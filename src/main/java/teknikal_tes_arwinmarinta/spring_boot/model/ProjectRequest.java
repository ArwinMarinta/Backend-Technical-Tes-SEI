package teknikal_tes_arwinmarinta.spring_boot.model;

import java.util.Date;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProjectRequest {
    @NotBlank(message="The project name cannot be null")
    @Size( max= 100)
    private String projectName;

    @NotBlank(message="The client  cannot be null")
    @Size(max = 100)
    private String client;

    
    private Date startDate; 
    private Date endDate; 

    @NotBlank(message = "The project leader cannot be null")
    @Size(max = 100)
    private String projectLeader;

    private String description; 
}
