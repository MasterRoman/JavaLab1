package entity;

public class Computer extends Appliance {
    private String cpu;
    public Computer(String title,int price,String cpu) {
        super(ApplianceType.Computer, title, price);
        this.cpu = cpu;
    }

    public String getCpu() {
        return cpu;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }
}
