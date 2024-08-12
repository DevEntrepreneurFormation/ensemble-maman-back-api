package com.ensemblemaman.api.exception;


import java.util.HashMap;
import java.util.Map;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.ensemblemaman.api.dto.ErrorEntity;

import jakarta.persistence.EntityNotFoundException;

@ControllerAdvice
public class ApplicationAdviceController {

     // retourne une erreur notFound si la ressource demandé n'est pas trouvé
    @ResponseStatus(BAD_REQUEST)
    @ExceptionHandler({EntityNotFoundException.class})
    public @ResponseBody ErrorEntity handleNotFoundExceptions(EntityNotFoundException exception) {
        return new ErrorEntity(null, exception.getMessage());
    }

    // retourne les erreurs des champs manquant dans les requetes de l'application
    @ResponseStatus(BAD_REQUEST)
    @ExceptionHandler({MethodArgumentNotValidException.class})
    public @ResponseBody ErrorEntity handleValidationExceptions(
    MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return new ErrorEntity(errors, null);
    }
}
