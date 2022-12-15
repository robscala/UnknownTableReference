import java.util.Properties;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Report
{
    public void run(String dbUrl, String password, Long distributorId)
    {
        Properties connectionProperties = new Properties();
        connectionProperties.put("javax.persistence.jdbc.url", dbUrl);
        connectionProperties.put("jakarta.persistence.jdbc.user", "insidetrack");
        connectionProperties.put("jakarta.persistence.jdbc.password", password);
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("InsideTrack", connectionProperties);
        EntityManager entityManager = emf.createEntityManager();

        DistributorCompany distributorCompany = entityManager.find(DistributorCompany.class, distributorId);
        System.out.println("ScheduleTarget count: " + distributorCompany.getScheduleTargets().size());
        entityManager.close();
    }

    public static void main(String args[])
    {
        Report report = new Report();
        report.run(args[0], args[1], Long.parseLong(args[2]));
    }
}
