package com.arshaa.entity;

import java.sql.Date;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "Guest")
public class Guest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int guestId;
    private long amount;
    private String firstName;
    private String lastName;
    private String email;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date dateOfBirth;
    private String phone;
    private String secondaryPhone;
    private String fatherName;
    private String fatherPhone;
    private String localGaurdianName;
    private String localGaurdianPhone;
    private String bloodGroup;
    private boolean termsOfService;


    public Guest(int id, long amount, String firstName, String lastName, String email, Date dateOfBirth, String phone, String secondaryPhone, String fatherName, String fatherPhone, String localGaurdianName, String localGaurdianPhone, String bloodGroup, boolean termsOfService) {
        this.guestId = id;
        this.amount = amount;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
        this.phone = phone;
        this.secondaryPhone = secondaryPhone;
        this.fatherName = fatherName;
        this.fatherPhone = fatherPhone;
        this.localGaurdianName = localGaurdianName;
        this.localGaurdianPhone = localGaurdianPhone;
        this.bloodGroup = bloodGroup;
        this.termsOfService = termsOfService;
    }

    public Guest() {
    }

    public int getId() {
        return guestId;
    }

    public long getAmount() {
		return amount;
	}

	public void setAmount(long amount) {
		this.amount = amount;
	}

	public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public String getPhone() {
        return phone;
    }

    public String getSecondaryPhone() {
        return secondaryPhone;
    }

    public String getFatherName() {
        return fatherName;
    }

    public String getFatherPhone() {
        return fatherPhone;
    }

    public String getLocalGaurdianName() {
        return localGaurdianName;
    }

    public String getLocalGaurdianPhone() {
        return localGaurdianPhone;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public boolean isTermsOfService() {
        return termsOfService;
    }

    public void setId(int id) {
        this.guestId = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setSecondaryPhone(String secondaryPhone) {
        this.secondaryPhone = secondaryPhone;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public void setFatherPhone(String fatherPhone) {
        this.fatherPhone = fatherPhone;
    }

    public void setLocalGaurdianName(String localGaurdianName) {
        this.localGaurdianName = localGaurdianName;
    }

    public void setLocalGaurdianPhone(String localGaurdianPhone) {
        this.localGaurdianPhone = localGaurdianPhone;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public void setTermsOfService(boolean termsOfService) {
        this.termsOfService = termsOfService;
    }
}
