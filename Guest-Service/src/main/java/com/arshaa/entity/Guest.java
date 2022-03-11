package com.arshaa.entity;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "Guest")
public class Guest implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String occupation;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date dateOfBirth;
    private String personalNumber;
    private String secondaryPhoneNumber;
    private String fatherName;
    private String fatherNumber;
    private String localGaurdianName;
    private String localGaurdianPhoneNumber;
    private String bloodGroup;
    //private String gender;
    private String addressLine1;
    private String addressLine2;
    // private String pincode;
    private String city;
    private String state;
    private String country;
    private String aadharNumber;
    private String workAddressLine1;
    private int floorNumber;
    private String roomNumber;
    private String bedId;
    private int amountPaid;
    private String roomType;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date checkInDate;
    @Temporal(TemporalType.DATE)
    private java.util.Date transactionDate = new java.util.Date(System.currentTimeMillis());
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date noticeDate;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date checkOutDate;
    private boolean termsOfService;

    public Guest(int id, String firstName, String lastName, String email, String occupation, Date dateOfBirth, String personalNumber, String secondaryPhoneNumber, String fatherName, String fatherNumber, String localGaurdianName, String localGaurdianPhoneNumber, String bloodGroup, String gender, String addressLine1, String addressLine2, String pincode, String city, String state, String country, String aadharNumber, String workAddressLine1, int floorNumber, String roomNumber, String bedId, int amountPaid, String roomType, Date checkInDate, Date transactionDate, Date noticeDate, Date checkOutDate, boolean termsOfService) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.occupation = occupation;
        this.dateOfBirth = dateOfBirth;
        this.personalNumber = personalNumber;
        this.secondaryPhoneNumber = secondaryPhoneNumber;
        this.fatherName = fatherName;
        this.fatherNumber = fatherNumber;
        this.localGaurdianName = localGaurdianName;
        this.localGaurdianPhoneNumber = localGaurdianPhoneNumber;
        this.bloodGroup = bloodGroup;
        //this.gender = gender;
        this.addressLine1 = addressLine1;
        this.addressLine2 = addressLine2;
        // this.pincode = pincode;
        this.city = city;
        this.state = state;
        this.country = country;
        this.aadharNumber = aadharNumber;
        this.workAddressLine1 = workAddressLine1;
        this.floorNumber = floorNumber;
        this.roomNumber = roomNumber;
        this.bedId = bedId;
        this.amountPaid = amountPaid;
        this.roomType = roomType;
        this.checkInDate = checkInDate;
        this.transactionDate = transactionDate;
        this.noticeDate = noticeDate;
        this.checkOutDate = checkOutDate;
        this.termsOfService = termsOfService;
    }

    public Guest() {
    }

    public int getId() {
        return id;
    }

    public void setId(int guestId) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getPersonalNumber() {
        return personalNumber;
    }

    public void setPersonalNumber(String personalNumber) {
        this.personalNumber = personalNumber;
    }

    public String getSecondaryPhoneNumber() {
        return secondaryPhoneNumber;
    }

    public void setSecondaryPhoneNumber(String secondaryPhoneNumber) {
        this.secondaryPhoneNumber = secondaryPhoneNumber;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public String getFatherNumber() {
        return fatherNumber;
    }

    public void setFatherNumber(String fatherNumber) {
        this.fatherNumber = fatherNumber;
    }

    public String getLocalGaurdianName() {
        return localGaurdianName;
    }

    public void setLocalGaurdianName(String localGaurdianName) {
        this.localGaurdianName = localGaurdianName;
    }

    public String getLocalGaurdianPhoneNumber() {
        return localGaurdianPhoneNumber;
    }

    public void setLocalGaurdianPhoneNumber(String localGaurdianPhoneNumber) {
        this.localGaurdianPhoneNumber = localGaurdianPhoneNumber;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

//    public String getGender() {
//        return gender;
//    }
//
//    public void setGender(String gender) {
//        this.gender = gender;
//    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

//    public String getPincode() {
//        return pincode;
//    }
//
//    public void setPincode(String pincode) {
//        this.pincode = pincode;
//    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getAadharNumber() {
        return aadharNumber;
    }

    public void setAadharNumber(String aadharNumber) {
        this.aadharNumber = aadharNumber;
    }

    public String getWorkAddressLine1() {
        return workAddressLine1;
    }

    public void setWorkAddressLine1(String workAddressLine1) {
        this.workAddressLine1 = workAddressLine1;
    }

    public int getFloorNumber() {
        return floorNumber;
    }

    public void setFloorNumber(int floorNumber) {
        this.floorNumber = floorNumber;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getBedId() {
        return bedId;
    }

    public void setBedId(String bedId) {
        this.bedId = bedId;
    }

    public int getAmountPaid() {
        return amountPaid;
    }

    public void setAmountPaid(int amountPaid) {
        this.amountPaid = amountPaid;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public Date getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(Date checkInDate) {
        this.checkInDate = checkInDate;
    }

    public java.util.Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    public Date getNoticeDate() {
        return noticeDate;
    }

    public void setNoticeDate(Date noticeDate) {
        this.noticeDate = noticeDate;
    }

    public Date getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(Date checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

    public boolean isTermsOfService() {
        return termsOfService;
    }

    public void setTermsOfService(boolean termsOfService) {
        this.termsOfService = termsOfService;
    }
}
