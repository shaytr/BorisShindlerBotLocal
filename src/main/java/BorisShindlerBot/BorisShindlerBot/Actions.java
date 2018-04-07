package BorisShindlerBot.BorisShindlerBot;

import java.util.HashMap;
import java.util.HashSet;

import org.telegram.telegrambots.api.methods.send.SendDocument;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Message;

public class Actions {
	public final static String welcomeText = "Вас приветствует чат-бот удобного Тель-Авива от Бориса Шиндлера.\n" + 
			"Получайте всю справочную информацию и справки от городских служб в " + 
			"вашем Телеграме на вашем языке.";
		
	private final static String transportationText = 
			"В Тель-Авиве развитая сеть общественного транспорта, представленная " + 
			"автобусами, микроавтобусами шерут и поездами. Самым комфортным и " + 
			"быстрым видом транспорта являются поезда, самым дешевым – городские " + 
			"автобусы и маршрутки шерут.\n\n" + 
			"*Проездной Rav Kav*\n" + 
			"*Rav Kav* – это персональная электронная карта, которую можно пополнить " + 
			"нужным количеством поездок на ж/д станциях и использовать для поездок на " + 
			"поезде или автобусе на территории выбранного вами города Израиля.\n" + 
			"*Автобусные маршруты* в Израиле обслуживают разные компании, поэтому, " + 
			"если вы планируете поездки с разными автобусными перевозчиками, то " + 
			"придется заплатить по отдельности за проезд в каждой компании и положить " + 
			"эти средства на свою карту Rav Kav.\n" + 
			"*Цены* на билеты на автобус в Тель-Авиве и ближайших городах\n" + 
			"Тель-Авив и Центральный округ объединяются в агломерацию Гуш-Дан, в " + 
			"которой действует единая система оплаты за проезд на автобусах " + 
			"компаний *Dan*, *Egged*, *Kavim* ,*Metropoline* и поезда.";
	private final static String electricityText = "Электрическая компания Израиля (Производит, передает и распределяет практически всё электричество, используемое в стране. Государству Израиль принадлежит приблизительно 99,85 % Компании." +
			"При любой проблеме с электричеством стоит обратиться в электро компанию по телефону 103 или он Лайн\n" +
			"https://www.iec.co.il/pages/default.aspx" ;
	private final static String electricityPayText = "https://www.iec.co.il/pages/billspayment.aspx";
	private final static String arnonaPayBillText = "goo.gl/48zE6D";
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
			"В том случае, если владелец не пользуется квартирой, он  может получить " + 
			"одноразовое освобождение от арноны (максимальный срок – 6 месяцев на одно " + 
			"помещение).\n" + 
			" \n" + 
			"Освобождение от уплаты налога могут получить те, кто предъявит документы о " + 
			"капитальном ремонте жилого помещения (лишь на срок ремонта).\n" + 
			" \n" + 
			"Так же существуют различные скидки на оплату арноны по медицинским " + 
			"показателям и экономическому положению.";
	private final static String arnonaDiscountApealOnLineText = "Если вы новый репатриант, вам полагается 90% скидка на «арнону» в течение первого года после репатриации, на первые 100 метров вашей квартиры."
			+ "\nhttps://www5.tel-aviv.gov.il/TlvForms/TlvArnonaDiscountRequest/";
	private final static String arnonaText = "Арнона – это муниципальный налог, установленный правительством, " + 
			"которым облагается владелец недвижимости или проживающий на " + 
			"съемной квартире.";
	private final static String arnonaChnangeAdressText = "Перевод «арноны» на ваше имя лучше всего делать вместе с предыдущим жильцом, тогда они выписывают ему квитанцию на оплату до даты начала вашего контракта, которую он может сразу же на месте оплатить. Паралельно, они переводят все будущие выплаты на ваше имя.\n" + 
			"\n" + 
			"Для того, чтобы точно определить адрес вашей квартиры в муниципалитете советую иметь при себе одну из предыдущих квитанций об оплате, на ней они смогут увидеть так называемый платежный номер вашей квартиры «миспар мешалем». Если у вас ее нет, не беспокойтесь, они смогут идентифицировать жилье по номеру «теудат зеута» его хозяина, который должен фигурировать на вашем договоре о съеме.";
	private final static String arnonaChnangeAdressOnLineText =
			"\nhttps://www.tel-aviv.gov.il/Residents/Arnona/Pages/ArnonaSwitching.aspx";
	private final static String parkingText = "Для того чтобы обеспечить жителей города бесплатной парковкой, местнось " + 
			"разделена на различные зоны парковки. Существует официальное " + 
			"разрешение на парковку в виде наклейки, которая должна быть прикреплена " + 
			"к вашему лобовому стеклу. Жители оговоренной зоны могут припарковать " + 
			"авто в любой области с синей и белой разметкой бесплатно. Нерезиденты " + 
			"должны платить за парковку в с *9:00* до *17:00* вечера.";
	
