package entity;

public class Kettle extends Appliance {
    private String mark;
    public Kettle(String title,int price, String mark) {
        super(ApplianceType.Kettle, title, price);
        this.mark = mark;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }
}
