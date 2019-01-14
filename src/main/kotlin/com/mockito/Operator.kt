package com.mockito

interface Operator {
    fun operation(a: Variable, b: Variable)
    fun operation(a: Data, b: Data)
}