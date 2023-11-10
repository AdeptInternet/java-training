import java.util.Date;

public class PatternMatchSwitch {

    public static void main(String[] args) {
        System.out.println(guardedSwitchPattern(1));
        System.out.println(guardedSwitchPattern(-1));
        System.out.println(guardedSwitchPattern(1.0));
        System.out.println(guardedSwitchPattern(-1.0));
        System.out.println(guardedSwitchPattern(new Date()));
    }

    public static String guardedSwitchPattern(Object o) {
        return switch (o) {
            case Integer i when i < 0 -> String.format("(%d)", i);
            case Integer i -> String.format("%d", i);
            case Double d when d < 0.0 -> String.format("(%.2f)", d);
            case Double d -> String.format("%.2f", d);
            default -> o.toString();
        };
    }

}
