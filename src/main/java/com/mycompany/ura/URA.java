/*
 * EFRIS System Implementation - URA Exam Solution
 * Demonstrates OOP principles in Electronic Fiscal Receipting and Invoicing System
 */

package com.mycompany.ura;

/**
 * Main class demonstrating EFRIS system implementation
 * @author Akram Mugerwa
 */
public class URA {

    public static void main(String[] args) {
        System.out.println("EFRIS System ");
        
        // Create array of different taxpayer categories
        TaxCategory[] taxpayers = {
            new Retailer("R001", "Retail Store Ltd"),
            new Wholesaler("W001", "Wholesale Distributors"),
            new Importer("I001", "Import Export Co"),
            new Manufacturer("M001", "Manufacturing Industries")
        };
        
        // Test transaction amounts
        double[] amounts = {100000, 250000, 500000, 750000};
        
        System.out.println("\nVAT Calculations for Different Taxpayer Categories:");
        System.out.println("=================================================");
        
        // Demonstrate polymorphism - different VAT calculations
        for (int i = 0; i < taxpayers.length; i++) {
            double vatAmount = taxpayers[i].calculateVAT(amounts[i]);
            System.out.printf("%s: Transaction Amount: UGX %.2f, VAT: UGX %.2f%n", 
                taxpayers[i].getClass().getSimpleName(), amounts[i], vatAmount);
            
            // Create transaction record to demonstrate encapsulation
            TransactionRecord record = new TransactionRecord(
                "TXN" + (i + 1), 
                taxpayers[i].getTaxpayerTIN(), 
                "INV" + (i + 1), 
                amounts[i], 
                System.currentTimeMillis()
            );
            
            System.out.println("Transaction Record: " + record.getTransactionSummary());
            System.out.println();
        }
    }
}
