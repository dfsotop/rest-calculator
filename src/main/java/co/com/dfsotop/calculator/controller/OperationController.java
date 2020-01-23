package co.com.dfsotop.calculator.controller;

import co.com.dfsotop.calculator.operator.OperatorEnum;
import co.com.dfsotop.calculator.service.ICalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/operation")
public class OperationController {

    private ICalculatorService calculatorService;

    @PostMapping
    public Number setOperand(@RequestBody @Valid Number operand) {
        return calculatorService.addOperand(operand);
    }

    @GetMapping
    public Number setOperator(@RequestParam("operator") @Valid OperatorEnum operator) {
        return calculatorService.getResult(operator);
    }

    @Autowired
    public void setCalculatorService(ICalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

}
