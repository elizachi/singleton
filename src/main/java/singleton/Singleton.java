package singleton;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Singleton {
    // поле есть но изначально не инициализировано
    private static Singleton instance;
    // наша коллекция
    private final List<String> singleCollection = Collections.synchronizedList(new ArrayList<String>());
    // чтобы нельзя было создавать экземпляр класса извне
    private Singleton() {}
    // экземпляр класса создается только при первом обращении
    public static Singleton getInstance() {
        if(instance == null) {
            synchronized (Singleton.class) {
                if(instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
    public void add(String newString) {
        try {
            singleCollection.add(newString);
            System.out.println("Элемент "+newString+" успешно добавлен");
        } catch(IllegalArgumentException e) {
            System.out.println("На вход была подана не строка");
        } catch (NullPointerException e) {
            System.out.println("Попытка использования null");
        } catch (ClassCastException e) {
            System.out.println("Элементы такого типа здесь запрещены");
        }
    }
    public void remove(int index) {
        try {
            singleCollection.remove(index);
            System.out.println("Удаление элемента под индексом "+index+" прошло успешно");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Элемента с таким индексом не существует");
        }
    }
    public void remove(String existedString) {
        boolean result = false;
        try {
            result = singleCollection.remove(existedString);
        } catch (ClassCastException e) {
            System.out.println("Элементы такого типа здесь запрещены");
        } catch (NullPointerException e) {
            System.out.println("Попытка использования null");
        }
        if(result) System.out.println("Удаление элемента "+existedString+" прошло успешно");
    }
}
