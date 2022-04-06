package net.arshaa.rat.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import Models.BedsCount;
import Models.BedsInfo;
import Models.BuildingInfo;
import Models.BuildingModel;
import Models.FloorsInfo;
import Models.NewBuildModel;
import Models.RoomsInfo;
import net.arshaa.rat.entity.Beds;
import net.arshaa.rat.entity.Buildings;
import net.arshaa.rat.entity.Floors;
import net.arshaa.rat.entity.Rooms;
import net.arshaa.rat.repository.BedRepository;
import net.arshaa.rat.repository.BedSummaryRepo;
import net.arshaa.rat.repository.FloorRepository;
import net.arshaa.rat.repository.BuildingRepository;
import net.arshaa.rat.repository.RoomRepository;
import org.springframework.web.client.RestTemplate;

@CrossOrigin("*")
@RestController
@RequestMapping("/bed")
public class BedController {

	@Autowired
	private BedRepository bedrepo;

	@Autowired
	private BuildingRepository buildingRepo;

	@Autowired
	private FloorRepository floorRepo;

	@Autowired
	private RoomRepository roomRepo;

	@Autowired
	private BedSummaryRepo bedsumRepo;

	// @Autowired
//	private NewBedRepository newBedRepo;

	@Autowired
	@Lazy
	private RestTemplate template;

//Api for test

	@GetMapping(path = "/test")
	public ResponseEntity<String> test() {
		return new ResponseEntity<>("hello", HttpStatus.OK);
	}
// Post API to add Bed by id

