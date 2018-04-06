package BorisShindlerBot.BorisShindlerBot;

import org.telegram.telegrambots.api.methods.BotApiMethod;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.methods.send.SendPhoto;
import org.telegram.telegrambots.api.objects.Message;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;

public class MyBot extends TelegramLongPollingBot {

	
	private final String token;

	public MyBot(String token) {
		this.token = token;
	}

	@Override
	public String getBotToken() {
		return token;
	}

	@SuppressWarnings("unchecked")
	public void onUpdateReceived(Update update) {
		if (update.hasMessage() && update.getMessage().hasText()) {
			// Set variables
			String message_text = update.getMessage().getText();
			long chat_id = update.getMessage().getChatId();
			Object sendMessage;
			if (message_text.equals("/start")) {
				sendMessage = startAction(update.getMessage());
			} else if (null != (sendMessage = Actions.getAction(message_text, update.getMessage()))) {
				
			}
			else if (message_text.equals("/pic")) {
				// User sent /pic
				SendPhoto msg = new SendPhoto().setChatId(chat_id)
						.setPhoto("AgADAgAD6qcxGwnPsUgOp7-MvnQ8GecvSw0ABGvTl7ObQNPNX7UEAAEC").setCaption("Photo");
				try {
					sendPhoto(msg); // Call method to send the photo
				} catch (TelegramApiException e) {
					e.printStackTrace();
				}
			} else {
				sendMessage = startAction(update.getMessage());
			}
			try {
				execute((BotApiMethod) sendMessage); // Call method to send the message
			} catch (TelegramApiException e) {
				e.printStackTrace();
			}

		}

	}

	private SendMessage startAction(Message m) {
		String[][] rows = new String[][] {
			{"жилье","транспорт","учеба"},
			{"здоровье канализация","документы", "Разрешение на парковку"}
		}; 
		SendMessage message = Utils.createSendMessage(null, m, null, rows);
		return message;
	}

	public String getBotUsername() {
		// TODO Auto-generated method stub
		return "BorisShindlerBot";
	}

}
