package ma.banking.bo;

import javax.persistence.*;
import javax.persistence.Column;
import javax.persistence.Version;



@Entity
public class Operation {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long Id;
	@Column(length = 80)
	private String ref;
	@Column(length = 80)
	private String type;
	@Column(name="SENS",length = 2)
	private String sens;
	@Column(length=80)
	private Double montant;
	@ManyToOne
	@JoinColumn(name="id_compte")
	private Compte compte;

	

	public Compte getCompte() {
		return compte;
	}
	public void setCompte(Compte compte) {
		this.compte = compte;
	}
	public Operation() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Operation(String ref, String type, String sens, Double montant) {
		super();
		this.ref = ref;
		this.type = type;
		this.sens = sens;
		this.montant = montant;
	}
	public Operation(Long id, String ref, String type, String sens,
			Double montant) {
		super();
		Id = id;
		this.ref = ref;
		this.type = type;
		this.sens = sens;
		this.montant = montant;
	}
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
	}
	public String getRef() {
		return ref;
	}
	public void setRef(String ref) {
		this.ref = ref;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getSens() {
		return sens;
	}
	public void setSens(String sens) {
		this.sens = sens;
	}
	public Double getMontant() {
		return montant;
	}
	public void setMontant(Double montant) {
		this.montant = montant;
	}
	
	@Override
	public String toString() {
		return "Operation [Id=" + Id + ", ref=" + ref + ", type=" + type
				+ ", sens=" + sens + ", montant=" + montant + ", compte=" + compte.getId() +  "]";
	}
	
	
	
	
	
}
