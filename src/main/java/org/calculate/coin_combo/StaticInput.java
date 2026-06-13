package org.calculate.coin_combo;
import java.util.ArrayList;
import java.util.List;

/**
 * StaticInput class to run a test using hard coded input variables
 */
public class StaticInput{
    
    /**
     * Run method
     * Uses hard coded inputs for total amount and denominations array
     */

    private void displayDenominations(Integer[] denominations){

        System.out.print("Denominations: [ ");
        for(Integer denomination:denominations){
            System.out.print(denomination+" ");
        }
        System.out.print("]");
        System.out.println();
    }

    private void displayInfo(Integer[] denominations,int total,List<String> combinations){
        System.out.println("Total : "+total);
        displayDenominations(denominations);
        System.out.println("Total Number of combinations : "+combinations.size());
    }

    public void run(){
        
        IComboCalc coinCombo = new ComboRecursionDfsCalc();
		Integer[] den = {1,2,3,5,29,30,31};
		int total = 30;
		List<String> combinations = coinCombo.getChangeCombination(den, total);
        displayInfo(den,total,combinations);
		coinCombo.displayResults(combinations);
        displayInfo(den,total,combinations);
    }
}