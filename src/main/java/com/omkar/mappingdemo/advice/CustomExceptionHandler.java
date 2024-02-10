package com.omkar.mappingdemo.advice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.omkar.mappingdemo.dto.ResponseDto;
import com.omkar.mappingdemo.exception.CityNotFoundException;
import com.omkar.mappingdemo.exception.CountryNotFoundException;
import com.omkar.mappingdemo.exception.StateNotFoundException;

@RestControllerAdvice
public class CustomExceptionHandler {
    
    @ResponseStatus(code = HttpStatus.NOT_FOUND)
    @ExceptionHandler
    public ResponseDto countryNotFoundExceptionHandler(CountryNotFoundException ex){
        return new ResponseDto(400, "FAILURE", ex.getMessage());
    }
    @ResponseStatus(code = HttpStatus.NOT_FOUND)
    @ExceptionHandler
    public ResponseDto StateNotFoundExceptionHandler(StateNotFoundException ex){
        return new ResponseDto(400, "FAILURE", ex.getMessage());
    }
    @ResponseStatus(code = HttpStatus.NOT_FOUND)
    @ExceptionHandler
    public ResponseDto CityNotFoundExceptionHandler(CityNotFoundException ex){
        return new ResponseDto(400, "FAILURE", ex.getMessage());
    }
}
