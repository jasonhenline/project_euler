from itertools import permutations


def is_concat_of_consecutive_multiples(digits):
    s = "".join(str(d) for d in digits)
    for end in range(1, 9):
        m = int(s[:end])
        rest = s[end:]
        n = 2
        while True:
            ss = str(m * n)
            if rest.startswith(ss):
                rest = rest[len(ss) :]
                n += 1
                if not rest:
                    return True
            else:
                break
    return False


def main():
    for permutation in permutations(reversed(range(1, 10))):
        if is_concat_of_consecutive_multiples(permutation):
            print("".join(str(d) for d in permutation))
            break


main()
