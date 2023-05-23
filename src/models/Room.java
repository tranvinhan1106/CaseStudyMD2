package src.models;

public class Room extends Facility {
    private String freeService;

    public Room(String serviceCode, String serviceName, double usableArea, double rentalCosts, int peopleMax, String rentalType) {
        super(serviceCode, serviceName, usableArea, rentalCosts, peopleMax, rentalType);
    }

    public Room(String serviceCode, String serviceName, double usableArea, double rentalCosts, int peopleMax, String rentalType, String freeService) {
        super(serviceCode, serviceName, usableArea, rentalCosts, peopleMax, rentalType);
        this.freeService = freeService;
    }

    public Room(String freeService) {
        this.freeService = freeService;
    }

    public String getFreeService() {
        return freeService;
    }

    public void setFreeService(String freeService) {
        this.freeService = freeService;
    }

    @Override
    public String toString() {
        return "Room{" +super.toString()+
                "freeService='" + freeService + '\'' +
                '}';
    }
}
