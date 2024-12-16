from itertools import permutations


def get_value_from_digits(digits):
    value = 0
    for digit in digits:
        value *= 10
        value += digit
    return value


def main():
    result = 0

    divisors = [2, 3, 5, 7, 11, 13, 17]

    for permutation in permutations(range(10)):
        is_special = True
        for i, divisor in enumerate(divisors):
            value = get_value_from_digits(permutation[i + 1 : i + 4])
            if value % divisor != 0:
                is_special = False
                break

        if is_special:
            result += get_value_from_digits(permutation)

    print(result)


main()
