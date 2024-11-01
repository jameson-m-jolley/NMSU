import java.util.ArrayList;

class RecursiveQuestion
{


public static int toInt(String c){
    if(c.length() == 1){
       return c.charAt(0)-'0';
    }
    else{
       return toInt(c.substring(0, c.length()-1)) * 10 + toInt(c.substring(c.length()-1, c.length()));
    }
}

public static <T> void reverseStack(linkstack<T> stack, linkQue<T> Q){
    if (!stack.isEmpty()){
        Q.inQue(stack.pop());
        reverseStack(stack, Q);
    }
    if(!Q.isEmpty()){
       stack.push(Q.next()); 
    }
    
} 

public static int FibBinaryRecursive(int k){
   if(k<2)return k;
   else return FibBinaryRecursive(k -1)+FibBinaryRecursive(k-2);
}

// reverses an array at form index l to h
public static void reverse(int[] arr, int l, int h){
   if(l>=h){}
   else{
       reverse(arr, l+1, h-1);
       int temp = arr[l];
       arr[l] = arr[h];
       arr[h] = temp;      
   }
}

//swaps the values;
public static void swap(int[] arr, int l, int h){
    int temp = arr[l];
    arr[l] = arr[h];
    arr[h] = temp;    
}
// this genarates all the purmutations 
public static void purm(int[] arr,int l, int h ){
   // print the arr
    if(l==h){
        for(int i:arr){
            System.out.print(i+" ");
        }System.out.println(" ");
    }else{
        for(int j=l;j<=h;j++){
            //swaps at vals 
            swap(arr, j, l);
            // genarates more 
            purm(arr, l+1, h);
            // swaps back
            swap(arr, j, l);
        }
    }
}

public static void HanoiProblem(ArrayList<linkstack<Integer>> towers){
    if(towers.get(0).isEmpty()){
        
       if(!towers.get(towers.size()-2).isEmpty()){
        //moves 1 out of the way of 2 and pust the remaing to back on the last stack
           towers.get(0).push(towers.get(towers.size()-2).pop());
           printTower(towers);

           towers.get(2).push(towers.get(towers.size()-2).pop());
           printTower(towers);
           towers.get(2).push(towers.get(0).pop());
            printTower(towers);
       }
    }else{
        if(towers.get(0).size()>1){
            // move to the right the size of the stack
            towers.get(towers.get(0).size()-1).push(towers.get(0).pop());
            printTower(towers);
            HanoiProblem(towers);
        }else{
            if(towers.get(towers.size()-1).isEmpty()){
                //move 3 
                towers.get(towers.size()-1).push(towers.get(0).pop());
                printTower(towers);
                HanoiProblem(towers);
            }else{
                //pop the last back 
                towers.get(towers.size()-2).push(towers.get(towers.size()-1).pop());
                printTower(towers);
                HanoiProblem(towers);
            }
        }
    }
}

public static void main(String[] args) {
   String s ="1234";
   int num  = toInt(s);
   System.out.println(s);
   System.out.println(num);
   System.out.println(FibBinaryRecursive(10));
  
   int[] arr ={1,3,4,5,3,2,34,5};
   for(int i=0;i< arr.length;i++){
       System.out.print(arr[i]+" ");
   }
   System.out.println("");


   reverse(arr, 2, 7);
   for(int i=0;i< arr.length;i++){
       System.out.print(arr[i]+" ");
   }System.out.println("");

   System.out.println("testing Permutation ");
   int[] narr = {1};
   //purm(narr,0,narr.length-1);

   int[] narr1 = {1,2};
   //purm(narr1,0,narr1.length-1);

   int[] narr2 = {1,2,3,4,5};
   purm(narr2,0,narr2.length-1);

   int[] narr3 = {1,2,3,4,5,6,7,8,9,10};
   //purm(narr3,0,narr3.length-1);


   //test for the HanoiProblem-------------------------------------------------
   System.out.println("test for the HanoiProblem");
   ArrayList<linkstack<Integer>> towers = new ArrayList<linkstack<Integer>>();
   towers.add(new linkstack<Integer>());
   towers.add(new linkstack<Integer>());
   towers.add(new linkstack<Integer>());

   towers.get(0).push(10);
   towers.get(0).push(33);
   towers.get(0).push(1);

   printTower(towers);
   HanoiProblem(towers);
   //end the test----------------------------------------------------------------


   //testing the reverse stack---------------------------------------------------
   
   linkstack<Integer> stack = new linkstack<Integer>();
   for(int i = 0; i < 5; i++ ){
    stack.push(i);
   }
   System.out.println(stack);
   reverseStack(stack, new linkQue<Integer>());
   System.out.println(stack);

   
}
public static void printTower(ArrayList<linkstack<Integer>> towers){
        for(int i=0;i< towers.size();i++ ){
            linkstack<Integer> t = towers.get(i);
            System.out.println("row#"+i+": "+t);
        }
        System.out.println("");
    }
}







