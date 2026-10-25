package question2;

public class requestqueue {
    private char[] elements;
    private int front;
    private int rear;
    private int size;
    public requestqueue(){
        elements=new char[10];
        front=0;
        rear=0;
        size=0;
    }
    public void enqueue(char c){
        if(size==elements.length){
            throw new IllegalStateException("queue full");
    }
    elements[rear]=c;
    rear=(rear+1)%elements.length;
    size++;
}
    public char dequeue(){
        if(isempty()){
            throw new IllegalStateException("queue empty");
        }
        char c=elements[front];
        front=(front+1)%elements.length;
        size--;
        return c;
    }
    public boolean isempty(){
        return size==0;
    }
}
