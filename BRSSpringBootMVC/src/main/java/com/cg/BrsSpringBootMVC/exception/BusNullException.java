package com.cg.BrsSpringBootMVC.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author Aditya
 * Created: 8/10/19
 * Last Modified: 9/10/19
 * Description : Responds with error when Bus is not found
 */
@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR, reason = "Bus object is Null")
public class BusNullException extends Exception {
	
	
	private static final long serialVersionUID = 1786214146473340560L;

	/**
	 * @author Aditya
	 * Created: 8/10/19
	 * Last Modified: 9/10/19
	 * Description: Nonparameterized constructor for custom exception BRSException
	 */
	public BusNullException() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @author Aditya
	 * Created: 8/10/19
	 * Last Modified: 9/10/19
	 * Description: Parameterized constructor with custom message for custom exception BRSException
	 * @param message
	 */
	public BusNullException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

}
