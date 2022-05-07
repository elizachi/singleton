import singleton.Singleton;
public class Main {
    public static void main(String[] args) {
        // создаем экземпляр класса singleton.Singleton и сразу пробуем чето добавить
        Singleton.getInstance().add("Lesha");
        Singleton.getInstance().add("postav' 10 ballov");
        Singleton.getInstance().add("please");
        Singleton.getInstance().add(null);

        Singleton.getInstance().remove(null);

    }
}
