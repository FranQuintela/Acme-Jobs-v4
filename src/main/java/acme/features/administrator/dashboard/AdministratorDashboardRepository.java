
package acme.features.administrator.dashboard;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.framework.repositories.AbstractRepository;

@Repository
public interface AdministratorDashboardRepository extends AbstractRepository {

	//Tablero Sector

	@Query("select distinct r.sector from InvestorRecord r order by r.sector")
	String[] investorSector();

	@Query("select count(r) from InvestorRecord r group by r.sector order by r.sector")
	String[] dataInvestor();

	@Query("select distinct c.workSector from CompanyRecords c where c.workSector not in (?1)")
	String[] companySector(String[] sector);

	@Query("select workSector,count(c) from CompanyRecords c group by c.workSector")
	String[] dataCompany();

	//Tablero Status Jobs

	@Query("select distinct j.status from Job j order by j.status")
	String[] jobStatus();

	@Query("select count(j) from Job j group by j.status order by j.status")
	String[] dataJob();

	//Tablero Status Application

	@Query("select distinct a.status from Application a order by a.status")
	String[] applicationStatus();

	@Query("select count(a) from Application a group by a.status order by a.status")
	String[] dataApplication();

	//Listing D02:

	@Query("select count(r) from Announcement r")
	Integer countAllAnnouncement();

	@Query("select count(r) from CompanyRecords r")
	Integer countAllCompanyRecord();

	@Query("select count(r) from InvestorRecord r")
	Integer countAllInvestorRecord();

	@Query("select max(r.maxReward.amount) from Offer r where r.deadline > utc_timestamp()")
	Double getMaxOffer();

	@Query("select min(r.minReward.amount) from Offer r where r.deadline > utc_timestamp()")
	Double getMinOffer();

	@Query("select max(r.reward.amount) from Request r where r.deadline > utc_timestamp()")
	Double getMaxRequest();

	@Query("select min(r.reward.amount) from Request r where r.deadline > utc_timestamp()")
	Double getMinRequest();

	@Query("select avg(r.reward.amount) from Request r where r.deadline > utc_timestamp()")
	Double getAvgRequest();

	@Query("select stddev(r.reward.amount) from Request r where r.deadline > utc_timestamp()")
	Double getStdRequest();

	//Querys no directas D02:

	@Query("select avg(r.maxReward.amount) from Offer r where r.deadline > utc_timestamp()")
	Double getMaxAvgOffer();

	@Query("select avg(r.minReward.amount) from Offer r where r.deadline > utc_timestamp()")
	Double getMinAvgOffer();

	@Query("select stddev(r.maxReward.amount) from Offer r where r.deadline > utc_timestamp()")
	Double getStdMaxOffer();

	@Query("select stddev(r.minReward.amount) from Offer r where r.deadline > utc_timestamp()")
	Double getStdMinOffer();

	//Listing D04:
	@Query("select avg(select count(j) from Job j where j.employer.id = e.id) from Employer e")
	Double avgNumberJobsPerEmployer();

	@Query("select avg(select count(a) from Application a where exists(select j from Job j where j.employer.id = e.id and a.job.id = j.id)) from Employer e")
	Double avgNumberApplicationsPerEmployer();

	@Query("select avg(select count(a) from Application a where a.worker.id = w.id) from Worker w")
	Double avgNumberApplicationsPerWorker();
}
