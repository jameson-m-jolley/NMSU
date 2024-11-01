/**
 * recusion
 */
public class recusion {
    
    //lin recusion
    //o(n)
    //
    public static int recusionsum(int[] arr, int n){
        if(n==1)return arr[0];
        else return recusionsum(arr,n-1 + arr[n-1]);
    }
//binary recusion
//o(n)
//this is more effechant for mem
    public static int recusion_sum(int[] arr, int s,int n){
        int mid = (s+n)/2;
        if (s==n) return arr[s];
        else return recusion_sum(arr, s, mid)+recusion_sum(arr, mid, n);
        
    }

    //tail recusion
    //avoid this
    //this is whe the recusive call is the last operation
    //this stors alot on the stack
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,5,6,7,7,8,8,3,34,43,3,5,64,64};

    }
    
}