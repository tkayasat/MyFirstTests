package com.example.myfirsttests

class Calculator {

    fun add(a: Int, b: Int): Int {
        println("Выполняется сложение $a и $b")
        return a + b
    }

    fun subtract(a: Int, b: Int): Int {
        println("Выполняется вычитание $a и $b")
        return a - b
    }

    fun multiply(a: Int, b: Int): Int {
        println("Выполняется умножение $a и $b")
        return a * b
    }

    fun divide(a: Int, b: Int): Int {
        println("Выполняется деление $a и $b")
        return a / b
    }
}