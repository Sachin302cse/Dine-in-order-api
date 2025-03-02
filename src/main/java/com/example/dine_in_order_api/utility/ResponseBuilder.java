package com.example.dine_in_order_api.utility;


import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

public class ResponseBuilder {

    public static <T> ResponseEntity<ResponseStructure<T>> success(HttpStatus status ,String message , T data){

                ResponseStructure<T> structure = ResponseStructure.<T>builder()
                .status(status.value())
                .message(message)
                .data(data)
                .build();

        return ResponseEntity.status(status)
                .body(structure);

    }

    public static <T> ResponseEntity<ResponseStructure<T>> success(HttpStatus status, HttpHeaders header, String message , T data){

        ResponseStructure<T> structure = ResponseStructure.<T>builder()
                .status(status.value())
                .message(message)
                .data(data)
                .build();

        return ResponseEntity.status(status)
                .headers(header)
                .body(structure);

    }

    public static ResponseEntity<SimpleErrorStructure> error(HttpStatus httpStatus, String message) {

        SimpleErrorStructure error = SimpleErrorStructure.builder()
                .type(httpStatus.name())
                .message(message)
                .status(httpStatus.value())
                .build();

        return ResponseEntity.status(httpStatus)
                .body(error);

    }

    public static ResponseEntity<FieldErrorResponse> error(HttpStatus status , String message, List<FieldErrorResponse.CustomFieldError> errors)
    {
        FieldErrorResponse error = FieldErrorResponse.builder()
                .type(status.name())
                .message(message)
                .errors(errors)
                .build();

        return ResponseEntity.status(status)
                .body(error);
    }
}
