package isaoglu.cahit.VetApp.dto.request.customer;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerSaveRequest {
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
    @NotBlank(message = "Müşteri şehir bilgisi boş bırakılamaz")
    private String city;
    /*
    {
        "name": "Cahit",
        "phone": "5359876582",
        "mail": "isaoglu@cahit.com",
        "address": "Merkez cad. Posta sok. No 1",
        "city": "İstanbul"
}
     */
}
