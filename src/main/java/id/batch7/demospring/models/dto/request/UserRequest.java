package id.batch7.demospring.models.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRequest {
    @NotBlank(message = "First name harus diisi!")
    private String firstName;
    @NotBlank(message = "Last name harus diisi!")
    private String lastName;
    @NotBlank(message = "Email harus diisi!")
    private String email;
    @NotBlank(message = "Username harus diisi!")
    private String username;
    @NotBlank(message = "Password harus diisi!")
    private String password;
    
}
