package jp.mirm.fcmlib;

import jp.mirm.fcmlib.entity.Notification;

public class testmain {

    public static void main(String[] args) {
        NotificationSender.init("Authorization key (like: bk3RNwTe3H0:CI2k_HHwgIpoDKCIZvvDMExUdFQ3P1...)");

        Notification notification = new Notification("Device token or Topic name")
                .setTitle("Title")
                .setMessage("message");
        NotificationSender.sendNotification(notification);

    }
}
