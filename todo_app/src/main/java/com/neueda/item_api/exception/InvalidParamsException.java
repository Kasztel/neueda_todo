package com.neueda.item_api.exception;

public class InvalidParamsException extends RuntimeException{
    public String getParam() {
        return param;
    }

    public void setParam(String param) {
        this.param = param;
    }

    public String param;
    public InvalidParamsException(String param){
        super(param);
    }
}
