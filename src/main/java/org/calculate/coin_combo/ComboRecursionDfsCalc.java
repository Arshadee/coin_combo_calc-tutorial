package org.calculate.coin_combo;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Change Combination generator for any amount and denomination
 * Recursion Debth First Search Implementation
 * 
 */
public class ComboRecursionDfsCalc implements IComboCalc{
    
    private static final String ALGORITHM_NAME = "Recursive Debth First Search";
    
     @Override
    public String getAlgorithmName(){
        return ALGORITHM_NAME;
    }
    
     /**
	*  Initializer method to initial params for cleaner client call
	*  The client therefor only specifies parameter of interest i.e.
	*  the denominations and the total amount
	* 
	*  @param den   List of all given denominations used in combinations
	*  @param total A given total amount each combination should add up to.
	*  @return      A List of valid combinations (each add up to the given
	*               Total)      
	*/
	 @Override
	public List<String> getChangeCombination(Integer[] den, int total){
		return change(0,"",total,den,new ArrayList<>());
	}

  /**
   * DFS Method to find all possible denomination combinations that sum up to 
   * the total
   * 
   * @param index  This is the index of the current element in the DFS search      
   * @param combo  Combination traversed at the current element in the DFS 
   *               search 
   * @param rem    The remaining amount after deducting current combination from
   *               the given amount
   * @param den    List of all given denominations used in combinations 
   * @param combos Stores a List of valid cominations (each adding up to given 
   *               Total) 
   * @return       A List of valid combinations (each add up to the given Total)
   */
	private static List<String> change(int index, String combo, int rem, Integer[] den, List<String> combos) {
		if (rem == 0) {
			combos.add(combo.trim());
		}

		for (int i = index; i < den.length && rem > 0; i++) {
			 change(i, combo + den[i]+" ", rem - den[i],den,combos);
		}
		return combos;
	}
	
// 	/**
// 	*  Simple method to display results in a readable format.
// 	* 
// 	*  @param List of valid combinations (results) to be dislayed
// 	*/
// 	public static void displayResults(List<String> combinations) {
// 		combinations.forEach((x)-> System.out.println(x));
// 	}
	
}
	