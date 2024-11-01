public class linkstack<T> implements StackInterface<T> {
    //data members
    private Node<T> data;

    public linkstack(){
        data = null; 
    }

    //prints out the data
    public String toString(){
        if(data != null){

        System.out.print("top:");
        return data.toString();

        }else{

            return "stack is empty";
        }
    }
        // push to the top of the linked list 
    public void push(T val){
        if(this.data == null){
            this.data = new Node<T>(val);
        }else{
            this.data = new Node<T>(val,this.data);
        }
        
    }
        // returns the item at the top of the list and removes the item
    public T pop(){
        T ret = data.GetData();
        data = data.GetNext();
        return ret;
    }
        // returns the item at the top of the list
    public T top(){
        return data.GetData();

    }
    // reterns the size of the list this is 0(n) becaus it is looping over all the list.
    public int size(){
        if(this.isEmpty()){return 0;}
        else return data.listLength();
    }

        // returns true if the stack is empty returns false if the stac is > 0
    public boolean isEmpty(){
        return (this.data == null)?true:false;
    }

public static void main(String[] args) {
    // makes an empty stack
    linkstack<Integer> stack = new linkstack<Integer>();

    for(int i = 100; i > 1; i=(i%2 != 0)?(i*3)+1: i/2){
        stack.push(i);
    }
    stack.push(1);
    System.out.println(stack);

    System.out.println("the top of the stack is: " + stack.top());
    System.out.println("the len of the stack is: " + stack.size());

    //computs a sumation with the stack
    int sum = 0;    
    while (!stack.isEmpty()) {
        
        sum += stack.pop();
    }
    System.out.println(stack);
    System.out.println("the sumation of the hailstione numbers from derived from 100 is "+sum);


}
    
}
