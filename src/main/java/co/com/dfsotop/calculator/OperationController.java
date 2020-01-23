package co.com.dfsotop.calculator;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/operation")
public class OperationController {

    @PostMapping("")
    public String setOperand(@RequestBody String operand) {
        return operand;
    }
    @PostMapping("/operator")
    public String setOperator(@RequestBody String operator) {
        return operator;
    }
}
