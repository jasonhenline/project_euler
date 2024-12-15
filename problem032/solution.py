from itertools import permutations


def digits_to_value(digits: tuple[int, ...]) -> int:
    result = 0
    for i in range(len(digits) - 1, -1, -1):
        result *= 10
        result += digits[i]
    return result


seen = set()
for permutation in permutations(range(1, 10)):
    for end0 in range(1, 9):
        for end1 in range(end0 + 1, 9):
            a = digits_to_value(permutation[:end0])
            b = digits_to_value(permutation[end0:end1])
            c = digits_to_value(permutation[end1:])
            if a * b == c:
                seen.add(c)
print(sum(seen))
