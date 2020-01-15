/*
 * @author      Peter Jacobson
 * @class       CS 3 - 0112
 * @assingment  Calculate Monthly Payment (#01)
 * @lastUpdate  Jan 6, 2020
 */

package calculatemonthlypayment;
import java.util.*;
import java.lang.Math;
import java.text.DecimalFormat;
import javax.swing.JOptionPane;

public class CalculateMonthlyPayment {      
    /* Monthly Pay= [rate + rate / ([1+rate] ^months -1)] X principle
    Where rate of 6% means 6/1200 and
    Months means number of years x 12 */

    public static void main(String[] args) {
        double rate;       //rate = rate/1200
        double principle;  //mulitpler
        double term;       //Amount of years
        double months;     //amount of months
        double monthlyPay; 
        double totalPay;
        double interestExpense;
        Scanner input = new Scanner(System.in);     //The way to get user input
        
        //Input of rate, principle, and term
        System.out.println("Please input the rate...");
        rate = input.nextInt();
        System.out.println("Please input the principle...");
        principle = input.nextInt();
        System.out.println("Please input the amount of terms in years...");
        term = input.nextInt();
        
        months = term * 12;             //months are used for calcuations
        double newRate = rate / 1200;   //calc rate for more calculations, but we keep the inputed rate to putput later
        
        //main calculations
        monthlyPay = calculateMonthlyPay(newRate, principle, months);
        totalPay = monthlyPay * months;
        interestExpense = calculateInterestExpense(totalPay, principle);
        
        //Cleanup decimals 
        DecimalFormat numberFormat = new DecimalFormat("#.00");
       
        //Output in a popup
        String s = "Calculations Complete"
        + "\nPrinciple: $" + numberFormat.format(principle)
        + "\nRate: " + numberFormat.format(rate) 
        + "\nTerm in Years: " + numberFormat.format(term)
        + "\nMonths: " + numberFormat.format(months)
        + "\nMonthly Payment: $" + numberFormat.format(monthlyPay)
        + "\nTotal Payment: $" + numberFormat.format(totalPay)
        + "\nInterest Expense: $" + numberFormat.format(interestExpense);
        JOptionPane.showMessageDialog(null,s); //make a pop-up window 
        
        //End program
        return;
    }
    
    public static double calculateMonthlyPay(double rate, double principle ,double months) {
        double monthlyPay;
        //calculate the monthly pay
        //Monthly Pay = [rate + rate / ([1+rate] ^months -1)] X principle
        monthlyPay = ((rate + rate / (Math.pow((1+rate),months) - 1 ))) * principle; 
        return monthlyPay;
    }
    
    public static double calculateInterestExpense(double totalPay, double principal) {
        double interestExpense = 0;
        //calcuate the interest expense
        interestExpense = totalPay - principal;
        return interestExpense;
    }   
}
