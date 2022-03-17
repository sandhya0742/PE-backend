package Models;
import java.util.List;
public class BuildingModel {
    private int building_id;
    private String building_name;
    private List<BedsInfo> beds;
    public BuildingModel(int building_id, String building_name, List<BedsInfo> beds) {
        super();
        this.building_id = building_id;
        this.building_name = building_name;
        this.beds = beds;
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

    public List<BedsInfo> getBeds() {
        return beds;
    }

    public void setBeds(List<BedsInfo> beds) {
        this.beds = beds;
    }

    public BuildingModel() {
// TODO Auto-generated constructor stub
    }

}