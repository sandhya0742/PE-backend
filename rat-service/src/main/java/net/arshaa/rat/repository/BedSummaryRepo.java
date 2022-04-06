package net.arshaa.rat.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;


import net.arshaa.rat.entity.Beds;


public interface BedSummaryRepo extends JpaRepository<Beds, Integer> {

    List<Beds> findByBuildingIdAndBedStatus(int building_id, boolean b);


}