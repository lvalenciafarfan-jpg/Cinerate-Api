package com.sistem.cinerate_api.exception.handler;

import com.sistem.cinerate_api.exception.custom.RecursoNoEncontradoException;
import com.sistem.cinerate_api.exception.custom.ReglaDeNegocioException;
import com.sistem.cinerate_api.exception.dto.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;


@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(RecursoNoEncontradoException.class)
    public ResponseEntity<ErrorResponse> handlerNotFound(RecursoNoEncontradoException ex){

        ErrorResponse error = new ErrorResponse(
                404, LocalDateTime.now(), ex.getMessage()
        );

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

    @ExceptionHandler(ReglaDeNegocioException.class)
    public ResponseEntity<ErrorResponse> handlerReglaNegocio(ReglaDeNegocioException ex){
        ErrorResponse error = new ErrorResponse(
                400, LocalDateTime.now(), ex.getMessage()
        );

        return ResponseEntity.badRequest().body(error);
    }
}

