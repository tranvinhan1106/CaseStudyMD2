package src.services.Impl;

import src.models.Facility;
import src.models.House;
import src.models.Room;
import src.models.Villa;
import src.regex.MyRegex;
import src.repository.Impl.FacilityRepository;
import src.services.IFacilityService;
import src.utils.Myutils;

import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

public class FacilityService implements IFacilityService {
    FacilityRepository facilityRepository = new FacilityRepository();

    @Override
    public Map<Facility, Integer> displayFacility() {
        Map<Facility, Integer> displayFacility = facilityRepository.displayFacility();
        for (Facility facility : displayFacility.keySet()) {
            System.out.println(facility + " - " + displayFacility.get(facility));
        }
        return displayFacility;
    }

    @Override
    public void addFacility() {
        Scanner scanner = new Scanner(System.in);
        boolean check = true;
        int choice;
        try {
            do {

                System.out.println("=====Add New Facility=====" + "\n" +
                        "1. Add New Villa " + "\n" +
                        "2. Add New House " + "\n" +
                        "3. Add New Room " + "\n" +
                        "4. Back To Menu " + "\n" +
                        "Vui lòng chọn chức năng từ 1->4 !");
                choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        String serviceCode;
                        do {
                            System.out.println("Enter serviceCode (SVVL-YYYY) :");
                            serviceCode = scanner.next();
                            if (!serviceCode.matches(MyRegex.REGEX_SERVICE_VL)) {
                                System.err.println("Vui lòng nhập đúng định dạng (SVVL-YYYY) !");
                            }
                        } while (!serviceCode.matches(MyRegex.REGEX_SERVICE_VL));
                        String serviceName;
                        do {
                            System.out.println("Enter serviceName :");
                            serviceName = scanner.next();
                            if (!serviceName.matches(MyRegex.REGEX_NAME_SERVICE_VL)) {
                                System.err.println("Vui lòng nhập đúng định dạng (Villa) !");
                            }
                        } while (!serviceName.matches(MyRegex.REGEX_NAME_SERVICE_VL));
                        double usableArea = 0;
                        do {
                            try {
                                System.out.println("Enter usableArea:");
                                usableArea = scanner.nextDouble();
                                if (usableArea < 30) {
                                    System.err.println("Vui lòng nhập số > 30 ");
                                }
                            } catch (InputMismatchException e) {
                                System.err.println("Vui lòng nhập số !");
                            }
                        } while (usableArea < 30);
                        long rentalCost;
                        do {
                            System.out.println("Enter rentalCost :");
                            rentalCost = scanner.nextLong();
                            if (rentalCost <= 0) {
                                System.err.println("Vui lòng nhập số lớn hơn 0 !");
                            }
                        } while (rentalCost <= 0);
                        int maxPeople;
                        do {
                            System.out.print("Enter maxPeople:");
                            maxPeople = scanner.nextInt();
                            if (maxPeople < 0 && maxPeople > 20) {
                                System.err.println("Vui lòng nhập số > 0 và < 20");
                            }
                        } while (maxPeople < 0 && maxPeople > 20);
                        String rentalType;
                        do {
                            System.out.print("Enter rentalType:");
                            rentalType = scanner.next();
                            if (!rentalType.matches(MyRegex.REGEX_RENTAL_TYPE)) {
                                System.err.println("Vui lòng nhập đúng định dạng (Ngay , Thang , Nam or Gio )!");
                            }
                        } while (!rentalType.matches(MyRegex.REGEX_RENTAL_TYPE));
                        String roomStandards = Myutils.roomStandards();
                        double poolArea;
                        do {
                            poolArea = 1;
                            try {
                                System.out.println("Enter usableArea:");
                                poolArea = scanner.nextDouble();
                                if (poolArea < 30) {
                                    System.err.println("Vui lòng nhập số > 30 ");
                                }
                            } catch (InputMismatchException inputMismatchException) {
                                System.err.println("Vui lòng nhập số !");
                            }
                        } while (poolArea < 30);
                        int numberFloors;
                        do {
                            System.out.print("Enter numberFloors:");
                            numberFloors = scanner.nextInt();
                            if (numberFloors < 0) {
                                System.err.println("Vui lòng nhập số lớn hơn 0 !");
                            }
                        } while (numberFloors < 0);
                        Villa villa = new Villa(serviceCode, serviceName, usableArea, rentalCost, maxPeople, rentalType, roomStandards, poolArea, numberFloors);
                        facilityRepository.addFacility(villa);
                        break;
                    case 2:
                        do {
                            System.out.println("Enter serviceCode (SVHO-YYYY) :");
                            serviceCode = scanner.next();
                            if (!serviceCode.matches(MyRegex.REGEX_SERVICE_HO)) {
                                System.err.println("Vui lòng nhập đúng định dạng (SVHO-YYYY) !");
                            }
                        } while (!serviceCode.matches(MyRegex.REGEX_SERVICE_HO));
                        do {
                            System.out.println("Enter serviceName :");
                            serviceName = scanner.next();
                            if (!serviceName.matches(MyRegex.REGEX_NAME_SERVICE_HO)) {
                                System.err.println("Vui lòng nhập đúng định dạng (House) !");
                            }
                        } while (!serviceName.matches(MyRegex.REGEX_NAME_SERVICE_HO));
                        usableArea = 0;
                        do {
                            try {
                                System.out.println("Enter usableArea:");
                                usableArea = scanner.nextDouble();
                                if (usableArea < 30) {
                                    System.err.println("Vui lòng nhập số > 30 ");
                                }
                            } catch (InputMismatchException inputMismatchException) {
                                System.err.println("Vui lòng nhập số !");
                            }
                        } while (usableArea < 30);
                        do {
                            System.out.print("Enter rentalCost:");
                            rentalCost = scanner.nextLong();
                            if (rentalCost < 0) {
                                System.err.println("Vui lòng nhập số > 0 !");
                            }
                        } while (rentalCost < 0);
                        do {
                            System.out.print("Enter maxPeople:");
                            maxPeople = scanner.nextInt();
                            if (maxPeople < 0 && maxPeople > 20) {
                                System.err.println("Vui lòng nhập số > 0 và < 20");
                            }
                        } while (maxPeople < 0 && maxPeople > 20);
                        do {
                            System.out.print("Enter rentalType:");
                            rentalType = scanner.next();
                            if (!rentalType.matches(MyRegex.REGEX_RENTAL_TYPE)) {
                                System.err.println("Vui lòng nhập đúng định dạng (Ngay , Thang , Nam or Gio )!");
                            }
                        } while (!rentalType.matches(MyRegex.REGEX_RENTAL_TYPE));
                        roomStandards = Myutils.roomStandards();
                        do {
                            System.out.print("Enter numberFloors:");
                            numberFloors = scanner.nextInt();
                            if (numberFloors < 0) {
                                System.err.println("Vui lòng nhập số lớn hơn 0 !");
                            }
                        } while (numberFloors < 0);
                        House house = new House(serviceCode, serviceName, usableArea, rentalCost, maxPeople, rentalType, roomStandards, numberFloors);
                        facilityRepository.addFacility(house);
                        break;
                    case 3:
                        do {
                            System.out.println("Enter serviceCode (SVRO-YYYY) :");
                            serviceCode = scanner.next();
                            if (!serviceCode.matches(MyRegex.REGEX_SERVICE_RO)) {
                                System.err.println("Vui lòng nhập đúng định dạng (SVRO-YYYY) !");
                            }
                        } while (!serviceCode.matches(MyRegex.REGEX_SERVICE_RO));
                        do {
                            System.out.println("Enter serviceName :");
                            serviceName = scanner.next();
                            if (!serviceName.matches(MyRegex.REGEX_NAME_SERVICE_RO)) {
                                System.err.println("Vui lòng nhập đúng định dạng (Room) !");
                            }
                        } while (!serviceName.matches(MyRegex.REGEX_NAME_SERVICE_RO));
                        usableArea = 0;
                        do {
                            try {
                                System.out.println("Enter usableArea:");
                                usableArea = scanner.nextDouble();
                                if (usableArea < 30) {
                                    System.err.println("Vui lòng nhập số > 30 ");
                                }
                            } catch (InputMismatchException inputMismatchException) {
                                System.err.println("Vui lòng nhập số !");
                            }
                        } while (usableArea < 30);
                        do {
                            System.out.print("Enter rentalCost:");
                            rentalCost = scanner.nextLong();
                            if (rentalCost < 0) {
                                System.err.println("Vui lòng nhập số > 0 !");
                            }
                        } while (rentalCost < 0);
                        do {
                            System.out.print("Enter maxPeople:");
                            maxPeople = scanner.nextInt();
                            if (maxPeople < 0 && maxPeople > 20) {
                                System.err.println("Vui lòng nhập số > 0 và < 20");
                            }
                        } while (maxPeople < 0 && maxPeople > 20);
                        do {
                            System.out.print("Enter rentalType:");
                            rentalType = scanner.next();
                            if (!rentalType.matches(MyRegex.REGEX_RENTAL_TYPE)) {
                                System.err.println("Vui lòng nhập đúng định dạng (Ngay , Thang , Nam hoặc Gio )!");
                            }
                        } while (!rentalType.matches(MyRegex.REGEX_RENTAL_TYPE));
                        System.out.println("Enter serviceFree:");
                        String serviceFree = scanner.next();
                        Room room = new Room(serviceCode, serviceName, usableArea, rentalCost, maxPeople, rentalType, serviceFree);
                        facilityRepository.addFacility(room);
                        break;
                    case 4:
                        check = false;
                }
            } while (check);
        } catch (InputMismatchException e) {
            System.err.println("Vui lòng nhập số !");
        }
//    public void displayListMaintenance() {
//        facilityRepository.displayListMaintenance();
//    }
    }
}
