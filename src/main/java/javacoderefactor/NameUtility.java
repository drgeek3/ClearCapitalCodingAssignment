package javacoderefactor;

//This is assignment three.

public class NameUtility {
    /**
     * <code>convertNameToInitials</code> takes a string of any length and will return the first character of
     * each word separated by spaces and separate those characters with a period.<p>
     * <code>String: David Taylor -> Returns: D.T.<br/>
     * String: James T Kirk -> Returns: J.T.K.<br/>
     * String: JohnSmith -> Returns: J.<br/></code>
     * @param name string of any length with any number of spaces
     * @return string of initials representing the first letter of each word separated by a period.
     */
    public static String convertNameToInitials(String name){
        StringBuilder initials = new StringBuilder(); //StringBuilder to concatenate the strings together
        if(name != null) { //check for null values since that will crash everything
            name = name.replaceAll("\\s+"," ").trim();  //replace any multiple spaces with a single space and then trim any leading or trailing spaces.
            if (!name.isEmpty()) { //make sure the field is not completely empty after clearing the spaces
                String[] names = name.split("\\s"); //split the string on the spaces to make individual words we can draw the first letters from
                for (String namePart : names) initials.append(namePart.charAt(0)).append("."); //single line for loop to get the characters at 0
            }
        }
        return initials.toString(); //return the completed StringBuilder and convert to String.
    }
}
