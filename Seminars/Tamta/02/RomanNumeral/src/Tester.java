public class Tester {
    public static void main(String[] args) {
        RomanNumeral a = new RomanNumeral(3999);
        System.out.println(a.toInt());
        System.out.println(a.toString()); // can omit toString(), since sout calls it internally

        RomanNumeral b = new RomanNumeral("MMMCMXCIX".toLowerCase());
        System.out.println(b.toInt());
        System.out.println(b.toString());

        // Z in romanNumber is wrong
        RomanNumeral c = new RomanNumeral("MMMZMXCIX");
        System.out.println(c.toInt());
        System.out.println(c.toString());

    }
}
