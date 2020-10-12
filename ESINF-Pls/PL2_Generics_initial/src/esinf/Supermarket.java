/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esinf;

import java.io.File;
import java.io.FileReader;
import java.time.LocalDate;
import java.util.*;

/**
 *
 * @author DEI-ISEP
 */
public class Supermarket {
    Map <Invoice, Set<Product>> m;
    
    Supermarket() {
        m = new HashMap<>();
    }
    
    // Reads invoices from a list of String
    void getInvoices(List <String> l) throws Exception {
        
        //throw new UnsupportedOperationException("Not supported yet.");
        Invoice i;
        Product p;
        Set<Product> productSet = null;

        for (String s: l){
            String lp[] = s.split(",");
            switch (lp[0]){
                case "I":
                    i = new Invoice(lp[1],lp[2]);
                    productSet = new TreeSet<>();
                    m.put(i,productSet);
                    break;
                case "P":
                    p = new Product(lp[1], Integer.parseInt(lp[2]),Long.parseLong(lp[3]));
                    productSet.add(p);
                    break;
                default: throw new Exception("ERRO");
            }
        }
    }   
    // returns a set in which each number is the number of products in the r
    // invoice 
    Map<Invoice, Integer> numberOfProductsPerInvoice() {
        Map<Invoice, Integer> r = new HashMap<>();

        for (Invoice i: m.keySet()){
            r.put(i, m.get(i).size());
        }

        return r;


    }

    // returns a Set of invoices in which each date is >d1 and <d2
    Set <Invoice> betweenDates(LocalDate d1, LocalDate d2) {
        Set<Invoice> invoiceSet = new HashSet<>();
        //throw new UnsupportedOperationException("Not supported yet.");
        for (Invoice i: m.keySet()){
            if (i.getDate().isAfter(d1) && i.getDate().isBefore(d2))
                invoiceSet.add(i);
        }
        return invoiceSet;
    }
    
    // returns the sum of the price of the product in all the invoices
    long totalOfProduct(String productId) {
        long sum = 0;
        //throw new UnsupportedOperationException("Not supported yet.");
        for(Invoice i: m.keySet()){
            for (Product p: m.get(i)){
                if (p.getIdentification().equals(productId))
                    sum += p.getPrice() * p.getQuantity();
            }
        }
        return sum;
    }
    
    // converts a map of invoices and troducts to a map which key is a product 
    // identification and the values are a set of the invoice references 
    // in which it appearss
    Map <String, Set<Invoice>> convertInvoices() {

        Map<String, Set<Invoice>> productSetMap = new HashMap<>();
        Set<Invoice> si;
        //throw new UnsupportedOperationException("Not supported yet.");
        for (Invoice i: m.keySet()){
            for (Product p: m.get(i)){
                String s =  p.getIdentification();
                if (!productSetMap.containsKey(s)){
                    si = new TreeSet<>();
                    productSetMap.put(s,si);
                }else {
                    si = productSetMap.get(s);
                }
                si.add(i);
            }

        }
        return productSetMap;

    }
}
