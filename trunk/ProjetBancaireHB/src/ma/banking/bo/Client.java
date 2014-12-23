package ma.banking.bo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
public class Client {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long Id;
	@Column(length = 80)
	private String CIN;
	@Column(length = 80)
	private String nom;
	@Temporal(TemporalType.DATE)
	private Date dateNaiss;
	@OneToMany(fetch=FetchType.LAZY, mappedBy="client",orphanRemoval=true)
	@Cascade(value = { CascadeType.SAVE_UPDATE, CascadeType.DELETE })
	private List<Compte> comptes;


	public Client(String cIN, String nom, Date dateNaiss) {
		super();
		CIN = cIN;
		this.nom = nom;
		this.dateNaiss = dateNaiss;
	}
	public Client() {
		super();
	}
	public Client(Long id, String cIN, String nom, Date dateNaiss) {
		super();
		Id = id;
		CIN = cIN;
		this.nom = nom;
		this.dateNaiss = dateNaiss;
	}
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
	}
	public String getCIN() {
		return CIN;
	}
	public void setCIN(String cIN) {
		CIN = cIN;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public Date getDateNaiss() {
		return dateNaiss;
	}
	public void setDateNaiss(Date dateNaiss) {
		this.dateNaiss = dateNaiss;
	}
	
	public List<Compte> getComptes() {
		return comptes;
	}
	public void setComptes(List<Compte> comptes) {
		this.comptes = comptes;
	}
	
	@Override
	public String toString() {
		return "Client [Id=" + Id + ", CIN=" + CIN + ", nom=" + nom
				+ ", dateNaiss=" + dateNaiss +  "]";
	}

}
