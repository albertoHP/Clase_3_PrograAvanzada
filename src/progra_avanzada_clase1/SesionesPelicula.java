/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package progra_avanzada_clase1;

import java.util.Vector;

/**
 *
 * @author Alberto
 */
public class SesionesPelicula {
    Pelicula pelicula;
    Vector sesiones;

    public SesionesPelicula(Pelicula pelicula, Vector sesiones) {
        this.pelicula = pelicula;
        this.sesiones = sesiones;
    }

    public Pelicula getPelicula() {
        return pelicula;
    }

    public void setPelicula(Pelicula pelicula) {
        this.pelicula = pelicula;
    }

    public Vector getSesiones() {
        return sesiones;
    }

    public void setSesiones(Vector sesiones) {
        this.sesiones = sesiones;
    }
    
    
}
