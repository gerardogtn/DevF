/**
 * Created by gerardogtn on 6/17/15.
 */
public class Rectangulo extends Figura{

    private double ancho;
    private double alto;

    public Rectangulo(){
        ancho = 0.0;
        alto = 0.0;
    }

    public Rectangulo(double ancho, double alto, String color, boolean relleno){
        this.ancho = ancho;
        this.alto = alto;
        this.color = color;
        this.relleno = relleno;
    }

    public double getAncho() {
        return ancho;
    }

    public void setAncho(double ancho) {
        this.ancho = ancho;
    }

    public double getAlto() {
        return alto;
    }

    public void setAlto(double alto) {
        this.alto = alto;
    }

    @Override
    public double getArea() {
        return ancho * alto;
    }

    @Override
    public double getPerimetro() {
        return (2 * ancho) + (2 * alto);
    }

    @Override
    public  String toString(){
        return ""; //STUB
    }
}
