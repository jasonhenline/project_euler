from dataclasses import dataclass


@dataclass
class State:
    year: int
    month: int
    weekday: int

    def is_leap_year(self) -> bool:
        if self.year % 4 != 0:
            return False
        elif self.year % 400 == 0:
            return True
        else:
            return self.year % 100 != 0

    def get_month_days(self) -> int:
        if self.month == 1 and self.is_leap_year():
            return 29
        else:
            return [31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31][self.month]

    def step_by_month(self) -> None:
        self.weekday += self.get_month_days()
        self.weekday %= 7
        self.month += 1
        if self.month == 12:
            self.year += 1
            self.month = 0


def main():
    result = 0
    state = State(1900, 0, 1)
    while state.year < 1901:
        state.step_by_month()
    while state.year < 2001:
        if state.weekday == 0:
            result += 1
        state.step_by_month()
    print(result)


main()
