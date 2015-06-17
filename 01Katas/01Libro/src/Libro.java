/**
 * Created by gerardogtn on 6/16/15.
 */
public class Libro {

    private String nombre;
    private int numAutores = 0;
    private double precio;
    private int cantidadStock = 0;

    public Libro(String name, double cost){
        this.nombre = name;
        this.precio = cost;
    }

    public Libro(String name, double cost, int stockAmount){
        this.nombre = name;
        this.precio = cost;
        this.cantidadStock = stockAmount;
    }
}
