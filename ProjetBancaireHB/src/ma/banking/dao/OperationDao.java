package ma.banking.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import ma.banking.bo.Compte;
import ma.banking.bo.Operation;

public class OperationDao implements IOperationDao{

	 SessionFactory sf = ConnexionManager.getSessionFactory();
	    Session session ;
	    Transaction tx;
	    List<Operation> operations;
	    Operation operation;

	@Override
	public void creat(Operation c) {
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
	public void update(Operation c) {
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
	public void delete(Operation c) {
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
	public List<Operation> retrieve() {
		session = sf.openSession();
		tx = session.beginTransaction();
		
		try{
			operations = session.createQuery("from Operation").list();
			return operations;
		}catch(Exception e){
			
			e.printStackTrace();
			return null;
		}finally{
			session.close();
		}
	}

	@Override
	public Operation findById(Long id) {
		session = sf.openSession();
		tx = session.beginTransaction();
		
		try{
			Query query = session.createQuery("from Operation where Id =:identifiant");
			query.setParameter("identifiant", id);
			operation = (Operation) query.uniqueResult();
			return operation;
		}catch(Exception e){
			
			e.printStackTrace();
			return null;
		}finally{
			session.close();
		}
	}

	@Override
	public List<Operation> findByNumCompte(String numCompte) {
		session = sf.openSession();
		
		Query query = session.createQuery("SELECT oper FROM Compte AS com JOIN com.operations AS oper WHERE com.num = :numero");
		query.setParameter("numero",numCompte);
		operations = (List<Operation>) query.list();
		return operations;
		
		
	}

	

}
