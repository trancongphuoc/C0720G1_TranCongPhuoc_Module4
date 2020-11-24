package com.codegym.service.implement;

import com.codegym.service.CalculateService;
import org.springframework.stereotype.Service;

@Service
public class CalculateServiceImpl implements CalculateService {

    @Override
    public double addition(Integer firstNumber, Integer secondNumber) {
        return firstNumber + secondNumber;
    }

    @Override
    public double subtraction(Integer firstNumber, Integer secondNumber) {
        return firstNumber - secondNumber;
    }

    @Override
    public double multiplication(Integer firstNumber, Integer secondNumber) {
        return firstNumber * secondNumber;
    }

    @Override
    public double division(Integer firstNumber, Integer secondNumber) {
        return firstNumber / secondNumber;
    }
}
