/**
 * Created by gerardogtn on 6/17/15.
 */
public class Celular extends AparatoElectronico implements LlamadaTelefonica {
    private String marca;
    private String modelo;
    private String dueno;
    private boolean enLlamada;

    public Celular(){
        this.marca = "";
        this.modelo = "";
        this.dueno = "";
        this.enLlamada = false;
        this.encendido = true;
        this.enchufado = false;
    }

    public Celular(String marca, String modelo, String dueno){
        this.marca = marca;
        this.modelo = modelo;
        this.dueno = dueno;
        this.enLlamada = false;
        this.encendido = true;
        this.enchufado = false;
    }
    @Override
    public void encender() {
        System.out.println("Presionando boton de encendido");
        System.out.println("Encendiendo... Espere");
        System.out.println("Encendido");
        this.encendido = true;
    }

    @Override
    public void apagar() {
        System.out.println("Presionando boton de apagado");
        System.out.println("Apagando... Espere");
        this.encendido = false;
    }

    @Override
    public void llamar(String destination) {
        System.out.print("Llamando a: ");
        System.out.println(destination);
        System.out.print("Conectado con: ");
        System.out.println(destination);
        this.enLlamada = true;
    }

    @Override
    public void colgar() {
        System.out.println("Terminando llamada");
        System.out.println("Llamada terminada");
        this.enLlamada = false;
    }
}
