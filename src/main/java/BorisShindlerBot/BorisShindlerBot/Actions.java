package BorisShindlerBot.BorisShindlerBot;

import java.util.HashMap;
import java.util.HashSet;

import org.telegram.telegrambots.api.methods.send.SendDocument;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Message;

public class Actions {
    public final static String welcomeText = "Вас приветствует чат-бот 'Удобный Тель-Авив' от Бориса Шиндлера.\n" +
            "Получайте всю справочную информацию и справки от городских служб в \n" +
            "Вашем 'Telegram' на удобном для Вас языке.\n";

    private final static String transportationText =
            "В Тель-Авиве развита сеть общественного транспорта. Сеть представлена " +
                    "автобусами, микроавтобусами шэрут и поездами. Наиболее комфортным и \n" +
                    "быстрым видом транспорта являются поезда, самым дешевым – городские\n" +
                    "автобусы и маршрутки шэрут.\n\n\n" +
                    "Проездной Rav Kav*+ \n" +
                    "Rav Kav* – это персональная электронная карта, которую можно пополнить\n" +
                    "нужным количеством средств, на ж/д станциях и использовать для поездок на\n" +
                    "поездах или автобусах на территории всего государства Израиль.\n" +
                    "Автобусные маршруты в Израиле обслуживают разные компании.\n" +
                    "Если вы планируете поездки с разными перевозчиками,\n" +
                    "необходимо заплатить за проезд отдельно в каждой компании.\n" +
                    "Цены на билеты в автобусах Тель-Авива и ближайших городов\n" +
                    "(Тель-Авив и Центральный округ) объединяются в агломерацию Гуш-Дан, в\n" +
                    "которой действует единая система оплаты проезда в автобусах\n" +
                    "компаний *Dan*, *Egged*, *Kavim* ,*Metropoline* и поездах.\n";
    private final static String electricityText = "Электроэнергетическая компания Израиля вырабатывает," +
            " поставляет и распределяет практически всё электричество,\n" +
            "потребляемое в стране. Государству Израиль принадлежат 99,85% компании.\n" +
            "При любых проблемах с электричеством стоит обратиться в компанию по телефону *103* или в онлайн-режиме.\n" +
            "https://www.iec.co.il/pages/default.aspx";
    private final static String electricityPayText = "https://www.iec.co.il/pages/billspayment.aspx";
    private final static String arnonaPayBillText = "goo.gl/48zE6D";
    private final static String arnonaDiscountText = "Кому положены скидки по арноне:\n" +
            " \n" +
            " • Новым репатриантам.\n" +
            " • Пожилым людям, получающим пособие для пожилых людей.\n" +
            " • Людям с инвалидностью (в том числе и родителям детей-инвалидов).\n" +
            " • Лицам, нуждающимся в постоянном уходе.\n" +
            " • Неполным семьям (матери-одиночки или отцы-одиночки).\n" +
            " • Инвалидам ЦАХАЛа и солдатам срочной службы.\n" +
            " • Людям, пережившим Холокост, узникам Сиона.\n" +
            " • Лицам, получающим пособия по прожиточному минимуму.\n" +
            " \n" +
            "В том случае, если владелец не пользуется квартирой, он может получить \n" +
            "одноразовое освобождение от арноны (максимальный срок – 6 месяцев на одно\n" +
            "помещение).\n" +
            " \n" +
            "Освобождение от уплаты налога могут получить те, кто предъявит документы о\n" +
            " капитальном ремонте жилого помещения (лишь на срок ремонта\n" +
            " \n" +
            "Также существуют различные льготы на оплату арноны по медицинским\n" +
            " показателям и экономическому положению.\n";
    private final static String arnonaDiscountApealOnLineText = "Если Вы - новый репатриант, " +
            "Вам положена скидка 90% на арнону в течение первого года после репатриации," +
            " на первые 100 метров Вашей квартиры."
            + "\nhttps://www5.tel-aviv.gov.il/TlvForms/TlvArnonaDiscountRequest/";
    private final static String arnonaText = "Арнона – это муниципальный налог, установленный правительством, \n" +
            "которым облагается владелец недвижимости или человек, проживающий на\n" +
            "съемной квартире.\n";
    private final static String arnonaChnangeAdressText = "Перевод арноны на Ваше имя лучше всего делать вместе с предыдущим жильцом.\n" +
            "Муниципалитет выписывает предыдущему жильцу квитанцию на оплату до изначальной даты вашего контракта,\n" +
            "которую он может оплатить на месте. Параллельно муниципалитет переводит все будущие выплаты на Ваше имя.\n" +
            "\n" +
            "Для того чтобы точно определить адрес Вашей квартиры," +
            " желательно иметь при себе одну из предыдущих квитанций об оплате.\n" +
            "На ней указан платежный номер Вашей квартиры «миспар мешалем». Если у Вас ее нет,\n" +
            "необходимо идентифицировать жилье по номеру «теудат зеута» хозяина," +
            " который должен быть отмечен в Вашем договоре об аренде\n";
    private final static String arnonaChnangeAdressOnLineText =
            "\nhttps://www.tel-aviv.gov.il/Residents/Arnona/Pages/ArnonaSwitching.aspx";
    private final static String parkingText = "Для того чтобы обеспечить жителей города бесплатной парковкой, местность\n" +
            "разделена на различные парковочные зоны. Существует официальное\n" +
            "разрешение на парковку в виде наклейки, которая клеится\n" +
            "на лобовое стекло Вашего автомобиля. Жители оговоренной зоны могут парковать\n" +
            "авто в любой области с сине-белой разметкой бесплатно. Нерезиденты\n" +
            "должны платить парковку с *9:00* до *17:00*.\n";

