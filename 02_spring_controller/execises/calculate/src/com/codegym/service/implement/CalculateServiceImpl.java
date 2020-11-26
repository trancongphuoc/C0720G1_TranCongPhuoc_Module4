package com.codegym.service.implement;

import com.codegym.service.CalculateService;
import org.springframework.stereotype.Service;

@Service
public class CalculateServiceImpl implements CalculateService {

    @Override
    public double addition(Double firstNumber, Double secondNumber) {
        return firstNumber + secondNumber;
    }

    @Override
    public double subtraction(Double firstNumber, Double secondNumber) {
        return firstNumber - secondNumber;
    }

    @Override
    public double multiplication(Double firstNumber, Double secondNumber) {
        return firstNumber * secondNumber;
    }

    @Override
    public double division(Double firstNumber, Double secondNumber) {

        return firstNumber / secondNumber;
    }

    @Override
    public double calculate(Double firstNumber, Double secondNumber, String calculation) {
        switch (calculation) {
            case "+":
                return addition(firstNumber, secondNumber);
            case "-":
                return subtraction(firstNumber, secondNumber);
            case "x":
                return multiplication(firstNumber, secondNumber);
            case "/":
                    return division(firstNumber, secondNumber);
        }
        return 0;
    }


}
