package Models;

public class BedSummary {


    private int totalBeds;
    private int occupiedBeds;
    private int availableBeds;


    public int getTotalBeds() {
        return totalBeds;
    }


    public void setTotalBeds(int totalBeds) {
        this.totalBeds = totalBeds;
    }


    public int getOccupiedBeds() {
        return occupiedBeds;
    }


    public void setOccupiedBeds(int occupiedBeds) {
        this.occupiedBeds = occupiedBeds;
    }


    public int getAvailableBeds() {
        return availableBeds;
    }


    public void setAvailableBeds(int availableBeds) {
        this.availableBeds = availableBeds;
    }


    public BedSummary(int totalBeds, int occupiedBeds, int availableBeds) {
        super();
        this.totalBeds = totalBeds;
        this.occupiedBeds = occupiedBeds;
        this.availableBeds = availableBeds;
    }


    public BedSummary() {
        super();
    }


}