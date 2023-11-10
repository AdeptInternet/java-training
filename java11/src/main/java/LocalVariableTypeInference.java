import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import static java.lang.String.format;

/**
 * Example quality: contrived but illustrative
 */
public class LocalVariableTypeInference {

    public static void main(String[] args) {
        System.out.println(oldWay(List.of("Inus", "Keagon", "Lian")));
        System.out.println(java11(List.of("Inus", "Keagon", "Lian")));
    }

    public static List<String> oldWay(List<String> names) {
        Calendar cal = new GregorianCalendar();
        String timeOfDay = "evening";
        if (cal.get(Calendar.HOUR_OF_DAY) < 12) {
            timeOfDay = "morning";
        } else if (cal.get(Calendar.HOUR_OF_DAY) < 18) {
            timeOfDay = "afternoon";
        }
        List<String> greets = new ArrayList<>();
        for (String name : names) {
            greets.add(format("Good %s %s!", timeOfDay, name));
        }
        return greets;
    }

    public static List<String> java11(List<String> names) {
        var cal = new GregorianCalendar();
        var timeOfDay = "evening";
        if (cal.get(Calendar.HOUR_OF_DAY) < 12) {
            timeOfDay = "morning";
        } else if (cal.get(Calendar.HOUR_OF_DAY) < 18) {
            timeOfDay = "afternoon";
        }
        var greets = new ArrayList<String>(); // point out that we need to put the type *somewhere*
        for (var name : names) {
            greets.add(format("Good %s %s!", timeOfDay, name));
        }
        return greets;
    }



}
