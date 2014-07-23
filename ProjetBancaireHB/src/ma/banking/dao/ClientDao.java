package ma.banking.dao;


import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import ma.banking.bo.Client;

public class ClientDao implements IClientDao{

	SessionFactory sf = ConnexionManager.getSessionFactory();
	Session session;
	Transaction tx;
	List<Client> clients;
	Client cli;
	
	
	@Override
	public void creat(Client c) {
		 session = sf.openSession();
		 tx = session.beginTransaction();
		 
		try{
		session.save(c);
		tx.commit();
		
		
		}catch(Exception e){
			tx.rollback();
			e.printStackTrace();
			
		}finally{
			session.close();
		}
	}

	@Override
	public void update(Client c) {
		// TODO Auto-generated method stub
		 session = sf.openSession();
		 tx = session.beginTransaction();
		try{
			
			//Client c1 = (Client) session.load(Client.class, c.getId());
			//c1 = c;
			session.update(c);
			tx.commit();
			
			}catch(Exception e){
				tx.rollback();
				e.printStackTrace();
				
			}finally{
				session.close();
				
			}
	}

	@Override
	public void delete(Client c) {
		// TODO Auto-generated method stub
				 session = sf.openSession();
				 tx = session.beginTransaction();
				try{
					session.delete(c);
					tx.commit();
					
					}catch(Exception e){
						tx.rollback();
						e.printStackTrace();
						
					}finally{
						session.close();
					}
	}

	@Override
	public List<Client> retrieve() {
		// TODO Auto-generated method stub
				 session = sf.openSession();
				 tx = session.beginTransaction();
				try{
					
				    clients = session.createQuery("from Client").list();
					
					return clients;
					
					}catch(Exception e){
						e.printStackTrace();
						return null;
					}finally{
						session.close();
					}		
				
				
	}

	@Override
	public Client findById(Long id) {
		 session = sf.openSession();
		 tx = session.beginTransaction();
		try{
		    String hql = "from Client where Id = :identifiant";
			Query query = session.createQuery(hql);
			query.setLong("identifiant", id);
			cli = (Client) query.uniqueResult();
		
		return cli;
			
			}catch(Exception e){
				e.printStackTrace();
				return null;
			}finally{
				session.close();
			}		

	}
	
	

}
