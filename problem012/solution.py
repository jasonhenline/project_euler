from collections import Counter


def triangle(n: int) -> int:
    return (n * (n + 1)) // 2


def factorize(n: int) -> Counter[int]:
    counter = Counter()
    d = 2
    while n > 1 and d * d <= n:
        while n % d == 0:
            counter[d] += 1
            n //= d
        d += 1
    if n > 1:
        counter[n] += 1
    return counter


def factorize_triangle(n: int) -> Counter[int]:
    # A little trick here because we know a triangle number is (n * (n + 1)) // 2
    # and either n is even or n + 1 is even, so we can already factor it into either n//2 and n+1 or n and (n+1)//2.
    # Then we factor each of these smaller numbers and combine their factorizations to get the whole factorization.
    n1, n2 = (n // 2, n + 1) if n % 2 == 0 else (n, (n + 1) // 2)
    f = Counter()
    for n in (n1, n2):
        f.update(factorize(n))
    return f


def get_divisor_count(factorization: Counter[int]) -> int:
    result = 1
    for count in factorization.values():
        result *= count + 1
    return result


def main():
    n = 1
    while True:
        triangle_factorization = factorize_triangle(n)
        divisor_count = get_divisor_count(triangle_factorization)
        if divisor_count > 500:
            print(triangle(n))
            break
        n += 1


main()
