package com.cg.BrsSpringBootMVC.dto;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Component("bus_transaction")
@Entity
@Table(name="bus_transaction")
public class BusTransaction {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "transaction_id")
	private Integer transactionId;
	@DateTimeFormat(pattern="dd-MM-yyyy")
	@Column(name = "journey_date")
	@NotNull 
	private LocalDate date;
	@Column(name = "available_seats")
	@NotNull(message= "seats required")
	@Min(0)@Max(40)
	private Integer availableSeats;
	@JsonIgnore
	@OneToOne(cascade = CascadeType.ALL)
	private Bus bus;
	// private String transactionStatus;
	@Column(name = "delete_flag")
	private Integer deleteFlag;

	public BusTransaction() {

	}

	public BusTransaction(Integer transactionId, LocalDate date, Integer availableSeats, Bus bus, Integer deleteFlag) {
		this.transactionId = transactionId;
		this.date = date;
		this.availableSeats = availableSeats;
		this.bus = bus;
		this.deleteFlag = deleteFlag;
	}

	public Integer getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(Integer transactionId) {
		this.transactionId = transactionId;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public Integer getAvailableSeats() {
		return availableSeats;
	}

	public void setAvailableSeats(Integer availableSeats) {
		this.availableSeats = availableSeats;
	}

	public Bus getBus() {
		return bus;
	}

	public void setBus(Bus bus) {
		this.bus = bus;
	}

	public Integer getDeleteFlag() {
		return deleteFlag;
	}

	public void setDeleteFlag(Integer deleteFlag) {
		this.deleteFlag = deleteFlag;
	}

	@Override
	public String toString() {
		return "BusTransaction [transactionId=" + transactionId + ", date=" + date + ", availableSeats="
				+ availableSeats + ", bus=" + bus + ", deleteFlag=" + deleteFlag + "]";
	}

	

}
