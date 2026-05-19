/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package eventdiskonan;

/**
 *
 * @author farhannivta
 */
public class NoDiskon implements Diskon {

    @Override
    public double calculateDiscount(double totalAmount) {
        return 0;
    }

    @Override
    public String getDiscountName() {
        return "No Discount";
    }
    
}
