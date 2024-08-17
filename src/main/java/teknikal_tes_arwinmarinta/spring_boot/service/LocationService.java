package teknikal_tes_arwinmarinta.spring_boot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import teknikal_tes_arwinmarinta.spring_boot.entity.Location;
import teknikal_tes_arwinmarinta.spring_boot.model.LocationRequest;
import teknikal_tes_arwinmarinta.spring_boot.model.LocationResponse;
import teknikal_tes_arwinmarinta.spring_boot.repository.LocationRepository;

@Service
public class LocationService {
    @Autowired
    private ValidationService validationService;

    @Autowired
    private LocationRepository locationRepository;

    
    public LocationResponse createLocation(LocationRequest locationRequest){
        //validasi input
        validationService.validate(locationRequest);

        Location location = new Location();
        location.setLocationName(locationRequest.getLocationName());
        location.setCountry(locationRequest.getCountry());
        location.setProvince(location.getProvince());
        location.setCity(location.getCity());
        location.setCreateAt(new java.sql.Timestamp(System.currentTimeMillis()));

        Location savedLocation = locationRepository.save(location);

        return LocationResponse.builder().id(savedLocation.getId()).locationName(savedLocation.getLocationName()).country(savedLocation.getCountry()).province(savedLocation.getProvince()).city(savedLocation.getCity()).build();
    }


}