    private final static String danLinkText = "http://www.dan.co.il/russian/";
    private final static String eggedLinkText = "http://www.egged.co.il/ru/HomePage.aspx";
    private final static String railLinkText = "https://www.rail.co.il/ru";

    private final static String parkingApprovalText = "Просьбу о получении наклейки жителя города для парковки " +
            "Вы можете подать онлайн на сайте муниципалитета.\n" +
            "https://www5.tel-aviv.gov.il/TlvForms/Parking/tlvTagRequest/Default.aspx";
    private final static String parkingFineText = "Выписанный штраф за парковку обычно оставляют под дворниками," +
            " на переднем ветровом стекле. В течение 30 дней Вам также высылают копию штрафа по почте.\n" +
            "У Вас есть 90 дней на оплату штрафа, начиная от даты выдачи.\n" +
            "Вы можете оплатить его в любом почтовом отделении, в ближайшем банке " +
            "или просто позвонив по номеру *106* и предоставив данные Вашей кредитной карты.\n" +
            "Еще один способ оплаты – online, на сайте муниципалитета\n" +
            "\nhttps://www5.tel-aviv.gov.il/tlv4u/parking/Reports/Default.aspx";
    private final static String parkingFineCancelText =
            "Штраф можно обжаловать в случаях," +
                    "когда возможно подтвердить следующие ситуации:\n" +
                    " • Штраф был выписан несправедливо.\n" +
                    " • Вы можете доказать, что не нарушали правил парковки Израиля.\n" +
                    " • Есть доказательства медицинской или иной чрезвычайной ситуации.\n" +
                    "В таких случаях Вы можете представить доказательства в отделе парковки муниципалитета.\n" +
                    "\nhttps://www5.tel-aviv.gov.il/TlvForms/Parking/tlvObjectionReport/Default.aspx";

    private final static String waterText = "Вода в Израиле находится в распоряжении «водных концернов» («таагидей маим»),\n" +
            "у каждого муниципалитета есть свой концерн.\n" +
            "\n" +
            "Важный совет: водный тариф зависит от количества людей, проживающих в квартире.\n" +
            "На каждого человека полагается 7 кубических метров воды на два месяца по «низкому» тарифу.\n" +
            "Последующие кубометры обойдутся Вам гораздо дороже.\n" +
            "Для того чтобы послать уведомление о количестве человек, проживающих в квартире, следует заполнить соответствующую форму и приложить к ней копии всех «теудат зеутов» (с «сефахом»!), всех проживающих лиц старше 18 лет.\n" +
            "Дети младше 18 лет прописаны во вкладышах («сефах») своих родителей.\n";

