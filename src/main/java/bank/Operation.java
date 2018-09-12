package bank;

import java.time.LocalDate;

public interface Operation {
  public LocalDate date();

  int amount();
}
