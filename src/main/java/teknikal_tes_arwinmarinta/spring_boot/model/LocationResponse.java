package teknikal_tes_arwinmarinta.spring_boot.model;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LocationResponse {
    private int id;
    private String locationName;
    private String country;
    private String province;
    private String city;
    private Timestamp createAt;
}
