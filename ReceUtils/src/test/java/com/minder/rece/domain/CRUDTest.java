package com.minder.rece.domain;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;



import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.junit.*;

import com.minder.rece.utils.db.SessionMaker;

public class CRUDTest {
	
	private static Language language;
	private static Country country;
	private static Holding holding;
	private static Company companyA;
	private static Company companyB;
	
	private static Session session;

	@BeforeClass
	public static void setup() {
		language = new Language();
		language.setName("Gallego");
		language.setDescription("Prueba de lenguaje.");
		country = new Country();
		country.setName("España");
		country.setLanguage(language);
		holding = new Holding();
		holding.setName("Disney");
		holding.setCountry(country);
		companyA = new Company();
		companyA.setName("LucasArt");
		companyA.setHolding(holding);
		companyB = new Company();
		companyB.setName("Marvel");
		companyB.setHolding(holding);
		
		Logger log = Logger.getLogger("org.hibernate");
        log.setLevel(Level.WARNING);
		
		session = SessionMaker.openSession();
	}

	@Test
	public void testSaveAndRead() {
		
		Transaction tx = session.beginTransaction();

		save();
        session.flush();
		tx.commit();
		
		List<Company> results = session.createCriteria(Company.class).add(Restrictions.eq("name", "Marvel")).list();
		if(!results.isEmpty()){
			
			Company foundCompany = results.get(0);
			
			companyB.setId(foundCompany.getId());
			
			assertEquals(companyB, foundCompany);
		}
	}

	@AfterClass
	public static void clean() {
		if(session.getTransaction().isActive()){
	    	System.out.println("An active transaction was found, rollbacking it...");
			session.getTransaction().rollback();
	    	System.out.println("Transaction rollbacked!");
		}
    	//System.out.println("Deleting tables...");
		deleteTables();
    	//System.out.println("Tables deleted.");
    	//System.out.println("Closing session...");
		session.close();
    	//System.out.println("Session closed!");
	}

	private void save() {
		session.save(language);
		session.save(country);
		session.save(holding);
		session.save(companyA);
		session.save(companyB);
		Set<Company> companies = new HashSet<Company>();
		companies.add(companyA);
		companies.add(companyB);
		holding.setCompanies(companies);
		session.save(holding);
	}

	private static void deleteTables() {
		session.beginTransaction();
		session.createSQLQuery("drop table available_credits").executeUpdate();
		session.createSQLQuery("drop table business_plans").executeUpdate();
		session.createSQLQuery("drop table certificates").executeUpdate();
		session.createSQLQuery("drop table certificate_types").executeUpdate();
		session.createSQLQuery("drop table companies").executeUpdate();
		session.createSQLQuery("drop table countries").executeUpdate();
		session.createSQLQuery("drop table credits").executeUpdate();
		session.createSQLQuery("drop table file_split_and_sign_configurations").executeUpdate();
		session.createSQLQuery("drop table granted_permissions").executeUpdate();
		session.createSQLQuery("drop table headquarter_assignments").executeUpdate();
		session.createSQLQuery("drop table headquarter_supervisor_assignments").executeUpdate();
		session.createSQLQuery("drop table headquarters").executeUpdate();
		session.createSQLQuery("drop table holdings").executeUpdate();
		session.createSQLQuery("drop table languages").executeUpdate();
		session.createSQLQuery("drop table liquidation_file_status").executeUpdate();
		session.createSQLQuery("drop table liquidation_files").executeUpdate();
		session.createSQLQuery("drop table liquidations").executeUpdate();
		session.createSQLQuery("drop table passwords").executeUpdate();
		session.createSQLQuery("drop table permissions").executeUpdate();
		session.createSQLQuery("drop table receipts").executeUpdate();
		session.createSQLQuery("drop table role_assignments").executeUpdate();
		session.createSQLQuery("drop table signed_receipts").executeUpdate();
		session.createSQLQuery("drop table signers").executeUpdate();
		session.createSQLQuery("drop table token_types").executeUpdate();
		session.createSQLQuery("drop table tokens").executeUpdate();
		session.createSQLQuery("drop table user_roles").executeUpdate();
		session.createSQLQuery("drop table users").executeUpdate();
		session.getTransaction().commit();
	}

}
