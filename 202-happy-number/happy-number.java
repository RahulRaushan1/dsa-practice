class Solution {
    public int square (int n ){
        int sum =0;
        while(n>0){
            int x = n%10;
            sum= sum + x*x;
            n= n/10;
        }
        return sum;
    }
    public boolean isHappy(int n) {
        int fast=n;
        int slow=n;
        do{
            slow= square(slow);
            fast= square(square(fast));
          }
           
          while(slow!=fast); 
        
        return slow==1;
    }
}