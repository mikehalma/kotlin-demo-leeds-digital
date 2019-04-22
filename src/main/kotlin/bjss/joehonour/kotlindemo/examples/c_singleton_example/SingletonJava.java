package bjss.joehonour.kotlindemo.examples.c_singleton_example;

public class SingletonJava {

    private static SingletonJava INSTANCE = null;

    public static SingletonJava getSingleton() {
        if (INSTANCE == null) {
            INSTANCE = new SingletonJava();
        }

        return INSTANCE;
    }
}
