package Models;

import java.util.Arrays;
import java.util.Scanner;

public class MenuPrincipal {

    public String ultimaMensagem = "";

    private String ultimaOpcaoEscolhida = "";

    public String getUltimaOpcaoEscolhida() {
        return ultimaOpcaoEscolhida;
    }

    public void mostrarMenu(){
        System.out.println(
        """
        *****************************************************
        Seja bem-vindo/a ao Conversor de Moeda =]
        1) Dólar =>> Peso argentino
        2) Peso argentino =>> Dólar
        3) Dólar =>> Real brasileiro
        4) Real brasileiro =>> Dólar
        5) Dólar =>> Peso colombiano
        6) Peso colombiano =>> Dólar
        7) Sair
        Escolha uma opção: """
        );
    }

    public void recebeOpcao(){
        Scanner leConsole = new Scanner(System.in);
        while(true) {
            String leitura = leConsole.next();
            if (Arrays.asList("1", "2", "3", "4", "5", "6").contains(leitura)) {
                System.out.println("Opcao recebida com sucesso");
                this.ultimaOpcaoEscolhida = leitura;
                break;
            } else if (leitura.equals("7")) {
                System.out.println("Você escolheu sair, encerrando o programa...");
                this.ultimaOpcaoEscolhida = leitura;
                break;
            } else {
                System.out.println("Opção incorreta, tente novamente...");
                this.mostrarMenu();
            }
        }
    }

}
