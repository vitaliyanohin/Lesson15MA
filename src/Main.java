import controller.ConsoleHandler;
import dao.BetDao;
import dao.BetDaoImpl;
import dao.UserDao;
import dao.UserDaoImpl;
import lib.Injector;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

public class Main {

  static  {
    try {
      Injector.injectDependency();
    } catch (InvocationTargetException
            | IllegalAccessException
            | NoSuchMethodException
            | IOException
            | ClassNotFoundException e ) {
      e.printStackTrace();
    }
  }

  public static void main(String[] args) {
    System.out.println("[1] - Menu Bet \n[2] - Menu User \n[0] - Exit");
    ConsoleHandler.handle();
    BetDao betDao = new BetDaoImpl();
    UserDao userDao = new UserDaoImpl();
    System.out.println(betDao.getAll());
    System.out.println(userDao.getAll());
  }
}
