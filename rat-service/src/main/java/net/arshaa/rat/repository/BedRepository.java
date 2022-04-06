package net.arshaa.rat.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import net.arshaa.rat.entity.Beds;

public interface BedRepository extends JpaRepository<Beds, Integer>{

    Optional<List<Beds>> findByroomId(Integer id);
    //List<Bed> findBybuildingId(Integer id);
    List<Beds> findByBedStatus(Boolean status);
    //List<Bed> findByBedStatusandId(int id, Boolean status);
    Optional<List<Beds>> findByroomIdAndBedStatus(int roomId, boolean b);
    Optional<List<Beds>> findBybuildingIdAndBedStatus(int building_id, boolean b);
    //List<Bed> findByBedStatusAndbuildingId(boolean b, int building_id);
    Beds findByBedId(String bedId);
    Beds getBedByBuildingId(int buildingId);

    List<Beds> findAllByBuildingId(int buildingId);


}
