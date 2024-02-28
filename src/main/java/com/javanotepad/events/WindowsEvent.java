package com.javanotepad.events;

import javafx.event.Event;
import javafx.event.EventType;

public class WindowsEvent extends Event {

    public static final EventType<WindowsEvent> ANY = new EventType<>(Event.ANY, "ANY");
    public static final EventType<WindowsEvent> WINDOWS_EXIT = new EventType<>(ANY, "WINDOWS_EXIT");

    public WindowsEvent(EventType<? extends Event> eventType) {
        super(eventType);
    }

}
