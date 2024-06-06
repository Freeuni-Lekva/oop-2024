public class Cat {
    private final static String name = "myCat";
    private int age;

    public int getAge() {
        return age;
    }

    public static String getName() {
        return name;
    }

    public void meow(){
        System.out.println("Meow!");
    }

    private void thisIsPrivate(){
        System.out.println("I am a private function");
    }

    private static void heyImPrivateAndStatic(){
        System.out.println("I am a private and static function");
    }
}
