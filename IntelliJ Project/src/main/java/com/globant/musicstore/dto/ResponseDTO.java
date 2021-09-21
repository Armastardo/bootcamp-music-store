package com.globant.musicstore.dto;

import com.globant.musicstore.utils.Constants;

public class ResponseDTO <T>{

    private Constants.ResponseConstants responseConstants;
    private String message;
    private T content;

    public ResponseDTO(){

    }

    public ResponseDTO(Constants.ResponseConstants responseConstants, String message, T content){
        this.responseConstants = responseConstants;
        this.message = message;
        this.content = content;

    }

    public Constants.ResponseConstants getResponseConstants() {
        return responseConstants;
    }

    public void setResponseConstants(Constants.ResponseConstants responseConstants) {
        this.responseConstants = responseConstants;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getContent() {
        return content;
    }

    public void setContent(T content) {
        this.content = content;
    }
}