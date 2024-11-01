
public class linkQue<T> implements QueInterface<T> {
    public Node<T> front;
    public Node<T> rear;
    public int length;

    public linkQue(){
        rear = null;
        front = null;
        length = 0;
    }

    public linkQue(T init){
        rear = new Node<T>(init,rear);
        front = rear;
        length = 1;
    }

    public String toString(){
        if(length > 0){
             return "Que::"+ front.toString();
        }else{
            return "empty Que";
        }
       
    }

    public void inQue(T obj){
        if(rear == null ){
            rear = new Node<T>(obj);
            front = rear;
            length++;
        }else{
            rear.addNodeAfterThis(obj);
            rear = rear.GetNext();
            length++;
        }
    };
    public T next(){
        T ret = front.GetData();
        front= front.GetNext();
        length--;
        return ret;
    }
    public int size(){
        return front.listLength();
    };
    public boolean isEmpty(){
        if(length == 0){
            return true;
        }else{
            return false;
        }
    };

    public static void main(String[] args) {
    linkQue<Integer> test = new linkQue<Integer>();
    System.out.println(test.isEmpty()); 
    

    test.inQue(4);
    test.inQue(5);
    System.out.println("len = "+test.length);


    System.out.println(test);

    System.out.println(test.next());
    System.out.println(test.next());
    System.out.println(test);


    }
    
    
}
