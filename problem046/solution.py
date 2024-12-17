from itertools import count, takewhile


def get_primes_generator():
    yield 2
    odd_primes = []
    k = 3
    while True:
        ps = takewhile(lambda p: p**2 <= k, odd_primes)
        is_prime = not any(k % p == 0 for p in ps)
        if is_prime:
            odd_primes.append(k)
            yield k
        k += 2


class Primes:
    def __init__(self):
        self._largest_prime = 0
        self._primes_list = []
        self._primes_set = set()
        self._primes_generator = get_primes_generator()
        self._extend()

    def _extend(self) -> None:
        self._largest_prime = next(self._primes_generator)
        self._primes_list.append(self._largest_prime)
        self._primes_set.add(self._largest_prime)

    def _any_prime_divides(self, n: int) -> bool:
        ps = takewhile(lambda p: p**2 <= n, self._primes_list)
        return any(n % p == 0 for p in ps)

    def is_prime(self, n: int) -> bool:
        if n <= self._largest_prime:
            return n in self._primes_set
        while self._largest_prime**2 < n:
            self._extend()
        return not self._any_prime_divides(n)


def main():
    primes = Primes()
    odd_composites = (n for n in count(start=3, step=2) if not primes.is_prime(n))

    for n in odd_composites:
        twice_squares = (2 * k**2 for k in count(1))
        small_twice_squares = takewhile(lambda k: k < n, twice_squares)
        remainders = (n - k for k in small_twice_squares)
        is_nice = any(primes.is_prime(r) for r in remainders)
        if not is_nice:
            print(n)
            return


main()
