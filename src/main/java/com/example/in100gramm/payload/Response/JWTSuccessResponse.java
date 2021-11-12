package com.example.in100gramm.payload.Response;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.boot.convert.DataSizeUnit;

@Data
@AllArgsConstructor
public class JWTSuccessResponse {
    private boolean success;
    private String token;

}
