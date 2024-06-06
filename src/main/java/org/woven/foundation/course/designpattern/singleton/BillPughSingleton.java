package org.woven.foundation.course.designpattern.singleton;

public class BillPughSingleton {
    private BillPughSingleton() {}

    private static class BillPughSingletonHolder {
        private static final BillPughSingleton INSTANCE = new BillPughSingleton();
    }

    public static BillPughSingleton getInstance() {
        return BillPughSingletonHolder.INSTANCE;
    }
}
