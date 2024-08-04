package core;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;


@Entity
@Table(name = "flights")
public class Flight implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "flight_id", unique=true)
	private int flight_id;

	@Column(name = "source_airport", nullable=false)
	private String source_airport;

	@Column(name = "destination", nullable=false)
	private String destination;

	@Column(name = "seats_available", nullable=false)
	private int seats_available;

	@Column(name = "airline", nullable=false)
	private String airline;

	@Column(name = "price", nullable=false)
	private int price;

	@Column(name = "departure_time", nullable=false)
	private String departure_time;

	@Column(name = "arrival_time", nullable=false)
	private String arrival_time;

	public Flight() {
		
	}
	
	public Flight(int flight_id, String source_airport, String destination, int seats_available, String airline, int price,
			String deptarture_time, String arrival_time) {
		super();
		this.flight_id = flight_id;
		this.source_airport = source_airport;
		this.destination = destination;
		this.seats_available = seats_available;
		this.airline = airline;
		this.price = price;
		this.departure_time = deptarture_time;
		this.arrival_time = arrival_time;
	}

	public Flight(String source_airport, String destination, int seats_available, String airline, int price,
			String deptarture_time, String arrival_time) {
		super();
		this.source_airport = source_airport;
		this.destination = destination;
		this.seats_available = seats_available;
		this.airline = airline;
		this.price = price;
		this.departure_time = deptarture_time;
		this.arrival_time = arrival_time;
	}
	
	public String getDeparture_time() {
		return departure_time;
	}

	public void setDeparture_time(String departure_time) {
		this.departure_time = departure_time;
	}

	public String getArrival_time() {
		return arrival_time;
	}

	public void setArrival_time(String arrival_time) {
		this.arrival_time = arrival_time;
	}

	public int getFlight_id() {
		return flight_id;
	}

	public void setFlight_id(int flight_id) {
		this.flight_id = flight_id;
	}

	public String getsource_airport() {
		return source_airport;
	}

	public void setsource_airport(String source_airport) {
		this.source_airport = source_airport;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public int getSeats_available() {
		return seats_available;
	}

	public void setseats_available(int seats_available) {
		this.seats_available = seats_available;
	}

	public String getAirline() {
		return airline;
	}

	public void setAirline(String airline) {
		this.airline = airline;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

}
