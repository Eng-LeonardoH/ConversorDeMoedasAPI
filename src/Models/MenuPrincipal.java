package Models;

import java.util.Arrays;

public class MenuPrincipal {

    public void mostrarMenu(){
        System.out.println(
        """
        *****************************************************
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
}
