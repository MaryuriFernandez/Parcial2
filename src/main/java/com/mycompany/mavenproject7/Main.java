
package com.mycompany.mavenproject7;
import static spark.Spark.*;
import com.google.gson.Gson;
import java.util.LinkedList;


public class Main {

    public static void main(String[] args) {
          /*
        * Esto nos sirve para generar un formato json para retornar la data del array
        * sin tener que acomodarla bonita de manera manual
        */
        Gson gson = new Gson();
        
        LinkedList <Vehiculo> automoviles = new LinkedList<>();
        LinkedList <Vehiculo> motos = new LinkedList<>();
        
        // Automovil creado por defecto
        Automovil auto = new Automovil(4, "Mazda", "3", "ZYX987", 8, 0);
        automoviles.add(auto);
        
        Motocicleta moto = new Motocicleta(600, "Honda", "CBR600", "XYZ789", 5, 0);
        motos.add(moto);
        
        
        // Definir endpoints
        
        // Por defecto 
        get("/motos", (req, res) -> {
            res.type("application/json");
            return gson.toJson(motos);
        });
        
        // Listado de automovile
        get("/automoviles", (req, res) -> {
            res.type("application/json");
            return gson.toJson(automoviles);
        });
        
        //

        
        // Guardar automovil
        // endpoint GET para agregar un automóvil
        get("/agregarAutomovil/:marca/:modelo/:placa/:numeroPuertas/:horaIngreso/:horaSalida", (req, res) -> {
            
            // Añadimos esto para retornar en formato Json
            res.type("application/json");

            // Obtener parámetros de la URL
            String marca = req.params(":marca");
            String modelo = req.params(":modelo");
            String placa = req.params(":placa");
            
            // No olvidar convertir en integer los string numericos que llegan por url
            int numeroPuertas = Integer.parseInt(req.params(":numeroPuertas"));
            int horaIngreso = Integer.parseInt(req.params(":horaIngreso"));
            int horaSalida = Integer.parseInt(req.params(":horaSalida"));


            
            // Crear un nuevo automóvil y agregarlo al parqueadero
            Automovil nuevoAuto = new Automovil(numeroPuertas, marca, modelo,placa, horaIngreso, horaSalida);
            automoviles.add(nuevoAuto);

            return gson.toJson(nuevoAuto);
        });
        
        
        
        get("/agregarMoto/:marca/:modelo/:placa/:cilindrada/:horaIngreso/:horaSalida", (req, res) -> {
            
            // Añadimos esto para retornar en formato Json
            res.type("application/json");

            // Obtener parámetros de la URL
            String marca = req.params(":marca");
            String modelo = req.params(":modelo");
            String placa = req.params(":placa");
            
            // No olvidar convertir en integer los string numericos que llegan por url
            int cilindrada = Integer.parseInt(req.params(":cilindrada"));
            int horaIngreso = Integer.parseInt(req.params(":horaIngreso"));
            int horaSalida = Integer.parseInt(req.params(":horaSalida"));

            
            // Crear un nuevo automóvil y agregarlo al parqueadero
            Motocicleta nuevoMoto = new Motocicleta(cilindrada, marca, modelo,placa, horaIngreso, horaSalida);
            motos.add(nuevoMoto);

            return gson.toJson(nuevoMoto);
        });
        
//        get("/sacarAutomovil/:placa/:horaSalida", (req, res)->{
//            
//            // Añadimos esto para retornar en formato Json
//            res.type("application/json");
//            
//             // Obtener parámetros de la URL
//            String placa = req.params(":placa");
//            int horaSalida = Integer.parseInt(req.params(":horaSalida"));
//            
//            
//        });
        
    }
    public void sacarAutomovil(){
      
        
    }
}
