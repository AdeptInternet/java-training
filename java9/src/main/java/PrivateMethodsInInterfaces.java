import static java.lang.String.format;

/** Example quality: contrived */
public class PrivateMethodsInInterfaces {

    interface OldWay1 {


          default String actLikeATeenAger(String text) {
            return addEmojis(shout(text));
        }

        /** Bad: User can now think it may be good to re-implement this */
        default String addEmojis(String text) {
            // pretend this is complicated code you don't want to expose to the world.
            return format("🤷‍♂️%s👀",text);
        }

        /** Bad: User can now think it may be good to re-implement this */
        default String shout(String text) {
            // pretend this is complicated code you don't want to expose to the world.
            return text.toUpperCase();
        }


    }

    interface OldWay2 {


        default String actLikeATeenAger(String text) {
                       return format("🤷‍♂️%s👀",text.toUpperCase());
        }

    }

    interface Java9Way {

        default String actLikeATeenAger(String text) {
            return addEmojis(shout(text));
        }

        private String addEmojis(String text) {
            // pretend this is complicated code you don't want to expose to the world.
            return format("🤷‍♂️%s👀",text);
        }

        private String shout(String text) {
            // pretend this is complicated code you don't want to expose to the world.
            return text.toUpperCase();
        }

    }



}
