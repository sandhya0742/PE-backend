package net.arshaa.rat.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.beans.factory.annotation.Value;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;

@Entity
public class Bed {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column
    private String bedId;
    @Column
    private int roomId;
    @Column
    private int floorId;
    @Column
    private int buildingId;
    private String buildingName;
    @Column
    private boolean bedStatus;
    @Column
    private String guestId;
    @Column
    private String bedName;
    @Column
    private double defaultRent;
    @Column
    private boolean ac;
    @Column
    private double securityDeposit;
    
    
	public Bed() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBedId() {
		return bedId;
	}
	public void setBedId(String bedId) {
		this.bedId = bedId;
	}
	public int getRoomId() {
		return roomId;
	}
	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}
	public int getFloorId() {
		return floorId;
	}
	public void setFloorId(int floorId) {
		this.floorId = floorId;
	}
	public int getBuildingId() {
		return buildingId;
	}
	public void setBuildingId(int buildingId) {
		this.buildingId = buildingId;
	}
	public String getBuildingName() {
		return buildingName;
	}
	public void setBuildingName(String buildingName) {
		this.buildingName = buildingName;
	}
	public boolean isBedStatus() {
		return bedStatus;
	}
	public void setBedStatus(boolean bedStatus) {
		this.bedStatus = bedStatus;
	}
	public String getGuestId() {
		return guestId;
	}
	public void setGuestId(String guestId) {
		this.guestId = guestId;
	}
	public String getBedName() {
		return bedName;
	}
	public void setBedName(String bedName) {
		this.bedName = bedName;
	}
	public double getDefaultRent() {
		return defaultRent;
	}
	public void setDefaultRent(double defaultRent) {
		this.defaultRent = defaultRent;
	}
	public boolean isAc() {
		return ac;
	}
	public void setAc(boolean ac) {
		this.ac = ac;
	}
	public double getSecurityDeposit() {
		return securityDeposit;
	}
	public void setSecurityDeposit(double securityDeposit) {
		this.securityDeposit = securityDeposit;
	}
	public Bed(int id, String bedId, int roomId, int floorId, int buildingId, String buildingName, boolean bedStatus,
			String guestId, String bedName, double defaultRent, boolean ac, double securityDeposit) {
		super();
		this.id = id;
		this.bedId = bedId;
		this.roomId = roomId;
		this.floorId = floorId;
		this.buildingId = buildingId;
		this.buildingName = buildingName;
		this.bedStatus = bedStatus;
		this.guestId = guestId;
		this.bedName = bedName;
		this.defaultRent = defaultRent;
		this.ac = ac;
		this.securityDeposit = securityDeposit;
	}
	public Bed orElseThrow(Object object) {
		// TODO Auto-generated method stub
		return null;
	}

}