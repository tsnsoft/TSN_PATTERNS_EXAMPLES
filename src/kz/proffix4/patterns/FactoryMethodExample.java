package kz.proffix4.patterns;

import java.io.File;
import java.io.StringWriter;

/*
 * Factory Method - это паттерн создания объектов (creational pattern). 
 * Данный шаблон проектирования предоставляет интерфейс для создания экземпляров некоторого класса. 
 * В момент создания наследники могут определить, какой класс инстанциировать. 
 * Иными словами, Фабрика делегирует создание объектов наследникам родительского класса. 
 * Это позволяет использовать в коде программы не специфические классы, 
 * а манипулировать абстрактными объектами на более высоком уровне.
 */
abstract class AbstractWriter {

    public abstract void write(Object context);
}

class ConcreteFileWriter extends AbstractWriter {

    public void write(Object context) {
        System.out.println("FileWriter: " + context);
    }
}

class ConcreteConsoleWriter extends AbstractWriter {

    public void write(Object context) {
        System.out.println("ConsoleWriter: " + context);
    }
}

class FactoryMethod {

    public AbstractWriter getWriter(Object object) {
        AbstractWriter writer = null;
        if (object instanceof File) {
            writer = new ConcreteFileWriter();
        } else {
            writer = new ConcreteConsoleWriter();
        }
        return writer;
    }
}

/**
 * ПАТТЕРН "ФАБРИКА" (Factory Method)
 *
 */
public class FactoryMethodExample {

    public static void main(String[] args) {
        FactoryMethod factoryMethod = new FactoryMethod();
        factoryMethod.getWriter(new File("demo.txt")).write("Hi!");
        factoryMethod.getWriter(new StringWriter()).write("Hi!");
    }

}
