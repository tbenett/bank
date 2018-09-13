package service;

import bank.Account;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

class Client {
  private final Account account;
  public static final String HEADER = "date,amount,balance\n";

  public Client(Account account) {
    this.account = account;
  }

  public void saveMoney(int amount) {
    account.deposit(amount);
  }

  public void retrieveMoney(int amount) {
    account.withdraw(amount);
  }

  public String check_operations() {
    AtomicInteger balance = new AtomicInteger();

    return HEADER + account.operations()
        .stream()
        .map(operation ->
            operation.date().toString()
                + "," + String.valueOf(operation.amount())
                + "," + String.valueOf(balance.addAndGet(operation.amount()))
                + "\n"
        ).collect(Collectors.joining());
  }

}
