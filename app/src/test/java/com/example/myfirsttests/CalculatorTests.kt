package com.example.myfirsttests

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource


class CalculatorTests {

    companion object {
        private lateinit var calculator: Calculator

        @BeforeAll
        @JvmStatic
        internal fun setup() {
            calculator = Calculator()
        }
    }

    @Test
    @DisplayName("Correct Addition Two Numbers: 2 + 8 = 10")
    fun calculator_CorrectAdditionTwoNumbers() {
        Assertions.assertEquals(10, calculator.add(2, 8), "2 + 8 should equal 10")
    }

    @Test
    @DisplayName("Correct Subtraction Two Numbers: 8 - 2 = 6")
    fun calculator_CorrectSubtractionTwoNumbers() {
        Assertions.assertEquals(6, calculator.subtract(8, 2), "8 - 2 should equal 6")
    }

    @Test
    @DisplayName("Correct Multiplication Two Numbers: 8 * 2 = 16")
    fun calculator_CorrectMultiplicationTwoNumbers() {
        Assertions.assertEquals(16, calculator.multiply(8, 2), "8 * 2 should equal 16")
    }

    @Test
    @DisplayName("Correct Division Two Numbers: 8 / 2 = 4")
    fun calculator_CorrectDivisionTwoNumbers() {
        Assertions.assertEquals(4, calculator.divide(8, 2), "8 / 2 should equal 4")
    }

    @Test
    @DisplayName("Incorrect Addition Two Numbers: 2 + 8 <> 10")
    fun calculator_IncorrectAdditionTwoNumbers() {
        Assertions.assertEquals(0, 10 - calculator.add(2, 8), "Error! 2 + 8 not equal 10!!!")
    }

    @Test
    @DisplayName("Incorrect Addition Two Numbers: 2 - 8 <> 6")
    fun calculator_IncorrectSubtractionTwoNumbers() {
        Assertions.assertEquals(0, 6 - calculator.subtract(8, 2), "Error! 8 - 2 not equal 6!!!")
    }

    @Test
    @DisplayName("Incorrect Addition Two Numbers: 2 * 8 <> 16")
    fun calculator_IncorrectMultiplicationTwoNumbers() {
        Assertions.assertEquals(0, 16 - calculator.multiply(2, 8), "Error! 2 * 8 not equal 16!!!")
    }

    @Test
    @DisplayName("Incorrect Addition Two Numbers: 8 / 2 <> 4")
    fun calculator_IncorrectDivisionTwoNumbers() {
        Assertions.assertEquals(0, 4 - calculator.divide(8, 2), "Error! 8 / 2 not equal 4!!!")
    }

    //Проба параметрического теста

    @DisplayName("Addition")
    @ParameterizedTest(name = "{0} + {1} = {2}")
    @CsvSource(
        "2,   3,    5",
        "5,   10,   15",
        "15,  27,   42",
        "42,  58,   100",
        "100, 500,  600",
        "700, 7000, 7700"
    )
    fun add_ParameterizedTest(first: Int, second: Int, expectedResult: Int) {
        Assertions.assertEquals(
            expectedResult, calculator.add(first, second)
        ) { "$first + $second should equal $expectedResult" }
    }

    @DisplayName("Multiplication")
    @ParameterizedTest(name = "{0} * {1} = {2}")
    @CsvSource(
        "2,   3,    6",
        "5,   10,   50",
        "15,  27,   405",
        "42,  58,   2436",
        "100, 500,  50000",
        "700, 7000, 4900000"
    )
    fun multiplication_ParameterizedTest(first: Int, second: Int, expectedResult: Int) {
        Assertions.assertEquals(
            expectedResult, calculator.multiply(first, second)
        ) { "$first * $second should equal $expectedResult" }
    }

    @DisplayName("Subtraction")
    @ParameterizedTest(name = "{0} - {1} = {2}")
    @CsvSource(
        "20,    3,     17",
        "50,    10,    40",
        "15,    27,    -12",
        "42,    58,    -16",
        "1000,  500,   500",
        "70000, 700,  69300"
    )
    fun subtraction_ParameterizedTest(first: Int, second: Int, expectedResult: Int) {
        Assertions.assertEquals(
            expectedResult, calculator.subtract(first, second)
        ) { "$first - $second should equal $expectedResult" }
    }

    @DisplayName("Division")
    @ParameterizedTest(name = "{0} / {1} = {2}")
    @CsvSource(
        "20,    2,     10",
        "50,    10,    5",
        "15,    2,    7",
    )
    fun division_ParameterizedTest(first: Int, second: Int, expectedResult: Int) {
        Assertions.assertEquals(
            expectedResult, calculator.divide(first, second)
        ) { "$first / $second should equal $expectedResult" }
    }

}