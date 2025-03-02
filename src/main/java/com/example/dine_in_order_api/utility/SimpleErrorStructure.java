package com.example.dine_in_order_api.utility;


import lombok.Getter;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
public class SimpleErrorStructure {

    private String type;
    private int status;
    private String message;
}
