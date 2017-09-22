package Object;

import java.util.Comparator;

public class Ant implements Comparator{
    private double speed;//The speed of ant
    private double distX;//The distance between left point and ant
    private boolean status;//The status of ant;false---- on the pole,true----under the pole
    private boolean dirt;//The direction of ant
    private String id;
    private int pos;//The order of ants
    /*construct function*/
    public Ant(String id,double speed,boolean dirt,double distX,int pos){
        super();
        this.id=id;
        this.speed=speed;
        this.dirt=dirt;
        this.distX=distX;
        this.pos=pos;
        this.status=true;
    }
    public Ant(String id,double speed,double distX,int pos){
        super();
        this.id=id;
        this.speed=speed;
        this.distX=distX;
        this.pos=pos;
        this.status=true;
    }
    public Ant(Ant ant){
        this.speed=ant.speed;
        this.distX=ant.distX;
        this.status=ant.status;
        this.dirt=ant.dirt;
        this.id=ant.id;
        this.pos=ant.pos;
        this.status=ant.status;
    }
    /*The function to get private attrs*/
    public double getDistX() {
        return distX;
    }
    public double getSpeed() {
        return speed;
    }
    public boolean getStatus(){
        return status;
    }
    public boolean getDirt(){
        return dirt;
    }
    public String getId() {
        return id;
    }
    public int getPos() {
        return pos;
    }

    /*The function to set private attrs*/
    public void setDirt(boolean dirt) {
        this.dirt = dirt;
    }
    public void setDistX(double distX) {
        this.distX = distX;
    }
    public void setSpeed(double speed) {
        this.speed = speed;
    }
    public void setStatus(boolean status) {
        this.status = status;
    }
    public void setId(String id) {
        this.id = id;
    }
    public void setPos(int pos) {
        this.pos = pos;
    }

    @Override
    public int compare(Object o1, Object o2) {
        Ant ant1=(Ant) o1;
        Ant ant2=(Ant) o2;
        return 0;
    }
}
