package src.models;

public class House extends Facility{
    private String roomStandard;
    private String floor;

    public House(String serviceCode, String serviceName, double usableArea, double rentalCosts, int peopleMax, String rentalType, String roomStandard, String floor) {
        super(serviceCode, serviceName, usableArea, rentalCosts, peopleMax, rentalType);
        this.roomStandard = roomStandard;
        this.floor = floor;
    }

    public House(String roomStandard, String floor) {
        this.roomStandard = roomStandard;
        this.floor = floor;
    }

    public House(String serviceCode, String serviceName, double usableArea, double rentalCosts, int peopleMax, String rentalType) {
        super(serviceCode, serviceName, usableArea, rentalCosts, peopleMax, rentalType);
    }

    public String getRoomStandard() {
        return roomStandard;
    }

    public void setRoomStandard(String roomStandard) {
        this.roomStandard = roomStandard;
    }

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    @Override
    public String toString() {
        return "House{" + super.toString()+
                "roomStandard='" + roomStandard + '\'' +
                ", floor='" + floor + '\'' +
                '}';
    }
}
