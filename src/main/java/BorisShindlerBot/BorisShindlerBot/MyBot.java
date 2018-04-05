package BorisShindlerBot.BorisShindlerBot;

import java.util.ArrayList;
import java.util.List;

import org.telegram.telegrambots.api.methods.BotApiMethod;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.methods.send.SendPhoto;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;



public class MyBot extends TelegramLongPollingBot {
	private final String welcome = "Вас приветствует чат-бот удобного Тель-Авива от Бориса Шиндлера.\n" + 
			"Получайте всю справочную информацию и справки от городских служб в\n" + 
			"вашем Телеграме на вашем языке.";
	
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
//		    // We check if the update has a message and the message has text
//		    if (update.hasMessage() && update.getMessage().hasText()) {
//		        SendMessage message = new SendMessage() // Create a SendMessage object with mandatory fields
//		                .setChatId(update.getMessage().getChatId())
//		                .setText(update.getMessage().getText());
//		        try {
//		            execute(message); // Call method to send the message
//		        } catch (TelegramApiException e) {
//		            e.printStackTrace();
//		        }
//		    }

		if (update.hasMessage() && update.getMessage().hasText()) {
			// Set variables
			String message_text = update.getMessage().getText();
			long chat_id = update.getMessage().getChatId();
			Object sendMessage;
			if (message_text.equals("/start")) {
				startAction(chat_id);
			} else if (null != (sendMessage = Actions.getAction(message_text, update.getMessage()))) {
				 try {
			            execute((BotApiMethod) sendMessage); // Call method to send the message
			        } catch (TelegramApiException e) {
			            e.printStackTrace();
			        }
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
				startAction(chat_id);
			}
		}

	}
//	
//	Main. –1 жилье, 2 транспорт, 3 учеба, 4 здоровье, 5 документы , 6-
//	Разрешение на парковку

	private void startAction(long chat_id) {
		SendMessage message = new SendMessage() // Create a message object object
				.setChatId(chat_id).setText(welcome);
		// Create ReplyKeyboardMarkup object
		ReplyKeyboardMarkup keyboardMarkup = new ReplyKeyboardMarkup();
		// Create the keyboard (list of keyboard rows)
		List<KeyboardRow> keyboard = new ArrayList<>();
		// Create a keyboard row
		KeyboardRow row = new KeyboardRow();
		// Set each button, you can also use KeyboardButton objects if you need
		// something else than text
		row.add("жилье");
		row.add("транспорт");
		row.add("учеба");
		// Add the first row to the keyboard
		keyboard.add(row);
		// Create another keyboard row
		row = new KeyboardRow();
		// Set each button for the second line
		row.add("здоровье");
		row.add("документы");
		row.add("Разрешение на парковку");
		// Add the second row to the keyboard
		keyboard.add(row);
		// Set the keyboard to the markup
		keyboardMarkup.setKeyboard(keyboard);
		// Add it to the message
		message.setReplyMarkup(keyboardMarkup);
		try {
			execute(message); // Call method to send the message
		} catch (TelegramApiException e) {
			e.printStackTrace();
		}
	}

	public String getBotUsername() {
		// TODO Auto-generated method stub
		return "BorisShindlerBot";
	}

}
