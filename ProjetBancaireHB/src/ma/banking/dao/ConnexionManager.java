package ma.banking.dao;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ConnexionManager {
	
	private static  SessionFactory sf ;
	private static  Configuration cfg;
	
	private static Configuration getConfig(){
		
			return new Configuration().configure();
			
	}
	
	public static SessionFactory getSessionFactory(){
		
		if(sf==null){
			sf = getConfig().buildSessionFactory();
			return sf;
		}else 
		return sf;
	}

}
