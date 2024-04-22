package com.andrmatt.currencyconverter.model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaApi {
    final String API_KEY = "94d094cd60be36dda8296269";

    public ExchangeRates obtenerCambio (String currency_1, String currency_2 ,double amount){

        final URI URL_QUERY = URI
                .create("https://v6.exchangerate-api.com/v6/"+API_KEY+"/pair/"+currency_1+"/"+currency_2+"/"+amount);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URL_QUERY)
                .build();

        try {
         HttpResponse<String> response = null;
            response = client.send(request, HttpResponse.BodyHandlers.ofString());

            return new Gson().fromJson(response.body(), ExchangeRates.class);

        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
