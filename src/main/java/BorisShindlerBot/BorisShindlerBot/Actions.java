package BorisShindlerBot.BorisShindlerBot;

import java.util.HashMap;
import java.util.HashSet;

import org.telegram.telegrambots.api.methods.send.SendDocument;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Message;

public class Actions {
	public final static String welcomeText = "Вас приветствует чат-бот 'Удобный Тель-Авив' от Бориса Шиндлера.\n" +
			"Получайте всю справочную информацию и справки от городских служб в " + 
			"Вашем 'Telegram', на удобном для Вас языке.";
		
	private final static String transportationText = 
			"В Тель-Авиве развита сеть общественного транспорта. Сеть представленна " +
			"автобусами, микроавтобусами шэрут и поездами. Самым комфортным и " +
			"быстрым видом транспорта являются поезда, самым дешевым – городские " + 
			"автобусы и маршрутки шэрут.\n\n" +
			"*Проездной Rav Kav*\n" + 
			"*Rav Kav* – это персональная электронная карта, которую можно пополнить " + 
			"нужным количеством средств, на ж/д станциях, и использовать для поездок на " +
			"поездах или автобусах, на территории всего государства Израиль.\n" +
			"*Автобусные маршруты* в Израиле обслуживают разные компании. " +
			"Если вы планируете поездки с разными перевозчиками, " +
			"необходимо заплатить отдельно за проезд в каждой компании.\n" +
			"*Цены* на билеты в автобусах Тель-Авива и ближайших городов\n" +
			"Тель-Авив и Центральный округ объединяются в агломерацию Гуш-Дан, в " + 
			"которой действует единая система оплаты за проезд в автобусах, " +
			"компаний *Dan*, *Egged*, *Kavim* ,*Metropoline*, и поездах.";
	private final static String electricityText = "Электрическая компания Израиля " +
			"вырабатывает, поставляеь и распределяет практически всё электричество, " +
			"потребляемое в стране. Государству Израиль принадлежит 99,85 % компании." +
			"При любых проблемах с электричеством стоит обратиться в компанию, по телефону 103 или online\n" +
			"https://www.iec.co.il/pages/default.aspx" ;
	private final static String electricityPayText = "https://www.iec.co.il/pages/billspayment.aspx";
	private final static String arnonaPayBillText = "goo.gl/48zE6D";
	private final static String arnonaDiscountText = "Кому положены скидки по арноне\n" + 
			" \n" + 
			"1. Новым репатриантам\n" +
			"2. Пожилым людям, получающим пособие по старости\n" +
			"3. Инвалидам (в том числе и родителям детей-инвалидов)\n" +
			"4. Лицам, нуждаюшимся в постоянном уходе\n" +
			"5. Неполным семьям (матери-одиночки или отцы-одиночки)\n" +
			"6. Инвалидам ЦАХАЛа и солдатам срочной службы\n" +
			"7. Пережившим Холокост, узникам Сиона\n" +
			"8. Лицам, получающим пособия по прожиточному минимуму\n" +
			" \n" + 
			"В том случае, если владелец не пользуется квартирой, он  может получить " + 
			"одноразовое освобождение от арноны (максимальный срок – 6 месяцев на одно " + 
			"помещение).\n" + 
			" \n" + 
			"Освобождение от уплаты налога могут получить те, кто предъявит документы о " + 
			"капитальном ремонте жилого помещения (лишь на срок ремонта).\n" + 
			" \n" + 
			"Так же существуют различные льготы на оплату арноны по медицинским " +
			"показателям и экономическому положению.";
	private final static String arnonaDiscountApealOnLineText = "Если Вы новый репатриант," +
			" Вам положена 90% скидка на «арнону» в течение первого года после репатриации, на первые 100 метров Вашей квартиры."
			+ "\nhttps://www5.tel-aviv.gov.il/TlvForms/TlvArnonaDiscountRequest/";
	private final static String arnonaText = "Арнона – это муниципальный налог, установленный правительством, " + 
			"которым облагается владелец недвижимости или проживающий на " + 
			"съемной квартире.";
	private final static String arnonaChnangeAdressText = "Перевод «арноны» на Ваше имя лучше всего делать вместе с предыдущим жильцом." +
			" Муниципалитет выписывает предыдущему жильцу квитанцию на оплату до даты начала вашего контракта," +
			" которую он может оплатить на месте. Паралельно, муниципалитет, переводит все будущие выплаты на Ваше имя.\n" +
			"\n" + 
			"Для того, чтобы точно определить адрес Вашей квартиры желательно иметь при себе одну из предыдущих квитанций об оплате." +
			" На ней указан платежный номер вашей квартиры «миспар мешалем». Если у Вас ее нет," +
			" необходимо идентифицировать жилье по номеру «теудат зеута» хозяина, который обязан присутствовать на Вашем договоре об оренде.";
	private final static String arnonaChnangeAdressOnLineText =
			"\nhttps://www.tel-aviv.gov.il/Residents/Arnona/Pages/ArnonaSwitching.aspx";
	private final static String parkingText = "Для того, чтобы обеспечить жителей города бесплатной парковкой, местнось " +
			"разделена на различные зоны парковки. Существует официальное " + 
			"разрешение на парковку в виде наклейки, которая клеится " +
			"на лобовое стекло Вашего автомобиля. Жители оговоренной зоны могут парковать " +
			"авто в любой области с сине-белой разметкой бесплатно. Нерезиденты " +
			"должны платить за парковку с *9:00* до *17:00*.";
	