	@PostMapping(path = "/addBed")
	public ResponseEntity<Beds> addBed(@RequestBody Beds newBed) {

		try {
			Beds bed = bedrepo.save(newBed);

			return new ResponseEntity("Bed Added Successfully", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity("Something went wrong", HttpStatus.OK);

		}
	}

// APi to update bed by id

	@PutMapping("/updateBedById/{id}")
	public ResponseEntity<Beds> updateBed(@PathVariable int id, @RequestBody Beds bedDetails) {
		try {
			Beds bed = bedrepo.getById(id);

			bed.setAc(bedDetails.isAc());
			bed.setBedId(bedDetails.getBedId());
			bed.setBedName(bedDetails.getBedName());
			bed.setBuildingId(bedDetails.getBuildingId());
			bed.setBedStatus(bedDetails.isBedStatus());
			bed.setBuildingName(bedDetails.getBuildingName());
			bed.setDefaultRent(bedDetails.getDefaultRent());
			bed.setFloorId(bedDetails.getFloorId());
			bed.setGuestId(bedDetails.getGuestId());
			bed.setRoomId(bedDetails.getRoomId());
			bed.setSecurityDeposit(bedDetails.getSecurityDeposit());
			Beds updatedBed = bedrepo.save(bed);
			return new ResponseEntity("Bed Updated Successfully", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity("Something went wrong can't able to update", HttpStatus.ALREADY_REPORTED);

		}
	}
// Api  to delete bed by id

	@DeleteMapping("/deleteBedByBedId/{id}")
	public ResponseEntity<String> deleteBed(@PathVariable int id) {

		try {
			bedrepo.deleteById(id);
			return new ResponseEntity<String>("Deleted Successfully", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>("Something went wrong", HttpStatus.OK);

		}

	}

// Api to get beddata		
	@GetMapping("/getAllBeds")
	public ResponseEntity<List<Beds>> getAllBeds() {
		try {
			List<Beds> bed = bedrepo.findAll();

			return new ResponseEntity<>(bed, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity("Something went wrong", HttpStatus.OK);

		}
	}

// Api to get the count of all beds
	@GetMapping("/getAllBedsCount")
	public ResponseEntity<Integer> getAllBedsCount() {
		List<Beds> bed = bedrepo.findAll();
		List<Beds> bedsCount=bedrepo.findByBedStatus(true);
		int bedCount = bed.size();
		int availableBedsCount=bedsCount.size();
		BedsCount bs=new BedsCount();
		bs.setTotalBeds(bedCount);
		bs.setTotalAvailbleBeds(availableBedsCount);
		return new ResponseEntity(bs, HttpStatus.OK);
	}
	
	@GetMapping("/getAvailableBeds")
	public ResponseEntity<List<Beds>>getAllAvailableBeds(){
		try {
			List<Beds> bedList=bedrepo.findByBedStatus(true);
			//Bed bed=new Bed();
			
			return new ResponseEntity<>( bedList,HttpStatus.OK);
		}
		catch(Exception e)
		{			
		return new ResponseEntity( "Something went wrong",HttpStatus.OK);
		}		
	}

// GET ALL BUILDINGS

	@GetMapping(path = "/getBedsByAllBuildings")
	public ResponseEntity<List<BuildingInfo>> getBedsByBuildings() {
		try {
			List<BuildingInfo> info = new ArrayList<>();
			List<Buildings> getBuildings = buildingRepo.findAll();
			if (!getBuildings.isEmpty()) {
				getBuildings.forEach(building -> {
					BuildingInfo newBuild = new BuildingInfo();
					Optional<Buildings> getBuilding = buildingRepo.findById(building.getBuilding_id());
					if (getBuilding.isPresent()) {
						newBuild.setBuildingName(getBuilding.get().getBuilding_name());
						List<FloorsInfo> floorsList = new ArrayList<>();
						Optional<List<Floors>> getFloors = floorRepo
								.findByBuildingId(getBuilding.get().getBuilding_id());
						if (getFloors.isPresent()) {
							getFloors.get().forEach(floor -> {
								FloorsInfo newFloor = new FloorsInfo();
								newFloor.setFloorName(floor.getFloorName());
								List<RoomsInfo> roomList = new ArrayList<>();
								Optional<List<Rooms>> getRooms = roomRepo.findByFloorId(floor.getFloorId());
								if (getRooms.isPresent()) {
									getRooms.get().forEach(room -> {
										RoomsInfo newRoom = new RoomsInfo();
										newRoom.setRoomNumber(room.getRoomName());
										List<BedsInfo> bedsList = new ArrayList<>();
										Optional<List<Beds>> getBeds = bedrepo.findByroomId(room.getRoomId());
										if (getBeds.isPresent()) {
											getBeds.get().forEach(bed -> {
												BedsInfo newBed = new BedsInfo();
												newBed.setBedStatus(bed.isBedStatus());
												newBed.setBuildingId(bed.getBuildingId());
												newBed.setBuildingName(bed.getBuildingName());
												newBed.setFloorId(bed.getFloorId());
												newBed.setDefaultRent(bed.getDefaultRent());
												newBed.setRoomId(bed.getRoomId());
												newBed.setAc(bed.isAc());
												newBed.setBedId(bed.getBedId());
												newBed.setBedName(bed.getBedName());
												newBed.setBedNum(bed.getId());
												newBed.setGuestId(bed.getGuestId());
												newBed.setDueAmount(bed.getDefaultRent());
												bedsList.add(newBed);
											});
										}
										newRoom.setBeds(bedsList);
										roomList.add(newRoom);
									});
								}
								newFloor.setRooms(roomList);
								floorsList.add(newFloor);
							});
						}
						newBuild.setFloors(floorsList);
					}
					info.add(newBuild);
				});
			}
			return new ResponseEntity<>(info, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity("Something went wrong", HttpStatus.OK);
		}
	}

// Get beds by building Id

	@GetMapping(path = "/getBedsByBuildingId/{id}")
	public ResponseEntity<BuildingInfo> getByBuildingId(@PathVariable Integer id) {

		BuildingInfo info = new BuildingInfo();
		Optional<Buildings> getBuilding = buildingRepo.findById(id);
		if (getBuilding.isPresent()) {
			info.setBuildingName(getBuilding.get().getBuilding_name());
			List<FloorsInfo> floorsList = new ArrayList<>();
			Optional<List<Floors>> getFloors = floorRepo.findByBuildingId(getBuilding.get().getBuilding_id());
			if (getFloors.isPresent()) {
				getFloors.get().forEach(floor -> {
					FloorsInfo newFloor = new FloorsInfo();
					newFloor.setFloorName(floor.getFloorName());
					List<RoomsInfo> roomList = new ArrayList<>();
					Optional<List<Rooms>> getRooms = roomRepo.findByFloorId(floor.getFloorId());
					if (getRooms.isPresent()) {
						getRooms.get().forEach(room -> {
							RoomsInfo newRoom = new RoomsInfo();
							newRoom.setRoomNumber(room.getRoomName());
							List<BedsInfo> bedsList = new ArrayList<>();
							Optional<List<Beds>> getBeds = bedrepo.findByroomId(room.getRoomId());
							if (getBeds.isPresent()) {
								getBeds.get().forEach(bed -> {
									BedsInfo newBed = new BedsInfo();
									newBed.setBuildingId(bed.getBuildingId());
									newBed.setBuildingName(bed.getBuildingName());
									newBed.setRoomId(bed.getRoomId());
									newBed.setFloorId(bed.getFloorId());
									newBed.setBedId(bed.getBedId());
									newBed.setBedName(bed.getBedName());
									newBed.setBedStatus(bed.isBedStatus());
									newBed.setDefaultRent(bed.getDefaultRent());
									newBed.setAc(bed.isAc());
									newBed.setGuestId(bed.getGuestId());
									newBed.setBedNum(bed.getId());
									bedsList.add(newBed);
								});
							}
							newRoom.setBeds(bedsList);
							roomList.add(newRoom);
						});
					}
					newFloor.setRooms(roomList);
					floorsList.add(newFloor);
				});
			}
			info.setFloors(floorsList);
		}
		return new ResponseEntity<>(info, HttpStatus.OK);
	}

	// GET MAPPING API FOR AVAILABLE BEDS BY BUILDING ID

	@GetMapping(path = "/getAvailableBedsByBuildingId/{id}")
	public ResponseEntity<java.util.List<Beds>> buildingId(@PathVariable Integer id) {
		List<Beds> listbed = new ArrayList<>();
		Optional<Buildings> getBuilding = buildingRepo.findById(id);
		if (getBuilding.isPresent()) {
			List<FloorsInfo> floorsList = new ArrayList<>();
			Optional<List<Floors>> getFloors = floorRepo.findByBuildingId(getBuilding.get().getBuilding_id());
			if (getFloors.isPresent()) {
				getFloors.get().forEach(floor -> {
					Optional<List<Rooms>> getRooms = roomRepo.findByFloorId(floor.getFloorId());
					if (getRooms.isPresent()) {
						getRooms.get().forEach(room -> {
							Optional<List<Beds>> getBeds = bedrepo.findByroomIdAndBedStatus(room.getRoomId(), true);
							if (getBeds.isPresent()) {
								getBeds.get().forEach(bed -> {
									Beds newBed = new Beds();
									listbed.add(newBed);
								});
							}
						});
					}
				});
			}
		}
		return new ResponseEntity<List<Beds>>(listbed, HttpStatus.OK);
	}

// GET MAPPING API FOR NOT AVAILABLE BEDS BY BUILDING ID

	@GetMapping(path = "/getNotAvailableBedsByBuildingId/{id}")
	public ResponseEntity<java.util.List<Beds>> getNotAvailableBedsByBuildingId(@PathVariable Integer id) {
		List<Beds> listbed = new ArrayList<>();
		Optional<Buildings> getBuilding = buildingRepo.findById(id);
		if (getBuilding.isPresent()) {
			List<FloorsInfo> floorsList = new ArrayList<>();
			Optional<List<Floors>> getFloors = floorRepo.findByBuildingId(getBuilding.get().getBuilding_id());
			if (getFloors.isPresent()) {
				getFloors.get().forEach(floor -> {
					Optional<List<Rooms>> getRooms = roomRepo.findByFloorId(floor.getFloorId());
					if (getRooms.isPresent()) {
						getRooms.get().forEach(room -> {
							Optional<List<Beds>> getBeds = bedrepo.findByroomIdAndBedStatus(room.getRoomId(), false);
							if (getBeds.isPresent()) {
								getBeds.get().forEach(bed -> {
									Beds newBed = new Beds();
									newBed.setBedId(bed.getBedId());
									newBed.setBedId(bed.getBedId());
									newBed.setBedName(bed.getBedName());
									newBed.setBedStatus(bed.isBedStatus());
									newBed.setFloorId(bed.getFloorId());
									newBed.setRoomId(bed.getRoomId());
									newBed.setId(bed.getId());
									newBed.setDefaultRent(bed.getDefaultRent());
									newBed.setBuildingId(bed.getBuildingId());
									newBed.setBuildingName(bed.getBuildingName());
									listbed.add(newBed);
								});
							}
						});
					}
				});
			}
		}
		return new ResponseEntity<List<Beds>>(listbed, HttpStatus.OK);
	}

//    getApi for all buldings available beds

	@GetMapping(path = "/getAvailableBedsByBuildings")
	public ResponseEntity<List<BuildingModel>> getAvailableBedsByBuildings() {
		List<BuildingModel> info = new ArrayList<>();
		List<Buildings> getBuildings = buildingRepo.findAll();
		if (!getBuildings.isEmpty()) {
			getBuildings.forEach(building -> {
				BuildingModel newBuild = new BuildingModel();
				Optional<Buildings> getBuilding = buildingRepo.findById(building.getBuilding_id());
				if (getBuilding.isPresent()) {
					newBuild.setBuildingId(getBuilding.get().getBuilding_id());
					newBuild.setBuildingName(getBuilding.get().getBuilding_name());
					List<BedsInfo> bedsList = new ArrayList<>();
					Optional<List<Beds>> getBeds = bedrepo
							.findBybuildingIdAndBedStatus(getBuilding.get().getBuilding_id(), true);
					if (getBeds.isPresent()) {
						getBeds.get().forEach(bed -> {
							BedsInfo newBed = new BedsInfo();
							newBed.setBedId(bed.getBedId());
							newBed.setBedName(bed.getBedName());
							newBed.setBedStatus(bed.isBedStatus());
							newBed.setFloorId(bed.getFloorId());
							newBed.setRoomId(bed.getRoomId());
							newBed.setBedNum(bed.getId());
							newBed.setBuildingId(bed.getBuildingId());
							newBed.setBuildingName(bed.getBuildingName());
							newBed.setGuestId(bed.getGuestId());
							newBed.setAc(bed.isAc());
							newBed.setDefaultRent(bed.getDefaultRent());
							newBed.setDueAmount(bed.getSecurityDeposit());
							bedsList.add(newBed);

						});
					}
					newBuild.setBeds(bedsList);
					info.add(newBuild);
				}
			});
		}
		return new ResponseEntity<>(info, HttpStatus.OK);
	}

//UPDATE API FOR BED STATUS AND GUEST ID BY BEDID

	@PutMapping("/updateBedStatusBydBedId")
	public void updateBedStatusByBedId(@RequestBody Beds bed) {
		Beds getBed = bedrepo.findByBedId(bed.getBedId());
		getBed.setGuestId(bed.getGuestId());
		getBed.setBedId(bed.getBedId());
		getBed.setBedStatus(!getBed.isBedStatus());
		bedrepo.save(getBed);
	}

//GET API FOR GETTING THE COUNT OF TOTAL BEDS AND OCCUPIED BEDS FOR RAT PIE CHART FOR ALL BUILDINGS

	@GetMapping(path = "/getBedSummaryForPieChartByAllBuildings")
	public ResponseEntity<List<NewBuildModel>> getAvailableBedsByBuilding() {
		List<NewBuildModel> info = new ArrayList<NewBuildModel>();
		List<Buildings> getBuildings = buildingRepo.findAll();
		if (!getBuildings.isEmpty()) {
			getBuildings.forEach(building -> {
				NewBuildModel newBuild = new NewBuildModel();
				Optional<Buildings> getBuilding = buildingRepo.findById(building.getBuilding_id());
				if (getBuilding.isPresent()) {
					newBuild.setBuildingId(getBuilding.get().getBuilding_id());
					newBuild.setBuildingName(getBuilding.get().getBuilding_name());
					List<Beds> bedsList = bedrepo.findAllByBuildingId(building.getBuilding_id());
					List<Beds> listbeds = bedsumRepo.findByBuildingIdAndBedStatus(building.getBuilding_id(), false);
					List<Beds> listOfAvailablebeds = bedsumRepo.findByBuildingIdAndBedStatus(building.getBuilding_id(),
							true);
					int bedsCount = bedsList.size();
					int occupiedBedsCount = listbeds.size();
					int totalAvailableBeds = listOfAvailablebeds.size();
					newBuild.setTotalBeds(bedsCount);
					newBuild.setOccupiedBeds(occupiedBedsCount);
					newBuild.setAvailableBeds(totalAvailableBeds);
					info.add(newBuild);
				}
			});
		}
		return new ResponseEntity<>(info, HttpStatus.OK);
	}

//GET API FOR GETTING THE COUNT OF TOTAL BEDS AND OCCUPIED BEDS FOR RAT PIE CHART BY BUILDING ID

	@GetMapping(path = "/getBedSummaryForPieChartByBuildingId/{buildingId}")
	public ResponseEntity<List<NewBuildModel>> getAvailableBedsByBuildingId(@PathVariable int buildingId) {
		List<NewBuildModel> info = new ArrayList<>();
		NewBuildModel newBuild = new NewBuildModel();
		Optional<Buildings> getBuilding = buildingRepo.findById(buildingId);
		if (getBuilding.isPresent()) {
			newBuild.setBuildingId(getBuilding.get().getBuilding_id());
			newBuild.setBuildingName(getBuilding.get().getBuilding_name());
			List<Beds> bedsList = bedrepo.findAllByBuildingId(buildingId);
			List<Beds> listbeds = bedsumRepo.findByBuildingIdAndBedStatus(buildingId, false);
			List<Beds> listOfAvailablebeds = bedsumRepo.findByBuildingIdAndBedStatus(buildingId, true);
			int bedsCount = bedsList.size();
			int occupiedBedsCount = listbeds.size();
			int totalAvailableBeds = listOfAvailablebeds.size();
			newBuild.setTotalBeds(bedsCount);
			newBuild.setOccupiedBeds(occupiedBedsCount);
			newBuild.setAvailableBeds(totalAvailableBeds);
			info.add(newBuild);
		}
		return new ResponseEntity<>(info, HttpStatus.OK);
	}

	@GetMapping("/getBedByBedId/{bedId}")
	public Beds getBedByBuildingId(@PathVariable String bedId) {
		Beds getBed = bedrepo.findByBedId(bedId);
		return getBed;
	}

}
