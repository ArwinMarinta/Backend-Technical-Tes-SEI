package teknikal_tes_arwinmarinta.spring_boot.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class WebResponse<T> {
    private String message; // Field untuk pesan sukses atau informasi
    private T data; // Field untuk menampung data generik
    private List<String> errors; // Field untuk menampung error jika ada
}
