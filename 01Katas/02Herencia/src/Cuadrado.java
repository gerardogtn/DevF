/**
 * Created by gerardogtn on 6/17/15.
 */
public class Cuadrado {

    private Rectangulo rectangulo = new Rectangulo();

    public Cuadrado(){
    }

    public Cuadrado(double lado){
        setLado(lado);
    }

    public Cuadrado(double lado, String color, boolean relleno){
        setLado(lado);
        rectangulo.setColor(color);
        rectangulo.setRelleno(relleno);
    }

    public String getColor(){
        return rectangulo.getColor();
    }

    public void setColor(String color) {
        rectangulo.setColor(color);
    }

    public boolean isRelleno() {
        return rectangulo.isRelleno();
    }

    public void setRelleno(boolean relleno) {
        rectangulo.setRelleno(relleno);
    }

    // REQUIRES: None.
    // MODIFIES: None.
    // EFFECTS: Get either rectangulo.getAlto or rectangulo.getAncho
    public double getLado(){
        return rectangulo.getAlto();
    }

    // REQUIRES: None.
    // MODIFIES: this.
    // INVARIANT: rectangulo.getAlto == rectangulo.getAncho
    // EFFECTS: Sets this.rectangulo height and width to lado.
    public void setLado(double lado){
        assert rectangulo.getAncho() == rectangulo.getAlto();
        rectangulo.setAlto(lado);
        rectangulo.setAncho(lado);
        assert rectangulo.getAncho() == rectangulo.getAlto();
    }

    // REQUIRES: None.
    // MODIFIES: None.
    // EFFECTS: Returns the area of the square.
    public double getArea(){
        return rectangulo.getArea();
    }

    // REQUIRES: None.
    // MODIFIES: None.
    // EFFECTS: Returns the perimeter of the square.
    public double getPerimetro(){
        return rectangulo.getPerimetro();
    }

    // REQUIRES: None.
    // MODIFIES: None.
    // EFFECTS: Returns a string representation of the square.
    @Override
    public String toString(){
        return rectangulo.toString();
    }
}
