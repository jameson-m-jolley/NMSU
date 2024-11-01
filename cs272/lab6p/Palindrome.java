import java.util.Scanner;
public class Palindrome {
    public static void main(String[] args) {
        System.out.println("enter some text");
        Scanner scan = new Scanner(System.in);
        String text = scan.nextLine();
        String[] split = text.split(" ");
        linkQue<String> normal = new linkQue<String>();
        linkstack<String> rev = new linkstack<String>();
     
        // we can use the stack to reverse the string and the que to store the normal string.
        for(int i=0;i<split.length;i++){
            normal.inQue(split[i]);
            rev.push(split[i]);
        }

        boolean pal =true;
        for(int i=0;i<split.length;i++){
            String s1 =normal.next();
            String s2 = rev.pop();
            if(!s1.equals(s2)){
                pal=false;
                break;
            }
        }
        
        if(pal==false){
            System.out.println("this is not a palindrome");
        }else{
            System.out.println("this is a palindrome");
        }
    }
    
}
