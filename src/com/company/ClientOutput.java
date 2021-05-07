package com.company;

public interface ClientOutput {
    static void print(String message) {
        System.out.println(message);
    }
    static void invalidValue() {
        System.out.println("Значение введено неверно, повторите");
    }
}
