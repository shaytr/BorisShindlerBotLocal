package BorisShindlerBot.BorisShindlerBot;

import org.telegram.telegrambots.api.methods.BotApiMethod;
import org.telegram.telegrambots.api.methods.send.SendDocument;
import org.telegram.telegrambots.api.methods.send.SendMessage;
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
		if (update.getMessage().getFrom().getBot()) {
			// message sent by a bot.
			System.err.println(update);
			return;
		}
		System.out.println(update);
		if (update.hasMessage() && update.getMessage().hasText()) {
			// Set variables
			String message_text = update.getMessage().getText();
			long chat_id = update.getMessage().getChatId();
			Object sendMessage;
			if (message_text.equals("/start")) {
				sendMessage = startAction(update.getMessage());
			} else if (null != (sendMessage = Actions.getAction(message_text, update.getMessage()))) {
				
			} else if (message_text.contains("@")) {
				sendMessage = Actions.getAction("@", update.getMessage());
			}
			else {
				sendMessage = startAction(update.getMessage());
			}
			try {
				if (sendMessage instanceof Object[]) {
					for(Object m: (Object[])sendMessage) {
						doSend(m);
					}
				} else {
					doSend(sendMessage);
				}
			} catch (TelegramApiException e) {
				e.printStackTrace();
			}

		}

	}

	private void doSend(Object sendMessage) throws TelegramApiException {
		if (sendMessage instanceof BotApiMethod) {
			execute((BotApiMethod) sendMessage); // Call method to send the message
		} else {
			sendDocument((SendDocument)sendMessage);
		}
	}

	private SendMessage startAction(Message m) {
		String[][] rows = new String[][] {
			{"жилье","транспорт","учеба"},
			{"здоровье", "Разрешение на парковку"}
		}; 
		SendMessage message = Utils.createSendMessage(m, rows);
		return message;
	}

	public String getBotUsername() {
		return "BorisShindlerBot";
	}

}
