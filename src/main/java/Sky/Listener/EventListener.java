package Sky.Listener;

import java.util.ArrayList;
import java.util.List;

public class EventListener {
    private static List<DataListener> dataListeners = new ArrayList<>();

    public static void addListener(DataListener dataListener) {
        dataListeners.add(dataListener);
    }

    public static void inform(Event event) {
        for (DataListener dataListener: dataListeners) {
            dataListener.onUpdated(event);
        }
    }
}
