package org.woven.foundation.course.solid.dip;

import java.util.logging.*;

public class EmailNotification implements NotificationProvider{

    private static final Logger logger = Logger.getLogger(EmailNotification.class.getName());

    @Override
    public void send(String message) {
        logger.log(Level.INFO,"email send {0}",message);
    }
}
