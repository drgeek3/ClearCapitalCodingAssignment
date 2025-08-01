package javacoderefactor;

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
        String initials = "";
        if(name != null) {
            name = name.replaceAll("\\s+"," ").trim();
            if (!name.isEmpty()) {
                String[] names = name.split("\\s");
                for (int i = 0; i < names.length; i++){
                    initials = initials + names[i].charAt(0) + ".";
                }
            }
        }
        return initials;
    }
}
