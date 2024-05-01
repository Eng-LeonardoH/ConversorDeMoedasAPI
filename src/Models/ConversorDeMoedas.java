package Models;

public class ConversorDeMoedas {
    private String moedaAtual;
    private String moedaDestino;
    private String urlApi;
    private String ultimaMensagem;

    public double getValorParaConverter() {
        return valorParaConverter;
    }

    public void setValorParaConverter(double valorParaConverter) {
        this.valorParaConverter = valorParaConverter;
    }

    private double valorParaConverter;

    public String getMoedaAtual() {
        return moedaAtual;
    }

    public String getMoedaDestino() {
        return moedaDestino;
    }

    public String getUrlApi() {
        return urlApi;
    }

    public void preparaUrl(String API, String moedaAtual) {
        this.moedaAtual = moedaAtual;
        this.urlApi = "https://v6.exchangerate-api.com/v6/"
                + API
                + "/latest/"
                + moedaAtual;
    }

    public String geraMensagemDePedidoDeValor(String moedaDestino) {
        this.moedaDestino = moedaDestino;
        this.ultimaMensagem = "Digite o valor em "
                + this.moedaAtual
                + " que deseja converter para "
                + this.moedaDestino
                + ": ";
        return ultimaMensagem;
    }
}