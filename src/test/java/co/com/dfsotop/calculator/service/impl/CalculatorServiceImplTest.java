package co.com.dfsotop.calculator.service.impl;

import co.com.dfsotop.calculator.operator.OperatorEnum;
import co.com.dfsotop.calculator.operator.PlusOperator;
import co.com.dfsotop.calculator.service.ISessionService;
import co.com.dfsotop.calculator.utils.OperatorBuilder;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;

public class CalculatorServiceImplTest {
    private UUID testUUID = UUID.randomUUID();
    private List<Number> mockList;
    @Mock
    private ISessionService sessionService;
    @Mock
    OperatorBuilder operatorBuilder;

    @InjectMocks
    CalculatorServiceImpl calculatorServiceImpl;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        mockList = new ArrayList<>();
        mockList.add(2);
        mockList.add(3);
    }

    @Test
    public void testAddOperand() {
        when(sessionService.getOperandsList(any())).thenReturn(new ArrayList<>());
        Number result = calculatorServiceImpl.addOperand(testUUID, 3);
        Assert.assertEquals(3, result);
    }

    @Test
    public void testGetResult() {

        when(operatorBuilder.getOperator(any())).thenReturn(new PlusOperator());
        when(sessionService.getOperandsList(any())).thenReturn(mockList);
        Number result = calculatorServiceImpl.getResult(testUUID, OperatorEnum.SUM);
        Assert.assertEquals(5, result);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme