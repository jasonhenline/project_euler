def get_cyclic_digit_permutations(n: int) -> list[int]:
    result = []
    s = str(n)
    for k in range(len(s)):
        result.append(int(s[k:] + s[:k]))
    return result


def get_primes_below(n: int) -> list[int]:
    primes = [2]
    k = 3
    while k < n:
        is_composite = False
        for p in primes:
            if p**2 > k:
                break
            if k % p == 0:
                is_composite = True
                break
        if not is_composite:
            primes.append(k)
        k += 2
    return primes


def main():
    limit = 1_000_000
    primes = set(get_primes_below(limit))
    count = 0
    for n in range(2, limit):
        if all(k in primes for k in get_cyclic_digit_permutations(n)):
            count += 1
    print(count)


main()
