package xyz.rjs.brandwatch.supermarkets.model.events;

public class Customer {
    private String name;
    private int stuffNeeded;
    private int stuffReceived;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStuffNeeded() {
        return stuffNeeded;
    }

    public void setStuffNeeded(int stuffNeeded) {
        this.stuffNeeded = stuffNeeded;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", stuffNeeded=" + stuffNeeded +
                ", stuffReceived=" + stuffReceived +
                '}';
    }

    public int getStuffReceived() {
        return stuffReceived;
    }

    public void setStuffReceived(int stuffReceived) {
        this.stuffReceived = stuffReceived;
    }

}
