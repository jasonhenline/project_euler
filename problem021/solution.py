from functools import cache


@cache
def get_proper_divisor_sum(n: int) -> int:
    result = 1
    d = 2
    while d * d <= n:
        q, r = divmod(n, d)
        if r == 0:
            result += d
            if q != d:
                result += q
        d += 1
    return result


def main():
    result = 0
    for n in range(1, 10_000):
        m = get_proper_divisor_sum(n)
        if m > n == get_proper_divisor_sum(m):
            result += n + m
    print(result)


main()
