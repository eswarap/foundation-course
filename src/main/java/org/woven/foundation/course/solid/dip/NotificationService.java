package org.woven.foundation.course.solid.dip;

/**
 * Dependency inversion principle states that a higher-level object
 * should never depend on a concrete implementation of a lower-level object.
 * Hence we losely couple NotificationService (high-level) to NotificationService(low-level) by abstracting it,
 * rather than tightly couple for ease of testing.
 */
public class NotificationService {
    private final NotificationProvider notificationProvider;

    public NotificationService(final NotificationProvider notificationProvider) {
        this.notificationProvider = notificationProvider;
    }

    public void send(String message) {
        notificationProvider.send(message);
    }
}
