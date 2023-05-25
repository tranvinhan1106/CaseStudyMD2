package src.repository.Impl;

import src.models.Facility;
import src.models.House;
import src.models.Room;
import src.models.Villa;
import src.repository.IFacilityRepository;

import java.util.LinkedHashMap;
import java.util.Map;

public class FacilityRepository implements IFacilityRepository {
    public static int countH = 0;
    public static int countV = 0;
    public static int countR = 0;
    public static Map<Facility, Integer> facilityIntegerMap ;

    static {
        facilityIntegerMap = new LinkedHashMap<>();
        facilityIntegerMap.put(new House("SVHO-0001","House", 300, 200000000, 5, "year", "Five Star" ,3), countH++);
        facilityIntegerMap.put(new Villa("SVVL-0002","Villa", 300, 200000000, 5, "year", "Four Star", 3, 2), countV++);
        facilityIntegerMap.put(new Room("SVRO-0003","Room", 300, 200000000, 5, "year", "water"), countR++);
    }

    @Override
    public Map<Facility, Integer> displayFacility() {
        return facilityIntegerMap;
    }

    @Override
    public void addFacility(Facility o) {
        if (o instanceof Villa) {
            facilityIntegerMap.put(o, countV++);
        } else if (o instanceof House) {
            facilityIntegerMap.put(o, countH++);
        } else {
            facilityIntegerMap.put(o, countR++);
        }
    }

//    @Override
//    public void displayListMaintenance() {
//        for (Facility key : facilityIntegerMap.keySet()) {
//            if (facilityIntegerMap.get(key) >= 5) {
//                System.err.println(key.getServiceName() + "Cần bảo trì !");
//            }
//        }
//    }

}
