def get_permutations(items: list):
    if not items:
        yield []
        return
    for index in range(len(items)):
        rest = items[:index] + items[index + 1 :]
        sub_permutations = [p for p in get_permutations(rest)]
        for sub_permutation in sub_permutations:
            yield [items[index]] + sub_permutation


items = list(range(10))
for i, permutation in enumerate(get_permutations(items)):
    if i + 1 == 1_000_000:
        print("".join(str(n) for n in permutation))
        break
