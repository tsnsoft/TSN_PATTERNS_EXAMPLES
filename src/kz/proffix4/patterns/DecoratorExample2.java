package kz.proffix4.patterns;

interface InterfaceComponents {

    InterfaceComponents add(String txt);

    void prn();
}

/**
 * ШАБЛОН ДЕКОРАТОР (англ. Decorator) — структурный шаблон проектирования,
 * предназначенный для динамического подключения дополнительного поведения к
 * объекту. Шаблон Декоратор предоставляет гибкую альтернативу практике создания
 * подклассов с целью расширения функциональности.
 *
 */
class Hi implements InterfaceComponents {

    StringBuilder text = new StringBuilder();

    public Hi(String txt) {
        text.append(txt);
    }

    public Hi(Hi parent, String txt) {
        text.append(parent.text + " " + txt);
    }

    @Override
    public InterfaceComponents add(String txt) {
        return new Hi(this, txt);
    }

    @Override
    public void prn() {
        System.out.println(text);
    }

}

/**
 * @author Talipov
 *
 */
public class DecoratorExample2 {

    public static void main(String[] args) {
        new Hi("0").add("11").add("222").add("3333").add("4444").prn();
    }
}
