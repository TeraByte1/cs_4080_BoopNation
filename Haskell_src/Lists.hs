import Data.List
import System.IO 
--import Criterion.Main
--import Criterion.Main
--use :set +s 

--each list comprehension returns a resulting list 

--timeIt :: IO a -> IO a
--(1) example our slides: returns squares from range 0-6 divisible by 3
exampleList = [ x * x | x <-[0..6], x `mod` 3 == 0] --[0,9,36]
biggerExampleList = [x * x | x <- [0..10000], x `mod` 3==0]
hugeExampleList = [x * x | x <- [0..100000], x `mod` 3==0]


--(2) tested with inputList [10..20] - if x is less than 15, print BOOP else print BEEP
boops inputList  = [ if x < 15 then "BOOP" else "BEEP" | x <- inputList]

--(3) sort a list 
sortedList = sort [4, 39, 18, 27, 13, 15, 200, 40001, 3, 2, 2938, 100, 101]

--remove vowels from word
rmVowels = [x | x <- "supercalifragilisticexpialidocious", not (elem x "aeio")]

--create a multiplication table for values from 1-3. 
--inner list comprehension: x multiplied by every value in y
--outer list comprehension: perform inner list comprehension operations for values in x: 1-3 
multTable = [ [x * y | y <- [1..3]] | x <-[1..3] ]

maxList = [1, 7, 13, 200, 15, 100]