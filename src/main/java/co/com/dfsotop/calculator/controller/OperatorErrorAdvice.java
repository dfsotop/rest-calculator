package co.com.dfsotop.calculator.controller;

import co.com.dfsotop.calculator.operator.OperatorEnum;
import org.springframework.core.convert.ConversionFailedException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.Arrays;

@ControllerAdvice(assignableTypes = OperationController.class)
        public class OperatorErrorAdvice {

    @ExceptionHandler({HttpMessageNotReadableException.class})
    public final ResponseEntity<String> handleException(Exception ex, WebRequest request) {
        return new ResponseEntity<>("Input is not a number", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({ConversionFailedException.class})
    public final ResponseEntity<String> handleEnumException(Exception ex, WebRequest request) {
        return new ResponseEntity<>("Invalid operator. Allowed operators are: "+ Arrays.toString(OperatorEnum.values()) , HttpStatus.BAD_REQUEST);
    }
}
