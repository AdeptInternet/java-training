import static java.lang.String.format;

public class TextBlocks {

    private static final String oldWay =
            "<html>\n" +
            "  <body>\n" +
            "    <p>Hello, %s</p>\n" +
            "  </body>\n" +
            "</html>";

    private static final String newWay = """
            <html>
              <body>
                <p>Hello, %s</p>
              </body>
            </html>
            """;

    private static String FIND_CUSTOMER_SQL = """
            SELECT name,email from Customer WHERE name='%s'
            ORDER BY email
            LIMIT 100;
            """;

    public static void main(String[] args) {

        System.out.printf(FIND_CUSTOMER_SQL+ "%n", "Bob");

//        System.out.printf((oldWay) + "%n", "Barry");
//        System.out.printf((newWay) + "%n", "Barry");
    }

}
