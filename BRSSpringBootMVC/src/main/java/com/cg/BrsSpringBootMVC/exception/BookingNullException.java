package com.cg.BrsSpringBootMVC.exception;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR, reason = "Booking Object is Null")

public class BookingNullException extends Exception {


	private static final long serialVersionUID = -5283966661668912956L;

	public BookingNullException() {
		// TODO Auto-generated constructor stub
	}

	public BookingNullException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public BookingNullException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	public BookingNullException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public BookingNullException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

}
