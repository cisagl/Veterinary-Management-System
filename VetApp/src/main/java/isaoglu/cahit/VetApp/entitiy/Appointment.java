package isaoglu.cahit.VetApp.entitiy;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Entity
@Table(name = "appointment")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "appointment_id")
    private long id;

    @Column(name = "appointment_date")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime appointmentDate;

    @ManyToOne
    @JoinColumn(name = "appointment_animal_id", referencedColumnName = "animal_id")
    private Animal animal;

    @ManyToOne
    @JoinColumn(name = "appointment_doctor_id", referencedColumnName = "doctor_id")
    private Doctor doctor;

    @OneToOne(mappedBy = "appointment", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    @JsonBackReference
    private Report report;
}