	private final static String danLinkText = "http://www.dan.co.il/russian/";
	private final static String eggedLinkText = "http://www.egged.co.il/ru/HomePage.aspx";
	private final static String railLinkText = "https://www.rail.co.il/ru";
	
	private final static String parkingApprovalText = "Просьбу о получении наклейки жителя города, для парковки, Вы можете подать online на сайте муниципалитета.\n" +
	"https://www5.tel-aviv.gov.il/TlvForms/Vacation.aspx";
	private final static String parkingFineText = "Когда Вам выписывают штраф за парковку, обычно его оставляют под дворниками, на переднем ветровом стекле. В течение 30 дней Вам, также, дублируются копию штрафа по почте.\n" +
			"У Вас есть 90 дней на оплату штрафа, начиная от даты выдачи.\n" +
			"Вы можете оплатить в любом почтовом отделении, в ближайшем банке или просто позвонив по номеру 106 и предоставив данные Вашей кредитной карты." +
			" Еще один способ оплаты – оплата online на сайте муниципалитета."+
			"\nhttps://www5.tel-aviv.gov.il/tlv4u/parking/Reports/Default.aspx";
	private final static String parkingFineCancelText = "Обжалование штрафа\n" + 
			"Штраф можно обжаловать в случаях," +
			" когда возможно подтвердить следующие ситуации:\n" +
			"•  штраф был выписан несправедливо;\n" + 
			"•  Вы можете доказать, что не нарушали правил парковки Израиля;\n" +
			"•  есть доказательства медицинской или иной чрезвычайной ситуации.\n" + 
			"В таком случае Вы можете представить доказательства в отдел парковки муниципалитета."+
			"\nhttps://www5.tel-aviv.gov.il/TlvForms/Vacation.aspx";
	
	private final static String waterText = "Вода в Израиле находится в распоряжении «водных концернов» («таагидей маим»)," +
			" у каждого муниципалитета есть свой концерн. \n" +
			"\n" + 
			"Важный совет: водный тариф зависит от количества людей, проживающих в квартире." +
			" На каждого человека полагается 7 кубических метров воды, на два месяца по «низкому» тарифу." +
			" Последующие кубометры уже будут стоить Вам гораздо больше. " +
			"Для того, чтобы послать уведомление о количестве человек проживающих в квартире, следует заполнить соответствующую форму и приложить к ней копии всех «теудат зеутов» (с «сефахом»!), всех проживающих старше 18 лет. " +
			"Дети младше 18 лет прописаны во вкладышах («сефах») своих родителей.";
	
	private final static String waterNumPplDeclarationText = 
			"Водный тариф зависит от количества людей, проживающих в квартире." +
					" Для того, чтобы послать уведомление о количестве человек, проживающих в квартире, следует также заполнить форму.\n" +
			"\n" + 
			"https://www.mybusiness-websuite-files.com/MeyAvivimWebsite/newcase1.asp?formId=2";
	private final static String waterPayText = "https://paybill.milgam.co.il";
	private final static String garbageText = "Если около Вашего дома есть мусор или Ваш мусорный бак переполнен, Вам необхожимо позвонить в муниципальную службу,по номеру 106, и попросить убрать мусор.";
	private final static String suigeText = "Муниципалитет отвечает за канализацию на улице. Все что касается канализации внутри дома лежит на ответственности жильцов каждой квартиры." +
			" Если на улице прорвало канализационный люк, Вам необходимо обратиться в муниципалитет, по номеру 106, и сообщить о проблеме." +
			" Если проблема с канализацикй внутри дома, Вам необходимо обратиться к сантехнику.";
	private final static String suigeOnLineText = "https://www5.tel-aviv.gov.il/TlvForms/tlvPublicPetition/Default.aspx?st=17";
	final static String THE_END_TEXT = "\n-------------------------------------\n_Спасибо за обращние! Вам понравилось? Имеются ли у Вас еще вопросы?" +
			" Буду рад услишат Ваши пожелания на моей офицалной странице в Фейсбуке" +
			" Подписывайтесь на мой оффицалный телеграм канал :)_";
	
