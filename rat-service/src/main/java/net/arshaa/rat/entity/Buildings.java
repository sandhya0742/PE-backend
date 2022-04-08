package net.arshaa.rat.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

@Entity
public class Buildings {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int building_id;
	@Column
	private String building_name;
	@Column
	private String manager_name;
	@Column
	private long phone_number;

	@Column
	private String created_by;
	@Column
	private Date created_on;
	public int getBuilding_id() {
		return building_id;
	}
	public void setBuilding_id(int building_id) {
		this.building_id = building_id;
	}
	public String getBuilding_name() {
		return building_name;
	}
	public void setBuilding_name(String building_name) {
		this.building_name = building_name;
	}
	public String getManager_name() {
		return manager_name;
	}
	public void setManager_name(String manager_name) {
		this.manager_name = manager_name;
	}
	public long getPhone_number() {
		return phone_number;
	}
	public void setPhone_number(long phone_number) {
		this.phone_number = phone_number;
	}
	public String getCreated_by() {
		return created_by;
	}
	public void setCreated_by(String created_by) {
		this.created_by = created_by;
	}
	public Date getCreated_on() {
		return created_on;
	}
	public void setCreated_on(Date created_on) {
		this.created_on = created_on;
	}
	public Buildings(int building_id, String building_name, String manager_name, long phone_number, String created_by,
					 Date created_on) {
		super();
		this.building_id = building_id;
		this.building_name = building_name;
		this.manager_name = manager_name;
		this.phone_number = phone_number;
		this.created_by = created_by;
		this.created_on = created_on;
	}
	public Buildings() {
		super();
		// TODO Auto-generated constructor stub
	}


}
