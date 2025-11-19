/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.FileReader;
import java.io.FileWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;

/**
 *
 * @author LENOVO
 */
public class FinanzasAPI {

    private static final String FILE_GASTOS = "gastos.json";
    private static final String FILE_INGRESOS = "ingresos.json";

    private static ArrayList<Gasto> listaGastos = new ArrayList<>();
    private static ArrayList<Ingreso> listaIngresos = new ArrayList<>();

    private static final Gson gson = new Gson();

    public static void cargarDatos() {
        try {
            Type tipoGasto = new TypeToken<ArrayList<Gasto>>() {
            }.getType();
            FileReader reader = new FileReader(FILE_GASTOS);
            listaGastos = gson.fromJson(reader, tipoGasto);
            reader.close();
            if (listaGastos == null) {
                listaGastos = new ArrayList<>();
            }
        } catch (Exception e) {
            listaGastos = new ArrayList<>();
        }

        try {
            Type tipoIngreso = new TypeToken<ArrayList<Ingreso>>() {
            }.getType();
            FileReader reader = new FileReader(FILE_INGRESOS);
            listaIngresos = gson.fromJson(reader, tipoIngreso);
            reader.close();
            if (listaIngresos == null) {
                listaIngresos = new ArrayList<>();
            }
        } catch (Exception e) {
            listaIngresos = new ArrayList<>();
        }
    }

    private static void guardarGastos() {
        try (FileWriter writer = new FileWriter(FILE_GASTOS)) {
            gson.toJson(listaGastos, writer);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void guardarIngresos() {
        try (FileWriter writer = new FileWriter(FILE_INGRESOS)) {
            gson.toJson(listaIngresos, writer);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void registrarGasto(String nombre, int valor, boolean esHormiga) {
        if (esHormiga) {
            listaGastos.add(new GastoHormiga(nombre, valor));
        } else {
            listaGastos.add(new GastoNecesario(nombre, valor));
        }
        guardarGastos();
    }

    public static boolean actualizarGasto(int index, String nuevoNombre, int nuevoValor) {
        if (index >= 0 && index < listaGastos.size()) {
            listaGastos.get(index).setNombre(nuevoNombre);
            listaGastos.get(index).setCosto(nuevoValor);
            guardarGastos();
            return true;
        }
        return false;
    }

    public static ArrayList<Gasto> getGastos() {
        return listaGastos;
    }

    public static void registrarIngreso(String nombre, int valor) {
        listaIngresos.add(new Ingreso(nombre, valor));
        guardarIngresos();
    }

    public static boolean actualizarIngreso(int index, String nuevoNombre, int nuevoValor) {
        if (index >= 0 && index < listaIngresos.size()) {
            listaIngresos.get(index).setNombre(nuevoNombre);
            listaIngresos.get(index).setValor(nuevoValor);
            guardarIngresos();
            return true;
        }
        return false;
    }

    public static ArrayList<Ingreso> getIngresos() {
        return listaIngresos;
    }
}
