import Service.Impl.WeatherServiceImpl;
import Service.TelegramBotInterface;
import Service.Impl.TelegramBotInterfaceImpl;
import Service.WeatherService;
import Utils.CityList;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.response.GetUpdatesResponse;
import com.pengrad.telegrambot.response.SendResponse;

import java.io.IOException;
import java.util.List;


/**Classe principal da aplicação onde starta o BOT do Telegram.
 * @author Eric Castro Santos
 * @version 1.00
 */
public class Main {


    public static void main(String[] args) throws IOException {

        int m = 0;

        TelegramBotInterface telegramBotInterface = new TelegramBotInterfaceImpl();

        //Inicializando lista de cidades disponiveis para pesquisa de previsão de tempo
        CityList.listarCidadesDisponiveis();

        //loop infinito pode ser alterado por algum timer de interval curto
        while (true) {

            GetUpdatesResponse mensagensPendentes = telegramBotInterface.recuperarMensagensPendentes(m);

            List<Update> updates = telegramBotInterface.listarMensagens(mensagensPendentes);

            //análise de cada ação da mensagem
            for (Update update : updates) {
                //atualização do off-set
                m = update.updateId() + 1;

                System.out.println("Recebendo mensagem:" + update.message().text());

                //processamento das mensagens
                String msgResponse = telegramBotInterface.processarMensagem(update.message().text());

                System.out.println(msgResponse);

                SendResponse response = telegramBotInterface.envioResposta(update, msgResponse);

                System.out.println("Mensagem enviada? "+response.isOk());
            }
        }

    }


}


