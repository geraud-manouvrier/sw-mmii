package cl.qande.mmii.app.util;

import cl.qande.mmii.app.config.AppConfig;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Notification {
    private final LocalTime time;
    private final String message;
    private final NotificationType type;

    public Notification(String message, NotificationType type) {
        this.time = LocalTime.now();
        this.message = message;
        this.type = type != null ? type : NotificationType.INFO;
    }

    public LocalTime getTime() { return time; }
    public String getMessage() { return message; }
    public NotificationType getType() { return type; }

    @Override
    public String toString() {
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("HH:mm:ss");
        DateTimeFormatter dateFmt = DateTimeFormatter.ofPattern("d-MMM", AppConfig.LOCALE_CL);
        String date = java.time.LocalDate.now().format(dateFmt).replace(".", "").toLowerCase();
        return date + " " + time.format(fmt) + " - " + message;
    }
}
