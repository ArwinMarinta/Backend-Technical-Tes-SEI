package teknikal_tes_arwinmarinta.spring_boot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import teknikal_tes_arwinmarinta.spring_boot.model.LocationRequest;
import teknikal_tes_arwinmarinta.spring_boot.model.LocationResponse;
import teknikal_tes_arwinmarinta.spring_boot.model.WebResponse;
import teknikal_tes_arwinmarinta.spring_boot.service.LocationService;

@RestController
public class LocationController {
    @Autowired
    private LocationService locationService;

    @PostMapping(path = "/api/location", produces= MediaType.APPLICATION_JSON_VALUE, consumes= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<WebResponse<LocationResponse>> createLocation(@RequestBody LocationRequest location){
        LocationResponse locationResponse = locationService.createLocation(location);

       WebResponse<LocationResponse> response = WebResponse.<LocationResponse>builder().message("Location created succesfully").data(locationResponse).build();

        return ResponseEntity.ok(response);

        }
    

    @GetMapping(path="/api/location", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<WebResponse<List<LocationResponse>>> getAllLocation(){
        List<LocationResponse> location = locationService.findAll();

        WebResponse <List<LocationResponse>> response = WebResponse.<List<LocationResponse>>builder().message("Location retrieved succesfully").data(location).build();

        return  ResponseEntity.ok(response);
    } 



    @DeleteMapping(path = "/api/location/{locationId}", produces= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<WebResponse<String>> deleteLocation(@PathVariable("locationId") int locationId){
        locationService.delete(locationId);

        WebResponse<String> response = WebResponse.<String>builder().message("Location deleted successfully")
            .data("Location with ID " + locationId + " has been deleted")
            .build();

        return ResponseEntity.ok(response);
    }
    
    @PutMapping(path = "/api/location/{locationId}", produces= MediaType.APPLICATION_JSON_VALUE, consumes= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<WebResponse<LocationResponse>> updateLocation(@PathVariable("locationId") int locationId, @RequestBody LocationRequest request){
        LocationResponse update = locationService.update(locationId, request);

        WebResponse<LocationResponse> response = WebResponse.<LocationResponse>builder().message("Location updated successfully")
                .data(update)
                .build();

        return ResponseEntity.ok(response);
    }
}
