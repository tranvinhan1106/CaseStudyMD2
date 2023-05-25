package src.repository;

import src.models.Facility;

import java.io.IOException;
import java.util.Map;

public interface IFacilityRepository {
    Map<Facility, Integer> displayFacility();

    void addFacility(Facility o);

//    void displayListMaintenance();
}
