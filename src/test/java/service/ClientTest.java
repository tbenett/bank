package service;

import bank.Account;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class ClientTest {
  @Mock
  private Account account;

  @Test
  void it_can_save_his_money() {
    var amount = 100;
    var client = new Client(account);

    client.saveMoney(amount);

    verify(account).deposit(amount);
  }

  @Test
  void it_can_retrieve_his_money() {
    var amount = 100;
    var client = new Client(account);

    client.retrieveMoney(amount);

    verify(account).withdraw(amount);
  }
}