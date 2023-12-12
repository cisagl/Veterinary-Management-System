package isaoglu.cahit.VetApp.dto.request.vaccine;

import isaoglu.cahit.VetApp.entitiy.Animal;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VaccineSaveRequest {
    @NotNull(message = "Aşı adı boş bırakılamaz")
    private String name;
    @NotNull(message = "Aşı kodu boş bırakılamaz")
    private String code;
    @Temporal(TemporalType.DATE)
    @NotNull(message = "Bağışıklık başlangıç tarihi boş bırakılamaz")
    private LocalDate protectionStartDate;
    @Temporal(TemporalType.DATE)
    @NotNull(message = "Bağışıklık bitiş tarihi boş bırakılamaz")
    private LocalDate protectionFinishDate;
    @NotNull(message = "Aşının yapıldığı hayvanın ID'si boş bırakılamaz")
    private Animal animal;

    /*
    {
        "name": "VetVac",
        "code": "UDFIG345",
        "protectionStartDate": "2023-12-13",
        "protectionFinishDate": "2024-12-13",
        "animal": {
            "id": 2
        }
    }
     */
}
