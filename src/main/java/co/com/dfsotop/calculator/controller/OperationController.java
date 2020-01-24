package co.com.dfsotop.calculator.controller;

import co.com.dfsotop.calculator.operator.OperatorEnum;
import co.com.dfsotop.calculator.service.ICalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

@RestController
@RequestMapping("/operation")
public class OperationController {

    private ICalculatorService calculatorService;

    @GetMapping("/session")
    public ResponseEntity getNewSession() {
        return new ResponseEntity(calculatorService.getSessionId(), HttpStatus.CREATED);
    }

    @PostMapping
    public Number setOperand(@RequestHeader(value = "session-id") String sessionId, @RequestBody @Valid Number operand) {
        return calculatorService.addOperand(UUID.fromString(sessionId), operand);
    }

    @GetMapping
    public Number setOperator(@RequestHeader(value = "session-id") String sessionId, @RequestParam("operator") @Valid OperatorEnum operator) {
        return calculatorService.getResult(UUID.fromString(sessionId), operator);
    }

    @Autowired
    public void setCalculatorService(ICalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

}
