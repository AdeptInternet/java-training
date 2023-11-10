import java.util.Objects;

import static java.lang.String.format;

public class RecordClasses {

    public static void main(String[] args) {
        oldTest();
        newTest();
    }

    private static void oldTest() {
        System.out.println("--- old ---");
        var bob = new OldCustomer("Bob", "bob@acme.com");
        var bob2 = new OldCustomer("Bob", "bob@acme.com");
        System.out.printf("Is %s the sames as %s? %b\n%n", bob.getName(), bob2.getName(), bob.equals(bob2));
    }
    private static void newTest() {
        System.out.println("--- new ---");
        var bob = new NewCustomer("Bob", "bob@acme.com");
        var bob2 = new NewCustomer("Bob", "bob@acme.com");
        System.out.printf("Is %s the sames as %s? %b\n%n", bob.name(), bob2.name(), bob.equals(bob2));
    }

    public static class OldCustomer {
        private final String name;
        private final String email;

        public OldCustomer(String name, String email) {
            this.name = name;
            this.email = email;
        }

        public String getName() {
            return name;
        }

        public String getEmail() {
            return email;
        }

        // explain why we need equals for DTOs

//        @Override
//        public boolean equals(Object o) {
//            if (this == o) return true;
//            if (o == null || getClass() != o.getClass()) return false;
//
//            OldCustomer that = (OldCustomer) o;
//
//            if (!Objects.equals(name, that.name)) return false;
//            return Objects.equals(email, that.email);
//        }

        // explain why we need hashCode for DTOs
        @Override
        public int hashCode() {
            int result = name != null ? name.hashCode() : 0;
            result = 31 * result + (email != null ? email.hashCode() : 0);
            return result;
        }

        @Override
        public String toString() {
            return "OldCustomer{" +
                    "name='" + name + '\'' +
                    ", email='" + email + '\'' +
                    '}';
        }
    }

    // what we get for free
    // access methods
    // toString (but can be overridden)
    // equals
    // hasCode

    public record NewCustomer(String name, String email) {

    }

}
