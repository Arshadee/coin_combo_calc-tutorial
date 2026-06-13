MyCoinComboCalc					12/09/2022
===============================================
Problem statement:
Given any Total amount and number of Denominations
calculate and display all the posible combinations of the Denominations adding up to the Total amount 

for example:
Total = 6 
Denominations = [1,2,3]

Result:
Total Number of combinations 7
1 1 1 1 1 1
1 1 1 1 2
1 1 1 3
1 1 2 2
1 2 3
2 2 2
3 3
Total Number of combinations 7

------------------------------------

Instructions to run with input args:
eg:
30 1 2 3 5 29 30 31

javac Main.java    -- to compile
java Main 30 1 2 3 5 29 30 31   --to run

Usage: Main (total) (denomination1) (denomination2) (denomination3) ... (denominationN)

Therefore
Usage: Main (total) (denomination1) (denomination2) (denomination3) (denomination4)  (denomination5) (denomination6) (denomination7)
              30		1			      2			     3		        5			      29			    30		        31
              
or to run using a specific algorthim from the 2 available
REC = Recursive Debth First Search Algorthim  (default)
ITR = Iterative Debth First Search Algorthim

Usage: Main (total) (denomination1) (denomination2) (denomination3) ... (denominationN) ITR

add the algorithm label (ITR / REC) at the end
