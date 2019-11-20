package Utils;

import java.util.HashMap;
import java.util.Map;

/**Classe respons�vel por armazenar mensagens de respostas padr�es.
 * @author Eric Castro Santos
 * @version 1.00
 */
public class DicionarioMensagens {

    public static Map<String, String> setarMensagensPadrao() {

        Map<String, String> map = new HashMap<>();
        map.put("OLA", "Ol�, tudo bem? Eu tenho fun��o de informar temperaturas de cidades, para isso escreva: Temperatura em \"nome da cidade\"");
        map.put("OI", "Ol�, tudo bem?");
        map.put("TCHAU", "Tchau! At� Breve!?");
        map.put("ONDE", "Sou do Telegram");
        map.put("PAIS", "Moro na nuvem, pa�s Internet");
        map.put("IDADE", "Ol�, Nasci em 03/11/2019, tenho 1 dia");
        map.put("BEM", "Estou �timo tamb�m! \uD83D\uDE09");
        map.put("FAZ", "Gosto de fazer o que me faz bem, responder as pessoas. \uD83D\uDE03");
        map.put("ANOS", "Nasci em 03/11/2019, tenho 1 dia!");
        map.put("PROFISSAO", "Posso te informar a previs�o do tempo, me informe a cidade:");
        map.put("RICO", "Simples, trabalhe bastante \uD83D\uDE1D");
        map.put("VIAGEM", "Simples, trabalhe bastante \uD83D\uDE1D");
        map.put("DINHEIRO", "Simples, trabalhe bastante \uD83D\uDE1D");
        map.put("LEGAL", "Sim, maneiro \uD83D\uDE0E");
        map.put("BOM", "Bom � fazer o bem para as pessoas \uD83D\uDE01");
        map.put("SONO", "Sim, maneiro \uD83D\uDE0E");
        map.put("SORTE", "Sorte � o resultado de muito esfor�o, trabalho e dedica��o");
        map.put("DORMIR", "Dormir � para os fracos \uD83D\uDE05");
        map.put("CERTEZA", "Nessa vida s� temos duas certezas: uma � que um dia todos n�s iremos morrer, e a outra � que no final do ano tem show do Roberto Carlos.");
        map.put("SIM", "Concordo com voc�");
        map.put("NAO", "Tudo � uma quest�o de perspectiva \uD83D\uDE03");
        map.put("RIR", "Sorria pois algu�m pode se apaixonar pelo seu sorriso!");
        map.put("PIADA", "O que uma impressora falou pra outra???? - Esse papel � seu ou � IMPRESS�O minha!!! \uD83D\uDE02 \uD83D\uDE02 \uD83D\uDE02!");
        map.put("OUTRA", "S� fui programado para essa.\uD83D\uDE1E ");
        map.put("PREVISAO", "Digite a cidade para consulta da previs�o do tempo, seguido da palavra 'Previs�o' ...");
        map.put("OBRIGADO", "Imagina \uD83D\uDE01");
        map.put("ERIC", "Eric � meu criador! \uD83D\uDE01");

        return map;

    }
}
