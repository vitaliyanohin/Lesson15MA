package dao;

import db.Storage;
import model.User;
import java.util.List;

public class UserDaoImpl implements UserDao {
  @Override
  public void add(User user) {
    Storage.user.add(user);
  }

  @Override
  public List<User> getAll() {
    return Storage.user;
  }
}
