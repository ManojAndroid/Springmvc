package com.bridgelabz.SpringMvcPro.Model;

import java.io.Serializable;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name ="UserRegistrationSpring")
public class UserRegistrationModel implements Serializable {
	private static final long serialVersionUID = 1L;

	public UserRegistrationModel() {
	}

	@Id
	@GenericGenerator(name = "reg", strategy ="increment")
	@GeneratedValue(generator = "reg")
	@Column(name = "ID")
	private int id;

	@Column(name = "NAME")
	private String name;

	@Column(name = "EMAIL")
	private String email;

	@Column(name = "MOBILNUMBER")
	private long mobilnumber;

	@Column(name = "PASSWORD")
	private String Password;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getMobilnumber() {
		return mobilnumber;
	}

	public void setMobilnumber(long mobilnumber) {
		this.mobilnumber = mobilnumber;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

}
