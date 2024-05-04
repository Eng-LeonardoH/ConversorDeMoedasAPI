import Models.ConversorDeMoedas;
import Models.MenuPrincipal;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MenuPrincipal menu = new MenuPrincipal();

        System.out.println("Seja bem-vindo/a ao Conversor de Moeda =]");

        boolean sair = false;
        while (!sair) {
            menu.mostrarMenu();
            int opcao = scanner.nextInt();
            switch (opcao) {
                case 1:
                    converterMoedas(scanner, "USD", "ARS");
                    break;
                case 2:
                    converterMoedas(scanner, "ARS", "USD");
                    break;
                case 3:
                    converterMoedas(scanner, "USD", "BRL");
                    break;
                case 4:
                    converterMoedas(scanner, "BRL", "USD");
                    break;
                case 5:
                    converterMoedas(scanner, "USD", "COP");
                    break;
                case 6:
                    converterMoedas(scanner, "COP", "USD");
                    break;
                case 7:
                    sair = true;
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida. Por favor, escolha uma opção válida.");
            }
        }
    }

    public static void converterMoedas(Scanner scanner, String moedaOrigem, String moedaDestino) {
        System.out.println("Digite o valor a ser convertido:");
        double valor = scanner.nextDouble();
        ConversorDeMoedas Conversor = new ConversorDeMoedas();

        try {
            double valorConvertido = Conversor.converteMoeda(valor, moedaOrigem, moedaDestino);
            System.out.println("*****************************************************");
            System.out.println(valor + " " + moedaOrigem + " equivale a " + valorConvertido + " " + moedaDestino);

        } catch (IOException | InterruptedException e) {
            System.out.println("Erro ao converter moeda: " + e.getMessage());
        }
    }
}