package factory;

import dao.BetDao;
import dao.BetDaoImpl;
import dao.UserDao;
import dao.UserDaoImpl;

public class DaoFactory {

  private static BetDao instance;
  private static UserDao userInstance;

  public static BetDao betDao() {
    if (instance == null) {
      instance = new BetDaoImpl();
    }
    return instance;
  }

  public static UserDao userDao() {
    if (userInstance == null) {
      userInstance = new UserDaoImpl();
    }
    return userInstance;
  }
}
