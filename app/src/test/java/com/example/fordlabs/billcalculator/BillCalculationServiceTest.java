package com.example.fordlabs.billcalculator;

import com.example.fordlabs.billcalculator.model.Customer;
import com.example.fordlabs.billcalculator.model.Discount;
import com.example.fordlabs.billcalculator.model.Purchase;
import com.example.fordlabs.billcalculator.service.BillCalculationService;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class BillCalculationServiceTest {

    BillCalculationService calculationService = new BillCalculationService();


    @Test
    public void getBill_if() throws InvalidInputException{

        Customer customer = new Customer("FAIZAL","YES","GOLD");
        Discount discount = new Discount();
        Purchase purchase = new Purchase(customer,discount,1500.00,5000.00);
        assertEquals(5615,calculationService.calculate(purchase),0.01);

    }

   @Test
    public void getBill_ifCustIsPlatinumAndSrvcCost1000AndProductCost500_totalAmount() throws InvalidInputException{
        Customer customer = new Customer("BALAJI","YES","PLATINUM");
        Discount discount = new Discount();
        Purchase purchase = new Purchase(customer,discount,1000.00,500.00);
        assertEquals(1295,calculationService.calculate(purchase),0.01);
    }

    @Test
    public void getBill_ifCustIsDiamondAndSrvcCost700AndProductCost0_totalAmount() throws InvalidInputException{
        Customer customer = new Customer("DANIEL","YES","DIAMOND");
        Discount discount = new Discount();
        Purchase purchase = new Purchase(customer,discount,700.00,0.00);
        assertEquals(581,calculationService.calculate(purchase),0.01);

    }

    @Test
    public void getBill_ifCustIsNotMemberAndSrvcCost500AndProductCost0_totalAmount() throws InvalidInputException{
        Customer customer = new Customer("XYZ","NO"," ");
        Discount discount = new Discount();
        Purchase purchase = new Purchase(customer,discount,500.00,0.00);
        assertEquals(500,calculationService.calculate(purchase),0.01);
    }

    @Test
    public void getBill_ifCustIsAMemberAndSrvcCost0AndProductCost700_totalAmount() throws InvalidInputException{
        Customer customer = new Customer("ABC","YES","GOLD");
        Discount discount = new Discount();
        Purchase purchase = new Purchase(customer,discount,0.00,700.00);
        assertEquals(595,calculationService.calculate(purchase),0.01);

    }

    @Test
    public void getBill_ifCustIsAMemberAndSrvcCost900AndProductCost700_totalAmount() throws InvalidInputException{
        Customer customer = new Customer("ABC","YES","DIAMOND");
        Discount discount = new Discount();
        Purchase purchase = new Purchase(customer,discount,700.00,700.00);
        assertEquals(1176,calculationService.calculate(purchase),0.01);

    }

    @Test(expected = InvalidInputException.class)
    public void getBill_ifCustIsAMemberAndSrvcCostIsNullAndProductCost700_totalAmount() throws InvalidInputException{
        Customer customer = new Customer("ABC","YES","DIAMOND");
        Discount discount = new Discount();
        Purchase purchase = new Purchase(customer,discount,null,700.00);
        assertEquals(1176,calculationService.calculate(purchase),0.01);

    }

    @Test(expected = InvalidInputException.class)
    public void getBill_ifCustIsAMemberAndSrvcCostIs700AndProductCostIsNull_totalAmount() throws InvalidInputException{
        Customer customer = new Customer("ABC","YES","DIAMOND");
        Discount discount = new Discount();
        Purchase purchase = new Purchase(customer,discount,700.00,null);
        assertEquals(1176,calculationService.calculate(purchase),0.01);

    }

    
    @Test
    public void getProductDiscount_ifAmountNull_totalAmount(){
        Customer customer = new Customer("ABC","YES","DIAMOND");
        Discount discount = new Discount();
        Purchase purchase = new Purchase(customer,discount,700.00,1000.00);
        assertEquals(150,calculationService.getProductDiscount(purchase,1000.00),0.01);

    }





}