package isaoglu.cahit.VetApp.dto.request.animal;

import isaoglu.cahit.VetApp.entitiy.Customer;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AnimalSaveRequest {
    @NotNull(message = "Hayvan ismi boş bırakılamaz")
    private String name;
    @NotNull(message = "Hayvan türü boş bırakılamaz")
    private String species;
    @NotNull(message = "Hayvanın cinsi boş bırakılamaz")
    private String breed;
    @NotNull(message = "Hayvan cinsiyeti boş bırakılamaz")
    private String gender;
    private String color;
    @Temporal(TemporalType.DATE)
    @Past
    private LocalDate dateOfBirth;
    @NotNull(message = "Sahipsiz hayvan kayıt edilemez")
    private Customer customer;

    /*
    {
        "name": "Kedi",
        "species": "CAT",
        "breed": "Orman kedisi",
        "gender": "FEMALE",
        "color": "Beyaz, turuncu",
        "dateOfBirth": "2020-11-05",
        "customer": {
            "id": 1
        }
     }
     */
}
