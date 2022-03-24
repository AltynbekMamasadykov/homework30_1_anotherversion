package com.company.exceptions;

public class ThatIdIsAlreadyInUse extends RuntimeException{
    public ThatIdIsAlreadyInUse(){

    }

    public ThatIdIsAlreadyInUse(String message)
    {
        super(message);
    }

}
