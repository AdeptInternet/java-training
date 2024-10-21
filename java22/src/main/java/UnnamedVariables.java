import java.util.List;

public class UnnamedVariables {

    public static void main(String[] args) {
        System.out.println(count(List.of("A", "B", "C")));
    }

    private static int count(Iterable<String> orders) {
        int total = 0;
        for (String _ : orders)    // Unnamed variable
            total++;
        return total;
    }

    private static String print(Object object) {
        return switch (object) {
            case String _ -> "A string";
            case Number _ -> "A number";
            default -> "Something else";
        };
    }
}
