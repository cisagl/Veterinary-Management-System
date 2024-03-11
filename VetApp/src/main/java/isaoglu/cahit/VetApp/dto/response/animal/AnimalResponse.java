package isaoglu.cahit.VetApp.dto.response.animal;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AnimalResponse {
    private long id;
    private String name;
    private String species;
    private String gender;
    private String color;
    private LocalDate dateOfBirth;
    private long customerId;
}
