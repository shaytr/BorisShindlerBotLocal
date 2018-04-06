package BorisShindlerBot.BorisShindlerBot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Message;
import org.telegram.telegrambots.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.api.objects.replykeyboard.buttons.KeyboardRow;

import BorisShindlerBot.BorisShindlerBot.Actions.Action;

public class Utils {
	private static String BACK_WORD = "назад";
	public static void addBackButton(List<KeyboardRow> keyboard, String command) {
		KeyboardRow row = new KeyboardRow();
		row.add(BACK_WORD + " (" + command + ")");
		keyboard.add(row);
	}
	
	public static void addAction(HashMap<String,Action> actionsMap, HashMap<String,String> textsMap, 
			String command, Action action, String text) {
		final String actualText = text != null ? text : command; 
		actionsMap.put(command, action);
		actionsMap.put(BACK_WORD + " (" + command + ")", action);
		textsMap.put(command, actualText);
		textsMap.put(BACK_WORD + " (" + command + ")", actualText);
	}
	
	public static SendMessage createSendMessage(HashMap<String, String> textsMap, Message inMessage, String backButtonCommand, String[]... rowsText) {
		SendMessage outMessage = new SendMessage()
				.setChatId(inMessage.getChatId()).setText(textsMap.get(inMessage.getText()));
		if(rowsText != null) {
			// Create ReplyKeyboardMarkup object
			ReplyKeyboardMarkup keyboardMarkup = new ReplyKeyboardMarkup();
			// Create the keyboard (list of keyboard rows)
			List<KeyboardRow> keyboard = new ArrayList<>();
			for (String[] rowButtonsText: rowsText) {
				KeyboardRow row = new KeyboardRow();
				for (String buttonText: rowButtonsText) {
					row.add(buttonText);
				}
				keyboard.add(row);
			}
			if (backButtonCommand != null) {
				Utils.addBackButton(keyboard, backButtonCommand);
			}
			keyboardMarkup.setKeyboard(keyboard);
			// Add it to the message
			outMessage.setReplyMarkup(keyboardMarkup);
			
		}
		return outMessage;
	}
}
