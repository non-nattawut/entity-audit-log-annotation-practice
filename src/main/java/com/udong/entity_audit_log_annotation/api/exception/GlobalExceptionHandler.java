package com.udong.entity_audit_log_annotation.api.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler
    public ResponseEntity<String> globalExceptionHandler(Exception e){
        e.printStackTrace();
        return ResponseEntity.badRequest().body(e.getMessage());
    }
}
