package Service.Impl;

import Service.TelegramBotInterface;
import Service.WeatherService;
import Utils.CityList;
import Utils.DicionarioMensagens;
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

/**Classe que implementa a interface do BOT do Telegram.
 * @author Eric Castro Santos
 * @version 1.00
 */
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

        Map<String, String> list = DicionarioMensagens.setarMensagensPadrao();
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
