package dao;

import lib.Dao;
import model.Bet;
import java.util.List;

//НАШ КЛАСС ДЛЯ РАБОТЫ С БАЗОЙ ДАННЫХ И ТАБЛИЦОЙ СТАВОК
@Dao
public interface BetDao {

  void add(Bet bet);

  List<Bet> getAll();
}
