package Models;

public class ConversorDeMoedas {
    private String moedaAtual = "";
    private String moedaDestino = "";
    private String ultimaUrlGerada = "";
    private String ultimaMensagem = "";
    public String getMoedaAtual() {
        return moedaAtual;
    }
    public String getMoedaDestino() {
        return moedaDestino;
    }
    public String getUltimaUrlGerada() {
        return ultimaUrlGerada;
    }

    public void preparaUrl(String API, String moedaAtual){
        this.ultimaUrlGerada = "https://v6.exchangerate-api.com/v6/"
                    + API
                    + "/latest/"
                    + moedaAtual;

    }

    public String pedeValorParaConverter(){
        this.ultimaMensagem = "Digite o valor em "
                + this.moedaAtual
                + " que deseja converter para "
                + this.moedaDestino
                + ": ";
        return ultimaMensagem;
    }
}
//    public String recebeOpcao(String opcao){
//        pedeValorParaConverter();
//        if (recebeOpcao().equals("1")) {
//            this.moedaAtual = "USD";
//            this.moedaDestino = "ARS";
//
//        } else if (recebeOpcao().equals("2")) {
//            this.moedaAtual = "ARS";
//            this.moedaDestino = "USD";
//            System.out.println("Digite quantos "
//                    + this.moedaAtual
//                    + " deseja converter em "
//                    + this.moedaDestino
//                    + ": ");
//        } else if (recebeOpcao().equals("3")) {
//            this.moedaAtual = "USD";
//            moedaDestino = "BRL";
//
//        } else if (recebeOpcao().equals("4")) {
//            this.moedaAtual = "BRL";
//            moedaDestino = "USD";
//
//        } else if (recebeOpcao().equals("5")) {
//            this.moedaAtual = "USD";
//            moedaDestino = "COP";
//
//        } else if (recebeOpcao().equals("6")) {
//            this.moedaAtual = "COP";
//            moedaDestino = "USD";
//
//        } else if (recebeOpcao().equals("7")) {
//            System.out.println("Programa encerrado");
//
//        } else {
//            System.out.println("Opcao invalida, tente novamente!");
//            // ! colocar um trigger para não enviar requisição
//        }
//        return opcao;
//    }