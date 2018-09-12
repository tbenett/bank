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

  @Test
  void many_operations_can_be_added_to_account() {
    final var depositOf10 = new Deposit(TODAY, 10);
    final var withdrawalOf100 = new Withdrawal(TODAY, 100);
    final var depositOf1000 = new Deposit(TODAY, 1000);
    final var account = new Account();

    account.deposit(10);
    account.withdraw(100);
    account.deposit(1000);

    final var operations = account.operations();

    assertThat(operations.size()).isEqualTo(3);
    assertThat(operations.get(0)).isEqualTo(depositOf10);
    assertThat(operations.get(1)).isEqualTo(withdrawalOf100);
    assertThat(operations.get(2)).isEqualTo(depositOf1000);
  }
}