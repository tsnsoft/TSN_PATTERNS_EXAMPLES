package kz.proffix4.patterns;

/*
 * Паттерн "Адаптер" (Adapter) используется для того, чтобы объекты с разными интерфейсами могли работать друг с другом. 
 * Существует два типа адаптеров - Class Adapter и Object Adapter.
 */
interface IHuman {

    void say();
}

class Dog {

    public void gav() {
        System.out.println("Gav!");
    }
}

class DogInHumanAdapterObject implements IHuman {

    private Dog adaptee;

    public DogInHumanAdapterObject(Dog adaptee) {
        this.adaptee = adaptee;
    }

    @Override
    public void say() {
        adaptee.gav();
    }
}

class DogInHumanAdapterClass extends Dog implements IHuman {

    @Override
    public void say() {
        gav();
    }
}

/**
 * ПАТТЕРН "АДАПТЕР" (Adapter)
 *
 */
public class AdapterExample {

    public static void main(String[] args) {
//		DogInHumanAdapterObject serri = new DogInHumanAdapterObject(new Dog());
//		serri.say();
//		
//		DogInHumanAdapterClass lussi = new DogInHumanAdapterClass();
//		lussi.say();

        DogInHumanAdapterClass dog = new DogInHumanAdapterClass();
        dog.gav();
        dog.say();
    }

}
