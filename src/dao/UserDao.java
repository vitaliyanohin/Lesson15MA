package dao;

import lib.Dao;
import model.User;
import java.util.List;

@Dao
public interface UserDao {

  void add(User user);

  List<User> getAll();
}