    private final static String waterNumPplDeclarationText =
            "Водный тариф зависит от количества людей, проживающих в квартире." +
                    " Для того чтобы послать уведомление о количестве человек, проживающих в квартире, следует также заполнить форму.\n" +
                    "\n" +
                    "https://www.mybusiness-websuite-files.com/MeyAvivimWebsite/newcase1.asp?formId=2";
    private final static String waterPayText = "https://paybill.milgam.co.il";
    private final static String garbageText = "Если около Вашего дома есть мусор или Ваш мусорный бак переполнен, Вам необходимо позвонить в муниципальную службу по номеру *106* и попросить убрать мусор.";
    private final static String suigeText = "Муниципалитет отвечает за уличную канализацию. Все, что касается канализации внутри дома," +
            " находится в зоне ответственности жильцов каждой квартиры.\n" +
            "Если на улице прорвало канализационный люк, Вам необходимо обратиться в муниципалитет по номеру *106* и сообщить о проблеме.\n" +
            "Если есть проблема с канализацией внутри дома, Вам необходимо обратиться к сантехнику.\n";
    private final static String suigeOnLineText = "https://www5.tel-aviv.gov.il/TlvForms/tlvPublicPetition/Default.aspx?st=17";
    final static String THE_END_TEXT = "\n-------------------------------------\n_Спасибо за обращение! Вам понравилось? Есть ли у Вас еще вопросы?\n" +
            "Буду рад услышать Ваши пожелания на моей официальной странице в Фейсбуке!\n" +
            "Подписывайтесь на мой официальный Телеграм-канал :)_\n";

    final static String[][] THE_END_MENU = {{"Оставить пожелания", "Страница ФБ Бориса Шиндлера"}, {"Основной канал Бориса Шиндлера", "Вернуться в главное меню"}};
    private final static String contactMail = "infoshindler@gmail.com";
    private final static String shindlerChannelText = "https://t.me/tlv2018";
    private final static String shindlerFBText = "fb://profile/898906540272648";
    private final static String shindlerSite = "http://shindler.co.il";

    private final static String pleaseEnterMailText = "пожалуйста введите адрес электронной почты:";
    private final static String mailSentTextText = "отправлено";
    private final static String gazText = "Обеспечение газом в Израиле осуществляется посредством системы централизованной подачи газа или " +
            "с помощью газовых баллонов." +
            "\n" +
            "Вы можете выбрать поставщика из списка. \n" +
            "Цена газа разная у каждого поставщика, стоит проверять цены отдельно:\n" +
            "https://www.amisragas.co.il/Eng/Index.asp?CategoryID=119&ArticleID=215\n" +
            "\n" +
            "http://www.doralongas.co.il/%D7%97%D7%93%D7%A9%D7%95%D7%AA-%D7%95%D7%A2%D7%93%D7%9B%D7%95%D7%A0%D7%99%D7%9D/%D7%94%D7%AA%D7%A7%D7%A0%D7%AA-%D7%92%D7%96-%D7%9C%D7%91%D7%99%D7%AA/\n" +
            "\n" +
            "http://www.gazyagel.co.il/%D7%92%D7%96-%D7%91%D7%99%D7%AA%D7%99.html\n" +
            "\n" +
            "https://www.pazgas.co.il/he/";
    private final static String mosqitoText = "При муниципалитете существует специальное отделение, которое занимается уничтожением комаров и других вредителей.\n" +
            "Если возле Вашего дома расположен открытый источник воды, Вы можете обратиться по телефону *106* для устранения нежелательных насекомых.\n";
    private final static String TODO_TEXT = "*в разработке...*";
    private final static String ABOUT_BOT = "Борис Шиндлер\n" +
            "Кандидат в депутаты горсовета Тель-Авива 30/10/2018\n" +
            "В Тель-Авиве проживает около 50 000 русскоязычных жителей, и у многих из них есть проблемы, которые можно было бы решить на уровне городского совета.\n" +
            "На муниципальных выборах избирается мэр города (прямым тайным голосованием) и городской совет, члены которого избираются по партийным спискам (не только общеизральских партий, но и местных городских политических объединений). \n" +
            "социальный стартапер, инициатор социальных проектов с 15-летним опытом работы в сфере развития общественных некоммерческих организаций. Основная специализация – инициация и управление социальными и общественно-просветительскими проектами \n" +
            "Дата рождения 1981г. \n" +
            "Место рождения – Кривой Рог, СССР (Украина) \n" +
            "Дата репатриации 1990г. \n" +
            "Место проживания – Флорентин, Тель-Авив \n" +
            "Образование: Семинар Хакибуцим, бакалавр по педагогике \n" +
            "Лицензия педагога от Министерства образования Израиля \n" +
            "Специализация: литература и ТаНаХ \n" +
            "В 2015 газета Едиот Ахронот включила Бориса Шиндлера в ТОП-50 социальных «ангелов» Израиля \n" +
            "2017 — 2018 – координатор партии НДИ в Тель-Авиве \n" +
            "2016 — 2018 – финансовый и административный директор в \"Topaz\" – ведущей некоммерческой организации, поддерживающей инновации в социальном предпринимательстве \n" +
            "С 2015 – соучредитель, член правления, глава русскоязычного штаба и исследовательского центра движения по защите прав частных предпринимателей. \n" +
            "С 2015 – Соучредитель лобби по продвижению «полуторного поколения» молодых русскоязычных израильтян \n" +
            "2014 — 2016 Управляющий финансами и международными проектами в сообществе молодых русскоязычных Израильтян «Фишка». \n" +
            "2013 — 2015 – соучредитель общественной организации «OneDay Social Volunteering», занимающейся привлечением молодежи в волонтерские проекты. \n" +
            "2009 — 2012 – менеджер по обучению и квалификации отдела по связям Бюро по связям «Натив» при канцелярии премьер-министра \n" +
            "2010 — 2014 – член оргкомитета «Лимуд» \n" +
            "Узнать более подробную информацию о Борисе Шиндлере и его проектах, а так же оставить отзывы и предложения, можно на официальных каналах Боримса Шиндлера\n" +
            shindlerSite + "\nсайт Бориса Шиндлера \n";


