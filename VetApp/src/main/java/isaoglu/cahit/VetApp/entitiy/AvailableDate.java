package isaoglu.cahit.VetApp.entitiy;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;
@Entity
@Table(name = "available_date")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AvailableDate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "available_date_id")
    private long id;
    @Column(name = "available_date_vet")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate availableDate;
    @ManyToOne
    @JoinColumn(name = "available_date_doctor_id", referencedColumnName = "doctor_id")
    private Doctor doctor;
}
