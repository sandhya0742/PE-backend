package net.arshaa.rat.entity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

@Entity
public class Floors {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int floorId;
    @Column
    private String floorName;
    @Column
    private int buildingId;

    /*
     * @ManyToOne
     *
     * @JoinColumn(name = "building_id") private Building building;
     *
     * @OneToMany(mappedBy = "floor") private List<Room> room = new ArrayList<>();
     */


    public int getFloorId() {
        return floorId;
    }

    public int getBuildingId() {
        return buildingId;
    }

    public void setBuildingId(int buildingId) {
        this.buildingId = buildingId;
    }

    public void setFloorId(int floorId) {
        this.floorId = floorId;
    }

    public String getFloorName() {
        return floorName;
    }

    public void setFloorName(String floorName) {
        this.floorName = floorName;
    }

    public Floors(int floorId, String floorName) {
        super();
        this.floorId = floorId;
        this.floorName = floorName;

    }

    public Floors() {
        super();
        // TODO Auto-generated constructor stub
    }


}
