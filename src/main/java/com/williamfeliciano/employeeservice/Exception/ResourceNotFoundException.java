package com.williamfeliciano.employeeservice.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException{

    private String resouceName;
    private String fieldName;
    private Long fieldValue;

    private String field;

    public ResourceNotFoundException(String resouceName, String fieldName, Long fieldValue) {
        super(String.format("%s not found with %s : '%s'", resouceName,fieldName,fieldValue));
        this.resouceName = resouceName;
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }

    public ResourceNotFoundException(String resouceName, String fieldName, String fieldValue) {
        super(String.format("%s not found with %s : '%s'", resouceName,fieldName,fieldValue));
        this.resouceName = resouceName;
        this.fieldName = fieldName;
        this.field= fieldValue;
    }
}
