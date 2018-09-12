package service;

import bank.Account;
import bank.Deposit;
import bank.Operation;
import bank.Withdrawal;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ClientTest {
  @Mock
  private Account account;

  private Client client;
  public static final LocalDate TODAY = LocalDate.now();


  @BeforeEach
  void setUp() {
    client = new Client(account);
  }

  @Test
  void it_can_save_his_money() {
    var amount = 100;

    client.saveMoney(amount);

    verify(account).deposit(amount);
  }

  @Test
  void it_can_retrieve_his_money() {
    var amount = 100;

    client.retrieveMoney(amount);

    verify(account).withdraw(amount);
  }

  @Test
  void it_can_see_his_operations_history() {
    client.saveMoney(100);
    client.retrieveMoney(58);
    client.saveMoney(1295);

    when(account.operations()).thenReturn(
        List.<Operation>of(
            new Deposit(TODAY, 100),
            new Withdrawal(TODAY, 58),
            new Deposit(TODAY, 1295)
        )
    );
    assertThat(client.check_operations()).isEqualTo(
        "date,amount,balance\n"
            + TODAY.toString() + "," + "100" + "," + "100" + "\n"
            + TODAY.toString() + "," + "-58" + "," + "42" + "\n"
            + TODAY.toString() + "," + "1295" + "," + "1337" + "\n"
    );
  }
}