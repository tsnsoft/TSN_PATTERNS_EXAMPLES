package kz.proffix4.patterns;

/*
 * Поведенческий паттерн проектирования Память нужен для хранения определенного состояния объекта. 
 * При сохранении не должна нарушаться парадигма ООП инкапсуляция. 
 * С другой стороны, должна присутствовать возможность возврата к предыдущему состоянию.
 */
/**
 * ПАТТЕРН "ПАМЯТЬ"
 *
 */
class SiteDescrBean {

    private String theURL;
    private String description;
    private int category;
    private Memento undo;

    public SiteDescrBean(String theURL, String description, int category) {
        this.theURL = theURL;
        this.description = description;
        this.category = category;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public String getTheURL() {
        return theURL;
    }

    public String getDescription() {
        return description;
    }

    public int getCategory() {
        return category;
    }

    private class Memento {

        String siteDescr;
        int siteCateg;

        Memento(String descr, int category) {
            siteDescr = descr;
            siteCateg = category;
        }

        String getDescr() {
            return siteDescr;
        }

        int getCateg() {
            return siteCateg;
        }
    }

    public void preview() {
        undo = new Memento(description, category);
    }

    public void undoChanges() {
        description = undo.getDescr();
        category = undo.getCateg();
    }

    @Override
    public String toString() {
        return String.format("theURL=%s, description=%s, category=%s", theURL, description, category);
    }

}

public class MementoExample {

    public static void main(String[] args) {
        SiteDescrBean siteDescrBean = new SiteDescrBean("www.mail.ru", "Почта", 1);
        System.out.println(siteDescrBean);
        siteDescrBean.preview();
        siteDescrBean.setDescription("Demo");
        siteDescrBean.setCategory(2);
        System.out.println(siteDescrBean);
        siteDescrBean.undoChanges();
        System.out.println(siteDescrBean);
    }
}
