package isaoglu.cahit.VetApp.dto.request.vaccine;

import isaoglu.cahit.VetApp.entitiy.Animal;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.boot.query.AbstractNamedQueryBuilder;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VaccineUpdateRequest {
    @Positive
    @NotNull(message = "Güncellenecek olan aşının ID'si boş bırakılamaz")
    private long id;
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
}
