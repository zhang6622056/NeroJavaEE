package observe;

/**
 * 抽象主题
 * Created by Nero on 2018-06-29.
 */
public interface Subject {


    void addObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers(String message);

}
