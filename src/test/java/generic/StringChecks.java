package generic;

import java.util.HashSet;
import java.util.Set;

public class StringChecks {

    public void charCount(String checkString){
        //Identify unique characters list
        Set<Character> charRef = new HashSet<>();
        int count = 0;
        for (int i = 0; i < checkString.length(); i++) {
            charRef.add(checkString.charAt(i));
        }

        //Get the count if occurrence of each character in the given string
        for (char c:charRef) {
            for(int i=0; i<checkString.length(); i++)
            {
                if(checkString.charAt(i) == c)
                    count++;
            }
            System.out.println(c+" occurs "+count+" times in the given string.");
            count = 0;
        }
    }

    public void reverseAllStrings(String inputString){
        //Separate individual words by space
        String[] individualWords = inputString.split(" ");
        StringBuffer reversedInputString = new StringBuffer();

        //reverse each word and add to new string buffer
        for (String individualWord : individualWords) {
            reversedInputString.append(reversedString(individualWord));
            reversedInputString.append(" ");
        }
        System.out.println(reversedInputString);
    }

    public String reversedString (String stringToReverse){
        String revString = "";
        for(int i = stringToReverse.length() - 1; i >= 0; i--) {
            revString = revString + stringToReverse.charAt(i);
        }
        return revString;
    }
}
