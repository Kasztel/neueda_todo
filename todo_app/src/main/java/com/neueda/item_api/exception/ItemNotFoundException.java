package com.neueda.item_api.exception;

public class ItemNotFoundException extends RuntimeException{
    public String getParam() {
        return param;
    }

    public void setParam(String param) {
        this.param = param;
    }

    public String param;

    public ItemNotFoundException(String param){
        super(param);
    }
}
