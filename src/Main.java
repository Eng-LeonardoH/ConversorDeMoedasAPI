import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import Models.ConversorDeMoedas;
import Models.MenuPrincipal;
import com.google.gson.Gson;


public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        MenuPrincipal menu = new MenuPrincipal();
        ConversorDeMoedas conversor = new ConversorDeMoedas();
        Gson gson = new Gson();
        Scanner leConsole = new Scanner(System.in);


        String API = "0709f8b04ad9917ac3e67bd5";
        String opcao;


        while (!menu.getUltimaOpcaoEscolhida().contains("7")) {
            menu.mostrarMenu();
            menu.recebeOpcao(leConsole.next());
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
                System.out.println(" -  URL criada com sucesso: " + conversor.getUrlApi());
                System.out.println(conversor.geraMensagemDePedidoDeValor(
                        opcao.equals("1") ? "ARS" :
                            opcao.equals("2") ? "USD" :
                                opcao.equals("3") ? "BRL" :
                                    opcao.equals("4") ? "USD" :
                                        opcao.equals("5") ? "COP" :
                                            opcao.equals("6") ? "USD" :
                                                null));
                boolean entradaValida = false;
                while (!entradaValida){
                    try {
                        conversor.setValorParaConverter(leConsole.nextDouble());
                        entradaValida = true;
                    } catch (InputMismatchException ime){
                        System.out.println("Entrada inválida, tente novamente.");
                        leConsole.nextLine();
                    }
                }
                System.out.println("O valor armazenado no atributo de classe foi: " +
                        conversor.getValorParaConverter());
                //seguir com a inclusão dos métodos para converter valor recebido para a moeda
                //de destino de acordo com os valores obtidos via API
            } else {
                System.out.println("Você escolheu sair. Encerrando programa...");
                leConsole.close();
                System.out.println("Programa encerrado...");
            }
        }
    }
}


//        ConversorDeMoedas conversor = new ConversorDeMoedas();
//            HttpClient client = HttpClient.newHttpClient();
//            HttpRequest request = HttpRequest.newBuilder()
//                    .uri(URI.create(url))
//                    .build();
//            HttpResponse<String> response = client
//                    .send(request, HttpResponse.BodyHandlers.ofString());
//            System.out.println(response.body());
//