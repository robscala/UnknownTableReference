import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@DiscriminatorValue("2")
@Table(name="distributor_company")
public class DistributorCompany extends Company {
    @OneToMany(mappedBy="owner", orphanRemoval=true, cascade= CascadeType.ALL)
    private List<ScheduleTarget> scheduleTargets = new ArrayList<>();

    public List<ScheduleTarget> getScheduleTargets() {
        return scheduleTargets;
    }
}
