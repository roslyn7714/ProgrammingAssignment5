/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binarysearchtreespellchecker;

import java.io.File;
import java.util.Scanner;

/**
 *
 * @author rcarnessali
 */
public class BinarySearchTree1<E> {

    public static int wordsFound;
    public static int wordsNotFound;
    public static long comparisonsFound;
    public static long comparisonsNotFound;



    public static void main(String[] args) throws Exception {
        //Initializing dictionary
       

    
        wordsFound = 0;
        wordsNotFound = 0;
        comparisonsFound = 0;
        comparisonsNotFound = 0;

        //initializing BinarySearchTree
     

        
        //Reading file into dictionary
        File dictionaryFile = new File("random_dictionary.txt");
        Scanner input = new Scanner(dictionaryFile);
                BinarySearchTree1 [] dictionary = new BinarySearchTree1[26];
 for (int i = 0; i < dictionary.length; i++)
            dictionary[i] = new BinarySearchTree1<String>();
        while (input.hasNext()) {
            String wordstr = input.next();
            wordstr = wordstr.toLowerCase();
dictionary [(int)wordstr.charAt(0) - 97].insert(wordstr) ; 


        }

        File oliver = new File("oliver.txt");
        input = new Scanner(oliver);

        while (input.hasNext()) {
            String line = input.next();
            line = line.toLowerCase(); //reads words as lowercase
//

            //need to do a substring for each word in a loop
            //got parsar information from http://stackoverflow.com/questions/15480811/for-loop-to-search-for-word-in-string
            for (String word : line.split(" ")) {
                if (!word.equals("-")) {
                    int character = word.charAt(0);

                    //runs this code if it starts with an odd character
                    if ((character - 97) > 25 || (character - 97) < 0) {
                        word = weirdWordFixer(word);
                        if (!word.equals("")) {
                            character = word.charAt(0);
                        }
                    }

                    if (!word.equals("") && dictionary[character - 97].search(word)) {
                        wordsFound++;
                        comparisonsFound += 1;
                    } else {
                        wordsNotFound++;
                        comparisonsNotFound += 1;
                    }
                }
            }
        }
        /*avgcompswordsfound =  compsFound / wordsFound // ( avg # of comps per word)
         avgcompswordsnotfound = compsNotFound / wordsNotFound //(avg # of comps per word not found)*/
        System.out.println("Words Found: " + wordsFound);
        System.out.println("Words Not Found: " + wordsNotFound);

        int totalWords = wordsFound + wordsNotFound;
        double avgComparisonsFound = comparisonsFound / ((double) totalWords);
        double avgComparisonsNotFound = comparisonsNotFound / ((double) totalWords);

        System.out.println("Average Comparisons Found: " + avgComparisonsFound);
        System.out.println("Average Comparisons Not Found: " + avgComparisonsNotFound);
    }

    //returns fixed word or a blank string if there were no letters in the string
    public static String weirdWordFixer(String weirdWord) {
        int length = weirdWord.length();
        for (int i = 1; i < length; i++) {
            int charValue = weirdWord.charAt(i);
            if ((charValue - 97) < 25 && (charValue - 97) > 0) {
                return weirdWord.substring(i, length);
            }
        }

        return "";
    }
}