package factory;

import dao.BetDao;
import dao.BetDaoImpl;
import dao.UserDao;
import dao.UserDaoImpl;

public class DaoFactory {
  private static BetDao betInstance;
  private static UserDao userInstance;

  public static BetDao betDao() {
    if (betInstance == null) {
      betInstance = new BetDaoImpl();
    }
    return betInstance;
  }

  public static UserDao userDao() {
    if (userInstance == null) {
      userInstance = new UserDaoImpl();
    }
    return userInstance;
  }
}
