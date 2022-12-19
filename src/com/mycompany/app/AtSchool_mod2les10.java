package com.mycompany.app;

import java.math.*;

public class AtSchool_mod2les10 {
    public static void main(String[] args) {

        //создаем числа BigInteger
        long l1 = 129_322_212_123_123_323L;
        BigInteger x = BigInteger.valueOf(l1);
        BigInteger x2 = BigInteger.TEN.multiply(x);

        //создаем числа BigDecimal
        BigDecimal x3;
        x3 = BigDecimal.valueOf(322323123,11441);
        BigDecimal x4 = BigDecimal.valueOf(108880454, 65699);

        //основные арифмет действия с BigInteger
        System.out.println("- - - - - - - - - - - - - - -");
        System.out.println("Сложение  чисел BigInteger " + x + " и " + x2 + " = " + x.add(x2));
        System.out.println("Вычитание чисел BigInteger " + x + " и " + x2 + " = " + x.subtract(x2));
        System.out.println("Умножение чисел BigInteger " + x + " и " + x2 + " = " + x.multiply(x2));
        System.out.println("Деление   чисел BigInteger " + x2 + " и " + x + " = " + x2.divide(x));
        System.out.println("Остаток от деления чисел BigInteger " + x2 + " и " + x + " = " + x2.mod(x));
        System.out.println("- - - - - - - - - - - - - - -");

        //основные арифмет действия с BigDecimal (впервые использовал комбинацию ctrl+R из урока по IDEA)
        System.out.println("Сложение  чисел BigDecimal " + x3 + " и " + x4 + " = " + x3.add(x4));
        System.out.println("Вычитание чисел BigDecimal " + x3 + " и " + x4 + " = " + x3.subtract(x4));
        System.out.println("Умножение чисел BigDecimal " + x3 + " и " + x4 + " = " + x3.multiply(x4));
        System.out.println("Остаток от деления чисел BigDecimal " + x4 + " и " + x3 + " = " + x4.remainder(x3));
        //вывовдит Arithmetic Exception - Nonterminating decimal expansion; no exact representable decimal result
        try {
            System.out.println("Деление   чисел BigDecimal " + x4 + " и " + x3 + " = " + x4.divide((x3)));
        }
        catch (ArithmeticException exc){
            //если ловим исключение, то округляем вывод, чтобы не получить ошибку
            System.out.println("Деление   чисел BigDecimal " + x4 + " и " + x3 + " = " + x4.divide((x3), 10,
                    RoundingMode.HALF_UP));
            //System.out.println("Sorry divide result is too large. Please try again with another input data");
        }
    }
}
