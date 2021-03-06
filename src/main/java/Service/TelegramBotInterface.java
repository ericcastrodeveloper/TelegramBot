package Service;

import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.response.GetUpdatesResponse;
import com.pengrad.telegrambot.response.SendResponse;

import java.io.IOException;
import java.util.List;

/**Interface do BOT do Telegram.
 * @author Eric Castro Santos
 * @version 1.00
 */
public interface TelegramBotInterface {

    GetUpdatesResponse recuperarMensagensPendentes(int m);

    List<Update> listarMensagens(GetUpdatesResponse mensagensPendentes);

    SendResponse envioResposta(Update update,  String mensagemResponse);

    String processarMensagem(String mensagem) throws IOException;

}
