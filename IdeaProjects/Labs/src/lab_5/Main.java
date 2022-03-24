package lab_5;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws Exception {
        Stack<Integer> stack1 = getValue();
        Stack<Integer> stack2 = getValue();


        System.out.println("Stack1 : " + stack1);
        System.out.println("Stack2 : " + stack2);

        if(stack1.size() == stack2.size()){
            Stack<Integer> temp = stack1;
            stack1 = stack2;
            stack2 = temp;
        } else {
            throw new NotEqualStackException("Stivele nu sunt egale");
        }



        System.out.println("Stack1 : " + stack1);
        System.out.println("Stack2 : " + stack2);

    }



    public static Stack<Integer> getValue(){
        Stack<Integer> stack = new Stack<Integer>();

        Scanner scanner = new Scanner(System.in);

        System.out.println("Lungimea stivei : ");
        int le = 0;
        //int le = scanner.nextInt();
        try{
            le = scanner.nextInt();
        } catch (InputMismatchException e){
            le = 5;
            System.out.println("Lungimea este automat setată la 5");
            scanner.nextLine();
        }
        int val, i = 0;
        while(i < le){
            try{
                val = Integer.parseInt(scanner.next());
                stack.push(val);
                i++;
            } catch (NumberFormatException e){
                System.out.println("Valoare nu este integer");
            }
        }

        return stack;
    }
}
