# cs_4080_BoopNation
## CS4080 Spring 20 Project: List Comprehension


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
To run the first list, which returns squares divisible by 3 in the range 0-6:
```shell script
*Main> exampleList 
```
To run the second list, which returns "BOOP" or "BEEP" depending on if the value is less than 15:
```shell script
*Main> boops [10..20] 
```
The list ranging from 10-20 can be changed to any list. To specify a range, format the list with '..' between the min and max, 
ie [5..30] 

To run the third list, which sorts an unsorted list: 
```shell script
*Main> sortedList
```
