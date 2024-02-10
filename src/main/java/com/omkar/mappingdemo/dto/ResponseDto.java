package com.omkar.mappingdemo.dto;

import lombok.Data;

@Data
public class ResponseDto {
    private int status;
    private String message;
    private Object data;
    public ResponseDto(int status, String message, Object data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }
    
}