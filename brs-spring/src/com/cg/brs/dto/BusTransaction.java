package com.cg.brs.dto;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class BusTransaction {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "transaction_id")
	private Integer transactionId;
	@Column(name = "date")
	private LocalDate date;
	@Column(name = "available_seats")
	private Integer availableSeats;

	@OneToOne(cascade = CascadeType.ALL)
	private Bus bus;
	// private String transactionStatus;
	@Column(name = "delete_flag")
	private Integer deleteFlag;

	public BusTransaction() {

	}

	public BusTransaction(Integer transactionId, LocalDate date, Integer availableSeats, Bus bus, Integer deleteFlag) {
		super();
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((availableSeats == null) ? 0 : availableSeats.hashCode());
		result = prime * result + ((bus == null) ? 0 : bus.hashCode());
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((deleteFlag == null) ? 0 : deleteFlag.hashCode());
		result = prime * result + ((transactionId == null) ? 0 : transactionId.hashCode());
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
		BusTransaction other = (BusTransaction) obj;
		if (availableSeats == null) {
			if (other.availableSeats != null)
				return false;
		} else if (!availableSeats.equals(other.availableSeats))
			return false;
		if (bus == null) {
			if (other.bus != null)
				return false;
		} else if (!bus.equals(other.bus))
			return false;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (deleteFlag == null) {
			if (other.deleteFlag != null)
				return false;
		} else if (!deleteFlag.equals(other.deleteFlag))
			return false;
		if (transactionId == null) {
			if (other.transactionId != null)
				return false;
		} else if (!transactionId.equals(other.transactionId))
			return false;
		return true;
	}

}
