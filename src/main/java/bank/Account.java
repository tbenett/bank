package bank;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static java.util.Collections.emptyList;

public class Account {
  private final ArrayList<Operation> operations;

  Account() {
    operations = new ArrayList<>();
  }

  public void deposit(int amount) {
    operations.add(new Deposit(now(), amount));
  }

  public void withdraw(int amount) {
    operations.add(new Withdrawal(now(), amount));
  }

  public List<Operation> operations() {
    return operations;
  }

  protected LocalDate now() {
    return LocalDate.now();
  }
}
