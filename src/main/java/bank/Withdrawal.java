package bank;

import java.time.LocalDate;

class Withdrawal extends Operation {

  public Withdrawal(LocalDate date, int amount) {
    this.date = date;
    this.amount = -amount;
  }
}
