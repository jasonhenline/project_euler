from itertools import permutations


def get_primes_below(n: int) -> list[int]:
    primes = [2]
    k = 3
    while k < n:
        is_prime = True
        for p in primes:
            if p**2 > k:
                break
            if k % p == 0:
                is_prime = False
                break
        if is_prime:
            primes.append(k)
        k += 2

    return primes


def main():
    primes = get_primes_below(10_000)

    def is_prime(n: int) -> bool:
        for p in primes:
            if p**2 > n:
                break
            if n % p == 0:
                return False
        return True

    for digit_count in range(9, 1, -1):
        for permutation in permutations(reversed(range(1, digit_count + 1))):
            value = 0
            for d in permutation:
                value *= 10
                value += d
            if is_prime(value):
                print(value)
                return


main()
