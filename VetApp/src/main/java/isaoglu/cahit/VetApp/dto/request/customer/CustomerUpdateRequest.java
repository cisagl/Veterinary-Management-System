package isaoglu.cahit.VetApp.dto.request.customer;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerUpdateRequest {
    @NotNull(message = "Müşteri adı boş bırakılamaz")
    private String name;
    @NotNull(message = "Müşteri telefon numarası boş bırakılamaz")
    private String phone;
    @Email
    @NotNull(message = "Müşteri mail adresi boş bırakılamaz")
    private String mail;
    @NotNull(message = "Müşteri adres bilgisi boş bırakılamaz")
    private String address;
    @NotNull(message = "Müşteri şehir bilgisi boş bırakılamaz")
    private String city;
}
