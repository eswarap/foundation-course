package org.woven.foundation.course.solid.dip;

import java.util.logging.*;

public class SMSNotification implements NotificationProvider{
    private static final Logger logger = Logger.getLogger(SMSNotification.class.getName());
    @Override
    public void send(String message) {
        logger.log(Level.INFO,"sms send {0}",message);
    }
}
