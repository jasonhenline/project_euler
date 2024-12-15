from dataclasses import dataclass


@dataclass
class PrimeTester:
    primes_set = {2}
    primes_list = [2]
    k = 3

    def is_prime(self, n) -> bool:
        if n <= 1:
            return False

        if n < self.k:
            return n in self.primes_set

        while self.k**2 <= n:
            if not self._is_divisible_by_known_primes(self.k):
                self.primes_set.add(self.k)
                self.primes_list.append(self.k)
            self.k += 2

        return not self._is_divisible_by_known_primes(n)

    def _is_divisible_by_known_primes(self, n: int) -> bool:
        for p in self.primes_list:
            if p**2 > n:
                return False
            elif n % p == 0:
                return True
        return False


def main():
    prime_tester = PrimeTester()

    # b must be prime because when n == 0 the output is b
    max_run = 0
    best_product = 0
    for b in range(1000):
        if not prime_tester.is_prime(b):
            continue
        for a in range(-999, 1000):
            n = 1
            while prime_tester.is_prime(n**2 + a * n + b):
                n += 1
            if n > max_run:
                max_run = n
                best_product = a * b

    print(best_product)


main()
