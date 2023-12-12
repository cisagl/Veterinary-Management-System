package isaoglu.cahit.VetApp.entitiy;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "animal")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Animal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "animal_id")
    private long id;
    @Column(name = "animal_name")
    private String name;
    @Column(name = "animal_species")
    private String species;
    @Column(name = "animal_breed")
    private String breed;
    @Column(name = "animal_gender")
    private String gender;
    @Column(name = "animal_color")
    private String color;
    @Column(name = "animal_birth_date")
    private LocalDate dateOfBirth;

    @OneToMany(mappedBy = "animal", cascade = {CascadeType.REMOVE, CascadeType.MERGE}, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Vaccine> vaccine;

    @OneToMany(mappedBy = "animal", cascade = {CascadeType.REMOVE, CascadeType.MERGE}, fetch = FetchType.EAGER)
    @JsonIgnore
    private List<Appointment> appointment;

    @ManyToOne
    @JoinColumn(name = "animal_customer_id", referencedColumnName = "customer_id")
    private Customer customer;
}
