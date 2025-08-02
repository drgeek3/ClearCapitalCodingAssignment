package javacoderefactor;

//This is the working portion for assignment 3.

import static javacoderefactor.NameUtility.convertNameToInitials;

public class Main {
    public static void main(String[] args) {
        System.out.print("Enter name: ");
        String name = System.console().readLine();
        System.out.println(name + " -> " + convertNameToInitials(name));
    }
}
