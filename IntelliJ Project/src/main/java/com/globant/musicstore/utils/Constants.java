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
}
