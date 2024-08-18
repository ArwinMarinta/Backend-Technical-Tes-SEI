package teknikal_tes_arwinmarinta.spring_boot.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import teknikal_tes_arwinmarinta.spring_boot.entity.Proyek;
import teknikal_tes_arwinmarinta.spring_boot.model.ProjectRequest;
import teknikal_tes_arwinmarinta.spring_boot.model.ProjectResponse;
import teknikal_tes_arwinmarinta.spring_boot.repository.ProjectRepository;

@Service
public class ProyekService {
    @Autowired
    private ValidationService validationService;

    @Autowired
    private ProjectRepository projectRepository; 


    @Transactional
   public ProjectResponse create(ProjectRequest projectRequest) {

        validationService.validate(projectRequest);

        Proyek proyek = new Proyek();
        proyek.setNameProject(projectRequest.getProjectName());
        proyek.setClient(projectRequest.getClient());
        proyek.setStartDate(projectRequest.getStartDate());
        proyek.setEndDate(projectRequest.getEndDate());
        proyek.setProjectLeader(projectRequest.getProjectLeader());
        proyek.setDescription(projectRequest.getDescription());
        proyek.setCreateAt(new java.sql.Timestamp(System.currentTimeMillis()));

        Proyek savedProyek = projectRepository.save(proyek);

        return ProjectResponse.builder().id(savedProyek.getId()).projectName(savedProyek.getNameProject()).client(savedProyek.getClient()).startDate(savedProyek.getStartDate()).endDate(savedProyek.getEndDate()).projectLeader(savedProyek.getProjectLeader()).description(savedProyek.getDescription()).build();

   }
    

    // @Transactional
    // public List<ProjectResponse> findProyek(){
    //     //
    // }
}
