import Data.List
import System.IO 

--(1) example our slides: returns squares from range 0-6 divisible by 3
exampleList = [ x * x | x <-[0..6], x `mod` 3 == 0] --[0,9,36]

--(2) tested with list [10..20] - if x is less than 15, print BOOP else print BEEP
boops inputList  = [ if x < 15 then "BOOP" else "BEEP" | x <- inputList]

--(3) sort a list 
sortedList = sort [4, 39, 18, 27, 13, 15]



