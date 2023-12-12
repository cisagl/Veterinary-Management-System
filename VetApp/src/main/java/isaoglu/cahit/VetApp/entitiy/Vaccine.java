package isaoglu.cahit.VetApp.entitiy;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Entity
@Table(name = "vaccine")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Vaccine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vaccine_id")
    private long id;
    @Column(name = "vaccine_name")
    private String name;
    @Column(name = "vaccine_code")
    private String code;
    @Column(name = "vaccine_protect_start")
    private LocalDate protectionStartDate;
    @Column(name = "vaccine_protect_finish")
    private LocalDate protectionFinishDate;
    @ManyToOne
    @JoinColumn(name = "vaccine_animal_id", referencedColumnName = "animal_id")
    private Animal animal;
}
