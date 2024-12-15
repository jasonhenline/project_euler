import math


def get_digit_cancels(n: int, d: int) -> set[tuple[int, int]]:
    result = set()

    ns = str(n)
    ds = str(d)

    for i, nc in enumerate(ns):
        if nc == "0":
            # Ignore the trivial case of a trailing zero.
            continue
        for j, dc in enumerate(ds):
            if nc == dc:
                n = int(ns[:i] + ns[i + 1 :])
                d = int(ds[:j] + ds[j + 1 :])
                g = math.gcd(n, d)
                result.add((n // g, d // g))

    return result


def is_special(n: int, d: int) -> bool:
    digit_cancels = get_digit_cancels(n, d)
    if not digit_cancels:
        return False
    g = math.gcd(n, d)
    if g == 1:
        return False
    reduced = n // g, d // g
    return reduced in digit_cancels


def main():
    specials: set[tuple[int, int]] = set()
    for n in range(10, 100):
        for d in range(n + 1, 100):
            if is_special(n, d):
                specials.add((n, d))
    n = math.prod(special[0] for special in specials)
    d = math.prod(special[1] for special in specials)
    g = math.gcd(n, d)
    print(d // g)


main()
