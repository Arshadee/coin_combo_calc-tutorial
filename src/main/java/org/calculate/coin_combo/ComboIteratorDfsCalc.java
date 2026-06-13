package org.calculate.coin_combo;
import java.util.List;
import java.util.ArrayList;
import java.util.Deque;
import java.util.ArrayDeque;

/**
 * Change Combination generator for any amount and denomination
 * Iterative Debth First Search Implementation
 * 
 */
public class ComboIteratorDfsCalc implements IComboCalc{  
    
    private static final String ALGOTITHM_NAME = "Iterative Debth First Search";
    
   /*
    * Retrieves the name of the algorithm used 
    */
    @Override
    public String getAlgorithmName(){
        return ALGOTITHM_NAME;
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
		return change(total, den, new ArrayList<>());
	}
	
    private List<String> change(int rem, Integer[] den, List<String> combos){
 
        State rootState = new State();
        rootState.rem = rem;
        rootState.index=0;
        Deque<State> stack = new ArrayDeque<>();
        stack.push(rootState);
      
        while(!stack.isEmpty()) {
    
            State currState = stack.pop();
    
            if (currState.rem == 0) {
                combos.add(currState.combo);
            }
        
            for (int i = den.length - 1; i >= currState.index && currState.rem > 0; i--) {
              State childState = new State();
              childState.index = i;
              childState.combo = currState.combo + " " + den[i];
              childState.rem = currState.rem - den[i];
              childState.denomination = den[i];
              stack.push(childState);
          }
      }
      return combos;
    }
    
    private class State{
        
        int rem;
        String combo;
        int index;
        int denomination;
        
        public State(){
            this.combo="";
        }
    }
}    