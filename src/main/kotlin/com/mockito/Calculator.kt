package com.mockito

interface Calculator {
    fun calc(a: Int, b: Int)

    fun operator(a: Variable, b: Variable)

    fun calc(a: Data, b: Data)
}