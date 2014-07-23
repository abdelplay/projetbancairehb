package ma.banking.dao;

import java.util.List;

import ma.banking.bo.Operation;

public interface IOperationDao {

	void creat(Operation c);
	void update(Operation c);
	void delete(Operation c);
	List<Operation> retrieve();
	Operation findById(Long id);
	List<Operation> findByNumCompte(String numCompte);
	
}
