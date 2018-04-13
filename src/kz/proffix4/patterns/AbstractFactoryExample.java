package kz.proffix4.patterns;

/*
 * Абстрактная фабрика предоставляет интерфейс для создания целых семейств объектов
 * без указания конкретных классов. Объекты каждого семейства должны быть логически связаны между собой. 
 */
interface ISquadronFactory {

    public IMage createMage();

    public IArcher createArcher();

    public IWarrior createWarrior();
}

interface IMage {

    public void cast();
}

interface IArcher {

    public void shoot();
}

interface IWarrior {

    public void attack();
}

class ElfMage implements IMage {

    public void cast() {
        System.out.println("Elf cast!");
    }
}

class ElfArcher implements IArcher {

    public void shoot() {
        System.out.println("Elf shoot!");
    }
}

class ElfWarrior implements IWarrior {

    public void attack() {
        System.out.println("Elf attack!");
    }
}

class GoblinWarrior implements IWarrior {

    public void attack() {
        System.out.println("Goblin attack!");
    }
}

class ElfSquadronFactory implements ISquadronFactory {

    public IMage createMage() {
        return new ElfMage();
    }

    public IArcher createArcher() {
        return new ElfArcher();
    }

    public IWarrior createWarrior() {
        return new ElfWarrior();
    }
}

class GoblinSquadronFactory implements ISquadronFactory {

    public IMage createMage() {
        return new ElfMage();
    }

    public IArcher createArcher() {
        return new ElfArcher();
    }

    public IWarrior createWarrior() {
        return new GoblinWarrior();
    }
}

class Squadron {

    IMage mage;
    IArcher archer;
    IWarrior warrior;

    void createSquadron(ISquadronFactory factory) {
        mage = factory.createMage();
        archer = factory.createArcher();
        warrior = factory.createWarrior();
    }

    public IMage getMage() {
        return mage;
    }

    public IArcher getArcher() {
        return archer;
    }

    public IWarrior getWarrior() {
        return warrior;
    }

}

/**
 * ПАТТЕРН "АБСТРАКТНАЯ ФАБРИКА" (Abstract Factory)
 *
 */
public class AbstractFactoryExample {

    public static void main(String[] args) {
        Squadron elfSquadron = new Squadron();
        Squadron goblinSquadron = new Squadron();
        elfSquadron.createSquadron(new ElfSquadronFactory());
        goblinSquadron.createSquadron(new GoblinSquadronFactory());
        goblinSquadron.getMage().cast();
        goblinSquadron.getWarrior().attack();
    }

}
