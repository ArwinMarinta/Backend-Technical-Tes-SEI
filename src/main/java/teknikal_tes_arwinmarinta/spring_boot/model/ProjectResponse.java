package teknikal_tes_arwinmarinta.spring_boot.model;

import java.security.Timestamp;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProjectResponse {
   private int id;
   private String projectName;
   private String client;
   private Date startDate;
   private Date endDate;
   private String projectLeader;
   private String description;
   private Timestamp createAt;

}
