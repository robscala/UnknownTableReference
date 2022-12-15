import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@DiscriminatorValue("9")
@Table(name = "customer")
public class CustomerCompany extends Company {
    private Boolean allowWebImpersonation;
}