	final static String[][] THE_END_MENU = {{"оставить пожелания", "страница ФБ Бориса Шиндлера"}, {"основной канал Бориса Шиндлера", "вернуться в главное меню"}};
	private final static String contactMail = "infoshindler@gmail.com";
	private final static String shindlerChannelText = "https://t.me/tlv2018";
	private final static String shindlerFBText = "https://www.facebook.com/ListOfShindler/";
	
	private final static String pleaseEnterMailText = "пожалуйста введите адрес электронной почты:";
	private final static String mailSentTextText = "отправлено";
	private final static String gazText = "Обеспечение газом, в Израиле, осыществляется через систему централизованной подачи газа или с помощью газовых баллонов.\n" +
			"\n" + 
			"Вы можете выбрать поставщика из списка\n" + 
			"Цена газа разная у каждого поставщика, стоит проверять цены отдельно:\n" +
			"https://www.amisragas.co.il/Eng/Index.asp?CategoryID=119&ArticleID=215\n" + 
			"\n" + 
			"http://www.doralongas.co.il/%D7%97%D7%93%D7%A9%D7%95%D7%AA-%D7%95%D7%A2%D7%93%D7%9B%D7%95%D7%A0%D7%99%D7%9D/%D7%94%D7%AA%D7%A7%D7%A0%D7%AA-%D7%92%D7%96-%D7%9C%D7%91%D7%99%D7%AA/\n" + 
			"\n" + 
			"http://www.gazyagel.co.il/%D7%92%D7%96-%D7%91%D7%99%D7%AA%D7%99.html\n" + 
			"\n" + 
			"https://www.pazgas.co.il/he/"; 
	private final static String mosqitoText = "При муниципалитете существует специальное отделение, которое занимается уничтожением комаров и других вредителей." +
			" Если у Вас возле дома открытый источник воды, Вы можете обратиться по телефону 106, для устранения нежелательных насикомых.";
	private final static String TODO_TEXT = "*в разработке...*";
	
	final static HashMap<String,Action> actionsMap = new HashMap<>();
	final static HashMap<String,String> textsMap = new HashMap<>();
	final static HashMap<String,String> backsMap = new HashMap<>();
	final static HashSet<String> isEndCommand = new HashSet<>();

