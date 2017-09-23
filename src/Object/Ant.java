package Object;

import java.util.Comparator;

public class Ant{
    private double speed;//The speed of ant
    private double distX;//The distance between left point and ant
    private boolean status;//The status of ant;true---- on the pole,false----under the pole
    private boolean dirt;//The direction of ant,false---left,true---right
    private String id;
    private int pos;//The order of ants
    private boolean init_dirt;

    /*construct function*/
    public Ant(String id,double speed,boolean dirt,double distX,int pos){
        super();
        this.id=id;
        this.speed=speed;
        this.dirt=dirt;
        this.distX=distX;
        this.pos=pos;
        this.status=true;
        this.init_dirt=dirt;
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
        this.init_dirt=ant.init_dirt;
    }

    /*The function to get private attrs*/
    public boolean getInit_dirt(){
        return this.init_dirt;
    }
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
    public void setInit_dirt(boolean init_dirt) {
        this.init_dirt = init_dirt;
        this.dirt=init_dirt;
    }
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

    /*go for a time*/
    public double run(Pole pole){
        if (dirt){
            distX+=speed;
            if(distX<=0||distX>=pole.getLen())
                status=false;
            return distX;
        }
        else{
            distX-=speed;
            if(distX<=0||distX>=pole.getLen())
                status=false;
            return distX;
        }
    }
}
