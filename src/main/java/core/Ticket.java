package core;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;


@Entity
@Table(name = "tickets")
public class Ticket implements Serializable{


	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ticket_id", unique=true, nullable=false)
	protected int ticket_id;
	
	@Column(name = "fname", nullable=false)
	private String fname;
	
	@Column(name = "lname", nullable=false)
	private String lname;
	
	@Column(name = "passenger_id", nullable=false)
	private int passenger_id;
	
	@Column(name = "flight_id", unique=true)
	private int flight_id;

	@Column(name = "quantity", nullable=false)
	private int quantity;
	
	@Column(name = "price", nullable=false)
	private int price;
	
	@Column(name = "status", nullable = true)
	private String status;
	
	public Ticket () {
		
	}
	public Ticket(String fname, String lname, int passenger_id, int flight_id, int quantity, int price, String status) {
		this.fname = fname;
		this.lname = lname;
		this.passenger_id = passenger_id;
		this.flight_id = flight_id;
		this.quantity = quantity;
		this.price = price;
		this.status = status;
	}
	
	public Ticket(int ticket_id, String fname, String lname, int flight_id, int quantity, int price, String status) {
		super();
		this.ticket_id = ticket_id;
		this.fname = fname;
		this.lname = lname;
		this.flight_id = flight_id;
		this.quantity = quantity;
		this.price = price;
		this.status = status;
	}
	

	public int getId() {
		return ticket_id;
	}

	public void setId(int ticket_id) {
		this.ticket_id = ticket_id;
	}
	
	public String getfname() {
		return fname;
	}

	public void setfname(String fname) {
		this.fname = fname;
	}
	
	public String getlname() {
		return lname;
	}

	public void setlname(String lname) {
		this.lname = lname;
	}
	
	public int getPassenger_id() {
		return passenger_id;
	}

	public void setPassenger_id(int passenger_id) {
		this.passenger_id = passenger_id;
	}

	public int getFlight_id() {
		return flight_id;
	}

	public void setFlight_id(int flight_id) {
		this.flight_id = flight_id;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public void setPrice(int price) {
		this.price = price;
	}
	
	public int getPrice() {
		return price;
	}
	
	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
}