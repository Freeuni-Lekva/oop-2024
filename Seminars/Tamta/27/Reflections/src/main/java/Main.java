import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class Main {

    public static void main(String[] args) throws IllegalAccessException, NoSuchFieldException, InvocationTargetException {
        Cat cat = new Cat();
        Field[] fields = cat.getClass().getDeclaredFields();

        System.out.println("age when starting: " + cat.getAge());
        System.out.println("\nfields:");
        for (Field field: fields) {
            System.out.print(field.getName() + ": ");
            System.out.println(field.getType());
        }

        fields[1].setAccessible(true);
        fields[1].set(cat, 3);

        System.out.println("\nage now: " + cat.getAge());
        System.out.println("name: " + Cat.getName());

        Method[] methods = cat.getClass().getDeclaredMethods();

        System.out.println("\nfunctions:");
        for (Method method: methods) {
            System.out.println(method.getName());
            if(method.getName().equals("meow")){
                method.invoke(cat);
            }
            if(method.getName().equals("heyImPrivate")){
                method.setAccessible(true);
                method.invoke(cat);
            }
            if(method.getName().equals("heyImPrivateAndStatic")){
                method.setAccessible(true);
                method.invoke(null);
            }

        }
    }
}
