package entity;


public class Appliance {

    public enum ApplianceType {
        Computer,
        Fridge,
        TV,
        Kettle
    }

    private ApplianceType type;
    private String title;
    private int price;

    public Appliance(ApplianceType type, String title,int price) {
        this.type = type;
        this.title = title;
        this.price = price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public String getTitle() {
        return title;
    }

    public ApplianceType getType() {
        return type;
    }
}
