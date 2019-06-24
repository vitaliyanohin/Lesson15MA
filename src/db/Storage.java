package db;

import model.Bet;
import model.User;

import java.util.ArrayList;
import java.util.List;

//ЭТО НАША БД
public class Storage<T> {
  public static final List<Bet> bet = new ArrayList<>();
  public static final List<User> user = new ArrayList<>();
}
