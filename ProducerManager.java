import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProducerManager {

    private Map<String, List<ConsumerListener>> listeners;

    public ProducerManager() {
        this.listeners = new HashMap<>();
        this.listeners.put(EventType.UNAUTHORISED, new ArrayList<>());
        // this.listeners.put(EventType.WRITE, new ArrayList<>());
    }

    public void subscribe(String eventType, ConsumerListener listener) {
        List<ConsumerListener> users =  this.listeners.get(eventType);
        users.add(listener);
    }

    public void unsubscribe(String eventType, ConsumerListener listener) {
        List<ConsumerListener> users =  this.listeners.get(eventType);
        users.remove(listener);
    }

    public void notify(String eventType, Object object) {
        List<ConsumerListener> users =  this.listeners.get(eventType);
        for (ConsumerListener listener : users) {
            listener.update(eventType, object);
        }
    }
}