	private final static String danLinkText = "http://www.dan.co.il/russian/";
	private final static String eggedLinkText = "http://www.egged.co.il/ru/HomePage.aspx";
	private final static String railLinkText = "https://www.rail.co.il/ru";
	
	private final static String parkingApprovalText = "Просьбу о получении наклейки жителя города для парковки вы можете подать  онлайн на сайте  Муниципалитета.\n" + 
	"https://www5.tel-aviv.gov.il/TlvForms/Vacation.aspx";
	private final static String parkingFineText = "Когда вам выписывают штраф за парковку, обычно его кладут под дворники на переднем ветровом стекле. В течение 30 дней вам также дублируют копию штрафа по почте.\n" + 
			"У вас есть 90 дней на оплату штрафа, начиная от даты выдачи.\n" + 
			"Вы можете оплатить в любом отделении почтового отделения, в ближайшем банке или просто позвонить в 106 и предоставив данные вашей кредитной карты. Еще один вариант – оплата онлайн на сайте муниципалитета."+ 
			"\nhttps://www5.tel-aviv.gov.il/tlv4u/parking/Reports/Default.aspx";
	private final static String parkingFineCancelText = "Обжалование штрафа\n" + 
			"Штраф можно обжаловать в случаях, если можете подтвердить документально или есть письменные доказательства следующих ситуаций:\n" + 
			"•  штраф был выписан несправедливо;\n" + 
			"•  вы можете доказать, что не нарушали правил парковки Израиля;\n" + 
			"•  есть доказательства медицинской или иной чрезвычайной ситуации.\n" + 
			"В таком случае вы можете представить доказательства в отдел парковки муниципалитета."+
			"\nhttps://www5.tel-aviv.gov.il/TlvForms/Vacation.aspx";
	
	private final static String waterText = "Вода в Израиле находится в распоряжении так называемых «водных концернов» («таагидей маим»), у каждого муниципалитета есть свой концерн. \n" + 
			"\n" + 
			"Важный совет: водный тариф зависит от количества людей, проживающих в квартире. На каждого человека полагается 7 кубических метров воды на два месяца по «низкому» тарифу. Последующие кубометры уже будут стоить вам гораздо больше. Для того, чтобы послать уведомление о количестве человек, проживающих в квартире следует также заполнить соответствующую форму и приложить к ней копии всех «теудат зеутов» (с «сефахом»!) всех проживающих старше 18 лет. Дети меньше 18 лет прописаны во вкладышах («сефах») своих родителей.";
	
	private final static String waterNumPplDeclarationText = 
			"Водный тариф зависит от количества людей, проживающих в квартире.. Для того, чтобы послать уведомление о количестве человек, проживающих в квартире следует также заполнить форму.\n" + 
			"\n" + 
			"https://www.mybusiness-websuite-files.com/MeyAvivimWebsite/newcase1.asp?formId=2";
	private final static String waterPayText = "https://paybill.milgam.co.il";
	private final static String garbageText = "Если около вашего дома есть мусор или ваш мусорный бак переполнен вам надо позвонить в муниципальную службу 106 и попросить убрать мусор.";
	private final static String suigeText = "Муниципалитет отвечает за канализацию на улице. Все что касается канализации внутри дома в ответственности каждого каждой квартиры. Если на улице прорвало люк канализации вам нужно обратиться в В муниципалитет 106 и сообщить о проблеме. Если проблема с канализации внутри дома то вам надо обратиться к сантехнику.";
	private final static String suigeOnLineText = "https://www5.tel-aviv.gov.il/TlvForms/tlvPublicPetition/Default.aspx?st=17";
	final static String THE_END_TEXT = "\n-------------------------------------\n_Спасибо за обращние! Вам понравилось? Есть еще вопросы?" + 
			" Буду рад услишат ваши пожелания на моей офицалной странице в Фейсбуке" + 
			" Подписывайтесь на мой оффицалный телеграм канал :)_";
	
