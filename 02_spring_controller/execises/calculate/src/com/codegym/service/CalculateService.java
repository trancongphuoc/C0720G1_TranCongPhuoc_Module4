package com.codegym.service;

public interface CalculateService {

    double addition(Double firstNumber, Double secondNumber);

    double subtraction(Double firstNumber, Double secondNumber);

    double multiplication(Double firstNumber, Double secondNumber);

    double division(Double firstNumber, Double secondNumber);

    double calculate(Double firstNumber, Double secondNumber, String calculation);
}
