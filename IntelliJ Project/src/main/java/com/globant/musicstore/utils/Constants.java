package com.globant.musicstore.utils;

public class Constants {

    public enum ResponseConstants {
        SUCCESS("Successful"), FAILURE("Unsuccessful");

        private String description;

        ResponseConstants(final String description) {
            this.description = description;
        }

        public String getDescription() {
            return description;
        }
    }

    public static final String CLIENT_ADDED_SUCCESSFULLY = "The client was added successfully";
    public static final String CLIENT_RETRIEVED_SUCCESSFULLY = "The client was retrieved successfully";
    public static final String ID_FOUNDED_SUCCESSFULLY = " The invoice was founded successfully";
    public static final String REPAYMENT_DELETED= "Repayment already deleted";
    public static final String ITEM_UPDATED_SUCCESSFULLY="ITEM_UPDATED_SUCCESSFULLY";
    public static final String ITEM_ADDED_SUCCESSFULLY= "ITEM_ADDED_SUCCESSFULLY";
    public static final String ITEM_ALREADY_DELETED="ITEM_ALREADY_DELETED";
    public static final String ITEM_IS_NOT_LOCATED=" ITEM_IS_NOT_LOCATED";
}
