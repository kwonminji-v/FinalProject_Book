package com.kdt.bookvoyage.Common;

public class UserPasswordNotMatchException extends RuntimeException{
    public UserPasswordNotMatchException(String message){
        super(message);
    }
}
