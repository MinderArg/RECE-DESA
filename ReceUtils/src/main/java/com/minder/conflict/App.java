package com.minder.conflict;

import java.util.List;
import java.util.Properties;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import com.minder.rece.domain.LiquidationFile;
import com.minder.rece.domain.LiquidationFileStatus;
 

public class App {
    private static SessionFactory sessionFactory = null; 
    private static ServiceRegistry serviceRegistry = null; 
       
    private static SessionFactory configureSessionFactory() throws HibernateException { 
        Configuration configuration = new Configuration(); 
        configuration.configure(); 
         
        Properties properties = configuration.getProperties();
         
        serviceRegistry = new ServiceRegistryBuilder().applySettings(properties).buildServiceRegistry();         
        sessionFactory = configuration.buildSessionFactory(serviceRegistry); 
         
        return sessionFactory; 
    }
     
    public static void main(String[] args) {
        // Configure the session factory
        configureSessionFactory();
         
        Session session = null;
        Transaction tx=null;
         
        try {
            session = sessionFactory.openSession();
            tx = session.beginTransaction();
             
            // Creating Contact entity that will be save to the sqlite database
            LiquidationFileStatus fileStatus = new LiquidationFileStatus();
            LiquidationFile file = new LiquidationFile();
            
            fileStatus.setDescription("Prueba de status.");
            fileStatus.setName("EstadoA");
            file.setName("ArchivoA");
            file.setUri("//mis docs");
            
            file.setLiquidationFileStatus(fileStatus);
             
            // Saving to the database
            session.save(fileStatus);
            session.save(file);
            
            
            file = new LiquidationFile();

            file.setName("ArchivoB");
            file.setUri("//mis docs");
            
            file.setLiquidationFileStatus(fileStatus);
             
            // Saving to the database
            session.save(file);
             
            // Committing the change in the database.
            session.flush();
            tx.commit();
             
            // Fetching saved data
            tx = session.beginTransaction();
            
            System.out.println("--LiquidationFile--");
			List<LiquidationFile> fileList = session.createQuery("from LiquidationFile").list();
            for (LiquidationFile liqFile : fileList) {
            	
            	System.out.println("Id: " + liqFile.getId() + " | Name:"  + liqFile.getName() + " | Uri:" + liqFile.getUri()+ " | Status: "+liqFile.getLiquidationFileStatus().getName());
            }

            System.out.println("--LiquidationFileStatus--");
			List<LiquidationFileStatus> statusList = session.createQuery("from LiquidationFileStatus").list();
            for (LiquidationFileStatus status : statusList) {
            	
            	System.out.println("Id: " + status.getId() + " | Name:"  + status.getName() + " | Desc: " + status.getDescription());
            	
            }
            
            session.flush();
			tx.commit();
             
        } catch (Exception ex) {
            ex.printStackTrace();
             
            // Rolling back the changes to make the data consistent in case of any failure
            // in between multiple database write operations.
            tx.rollback();
        } finally{
            if(session != null) {
            	System.out.println("Closing session...");
                session.close();
            	System.out.println("Session closed!");
            }
        }
    }
}