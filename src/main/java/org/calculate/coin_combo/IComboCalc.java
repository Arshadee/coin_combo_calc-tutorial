package org.calculate.coin_combo;
import java.util.List;

/**
 * A common interface to standardize our possible different
 * Combination calculation imlemenations using different algorithms
 * 
 */
public interface IComboCalc{
  
    public String getAlgorithmName();
    
  	public List<String> getChangeCombination(Integer[] den, int total);
  	
  	public default void displayResults(List<String> combinations) {
 		combinations.forEach((x)-> System.out.println(x));
 	}
  	
}