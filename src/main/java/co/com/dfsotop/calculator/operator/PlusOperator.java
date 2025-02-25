package co.com.dfsotop.calculator.operator;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PlusOperator implements IOperator {

    @Override
    public Number operate(List<Number> operands) {
        return operands.parallelStream().map(Number::intValue).reduce(0, Integer::sum);
    }
}
