package com.kdt.bookvoyage.Common;

public class UserIdNotFoundException extends RuntimeException{
    public UserIdNotFoundException(String message){
        super(message);
    }
}
