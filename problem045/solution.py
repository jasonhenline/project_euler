from math import isqrt
from itertools import count


def get_integer_roots_for_quadratic(a: int, b: int, c: int) -> list[int]:
    discriminant = b**2 - 4 * a * c
    if discriminant < 0:
        return []
    sqrt_discriminant = isqrt(discriminant)
    if sqrt_discriminant**2 != discriminant:
        return []
    ns = [-b + sqrt_discriminant, -b - sqrt_discriminant]
    d = 2 * a

    divmods = [divmod(n, d) for n in ns]
    return [q for (q, r) in divmods if r == 0]


def quadratic_has_non_negative_integer_solution(a: int, b: int, c: int) -> bool:
    return any(r >= 0 for r in get_integer_roots_for_quadratic(a, b, c))


def is_triangle(n: int) -> bool:
    # Quadratic equation comes from k*(k + 1)//2 == n
    #   => k**2 + k - 2*n == 0
    return quadratic_has_non_negative_integer_solution(1, 1, -2 * n)


def is_pentagonal(n: int) -> bool:
    # Quadratic equation comes from k*(3*k - 1)//2 == n
    #   => 3*k**2 - k - 2*n == 0
    return quadratic_has_non_negative_integer_solution(3, -1, -2 * n)


def get_hexagonal(n: int) -> int:
    return n * (2 * n - 1)


def main():
    for n in count(144):
        hexagonal = get_hexagonal(n)
        if is_triangle(hexagonal) and is_pentagonal(hexagonal):
            print(hexagonal)
            return


main()
