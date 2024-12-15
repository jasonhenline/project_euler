# The largest product of two three-digit numbers is 999 * 999 = 998001.
#
# We will count down the six-digit palindromes until we find one that is the product of two three-digit numbers.


def is_product_of_two_three_digit_numbers(n: int) -> bool:
    for d in range(100, 1000):
        q, r = divmod(n, d)
        if r == 0 and 100 <= q < 1000:
            return True
        if q < 100:
            return False
    return False


def main():
    top = 999
    while True:
        bottom = int("".join(reversed(str(top))))
        n = 1000 * top + bottom
        if is_product_of_two_three_digit_numbers(n):
            print(n)
            break
        top -= 1


main()
