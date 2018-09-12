package bank;

import java.time.LocalDate;
import java.util.Objects;

public abstract class Operation {
  protected int amount;
  protected LocalDate date;

  public LocalDate date() {
    return date;
  }

  public int amount() {
    return amount;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Operation operation = (Operation) o;
    return amount == operation.amount &&
        Objects.equals(date, operation.date);
  }

  @Override
  public int hashCode() {
    return Objects.hash(amount, date);
  }
}
