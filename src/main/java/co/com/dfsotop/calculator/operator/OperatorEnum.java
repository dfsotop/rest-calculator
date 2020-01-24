package co.com.dfsotop.calculator.operator;

public enum OperatorEnum {
    SUM("sum"),
    SUBTRACT("subtract"),
    PRODUCT("product");

    private String operator;

    OperatorEnum(String operator) {
        this.operator = operator;
    }

    public String getValue() {
        return operator;
    }
}
