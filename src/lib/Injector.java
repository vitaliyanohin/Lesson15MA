package lib;

import controller.ConsoleHandler;
import factory.DaoFactory;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Injector {

  public static void injectDependency() throws InvocationTargetException,
          IllegalAccessException, NoSuchMethodException {
    Class<ConsoleHandler> consoleHandlerClass = ConsoleHandler.class;
    Field[] consoleHandlerFields = consoleHandlerClass.getDeclaredFields();
    for (Field field : consoleHandlerFields) {
      if (field.getDeclaredAnnotation(Inject.class) != null
               && field.getType().isAnnotationPresent(Dao.class)) {
        field.setAccessible(true);
        Method method = DaoFactory.class.getDeclaredMethod(field.getName());
        method.setAccessible(true);
        field.set(null, method.invoke(field.getName()));
      }
    }
  }
}
