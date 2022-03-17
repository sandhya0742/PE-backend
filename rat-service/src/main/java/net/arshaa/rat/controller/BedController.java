package net.arshaa.rat.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import Models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import net.arshaa.rat.entity.Bed;
import net.arshaa.rat.entity.Building;
import net.arshaa.rat.entity.Floor;
import net.arshaa.rat.entity.Room;
import net.arshaa.rat.repository.BedRepository;
import net.arshaa.rat.repository.FloorRepository;
import net.arshaa.rat.repository.BuildingRepository;
import net.arshaa.rat.repository.RoomRepository;


@RestController
@RequestMapping("/bed-service")
@CrossOrigin("*")
public class BedController {

    @Autowired
    private BedRepository bedrepo;

    @Autowired
    private BuildingRepository buildingRepo;

    @Autowired
    private FloorRepository floorRepo;

    @Autowired
    private RoomRepository roomRepo;


    //to test API

    @RequestMapping(path = "/test")
    public ResponseEntity<String> test() {
        return new ResponseEntity<>("hello", HttpStatus.OK);
    }


    //GET ALL BUILDINGS

    @RequestMapping(path = "/getBedsByAllBuildings", method = RequestMethod.GET)
    public ResponseEntity<List<BuildingInfo>> getBedsByBuildings() {
        List<BuildingInfo> info = new ArrayList<>();
        List<Building> getBuildings = buildingRepo.findAll();
        if (!getBuildings.isEmpty()) {
            getBuildings.forEach(building -> {
                BuildingInfo newBuild = new BuildingInfo();
                Optional<Building> getBuilding = buildingRepo.findById(building.getBuilding_id());
                if (getBuilding.isPresent()) {
                    newBuild.setBuildingName(getBuilding.get().getBuilding_name());
                    List<FloorsInfo> floorsList = new ArrayList<>();
                    Optional<List<Floor>> getFloors = floorRepo.findByBuildingId(getBuilding.get().getBuilding_id());
                    if (getFloors.isPresent()) {
                        getFloors.get().forEach(floor -> {
                            FloorsInfo newFloor = new FloorsInfo();
                            newFloor.setFloorName(floor.getFloorName());
                            List<RoomsInfo> roomList = new ArrayList<>();
                            Optional<List<Room>> getRooms = roomRepo.findByFloorId(floor.getFloorId());
                            if (getRooms.isPresent()) {
                                getRooms.get().forEach(room -> {
                                    RoomsInfo newRoom = new RoomsInfo();
                                    newRoom.setRoomNumber(room.getRoomName());
                                    List<BedsInfo> bedsList = new ArrayList<>();
                                    Optional<List<Bed>> getBeds = bedrepo.findByroomId(room.getRoomId());
                                    if (getBeds.isPresent()) {
                                        getBeds.get().forEach(bed -> {
                                            BedsInfo newBed = new BedsInfo();
                                            newBed.setBedStatus(bed.isBedStatus());
                                            newBed.setBuildingId(bed.getBuildingId());
                                            newBed.setFloorId(bed.getFloorId());
                                            newBed.setDefaultRent(bed.getDefaultRent());
                                            newBed.setRoomId(bed.getRoomId());
                                            newBed.setAc(bed.isAc());
                                            newBed.setBedId(bed.getBedId());
                                            newBed.setBedName(bed.getBedName());
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
    }


    // Get beds by building Id

    @RequestMapping(path = "/getBedsByBuildingId/{id}", method = RequestMethod.GET)
    public ResponseEntity<BuildingInfo> getByBuildingId(@PathVariable Integer id) {

        BuildingInfo info = new BuildingInfo();
        Optional<Building> getBuilding = buildingRepo.findById(id);
        if (getBuilding.isPresent()) {
            info.setBuildingName(getBuilding.get().getBuilding_name());
            List<FloorsInfo> floorsList = new ArrayList<>();
            Optional<List<Floor>> getFloors = floorRepo.findByBuildingId(getBuilding.get().getBuilding_id());
            if (getFloors.isPresent()) {
                getFloors.get().forEach(floor -> {
                    FloorsInfo newFloor = new FloorsInfo();
                    newFloor.setFloorName(floor.getFloorName());
                    List<RoomsInfo> roomList = new ArrayList<>();
                    Optional<List<Room>> getRooms = roomRepo.findByFloorId(floor.getFloorId());
                    if (getRooms.isPresent()) {
                        getRooms.get().forEach(room -> {
                            RoomsInfo newRoom = new RoomsInfo();
                            newRoom.setRoomNumber(room.getRoomName());
                            List<BedsInfo> bedsList = new ArrayList<>();
                            Optional<List<Bed>> getBeds = bedrepo.findByroomId(room.getRoomId());
                            if (getBeds.isPresent()) {
                                getBeds.get().forEach(bed -> {
                                    BedsInfo newBed = new BedsInfo();
                                    newBed.setBedStatus(bed.isBedStatus());
                                    newBed.setBuildingId(bed.getBuildingId());
                                    newBed.setFloorId(bed.getFloorId());
                                    newBed.setDefaultRent(bed.getDefaultRent());
                                    newBed.setRoomId(bed.getRoomId());
                                    newBed.setAc(bed.isAc());
                                    newBed.setBedId(bed.getBedId());
                                    newBed.setBedName(bed.getBedName());

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

    //GET MAPPING API FOR AVAILABLE BEDS FOR ALL BUILDINGS
    @RequestMapping(path = "/getAvailableBedsByAllBuildings", method = RequestMethod.GET)
    public ResponseEntity<List<BuildingModel>> getAvailableBedsByBuildings() {
        List<BuildingModel> info = new ArrayList<>();
        List<Building> getBuildings = buildingRepo.findAll();
        if (!getBuildings.isEmpty()) {
            getBuildings.forEach(building -> {
                BuildingModel newBuild = new BuildingModel();
                Optional<Building> getBuilding = buildingRepo.findById(building.getBuilding_id());
                if (getBuilding.isPresent()) {
                    newBuild.setBuilding_id(getBuilding.get().getBuilding_id());
                    newBuild.setBuilding_name(getBuilding.get().getBuilding_name());
                    List<BedsInfo> bedsList = new ArrayList<>();
                    Optional<List<Bed>> getBeds = bedrepo.findBybuildingIdAndBedStatus(getBuilding.get().getBuilding_id(), true);
                    if (getBeds.isPresent()) {
                        getBeds.get().forEach(bed -> {
                            BedsInfo newBed = new BedsInfo();
                            newBed.setBedId(bed.getBedId());
                            newBed.setBedId(bed.getBedId());
                            newBed.setBedName(bed.getBedName());
                            newBed.setBedStatus(bed.isBedStatus());
                            newBed.setFloorId(bed.getFloorId());
                            newBed.setBuildingName(bed.getBuildingName());
                            newBed.setRoomId(bed.getRoomId());
                            newBed.setBuildingId(bed.getBuildingId());
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

    // GET MAPPING API FOR AVAILABLE BEDS BY BUILDING ID

    @RequestMapping(path = "/getAvailableBedsByBuildingId/{id}", method = RequestMethod.GET)
    public ResponseEntity<java.util.List<Bed>> buildingId(@PathVariable Integer id) {
        List<Bed> listbed = new ArrayList<>();
        Optional<Building> getBuilding = buildingRepo.findById(id);
        if (getBuilding.isPresent()) {
            List<FloorsInfo> floorsList = new ArrayList<>();
            Optional<List<Floor>> getFloors = floorRepo.findByBuildingId(getBuilding.get().getBuilding_id());
            if (getFloors.isPresent()) {
                getFloors.get().forEach(floor -> {
                    Optional<List<Room>> getRooms = roomRepo.findByFloorId(floor.getFloorId());
                    if (getRooms.isPresent()) {
                        getRooms.get().forEach(room -> {
                            Optional<List<Bed>> getBeds = bedrepo.findByroomIdAndBedStatus(room.getRoomId(), true);
                            if (getBeds.isPresent()) {
                                getBeds.get().forEach(bed -> {
                                    Bed newBed = new Bed();
                                    newBed.setBedId(bed.getBedId());
                                    newBed.setBedId(bed.getBedId());
                                    newBed.setBedName(bed.getBedName());
                                    newBed.setBedStatus(bed.isBedStatus());
                                    newBed.setFloorId(bed.getFloorId());
                                    newBed.setRoomId(bed.getRoomId());
                                    newBed.setBuildingName(getBuilding.get().getBuilding_name());
                                    newBed.setBuildingId(getBuilding.get().getBuilding_id());
                                    listbed.add(newBed);
                                });
                            }
                        });
                    }
                });
            }
        }
        return new ResponseEntity<List<Bed>>(listbed, HttpStatus.OK);
    }

    //GET MAPPING API FOR NOT AVAILABLE BEDS BY BUILDING ID

    @RequestMapping(path = "/getNotAvailableBedsByBuildingId/{id}", method = RequestMethod.GET)
    public ResponseEntity<java.util.List<Bed>> getNotAvailableBedsByBuildingId(@PathVariable Integer id) {
        List<Bed> listbed = new ArrayList<>();
        Optional<Building> getBuilding = buildingRepo.findById(id);
        if (getBuilding.isPresent()) {
            List<FloorsInfo> floorsList = new ArrayList<>();
            Optional<List<Floor>> getFloors = floorRepo.findByBuildingId(getBuilding.get().getBuilding_id());
            if (getFloors.isPresent()) {
                getFloors.get().forEach(floor -> {
                    Optional<List<Room>> getRooms = roomRepo.findByFloorId(floor.getFloorId());
                    if (getRooms.isPresent()) {
                        getRooms.get().forEach(room -> {
                            Optional<List<Bed>> getBeds = bedrepo.findByroomIdAndBedStatus(room.getRoomId(), false);
                            if (getBeds.isPresent()) {
                                getBeds.get().forEach(bed -> {
                                    Bed newBed = new Bed();
                                    newBed.setBedId(bed.getBedId());
                                    newBed.setBedId(bed.getBedId());
                                    newBed.setBedName(bed.getBedName());
                                    newBed.setBedStatus(bed.isBedStatus());
                                    newBed.setFloorId(bed.getFloorId());
                                    newBed.setRoomId(bed.getRoomId());
                                    listbed.add(newBed);
                                });
                            }
                        });
                    }
                });
            }
        }
        return new ResponseEntity<List<Bed>>(listbed, HttpStatus.OK);
    }


    @PutMapping("/updateBedStatusBydBedId")
    public ResponseEntity<String> updateBedStatusByBedNumber(@RequestBody Bed bed) {
        Bed getBed = bedrepo.findByBedId(bed.getBedId());
        //int getBedNum = getBed.getBedNum();
        getBed.setGuestId(bed.getGuestId());
        getBed.setBedStatus(!getBed.isBedStatus());
        bedrepo.save(getBed);
        return new ResponseEntity<String>("Updated Successfully", HttpStatus.OK);
    }
}


