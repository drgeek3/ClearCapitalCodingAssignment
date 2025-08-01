package javacoderefactor;

//Assignment 3 is here.

import static javacoderefactor.NameUtility.convertNameToInitials;

public class Main {
    public static void main(String[] args) {
        System.out.print("Enter name: ");
        String name = System.console().readLine();
        System.out.println(name + " -> " + convertNameToInitials(name));
    }
}
