package observe;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 2018-06-29.
 */
public class ConcreteSubject implements Subject{


    private List<Observer> list;

    public ConcreteSubject() {
        list = new ArrayList<>();
    }

    @Override
    public void addObserver(Observer observer) {
        list.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        for(Observer cur : list){
            if(cur.hashCode() == observer.hashCode() && observer == cur){
                list.remove(cur);
            }
        }
    }

    @Override
    public void notifyObservers(String message) {
        for(Observer current : list){
              current.createOrder(message);
        }
    }

}
