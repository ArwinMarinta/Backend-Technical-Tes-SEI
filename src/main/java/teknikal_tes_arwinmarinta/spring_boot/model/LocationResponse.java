package teknikal_tes_arwinmarinta.spring_boot.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LocationResponse {
    private int id; // Perbaikan dari 'string' menjadi 'int'
    private String locationName;
    private String country;
    private String province;
    private String city;
}
