package entity;

public class Fridge extends Appliance {
    private int weight;
    public Fridge(String title,int price,int weight) {
        super(ApplianceType.Fridge, title, price);
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}
