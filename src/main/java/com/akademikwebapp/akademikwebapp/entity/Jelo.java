package com.akademikwebapp.akademikwebapp.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "jelo")
public class Jelo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "vrsta_jela")
	private String vrstaJela;

	@Column(name = "naziv_jela")
	private String nazivJela;

	@Column(name = "cijena")
	private double cijena;

	@Column(name = "slika")
	private String slika;

	
	@OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	@JoinColumn(name="jelo_id")
	private List<Galerija>galerija;

	public Jelo() {
	}

	public Jelo(String vrstaJela, String nazivJela, double cijena, String slika) {
		this.vrstaJela = vrstaJela;
		this.nazivJela = nazivJela;
		this.cijena = cijena;
		this.slika = slika;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getVrstaJela() {
		return vrstaJela;
	}

	public void setVrstaJela(String vrstaJela) {
		this.vrstaJela = vrstaJela;
	}

	public String getNazivJela() {
		return nazivJela;
	}

	public void setNazivJela(String nazivJela) {
		this.nazivJela = nazivJela;
	}

	public double getCijena() {
		return cijena;
	}

	public void setCijena(double cijena) {
		this.cijena = cijena;
	}

	public String getSlika() {
		return slika;
	}

	public void setSlika(String slika) {
		this.slika = slika;
	}

	
	
	public List<Galerija> getGalerija() {
		return galerija;
	}

	public void setGalerija(List<Galerija> galerija) {
		this.galerija = galerija;
	}
	
	public void addGalerija(Galerija theGalerija) {
		
		if (galerija == null) {
			galerija = new ArrayList<>();
		}
		
		galerija.add(theGalerija);
	}


	@Override
	public String toString() {
		return "Jelovnik [id=" + id + ", vrstaJela=" + vrstaJela + ", nazivJela=" + nazivJela + ", cijena=" + cijena
				+ ", slika=" + slika + "]";
	}

}
