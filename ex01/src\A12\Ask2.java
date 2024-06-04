package A12;

import java.util.Arrays;
import java.util.Scanner;
import java.text.Normalizer;
import java.text.Normalizer.Form;
import java.util.Scanner;


class  PalindromikesFraseis{

    public static void main(String[] args){

        System.out.println("Please enter a phrase: ");
        Scanner inpet= new Scanner(System.in);
        String phrasee= inpet.nextLine();

        boolean baboulean;
        baboulean=isPalindromikiFrash(phrasee.toLowerCase());

        System.out.println(baboulean);

    }

    static boolean isPalindromikiFrash(String s){


        String neo_stringo= normaliseTheStringo(s);

        char[] efthi = new char[neo_stringo.length()];
        char[] anapodo=new char[neo_stringo.length()];

        //System.out.println(neo_stringo);
        neo_stringo.getChars(0,neo_stringo.length(),efthi,0);


        for(int i=0; i< efthi.length  ; i++){
            anapodo[i] = efthi[ efthi.length-i -1 ];

        }
        int counterr=0;
        for(int j=0; j < efthi.length ; j++){
            if(efthi[j]==anapodo[j]){
                counterr++;
            }
        }

        // printEFkaiANAp(efthi);
        // System.out.println("########");
        // printEFkaiANAp(anapodo);

        if(counterr==efthi.length) return true;
        else return false;
    }

    static String normaliseTheStringo( String phrase ) {


        String new_strinkkk = phrase.toLowerCase();
        new_strinkkk=new_strinkkk.replace(" ","");


        // System.out.println(Normalizer.normalize(phrase,Form.NFD).replaceAll("\\p{InCombiningDiacriticalMarks}+", ""));
        new_strinkkk=new_strinkkk.replaceAll("[^a-zA-Z]","");

        // System.out.println(new_strinkkk);
        return new_strinkkk;

    }

    static void printEFkaiANAp(char[] matr){

        for(int i=0; i<matr.length; i++){
            System.out.println(Arrays.toString(matr));
        }
    }
}