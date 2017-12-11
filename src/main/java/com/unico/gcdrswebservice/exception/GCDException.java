package com.unico.gcdrswebservice.exception;
/**
 * This class contains GCDException for GCD Service
 * @Operations: getErrorMessage
 * @Developer: Vikas Malviya
 */
	public class GCDException extends Exception {

		private static final long serialVersionUID = 1L;
		private String errorMessage;

		public GCDException(String errorMessage) {
			    super(errorMessage);
			     this.errorMessage = errorMessage;
		}
		public GCDException() {
			     super();
		}
		  

	
	
}
