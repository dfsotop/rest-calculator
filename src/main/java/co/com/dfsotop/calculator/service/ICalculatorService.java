package co.com.dfsotop.calculator.service;

import co.com.dfsotop.calculator.operator.OperatorEnum;

import java.util.UUID;

public interface ICalculatorService {

    UUID getSessionId();
    Number addOperand(UUID sessionId, Number operand);
    Number getResult(UUID sessionId, OperatorEnum operatorEnum);
}
