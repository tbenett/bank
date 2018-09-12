package bank;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

class DepositTest {
  private static final LocalDate TODAY = LocalDate.now();

  @Test
  void it_has_a_date() {
    var deposit = new Deposit(TODAY, 100);

    assertThat(deposit.date).isEqualTo(TODAY);
  }

  @Test
  void it_has_a_positive_amount() {
    var amount = 100;
    var deposit = new Deposit(TODAY, amount);

    assertThat(deposit.amount).isEqualTo(amount);
  }
}