package kz.proffix4.patterns;

/**
 * ШАБЛОН ДЕКОРАТОР (англ. Decorator) — структурный шаблон проектирования,
 * предназначенный для динамического подключения дополнительного поведения к
 * объекту. Шаблон Декоратор предоставляет гибкую альтернативу практике создания
 * подклассов с целью расширения функциональности.
 *
 */
interface IProduct {

    String getDescription();

    int getCost();
}

class Product implements IProduct {

    private String description;
    private int cost;

    public Product(String description, int cost) {
        this.description = description;
        this.cost = cost;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public int getCost() {
        return cost;
    }
}

class Coffee extends Product {

    public Coffee(int cost) {
        super("Кофе", cost);
    }
}

class Milk extends Product {

    public Milk(int cost) {
        super("молоко", cost);
    }
}

class Sugar extends Product {

    public Sugar(int cost) {
        super("сахар", cost);
    }
}

class ProductAdditive implements IProduct {

    protected IProduct product;
    IProduct additive;

    public ProductAdditive(IProduct product, IProduct additive) {
        this.product = product;
        this.additive = additive;
    }

    @Override
    public String getDescription() {
        return product.getDescription() + ", " + additive.getDescription();
    }

    @Override
    public int getCost() {
        return product.getCost() + additive.getCost();
    }
}

public class DecoratorExample {

    public static void main(String... s) {
        Milk milk = new Milk(15);
        IProduct coffee = new ProductAdditive(new ProductAdditive(new Coffee(100), milk), new Sugar(10));
        coffee = new ProductAdditive(coffee, new Product("шоколад", 50));
        System.out.println(coffee.getDescription());
        System.out.println(coffee.getCost() + " тенге");
    }
}
