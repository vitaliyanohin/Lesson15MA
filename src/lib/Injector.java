package lib;

import controller.ConsoleHandler;
import factory.DaoFactory;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Injector {

  public static void injectDependency() throws
          InvocationTargetException,
          IllegalAccessException,
          NoSuchMethodException,
          IOException,
          ClassNotFoundException {
    Class consoleHandlerClass = ConsoleHandler.class;
    Field[] consoleHandlerFields = consoleHandlerClass.getDeclaredFields();
    int count = 0;
    for (Field field : consoleHandlerFields) {
      if (field.isAnnotationPresent(Inject.class)) {
        Object[] objects = ClassLoadHelper.getClasses(field.getType().getPackage().getName());
        count++;
        Class currentClass;
        for (Object o : objects) {
          currentClass = (Class) o;
          if (field.getType().isAssignableFrom(currentClass)
                  & !currentClass.isInterface()
                  & currentClass.isAnnotationPresent(Dao.class)) {
            field.setAccessible(true);
            Method method = DaoFactory.class.getDeclaredMethod(field.getName());
            method.setAccessible(true);
            field.set(null, method.invoke(field.getName()));
            count--;
          }
        }
      }
      if (count != 0) {
        try {
          throw new Exception("DAOOO");
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    }
  }
}
