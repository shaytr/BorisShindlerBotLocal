package BorisShindlerBot.BorisShindlerBot;

import org.telegram.telegrambots.api.objects.Update;

import java.sql.*;
import java.util.HashSet;
import java.util.Set;

public class UserSet {

    // create a mysql database connection
    private Connection conn;
    // create the java statement
    private Statement st;
    private final String url = "jdbc:mysql://localhost:3306/boris_shindler?autoReconnect=true";
    //private String myDriver = "org.gjt.mm.mysql.Driver";
    private final String myDriver = "com.mysql.jdbc.Driver";
    //
    private final String username = "root";
    private final Set<String> chatIds = new HashSet<>();
    // the mysql insert statement
    private final String queryInput = " insert into users (chat_id, user_id, first_name, last_name)"
            + " values (?, ?, ?, ?)";
    // our SQL SELECT query.
    private final String querySelect = "SELECT chat_id FROM users";

    public void setConnection(String password) {

        try {

            Class.forName(myDriver);
            conn = DriverManager.getConnection(url, username, password);
        } catch (Exception e) {
            System.err.println("Got an exception!" + e);
            System.err.println(e.getMessage());
        }
    }

    public void inserInDB(Long chatId, Integer userId, String firstUserName, String lastUserName) {

        // create the mysql insert preparedstatement
        try {
            PreparedStatement preparedStmt = conn.prepareStatement(queryInput);

            preparedStmt.setLong(1, chatId);
            preparedStmt.setLong(2, userId);
            preparedStmt.setString(3, firstUserName);
            preparedStmt.setString(4, lastUserName);
            // execute the preparedstatement
            preparedStmt.execute();

        } catch (Exception e) {
        	chatIds.remove(Long.toString(chatId));
            e.printStackTrace();
        }
    }

    public void copyFromDataBase() {
        if (chatIds.isEmpty()) {
            try {
                st = conn.createStatement();
                // execute the query, and get a java resultset
                ResultSet rs = st.executeQuery(querySelect);

                while (rs.next()) {
                    chatIds.add(rs.getString("chat_id"));
                }
                st.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public boolean addToSet(Update update) {

        return chatIds.add(Long.toString(update.getMessage().getChatId()));

    }

    public Set<String> getChatIds() {
        return chatIds;
    }

}






