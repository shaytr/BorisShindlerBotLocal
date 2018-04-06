package BorisShindlerBot.BorisShindlerBot;

import java.util.HashMap;
import java.util.HashSet;

import org.telegram.telegrambots.api.methods.send.SendDocument;
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
			"автобусы и маршрутки шерут.\n" + 
			"Проездной Rav Kav\n" + 
			"Rav Kav – это персональная электронная карта, которую можно пополнить\n" + 
			"нужным количеством поездок на ж/д станциях и использовать для поездок на\n" + 
			"поезде или автобусе на территории выбранного вами города Израиля.\n" + 
			"Автобусные маршруты в Израиле обслуживают разные компании, поэтому,\n" + 
			"если вы планируете поездки с разными автобусными перевозчиками, то\n" + 
			"придется заплатить по отдельности за проезд в каждой компании и положить\n" + 
			"эти средства на свою карту Rav Kav.\n" + 
			"Цены на билеты на автобус в Тель-Авиве и ближайших городах\n" + 
			"Тель-Авив и Центральный округ объединяются в агломерацию Гуш-Дан, в\n" + 
			"которой действует единая система оплаты за проезд на автобусах\n" + 
			"компаний Dan, Egged, Kavim ,Metropoline и поезда.";
	private final static String electricityText = "https://www.iec.co.il/pages/default.aspx" ;
	private final static String arnonaPayBillText = "https://www.mybills.co.il/payments/147/%D7%90%D7%A8%D7%A0%D7%95%D7%A0%D7%94_%D7%AA%D7%9C_%D7%90%D7%91%D7%99%D7%91.html";
	private final static String arnonaDiscountText = "Кому положены скидки по арноне\n" + 
			" \n" + 
			"1. Новые репатрианты\n" + 
			"2. Пожилые люди, получающие пособие по старости\n" + 
			"3. Инвалиды (в том числе и родители детей-инвалидов)\n" + 
			"4. Лица, требующие постоянного ухода\n" + 
			"5. Неполные семьи (матери-одиночки или отцы-одиночки)\n" + 
			"6. Инвалиды ЦАХАЛа и солдаты срочной службы\n" + 
			"7. Пережившие Холокост, узники Сиона\n" + 
			"8. Лица, получающие пособия по прожиточному минимуму\n" + 
			" \n" + 
			"В том случае, если владелец не пользуется квартирой, он  может получить\n" + 
			"одноразовое освобождение от арноны (максимальный срок – 6 месяцев на одно\n" + 
			"помещение).\n" + 
			" \n" + 
			"Освобождение от уплаты налога могут получить те, кто предъявит документы о\n" + 
			"капитальном ремонте жилого помещения (лишь на срок ремонта).\n" + 
			" \n" + 
			"Так же существуют различные скидки на оплату арноны по медицинским\n" + 
			"показателям и экономическому положению.";
	private final static String arnonaText = "Арнона – это муниципальный налог, установленный правительством,\n" + 
			"которым облагается владелец недвижимости или проживающий на\n" + 
			"съемной квартире.";
	private final static String arnonaChnangeAdressText = "https://www.tel-aviv.gov.il/Residents/Arnona/Pages/ArnonaSwitching.aspx";
	private final static String parkingText = "Для того чтобы обеспечить жителей города бесплатной парковкой, местнось\n" + 
			"разделена на различные зоны парковки. Существует официальное\n" + 
			"разрешение на парковку в виде наклейки, которая должна быть прикреплена\n" + 
			"к вашему лобовому стеклу. Жители оговоренной зоны могут припарковать\n" + 
			"авто в любой области с синей и белой разметкой бесплатно. Нерезиденты\n" + 
			"должны платить за парковку в с 9:00 до 17:00 вечера.";
	
	private final static String danLinkText = "http://www.dan.co.il/russian/";
	private final static String eggedLinkText = "http://www.egged.co.il/ru/HomePage.aspx";
	private final static String railLinkText = "https://www.rail.co.il/ru";
	
	
	final static String THE_END_TEXT = "\n-------------------------------------\nСпасибо за обращние! Вам понравилось? Есть еще вопросы?";
	final static String[][] THE_END_MENU = {{"вернуться в главное меню","оставить пожелания"}, {"основной канал Бориса Шиндлера"}};
	private final static String contactMail = "infoshindler@gmail.com";
	private final static String shindlerChannel = "https://t.me/tlv2018";
	private final static String pleaseEnterMailText = "пожалуйста введите адрес электронной почты:";
	private final static String mailSentTextText = "отправлено";
	
	final static HashMap<String,Action> actionsMap = new HashMap<>();
	final static HashMap<String,String> textsMap = new HashMap<>();
	final static HashMap<String,String> backsMap = new HashMap<>();
	final static HashSet<String> isEndCommand = new HashSet<>();

	public interface Action {
		Object getActionMessage(Message m);
	}
	
	
	static {
		Utils.addAction("жилье", Actions::appartment, null, "главное меню", false);
		/**/Utils.addAction("вода", Actions::water, null, "жилье", false);
		/**//**/Utils.addAction("арнона", Actions::arnona, arnonaText, "жилье", false);
		/**//**//**/Utils.addAction("изменить домашний адрес", Actions::arnonaChangeAdress, arnonaChnangeAdressText, "арнона", false);
		/**//**//**//**/Utils.addAction("получить форму на емэйл", Actions::arnonaChangeAdressSendMail, pleaseEnterMailText, "изменить домашний адрес", false);
		/**//**//**//**//**/Utils.addAction("@", Actions::sendMail, mailSentTextText, "изменить домашний адрес", true);
		/**//**//**//**/Utils.addAction("показать форму на экране", Actions::arnonaChangeAdressSendFile, null, "изменить домашний адрес", true);
		/**//**//**/Utils.addAction("оплатить", Actions::arnonaPayBill, arnonaPayBillText, "арнона", true);
		/**//**//**/Utils.addAction("льготы", Actions::arnonaDiscount, arnonaDiscountText, "арнона", true);
		/**/Utils.addAction("уличная канализация", Actions::suige, null, "жилье", false);
		/**/Utils.addAction("комары", Actions::mosqito, null, "жилье", false);
		/**/Utils.addAction("мусор", Actions::garbage, null, "жилье", false);
		/**/Utils.addAction("электричество", Actions::electricity, electricityText, "жилье", true);
		Utils.addAction("транспорт", Actions::transportation, transportationText, "главное меню", false);
		/**/Utils.addAction("Kомпания Дан", Actions::transportationLinks, danLinkText, "транспорт", true);
		/**/Utils.addAction("Кооператив Эгед", Actions::transportationLinks, eggedLinkText, "транспорт", true);
		/**/Utils.addAction("Kомпания Железные дороги Израиля", Actions::transportationLinks, railLinkText, "транспорт", true);
		Utils.addAction("учеба", Actions::education, null, "главное меню", false);
		Utils.addAction("Разрешение на парковку", Actions::parking, parkingText, "главное меню", true);
		Utils.addAction("здоровье", Actions::health, null, "главное меню", false);
		Utils.addAction("документы", Actions::docs, null, "главное меню", false);
		
		Utils.addAction("оставить пожелания", Actions::showMailAtEnd, contactMail, "главное меню", false);
		Utils.addAction("основной канал Бориса Шиндлера", Actions::shindlerMainChannel, shindlerChannel, "главное меню", false);
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
		SendMessage message = Utils.createSendMessage(m, rows);
		return message;
	}
	
	
	public static Object transportation(Message m) {
		String[][] rows = new String[][] {
			{"Kомпания Дан","Кооператив Эгед"},
			{"Kомпания Железные дороги Израиля"}
		}; 
		SendMessage message = Utils.createSendMessage(m, rows);
		return message;
	}
	
	public static Object transportationLinks(Message m) {
		SendMessage message = Utils.createSendMessage(m);
		return message;
	}
	
	public static Object electricity(Message m) {
		SendMessage message = Utils.createSendMessage(m);
		return message;
	}
	
	public static Object arnonaPayBill(Message m) {
		SendMessage message = Utils.createSendMessage(m);
		return message;
	}
	
	public static Object arnonaDiscount(Message m) {
		SendMessage message = Utils.createSendMessage(m);
		return message;
	}
	
	public static Object parking(Message m) {
		SendMessage message = Utils.createSendMessage(m);
		return message;
	}
	
	public static Object health(Message m) {
		SendMessage message = Utils.createSendMessage(m);
		return message;
	}
	
	public static Object docs(Message m) {
		SendMessage message = Utils.createSendMessage(m);
		return message;
	}
	
	public static Object education(Message m) {
		SendMessage message = Utils.createSendMessage(m);
		return message;
	}
	
	public static Object water(Message m) {
		SendMessage message = Utils.createSendMessage(m);
		return message;
	}
	
	public static Object arnona(Message m) {
		
		String[][] rows = new String[][] {
			{"изменить домашний адрес"},
			{"оплатить","льготы"}
		}; 
		SendMessage message = Utils.createSendMessage(m, rows);
		return message;
	}
	
	public static Object suige(Message m) {
		SendMessage message = Utils.createSendMessage(m);
		return message;
	}
	
	public static Object mosqito(Message m) {
		SendMessage message = Utils.createSendMessage(m);
		return message;
	}
	
	public static Object garbage(Message m) {
		SendMessage message = Utils.createSendMessage(m);
		return message;
	}
	
	public static Object arnonaChangeAdress(Message m) {
		
		String[][] rows = new String[][] {
			{"получить форму на емэйл"},
			{"показать форму на экране"}
		}; 
		SendMessage message = Utils.createSendMessage(m, rows);
		return message;
	}
	
	public static Object arnonaChangeAdressSendMail(Message m) {
		SendMessage message = Utils.createSendMessage(m);
		return message;
	}
	
	public static Object sendMail(Message m) {
		SendMessage message = Utils.createSendMessage(m);
		return message;
	}
	
	public static Object arnonaChangeAdressSendFile(Message m) {
		// User sent /pic
		SendDocument docMsg = new SendDocument().setChatId(m.getChatId())
				.setDocument("BQADBAADPAMAAuuBQVKMjF-LtHJ6BwI").setCaption("pdf");
		SendMessage message = Utils.createSendMessage(m);
		return new Object[] {docMsg, message};
	}
	
	public static Object showMailAtEnd(Message m) {
		SendMessage message = Utils.createSendMessage(m);
		return message;
	}
	
	public static Object shindlerMainChannel(Message m) {
		SendMessage message = Utils.createSendMessage(m);
		return message;
	}
}
