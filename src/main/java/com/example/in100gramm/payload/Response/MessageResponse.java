package com.example.in100gramm.payload.Response;


import com.sun.xml.internal.ws.api.FeatureListValidatorAnnotation;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MessageResponse {
    private String message;
}
