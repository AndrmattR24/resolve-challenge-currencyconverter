package com.andrmatt.currencyconverter.principal;

import com.andrmatt.currencyconverter.model.ConsultaApi;
import com.andrmatt.currencyconverter.model.ExchangeRates;

import javax.swing.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class principal {

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);
        ConsultaApi consultaApi = new ConsultaApi();
        ExchangeRates exchangeRates = null;

        double amount = 0, convertedAmount = 0;
        int option = 0;

        while (option != 7) {

            System.out.println("""
                     $$$$$MONEY EXCHANGE$$$$
                     [ 1 ]  U S D  ->  P E N
                     [ 2 ]  P E N  ->  U S D
                     [ 3 ]  A R S  ->  P E N
                     [ 4 ]  P E N  ->  A R S
                     [ 5 ]  E U R  ->  P E N
                     [ 6 ]  P E N  ->  E U R
                     [ 7 ]  S A L I R       """);

            System.out.print("Que operacion realizamos ? : ");
            option = entrada.nextInt();

            if (option > 0 && option <= 6) {
                System.out.print("ingrese Monto a convertir :");
                amount = entrada.nextDouble();

                exchangeRates = switch (option) {
                    case 1 -> consultaApi.obtenerCambio("USD", "PEN", amount);
                    case 2 -> consultaApi.obtenerCambio("PEN", "USD", amount);
                    case 3 -> consultaApi.obtenerCambio("ARS", "PEN", amount);
                    case 4 -> consultaApi.obtenerCambio("PEN", "ARS", amount);
                    case 5 -> consultaApi.obtenerCambio("EUR", "PEN", amount);
                    case 6 -> consultaApi.obtenerCambio("PEN", "EUR", amount);
                    default -> exchangeRates;
                };
                convertedAmount = exchangeRates.getConversion_result();
                System.out.println(String.format("\n\n[%s] %s : [%s] -> %s",exchangeRates.getBase_code(), String.valueOf(amount), exchangeRates.getTarget_code(), String.valueOf(convertedAmount)+"\n\n"));

            } else if (option == 7) {
                System.out.println("Gracias Por su prefrencia\n");

            } else {
                System.out.println("\nSeleccion una opcion valida\n");
            }
        }
    }
}
