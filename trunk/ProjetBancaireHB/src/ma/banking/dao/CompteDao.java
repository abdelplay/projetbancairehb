package ma.banking.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import ma.banking.bo.Compte;

public class CompteDao implements ICompteDao{

    SessionFactory sf = ConnexionManager.getSessionFactory();
    Session session ;
    Transaction tx;
    List<Compte> comptes;
    Compte compte;
    
	@Override
	public void creat(Compte c) {

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
	public void update(Compte c) {

		session = sf.openSession();
		tx = session.beginTransaction();
		
		try{
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
	public void delete(Compte c) {

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
	public List<Compte> retrieve() {
		session = sf.openSession();
		tx = session.beginTransaction();
		
		try{
			comptes = session.createQuery("from Compte").list();
			return comptes;
		}catch(Exception e){
			
			e.printStackTrace();
			return null;
		}finally{
			session.close();
		}
		
	}

	@Override
	public Compte findById(Long id) {
		session = sf.openSession();
		tx = session.beginTransaction();
		
		try{
			Query query = session.createQuery("from Compte where Id = :identifiant");
			query.setLong("identifiant", id);
			compte = (Compte) query.uniqueResult();
			return compte;
		}catch(Exception e){
			
			e.printStackTrace();
			return null;
		}finally{
			session.close();
		}
	}

	@Override
	public List<Compte> findByClient(Long id_client) {
   session = sf.openSession();
   
   Query query = session.createQuery("SELECT com from Client AS cli JOIN cli.comptes AS com where com.client = :id_client");
   query.setLong("id_client", id_client);
   comptes = (List<Compte>) query.list();
		
		return comptes;
	}

}
