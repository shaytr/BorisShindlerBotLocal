package BorisShindlerBot.BorisShindlerBot;

import java.util.HashMap;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Message;

public class Actions {
	
	public final static String welcomeText = "Вас приветствует чат-бот удобного Тель-Авива от Бориса Шиндлера.\n" + 
			"Получайте всю справочную информацию и справки от городских служб в\n" + 
			"вашем Телеграме на вашем языке.";
	
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
	private final static String arnonaChnangeAdressText = "https://www.tel-aviv.gov.il/Residents/Arnona/Pages/ArnonaSwitching.aspx";
	
	final static HashMap<String,Action> actionsMap = new HashMap<>();
	final static HashMap<String,String> textsMap = new HashMap<>();
	

	public interface Action {
		Object getActionMessage(Message m);
	}
	
	static {
		Utils.addAction(actionsMap, textsMap, "жилье", Actions::appartment, null);
		Utils.addAction(actionsMap, textsMap, "транспорт", Actions::transportation, transportationText);
		Utils.addAction(actionsMap, textsMap, "учеба", Actions::education, null);
		Utils.addAction(actionsMap, textsMap, "вода", Actions::water, null);
		Utils.addAction(actionsMap, textsMap, "арнона", Actions::arnona, arnonaText);
		Utils.addAction(actionsMap, textsMap, "уличная канализация", Actions::suige, null);
		Utils.addAction(actionsMap, textsMap, "электричество", Actions::electricity, electricityText);
		Utils.addAction(actionsMap, textsMap, "изменить домашний адрес", Actions::arnonaChangeAdress, arnonaChnangeAdressText);
	}
	
	public static Object getAction(String command, Message message) {
		Action action = actionsMap.get(command);
		if (action != null) {
			return action.getActionMessage(message);
		}
		return null;
	}
	
	public static Object appartment(Message m) {	
		String[][] rows = new String[][] {
			{"вода","арнона","мусор","газ"},
			{"уличная канализация","комары", "электричество"}
		}; 
		SendMessage message = Utils.createSendMessage(textsMap, m, "главное меню", rows);
		return message;
	}
	
	
	public static Object transportation(Message m) {
		SendMessage message = Utils.createSendMessage(textsMap, m, null);
		return message;
	}
	
	public static Object electricity(Message m) {
		SendMessage message = Utils.createSendMessage(textsMap, m, null);
		return message;
	}
	
	public static Object education(Message m) {
		return null;
	}
	
	public static Object water(Message m) {
		return null;
	}
	
	public static Object arnona(Message m) {
		
		String[][] rows = new String[][] {
			{"изменить домашний адрес"},
			{"оплатить","льготы"}
		}; 
		SendMessage message = Utils.createSendMessage(textsMap, m, "жилье", rows);
		return message;
	}
	
	public static Object suige(Message m) {
		return null;
	}
	
	public static Object arnonaChangeAdress(Message m) {
		
		String[][] rows = new String[][] {
			{"получить форму на емэйл"},
			{"показать форму на экране"}
		}; 
		SendMessage message = Utils.createSendMessage(textsMap, m, "арнона", rows);
		return message;
	}
	
}
