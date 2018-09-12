package bank;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

class WithdrawalTest {
  private static final LocalDate TODAY = LocalDate.now();

  @Test
  void it_has_a_date() {
    var withdrawal = new Withdrawal(TODAY, 100);

    assertThat(withdrawal.date).isEqualTo(TODAY);
  }

  @Test
  void it_has_a_negative_amount() {
    var amount = 100;
    var withdrawal = new Withdrawal(TODAY, amount);

    assertThat(withdrawal.amount).isEqualTo(-amount);
  }
}
