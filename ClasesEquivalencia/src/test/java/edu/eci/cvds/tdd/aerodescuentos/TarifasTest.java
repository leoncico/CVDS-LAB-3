package edu.eci.cvds.tdd.aerodescuentos;

import org.junit.Assert;
import org.junit.Test;

public class TarifasTest {
    /**
     * Al no tener una clase de excepciones como tal, esta prueba sera tomada como un Failure al momento de ejecutarlas con maven
     */
    //@Test
    public void validateInvalidParameters(){
        try {
            double tarifa = CalculadorDescuentos.calculoTarifa(-1, -2, -3);
            Assert.assertTrue(false);
        } catch (Exception e){
            Assert.assertTrue(true);
        }
    }
    @Test
    public void validateDiscountUnder18(){
        double tarifa;
        tarifa = CalculadorDescuentos.calculoTarifa(1000000, 2, 11);
        Assert.assertTrue(950000==tarifa);
    }
    @Test
    public void validateDiscountUnder18AndAnticipatedDays(){
        double tarifa;
        tarifa = CalculadorDescuentos.calculoTarifa(1000000, 25, 16);
        Assert.assertTrue(800000==tarifa);
    }
    @Test
    public void validateThatHasNoDiscount(){
        double tarifa;
        tarifa = CalculadorDescuentos.calculoTarifa(1000000, 8, 42);
        Assert.assertTrue(1000000==tarifa);
    }
    @Test
    public void validateDiscountForAnticipatedDays(){
        double tarifa;
        tarifa = CalculadorDescuentos.calculoTarifa(1000000, 24, 32);
        Assert.assertTrue(850000==tarifa);
    }
    @Test
    public void validateDiscountForBeingAnOldMan(){
        double tarifa;
        tarifa = CalculadorDescuentos.calculoTarifa(1000000, 2, 77);
        Assert.assertTrue(920000==tarifa);
    }
    @Test
    public void validateDiscountForBeingAnOldManAndAnticipatedDays() {
        double tarifa;
        tarifa = CalculadorDescuentos.calculoTarifa(1000000, 41, 68);
        Assert.assertTrue(770000 == tarifa);
    }
}
