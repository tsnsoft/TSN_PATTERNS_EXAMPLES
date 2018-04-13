package kz.proffix4.patterns;

/*
 * Паттерны проектирования - это описание некоторых проблем, возникающих во время объектно-ориентированного 
 * проектирования, а также способов их решения (как практических, так и теоретических). 
 * Иными словами - это примеры правильных подходов к реению типичных задач проектирования.
 * Одним из самых распространенных паттернов является Singleton (Одиночка). 
 * Задача этого паттерна ограничить количество экземпляров некоторого класса. 
 */
/**
 * Паттерн Singleton (Одиночка)
 *
 */
final class Singleton {

    private static Singleton instance = null;

    private Singleton() { // Запрет на вызов конструктора извне
    }

    public String getWord() { // Полезный метод класса
        return "Hi!";

    }

    ;

	// Метод доступа к классу с первичной инициализацией
	public static synchronized Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}

public class SingletonExample {

    public static void main(String[] args) {
        // Singleton singleton = new Singleton(); // Так нельзя изза защиты синглтона
        System.out.println(Singleton.getInstance().getWord());
        System.out.println(Singleton.getInstance().getWord());
    }

}
