package tests;

import generic.StringChecks;
import org.junit.jupiter.api.Test;

public class StringTest {

    StringChecks stringChecks = new StringChecks();

    @Test
    public void getCharCount() {
        System.out.println("Count characters");
        stringChecks.charCount("abcdABCDabcd");
        stringChecks.charCount("ABCDabcd");
        stringChecks.charCount("asbdhjabfaksnakjsfkjasn");
    }

    @Test
    public void revString(){
        System.out.println("Reverse individual words");
        stringChecks.reverseAllStrings("Rajeshwaran is working in EPAM");
    }

    //Get Call <>
}


