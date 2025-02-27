package com.example.dine_in_order_api.utility;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReponseStructure<T> {

    private int status;
    private String message;
    private T data;

    public static <T> ReponseStructure<T> create(HttpStatus status, String message, T data){
        ReponseStructure<T> reponse = new ReponseStructure();
        reponse.status= status.value();
        reponse.message=message;
        reponse.data=data;

        return reponse;
    }

}
