package api.utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import org.json.JSONArray;
import org.json.JSONObject;
 
public class DatabaseUtils {
    // Database connection properties
    private static final String JDBC_URL = "jdbc:mysql://staging-db.cda6fi20nfkr.us-east-2.rds.amazonaws.com:3306/vapor";
    private static final String USER = "vapor";
    private static final String PASSWORD = "t8mzsNwIbkKo3LhuykMXfSAIivpixyXdHqo2P2AX";
 
    public static String getresult_fromdb(String query) {
        Connection conn = null;
        Statement stmt = null;
        JSONArray jsonArray = null;
        try {
            // Step 1: Register JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");
 
            // Step 2: Open a connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(JDBC_URL, USER, PASSWORD);
 
            // Step 3: Execute a query
            System.out.println("Creating statement...");
            stmt = conn.createStatement();
            String sql = query; // Replace with your query
            ResultSet rs = stmt.executeQuery(sql);
 
            // Step 4: Convert ResultSet to JSON
            jsonArray = convertResultSetToJSON(rs);
 
            // Step 5: Print the JSON array
            System.out.println(jsonArray.toString(4)); // Pretty print JSON with 4 space indentation
 
            // Step 6: Clean-up environment
            rs.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
		return jsonArray.toString(4);
    }
 
    // Utility method to convert ResultSet to JSON
    public static JSONArray convertResultSetToJSON(ResultSet resultSet) throws Exception {
        JSONArray jsonArray = new JSONArray();
        ResultSetMetaData metaData = resultSet.getMetaData();
        int columnCount = metaData.getColumnCount();
 
        while (resultSet.next()) {
            JSONObject jsonObject = new JSONObject();
            for (int i = 1; i <= columnCount; i++) {
                String columnName = metaData.getColumnLabel(i);
                Object columnValue = resultSet.getObject(i);
                jsonObject.put(columnName, columnValue);
            }
            jsonArray.put(jsonObject);
        }
        return jsonArray;
    }
}
