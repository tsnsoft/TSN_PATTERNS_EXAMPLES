package kz.proffix4.patterns;

/*
 * Паттерн Builder (Строитель) является паттерном создания объектов (creational pattern).
 * Суть его заключается в том, чтобы отделить процесс создания некоторого сложного объекта
 * от его представления. Таким образом, можно получать различные представления объекта,
 * используя один и тот же “технологический” процесс.
 */
/**
 * Паттерн Builder (Строитель)
 *
 */
class Computer {

    private String display = null;
    private String systemBlock = null;
    private String manipulators = null;

    public void setDisplay(String display) {
        this.display = display;
    }

    public void setSystemBlock(String systemBlock) {
        this.systemBlock = systemBlock;
    }

    public void setManipulators(String manipulators) {
        this.manipulators = manipulators;
    }

    @Override
    public String toString() {
        return String.format("Computer [display=%s, systemBlock=%s, manipulators=%s]", display, systemBlock,
                manipulators);
    }
}

abstract class ComputerBuilder {

    protected Computer computer;

    public Computer getComputer() {
        return computer;
    }

    public void createNewComputer() {
        computer = new Computer();
    }

    public abstract void buildSystemBlock();

    public abstract void buildDisplay();

    public abstract void buildManipulators();
}

class CheapComputerBuilder extends ComputerBuilder {

    @Override
    public void buildSystemBlock() {
        computer.setSystemBlock("Everest");
    }

    @Override
    public void buildDisplay() {
        computer.setDisplay("CRT");
    }

    @Override
    public void buildManipulators() {
        computer.setManipulators("mouse+keyboard");
    }
}

class Director {

    private ComputerBuilder computerBuilder;

    public void setComputerBuilder(ComputerBuilder computerBuilder) {
        this.computerBuilder = computerBuilder;
    }

    public Computer getComputer() {
        return computerBuilder.getComputer();
    }

    public void constructComputer() {
        computerBuilder.createNewComputer();
        computerBuilder.buildSystemBlock();
        computerBuilder.buildDisplay();
        computerBuilder.buildManipulators();
    }
}

public class BuilderExample {

    public static void main(String[] args) {
        Director director = new Director();
        ComputerBuilder cheapComputerBuilder = new CheapComputerBuilder();

        director.setComputerBuilder(cheapComputerBuilder);
        director.constructComputer();

        Computer computer = director.getComputer();
        System.out.println(computer);

    }

}
