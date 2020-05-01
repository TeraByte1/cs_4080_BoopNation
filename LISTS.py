import random
# example O(n)
exampleList = [x*x for x in range(7) if x%3 == 0]

# example O(n^2)- nested list comprehension
# 3 x 3 matrix
matrix = [[x for x in range(3)] for y in range(3) ]

# example O(n^3) - even more nested
# 3 x 3 x 3 matrix
dim_matrix = [ [[x for x in range(3)] for y in range(3)] for z in range(3)]

# python sorted uses Tim Sort algorithm O(nlogn) 
# creates a random list of length 10 and then sorts
sorted_random_list = sorted([random.randrange(0,100,1) for i in range(10)])




