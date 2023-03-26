package org.example.Homework;

public class InvalidDataOrCommandException extends RuntimeException{
    public InvalidDataOrCommandException(String message) {
        super(message);
    }
}
