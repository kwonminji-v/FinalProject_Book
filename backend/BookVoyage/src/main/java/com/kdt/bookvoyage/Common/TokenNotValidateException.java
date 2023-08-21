package com.kdt.bookvoyage.Common;

public class TokenNotValidateException extends RuntimeException{
    public TokenNotValidateException(String message){
        super(message);
    }
}
