package learningJava;

public class WorkWithTypes {

    public static void main(String[] args) {

        byte a = 15;
        int b = 137;
        double c = 5.5;
        String str = "137 more then 15 that's true";
        String fail = "fail";

            System.out.println("a + b = " + (a + b));
            System.out.println("a - b = " + (a - b));
            System.out.println("a / b = " + a / b);
            System.out.println("b % a = " + b % a);
            System.out.println("a++ = " + a++);
            System.out.println(a);
            System.out.println("++a = " + ++a);
            System.out.println(a);

        //переполнение
            a = 20;
            System.out.println("a^2 = " + (byte) (a * a));

            System.out.println("a > b = " + (a > b));
            System.out.println("a != b = " + (a != b));
            System.out.println("a == b = " + (a == b));
            System.out.println("a < b = " + (a < b) + ", " + str);

        String result =  (a < b) || (137 > 15) ? str : fail;
        System.out.println(result);

        System.out.println("a + b - c = " + (a + b - c));

    }
}