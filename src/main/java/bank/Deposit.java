package bank;

import java.time.LocalDate;

public class Deposit extends Operation {

  public Deposit(LocalDate date, int amount) {
    this.date = date;
    this.amount = amount;
  }
}
