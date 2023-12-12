package isaoglu.cahit.VetApp.dto.request.doctor;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DoctorUpdateRequest {
    @NotNull(message = "Doktor adı boş bırakılamaz")
    private String name;
    @NotNull(message = "Doktor telefon numarası bırakılamaz")
    private String phone;
    @NotNull(message = "Doktor mail adresi boş bırakılamaz")
    @Email
    private String mail;
    @NotNull(message = "Doktor adres bilgisi boş bırakılamaz")
    private String address;
    @NotNull(message = "Doktor şehir bilgisi boş bırakılamaz")
    private String city;
}
