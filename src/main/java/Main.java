import singleton.Singleton;
public class Main {
    public static void main(String[] args) {
        // создаем экземпляр класса singleton.Singleton и сразу пробуем чето добавить
        Singleton.getInstance().add("Lesha");
        Singleton.getInstance().add("postav' 10 ballov");
        Singleton.getInstance().add("please");
        Singleton.getInstance().add(null);

        Singleton.getInstance().remove(null);
        Singleton.getInstance().remove(10);

        Singleton.getInstance().remove("Lesha");
        Singleton.getInstance().add("Aleksey Egoshin");

        Singleton.getInstance().remove(2);
        Singleton.getInstance().add("postav'te 11 ballov");

        Singleton.getInstance().remove("pozhaluysta");
        Singleton.getInstance().add("pozhaluysta");
    }
}
