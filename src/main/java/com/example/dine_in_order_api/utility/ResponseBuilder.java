package com.example.dine_in_order_api.utility;

import com.sun.net.httpserver.Headers;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;

public class ResponseBuilder {

    public static <T> ResponseEntity<ReponseStructure<T>> success(HttpStatus status ,String message , T data){

                ReponseStructure<T> structure = ReponseStructure.<T>builder()
                .status(status.value())
                .message(message)
                .data(data)
                .build();

        return ResponseEntity.status(status)
                .body(structure);

    }

    public static <T> ResponseEntity<ReponseStructure<T>> success(HttpStatus status, HttpHeaders header, String message , T data){

        ReponseStructure<T> structure = ReponseStructure.<T>builder()
                .status(status.value())
                .message(message)
                .data(data)
                .build();

        return ResponseEntity.status(status)
                .headers(header)
                .body(structure);

    }

}
