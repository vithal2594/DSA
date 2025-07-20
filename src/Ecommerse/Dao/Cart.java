package Prac.Ecommerse.Dao;

import java.util.Map;
import java.util.Set;

public class Cart {
    private static Product products;
        Set<String> vendors;
    
        public static void additems(String str){
            products.add(str);
    }
    
}

vendors
  vendorid
  vendorname

Product
 productid    car,bike
  vendorid
  productname

Cart
 cartid     1 car 
 productid   
 vendorid
 
//  composite
static
abstract
interface 