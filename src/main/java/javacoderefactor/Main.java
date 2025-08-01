package javacoderefactor;

//Assignment 3 is here.

public class Main {
    public static void main(String[] args) {
        System.out.print("Enter name: ");
        String name = System.console().readLine();
        System.out.println(name + " -> " + convertNameToInitials(name));
    }

    public static String convertNameToInitials(String name){
        String initials = name.charAt(0) + ".";

        for (int i = 0; i < name.length(); i++){
            if (name.substring(i,i+1).equals(" ")){
                initials = initials + name.charAt(i+1) + ".";
            }
        }

        return initials;
    }
}