import itertools


def get_word_value(s: str) -> int:
    return sum(ord(c) - ord("A") + 1 for c in s)


def main():
    words = [s[1:-1] for s in open("0042_words.txt").read().split(",")]
    word_values = [get_word_value(word) for word in words]
    max_word_value = max(word_values)

    triangles = (n * (n + 1) // 2 for n in itertools.count(0))
    triangles_set = set(itertools.takewhile(lambda n: n <= max_word_value, triangles))

    result = sum(1 if word_value in triangles_set else 0 for word_value in word_values)
    print(result)


main()
