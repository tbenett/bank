package bank;

import java.time.LocalDate;
import java.util.Objects;

class Deposit implements Operation {
  private final LocalDate date;
  private final int amount;

  public Deposit(LocalDate date, int amount) {
    this.date = date;
    this.amount = amount;
  }

  @Override
  public LocalDate date() {
    return date;
  }

  @Override
  public int amount() {
    return amount;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Deposit deposit = (Deposit) o;
    return amount == deposit.amount &&
        Objects.equals(date, deposit.date);
  }

  @Override
  public int hashCode() {
    return Objects.hash(date, amount);
  }
}
