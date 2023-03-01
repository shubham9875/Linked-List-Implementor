import java.util.*;

class Node{
    Node next;
    int data;
}
class ll{
    Node head;
    Node tail;
    int size;

    
    void insertEnd(int x){
        Node n=new Node();
        n.data=x;
        n.next=null;
        if(size==0){
            head=tail=n;
        }
        else{
            tail.next=n;
            tail=n;
        }
        size++;
    }
    void insertBegin(int x){
        Node n=new Node();
        n.data=x;
        n.next=head;
        head=n;
        size++;
    }
    public void insertIdx(int idx,int x){
        if(idx==0){
            insertBegin(x);
        }
        else if(idx== size-1){
            insertEnd(x);
        }
        else {
            Node n = new Node();
            n.data = x;
            Node temp = head;
            for (int i = 0; i < idx - 1; i++) {
                temp = temp.next;
            }
            n.next = temp.next;
            temp.next = n;
            size++;
        }
    }
    public void printL(){
        Node curr=head;
        if(size==0) System.out.println("Nothing to display ");
        else {
            while (curr.next != null) {
                System.out.print(curr.data + "--> ");
                curr = curr.next;
            }
            System.out.print(curr.data);
            System.out.println();
        }
    }
    public void getSize(){
        System.out.println(size);
        System.out.println();
    }
     void search(int x){

        int c=0;
        Node curr=head;
        boolean flag=false;
        for(int i=0;i<size;i++){
            if(curr.data==x){
                System.out.println("Element found at " + c++);
                curr=curr.next;
                flag=true;
                break;
            }
            curr=curr.next;
            c++;
        }
        if(flag==false){
            System.out.println("Element not Found" );
        }

    }
    public void removeFirst(){
        head=head.next;
        size--;
    }
    public void removeLast(){

        Node temp=head;
        for(int i=0;i<size-2;i++){
            temp=temp.next;
        }
        tail=temp;
        tail.next=null;
        size--;
    }
    public void removeIdx(int idx){
        if(idx>=size){
            System.out.println("invalid Number ");
        }

       else  if(idx == 0){
            removeFirst();
        }else if (idx == size-1){
           removeLast();
        }else {
            Node temp = head;
            for (int i = 0; i < idx - 1; i++) {
                temp = temp.next;
            }
            temp.next = temp.next.next;
            size--;
        }
    }
    public void reverse(){
        if(size==0) System.out.println("List is empty");
        else {
            tail = head;
            Node curr = head;
            Node prev = null;

            while (curr != null) {
                Node nex = curr.next;
                curr.next = prev;
                prev = curr;
                curr = nex;
            }
            head=prev;
        }
    }
}

public class LinkedList {

    public static void main(String[] args) {
        ll list=new ll();
        Scanner sc=new Scanner(System.in);
        int input;
        do{
            System.out.println("------Create a Linked List-----");
            System.out.println("------1.Insert at End-------");
            System.out.println("------2.Insert at begining-------");
            System.out.println("------3.Insert at index-------");
            System.out.println("------4.Delete at End-------");
            System.out.println("------5.Delete at Beginning-------");
            System.out.println("------6.Delete at Index-------");
            System.out.println("------7.Search -------");
            System.out.println("------8.Size -------");
            System.out.println("------9.Print List -------");
            System.out.println("------10.Reverse the list -------");
            System.out.println("------11.Exit -------");
            input=sc.nextInt();
            if(input>11){
                System.out.println("invalid input");
                System.out.println();
            }
            switch(input){
                case 1:
                    System.out.println("Enter The element: ");
                    int elem=sc.nextInt();
                    list.insertEnd(elem);
                    break;
                case 2:
                    System.out.println("Enter The element: ");
                    int elem2=sc.nextInt();
                    list.insertBegin(elem2);
                    break;
                case 3:
                    System.out.println("Enter The Index: ");
                    int elem3=sc.nextInt();
                    System.out.println("Enter The element: ");
                    int elem4=sc.nextInt();
                    list.insertIdx(elem3,elem4);
                    break;
                case 4:
                    list.removeLast();
                    break;
                case 5:
                    list.removeFirst();
                    break;
                case 6:
                    System.out.println("Enter The element to remove: ");
                    int elem5=sc.nextInt();
                    list.removeIdx(elem5);
                    break;
                case 7:
                    System.out.println("Enter The element to search: ");
                    int elem6=sc.nextInt();
                    list.search(elem6);
                    break;
                case 8:
                    list.getSize();
                    break;
                case 9:
                    list.printL();
                    break;
                case 10:
                    list.reverse();
                    break;
                case 11:
                    break;
            }
        }while(input !=11);
        System.out.println("-----End------");
    }
}
