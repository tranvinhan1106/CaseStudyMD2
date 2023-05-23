package src.models;

public class Villa extends Facility {
    private String standardRoom;
    private double poolArea;
    private int floor;

    public Villa(String serviceCode, String serviceName, double usableArea, double rentalCosts, int peopleMax, String rentalType) {
        super(serviceCode, serviceName, usableArea, rentalCosts, peopleMax, rentalType);
    }

    public Villa(String standardRoom, double poolArea, int floor) {
        this.standardRoom = standardRoom;
        this.poolArea = poolArea;
        this.floor = floor;
    }

    public Villa(String serviceCode, String serviceName, double usableArea, double rentalCosts, int peopleMax, String rentalType, String standardRoom, double poolArea, int floor) {
        super(serviceCode, serviceName, usableArea, rentalCosts, peopleMax, rentalType);
        this.standardRoom = standardRoom;
        this.poolArea = poolArea;
        this.floor = floor;
    }

    public String getStandardRoom() {
        return standardRoom;
    }

    public void setStandardRoom(String standardRoom) {
        this.standardRoom = standardRoom;
    }

    public double getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(double poolArea) {
        this.poolArea = poolArea;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    @Override
    public String toString() {
        return "Villa{" + super.toString()+
                "standardRoom='" + standardRoom + '\'' +
                ", poolArea=" + poolArea +
                ", floor=" + floor +
                '}';
    }
}
