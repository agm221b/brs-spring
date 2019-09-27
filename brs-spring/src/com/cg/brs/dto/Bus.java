package com.cg.brs.dto;

import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "bus")
public class Bus {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer busId;

	@Column(name = "bus_name")
	private String busName;

	@Column(name = "bus_type")
	@Enumerated(EnumType.STRING)
	private BusType busType;

	@Enumerated(EnumType.STRING)
	@Column(name = "bus_class")
	private BusClass busClass;

	@Column(name = "source")
	private String source;

	@Column(name = "destination")
	private String destination;

	@Column(name = "no_of_seats")
	private Integer noOfSeats;

	@Column(name = "delete_flag")
	private Integer deleteFlag = 0;

	@Column(name = "start_time")
	private LocalTime startTime;

	@Column(name = "end_time")
	private LocalTime endTime;

	@Column(name = "cost_per_seat")
	private Double costPerSeat;

	public Bus() {

	}

	public Bus(Integer busId, String busName, String busType, String busClass, String source, String destination,
			Integer noOfSeats, Integer delete_flag, LocalTime startTime, LocalTime endTime, Double costPerSeat) {
		super();
		this.busId = busId;
		this.busName = busName;
		this.busType = BusType.valueOf(busType);
		this.busClass = BusClass.valueOf(busClass);
		this.source = source;
		this.destination = destination;
		this.noOfSeats = noOfSeats;
		this.deleteFlag = delete_flag;
		this.startTime = startTime;
		this.endTime = endTime;
		this.costPerSeat = costPerSeat;
	}

	public Integer getBusId() {
		return busId;
	}

	public void setBusId(Integer busId) {
		this.busId = busId;
	}

	public String getBusName() {
		return busName;
	}

	public void setBusName(String busName) {
		this.busName = busName;
	}

	public String getBusType() {
		return busType.toString();
	}

	public void setBusType(String busType) {
		this.busType = BusType.valueOf(busType.toUpperCase());
	}

	public String getBusClass() {
		return busClass.toString();
	}

	public void setBusClass(String busClass) {
		this.busClass = BusClass.valueOf(busClass.toUpperCase());
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public Integer getNoOfSeats() {
		return noOfSeats;
	}

	public void setNoOfSeats(Integer noOfSeats) {
		this.noOfSeats = noOfSeats;
	}

	public Integer getDeleteFlag() {
		return deleteFlag;
	}

	public void setDelete_flag(Integer delete_flag) {
		this.deleteFlag = delete_flag;
	}

	public LocalTime getStartTime() {
		return startTime;
	}

	public void setStartTime(LocalTime startTime) {
		this.startTime = startTime;
	}

	public LocalTime getEndTime() {
		return endTime;
	}

	public void setEndTime(LocalTime endTime) {
		this.endTime = endTime;
	}

	public Double getCostPerSeat() {
		return costPerSeat;
	}

	public void setCostPerSeat(Double costPerSeat) {
		this.costPerSeat = costPerSeat;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((busId == null) ? 0 : busId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Bus other = (Bus) obj;
		if (busId == null) {
			if (other.busId != null)
				return false;
		} else if (!busId.equals(other.busId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Bus [busId=" + busId + ", busName=" + busName + ", busType=" + busType + ", busClass=" + busClass
				+ ", source=" + source + ", destination=" + destination + ", noOfSeats=" + noOfSeats + ", deleteFlag="
				+ deleteFlag + ", startTime=" + startTime + ", endTime=" + endTime + ", costPerSeat=" + costPerSeat
				+ "]";
	}

}
