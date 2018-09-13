package bank;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

class WithdrawalTest {
  private static final LocalDate A_DATE = LocalDate.of(1974, 1, 1);

  @Test
  void it_has_a_date() {
    var withdrawal = new Withdrawal(A_DATE, 100);

    assertThat(withdrawal.date).isEqualTo(A_DATE);
  }

  @Test
  void it_has_a_negative_amount() {
    var amount = 100;
    var withdrawal = new Withdrawal(A_DATE, amount);

    assertThat(withdrawal.amount).isEqualTo(-amount);
  }
}
