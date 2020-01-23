package co.com.dfsotop.calculator.operator;

public enum OperatorEnum {
    SUM("sum"),
    SUBSTRACT("substract");

    private String operator;

    OperatorEnum(String operator) {
        this.operator = operator;
    }

    public String getValue() {
        return operator;
    }
}
