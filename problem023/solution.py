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
    abundants = [n for n in range(2, 28123 + 1) if get_proper_divisor_sum(n) > n]
    non_sums = set(range(1, 28123 + 1))
    for i in range(len(abundants)):
        for j in range(i, len(abundants)):
            s = abundants[i] + abundants[j]
            if s in non_sums:
                non_sums.remove(s)
    print(sum(non_sums))


main()
