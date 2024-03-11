package isaoglu.cahit.VetApp.dto.response.report;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReportResponse {
    private long id;
    private String title;
    private String diagnosis;
    private double price;
    private long appointmentId;
}
