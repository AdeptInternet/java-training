import static java.lang.String.format;

public class RecordPatterns {

    public static void main(String[] args) {
        var p1 = new Point(1.0, 2.0);
        var p2 = new Point(5.0, 6.0);
        var l = new Line(p1, p2);
        instanceOfExample(p1);
        instanceOfExample(l);
        switchExample(p1);
        switchExample(l);
    }

    public record Point(double x, double y) {

    }

    public record Line(Point start, Point end) {

    }

    static void instanceOfExample(Object o) {
        if (o instanceof Point(double x, double y)) {
            System.out.printf("I have a point at %.2f,%.2f%n", x, y);
        }
        if (o instanceof Line(Point(double x1, double y1), Point(double x2, double y2))) {
            System.out.printf("I have a line from %.2f,%.2f to %.2f,%.2f%n", x1, y1, x2, y2);
        }

    }

    static void switchExample(Object o) {
        switch (o) {
            case Point(double x, double y) -> System.out.printf("I have a point at %.2f,%.2f%n", x, y);
            case Line(Point(double x1, double y1), Point(double x2, double y2)) ->
                    System.out.printf("I have a line from %.2f,%.2f to %.2f,%.2f%n", x1, y1, x2, y2);
            default -> System.out.println("no idea");
        }

    }

}
