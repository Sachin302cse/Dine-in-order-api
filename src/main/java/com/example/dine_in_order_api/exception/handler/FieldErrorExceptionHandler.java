package com.example.dine_in_order_api.exception.handler;

import com.example.dine_in_order_api.utility.FieldErrorResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class FieldErrorExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                   HttpHeaders headers, HttpStatusCode status,
                                                                   WebRequest request){

        List<FieldErrorResponse.CustomFieldError> error = new ArrayList<>();
        List<ObjectError> objectErrors = ex.getAllErrors();

        for(ObjectError objectError : objectErrors)
        {
            FieldError fieldError = (FieldError) objectError;
          String message = objectError.getDefaultMessage();
          Object rejectedValue = ((FieldError) objectError).getRejectedValue();
          String field = ((FieldError) objectError).getField();

          FieldErrorResponse.CustomFieldError customFieldError = FieldErrorResponse.createFieldError(message ,
                    rejectedValue,field);

          error.add(customFieldError);

        }
        FieldErrorResponse response = createFieldErrorResponse(status,error);

        return ResponseEntity.status(status).body(response);
    }

    private FieldErrorResponse createFieldErrorResponse(HttpStatusCode status, List<FieldErrorResponse.CustomFieldError> errors) {
        FieldErrorResponse fieldErrorResponse= FieldErrorResponse.builder()
                .type(status.toString())
                .status(status.value())
                .message("Invalid Input")
                .errors(errors)
                .build();
        return fieldErrorResponse;
    }


}
