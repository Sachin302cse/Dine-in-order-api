package com.example.dine_in_order_api.utility;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class SimpleErrorStructure {

    private String type;
    private int status;
    private String message;
}
