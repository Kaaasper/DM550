import java.util.Arrays;
import java.util.Scanner;

public class ScrambleIt{

    /**
     * Throughout this program method from the file "section5" are used. 
     * This file contains methods to use on strings, and it felt stupid to re-implement these here, when we could just use them again from the file
     */


    public static void main(String[] args){

        // System.out.println(removeVowels("Hello World"));
        operationController();

    }

    public static void operationController(){


        Scanner input = new Scanner(System.in);
        int mode = 1;

        int spaces;
        int blocks;
        int shift;
        int cont;
        int newText;
        boolean reUse = true;

        String text;
        System.out.println("Input text to be scrambled:");
        text = input.nextLine();

        do {

            if (!reUse){

                System.out.println("Input text to be scrambled:");
                text = input.nextLine();
            }

            showOptions();

            mode = input.nextInt();

            switch (mode){

                case (1):
                    text = removeVowels(text);
                    System.out.println("Resulting output:\n"+text);
                    break;

                case (2):
                    System.out.println("Enter the length between the spaces");
                    spaces = input.nextInt();
                    text = section5.respace(text, spaces);
                    System.out.println("Resulting output:\n"+text);
                    break;
                
                case (3):
                    text = section5.reverseWords(text);
                    System.out.println("Resulting output:\n"+text);
                    break;

                case (4):
                    System.out.println("Enter block length:");
                    blocks = input.nextInt();
                    text = reverseBlocks(text, blocks);
                    System.out.println("Resulting output:\n"+text);
                    break;

                case (5):
                    System.out.println("Enter amount to be shifted:");
                    shift = input.nextInt();
                    text = section5.shiftWords(text, shift);
                    System.out.println("Resulting output:\n"+text);
                    break;
                
                case (0):
                    input.close();
                    System.exit(0);
                    break;
            }

            askContinue();

            cont = input.nextInt();

            switch (cont){
                
                case (1):
                    askNewText();
                    newText = input.nextInt();

                    switch (newText){

                        case (1):
                            reUse = true;
                            break;

                        case (2):
                            reUse = false;
                            break;

                    }


                    break;

                case (2):
                    mode = 0;
                    break;
                
                default:
                    break;

            }


            
        } while (mode != 0);

        input.close();



    }

    public static void showOptions(){

        System.out.println("Choose a method by writing the corresponding number, and pressing \"enter\":");
        System.out.println("-----------------------------------------------------------------------------");
        System.out.println("1. Remove all vowels from words, except those words that consists of only vowels");
        System.out.println("2. Remove all space from the text and add a new space after every n-th character");
        System.out.println("3. Reverse every induvidual word");
        System.out.println("4. Divide the test into blocks of length m, and reverse each block individually");
        System.out.println("5. Shift each individual word in the text by a given number of characters");
        System.out.println("0. Exit");

    }

    public static void askContinue(){

        System.out.println("Do you want to continue?");
        System.out.println("1. Yes");
        System.out.println("2. No");
    }

    public static void askNewText(){

        System.out.println("Do you wish to continue using the same scrambled text, or input something new instead");
        System.out.println("1. Use the same");
        System.out.println("2. Input new");

    }

    /**
     * Remove all vowels from a string, unless it only consists of vowels
     */
    public static String removeVowels(String s){

        String[] words = section5.split(' ', s);
        String res = "";

        for(String w: words){
            if (!checkForVowels(w)){
                w = section5.removeVowels(w);
            }

            res = res + w + ' ';
        }

    
        return res;
    }
    
    /**
     * Check is a string consists of only vowels, returns true if it does
     */
    public static boolean checkForVowels(String s){
        int i = 0;
        String vowels = "aeiouyAEIOUY";

        boolean onlyVowels = true;

        while (i < s.length() && onlyVowels){
            if (!section5.member(s.charAt(i), vowels)){
                onlyVowels = false;
            }
            i++;
        }

        return onlyVowels;

    }

    /**
     * Split a string 's' into blocks of size m, and then reverses them
     */
    public static String reverseBlocks(String s, int m){

        String[] blocks = splitStringIntoBlocks(s, m);
        String res = "";

        for (int i = 0; i < blocks.length; i++) {
            res = res + section5.reverse(blocks[i]);
        }

        return res;

    }

    /**
     * Splits a string 's' into blocks of size 'm'
     */
    public static String[] splitStringIntoBlocks(String s, int m){
        
        //Calcualte amount of blocks we are going to get
        int length = (int) Math.ceil( (double) s.length() / m);


        String[] blocks = new String[length];
        int i = 0;
        int b = 0;
        

        while (i < s.length()){

            //Choose a substring from the text given from an index i, to either 'm' characters more, or the end of the string
            blocks[b] = s.substring(i, Math.min(s.length(), i+m));
            b++;
            i = i + m;

        }
        
        return blocks;

    }   

}