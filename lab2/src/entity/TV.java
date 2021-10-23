package entity;

public class TV extends Appliance{
    private String resolution;
    public TV(String title,int price,String resolution) {
        super(ApplianceType.TV,title, price);
        this.resolution = resolution;
    }

    public String getRezolution() {
        return resolution;
    }

    public void setRezolution(String resolution) {
        this.resolution = resolution;
    }
}
