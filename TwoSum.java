//pblm link --> https://leetcode.com/problems/two-sum/description/

//Approach 1 (BRUTE FORCE) --> Nested looping T.C. -->O(N^2)
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int ans[] = new int[2];
        for(int i=0;i<nums.length-1;i++){
            int currSum = nums[i];
            for(int j=i+1;j<nums.length;j++){
                currSum += nums[j];
                if(currSum==target){
                    ans[0] = i;
                    ans[1] = j;
                    break;
                }
                //phir se reinitialize kardo 
                currSum = nums[i];
            }
        }
        return ans;
    }
}

//APPROCH - 2 -->HashMap use karo
//T.C. --> O(N) 
//S.C. --> O(N)
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int ans[] = new int[2];
        HashMap<Integer,Integer> hmap = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            hmap.put(nums[i],i);
        }
        //now phir se array ko traverse karo and ye check karo ki kya target-nums[i] present hai
        for(int i=0;i<nums.length;i++){
            int find = target-nums[i];
          //yaha pe ensure karo ki index repeat nhi hona chahiye
            if(hmap.containsKey(find) && hmap.get(find)!=i){
                ans[0] = i;
                ans[1] = hmap.get(find);
                break;
            }
        }
        return ans;
    }
}

//Approach 3 --> using 2 pointers after sorting the array 
