package bank;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class AccountTest {

  private static final LocalDate TODAY = LocalDate.now();

  @Test
  void make_a_deposit_is_adding_a_deposit_operation() {
    var deposit = new Deposit(TODAY, 100);
    var account = new Account();

    account.deposit(100);

    final List<Operation> operations = account.operations();

    assertThat(operations.size()).isEqualTo(1);
    assertThat(operations.get(0)).isEqualTo(deposit);
  }

  @Test
  void make_a_withdrawal_is_adding_a_withdrawal_operation() {
    var withdrawal = new Withdrawal(TODAY, 100);
    var account = new Account();

    account.withdraw(100);

    final List<Operation> operations = account.operations();

    assertThat(operations.size()).isEqualTo(1);
    assertThat(operations.get(0)).isEqualTo(withdrawal);
  }
}