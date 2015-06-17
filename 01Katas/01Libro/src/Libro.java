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

    public int getCantidadStock(){
        return this.cantidadStock;
    }

    public void setCantidadStock(int stockAmount){
        this.cantidadStock = stockAmount;
    }

    public String toString(){
        return ""; //STUB
    }

    // REQUIRES: None.
    // MODIFIES: None.
    // EFFECTS:  Prints to console the authors of a book.
    public void printAutores(){
        System.out.print("Los autores del libro: ");
        System.out.print(getNombre());
        System.out.println(" son: ");

        for (int i = 0; i < this.numAutores; i++){
            System.out.println(autores[i]);
        }
    }

    // REQUIRES: None
    // MODIFIES: this
    // EFFECTS:  Adds an Author to this.autores
    public void addAutor(Autor autor) throws IndexOutOfBoundsException {
        if(this.numAutores < 5){
            this.autores[numAutores] = autor;
            numAutores++;
        } else{
            throw new IndexOutOfBoundsException("El numero maximo de autores es 5.");
        }
    }
}
