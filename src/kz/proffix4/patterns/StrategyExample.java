package kz.proffix4.patterns;

/*
 * ПАТТЕРН "СТРАТЕГИЯ" (Strategy)
 * Этот паттерн проектирования известен также под названием Policy. 
 * Суть его состоит в том, чтобы создать несколько моделей поведения (стратегий) для одного объекта
 * и вынести их в отдельные классы. 
 */
interface IAlgorithm {

    String crypt(String text, String key);
}

class DESAlgorithm implements IAlgorithm {

    public String crypt(String text, String key) {
        String cryptedString = "DES: " + text + " ^ " + key;
        return cryptedString;
    }
}

class RSAAlgorythm implements IAlgorithm {

    public String crypt(String text, String key) {
        String cryptedString = "RSA: " + text + " ^ " + key;
        return cryptedString;
    }
}

class Encryption {

    private IAlgorithm algorithm;

    public Encryption(IAlgorithm algorithm) {
        this.algorithm = algorithm;
    }

    public void setAlgorithm(IAlgorithm algorithm) {
        this.algorithm = algorithm;
    }

    public String crypt(String text, String key) {
        return algorithm.crypt(text, key);
    }
}

/**
 * ПАТТЕРН "СТРАТЕГИЯ"
 *
 */
public class StrategyExample {

    public static void main(String[] args) {
        String text = "text";
        String key = "key";
        Encryption encryption = new Encryption(new DESAlgorithm());
        String cryptedText = encryption.crypt(text, key);
        System.out.println(cryptedText);
        encryption.setAlgorithm(new RSAAlgorythm());
        cryptedText = encryption.crypt(text, key);
        System.out.println(cryptedText);
    }
}
