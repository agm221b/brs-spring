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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

@Component("bus")
@Entity
@Table(name = "bus")
public class Bus {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "bus_id")
	private Integer busId;

	@Column(name = "bus_name")
	@NotBlank(message="name required")
	@Size(min=3,max=20,message="Name should be between 3-20 characters")
	private String busName;

	@Column(name = "bus_type")
	@Enumerated(EnumType.STRING)
	@NotNull
	private BusType busType;

	@Column(name = "bus_class")
	@Enumerated(EnumType.STRING)
	@NotNull
	private BusClass busClass;

	@Column(name = "bus_source")
	@NotBlank(message="source required")
	private String source;

	@Column(name = "bus_destination")
	@NotBlank(message="destination required")
	private String destination;

	@Column(name = "no_of_seats")
	@NotNull(message="number of seats required")
	private Integer noOfSeats;

	@Column(name = "delete_flag")
	private Integer deleteFlag = 0;

	@DateTimeFormat(pattern = "HH:mm")
	@Column(name = "start_time")
	@NotNull(message="time validation to be done")
	private LocalTime startTime;

	@DateTimeFormat(pattern = "HH:mm")
	@Column(name = "end_time")
	@NotNull // end time validation to be done here
	private LocalTime endTime;

	@Column(name = "cost_per_seat")
	@NotNull(message=" cost per seat required")
	private Double costPerSeat;

	public Bus() {

	}

	public Bus(Integer busId, String busName, BusType busType, BusClass busClass, String source, String destination,
			Integer noOfSeats, Integer deleteFlag, LocalTime startTime, LocalTime endTime, Double costPerSeat) {
		this.busId = busId;
		this.busName = busName;
		this.busType = busType;
		this.busClass = busClass;
		this.source = source;
		this.destination = destination;
		this.noOfSeats = noOfSeats;
		this.deleteFlag = deleteFlag;
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

	public BusType getBusType() {
		return busType;
	}

	public void setBusType(BusType busType) {
		this.busType = busType;
	}

	public BusClass getBusClass() {
		return busClass;
	}

	public void setBusClass(BusClass busClass) {
		this.busClass = busClass;
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

	public void setDeleteFlag(Integer deleteFlag) {
		this.deleteFlag = deleteFlag;
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
	public String toString() {
		return "Bus [busId=" + busId + ", busName=" + busName + ", busType=" + busType + ", busClass=" + busClass
				+ ", source=" + source + ", destination=" + destination + ", noOfSeats=" + noOfSeats + ", deleteFlag="
				+ deleteFlag + ", startTime=" + startTime + ", endTime=" + endTime + ", costPerSeat=" + costPerSeat
				+ "]";
	}

	
}
