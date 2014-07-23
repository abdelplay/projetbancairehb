package ma.banking.bo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

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
