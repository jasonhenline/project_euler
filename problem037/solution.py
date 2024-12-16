def get_primes_below(n: int) -> list[int]:
    primes = [2]
    k = 3

    while k < n:
        is_composite = False
        for p in primes:
            if p * p > k:
                break
            if k % p == 0:
                is_composite = True
                break
        if not is_composite:
            primes.append(k)
        k += 2

    return primes


def get_truncations(n: int) -> list[int]:
    result = []
    s = str(n)
    result.append(int(s))
    for i in range(0, len(s) - 1):
        result.append(int(s[i + 1 :]))
        result.append(int(s[: -1 - i]))
    return result


def main():
    limit = 1_000_000
    primes = set(get_primes_below(limit))

    count = 0
    result = 0
    n = 11
    while True:
        if n >= limit:
            raise Exception("need more primes")
        is_special = all(t in primes for t in get_truncations(n))
        if is_special:
            result += n
            count += 1
            if count == 11:
                break
        n += 1

    print(result)


main()
