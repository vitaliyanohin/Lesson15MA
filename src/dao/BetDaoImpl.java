package dao;

import db.Storage;
import lib.Dao;
import model.Bet;
import java.util.List;

//НАШ КЛАСС ДЛЯ РАБОТЫ С БАЗОЙ ДАННЫХ И ТАБЛИЦОЙ СТАВОК

public class BetDaoImpl implements BetDao {

  @Override
  public void add(Bet bet) {
    Storage.bet.add(bet);
  }

  @Override
  public List<Bet> getAll() {
    return Storage.bet;
  }
}
