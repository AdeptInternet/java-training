/** Example quality: fine.
 *
 * Must mention: This is not a *language* feature per se, since older code on newer VMs seem to also be treated
 * correctly, but still good to know
 */
public class HelpfulNullPointerErrors {

    static class A {
        B b;
    }

    static class B {
        C c;
    }
    static class C {
        String name;
    }

    public static void main(String[] args) {
        var a = new A();
        System.out.println(a.b.c.name);
    }


}
