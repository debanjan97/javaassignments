class Node<Type>{ 
    Type data;
    Node<Type> next;

    Node(Type data, Node<Type> next){
        this.data = data;
        this.next = next;
    }

}

class SList<Type>{
    Node<Type> head = new Node<Type>(null, null);

    public String toString(){
        if(head.next == head){
            return "List is empty.";
        }

        SListIterator<Type> it = iterator();
        String S = "< ";
        while(it.hasNext()){
            S = S + it.next().data.toString() + " => ";
        }
        return S+" null >";
    }

    SListIterator<Type> iterator(){
        return new SListIterator<Type>(head);
    }
}

class SListIterator<Type>{     //iterating through the linked list
    Node<Type> curr;
    Node<Type> head;
    public SListIterator(Node<Type> head) {
        this.curr = head;
        this.head = head;
    }

    public boolean hasNext(){
        if(curr.next == null){
            return false;
    	}
        return true;
    }

    public Node<Type> next(){
        curr = curr.next;
        return curr;
    }

    public void add(Type data) {
        curr.next = new Node<Type>(data, null);
        curr = curr.next;
    }

    String delete(){
        Node<Type> temp = head;
        if(temp.next == null){
            return "List Underflow";
        }
        while(temp.next.next != null){
            temp = temp.next;
        }
        curr = temp;
        String returnString =  "Deleting " + temp.next.data.toString();
	temp.next = null;
	return returnString;
    }

}

public class GenericLinkedList {

    public static void main(String[] args) {
        SList<Integer> list = new SList<Integer>();
        SListIterator<Integer> it = list.iterator();

        System.out.println(list);

	System.out.println("Adding 1");
        it.add(1);
        System.out.println(list);

	System.out.println("Adding 2");
        it.add(2);
        System.out.println(list);

	System.out.println("Adding 3");
	it.add(3);
        System.out.println(list);

	System.out.println(it.delete());
        System.out.println(list);

        System.out.println(it.delete());
        System.out.println(list);

	System.out.println("Adding 500");
	it.add(500);
        System.out.println(list);

	System.out.println(it.delete());
        System.out.println(list);

	System.out.println(it.delete());
        System.out.println(list);

        System.out.println(it.delete());
        System.out.println(list);

    }
}
