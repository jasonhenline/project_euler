"""
Here is the extended pattern:

73 74 75 76 77 78 79 80 81
72 43 44 45 46 47 48 49 50
71 42 21 22 23 24 25 26 51
70 41 20 7  8  9  10 27 52
69 40 19 6  1  2  11 28 53
68 39 18 5  4  3  12 29 54
67 38 17 16 15 14 13 30 55
66 37 36 35 34 33 32 31 56
65 64 63 62 61 60 59 58 57

It's clear that the diagonal from the center in the NE direction is the square of the odd numbers.

Let's let n = 0 correspond to the 1 in the center. Then the NE diagonal is the sequence (2*n+1)**2.

    NE Corner: (2*n+1)**2

We can subtract from this to get the NW corner:

    NW Corner: (2*n+1)**2 - 2*n

Plugging in a few values to check we have

n | 2*n | 2n+1 | result
===========================
0 | 0   | 1    | 1
1 | 2   | 3    | 7
2 | 4   | 5    | 21
3 | 6   | 7    | 43
4 | 8   | 9    | 73

Subtract another 2*n to get to the SW corner.

    SW Corner: (2*n+1)**2 - 4*n

And subtract one more 2*n to get the SE corner.

    SE Corner: (2*n+1)**2 - 6*n

Adding all these together for a given n gives

    Total: 4*(2*n+1)**2 - 12*n

We can expand this to get:

        4*(4*n**2 + 4*n + 1) - 12*n
    =   16*n**2 + 4*n + 4
"""

side_length = 1001
upper_n = (side_length - 1) // 2
result = 1
for n in range(1, upper_n + 1):
    result += 16 * n**2 + 4 * n + 4
print(result)
