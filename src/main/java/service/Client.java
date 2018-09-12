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
}
