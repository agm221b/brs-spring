package com.cg.BrsSpringBootMVC.dto;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

/**
 * @author Tejaswini
 * Description: Booking entity for Customer
 * Created On: 05/09/2019
 *
 */


@EntityListeners(AuditingEntityListener.class)
@Component("booking")
@Entity
@Table(name = "booking")
public class Booking {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "booking_id")
	private Integer bookingId;

	@DateTimeFormat(pattern="dd-MM-yyyy")
	@Column(name = "date_of_journey")
	private LocalDate dateOfJourney;

	@OneToOne(cascade = CascadeType.MERGE)
	private Bus bus;


	@OneToMany(cascade = CascadeType.MERGE,fetch = FetchType.EAGER)
	@JoinColumn(name = "passenger_fk")
	private List<Passenger> passengers;
	@Column(name = "mode_of_payment")
	private String modeOfPayment;
	@Column(name = "total_cost")
	@NotNull(message="cannot be empty")
	private Double totalCost;
	@Column(name = "booking_status")
	private String bookingStatus;
	@Column(name = "delete_flag")
	private Integer deleteFlag;

	@ManyToOne
	@JoinColumn(name="user_fk")
	private User user;
	
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

	public Booking() {

	}

	public Booking(Integer bookingId, LocalDate dateOfJourney, Bus bus, List<Passenger> passengers,
			String modeOfPayment, Double totalCost, String bookingStatus, Integer deleteFlag) {
		this.bookingId = bookingId;
		this.dateOfJourney = dateOfJourney;
		this.bus = bus;
		this.passengers = passengers;
		this.modeOfPayment = modeOfPayment;
		this.totalCost = totalCost;
		this.bookingStatus = bookingStatus;
		this.deleteFlag = deleteFlag;
	}

	public Integer getBookingId() {
		return bookingId;
	}

	public void setBookingId(Integer bookingId) {
		this.bookingId = bookingId;
	}

	public LocalDate getDateOfJourney() {
		return dateOfJourney;
	}

	public void setDateOfJourney(LocalDate dateOfJourney) {
		this.dateOfJourney = dateOfJourney;
	}

	public Bus getBus() {
		return bus;
	}

	public void setBus(Bus bus) {
		this.bus = bus;
	}

	public List<Passenger> getPassengers() {
		return passengers;
	}

	public void setPassengers(List<Passenger> passengers) {
		this.passengers = passengers;
	}

	public String getModeOfPayment() {
		return modeOfPayment;
	}

	public void setModeOfPayment(String modeOfPayment) {
		this.modeOfPayment = modeOfPayment;
	}

	public Double getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(Double totalCost) {
		this.totalCost = totalCost;
	}

	public String getBookingStatus() {
		return bookingStatus;
	}

	public void setBookingStatus(String bookingStatus) {
		this.bookingStatus = bookingStatus;
	}

	public Integer getDeleteFlag() {
		return deleteFlag;
	}

	public void setDeleteFlag(Integer deleteFlag) {
		this.deleteFlag = deleteFlag;
	}



	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Booking [bookingId=" + bookingId + ", dateOfJourney=" + dateOfJourney + ", bus=" + bus + ", modeOfPayment=" + modeOfPayment + ", totalCost=" + totalCost + ", bookingStatus="
				+ bookingStatus + ", deleteFlag=" + deleteFlag + "]";
	}


}
