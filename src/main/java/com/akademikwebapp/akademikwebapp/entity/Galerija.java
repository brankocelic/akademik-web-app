package com.akademikwebapp.akademikwebapp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "galerija")
public class Galerija {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "slika")
	private String slika;

	public Galerija() {

	}

	public Galerija(String slika) {
		this.slika = slika;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSlika() {
		return slika;
	}

	public void setSlika(String slika) {
		this.slika = slika;
	}

	@Override
	public String toString() {
		return "Galerija [id=" + id + ", slika=" + slika + "]";
	}

}
