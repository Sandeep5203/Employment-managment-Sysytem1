package com.sandeep.ems.exceptions;

public class EmployeesNotExist extends Throwable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public EmployeesNotExist(String message) {
        super(message);
    }

	public EmployeesNotExist() {
		super();
		// TODO Auto-generated constructor stub
	}

	public EmployeesNotExist(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public EmployeesNotExist(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public EmployeesNotExist(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
}
