package be.seeseemelk.mockbukkit.plugin;

import org.bukkit.event.Event;
import org.bukkit.event.EventException;
import org.bukkit.event.Listener;
import org.bukkit.plugin.EventExecutor;
import org.bukkit.plugin.Plugin;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * The {@code ListenerEntry} is a class that represents a single event handler
 * of a plugin.
 */
public class ListenerEntry {
    private final Plugin plugin;
    private final Listener listener;
    private final EventExecutor eventExecutor;
    private final Class<? extends Event> eventType;
    private final Method method;

    /**
     * Creates a new listener entry for a given method.
     *
     * @param plugin   The plugin that owns the listener.
     * @param listener The listener object that contains the method.
     * @param method   The method to call on events.
     */
    public ListenerEntry(final Plugin plugin, final Listener listener, final Method method) {
        this.plugin = plugin;
        this.listener = listener;
        this.method = method;
        method.setAccessible(true);
        this.eventType = null;
        this.eventExecutor = (obj, args) -> {
            try {
                method.invoke(obj, args);
            } catch (IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }
        };
    }

    /**
     * Creates a new listener entry for a given method.
     *
     * @param plugin        The plugin that owns the listener.
     * @param listener      The listener object that contains the method.
     * @param eventExecutor The executor to call on events.
     */
    public ListenerEntry(final Plugin plugin, final Listener listener, EventExecutor eventExecutor,
                         Class<? extends Event> eventType) {
        this.plugin = plugin;
        this.listener = listener;
        this.eventExecutor = eventExecutor;
        this.eventType = eventType;
        this.method = null;
    }

    public Plugin getPlugin() {
        return plugin;
    }

    public Listener getListener() {
        return listener;
    }

    /**
     * Tries to invoke the method handler with a given event.
     *
     * @param event The event to pass on to the method.
     */
    public void invoke(Event event) throws EventException {
        eventExecutor.execute(listener, event);
    }

    /**
     * Tries to invoke the method, but will cast any exceptions to
     * RuntimeExceptions.
     *
     * @param event The event to pass on to the method.
     */
    public void invokeUnsafe(Event event) {
        try {
            eventExecutor.execute(listener, event);
        } catch (EventException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Checks if this method is compatible for a given event type.
     *
     * @param event The event type the handler should be able to handle.
     * @return {@code true} if the handler can handle that event, {@code false} if
     * it can't.
     */
    public boolean isCompatibleFor(Event event) {
        if (method == null) return event.getClass() == eventType;
        return method.getParameterCount() == 1 && method.getParameters()[0].getType().isInstance(event);
    }
}
