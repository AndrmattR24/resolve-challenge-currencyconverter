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
        boolean flag = false;
        //Menu

        //Entrada Operacion
        do {
            flag = false;
            try {
                System.out.print("""
                        $ $ $ $ $ MONEY EXCHANGE $ $ $ $
                            [ 1 ]  USD  -> PEN
                            [ 2 ]  PEN  -> USD
                            [ 3 ]  ARS  -> PEN
                            [ 4 ]  PEN  -> ARS
                            [ 5 ]  EUR  -> PEN
                            [ 6 ]  PEN  -> EUR
                            [ 7 ]  SALIR       
                                            
                        Ingrese numero de operacion : """);
                option = entrada.nextInt();
                //Evaluacion de la operacion
                if (option > 0 && option <= 6) {
                    do {
                        try {
                            System.out.print("ingrese Monto a convertir :");
                            amount = entrada.nextDouble();
                            //devolviendo el tipo de cambio
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
                            //Mostrando Conversion
                            System.out.println(String.format("\n\n[%s] %s : [%s] -> %s", exchangeRates.getBase_code(), String.valueOf(amount), exchangeRates.getTarget_code(), String.valueOf(convertedAmount) + "\n\n"));
                            break;

                        } catch (InputMismatchException e) {
                            System.out.println("Error Se esperaba un dato tipo numero Decimal, Intenta de nuevoa\n");
                            flag = true;
                            entrada.nextLine();
                        }
                    } while (flag);
                } else if (option == 7) {
                    System.out.println("Gracias Por Su preferencia");
                } else {
                    System.out.println("\nSeleccion una opcion valida\n");
                }
            } catch (InputMismatchException e) {
                System.out.println("Error Se esperaba un dato tipo numero entero, Intenta de nuevoa\n");
                flag = true;
                entrada.nextLine();
            }
        } while (option != 7);

    }
}