package com.globant.musicstore.utils;

public class IntInvoiceAlbumConstants {
	
	public enum ResponseConstants{
		SUCCESS("Successful"), FAILURE("Unsuccessful");
		
		private String description;
		
		ResponseConstants(final String description) {
			this.description = description;
		}
		
		public String getDescription() {
			return description;
		}
		 
	}
	
	public static final String INTINVOICEALBUM_ADDED_SUCCESSFULLY = "Invoice added to data base successfully";
	public static final String INTINVOICEALBUM_ADDED_ERROR = "Invoice was not added to data base";
	public static final String INTINVOICEALBUM_FOUNDED_SUCCESSFULLY = " The invoice was founded successfully";
	public static final String INTINVOICEALBUM_UPDATED_SUCCESSFULLY = " The invoice was updated successfully";
	public static final String INTINVOICEALBUM_DELETED_SUCCESSFULLY = " The invoice was deleted successfully";

}
