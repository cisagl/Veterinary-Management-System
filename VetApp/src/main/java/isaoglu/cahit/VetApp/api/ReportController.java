package isaoglu.cahit.VetApp.api;

import isaoglu.cahit.VetApp.business.abstracts.IReportService;
import isaoglu.cahit.VetApp.dto.request.report.ReportSaveRequest;
import isaoglu.cahit.VetApp.dto.request.report.ReportUpdateRequest;
import isaoglu.cahit.VetApp.dto.response.report.ReportResponse;
import isaoglu.cahit.VetApp.entitiy.Report;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/v1/reports")
public class ReportController {
    private final IReportService reportService;

    public ReportController(IReportService reportService) {
        this.reportService = reportService;
    }

    @GetMapping()
    public String home(){
        return "Raporlar";
    }

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<Report> findAll(){
        return this.reportService.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Report findById(@PathVariable("id") Long id){
        return this.reportService.getById(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public ReportResponse save(@RequestBody ReportSaveRequest reportSaveRequest){
        return reportService.save(reportSaveRequest);
    }

    @PutMapping("/update/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ReportResponse update(@Valid @PathVariable("id") long id, @RequestBody ReportUpdateRequest reportUpdateRequest){
        return reportService.update(id, reportUpdateRequest);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") long id){
        reportService.delete(id);
    }

}
