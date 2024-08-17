package teknikal_tes_arwinmarinta.spring_boot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import teknikal_tes_arwinmarinta.spring_boot.model.LocationRequest;
import teknikal_tes_arwinmarinta.spring_boot.model.LocationResponse;
import teknikal_tes_arwinmarinta.spring_boot.model.WebResponse;
import teknikal_tes_arwinmarinta.spring_boot.service.LocationService;


@RestController
@RequestMapping("/api/location")
public class LocationController {
    @Autowired
    private LocationService locationService;

    @PostMapping(path = "/", produces= MediaType.APPLICATION_JSON_VALUE, consumes= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<WebResponse<LocationResponse>> createLocation(@RequestBody LocationRequest location){
        LocationResponse locationResponse = locationService.createLocation(location);

       WebResponse<LocationResponse> response = WebResponse.<LocationResponse>builder().message("Location created succesfully").data(locationResponse).build();

        return ResponseEntity.ok(response);
}
    
    
}
