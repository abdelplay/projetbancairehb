package ma.banking;

import java.util.ArrayList;
import java.util.Date;
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

public class MainClass {

	
	public static void main(String[] args) {
		
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
	
		Compte co1 = new Compte();
		Compte co2 = new Compte();
		Compte co3 = new Compte();
		
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
		
		cdao.creat(c);
		cdao.creat(c1);
		
		
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
		
		
		Compte co = codao.findById(new Long(2));

		o1.setCompte(co);
		o2.setCompte(co);
		
		odao.creat(o1);
		odao.creat(o2);

		
		
		
//		for(Compte compte: codao.findByClient(new Long(3))){
//			System.out.println(compte.toString());
//			System.out.println();
//			//System.out.println("======= Operations =======");
//			for(Operation operation:odao.findByNumCompte(compte.getNum()) ){
//				System.out.println(operation.toString());
//	
//			}
//			System.out.println();
//		}
//		
//		
//		o1 = odao.findById(new Long(3));
//		o1.setMontant(8000.00);
//		o1.setRef("KZ47898");
//		o1.setType("VIRM");
//		odao.update(o1);
//		
//		for(Operation operation:odao.retrieve()){
//			System.out.println(operation.toString());
//
//		}
		
//		o1.setId(new Long(5));
//		odao.delete(o1);
		
//		c1.setId(new Long(2));
//		cdao.delete(c1);
		
//	for(Client cli: cdao.retrieve()){
//		System.out.println();
//		System.out.println("======= Clients =======");
//		System.out.println(cli.toString());
//		System.out.println();
//		System.out.println("======= Comptes =======");
////		for(Compte compte: cli.getComptes()){
////			System.out.println(compte.toString());
////			System.out.println();
////			System.out.println("======= Operations =======");
////			for(Operation operation:odao.findByNumCompte(compte.getNum()) ){
////				System.out.println(operation.toString());
////	
////			}
////			
////		}
//		
		for(Compte compte: codao.findByClient(new Long(5))){
			System.out.println(compte.toString());
			System.out.println();
			System.out.println("======= Operations =======");
			for(Operation operation:odao.findByNumCompte(compte.getNum()) ){
				System.out.println(operation.toString());
	
			}
			
		}
	
	
	}
}
