package Models;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Map;

public class ConversorDeMoedas {

    private static final String API_URL = "https://v6.exchangerate-api.com/v6/cad048ea7ed106b90093b67b/latest/USD";

    public static Map<String, Double> obterTaxasDeConversao() throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(API_URL))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        Gson gson = new Gson();
        JsonObject jsonObject = gson.fromJson(response.body(), JsonObject.class);

        JsonObject conversionRates = jsonObject.getAsJsonObject("conversion_rates");
        return gson.fromJson(conversionRates, Map.class);
    }

    public static double converteMoeda(double valor, String moedaOrigem, String moedaDestino) throws IOException, InterruptedException {
        Map<String, Double> taxasDeConversao = obterTaxasDeConversao();
        double taxaOrigem = taxasDeConversao.get(moedaOrigem);
        double taxaDestino = taxasDeConversao.get(moedaDestino);

        double valorConvertido = (valor / taxaOrigem) * taxaDestino;
        return valorConvertido;
    }

    public static void main(String[] args) {
        try {
            double valor = 100;
            String moedaOrigem = "USD";
            String moedaDestino = "EUR";

            double valorConvertido = converteMoeda(valor, moedaOrigem, moedaDestino);
            System.out.println(valor + " " + moedaOrigem + " equivalem a " + valorConvertido + " " + moedaDestino);
        } catch (IOException | InterruptedException e) {
            System.out.println("Erro ao converter moeda: " + e.getMessage());
        }
    }
}