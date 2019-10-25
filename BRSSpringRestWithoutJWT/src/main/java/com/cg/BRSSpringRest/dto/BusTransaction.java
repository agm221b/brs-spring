package com.cg.BRSSpringRest.dto;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

@EntityListeners(AuditingEntityListener.class)
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
	@NotNull // more date validation
	private LocalDate date;
	@Column(name = "available_seats")
	@NotNull(message= "seats required")
	@Min(0)@Max(40)
	private Integer availableSeats;

	@OneToOne(cascade = CascadeType.ALL)
	private Bus bus;
	// private String transactionStatus;
	@Column(name = "delete_flag")
	private Integer deleteFlag;
	
	@CreatedBy
    protected String createdBy;
    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    protected Date creationDate;
    @LastModifiedBy
    protected String lastModifiedBy;
    @LastModifiedDate
    @Temporal(TemporalType.TIMESTAMP)
    protected Date lastModifiedDate;
    
    public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public String getLastModifiedBy() {
		return lastModifiedBy;
	}

	public void setLastModifiedBy(String lastModifiedBy) {
		this.lastModifiedBy = lastModifiedBy;
	}

	public Date getLastModifiedDate() {
		return lastModifiedDate;
	}

	public void setLastModifiedDate(Date lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}

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
