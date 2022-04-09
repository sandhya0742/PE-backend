package net.arshaa.rat.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Rooms {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int roomId;
    @Column
    private String roomName;
    @Column
    private int floorId;

    public int getFloorId() {
        return floorId;
    }

    public void setFloorId(int floorId) {
        this.floorId = floorId;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }


    public Rooms(int roomId, String roomName, Bed[] bed) {
        super();
        this.roomId = roomId;
        this.roomName = roomName;
    }

    public Rooms() {
        super();
        // TODO Auto-generated constructor stub
    }


}

