package co.com.dfsotop.calculator.utils;

import co.com.dfsotop.calculator.operator.IOperator;
import co.com.dfsotop.calculator.operator.OperatorEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OperatorBuilder {

    private IOperator plusOperator;

    public IOperator getOperator(OperatorEnum operatorEnum) {
        if (operatorEnum.getValue().equalsIgnoreCase(OperatorEnum.SUM.getValue())) {
            return plusOperator;
        }else {
            throw new IllegalArgumentException("Invalid operator (or not implemented yet)");
        }
    }

    @Autowired
    public void setPlusOperator(IOperator plusOperator) {
        this.plusOperator = plusOperator;
    }
}
