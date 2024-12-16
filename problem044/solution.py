import time
import itertools


def get_pentagonal(n: int) -> int:
    return n * (3 * n - 1) // 2


class PentagonalChecker:
    def __init__(self):
        self._pentagonals = {1}
        self._maximum_pentagonal = 1
        self._next_n = 2

    def is_pentagonal(self, k: int) -> bool:
        while k > self._maximum_pentagonal:
            self._maximum_pentagonal = get_pentagonal(self._next_n)
            self._pentagonals.add(self._maximum_pentagonal)
            self._next_n += 1
        return k in self._pentagonals


def main():

    # The idea here is to loop over the differences in ascending order.
    #
    # For each difference we then loop over the lower value and add the difference to get the middle value.
    #
    # For the difference and lower value we only loop over pentagonal numbers, but then the middle number
    # might not be pentagonal. If it is not, then move to the next lower number. If the middle number is
    # pentagonal, then get the higher number by adding the lower and middle and check if it is pentagonal.
    # If the higher number is pentagonal, then the difference is the minimum difference; we have the
    # desired solution.
    #
    # When looping over lower numbers we can stop when the gap between successive lower numbers is larger
    # than the difference because that gap will only grow and the difference must be able to overcome the
    # gap in order to get a pentagonal middle number.
    #
    # This takes a relatively long time to run (10 minutes in 2024), but it does guarantee the right solution.
    # There are other solutions that involve just taking differences of the smallest pentagonals, and they
    # do give the right solution for this problem, but that is not guaranteed a priori, so this solution is
    # preferred because it does give a guarantee.

    checker = PentagonalChecker()
    for n in itertools.count(1):
        diff = get_pentagonal(n)
        print(f"n = {n}, diff = {diff}")
        for m in itertools.count(1):
            lowest = get_pentagonal(m)
            gap = get_pentagonal(m + 1) - lowest
            if gap > diff:
                break
            middle = lowest + diff
            if checker.is_pentagonal(middle):
                highest = middle + lowest
                if checker.is_pentagonal(highest):
                    print(diff)
                    return


main()
