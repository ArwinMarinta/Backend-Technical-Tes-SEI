package teknikal_tes_arwinmarinta.spring_boot.model;


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
public class LocationRequest {
    @NotBlank(message="The location name cannot be empty")
    @Size(max = 200)
    private String locationName;

    @Size(max= 100)
    private String country;

    @Size(max = 50)
    private String province;

    @Size(max = 50)
    private String city;
}
