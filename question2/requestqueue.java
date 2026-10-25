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
}
