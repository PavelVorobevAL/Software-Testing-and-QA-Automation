package com.example;

public class ComputerRecommender {
    /*

    Equivalence Partitioning

    maxBudget < 0 - Invalid
    maxBudget >= 0 and <450 - Valid
    maxBudget >= 450 and <= 600 - Valid
    maxBudget > 600 and <=1500  - Valid
    maxBudget > 1500 - Valid

     */
    public ComputerType getRecommendedComputerTypePerBudget(int maxBudget) throws InvalidBudgetException {

            if (maxBudget >= 0 && maxBudget < 450)
                return ComputerType.ENTRYLVLPC;

            else if (maxBudget >= 450 && maxBudget <= 600)
                return ComputerType.BDGTPC;

            else if (maxBudget > 600 && maxBudget <= 1500)
                return ComputerType.GAMINGPC;

            else if (maxBudget > 1500)
                return ComputerType.ENTHUSIASTPC;

            else
                throw new InvalidBudgetException("Invalid budget - " + maxBudget);
    }
}
    

