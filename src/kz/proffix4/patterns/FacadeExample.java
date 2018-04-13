package kz.proffix4.patterns;

/* Шаблон фасад (англ. Facade) — структурный шаблон проектирования, 
 * позволяющий скрыть сложность системы путем сведения всех возможных 
 * внешних вызовов к одному объекту, делегирующему их соответствующим объектам системы.*/
class CPU {

    public void freeze() {
    }

    public void jump(long position) {
    }

    public void execute() {
    }
}

class Memory {

    public void load(long position, byte[] data) {
    }
}

class HardDrive {

    public byte[] read(long lba, int size) {
        return null;
    }
}

/* Facade */
class PersonalComputer {

    private static final long BOOT_ADDRESS = 0;
    private static final long BOOT_SECTOR = 1;
    private static final int SECTOR_SIZE = 512;

    private CPU cpu;
    private Memory memory;
    private HardDrive hardDrive;

    public PersonalComputer() {
        this.cpu = new CPU();
        this.memory = new Memory();
        this.hardDrive = new HardDrive();
    }

    public void startComputer() {
        cpu.freeze();
        memory.load(BOOT_ADDRESS, hardDrive.read(BOOT_SECTOR, SECTOR_SIZE));
        cpu.jump(BOOT_ADDRESS);
        cpu.execute();
    }
}

/* Client */
public class FacadeExample {

    public static void main(String[] args) {
        PersonalComputer computer = new PersonalComputer();
        computer.startComputer();
    }
}
