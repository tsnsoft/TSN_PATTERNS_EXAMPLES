package kz.proffix4.patterns;

/*
 * Паттерн - Prototype (Прототип).
 * Паттерн Prototype позволяет создавать новые объекты на основе некоторого объекта - прототипа,
 * при этом совсем не обязательно знать как необходимый объект устроен
 */
interface ICopyable {

    ICopyable copy();
}

class ComplicatedObject implements ICopyable {

    private Type type;

    public enum Type {
        ONE, TWO
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Type getType() {
        return type;
    }

    public ComplicatedObject copy() {
        ComplicatedObject copyObject = new ComplicatedObject();
        copyObject.setType(this.getType());
        return copyObject;
    }

}

public class PrototypeExample {

    public static void main(String[] args) {
        ComplicatedObject prototype = new ComplicatedObject();
        prototype.setType(ComplicatedObject.Type.ONE);
        ComplicatedObject clone = prototype.copy();
        System.out.println(prototype.getType());
        System.out.println(clone.getType());
        clone.setType(ComplicatedObject.Type.TWO);
        System.out.println(clone.getType());
        System.out.println(prototype.getType());
    }
}
