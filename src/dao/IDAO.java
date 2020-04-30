package dao;


import java.util.List;

public interface IDAO<T> {

    void add(T t);

    void update(T t, String code);

    void remove(String code);

    List<T> findByCode(String code);

    List<T> findByName(String name);

    List<T> getList();

    void sortListByName();

    void writeToFile();

    void readFile();

    void clearList();

}
