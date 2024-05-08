// Approach 1
// T.C.--> O(N logN) , S.C. --> O(1)
//BRUTE FORCE --> Directly inbuilt sort method ka use krke SORT kardo
class Solution {
    public void sortColors(int[] nums) {
        Arrays.sort(nums);

    }
}

/*
Approach --> 2
T.c. --> O(N)
Ab thoda sa na hum OPTIMIZE  krte hai code ko kyunki Approach 1 ke case T.C. --> O(N logN) jaa rahi thi
Ab hum basically use karenge 3 pointers -- (left {l} ,mid {m}, right {r})

Aur hamara logic ye hoga ki left pointer ke help se hum starting mei 0s ko laane ka try karenge and with the help of right pointer hum 2s ko end mei place karane ka try karenge and mid point karenge value 1 ko

DRY RUN krke samajhte hai
 m         r
[2,0,2,1,1,0]  --> since mid point kar raha hai 2 ko and r 0 ko so swap krdo dono ko
 l
r ko decrement krdo because last position pe 2 aaa chuka hai jo ki correct position hai
 m       r
[0,0,2,1,1,2] 
 l

now left and mid, both are pointing to 0 toh just increment both of them
   m     r
[0,0,2,1,1,2] 
   l

now again left and mid, both are pointing to 0 toh just increment both of them
     m   r
[0,0,2,1,1,2] 
     l

now mid 2 ko point kar raha hai so swap krdo with right ptr
     m r
[0,0,1,1,2,2] 
     l
now since mid 1 ko point kar raha hai just increment mid {because 1 apne sahi position pe hai and jab bhi mid 1 ko point krta hai means 1 apne correct position pe hi hai
so just simply increment mid
NOTE --> Iss logic ka ek fancy sa naam hai --> DUTCH NATIONAL FLAG ALGORITHM
*/
class Solution {
    public void sortColors(int[] nums) {
       int l=0;
       int r=nums.length-1;
       int m=0;
       while(m<=r){
        if(nums[m]==0){
            //swap with l ptr
            int temp = nums[l];
            nums[l] = nums[m];
            nums[m] = temp;
            l++;
            m++;
        }
        else if(nums[m]==1){
            m++;
        }
        else{
            int temp = nums[r];
            nums[r] = nums[m];
            nums[m] = temp;
            r--;
        }
       }
    }
}
