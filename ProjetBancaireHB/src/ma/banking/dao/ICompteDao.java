package ma.banking.dao;

import java.util.List;

import ma.banking.bo.Client;
import ma.banking.bo.Compte;

public interface ICompteDao {
	
	void creat(Compte c);
	void update(Compte c);
	void delete(Compte c);
	List<Compte> retrieve();
	Compte findById(Long id);
	List<Compte> findByClient(Long id_client);
}
