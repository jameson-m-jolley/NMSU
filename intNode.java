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
}
