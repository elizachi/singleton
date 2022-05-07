package singleton;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Singleton {
    private static volatile Singleton instance;

    private final List<String> singleCollection = Collections.synchronizedList(new ArrayList<String>());

    public static Singleton getInstance() {
        Singleton localInstance = instance;
        if(localInstance == null) {
            synchronized (Singleton.class) {
                localInstance = instance;
                if(localInstance == null) {
                    instance = localInstance = new Singleton();
                }
            }
        }
        return localInstance;
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
