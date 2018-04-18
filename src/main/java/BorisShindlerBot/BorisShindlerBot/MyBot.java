package BorisShindlerBot.BorisShindlerBot;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

import org.telegram.telegrambots.api.methods.BotApiMethod;
import org.telegram.telegrambots.api.methods.send.SendDocument;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Message;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;

public class MyBot extends TelegramLongPollingBot {

	
	private final String token;
	private final UserSet usetSet;
	private final String broadcastPassword;
	ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(4);


	public MyBot(String token, UserSet usetSet, String broadcastPassword) {
		this.token = token;
		this.usetSet = usetSet;
		this.broadcastPassword = broadcastPassword + " ";
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


		// insert to database
		
		executor.execute(() -> {
	        if(usetSet.addToSet(update)){
	    		System.out.println(update);
	            usetSet.inserInDB(update.getMessage().getChatId(), update.getMessage().getFrom().getId(),
	                    update.getMessage().getFrom().getFirstName(), update.getMessage().getFrom().getLastName());
	        }			
		});

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
			else if (message_text.startsWith(broadcastPassword)) {
				sendMessage = broadcastAction(update.getMessage());
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

	private Object broadcastAction(Message message) {
		String outText = message.getText().substring(broadcastPassword.length());
		SendMessage outMessage;
		System.out.println("Broadcasting Mesage: " + outText);
		int i = 0;
		for (String chat_id: usetSet.getChatIds()) {
			outMessage = new SendMessage()
					.setChatId(chat_id).setText(outText);
			outMessage.enableMarkdown(true);
			try {
				doSend(outMessage);
				i++;
			} catch (Throwable e) {
				System.err.println("Broadcasting Mesage failed for cat_id: " + chat_id);
			}
		}
		outText = "_Broadcasting Mesage been sent for : " + i + " users_";
		outMessage = new SendMessage()
				.setChatId(message.getChatId()).setText(outText);
		outMessage.enableMarkdown(true);
		System.out.println(outText);
		return outMessage;
	}

	private void doSend(Object sendMessage) throws TelegramApiException {
		if (sendMessage == null) {
			return;
		}
		if (sendMessage instanceof BotApiMethod) {
			execute((BotApiMethod) sendMessage); // Call method to send the message
		} else {
			sendDocument((SendDocument)sendMessage);
		}
	}

	private SendMessage startAction(Message m) {
		String[][] rows = new String[][] {
			{"жилье","арнона", "транспорт"},
			{"Разрешение на парковку", "учеба", "здоровье"}
		}; 
		SendMessage message = Utils.createSendMessage(m, rows);
		return message;
	}

	public String getBotUsername() {
		return "TLVBotBorisShindler";
	}

}
