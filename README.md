# Coding Challenge Project - *Zip Code Range*

### Zip Code Range

1. Brute Force Solution - `O(n^2)`
* Start from the first interval and compare with the rest of intervals
* If it finds an overlapping interval, it'll merge with the first interval and remove it from the array.
* Repeat the above steps for the rest of the intervals
2. Optimal Solution - Time Complexity `O(nlog(n))` and Space Complexity `O(n)`
* Sort the array of intervals on the start zip code in increasing order
* Create an empty stack of intervals and push the first interval
* Iterate through the rest of the intervals and compare the current interval with the top element of stack
* If top.end is less than currentInterval.start, push the current interval to the stack
* Otherwise, if the top.end is less than currentInterval.end, it will be an overlapping interval. Pop the top element of the stack, merge it with the current interval and push them back to the stack
* Repeat the above two steps for the rest of the elemnts in the array - Time Complexity `O(n)` - n is the array size
* For printing the result, iterate through the stack - Time Complexity `O(n)` and Space Complexity `O(n)` - n is the stack size

## How To Run
Open the project in any IDE which supports Java e.g. Eclipse, IntelliJ


