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
	
	public static void addAction(String command, Action action, String text, String backCommand, boolean isEnd) {
		final String actualText = text != null ? text : command; 
		Actions.actionsMap.put(command, action);
		Actions.actionsMap.put(BACK_WORD + " (" + command + ")", action);
		Actions.textsMap.put(command, actualText);
		Actions.textsMap.put(BACK_WORD + " (" + command + ")", actualText);
		if (backCommand != null) {
			Actions.backsMap.put(command, backCommand);
			Actions.backsMap.put(BACK_WORD + " (" + command + ")", backCommand);
		}
		if(isEnd) {
			Actions.isEndCommand.add(command);
		}
	}
	
	public static SendMessage createSendMessage(Message inMessage, String[]... rowsText) {
		
		String inText = inMessage.getText();
		if (inText.contains("@")) {
			inText ="@";
		}
		String outText = Actions.textsMap.get(inText);;
		if(outText == null) {
			outText = Actions.welcomeText;
		
		}
		SendMessage outMessage = new SendMessage()
				.setChatId(inMessage.getChatId()).setText(outText);
		if(rowsText != null) {
			// Create ReplyKeyboardMarkup object
			ReplyKeyboardMarkup keyboardMarkup = new ReplyKeyboardMarkup();
			// Create the keyboard (list of keyboard rows)
			List<KeyboardRow> keyboard = new ArrayList<>();
			for (String[] rowButtonsText: rowsText) {
				addRow(keyboard, rowButtonsText);
			}
			if (Actions.isEndCommand.contains(inText)) {
				for (String[] rowButtonsText: Actions.THE_END_MENU) {
					addRow(keyboard, rowButtonsText);
				}
				outMessage.setText(outText + Actions.THE_END_TEXT);
			}
			String backButtonCommand = Actions.backsMap.get(inText);
			if (backButtonCommand != null) {
				Utils.addBackButton(keyboard, backButtonCommand);
			}
			keyboardMarkup.setKeyboard(keyboard);
			// Add it to the message
			outMessage.setReplyMarkup(keyboardMarkup);
			
		}
		return outMessage;
	}

	private static void addRow(List<KeyboardRow> keyboard, String[] rowButtonsText) {
		KeyboardRow row = new KeyboardRow();
		for (String buttonText: rowButtonsText) {
			row.add(buttonText);
		}
		keyboard.add(row);
	}
}
