import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import static java.lang.String.format;

public class PatternMatchInstanceOf {

    private static final DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    public static String oldWay(Object val) {
        if (val instanceof Double) {
            var d = (Double)val;
            if (d < 0.0) {
                return format("(%.2f)", d);
            }
            else {
                return format("%.2f", d);

            }
        }
        if (val instanceof Date) {
            return dateFormat.format((Date)val);
        }

        return "no idea";
    }


    public static String java16way(Object val) {
        if (val instanceof Double d) {
            if (d < 0.0) {
                return format("(%.2f)", d);
            }
            else {
                return format("%.2f", d);

            }
        }
        if (val instanceof Date date) {
            return dateFormat.format(date);
        }
        return "no idea";
    }

    public static String java16wayOther(Object val) {
        if (val instanceof Double d && d < 0.0) {
            return format("(%.2f)", d);
        }
        if (val instanceof Double d && d >= 0.0) {
                return format("%.2f", d);
        }
        if (val instanceof Date date) {
            return dateFormat.format(date);
        }
        return "no idea";
    }



}
