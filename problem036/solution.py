def is_string_palindrome(s: str) -> int:
    return s == "".join(reversed(s))


def is_palindrome_in_both_bases(n: int) -> int:
    strings = [str(n), bin(n)[2:]]
    return all(is_string_palindrome(s) for s in strings)


def main():
    result = 0
    for n in range(1, 1_000_000):
        if is_palindrome_in_both_bases(n):
            result += n
    print(result)


main()
