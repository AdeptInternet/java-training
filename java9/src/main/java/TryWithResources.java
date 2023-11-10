import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/** Example qualiry: Real world  */
public class TryWithResources {

    private static final String SQL_URL = "jdbc:mysql://localhost:3360/clients";
    private static final String SQL_USER = "root";
    private static final String SQL_PASSWORD = "dev";

    /**
     * Good: Terse and understandable and logical.
     * Bad: We're not closing resources - explain why bad
     */

    public List<String> badWay() throws SQLException {
        Connection con = DriverManager.getConnection(SQL_URL, SQL_USER, SQL_PASSWORD);
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT email FROM CLIENT WHERE name='Bob");
        List<String> emails = new ArrayList<>();
        while (rs.next()) {
            emails.add(rs.getString("email"));
        }
        return emails;
    }

    /**
     * Good: We're closing resources. Will close irrespective the error (we can get other errors than checked exceptions)
     * Bad: We need to write more resource code than actual useful code. Need to understand sequence of resource allocation
     */

    public List<String> goodWay() throws SQLException {
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            con = DriverManager.getConnection(SQL_URL, SQL_USER, SQL_PASSWORD);
            stmt = con.createStatement();
            rs = stmt.executeQuery("SELECT email FROM CLIENT WHERE name='Bob");
            List<String> emails = new ArrayList<>();
            while (rs.next()) {
                emails.add(rs.getString("email"));
            }
            return emails;
        } finally {
            if (con != null) {
                if (stmt != null) {
                    if (rs != null) {
                        rs.close();
                    }
                    stmt.close();
                }
                con.close();

            }
        }
    }

    /** Good: We're relying on try-with-resources and auto-closeable to deal with it
     * Good: Terse, we only have code for what we do
     */
    public List<String> java9Way() throws SQLException {
        try (Connection con = DriverManager.getConnection(SQL_URL, SQL_USER, SQL_PASSWORD);
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT email FROM CLIENT WHERE name='Bob")) {
            List<String> emails = new ArrayList<>();
            while (rs.next()) {
                emails.add(rs.getString("email"));
            }
            return emails;
        }
    }

}
