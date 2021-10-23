package entity;

public class TV extends Appliance{
    private String rezalution;
    public TV(String title,int price,String rezalution) {
        super(ApplianceType.TV,title, price);
        this.rezalution = rezalution;
    }

    public String getRezalution() {
        return rezalution;
    }

    public void setRezalution(String rezalution) {
        this.rezalution = rezalution;
    }
}
