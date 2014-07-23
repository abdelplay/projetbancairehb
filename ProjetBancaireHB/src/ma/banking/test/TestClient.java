package ma.banking.test;

import java.util.ArrayList;
import java.util.List;

import ma.banking.bo.Client;
import ma.banking.bo.Compte;
import ma.banking.bo.Operation;
import ma.banking.dao.ClientDao;
import ma.banking.dao.CompteDao;
import ma.banking.dao.IClientDao;
import ma.banking.dao.ICompteDao;
import ma.banking.dao.IOperationDao;
import ma.banking.dao.OperationDao;

import org.junit.BeforeClass;
import org.junit.Test;

import junit.framework.TestCase;

public class TestClient extends TestCase{

	
	IClientDao cdao = new ClientDao();
	ICompteDao codao = new CompteDao();
	IOperationDao odao = new OperationDao();
	
	Operation o1 = new Operation();
	Operation o2 = new Operation();
	

	List<Compte> comptes = new ArrayList<Compte>();
	List<Compte> comptes1 = new ArrayList<Compte>();
	List<Operation> operations = new ArrayList<Operation>();
	
	Client c = new Client();	
	Client c1 = new Client();

	Compte co = new Compte();
	Compte co1 = new Compte();
	Compte co2 = new Compte();
	Compte co3 = new Compte();
	
@BeforeClass
protected void setUp(){
	
	
	
	co1.setNum("123456789456123");
	co1.setSolde(545.8);
	co1.setType("Compte cheque");
	
	
	co2.setNum("798456456546164");
	co2.setSolde(1245.8);
	co2.setType("Compte courant");
	
	
	co3.setNum("465651276456757");
	co3.setSolde(145.8);
	co3.setType("Compte sur carnet");
	
	
	c.setCIN("BK214567");
	c.setNom("Hamid");
	
	
	c1.setCIN("CD66467");
	c1.setNom("Farid");
	
	
	
	
	co1.setClient(c);
	co2.setClient(c);
	co3.setClient(c1);
	
	codao.creat(co1);
	codao.creat(co2);
	codao.creat(co3);
	
	
	
	
	
	o1.setRef("jh45787");
	o1.setSens("DB");
	o1.setType("ERA");
	o1.setMontant(2000.00);
	
	o2.setRef("zt47857");
	o2.setSens("CR");
	o2.setType("ERA");
	o2.setMontant(1500.00);
	
	
	


}

	


@Test
public void testCreate(){
	cdao.creat(c);
	cdao.creat(c1);
	o1.setCompte(co);
	o2.setCompte(co);
	
	odao.creat(o1);
	odao.creat(o2);
	
 co = codao.findById(new Long(2));

	
}

@Test
public void testAffichage() throws Exception{
	for(Compte compte: codao.findByClient(new Long(2))){
		System.out.println(compte.toString());
		System.out.println();
		System.out.println("======= Operations =======");
		for(Operation operation:odao.findByNumCompte(compte.getNum()) ){
			System.out.println(operation.toString());

		}
		
		
	}
}


}
