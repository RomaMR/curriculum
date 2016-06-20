package com.curriculum.web.handler;

import com.curriculum.dto.exception.ExceptionDTO;
import com.curriculum.exception.AuthenticationException;
import com.curriculum.exception.BadRequestException;
import com.curriculum.exception.ContentNotFoundException;
import com.curriculum.exception.UnauthorizedException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ContentNotFoundException.class)
    public ResponseEntity<ExceptionDTO> contentNotFound(ContentNotFoundException e){
        ExceptionDTO exceptionDTO = new ExceptionDTO(e.getValue(), HttpStatus.NOT_FOUND.value());
        return new ResponseEntity<>(exceptionDTO, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ExceptionDTO> badRequest(BadRequestException e){
        ExceptionDTO exceptionDTO = new ExceptionDTO(e.getValue(), HttpStatus.BAD_REQUEST.value());
        return new ResponseEntity<>(exceptionDTO, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(UnauthorizedException.class)
    public ResponseEntity<ExceptionDTO> unauthorized(UnauthorizedException e){
        ExceptionDTO exceptionDTO = new ExceptionDTO(e.getValue(), HttpStatus.UNAUTHORIZED.value());
        return new ResponseEntity<>(exceptionDTO, HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(AuthenticationException.class)
    public ResponseEntity<ExceptionDTO> unauthorized(AuthenticationException e){
        ExceptionDTO exceptionDTO = new ExceptionDTO(e.getValue(), HttpStatus.BAD_REQUEST.value());
        return new ResponseEntity<>(exceptionDTO, HttpStatus.BAD_REQUEST);
    }

}
