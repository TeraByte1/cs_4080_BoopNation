import random
import os
import psutil
from guppy import hpy
import time

# example O(n)
start_time = time.time_ns()
exampleList = [x*x for x in range(7) if x%3 == 0]
end_time = time.time_ns()
print("---%s nanoseconds---" %(time))
h = hpy()
string = h.heap()
print (string)

#bigger example
start_time = time.time_ns()
biggerExampleList = [x*x for x in range(10001) if x%3 == 0]
end_time = time.time_ns()
print("---%s nanoseconds---" %(time))
h = hpy()
string = h.heap()
print (string)

#hugeExample
start_time = time.time_ns()
hugeExampleList = [x*x for x in range(100001) if x%3 == 0]
end_time = time.time_ns()
print("---%s nanoseconds---" %(time))
h = hpy()
string = h.heap()
print (string)

# example O(n^2)- nested list comprehension
# 3 x 3 matrix
matrix = [[x for x in range(3)] for y in range(3) ]

# example O(n^3) - even more nested
# 3 x 3 x 3 matrix
dim_matrix = [ [[x for x in range(3)] for y in range(3)] for z in range(3)]

# python sorted uses Tim Sort algorithm O(nlogn) 
# creates a random list of length 10 and then sorts
sorted_random_list = sorted([random.randrange(0,100,1) for i in range(10)])
