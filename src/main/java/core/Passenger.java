package core;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="passenger")
public class Passenger implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id", unique=true)
	private int user_id;
	

	@Column(name = "email", unique=true, nullable=false)
	private String email;

	
	@Column(name = "fname", nullable=false)
	private String fname;

	@Column(name = "lname", nullable=false)
	private String lname;



	public Passenger(int user_id, String fname, String lname, String email) {
		super();
		this.user_id = user_id;
		this.fname = fname;
		this.lname = lname;
		this.email = email;
		
	}
	
	public Passenger(String fname, String lname, String email) {
		super();
		this.fname = fname;
		this.lname = lname;
		this.email = email;
		
	}

	public Passenger () {

	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}


	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}



}
