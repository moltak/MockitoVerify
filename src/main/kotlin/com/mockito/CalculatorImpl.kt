package com.mockito

class CalculatorImpl(
        private val expression: Expression,
        private val operator: Operator
) : Calculator {
    override fun calc(a: Int, b: Int) {
        expression.calc(a, b)
    }

    override fun operator(a: Variable, b: Variable) {
        operator.operation(a, b)
    }

    override fun calc(a: Data, b: Data) {
        operator.operation(a, b)
    }
}