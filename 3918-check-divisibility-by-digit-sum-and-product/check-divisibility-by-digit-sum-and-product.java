class Solution {
    public boolean checkDivisibility(int n) {
        int orginal=n;
        int sum=0;
        int product=1;
        while(n>0){
            int digit=n%10;
            sum=sum+digit;
            product*=digit;
            n=n/10;
            
        }
        int ans=sum+product;
      
        if(orginal%ans==0){
            return true;
        }
        return false;
    }
}