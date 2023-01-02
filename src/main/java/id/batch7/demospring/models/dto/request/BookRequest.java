package id.batch7.demospring.models.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookRequest {
    @NotBlank(message = "Judul buku harus diisi!")
    private String judulBuku;
    @NotBlank(message = "Penulis buku harus diisi!")
    private String penulis;
    @NotBlank(message = "Penerbit buku harus diisi!")
    private String penerbit;

    private String categoryName;
    
}
