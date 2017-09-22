package Object;

public class Pole {
    private double len;

    /*construct function*/
    public Pole(double len){
        super();
        this.len=len;
    }

    /*The function to set attr*/
    public void setLen(double len) {
        this.len = len;
    }

    /*The function to get attr*/
    public double getLen(){
        return this.len;
    }
}
