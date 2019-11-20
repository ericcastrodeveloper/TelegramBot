package Service.Impl;

import Service.TelegramBotInterface;
import Service.WeatherService;
import Utils.CityList;
import Utils.MapUtils;
import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.TelegramBotAdapter;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.model.request.ChatAction;
import com.pengrad.telegrambot.request.GetUpdates;
import com.pengrad.telegrambot.request.SendChatAction;
import com.pengrad.telegrambot.request.SendMessage;
import com.pengrad.telegrambot.response.GetUpdatesResponse;
import com.pengrad.telegrambot.response.SendResponse;

import java.io.IOException;
import java.text.Normalizer;
import java.util.*;

public class TelegramBotInterfaceImpl implements TelegramBotInterface {

    //Criação do objeto bot com as informações de acesso
    private static TelegramBot bot = TelegramBotAdapter.build("1042814714:AAGJiLHrPZMy-JGa97ruqnAEGxh1ws0GCFE");

    public GetUpdatesResponse recuperarMensagensPendentes(int m) {
        return bot.execute(new GetUpdates().limit(100).offset(m));
    }

    public List<Update> listarMensagens(GetUpdatesResponse mensagensPendentes) {
        return mensagensPendentes.updates();
    }

    public SendResponse envioResposta(Update update, String mensagemResponse) {
        bot.execute(new SendChatAction(update.message().chat().id(), ChatAction.typing.name()));
        return bot.execute(new SendMessage(update.message().chat().id(), mensagemResponse));
    }

    public String processarMensagem(String mensagem) throws IOException {

        String msgResponse = "";

        Map<String, String> list = setarMensagensPadrao();
        Set<String> mensagens;
        mensagens = list.keySet();

        //mensagens padrões

        //previsao do tempo
       if(mensagem.contains("Temperatura em")) {

           msgResponse = servicoTemperatura(mensagem);

           //mensagens de resposta padrão
       }else {

           mensagem = retirarAcentos(mensagem);
           mensagem = mensagem.toUpperCase();

           for (String mensagensPadrao : mensagens) {
               if (mensagem.contains(mensagensPadrao.toUpperCase())) {
                   msgResponse = list.get(mensagensPadrao);
                   break;
               }
           }
       }
        if(msgResponse.equals("")){
            msgResponse = "Não entendi...";
        }
        return msgResponse;
    }


    private Map<String, String>  setarMensagensPadrao() {
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

        return map;

    }

    private String retirarAcentos(String mensagem) {
        return Normalizer.normalize(mensagem, Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "");
    }
    private String servicoTemperatura(String mensagem) throws IOException {
        String msgResponse;
        String cidade = mensagem.substring(15);
        mensagem = retirarAcentos(mensagem);
        Long id = MapUtils.getKeysByValue(CityList.listaCidades, mensagem.substring(15));
        WeatherService weatherService = new WeatherServiceImpl();
        String temperatura = weatherService.hourlyForecastByCityID(id);
        if(temperatura == null){
            msgResponse = "Cidade não encontrada!";
        }else
        msgResponse = "Temperatura - "+cidade+": "+temperatura+"º C";

        return msgResponse;
    }
}
