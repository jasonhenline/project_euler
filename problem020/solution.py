def factorial(n: int) -> int:
    result = 1
    for k in range(1, n + 1):
        result *= k
    return result


def main():
    # Little optimization is that the 100 will just add zeros at the end, so we can leave that out.
    n = factorial(99)
    s = str(n)
    print(sum(int(c) for c in s))


main()
