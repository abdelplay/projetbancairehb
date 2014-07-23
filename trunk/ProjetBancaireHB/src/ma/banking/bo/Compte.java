package ma.banking.bo;

import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Version;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
public class Compte {

	@Id
	@GeneratedValue
	private Long Id;
	@Column(length = 80)
	private String num;
	@Column(length = 80)
	private String Type;
	@Column(length = 80)
	private  Double solde;
	@ManyToOne
	@JoinColumn(name = "id_client")
	private Client client;
	@OneToMany(fetch = FetchType.LAZY, mappedBy="compte")
	private List<Operation> operations;
	
	
	
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public List<Operation> getOperations() {
		return operations;
	}
	public void setOperations(List<Operation> operations) {
		this.operations = operations;
	}
//	@Version
//	protected Integer version;
//

	
	public Compte(String num, String type, Double solde) {
		super();
		this.num = num;
		Type = type;
		this.solde = solde;
	}
	public Compte(Long id, String num, String type, Double solde) {
		super();
		Id = id;
		this.num = num;
		Type = type;
		this.solde = solde;
	}
	public Compte() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
	}
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	public String getType() {
		return Type;
	}
	public void setType(String type) {
		Type = type;
	}
	public Double getSolde() {
		return solde;
	}
	public void setSolde(Double solde) {
		this.solde = solde;
	}

//	public Integer getVersion() {
//		return version;
//	}
//	public void setVersion(Integer version) {
//		this.version = version;
//	}
	
	@Override
	public String toString() {
		return "Compte [Id=" + Id + ", num=" + num + ", Type=" + Type
				+ ", solde=" + solde + ", client=" + client.getId() +"]";
	}
	
	
	
	
}
