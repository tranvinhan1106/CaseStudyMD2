package src.services;

import src.models.Facility;

import java.util.Map;

public interface IFacilityService extends Service{
    Map<Facility, Integer> displayFacility();

    void addFacility();
}
