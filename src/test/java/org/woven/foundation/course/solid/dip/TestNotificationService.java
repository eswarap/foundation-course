package org.woven.foundation.course.solid.dip;

import org.junit.jupiter.api.Test;

public class TestNotificationService {

    static NotificationService notificationService;
    static NotificationProvider notification;

    @Test
    void testSMSSend() {
        notification = new SMSNotification();
        notificationService = new NotificationService(notification);
        notificationService.send("Hello Good Morning");
    }

    @Test
    void testEmailSend() {
        notification = new EmailNotification();
        notificationService = new NotificationService(notification);
        notificationService.send("Hello Good Morning");

    }
}
