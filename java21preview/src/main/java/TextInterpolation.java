import static java.util.FormatProcessor.FMT;

public class TextInterpolation {

    public static void main(String[] args) {
        test("Inus", 30.0713);
    }
    public static void test(String name, double temp) {
        var template =  FMT."""
                Hello there \{name}!
                It is %.1f\{temp} degrees outside
                """;
        System.out.println(template);
    }

}
