package co.com.dfsotop.calculator.utils;

import co.com.dfsotop.calculator.operator.IOperator;
import co.com.dfsotop.calculator.operator.OperatorEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OperatorBuilder {

    private IOperator plusOperator;
    private IOperator subtractionOperator;
    private IOperator productOperator;

    public IOperator getOperator(OperatorEnum operatorEnum) {
        IOperator operator;
        switch (operatorEnum) {
            case SUM:
                operator = plusOperator;
                break;
            case SUBTRACT:
                operator = subtractionOperator;
                break;
            case PRODUCT:
                operator = productOperator;
                break;
            default:
                throw new IllegalArgumentException("Invalid operator (or not implemented yet)");
        }
        return  operator;
    }

    @Autowired
    public void setPlusOperator(IOperator plusOperator) {
        this.plusOperator = plusOperator;
    }

    @Autowired
    public void setSubtractionOperator(IOperator subtractionOperator) {
        this.subtractionOperator = subtractionOperator;
    }

    @Autowired
    public void setProductOperator(IOperator productOperator) {
        this.productOperator = productOperator;
    }
}
