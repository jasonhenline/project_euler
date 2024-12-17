import itertools
from itertools import takewhile


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
        self._primes_generator = get_primes_generator()
        self._extend()

    def _extend(self) -> None:
        self._largest_prime = next(self._primes_generator)
        self._primes_list.append(self._largest_prime)

    def get_prime(self, n: int) -> int:
        while n >= len(self._primes_list):
            self._extend()
        return self._primes_list[n]

    def factorize(self, n: int) -> dict[int, int]:
        if n < 2:
            return {}

        factorization: dict[int, int] = {}
        prime_index = 0
        while n > 1:
            p = self.get_prime(prime_index)
            if p**2 > n:
                if n > 1:
                    factorization[n] = 1
                break
            count = 0
            while n % p == 0:
                n //= p
                count += 1
            if count > 0:
                factorization[p] = count
            prime_index += 1

        return factorization


def main():
    primes = Primes()

    for n in itertools.count(0):
        if all(len(primes.factorize(m)) == 4 for m in range(n, n + 4)):
            print(n)
            break


main()