	public interface Action {
		Object getActionMessage(Message m);
	}
	
	
	static {
		Utils.addAction("арнона", Actions::arnona, arnonaText, "главное меню", false);
		/**/Utils.addAction("изменить домашний адрес", Actions::arnonaChangeAdress, arnonaChnangeAdressText, "арнона", false);
		/**//**/Utils.addAction("получить форму на e-mail", Actions::genericAction, pleaseEnterMailText, "изменить домашний адрес", false);
		/**//**//**/Utils.addAction("@", Actions::sendMail, mailSentTextText, "изменить домашний адрес", true);
		/**//**/Utils.addAction("показать форму на экране", Actions::arnonaChangeAdressSendFile, null, "изменить домашний адрес", true);
		/**//**/Utils.addAction("подать форму online", Actions::genericAction, arnonaChnangeAdressOnLineText, "изменить домашний адрес", true);
		/**/Utils.addAction("оплатить", Actions::genericAction, arnonaPayBillText, "арнона", true);
		/**/Utils.addAction("льготы", Actions::arnonaDiscount, arnonaDiscountText, "арнона", false);
		/**//**/Utils.addAction("Подать просьбу на скидку online", Actions::genericAction, arnonaDiscountApealOnLineText, "льготы", true);
		Utils.addAction("жилье", Actions::appartment, null, "главное меню", false);
		/**/Utils.addAction("вода", Actions::water, waterText, "жилье", false);
		/**//**/Utils.addAction("Декларация количества людей online", Actions::genericAction, waterNumPplDeclarationText, "вода", true);
		/**//**/Utils.addAction("Оплатить счет воды", Actions::genericAction, waterPayText, "вода", true);
		/**/Utils.addAction("уличная канализация", Actions::suige, suigeText, "жилье", false);
		/**//**/Utils.addAction("Обращение online о проблемах канализации", Actions::genericAction, suigeOnLineText, "уличная канализация", true);
		/**/Utils.addAction("комары", Actions::genericAction, mosqitoText, "жилье", true);
		/**/Utils.addAction("мусор", Actions::genericAction, garbageText, "жилье", true);
		/**/Utils.addAction("электричество", Actions::electricity, electricityText, "жилье", false);
		/**//**/Utils.addAction("Оплата электричества", Actions::genericAction, electricityPayText, "электричество", true);
		/**/Utils.addAction("газ", Actions::genericAction, gazText, "жилье", true);
		Utils.addAction("транспорт", Actions::transportation, transportationText, "главное меню", false);
		/**/Utils.addAction("Kомпания Дан", Actions::genericAction, danLinkText, "транспорт", true);
		/**/Utils.addAction("Кооператив Эгед", Actions::genericAction, eggedLinkText, "транспорт", true);
		/**/Utils.addAction("Kомпания Железные дороги Израиля", Actions::genericAction, railLinkText, "транспорт", true);
		Utils.addAction("учеба", Actions::genericAction, TODO_TEXT, "главное меню", false);
		Utils.addAction("Разрешение на парковку", Actions::parking, parkingText, "главное меню", false);
		/**/Utils.addAction("получит разрешение на парковку", Actions::genericAction, parkingApprovalText, "Разрешение на парковку", true);
		/**/Utils.addAction("заплатит штраф", Actions::genericAction, parkingFineText, "Разрешение на парковку", true);
		/**/Utils.addAction("отменит штраф", Actions::genericAction, parkingFineCancelText, "Разрешение на парковку", true);	
		Utils.addAction("здоровье", Actions::genericAction, TODO_TEXT, "главное меню", false);
		Utils.addAction("документы", Actions::genericAction, null, "главное меню", false);
		
		Utils.addAction("оставить пожелания", Actions::genericAction, contactMail, "главное меню", false);
		Utils.addAction("основной канал Бориса Шиндлера", Actions::genericAction, shindlerChannelText, "главное меню", false);
		Utils.addAction("страница ФБ Бориса Шиндлера", Actions::genericAction, shindlerFBText, "главное меню", false);

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
			{"вода","газ","мусор", "комары"},
			{"уличная канализация", "электричество"}
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
	
	public static Object genericAction(Message m) {
		SendMessage message = Utils.createSendMessage(m);
		return message;
	}
	
	public static Object electricity(Message m) {
		String[][] rows = new String[][] {
			{"Оплата электричества"}
		}; 
		SendMessage message = Utils.createSendMessage(m, rows);
		return message;
	}
	
	public static Object arnonaDiscount(Message m) {
		String[][] rows = new String[][] {
			{"Подать просьбу на скидку online"}
		}; 
		SendMessage message = Utils.createSendMessage(m, rows);
		return message;
	}
	
	public static Object parking(Message m) {
		String[][] rows = new String[][] {
			{"получит разрешение на парковку"},
			{"заплатит штраф", "отменит штраф"}
		}; 
		SendMessage message = Utils.createSendMessage(m, rows);
		return message;
	}
	
	public static Object water(Message m) {
		String[][] rows = new String[][] {
			{"Декларация количества людей online"},
			{"Оплатить счет воды"}
		}; 
		SendMessage message = Utils.createSendMessage(m, rows);
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
		String[][] rows = new String[][] {
			{"Обращение online о проблемах канализации"}
		}; 
		SendMessage message = Utils.createSendMessage(m, rows);
		return message;
	}
	
	public static Object arnonaChangeAdress(Message m) {
		
		String[][] rows = new String[][] {
			{"получить форму на e-mail", "подать форму online"},
			{"показать форму на экране"}
		}; 
		SendMessage message = Utils.createSendMessage(m, rows);
		return message;
	}
	
	public static Object sendMail(Message m) {
		//TODO How to send mail ?? for now just send file
		SendDocument docMsg = new SendDocument().setChatId(m.getChatId())
				.setDocument("BQADBAADPAMAAuuBQVKMjF-LtHJ6BwI").setCaption("pdf");
		SendMessage message = Utils.createSendMessage(m);
		return new Object[] {docMsg, message};
	}
	
	public static Object arnonaChangeAdressSendFile(Message m) {
		SendDocument docMsg = new SendDocument().setChatId(m.getChatId())
				.setDocument("BQADBAADPAMAAuuBQVKMjF-LtHJ6BwI").setCaption("pdf");
		SendMessage message = Utils.createSendMessage(m);
		return new Object[] {docMsg, message};
	}
}
