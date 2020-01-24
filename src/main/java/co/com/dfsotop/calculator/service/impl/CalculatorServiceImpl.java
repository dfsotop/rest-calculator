package co.com.dfsotop.calculator.service.impl;

import co.com.dfsotop.calculator.operator.IOperator;
import co.com.dfsotop.calculator.operator.OperatorEnum;
import co.com.dfsotop.calculator.service.ICalculatorService;
import co.com.dfsotop.calculator.service.ISessionService;
import co.com.dfsotop.calculator.utils.OperatorBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Service
public class CalculatorServiceImpl implements ICalculatorService  {

    private static final Logger LOGGER = LoggerFactory.getLogger(CalculatorServiceImpl.class);

    private ISessionService sessionService;
    private OperatorBuilder operatorBuilder;

    @Override
    public UUID getSessionId() {
        return sessionService.getNewSession();
    }

    public Number addOperand(UUID sessionId, Number operand) {
        List<Number> operandsList = sessionService.getOperandsList(sessionId);
        return this.addOperand(sessionId,operandsList,operand);
    }

    private Number addOperand(UUID sessionId, List<Number> operandsList, Number operand) {
        operandsList.add(operand);
        sessionService.saveOperandList(sessionId,operandsList);
        String list = Arrays.toString(operandsList.toArray());
        LOGGER.info("Array: {}", list);
        return operand;
    }

    public Number getResult(UUID sessionId, OperatorEnum operatorEnum) {
        IOperator operator = operatorBuilder.getOperator(operatorEnum);
        List<Number> operandsList = sessionService.getOperandsList(sessionId);
        Number result = operator.operate(operandsList);
        operandsList.clear();
        this.addOperand(sessionId, operandsList, result);
        LOGGER.info("result: {}", result);
        return result;
    }

    @Autowired
    public void setOperatorBuilder(OperatorBuilder operatorBuilder) {
        this.operatorBuilder = operatorBuilder;
    }

    @Autowired
    public void setSessionService(ISessionService sessionService) {
        this.sessionService = sessionService;
    }
}
