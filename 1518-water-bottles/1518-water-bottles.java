class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        
                    
            int ans = numBottles;
      
        while(numBottles >= numExchange){
            
            int newBottles = numBottles / numExchange;
            
            ans = ans + newBottles;
            
            int remainBottles = numBottles % numExchange;
            
            numBottles = newBottles + remainBottles;

        }
        return ans;
    }
}