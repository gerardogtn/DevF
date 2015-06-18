/**
 * Created by gerardogtn on 6/17/15.
 */
public abstract class AparatoElectronico {
    protected boolean encendido;
    protected boolean enchufado;

    public void enchufar(){
        this.enchufado = true;
    }

    public void desenchufar(){
        this.enchufado = false;
    }

    public abstract void encender();
    public abstract void apagar();
}

