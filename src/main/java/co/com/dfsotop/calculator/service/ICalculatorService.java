package co.com.dfsotop.calculator.service;

import co.com.dfsotop.calculator.operator.OperatorEnum;

public interface ICalculatorService {

    Number addOperand(Number operand);
    Number getResult(OperatorEnum operatorEnum);
}
