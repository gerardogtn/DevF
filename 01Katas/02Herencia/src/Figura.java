/**
 * Created by gerardogtn on 6/17/15.
 */
public abstract class Figura {
    protected String color = "rojo";
    protected boolean relleno = true;

    public String getColor(){
        return this.color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isRelleno() {
        return relleno;
    }

    public void setRelleno(boolean relleno) {
        this.relleno = relleno;
    }

    public String toString(){
        return ""; //STUB
    }
}
