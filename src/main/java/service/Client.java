package service;

import bank.Account;

class Client {
  private final Account account;

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
    String operations = "date,amount,balance\n";

    int balance = 0;

    for (var operation : account.operations()) {
      balance += operation.amount();

      operations += operation.date().toString()
          + "," + String.valueOf(operation.amount())
          + "," + String.valueOf(balance)
          + "\n";
    }

    return operations;
  }
}
