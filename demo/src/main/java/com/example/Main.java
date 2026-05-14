package com.example;

public class Main {
    public static void main(String[] args) {
        ComputerRecommender recommender = new ComputerRecommender();

            // Test cases
            int[] budgets = {-2000, 449, 450, 600, 601, 1500, 1501, -1};

            for (int budget : budgets) {
                try {
                    ComputerType type = recommender.getRecommendedComputerTypePerBudget(budget);
                    System.out.println("Budget: " + budget + " -> Recommended: " + type);
                } catch (InvalidBudgetException e) {
                    System.out.println("Budget: " + budget + " -> " + e.getMessage());
                }
            }
        }  
}   

