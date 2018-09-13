package bank;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

class DepositTest {
  private static final LocalDate A_DATE = LocalDate.of(1974, 1, 1);

  @Test
  void it_has_a_date() {
    var deposit = new Deposit(A_DATE, 100);

    assertThat(deposit.date).isEqualTo(A_DATE);
  }

  @Test
  void it_has_a_positive_amount() {
    var amount = 100;
    var deposit = new Deposit(A_DATE, amount);

    assertThat(deposit.amount).isEqualTo(amount);
  }
}