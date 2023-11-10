import static java.lang.String.format;

public class SealedClasses {


    public abstract static sealed class Animal permits Cat, Dog {

        private final String name;

        public Animal(String name) {
            this.name = name;
        }

        public abstract String makeNoise();

        public String getName() {
            return name;
        }
    }

    public static final class Cat extends Animal {
        public Cat(String name) {
            super(name);
        }

        @Override
        public String makeNoise() {
            return "Meow!";
        }
    }

    public static final class Dog extends Animal {
        public Dog(String name) {
            super(name);
        }

        @Override
        public String makeNoise() {
            return "Woof";
        }

    }

    // show compiler is unhappy when we go off script

//    public static final class Bird extends Animal {
//        public Bird(String name) {
//            super(name);
//        }
//
//        @Override
//        public String makeNoise() {
//            return "Tweet";
//        }
//    }

}
