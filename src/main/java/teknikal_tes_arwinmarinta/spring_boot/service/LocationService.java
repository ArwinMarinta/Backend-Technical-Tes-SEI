package teknikal_tes_arwinmarinta.spring_boot.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
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

    
    @Transactional
    public LocationResponse createLocation(LocationRequest locationRequest){
        //validasi input
        validationService.validate(locationRequest);

        Location location = new Location();
        location.setLocationName(locationRequest.getLocationName());
        location.setCountry(locationRequest.getCountry());
        location.setProvince(locationRequest.getProvince());
        location.setCity(locationRequest.getCity());
        location.setCreateAt(new java.sql.Timestamp(System.currentTimeMillis()));

        Location savedLocation = locationRepository.save(location);

        return LocationResponse.builder().id(savedLocation.getId()).locationName(savedLocation.getLocationName()).country(savedLocation.getCountry()).province(savedLocation.getProvince()).city(savedLocation.getCity()).build();
    }

    @Transactional
    public List<LocationResponse> findAll(){
        // List<Location> locations = locationRepository.findAll();

       return  locationRepository.findAll().stream().map((var location) -> new LocationResponse(
        location.getId(),
        location.getLocationName(),
        location.getCountry(),
        location.getProvince(),
        location.getCity(),
        location.getCreateAt()
       )).collect(Collectors.toList());
    }

    @Transactional
    public void delete(int locationId){
        Location location = locationRepository.findById(locationId).orElseThrow(() -> new RuntimeException("Location with ID " + locationId + " not found"));

        locationRepository.delete(location);
    }

    @Transactional
    public LocationResponse update(int locationId, LocationRequest locationRequest){
        Location location = locationRepository.findById(locationId).orElseThrow(() -> new RuntimeException("Location with ID " + locationId + " not found"));

        location.setLocationName(locationRequest.getLocationName());
        location.setCountry(locationRequest.getCountry());
        location.setProvince(locationRequest.getProvince());
        location.setCity(locationRequest.getCity());
        location.setCreateAt(new java.sql.Timestamp(System.currentTimeMillis()));

        Location updateLocation = locationRepository.save(location);

        return LocationResponse.builder().id(updateLocation.getId()).locationName(updateLocation.getLocationName()).country(updateLocation.getCountry()).province(updateLocation.getProvince()).city(updateLocation.getCity()).createAt(updateLocation.getCreateAt()).build();
    }
}
