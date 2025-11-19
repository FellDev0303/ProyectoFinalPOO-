/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package Modelo;

import java.util.ArrayList;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author LENOVO
 */
public class FinanzasAPITest {
    
    @BeforeEach
    public void setUp() {
            
        FinanzasAPI.getGastos().clear();
        FinanzasAPI.getIngresos().clear();
    }

    @Test
    public void testRegistrarIngreso() {
        FinanzasAPI.registrarIngreso("Salario", 1200);

        assertEquals(1, FinanzasAPI.getIngresos().size());
        assertEquals("Salario", FinanzasAPI.getIngresos().get(0).getNombre());
        assertEquals(1200, FinanzasAPI.getIngresos().get(0).getValor());
    }

    @Test
    public void testRegistrarGastoHormiga() {
        FinanzasAPI.registrarGasto("Café", 5, true);

        assertEquals(1, FinanzasAPI.getGastos().size());
        assertEquals("Café", FinanzasAPI.getGastos().get(0).getNombre());
        assertEquals(5, FinanzasAPI.getGastos().get(0).getCosto());
        assertTrue(FinanzasAPI.getGastos().get(0) instanceof GastoHormiga);
    }

    @Test
    public void testRegistrarGastoNecesario() {
        FinanzasAPI.registrarGasto("Arriendo", 500, false);

        assertEquals(1, FinanzasAPI.getGastos().size());
        assertEquals("Arriendo", FinanzasAPI.getGastos().get(0).getNombre());
        assertEquals(500, FinanzasAPI.getGastos().get(0).getCosto());
        assertTrue(FinanzasAPI.getGastos().get(0) instanceof GastoNecesario);
    }

    @Test
    public void testActualizarIngreso() {
        FinanzasAPI.registrarIngreso("Pago viejo", 100);
        FinanzasAPI.actualizarIngreso(0, "Pago nuevo", 300);

        assertEquals("Pago nuevo", FinanzasAPI.getIngresos().get(0).getNombre());
        assertEquals(300, FinanzasAPI.getIngresos().get(0).getValor());
    }

    @Test
    public void testActualizarGasto() {
        FinanzasAPI.registrarGasto("Pan", 2, true);
        FinanzasAPI.actualizarGasto(0, "Pan integral", 3);

        assertEquals("Pan integral", FinanzasAPI.getGastos().get(0).getNombre());
        assertEquals(3, FinanzasAPI.getGastos().get(0).getCosto());
    }
}
