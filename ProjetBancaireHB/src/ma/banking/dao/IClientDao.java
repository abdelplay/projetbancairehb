package ma.banking.dao;

import java.util.List;

import ma.banking.bo.Client;

public interface IClientDao {
	
	void creat(Client c);
	void update(Client c);
	void delete(Client c);
	List<Client> retrieve();
	Client findById(Long id);

}
