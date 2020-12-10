package model.domain.chooser;

import java.lang.reflect.Method;

public class ApplicationChooser {
    private ApplicationChooser() {
    }

    public static void chooseApplication(String className, String methodName) {
        try {
            Class<?> c = Class.forName(className);
            Method method = c.getDeclaredMethod(methodName);
            method.invoke(c.getClass());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
