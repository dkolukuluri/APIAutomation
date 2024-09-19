package api.utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DatabaseUtils {

    private static final String JDBC_URL = "jdbc:mysql://staging-db.cda6fi20nfkr.us-east-2.rds.amazonaws.com:3306/vapor";
    private static final String USER = "vapor";
    private static final String PASSWORD = "t8mzsNwIbkKo3LhuykMXfSAIivpixyXdHqo2P2AX";

    public static String getDataFromDB(String query) throws Exception {
        String result = null;
        Connection connection = DriverManager.getConnection(JDBC_URL, USER, PASSWORD);
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);

        if (resultSet.next()) {
            result = resultSet.getString(1);
        }
        resultSet.close();
        statement.close();
        connection.close();

        return result;
    }
}
