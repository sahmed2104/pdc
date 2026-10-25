package question2;
import java.util.Scanner;
public class packetsymmetry {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.println("enter packet payload");
        String payload=sc.nextLine();

        transactionstack stack= new transactionstack();
        requestqueue queue= new requestqueue();

        for(int i=0;i<payload.length(); i++){
            char c=payload.charAt(i);

            stack.push(c);
            queue.enqueue(c);
        }
        boolean palindrome=true;
        while (!stack.isempty() && !queue.isempty()) {
            char stackchar=stack.pop();
            char queuechar=queue.dequeue();

            if(stackchar!=queuechar){
                palindrome=false;
                break;
            }
        }
        System.out.println("packet verification log==");
        if(palindrome){
            System.out.println("packet is symmetrical");
            System.out.println("verification passed");
        }
        else{
            System.out.println("packet not symmetrical ");
            System.out.println("verfication failed");
        }
        sc.close();
    }
}
