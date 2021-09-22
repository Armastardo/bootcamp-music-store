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
    public static final String ITEM_ADDED_SUCCESSFULLY = "Item added successfully";
    public static final String ITEM_DELETED_SUCCESSFULLY = "Item disable succesfully";
    public static final String ITEM_UPDATED_SUCCESSFULLY = "Item updated succesfully";
    public static final String ITEM_IS_ALREADY_DISABLE = "Item is already disable";
    public static final String ITEMS_SHOWED_SUCCESSFULLY = "Items showed successfully";
    public static final String ITEM_DOES_NOT_EXIST = "Item doesn't exist";
}
