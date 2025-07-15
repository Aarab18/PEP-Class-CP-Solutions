Problem Statement: Special Index Count


You are given an array nums of integers. An index i is called a special index if, after removing the element at index i, the sum of the elements at even indices becomes equal to the sum of the elements at odd indices in the resulting array.

Your task is to count the total number of such special indices.

🔸 Input:
An integer n (1 ≤ n ≤ 10⁵) — the size of the array

An array nums of n integers (1 ≤ nums[i] ≤ 10⁴)

🔸 Output:
A single integer — the number of special indices

🔸 Example:
Input:
6
4 3 6 3 8 12

Output:
1

Explanation:
Removing index 4 (value = 8) results in [4, 3, 6, 3, 12]
New indices: 0 1 2 3 4
Even indices sum = 4 + 6 + 12 = 22
Odd indices sum = 3 + 3 = 6
Only one index gives equal sums after adjustment.