package com.bear.blogvillage.exception;

public class UserNotFoundException extends RuntimeException{

    static final long serialVersionUID = -7034897190745766959L;

    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public UserNotFoundException(String id){
        super("user is a sb");
        this.id = id;
    }
}
