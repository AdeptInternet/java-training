/** Example quality: contrived but good
 */
public class SwitchExperssions {

    enum Vertebrates {
        MAMAL,
        FISH,
        REPTILE,
        AVIAN,
        AMPHIBIAN;


        public static void main(String[] args) {
            var animal = AVIAN;
            System.out.printf("I feel %s when I encounter a %s\n", oldWay(animal), animal.name().toLowerCase());
            System.out.printf("I feel %s when I encounter a %s\n", java14Way(animal), animal.name().toLowerCase());
        }

        public static String oldWay(Vertebrates type) {
            var emotion = "indifferent";
            switch (type) {
                case FISH:
                case AVIAN: emotion = "jealous"; // I wish I could fly or swim better
                    break;
                case REPTILE: emotion = "scared"; // I am scared of snakes
                    break;
                case AMPHIBIAN:
                case MAMAL: emotion = "hungry"; // I like a good steak, but hope it's not cat or dog
                    break;
// explain the risks:
// what happens if we forget the break
// what happens if we add a new type
            }
            return emotion;
        }
    }

    public static String java14Way(Vertebrates type) {
        return switch (type) {
            case FISH, AVIAN ->  "jealous"; // I wish I could fly or swim better
            case REPTILE ->  "scared"; // I am scared of snakes
            case MAMAL, AMPHIBIAN -> "hungry"; // I like a good steak, but hope it's not cat or dog
        };
        // explain safety from exhaustiveness
        // show example of adding Amphibia to vertebrates
    }

    public static String otherExample(String type) {
        return switch (type) {
            case  "FISH" -> "jealous";
            default ->  "kinda fine";
        };
    }

}
