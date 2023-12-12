package isaoglu.cahit.VetApp.dto.request.appointment;

import isaoglu.cahit.VetApp.entitiy.Animal;
import isaoglu.cahit.VetApp.entitiy.Doctor;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AppointmentSaveRequest {
    @Temporal(TemporalType.DATE)
    @NotNull(message = "Randevu günü boş bırakılamaz")
    private LocalDateTime appointmentDate;
    @NotNull(message = "Randevuya gelecek olan hayvanın ID'si boş bırakılamaz")
    private Animal animal;
    @NotNull(message = "Randevuya gelecek olan doktorun ID'si boş bırakılamaz")
    private Doctor doctor;

    /*
    {
        "appointmentDate": "2023-12-10T11:00",
        "animal": {
            "id": 4
        },
        "doctor": {
            "id": 2
        }
    }
     */
}
