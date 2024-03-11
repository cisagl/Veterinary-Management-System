package isaoglu.cahit.VetApp.dao;

import isaoglu.cahit.VetApp.entitiy.Report;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReportRepo extends JpaRepository<Report, Long> {
    Report findById(long id);
}
