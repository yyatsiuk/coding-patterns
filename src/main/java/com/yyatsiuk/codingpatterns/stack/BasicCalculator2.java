package com.yyatsiuk.codingpatterns.stack;

public class BasicCalculator2 {

    public int calculate(String s) {
        s = s.replaceAll(" ", "");
        s = s.replace("+", " + ")
                .replace("-", " - ")
                .replace("*", " * ")
                .replace("/", " / ");

        String[] tokens = s.split(" ");
        return 1;
    }


    public static void main(String[] args) {
        BasicCalculator2 basicCalculator2 = new BasicCalculator2();
        int calculate = basicCalculator2.calculate("1 *   2 + 5 / 2");
        System.out.println(calculate);
    }

}
