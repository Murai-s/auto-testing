package com.example.automation.api.models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Pet {

    @Builder.Default
    private long id = 0;

    private String name;

    @Builder.Default
    private String status = "available";
}
