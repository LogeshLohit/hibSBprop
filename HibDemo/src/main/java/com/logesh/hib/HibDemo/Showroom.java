package com.logesh.hib.HibDemo;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Showroom")
public class Showroom {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	@Column(name = "location")
	private String showRoomLocation;

	@OneToMany(mappedBy = "showroom")
	// @JoinColumn(name = "showroom_id")
	private List<Car> cars;

	public List<Car> getCars() {
		return cars;
	}

	public void setCars(List<Car> cars) {
		this.cars = cars;
	}

	public Showroom(String showRoomLocation) {
		super();
		this.showRoomLocation = showRoomLocation;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getShowRoomLocation() {
		return showRoomLocation;
	}

	public void setShowRoomLocation(String showRoomLocation) {
		this.showRoomLocation = showRoomLocation;
	}

	

}
