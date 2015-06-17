/**
 * Created by gerardogtn on 6/17/15.
 */
public class Circulo extends Figura {
    private double radio = 1.0;

    public Circulo(){

    }

    public Circulo(double radio, String color, boolean relleno){
        this.radio = radio;
        this.color = color;
        this.relleno = relleno;
    }

    public double getRadio() {
        return radio;
    }

    public void setRadio(double radio) {
        this.radio = radio;
    }

    // REQUIRES: None.
    // MODIFIES: None.
    // EFFECTS: Return the circle's perimeter.
    public double getPerimetro(){
        return Math.PI * 2 * radio;
    }

    // REQUIRES: None.
    // MODIFIES: None.
    // EFFECTS:  Return the circle's area.
    public double getArea(){
        return Math.PI * radio * radio;
    }

    // REQUIRES: None.
    // MODIFIES: None.
    // EFFECTS:  Returns a string representation of a circle. 
    public String toString(){
        return ""; //STUB
    }
}
