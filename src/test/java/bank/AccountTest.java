package bank;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

class AccountTest {

  private static final LocalDate A_DATE = LocalDate.of(1974, 1, 1);

  private MockedAccount account;

  @BeforeEach
  void setUp() {
    account = new MockedAccount();
  }

  @Test
  void make_a_deposit_is_adding_a_deposit_operation() {
    var deposit = new Deposit(A_DATE, 100);

    account.deposit(100);

    final List<Operation> operations = account.operations();

    assertThat(operations.size()).isEqualTo(1);
    assertThat(operations.get(0)).isEqualTo(deposit);
  }

  @Test
  void make_a_withdrawal_is_adding_a_withdrawal_operation() {
    var withdrawal = new Withdrawal(A_DATE, 100);

    account.withdraw(100);

    final List<Operation> operations = account.operations();

    assertThat(operations.size()).isEqualTo(1);
    assertThat(operations.get(0)).isEqualTo(withdrawal);
  }

  @Test
  void many_operations_can_be_added_to_account() {
    final var depositOf10 = new Deposit(A_DATE, 10);
    final var withdrawalOf100 = new Withdrawal(A_DATE, 100);
    final var depositOf1000 = new Deposit(A_DATE, 1000);

    account.deposit(10);
    account.withdraw(100);
    account.deposit(1000);

    final var operations = account.operations();

    assertThat(operations.size()).isEqualTo(3);
    assertThat(operations.get(0)).isEqualTo(depositOf10);
    assertThat(operations.get(1)).isEqualTo(withdrawalOf100);
    assertThat(operations.get(2)).isEqualTo(depositOf1000);
  }

  private class MockedAccount extends Account {
    protected LocalDate now() {
      return A_DATE;
    }
  }
}
