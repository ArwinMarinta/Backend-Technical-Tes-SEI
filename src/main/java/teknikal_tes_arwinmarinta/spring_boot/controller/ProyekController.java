package teknikal_tes_arwinmarinta.spring_boot.controller;

// import java.awt.PageAttributes;
import java.awt.PageAttributes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.MediaType;

import teknikal_tes_arwinmarinta.spring_boot.model.ProjectRequest;
import teknikal_tes_arwinmarinta.spring_boot.model.ProjectResponse;
import teknikal_tes_arwinmarinta.spring_boot.model.WebResponse;
import teknikal_tes_arwinmarinta.spring_boot.service.ProyekService;

@RestController
public class ProyekController {
    @Autowired
    private ProyekService proyekService;


    @PostMapping(path = "/api/proyek", produces = MediaType.APPLICATION_JSON_VALUE, consumes= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<WebResponse<ProjectResponse>> create (@RequestBody ProjectRequest request){
        ProjectResponse project = proyekService.create(request);

         WebResponse<ProjectResponse> response = WebResponse.<ProjectResponse>builder().message("Projects retrieved successfully").data(project).build();

        return ResponseEntity.ok(response);
        
    }
}
