package dao;

import db.Storage;
import lib.Dao;
import model.User;
import java.util.List;

@Dao
public class UserDaoImpl implements UserDao {
  @Override
  public void add(User user) {
    Storage.USERS.add(user);
  }

  @Override
  public List<User> getAll() {
    return Storage.USERS;
  }
}
