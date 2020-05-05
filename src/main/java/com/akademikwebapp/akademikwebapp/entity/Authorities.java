package com.akademikwebapp.akademikwebapp.entity;




import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;

@Entity
@Table(name = "authorities")
public class Authorities {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "authority")
	private String authority;

//	@ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH,
//			CascadeType.REFRESH })
//
//	@JoinTable(name = "user_authorities", joinColumns = @JoinColumn(name = "authorities_id"), inverseJoinColumns = @JoinColumn(name = "users_username"))
//	public List<Users> users;

	public Authorities() {
	}

	

	public Authorities(String authority) {
		this.authority = authority;
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getAuthority() {
		return authority;
	}



	public void setAuthority(String authority) {
		this.authority = authority;
	}



	@Override
	public String toString() {
		return "Authorities [id=" + id + ", authority=" + authority + "]";
	}

}
