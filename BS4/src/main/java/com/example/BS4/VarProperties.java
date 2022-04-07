package com.example.BS4;

import lombok.Data;
import lombok.Getter;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConstructorBinding
@Data

public class VarProperties {
    @Value("${var1}")
    private String var1;

    @Value("${var2}")
    private Integer var2;


}