	final static String[][] THE_END_MENU = {{"оставить пожелания", "страница ФБ Бориса Шиндлера"}, {"основной канал Бориса Шиндлера", "вернуться в главное меню"}};
	private final static String contactMail = "infoshindler@gmail.com";
	private final static String shindlerChannelText = "https://t.me/tlv2018";
	private final static String shindlerFBText = "https://www.facebook.com/ListOfShindler/";
	
	private final static String pleaseEnterMailText = "пожалуйста введите адрес электронной почты:";
	private final static String mailSentTextText = "отправлено";
	private final static String gazText = "В Израиле газом обеспечивает через систему централизованной подачи газа или с помощью баллонов.\n" + 
			"\n" + 
			"Вы можете выбрать поставщика из списка\n" + 
			"Цена газа разная у каждого поставщика и стоит и её проверить:\n" + 
			"https://www.amisragas.co.il/Eng/Index.asp?CategoryID=119&ArticleID=215\n" + 
			"\n" + 
			"http://www.doralongas.co.il/%D7%97%D7%93%D7%A9%D7%95%D7%AA-%D7%95%D7%A2%D7%93%D7%9B%D7%95%D7%A0%D7%99%D7%9D/%D7%94%D7%AA%D7%A7%D7%A0%D7%AA-%D7%92%D7%96-%D7%9C%D7%91%D7%99%D7%AA/\n" + 
			"\n" + 
			"http://www.gazyagel.co.il/%D7%92%D7%96-%D7%91%D7%99%D7%AA%D7%99.html\n" + 
			"\n" + 
			"https://www.pazgas.co.il/he/"; 
	private final static String mosqitoText = "При муниципалитете существует специальное отделение которая занимается уничтожением Комаров и других вредителей. Если у вас возле дома открытый источник воды вы можете обратиться по телефону 106 для удобрения Комаров";
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
		/**//**/Utils.addAction("получить форму на емэйл", Actions::arnonaChangeAdressSendMail, pleaseEnterMailText, "изменить домашний адрес", false);
		/**//**//**/Utils.addAction("@", Actions::sendMail, mailSentTextText, "изменить домашний адрес", true);
		/**//**/Utils.addAction("показать форму на экране", Actions::arnonaChangeAdressSendFile, null, "изменить домашний адрес", true);
		/**//**/Utils.addAction("подать форму он лайн", Actions::arnonaChangeAdressOnLine, arnonaChnangeAdressOnLineText, "изменить домашний адрес", true);
		/**/Utils.addAction("оплатить", Actions::arnonaPayBill, arnonaPayBillText, "арнона", true);
		/**/Utils.addAction("льготы", Actions::arnonaDiscount, arnonaDiscountText, "арнона", false);
		/**//**/Utils.addAction("Подать просбу на скидку он лайн", Actions::arnonaDiscountApealOnLine, arnonaDiscountApealOnLineText, "льготы", true);
		Utils.addAction("жилье", Actions::appartment, null, "главное меню", false);
		/**/Utils.addAction("вода", Actions::water, waterText, "жилье", false);
		/**//**/Utils.addAction("Декларация количества людей он лайн", Actions::waterNumPplDeclaration, waterNumPplDeclarationText, "вода", true);
		/**//**/Utils.addAction("Оплатит  счет воды", Actions::waterPay, waterPayText, "вода", true);		
		/**/Utils.addAction("уличная канализация", Actions::suige, suigeText, "жилье", false);
		/**//**/Utils.addAction("Обращение он лайн о проблемах канализации", Actions::suigeOnLine, suigeOnLineText, "уличная канализация", true);
		/**/Utils.addAction("комары", Actions::mosqito, mosqitoText, "жилье", true);
		/**/Utils.addAction("мусор", Actions::garbage, garbageText, "жилье", true);
		/**/Utils.addAction("электричество", Actions::electricity, electricityText, "жилье", false);
		/**//**/Utils.addAction("Оплата электричества", Actions::electricityPay, electricityPayText, "электричество", true);
		/**/Utils.addAction("газ", Actions::gaz, gazText, "жилье", true);
		Utils.addAction("транспорт", Actions::transportation, transportationText, "главное меню", false);
		/**/Utils.addAction("Kомпания Дан", Actions::transportationLinks, danLinkText, "транспорт", true);
		/**/Utils.addAction("Кооператив Эгед", Actions::transportationLinks, eggedLinkText, "транспорт", true);
		/**/Utils.addAction("Kомпания Железные дороги Израиля", Actions::transportationLinks, railLinkText, "транспорт", true);
		Utils.addAction("учеба", Actions::education, TODO_TEXT, "главное меню", false);
		Utils.addAction("Разрешение на парковку", Actions::parking, parkingText, "главное меню", false);
		/**/Utils.addAction("получит разрешение на парковку", Actions::parkingApproval, parkingApprovalText, "Разрешение на парковку", true);
		/**/Utils.addAction("заплатит штраф", Actions::parkingFine, parkingFineText, "Разрешение на парковку", true);
		/**/Utils.addAction("отменит штраф", Actions::parkingFineCancel, parkingFineCancelText, "Разрешение на парковку", true);	
		Utils.addAction("здоровье", Actions::health, TODO_TEXT, "главное меню", false);
		Utils.addAction("документы", Actions::docs, null, "главное меню", false);
		
