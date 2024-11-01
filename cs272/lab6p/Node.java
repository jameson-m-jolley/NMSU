class Node<T>{
    private T data;
    private Node next;
    
    public Node(){
        this.data = null;
        this.next = null;
    }
        
    public Node(T data){
        this.data = data;
        this.next = null;
    }

    public Node(T data, Node<T> next){
        this.data = data;
        this.next = next;
    }

   public T GetData(){
        return this.data; 
   }

   public Node GetNext(){
        return this.next;
   }

   public void setData(T data){
        this.data = data;
   } 

   public void setNext(Node next){
        this.next = next;
   }

   public String toString(){
        if(next != null){
           return ""+this.data+"->"+this.next.toString();
        }else{
            return ""+this.data;
        }
   }

   public void addNodeAfterThis(T data){
        this.next = new Node(data,this.next);
   }

   public void removeNodeAfterThis(){
        this.next = this.next.next;
   }

   //this is a non static method that is called by the static one
   public int listLength(){
        if(next != null){
            return 1 + this.next.listLength();
        }else{
            return 1;
        }
   }
   public static int listLength(Node head){
        return head.listLength();
   }
   //this looks throug the list from the current node to the end of the list.
   public boolean search(T data){
     Node head = this;
     while (head.next != null) {
          if(head.data == data){
            return true;   
          }
          head = head.next;
     }
     return false;
   } 

   public static Node reverse (Node head){
     Node rv = new Node();
     while (head.next != null) {
          rv.addNodeAfterThis(head.GetData());
          head = head.GetNext();
     }
     rv.addNodeAfterThis(head.GetData());
     rv = rv.GetNext();
     return rv;
   }



   public static void main(String[] args) {
     Node head = new Node("this");
     head.addNodeAfterThis("is");
     head.addNodeAfterThis("kinda");
     head.addNodeAfterThis("cool");

     System.out.println(head);
     System.err.println("reverse(head)");
     System.err.println(reverse(head));
     System.out.println(listLength(head));

     head = reverse(head);
     Node other = new Node();
     for(int i =10 ; i>0;--i){
          other.addNodeAfterThis(i);
     }
     
   }
}
