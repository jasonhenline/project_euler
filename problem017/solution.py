unique_name = [
    "",
    "one",
    "two",
    "three",
    "four",
    "five",
    "six",
    "seven",
    "eight",
    "nine",
    "ten",
    "eleven",
    "twelve",
    "thirteen",
    "fourteen",
    "fifteen",
    "sixteen",
    "seventeen",
    "eighteen",
    "nineteen",
]

decades = [
    "",
    "",
    "twenty",
    "thirty",
    "forty",
    "fifty",
    "sixty",
    "seventy",
    "eighty",
    "ninety",
]


def get_string(n: int) -> str:
    parts: list[str] = []

    hundreds_digit, under_100 = divmod(n, 100)

    if hundreds_digit:
        digit_string = unique_name[hundreds_digit]
        parts.append(f"{digit_string} hundred")
        if under_100:
            parts.append(" and ")

    if under_100 < len(unique_name):
        parts.append(unique_name[under_100])
    else:
        tens_digit, ones_digit = divmod(under_100, 10)
        tens_name = decades[tens_digit]
        ones_name = unique_name[ones_digit]
        parts.append(tens_name)
        if ones_digit:
            parts.append(f"-{ones_name}")

    return "".join(parts)


def main():
    result = 0
    for n in range(1, 1000):
        s = get_string(n)
        simplified = s.replace(" ", "").replace("-", "")
        result += len(simplified)

    result += len("one")
    result += len("thousand")
    print(result)


main()