		Utils.addAction("оставить пожелания", Actions::showMailAtEnd, contactMail, "главное меню", false);
		Utils.addAction("основной канал Бориса Шиндлера", Actions::shindlerMainChannel, shindlerChannelText, "главное меню", false);
		Utils.addAction("страница ФБ Бориса Шиндлера", Actions::shindlerMainFB, shindlerFBText, "главное меню", false);

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
	
	public static Object transportationLinks(Message m) {
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
	public static Object electricityPay(Message m) {
		SendMessage message = Utils.createSendMessage(m);
		return message;
	}	
	public static Object arnonaPayBill(Message m) {
		SendMessage message = Utils.createSendMessage(m);
		return message;
	}
	
	public static Object arnonaDiscount(Message m) {
		String[][] rows = new String[][] {
			{"Подать просбу на скидку он лайн"}
		}; 
		SendMessage message = Utils.createSendMessage(m, rows);
		return message;
	}
	public static Object arnonaDiscountApealOnLine(Message m) {
		SendMessage message = Utils.createSendMessage(m);
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
		String[][] rows = new String[][] {
			{"Декларация количества людей он лайн"},
			{"Оплатит  счет воды"}
		}; 
		SendMessage message = Utils.createSendMessage(m, rows);
		return message;
	}
	public static Object waterNumPplDeclaration(Message m) {
		SendMessage message = Utils.createSendMessage(m);
		return message;
	}
	public static Object waterPay(Message m) {
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
		String[][] rows = new String[][] {
			{"Обращение он лайн о проблемах канализации"}
		}; 
		SendMessage message = Utils.createSendMessage(m, rows);
		return message;
	}
	
	public static Object suigeOnLine(Message m) {
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
			{"получить форму на емэйл", "подать форму он лайн"},
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
	
	public static Object arnonaChangeAdressOnLine(Message m) {
		SendMessage message = Utils.createSendMessage(m);
		return message;
	}
	
	public static Object showMailAtEnd(Message m) {
		SendMessage message = Utils.createSendMessage(m);
		return message;
	}
	
	public static Object shindlerMainChannel(Message m) {
		SendMessage message = Utils.createSendMessage(m);
		return message;
	}
	
	public static Object shindlerMainFB(Message m) {
		SendMessage message = Utils.createSendMessage(m);
		return message;
	}
	
	public static Object parkingApproval(Message m) {
		SendMessage message = Utils.createSendMessage(m);
		return message;
	}
	
	public static Object parkingFine(Message m) {
		SendMessage message = Utils.createSendMessage(m);
		return message;
	}
	
	public static Object parkingFineCancel(Message m) {
		SendMessage message = Utils.createSendMessage(m);
		return message;
	}
	
	public static Object gaz(Message m) {
		SendMessage message = Utils.createSendMessage(m);
		return message;
	}
}
