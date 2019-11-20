package Utils;

import java.util.HashMap;
import java.util.Map;

/**Classe responsável por armazenar mensagens de respostas padrões.
 * @author Eric Castro Santos
 * @version 1.00
 */
public class DicionarioMensagens {

    public static Map<String, String> setarMensagensPadrao() {

        Map<String, String> map = new HashMap<>();
        map.put("OLA", "Olá, tudo bem? Eu tenho função de informar temperaturas de cidades, para isso escreva: Temperatura em \"nome da cidade\"");
        map.put("OI", "Olá, tudo bem?");
        map.put("TCHAU", "Tchau! Até Breve!?");
        map.put("ONDE", "Sou do Telegram");
        map.put("PAIS", "Moro na nuvem, país Internet");
        map.put("IDADE", "Olá, Nasci em 03/11/2019, tenho 1 dia");
        map.put("BEM", "Estou ótimo também! \uD83D\uDE09");
        map.put("FAZ", "Gosto de fazer o que me faz bem, responder as pessoas. \uD83D\uDE03");
        map.put("ANOS", "Nasci em 03/11/2019, tenho 1 dia!");
        map.put("PROFISSAO", "Posso te informar a previsão do tempo, me informe a cidade:");
        map.put("RICO", "Simples, trabalhe bastante \uD83D\uDE1D");
        map.put("VIAGEM", "Simples, trabalhe bastante \uD83D\uDE1D");
        map.put("DINHEIRO", "Simples, trabalhe bastante \uD83D\uDE1D");
        map.put("LEGAL", "Sim, maneiro \uD83D\uDE0E");
        map.put("BOM", "Bom é fazer o bem para as pessoas \uD83D\uDE01");
        map.put("SONO", "Sim, maneiro \uD83D\uDE0E");
        map.put("SORTE", "Sorte é o resultado de muito esforço, trabalho e dedicação");
        map.put("DORMIR", "Dormir é para os fracos \uD83D\uDE05");
        map.put("CERTEZA", "Nessa vida só temos duas certezas: uma é que um dia todos nós iremos morrer, e a outra é que no final do ano tem show do Roberto Carlos.");
        map.put("SIM", "Concordo com você");
        map.put("NAO", "Tudo é uma questão de perspectiva \uD83D\uDE03");
        map.put("RIR", "Sorria pois alguém pode se apaixonar pelo seu sorriso!");
        map.put("PIADA", "O que uma impressora falou pra outra???? - Esse papel é seu ou é IMPRESSÃO minha!!! \uD83D\uDE02 \uD83D\uDE02 \uD83D\uDE02!");
        map.put("OUTRA", "Só fui programado para essa.\uD83D\uDE1E ");
        map.put("PREVISAO", "Digite a cidade para consulta da previsão do tempo, seguido da palavra 'Previsão' ...");
        map.put("OBRIGADO", "Imagina \uD83D\uDE01");
        map.put("ERIC", "Eric é meu criador! \uD83D\uDE01");

        return map;

    }
}
