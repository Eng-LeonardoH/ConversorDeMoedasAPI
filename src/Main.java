import java.io.IOException;

import Models.ConversorDeMoedas;
import Models.MenuPrincipal;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        MenuPrincipal menu = new MenuPrincipal();
        ConversorDeMoedas conversor = new ConversorDeMoedas();

        String API = "0709f8b04ad9917ac3e67bd5";
        String opcao;

        while (!menu.getUltimaOpcaoEscolhida().contains("7")) {
            menu.mostrarMenu();
            menu.recebeOpcao();
            opcao = menu.getUltimaOpcaoEscolhida();
            if (!opcao.equals("7")) {
                System.out.println("Preparando para converter valores...");
                System.out.println(" - Criando URL...");
                conversor.preparaUrl(API,
                        opcao.equals("1") ? "USD" :
                                opcao.equals("2") ? "ARS" :
                                        opcao.equals("3") ? "USD" :
                                                opcao.equals("4") ? "BRL" :
                                                        opcao.equals("5") ? "USD" :
                                                                opcao.equals("6") ? "COP" :
                                                                        null);
                System.out.println(conversor.getUltimaUrlGerada());
            }
        }


//        Gson gson = new Gson();
//        ConversorDeMoedas conversor = new ConversorDeMoedas();
//
//        String opcao = "";
//        double valorEmMoedaAtual = 0;
//
//        while (opcao != "7"){
//            MenuPrincipal.mostrarMenu();
//            String entrada = entradaConsole.next();
//
//
//            // COLOCAR EM CLASSE ESPECIFICA
//            HttpClient client = HttpClient.newHttpClient();
//            HttpRequest request = HttpRequest.newBuilder()
//                    .uri(URI.create(url))
//                    .build();
//            HttpResponse<String> response = client
//                    .send(request, HttpResponse.BodyHandlers.ofString());
//            System.out.println(response.body());
//        }
    }
}