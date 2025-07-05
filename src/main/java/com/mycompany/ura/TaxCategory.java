/*
 * Base class for different taxpayer categories in EFRIS
 * Demonstrates Inheritance and Polymorphism for VAT calculations
 */

package com.mycompany.ura;

/**
 * Abstract base class for different taxpayer categories
 * Implements polymorphism for VAT calculation methods
 */
public abstract class TaxCategory {
    protected String taxpayerTIN;
    protected String businessName;
    protected double baseVATRate;
    
    /**
     * Constructor for TaxCategory
     * @param taxpayerTIN Tax Identification Number
     * @param businessName Name of the business
     */
    public TaxCategory(String taxpayerTIN, String businessName) {
        this.taxpayerTIN = taxpayerTIN;
        this.businessName = businessName;
        this.baseVATRate = 0.18; // Default 18% VAT rate
    }
    
    /**
     * Abstract method for VAT calculation - to be overridden by subclasses
     * Demonstrates polymorphism - different implementations for different categories
     * @param amount Transaction amount
     * @return Calculated VAT amount
     */
    public abstract double calculateVAT(double amount);
    
    /**
     * Common method to get taxpayer information
     * @return Taxpayer TIN
     */
    public String getTaxpayerTIN() {
        return taxpayerTIN;
    }
    
    /**
     * Get business name
     * @return Business name
     */
    public String getBusinessName() {
        return businessName;
    }
    
    /**
     * Get base VAT rate
     * @return Base VAT rate
     */
    public double getBaseVATRate() {
        return baseVATRate;
    }
    
    /**
     * Common method to validate transaction amount
     * @param amount Transaction amount to validate
     * @return true if amount is valid
     */
    protected boolean isValidAmount(double amount) {
        return amount > 0;
    }
    
    /**
     * Get category type - to be overridden by subclasses
     * @return Category type as string
     */
    public abstract String getCategoryType();
}