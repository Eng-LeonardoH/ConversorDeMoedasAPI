package Models;

import java.util.Arrays;

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

    public void recebeOpcao(String opcao){
        while(true) {
            if (Arrays.asList("1", "2", "3", "4", "5", "6").contains(opcao)) {
                System.out.println("Opcao recebida com sucesso");
                this.ultimaOpcaoEscolhida = opcao;
                break;
            } else if (opcao.equals("7")) {
                this.ultimaOpcaoEscolhida = opcao;
                break;
            } else {
                System.out.println("Opção incorreta, tente novamente...");
                this.mostrarMenu();
            }
        }
    }

}
