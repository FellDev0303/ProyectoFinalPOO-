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
public class FinanzasAPIIntegracionTest {

    @BeforeEach
    public void setUp() {
        FinanzasAPI.getGastos().clear();
        FinanzasAPI.getIngresos().clear();
    }

    @Test
    public void flujoCompletoIngresosYGastos() {
       
        FinanzasAPI.registrarIngreso("Salario", 1500);
        FinanzasAPI.registrarIngreso("Freelance", 300);
        
        FinanzasAPI.registrarGasto("Comida", 200, false);
        FinanzasAPI.registrarGasto("Uber", 30, true);

        assertEquals(2, FinanzasAPI.getIngresos().size());
        assertEquals(2, FinanzasAPI.getGastos().size());

        
        FinanzasAPI.actualizarIngreso(1, "Freelance actualizado", 350);
        FinanzasAPI.actualizarGasto(0, "Comida saludable", 250);

        assertEquals("Freelance actualizado", FinanzasAPI.getIngresos().get(1).getNombre());
        assertEquals(350, FinanzasAPI.getIngresos().get(1).getValor());

        assertEquals("Comida saludable", FinanzasAPI.getGastos().get(0).getNombre());
        assertEquals(250, FinanzasAPI.getGastos().get(0).getCosto());

       
        int sumaIngresos = FinanzasAPI.getIngresos().stream().mapToInt(Ingreso::getValor).sum();
        int sumaGastos = FinanzasAPI.getGastos().stream().mapToInt(Gasto::getCosto).sum();

        assertEquals(1500 + 350, sumaIngresos);
        assertEquals(250 + 30, sumaGastos);
    }
}
