package com.section.recursive.dp;




/*
 * This is kind of combinatorial problem.
 * xi - is the items that we have called as N
 * 			vi - is the value of the item.
 * 			wi - is the weight of the item
 * W - maximum capacity of the knapsack.
 * 
 * 0 - we do not take it .
 * 1 -we take it.
 * 
 * s[i][w] = Math.max(s[i-1][w]: vi+s[i-1][w-wi])
 * 
 * w is arranged as columns.
 * i(value) is arranged as rows.
 * 
 * 
 * 
*/
public class KnapsackProblem {

}
