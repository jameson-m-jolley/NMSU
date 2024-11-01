class Dlinkedlist{
  

    private DIntNode Dhead;
    private DIntNode Dtail;

    public Dlinkedlist(){
        Dhead = new DIntNode();
        Dtail = new DIntNode();
        Dhead.setNext(Dtail);
        Dtail.setPrev(Dhead);

    }
    public DIntNode getHead(){
        return Dhead.getNext();
    }

    public DIntNode getTail(){
        return Dtail.getPrev();
    }

    public void setHead(DIntNode node){
        Dhead = node;
    }

    public void setTail(DIntNode node){
        Dtail = node;
    }
    
    public int len(){
        int r =0;
        for(DIntNode cursor = this.getHead();cursor != this.Dtail;cursor = cursor.getNext()){
            r++;
        }
        return r;
    }

    //convers the list to a sting in O(n) Time
    public String toString(){

        String r  = "\n(forward) ";
        DIntNode c = Dhead.getNext();
        do
        {
           if(c.equals(Dtail)){
                r += "\n";
           }else{
                r += ""+ c.getData();
                r +=(c.getNext().equals(Dtail))?"\n":"<->";
           }
            c=(c.getNext() == null)?c:c.getNext();
        }
        while(!c.equals(Dtail));
        c = c.getPrev();
        r+= "(backward) ";

        do
        {
           if(c.equals(Dhead)){
                r += "\n";
           }else{
                r += ""+ c.getData();
                r +=(c.getPrev().equals(Dhead))?"\n":"<->";
           }
            c=(c.getPrev() == null)?c:c.getPrev();
        }
        while(!c.equals(Dhead));


        return r;
    }
    // this adds an element at the end 
    public void addEnd(int element){

        Dtail.getPrev().setNext(new DIntNode(element));
        Dtail.getPrev().getNext().setNext(Dtail);
        Dtail.getPrev().getNext().setPrev(Dtail.getPrev());
        Dtail.setPrev(Dtail.getPrev().getNext());

    }

    public void removeFromHead(){

        Dhead.getNext().getNext().setPrev(Dhead);
        Dhead.setNext(Dhead.getNext().getNext());
    }
//counts all the intances of the int e in the list.
//the runtime of this is constant time o(n)
    public int countOccurrence(int e){
        int r =0;
        DIntNode c = Dhead;
        do{ 
            c=(c.getNext()==null)?c:c.getNext();
            r += (e==c.getData())?1:0;
        }while(!c.equals(Dtail));
        return r;
    }
    public boolean removeAll(int e){
        boolean r = false;
        DIntNode c = Dhead;
        do{ 
            c=(c.getNext()==null)?c:c.getNext();
            if(c.getData()==e){
                r = true;
                c.getPrev().setNext(c.getNext());
                c.getNext().setPrev(c.getPrev());
            }
        }while(!c.equals(Dtail));
        return r;
    }
    // this reverses a set of a sub list starting at index stored in the peramiter from reversing to the index of from+k
    //the runtime of this function is o(n)
    public static void reverse(DIntNode cursor,int k){
       
        Dlinkedlist fromHead = new Dlinkedlist();

        for(int i=0;i<k-1;i++)
            cursor=cursor.getNext();

            DIntNode end = cursor.getNext();


        for(int l=0; l<k; l++){
            fromHead.addEnd(cursor.getData());
            cursor= cursor.getPrev();
        }
        
        // adds the reversed nodes to the list
        cursor.setNext(fromHead.getHead());
        fromHead.getHead().setPrev(cursor);

        end.setPrev(fromHead.getTail());
        fromHead.getTail().setNext(end);;
        //System.out.println("test of fromhead"+fromHead);

   }
   // this makes a coppy of the list O(n)
   public Dlinkedlist clone(){
    Dlinkedlist r = new Dlinkedlist();
        for(DIntNode cursor = this.getHead();cursor != this.Dtail;cursor = cursor.getNext()){
            r.addEnd(cursor.getData());
        }
        
    return r;
   }
    // this reverses the k groops O(n)
    public static Dlinkedlist reverse_kgroups(Dlinkedlist list,int k){
        //creates a coppy and loop over all the items in the list 
        Dlinkedlist r = list.clone();
        DIntNode cursor = r.getHead();
        int l = list.len();
        for(int i=0; i < l; i+=k){
            // flips by groop k at the cursor
                if(i+k < l){
                    reverse(cursor, k);
                }
            // incraments the cursor by k
            for(int c = 0; c < k; c++)
                cursor= cursor.getNext();
            }
        return r;
    }
    //test the functions
    public static void main(String[] args) {
        Dlinkedlist test = new Dlinkedlist();
        //prints a n empty list
        System.out.println(test);
        test.addEnd(1);
        test.addEnd(2);
        test.addEnd(3);
        test.addEnd(4);
        test.addEnd(5);
        test.addEnd(6);
        //prints elament with 2 nodes
        System.out.print(test);
        test.removeAll(5);
        System.out.println("removing 5:"+test);
        reverse(test.getHead(), 2);
        
        System.out.println("reversing from 0 by 2 nodes"+test);

        System.out.println("testing k groops"+reverse_kgroups(test, 2));
        
    }


}