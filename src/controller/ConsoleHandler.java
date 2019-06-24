package controller;

import dao.BetDao;
import dao.UserDao;
import lib.Inject;
import model.Bet;
import model.User;
import java.util.Scanner;

public class ConsoleHandler {

  @Inject
  private static BetDao betDao;
  @Inject
  private static UserDao userDao;

  static public void handle() {
    try (Scanner scanner = new Scanner(System.in)) {
      while (true) {
        String command = scanner.nextLine();
        switch (command) {
          case "1":
            while (true) {
              System.out.println("Menu Bet:");
              command = scanner.nextLine();
              if (command.equals("0")) {
                return;
              }
              String[] data = command.split(" ");
              int value = Integer.parseInt(data[0]);
              double risk = Double.parseDouble(data[1]);
              Bet bet = new Bet(value, risk);
              betDao.add(bet);
            }
          case "2":
            while (true) {
              System.out.println("Menu User:");
              command = scanner.nextLine();
              if (command.equals("0")) {
                return;
              }
              String[] data = command.split(" ");
              String userName = data[0];
              int age = Integer.parseInt(data[1]);
              User user = new User(userName, age);
              userDao.add(user);
            }
        }
      }
    } catch (Exception e) {
      e.printStackTrace();
      System.out.println("Данные введены некорректно");
    }
  }
}

