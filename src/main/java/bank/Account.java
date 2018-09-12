package bank;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static java.util.Collections.emptyList;

class Account {
  private final ArrayList<Operation> operations;

  Account() {
    operations = new ArrayList<>();
  }

  public void deposit(int amount) {
    operations.add(new Deposit(LocalDate.now(), amount));
  }

  public List<Operation> operations() {
    return operations;
  }
}
