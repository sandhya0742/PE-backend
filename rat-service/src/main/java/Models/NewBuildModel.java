package Models;

import java.util.List;

public class NewBuildModel {


    private int building_id;
    private String building_name;
    // private List<BedsInfo> beds;
    private List<BedSummary> bedSummary;


    public NewBuildModel() {
// TODO Auto-generated constructor stub
    }


    public NewBuildModel(int building_id, String building_name, List<BedSummary> bedSummary) {
        super();
        this.building_id = building_id;
        this.building_name = building_name;
        this.bedSummary = bedSummary;
    }


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


    public List<BedSummary> getBedSummary() {
        return bedSummary;
    }


    public void setBedSummary(List<BedSummary> bedSummary) {
        this.bedSummary = bedSummary;
    }


}
