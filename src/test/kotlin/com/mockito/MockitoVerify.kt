package com.mockito

import org.assertj.core.api.Assertions.assertThat
import org.junit.Before
import org.junit.Ignore
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.ArgumentCaptor
import org.mockito.Captor
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner


@RunWith(MockitoJUnitRunner::class)
class MockitoVerify {

    private lateinit var calculator: Calculator

    @Mock lateinit var expression: Expression
    @Mock lateinit var operator: Operator

    @Captor lateinit var firstCaptor: ArgumentCaptor<Int>
    @Captor lateinit var secondCaptor: ArgumentCaptor<Int>

    @Captor lateinit var firstCaptorVariable: ArgumentCaptor<Variable>
    @Captor lateinit var secondCaptorVariable: ArgumentCaptor<Variable>

    @Captor lateinit var firstCaptorData: ArgumentCaptor<Data>
    @Captor lateinit var secondCaptorData: ArgumentCaptor<Data>

    @Before fun setUp() {
        calculator = CalculatorImpl(expression, operator)
    }

    @Test fun should_return_results() {
        `when`(expression.calc(1, 2)).then {  }

        calculator.calc(1, 2)

        verify(expression).calc(firstCaptor.capture(), secondCaptor.capture())

        assertThat(firstCaptor.value).isEqualTo(1)
        assertThat(secondCaptor.value).isEqualTo(2)
    }

    @Test @Ignore fun should_call_operation() {
        val a = object : Variable {
            override fun get(): Int = 0
        }

        val b = object : Variable {
            override fun get(): Int = 1
        }

        `when`(operator.operation(a, b)).then {  }

        calculator.operator(a, b)

        verify(operator).operation(firstCaptorVariable.capture(), secondCaptorVariable.capture())
    }

    @Test fun should_call_operation_with() {
        val a = Data(0)
        val b = Data(1)

        `when`(operator.operation(a, b)).then {  }

        calculator.calc(a, b)

        verify(operator).operation(firstCaptorData.capture(), secondCaptorData.capture())
    }
}