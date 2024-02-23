class intNode{
    private int data;
    private intNode next;
    
    public intNode(){
        this.data = 0;
        this.next = null;
    }
        
    public intNode(int data){
        this.data = data;
        this.next = null;
    }

    public intNode(int data,intNode next){
        this.data = data;
        this.next = next;
    }

   public int GetData(){
        return this.data; 
   }

   public intNode GetNext(){
        return this.next;
   }

   public void setData(int data){
        this.data = data;
   } 

   public void setNext(intNode next){
        this.next = next;
   }

   public String toString(){
        if(next != null){
           return ""+this.data+"->"+this.next.toString();
        }else{
            return ""+this.data;
        }
   }

   public void addNodeAfterThis(int data){
        this.next = new intNode(data,this.next);
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
   public static int listLength(intNode head){
        return head.listLength();
   }
   
   public static boolean search(intNode head, int data){

   intNode lookingPoint = head;

    if(head.data == data){
        return true;
    }
    while(head.next != null){
      if(head.data == data){
        return true;
      } else{
        lookingPoint = lookingPoint.next;
      }
    }
    return false;
   } 

public static intNode merge(intNode head1, intNode head2){
     intNode ret = new intNode();
     intNode place = ret;
     while (head1.next != null) {
          if(head2 != null){
               if(head1.GetData() < head2.GetData()){
                    place.addNodeAfterThis(head1.GetData());
                    place = place.GetNext();
                    head1 = head1.GetNext();
               }

               if(head2.GetData() <= head1.GetData()){
                    place.addNodeAfterThis(head2.GetData());
                    place = place.GetNext();
                    head2 = head2.GetNext();
               }
          }else{
               ret.setNext(head1);
               break;
          }    

     }
     ret = ret.GetNext();
     return ret;
}

   public static intNode reverse (intNode head){
     intNode rv = new intNode();
     while (head.next != null) {
          rv.addNodeAfterThis(head.GetData());
          head = head.GetNext();
     }
     rv.addNodeAfterThis(head.GetData());
     rv = rv.GetNext();
     return rv;
   }



   public static void main(String[] args) {
     intNode head = new intNode(22);
     head.addNodeAfterThis(4);
     head.addNodeAfterThis(13);
     head.addNodeAfterThis(20);

     System.out.println(head);
     System.err.println("reverse(head)");
     System.err.println(reverse(head));
     intNode other = new intNode();
     for(int i =10 ; i>0;--i){
          other.addNodeAfterThis(i);
     }
     System.err.println(other);
     System.err.println(merge(head, other).toString());
   }
}
