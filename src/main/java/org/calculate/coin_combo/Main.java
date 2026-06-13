package org.calculate.coin_combo;

public class Main {

    /**
     * For Testing purpose
     * <p>
     * input args[]:
     * 1st element is the total amount (int total)
     * The rest of the elements of the args[] are the demonimations
     * (Integer den[])
     * <p>
     * Command line arguments format:
     * total denomination1 denomination2 denomination3 ... denominationN
     */
    public static void main(String[] args) {

//        StaticInput staticInput = new StaticInput();
//        staticInput.run();

        long startTime = System.currentTimeMillis();
        UserInput userInput = new UserInput();
        userInput.run(args);
        long endTime = System.currentTimeMillis();
        System.out.println("Duration " + (endTime - startTime) + "ms");


    }
}