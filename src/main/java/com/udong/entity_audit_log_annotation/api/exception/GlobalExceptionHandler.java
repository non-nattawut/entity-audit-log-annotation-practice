package com.udong.entity_audit_log_annotation.api.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler
    public ResponseEntity<String> globalExceptionHandler(Exception e){
        return ResponseEntity.badRequest().body(e.getMessage());
    }
}
