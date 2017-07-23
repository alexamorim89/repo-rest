package br.com.local.util.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
	
  private static  EntityManagerFactory factory = Persistence.createEntityManagerFactory("VertigoPU");
  
  private static EntityManager manager = factory.createEntityManager();
  
  
  
  public static EntityManager getEntityManager(){
	  return manager;
  }
  
  
  
  
}