    final static HashMap<String, Action> actionsMap = new HashMap<>();
    final static HashMap<String, String> textsMap = new HashMap<>();
    final static HashMap<String, String> backsMap = new HashMap<>();
    final static HashSet<String> isEndCommand = new HashSet<>();

    public interface Action {
        Object getActionMessage(Message m);
    }


    static {
        Utils.addAction("Арнона", Actions::arnona, arnonaText, "Главное меню", false);
        /**/
        Utils.addAction("Изменить домашний адрес", Actions::arnonaChangeAdress, arnonaChnangeAdressText, "Арнона", false);
        /**//**/
        Utils.addAction("Получить форму на e-mail", Actions::genericAction, pleaseEnterMailText, "Изменить домашний адрес", false);
        /**//**//**/
        Utils.addAction("@", Actions::sendMail, mailSentTextText, "Изменить домашний адрес", true);
        /**//**/
        Utils.addAction("Показать форму на экране", Actions::arnonaChangeAdressSendFile, null, "Изменить домашний адрес", true);
        /**//**/
        Utils.addAction("Подать форму online", Actions::genericAction, arnonaChnangeAdressOnLineText, "Изменить домашний адрес", true);
        /**/
        Utils.addAction("Оплатить", Actions::genericAction, arnonaPayBillText, "Арнона", true);
        /**/
        Utils.addAction("Льготы", Actions::arnonaDiscount, arnonaDiscountText, "Арнона", false);
        /**//**/
        Utils.addAction("Подать просьбу на скидку online", Actions::genericAction, arnonaDiscountApealOnLineText, "Льготы", true);
        Utils.addAction("Жилье", Actions::appartment, null, "Главное меню", false);
        /**/
        Utils.addAction("Вода", Actions::water, waterText, "Жилье", false);
        /**//**/
        Utils.addAction("Декларация количества людей online", Actions::genericAction, waterNumPplDeclarationText, "Вода", true);
        /**//**/
        Utils.addAction("Оплатить счет воды", Actions::genericAction, waterPayText, "Вода", true);
        /**/
        Utils.addAction("Уличная канализация", Actions::suige, suigeText, "Жилье", false);
        /**//**/
        Utils.addAction("Обращение online о проблемах канализации", Actions::genericAction, suigeOnLineText, "Уличная канализация", true);
        /**/
        Utils.addAction("Комары", Actions::genericAction, mosqitoText, "Жилье", true);
        /**/
        Utils.addAction("Мусор", Actions::genericAction, garbageText, "Жилье", true);
        /**/
        Utils.addAction("Электричество", Actions::electricity, electricityText, "Жилье", false);
        /**//**/
        Utils.addAction("Оплата электричества", Actions::genericAction, electricityPayText, "Электричество", true);
        /**/
        Utils.addAction("Газ", Actions::genericAction, gazText, "Жилье", true);
        Utils.addAction("Транспорт", Actions::transportation, transportationText, "Главное меню", false);
        /**/
        Utils.addAction("Kомпания Дан", Actions::genericAction, danLinkText, "Транспорт", true);
        /**/
        Utils.addAction("Кооператив Эгед", Actions::genericAction, eggedLinkText, "Транспорт", true);
        /**/
        Utils.addAction("Kомпания Железные дороги Израиля", Actions::genericAction, railLinkText, "Транспорт", true);
        Utils.addAction("Учеба", Actions::genericAction, TODO_TEXT, "Главное меню", false);
        Utils.addAction("Разрешение на парковку", Actions::parking, parkingText, "Главное меню", false);
        /**/
        Utils.addAction("Получить разрешение на парковку", Actions::genericAction, parkingApprovalText, "Разрешение на парковку", true);
        /**/
        Utils.addAction("Заплатить штраф", Actions::genericAction, parkingFineText, "Разрешение на парковку", true);
        /**/
        Utils.addAction("Отменить штраф", Actions::genericAction, parkingFineCancelText, "Разрешение на парковку", true);
        Utils.addAction("Здоровье", Actions::genericAction, TODO_TEXT, "Главное меню", false);
        Utils.addAction("Документы", Actions::genericAction, null, "Главное меню", false);
        Utils.addAction("О Боте", Actions::genericAction, ABOUT_BOT, "Главное меню", true);

        Utils.addAction("Оставить пожелания", Actions::genericAction, contactMail, "Главное меню", false);
        Utils.addAction("Основной канал Бориса Шиндлера", Actions::genericAction, shindlerChannelText, "Главное меню", false);
        Utils.addAction("Страница ФБ Бориса Шиндлера", Actions::genericAction, shindlerFBText, "Главное меню", false);

    }

