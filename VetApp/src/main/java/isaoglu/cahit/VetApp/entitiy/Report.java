package isaoglu.cahit.VetApp.entitiy;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "report")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Report {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "report_id")
    private long id;

    @Column(name = "report_title")
    private String title;

    @Column(name = "report_diagnosis")
    private String diagnosis;

    @Column(name = "report_price")
    private double price;

    @OneToMany(mappedBy = "report", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    @JsonIgnore
    private List<Vaccine> vaccine;

    @OneToOne
    @JoinColumn(name = "report_appointment_id", referencedColumnName = "appointment_id")
    private Appointment appointment;
}
