package com.payment.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import java.sql.Date;

@Entity
@Table(name = "payment")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int paymentId;
    private String paymentMethod;
    private double dueAmount;
    private double amountPaid;
    private String transactionId;
    //    @JsonFormat(pattern = "yyyy-MM-dd")
//    LocalDate checkInDate;
    private Date transactionDate;
    private Date checkinDate;
    private Date checkOutDate;
    private int remainder;
    private double newDuesAmount;
    private boolean onBoard;
    private String paymentPurpose;
    // private double dueDuringOnBoard ;
    // private String occupancyType[] = { "Daily" , "Monthly" , "Regular" };
    private String occupancyType;

    // Fields taking reference from guest-Master Data .
    //    private double securityDeposit = 5000;
    private String guestId; // (f k) from guestId
//    double defaultRent;

    //Getters and setters .

    public int getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(int paymentId) {
        this.paymentId = paymentId;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public double getDueAmount() {
        return dueAmount;
    }

    public void setDueAmount(double dueAmount) {
        this.dueAmount = dueAmount;
    }

    public double getAmountPaid() {
        return amountPaid;
    }

    public void setAmountPaid(double amountPaid) {
        this.amountPaid = amountPaid;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    public Date getCheckinDate() {
        return checkinDate;
    }

    public void setCheckinDate(Date checkinDate) {
        this.checkinDate = checkinDate;
    }

    public Date getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(Date checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

    public int getRemainder() {
        return remainder;
    }

    public void setRemainder(int remainder) {
        this.remainder = remainder;
    }

    public double getNewDuesAmount() {
        return newDuesAmount;
    }

    public void setNewDuesAmount(double newDuesAmount) {
        this.newDuesAmount = newDuesAmount;
    }

    public boolean isOnBoard() {
        return onBoard;
    }

    public void setOnBoard(boolean onBoard) {
        this.onBoard = onBoard;
    }

    public String getPaymentPurpose() {
        return paymentPurpose;
    }

    public void setPaymentPurpose(String paymentPurpose) {
        this.paymentPurpose = paymentPurpose;
    }

    public String getOccupancyType() {
        return occupancyType;
    }

    public void setOccupancyType(String occupancyType) {
        this.occupancyType = occupancyType;
    }

    public String getGuestId() {
        return guestId;
    }

    public void setGuestId(String guestId) {
        this.guestId = guestId;
    }

    public Payment(int paymentId, String paymentMethod, double dueAmount, double amountPaid, String transactionId, Date transactionDate, Date checkinDate, Date checkOutDate, int remainder, double newDuesAmount, boolean onBoard, String paymentPurpose, String occupancyType, String guestId) {
        this.paymentId = paymentId;
        this.paymentMethod = paymentMethod;
        this.dueAmount = dueAmount;
        this.amountPaid = amountPaid;
        this.transactionId = transactionId;
        this.transactionDate = transactionDate;
        this.checkinDate = checkinDate;
        this.checkOutDate = checkOutDate;
        this.remainder = remainder;
        this.newDuesAmount = newDuesAmount;
        this.onBoard = onBoard;
        this.paymentPurpose = paymentPurpose;
        this.occupancyType = occupancyType;
        //this.bedId = bedId;
        this.guestId = guestId;
    }

    public Payment() {
    }

    @Override
    public String toString() {
        return "Payment{" +
                "paymentId=" + paymentId +
                ", paymentMethod='" + paymentMethod + '\'' +
                ", dueAmount=" + dueAmount +
                ", amountPaid=" + amountPaid +
                ", transactionId='" + transactionId + '\'' +
                ", transactionDate=" + transactionDate +
                ", checkinDate=" + checkinDate +
                ", checkOutDate=" + checkOutDate +
                ", remainder=" + remainder +
                ", newDuesAmount=" + newDuesAmount +
                ", onBoard=" + onBoard +
                ", paymentPurpose='" + paymentPurpose + '\'' +
                ", occupancyType='" + occupancyType + '\'' +
                ", guestId='" + guestId + '\'' +
                '}';
    }

    /*
     * public double getDueAmount() { LocalDate checkInDate = LocalDate.now() ; int
     * remainder = checkInDate.getDayOfMonth();
     *
     * double count=securityDeposit+defaultRent; dueAmount = count;
     *
     *
     * if(remainder <30 && remainder > 1) {
     *
     * dueAmount = (defaultRent/30)*remainder ; } if (onBoard == true ) {
     *
     * newDuesAmount = dueAmount - amountPaid ; }
     *
     */

    /*
     * public double getAmountPaid() { if(occupancyType.toString().equals("Daily"))
     * {
     *
     * amountPaid = (defaultRent/30)* remainder ;
     *
     *
     * }else if (occupancyType.toString().equals("Monthly")) {
     *
     * amountPaid = defaultRent ;
     *
     * }else if (occupancyType.toString().equals("Regular")){
     *
     * amountPaid = defaultRent ; System.out.println("Exception"); } return
     * amountPaid; }
     */

    /*
     * public double getDefaultRent() { if(occupancyType.toString().equals("Daily"))
     * { defaultRent = defaultRent/30;
     *
     *
     * }else if (occupancyType.toString().equals("Monthly")) { defaultRent =
     * amountPaid;
     *
     * }else if (occupancyType.toString().equals("Regular")){ defaultRent =
     * amountPaid; } return defaultRent ; }
     */
}
