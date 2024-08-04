package core;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "admin")
public class Admin implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "uName", unique=true, nullable=false)
	private String uName;
	
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "user_id", unique=true)
	private int user_id;


	@Column(name = "password", nullable=false)
	private String password;


	public Admin() {

	}

//	public Admin(int user_id, String uName, String password) {
//		super();
//		this.user_id = user_id;
//		this.uName = uName;
//		this.password = password;
//	}
	public Admin(String uName, String password) {
		super();
		this.uName = uName;
		this.password = password;
	}


	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getName() {
		return uName;
	}

	public void setName(String uName) {
		this.uName = uName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}

