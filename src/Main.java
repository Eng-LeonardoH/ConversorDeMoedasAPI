import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import Menus.MenuPrincipal;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        var API = "0709f8b04ad9917ac3e67bd5";
        var url = "https://v6.exchangerate-api.com/v6/"+ API + "/latest/USD";
          var opcao = "";

        Gson gson = new Gson();
          MenuPrincipal menu = new MenuPrincipal();
          Scanner entradaConsole = new Scanner(System.in);

        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();

        HttpResponse<String> response = client
               .send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println(response.body());

        while (opcao != "7"){
            MenuPrincipal.mostrarMenu();
            String entrada = entradaConsole.next();

            if (entrada.equalsIgnoreCase("1")) {
                System.out.println("ok");
            } else if (entrada.equalsIgnoreCase("2")) {
                System.out.println("ok");
            } else if (entrada.equalsIgnoreCase("3")) {
                System.out.println("ok");
            } else if (entrada.equalsIgnoreCase("4")) {
                System.out.println("ok");
            } else if (entrada.equalsIgnoreCase("5")) {
                System.out.println("ok");
            } else if (entrada.equalsIgnoreCase("6")) {
                System.out.println("ok");
            } else if (entrada.equalsIgnoreCase("7")) {
                System.out.println("Programa encerrado");
                break;
            } else {
                System.out.println("Opcao invalida, tente novamente!");
            }
        }
    }
}