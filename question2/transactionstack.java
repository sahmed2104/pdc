package question2;

public class transactionstack {
    private char[] elements;
    private int top;

    public transactionstack(){
        elements=new char[10];
        top=-1;
    }
    public void push(char c){
        if(top== elements.length -1){
            resize();
        }
        elements[++top]=c;
    }
    public char pop(){
        if(isempty()){
            throw new IllegalStateException("state empty");
        }
        char c=elements[top];
        elements[top--]=0;
        return c;
    }
    public char peek(){
        if(isempty()){
            throw new IllegalStateException("state empty");
        }
        return elements[top];
    }
    public boolean isempty(){
        return top==-1;
    }
    private void resize(){
        int newsize=elements.length*2;
        elements=java.util.Arrays.copyOf(elements, newsize);
    }
}