    public static Object getAction(String command, Message message) {
        Action action = actionsMap.get(command);
        if (action != null) {
            return action.getActionMessage(message);
        }
        return null;
    }

    public static Object appartment(Message m) {
        String[][] rows = new String[][]{
                {"Вода", "Газ", "Мусор", "Комары"},
                {"Уличная канализация", "Электричество"}
        };
        SendMessage message = Utils.createSendMessage(m, rows);
        return message;
    }


    public static Object transportation(Message m) {
        String[][] rows = new String[][]{
                {"Kомпания Дан", "Кооператив Эгед"},
                {"Kомпания Железные дороги Израиля"}
        };
        SendMessage message = Utils.createSendMessage(m, rows);
        return message;
    }

    public static Object genericAction(Message m) {
        SendMessage message = Utils.createSendMessage(m);
        return message;
    }
    
    public static Object aboutBot(Message m) {
        SendMessage message = Utils.createSendMessage(m);
        message.enableHtml(true);
        return message;
    }

    public static Object electricity(Message m) {
        String[][] rows = new String[][]{
                {"Оплата электричества"}
        };
        SendMessage message = Utils.createSendMessage(m, rows);
        return message;
    }

    public static Object arnonaDiscount(Message m) {
        String[][] rows = new String[][]{
                {"Подать просьбу на скидку online"}
        };
        SendMessage message = Utils.createSendMessage(m, rows);
        return message;
    }

    public static Object parking(Message m) {
        String[][] rows = new String[][]{
                {"Получить разрешение на парковку"},
                {"Заплатить штраф", "Отменить штраф"}
        };
        SendMessage message = Utils.createSendMessage(m, rows);
        return message;
    }

    public static Object water(Message m) {
        String[][] rows = new String[][]{
                {"Декларация количества людей online"},
                {"Оплатить счет воды"}
        };
        SendMessage message = Utils.createSendMessage(m, rows);
        return message;
    }

    public static Object arnona(Message m) {

        String[][] rows = new String[][]{
                {"Изменить домашний адрес"},
                {"Оплатить", "Льготы"}
        };
        SendMessage message = Utils.createSendMessage(m, rows);
        return message;
    }

    public static Object suige(Message m) {
        String[][] rows = new String[][]{
                {"Обращение online о проблемах канализации"}
        };
        SendMessage message = Utils.createSendMessage(m, rows);
        return message;
    }

    public static Object arnonaChangeAdress(Message m) {

        String[][] rows = new String[][]{
                {"Получить форму на e-mail", "Подать форму online"},
                {"Показать форму на экране"}
        };
        SendMessage message = Utils.createSendMessage(m, rows);
        return message;
    }

    public static Object sendMail(Message m) {
        //TODO How to send mail ?? for now just send file
        SendDocument docMsg = new SendDocument().setChatId(m.getChatId())
                .setDocument("BQADBAADPAMAAuuBQVKMjF-LtHJ6BwI").setCaption("pdf");
        SendMessage message = Utils.createSendMessage(m);
        return new Object[]{docMsg, message};
    }

    public static Object arnonaChangeAdressSendFile(Message m) {
        SendDocument docMsg = new SendDocument().setChatId(m.getChatId())
                .setDocument("BQADBAADPAMAAuuBQVKMjF-LtHJ6BwI").setCaption("pdf");
        SendMessage message = Utils.createSendMessage(m);
        return new Object[]{docMsg, message};
    }
}
