package BorisShindlerBot.BorisShindlerBot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Message;
import org.telegram.telegrambots.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.api.objects.replykeyboard.buttons.KeyboardRow;

public class Actions {
	
	private final static String transportationText = 
			"В Тель-Авиве развитая сеть общественного транспорта, представленная\n" + 
			"автобусами, микроавтобусами шерут и поездами. Самым комфортным и\n" + 
			"быстрым видом транспорта являются поезда, самым дешевым – городские\n" + 
			"автобусы и маршрутки шерут. Внимание! В Шабат – по субботам –\n" + 
			"транспорт в Израиле не ходит, за исключением некоторых маршрутом\n" + 
			"шерутов и такси, в которых в это время действует повышенный тариф.\n" + 
			"Проездной Rav Kav\n" + 
			"Rav Kav – это персональная электронная карта, которую можно пополнить\n" + 
			"нужным количеством поездок на ж/д станциях и использовать для поездок на\n" + 
			"поезде или автобусе на территории выбранного вами города Израиля. Rav\n" + 
			"Kav подойдет вам в том случае, если вы планируете много ездить на\n" + 
			"автобусах одной компании в одном городе. Автобусные маршруты в Израиле\n" + 
			"обслуживают разные компании, поэтому, если вы планируете поездки с\n" + 
			"разными автобусными перевозчиками, то придется заплатить по отдельности\n" + 
			"за проезд в каждой компании и положить эти средства на свою карту Rav\n" + 
			"Kav. Всего на карту можно зачислить билеты 8 перевозчиков.\n" + 
			"Цены на билеты на автобус в Тель-Авиве и ближайших городах\n" + 
			"\n" + 
			"Тель-Авив и Центральный округ объединяются в агломерацию Гуш-Дан, в\n" + 
			"которой действует единая система оплаты за проезд на автобусах\n" + 
			"компаний Dan, Egged, Kavim ,Metropoline и поезда.\n" + 
			"http://www.dan.co.il/russian/\n" + 
			"http://www.egged.co.il/ru/HomePage.aspx\n" + 
			"https://www.rail.co.il/ru\n" + 
			"https://bus.gov.il/#/origindestination/1/0";
	
	private final static String electricityText = "https://www.iec.co.il/pages/default.aspx" ;
	
	private final static String payBillText = "https://www.mybills.co.il/payments/147/%D7%90%D7%A8%D7%A0%D7%95%D7%A0%D7%94_%D7%AA%D7%9C_%D7%90%D7%91%D7%99%D7%91.html";

	private final static String arnonaText = "Арнона – это муниципальный налог, установленный правительством,\n" + 
			"которым облагается владелец недвижимости или проживающий на\n" + 
			"съемной квартире.";
	
	final static HashMap<String,Action> actionsMap = new HashMap<>();

	public interface Action {
		Object getActionMessage(Message m);
	}
	
	static {
		
		actionsMap.put("жилье", Actions::appartment);
		actionsMap.put("транспорт", Actions::transportation);
		actionsMap.put("учеба", Actions::education);
		actionsMap.put("вода", Actions::water);
		actionsMap.put("арнона", Actions::arnona);
		actionsMap.put("уличная канализация", Actions::suige);
		actionsMap.put("электричество", Actions::electricity);
	}
	
	public static Object getAction(String command, Message message) {
		Action action = actionsMap.get(command);
		if (action != null) {
			return action.getActionMessage(message);
		}
		return null;
	}
	
	public static Object appartment(Message m) {
		SendMessage message = new SendMessage() // Create a message object object
				.setChatId(m.getChatId()).setText("жилье");
		// Create ReplyKeyboardMarkup object
		ReplyKeyboardMarkup keyboardMarkup = new ReplyKeyboardMarkup();
		// Create the keyboard (list of keyboard rows)
		List<KeyboardRow> keyboard = new ArrayList<>();
		// Create a keyboard row
		KeyboardRow row = new KeyboardRow();
		// Set each button, you can also use KeyboardButton objects if you need
		// something else than text
		row.add("вода");
		row.add("арнона");
		row.add("мусор");
		row.add("газ");
		// Add the first row to the keyboard
		keyboard.add(row);
		//назад
		row = new KeyboardRow();
		row.add("уличная канализация");
		row.add("комары");
		row.add("электричество");
		keyboard.add(row);
		row = new KeyboardRow();
		row.add("назад");
		keyboard.add(row);
		// Create another keyboard row
		// Set the keyboard to the markup
		keyboardMarkup.setKeyboard(keyboard);
		// Add it to the message
		message.setReplyMarkup(keyboardMarkup);
		return message;
	}
	public static Object transportation(Message m) {
		SendMessage message = new SendMessage() // Create a SendMessage object with mandatory fields
                .setChatId(m.getChatId())
                .setText(transportationText);
		return message;
	}
	public static Object electricity(Message m) {
		SendMessage message = new SendMessage() // Create a SendMessage object with mandatory fields
                .setChatId(m.getChatId())
                .setText(electricityText);
		return message;
	}
	public static Object education(Message m) {
		return null;
	}
	public static Object water(Message m) {
		return null;
	}
	public static Object arnona(Message m) {
		SendMessage message = new SendMessage() // Create a message object object
				.setChatId(m.getChatId()).setText(arnonaText);
		// Create ReplyKeyboardMarkup object
		ReplyKeyboardMarkup keyboardMarkup = new ReplyKeyboardMarkup();
		// Create the keyboard (list of keyboard rows)
		List<KeyboardRow> keyboard = new ArrayList<>();
		// Create a keyboard row
		KeyboardRow row = new KeyboardRow();
		// Set each button, you can also use KeyboardButton objects if you need
		// something else than text
		row.add("изменить домашний адрес");
		// Add the first row to the keyboard
		keyboard.add(row);
		//назад
		row = new KeyboardRow();
		row.add("оплатить");
		row.add("льготы");
		keyboard.add(row);
		row = new KeyboardRow();
		row.add("назад");
		keyboard.add(row);
		// Create another keyboard row
		// Set the keyboard to the markup
		keyboardMarkup.setKeyboard(keyboard);
		// Add it to the message
		message.setReplyMarkup(keyboardMarkup);
		return message;
	}
	public static Object suige(Message m) {
		return null;
	}
	
}
