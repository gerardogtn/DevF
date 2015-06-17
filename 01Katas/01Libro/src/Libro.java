/**
 * Created by gerardogtn on 6/16/15.
 */
public class Libro {

    private String nombre;
    private Autor autores[] = new Autor[5];
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

    public String getNombre(){
        return this.nombre;
    }

    public Autor[] getAutores(){
        return this.autores;
    }

    public double getPrecio(){
        return this.precio;
    }

    public void setPrecio(double precio){
        this.precio = precio;
    }
}
