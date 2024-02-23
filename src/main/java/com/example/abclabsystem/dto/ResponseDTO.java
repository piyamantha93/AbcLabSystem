package com.example.abclabsystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component

@Data
public class ResponseDTO {
    private String code;
    private String message;
    private Object content;

    public ResponseDTO() {
    }

    public ResponseDTO(String code, String message, Object content) {
        this.code = code;
        this.message = message;
        this.content = content;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getContent() {
        return content;
    }

    public void setContent(Object content) {
        this.content = content;
    }
}