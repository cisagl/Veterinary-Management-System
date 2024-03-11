package isaoglu.cahit.VetApp.business.abstracts;

import isaoglu.cahit.VetApp.dto.request.report.ReportSaveRequest;
import isaoglu.cahit.VetApp.dto.request.report.ReportUpdateRequest;
import isaoglu.cahit.VetApp.dto.response.report.ReportResponse;
import isaoglu.cahit.VetApp.entitiy.Report;

import java.util.List;

public interface IReportService {
    Report getById(long id);
    ReportResponse save(ReportSaveRequest reportSaveRequest);
    ReportResponse update(long id, ReportUpdateRequest reportUpdateRequest);
    void delete(long id);
    List<Report> findAll();
}
