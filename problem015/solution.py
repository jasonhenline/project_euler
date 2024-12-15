# We need to move left 20 times and right 20 times.
#
# There will always be 40 total moves, so we just need to see how many ways there are to choose which 20 are left and
# which 20 are down.
#
# Mathematically this is 40 choose 20.

from math import comb

print(comb(40, 20))
