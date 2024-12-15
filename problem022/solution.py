data = open("0022_names.txt").read()
names = [name[1:-1] for name in data.split(",")]
names.sort()

result = 0
for i, name in enumerate(names):
    char_sum = sum(ord(c) - ord("A") + 1 for c in name)
    result += (i + 1) * char_sum
print(result)
