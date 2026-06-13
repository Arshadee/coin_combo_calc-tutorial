package org.calculate.coin_combo;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * UserInput class to run a test using user selected input variables
 * from Command line arguments
 */
public class UserInput{
    
    static final String ALGORITHM_RECURSIVE = "REC";
    static final String ALGORITHM_ITERATIVE = "ITR";

    private void displayDenominations(Integer[] denominations){

        System.out.print("Denominations: [ ");
        for(Integer denomination:denominations){
            System.out.print(denomination+" ");
        }
        System.out.print("]");
        System.out.println();
    }

    private void displayInfo(
        IComboCalc coinCombo,
        List<String> combinations,
        String endParam,
        int total,
        Integer[] denominations) {

        System.out.println("Total : "+total);
        displayDenominations(denominations);
        System.out.println("Algorithm Type : "+coinCombo.getAlgorithmName()+" Total Number of combinations "+combinations.size());
        System.out.println("Algorithm key input by user "+endParam);
    }
    
    /**
     * run(String[] args) method
     * Uses User inputs from command line args
     * For total amount and denominations array
     * 
     * Format for user input (args[])
     * total denomination1 denomination2 denomination3 ... denominationN
     * total denomination1 denomination2 denomination3 ... denominationN Algorithm
     * 
     * @param args   String Array of user inputs includes total and denominations
     *
     */ 
    public void run(String[] args){
        
        if(args==null || args.length==0){
		    System.out.println("Usage: Main total denomination1 denomination2 denomination3 ... denominationN");
		    System.out.println("or Main total denomination1 denomination2 denomination3 ... denominationN (Algorithm Type) ITR or REC");
		    return;
		}
		
		IComboCalc coinCombo = new ComboRecursionDfsCalc();
		String endParam = args[args.length-1];
		
		if(!isNumeric(endParam)){
		    args = Arrays.copyOfRange(args, 0, args.length-1);
		} 
		
		if(endParam.toUpperCase().equals(ALGORITHM_ITERATIVE)){
		    coinCombo = new ComboIteratorDfsCalc();
		}
	
		
		Integer[] den = getDenominationsfromInput(args);
		int total = Integer.parseInt(args[0]);
		List<String> combinations = coinCombo.getChangeCombination(den, total);
        displayInfo(coinCombo,combinations,endParam,total,den);
		coinCombo.displayResults(combinations);
        displayInfo(coinCombo,combinations,endParam,total,den);
    }
    

  /**
   * getDenominationsfromInput(String[] args) method
   * Extracts denomination list from String[] args from users command line input
   *
   * @param args   Array of user inputs includes total and denominations
   * @return       An Integer List of denomination values 
   */ 
   private static Integer[] getDenominationsfromInput(String[] args){
       Integer[] den = new Integer[args.length-1];
       for(int i=1 ; i<args.length;i++){
           den[i-1] = Integer.parseInt(args[i]);
       }
       return den;
   }
   
   private static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            double d = Double.parseDouble(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }
    
}