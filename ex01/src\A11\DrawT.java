package A11;
//import java.util.logging.SocketHandler;
import java.sql.Array;
import java.util.Scanner;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.*;


import java.io.*;
import java.sql.SQLOutput;
import java.util.Arrays;
import javax.sound.midi.Soundbank;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

public class DrawT {

    //#############################################################################################
    public static void main(String[] args) {




        String lenn;
        Scanner in = new Scanner(System.in);



        int lsize = Integer.parseInt(args[1]);


        lenCheck(lsize);

        // creating an array that contains the positions of * of T
        char matrr[][] = new char[lsize][lsize];
        matrrMaking(matrr);



        String[] nextArgs= new String[2];
        //args[0]=modee;



        // checking the selected mode

        switch (args[0]) {
            case "c":
                // method call to print a T on cmd
                printCmdMatrr(matrr);

                //preparing to call main again with different length ( A1 vi )
                lenn=nextLength();
                nextArgs[0]=args[0];
                nextArgs[1]=lenn;

                main(nextArgs);     //we repeat this action till incorrect length
                break;

            case "w":
                // method to call JOptionPane
                printExitWnd(matrr, lsize);

                //preparing to call main again with different length ( A1 vi )
                String inputk =JOptionPane.showInputDialog("Give me a number ", 5);
                nextArgs[0]=args[0];
                nextArgs[1]=inputk;
                main(nextArgs);
                break;

            case "f":
                //method to write an html file
                printInWriterr(lsize);

                //preparing to call main again with different length ( A1 vi )
                lenn=nextLength();
                nextArgs[0]=args[0];
                nextArgs[1]=lenn;
                main(nextArgs);
                break;

            case "g":
                // method to create a wonderous T in GUI
                drawΕgraphics(lsize);

                //preparing to call main again with different length ( A1 vi )
                lenn=nextLength();
                nextArgs[0]=args[0];
                nextArgs[1]=lenn;
                main(nextArgs);
                break;

            default:
                System.out.println("Incorrect mode.Please enter one of these modes.");
                System.exit(2);
        }











        // System.out.println("HELLO MY NIBBAS\n");

    }

    // Method for assessing the length of the next T
    public static String nextLength(){

        Scanner inp= new Scanner(System.in);

        System.out.println("Please enter a new lenght for the T:");
        String str_lsize= inp.nextLine();

        int n_lsize=Integer.parseInt(str_lsize);
        lenCheck(n_lsize);
        return str_lsize;
    }
    // method that checks if length is within bounds
    public static void lenCheck(int lsize){
        if(lsize<5 || lsize>20 ){
            System.out.println("Incorrect Length of letter T. Please enter a number between 5 and 20.");
            System.exit(1);
        }
    }
    //#############################################################################################
    /*this is a method for GUI*/
    static void drawΕgraphics(int L) {
        Frame f = new Frame("Ζωγραφίζοντας το T") {
            public void paint (Graphics g) {
                Graphics2D g2 = (Graphics2D) g;

                // συμπληρώστε
                CubicCurve2D c1 = new CubicCurve2D.Double();
                QuadCurve2D c2 = new QuadCurve2D.Float();
                c1.setCurve(50,100, 70,90,170,110,200,100);

                c2.setCurve(125,100,135,250,110,300);
                g2.draw(c1);
                g2.draw(c2);
            }
        };
        f.setSize(400,400);
        f.setVisible(true);
    }
    public static void printInWriterr(int lsize){

        PrintWriter htmlFile;
        try {
            htmlFile= new PrintWriter("T.html", "UTF-8");
            htmlFile.println("<!DOCTYPE html>");
            htmlFile.println("<html>");
            htmlFile.println("<head>");
            htmlFile.println("<meta http-equiv=\"content-type\" content=\"text/html;charset=utf-8\"/>\n");
            htmlFile.println("</head>");
            htmlFile.print("<body><font size=\"" );
            htmlFile.print(lsize);
            htmlFile.print("\">T with font size = ");
            htmlFile.print(lsize);
            htmlFile.println("</font></body>");
            htmlFile.println("</html>");
            htmlFile.close();

        } catch (Exception e) {
            System.out.println("Πρόβλημα: "+e);
        }

    }



    /* this is a function that prints our T in a JOptionPane*/
    public static void printExitWnd(char[][] matrr, int lsize){

        String[] strMat= new String[lsize];
        Arrays.fill(strMat,"");



        for(int i=0; i<lsize; i++){
            for(int j =0; j<lsize; j++){
                strMat[i]=strMat[i]+matrr[i][j];
            }
            strMat[i].replace("/0","");
        }

        System.out.println(Arrays.toString(strMat));

        UIManager.put("OptionPane.messageFont", new Font("Lucida Console", Font.BOLD, 14));
        StringBuilder builder = new StringBuilder(strMat.length);

        for (int i=0;i<strMat.length; builder.append(strMat[i++])){
            builder.append("\n");
        }
        JOptionPane.showMessageDialog(null, builder.toString(), "Printing results", JOptionPane.INFORMATION_MESSAGE);
/*
        UIManager.put("OptionPane.messageFont", new Font("Lucida Console", Font.BOLD, 14));
        JOptionPane.showMessageDialog(null,
                matrr[0][1],
                "Παράθυρο Εξόδου",
                JOptionPane.INFORMATION_MESSAGE);
*/
    }

    /*this function  stores the exact positions of '*' */
    public static void matrrMaking(char[][] matrr){

        int lsize=matrr.length;
        for( int i=0; i<lsize; i++){

            //if lsize is EVEn
            if(lsize%2==0){

                for(int j=0; j<lsize; j++){



                    if( j==(lsize/2) || j==(lsize/2)-1){
                        matrr[i][j]='*';
                    }
                    else{
                        matrr[i][j]=' ';
                    }
                }
            }
            //If lsize is ODD
            if(lsize%2!=0){

                for( int j=0; j<lsize; j++){


                    if( j==(lsize/2)){
                        matrr[i][j]='*';
                    }
                    else{
                        matrr[i][j]=' ';
                    }
                }
            }
        }
        for(int k=0; k<lsize; k++){
            matrr[0][k]='*';
        }

    }

    /*this function prints a T on the cmd window */
    public static void printCmdMatrr(char[][] matrron){
        for(int i=0;i<matrron.length;i++){
            for(int j=0; j<matrron.length; j++){
                System.out.print(matrron[i][j]);
            }
            System.out.println();
        }
    }



}

