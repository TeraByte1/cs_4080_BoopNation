## BoopNation | CS4080 Spring 20 Project: List Comprehension



## Running Haskell 
### Step One - Get BoopNation's Source Code 
Clone our repository in the terminal and run: 
```shell script
mkdir BoopNation
git clone https://github.com/TeraByte1/cs_4080_BoopNation.git
cd BoopNation
```
### Step Two - Download Compiler for Haskell
* [Download the Glasgow Haskell Compiler (GHC)] (https://www.haskell.org/downloads/#platform) for appropriate OS 

### Step Three - Run *Lists.hs*
Open terminal again and run to load the Haskell class: 
```shell script
$ ghci
Prelude> :l Lists
*Main> :r 
```
To run the first exampleList, which returns squares divisible by 3 in the range 0-6:
```shell script
*Main> exampleList 
```
To run biggerExampleList, which returns squares divisible by 3 in the range 0-10,000:
```shell script
*Main> biggerExampleList 
```
To run hugeExampleList, which returns squares divisible by 3 in the range 0-100,000:
```shell script
*Main> hugeExampleList 
```
To run another list we used for experimentation, which returns "BOOP" or "BEEP" depending on if the value is less than 15:
```shell script
*Main> boops [10..20] 
```
Note: The list ranging from 10-20 can be changed to any list. To specify a range, format the list with '..' between the min and max, 
ie [5..30] 

### More list comprehensions tested for the project in Haskell
To run another experimental list comprehension, which sorts an unsorted list: 
```shell script
*Main> sortedList
```
Our experimental list that removes vowels from an explicitly declared word can be run with: 
```shell script
*Main> rmVowels
```
Lastly, our experimental list comprehension that creates a multiplication table for values 1-3 can be run with: 
```shell script
*Main> multTable
```
