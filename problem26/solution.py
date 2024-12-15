def get_reciprocal_cycle_size(n: int) -> int:
    index = 0
    r = 1
    remainder_to_index = {r: index}
    while True:
        if r == 0:
            return 1

        while r < n:
            r *= 10
        q, r = divmod(r, n)
        index += 1
        if r in remainder_to_index:
            return index - remainder_to_index[r]
        remainder_to_index[r] = index


def main():
    max_cycle_size = 0
    best_d = 0
    for d in range(2, 1000):
        cycle_size = get_reciprocal_cycle_size(d)
        if cycle_size > max_cycle_size:
            max_cycle_size = cycle_size
            best_d = d
    print(best_d)


main()
