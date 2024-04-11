package sancrisxa.com.br.testejava.Exceptions;

import jakarta.validation.UnexpectedTypeException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.MethodArgumentNotValidException;

import org.springframework.web.bind.annotation.ControllerAdvice;
import sancrisxa.com.br.testejava.Exceptions.customs.PedidoMaximoExcedidoException;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<StandardError> methodArgumentNotValidException(MethodArgumentNotValidException e) {
        ValidationError error = new ValidationError(System.currentTimeMillis(),
                HttpStatus.BAD_REQUEST.value(), "Erro na validação dos campos!");

        for(FieldError fieldError : e.getBindingResult().getFieldErrors()) {
            error.addError(fieldError.getField(), fieldError.getDefaultMessage());
        }

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }

    @ExceptionHandler(UnexpectedTypeException.class)
    public ResponseEntity<StandardError> unexpectedTypeException(UnexpectedTypeException e) {
        StandardError error = new StandardError(System.currentTimeMillis(),
                HttpStatus.BAD_REQUEST.value(), e.getMessage());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }

    @ExceptionHandler(PedidoMaximoExcedidoException.class)
    public ResponseEntity<StandardError> pedidoMaximoExcedidoException(PedidoMaximoExcedidoException e) {
        StandardError error = new StandardError(System.currentTimeMillis(),
                HttpStatus.BAD_REQUEST.value(), e.getMessage());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<StandardError> dataIntegrityViolationException(DataIntegrityViolationException e) {
        StandardError error = new StandardError(System.currentTimeMillis(),
                HttpStatus.BAD_REQUEST.value(), "Numero controle não poder ser duplicado.");

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }


}
