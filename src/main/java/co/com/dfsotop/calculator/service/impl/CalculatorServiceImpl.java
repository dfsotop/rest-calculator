package co.com.dfsotop.calculator.service.impl;

import co.com.dfsotop.calculator.operator.IOperator;
import co.com.dfsotop.calculator.operator.OperatorEnum;
import co.com.dfsotop.calculator.service.ICalculatorService;
import co.com.dfsotop.calculator.utils.OperatorBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CalculatorServiceImpl implements ICalculatorService {

    private List<Number> operandsList;
    private OperatorBuilder operatorBuilder;

    public CalculatorServiceImpl() {
        operandsList = new ArrayList<>();
    }

    public Number addOperand(Number operand) {
        operandsList.add(operand);
        return operand;
    }

    public Number getResult(OperatorEnum operatorEnum) {
        IOperator operator = operatorBuilder.getOperator(operatorEnum);
        Number result = operator.operate(operandsList);
        operandsList.clear();
        this.addOperand(result);
        return result;
    }

    @Autowired
    public void setOperatorBuilder(OperatorBuilder operatorBuilder) {
        this.operatorBuilder = operatorBuilder;
    }
}
