package Object;

import java.util.ArrayList;
import java.util.List;

public class AntResult {
    private List<Ant> ants;
    private int time;
    private double pole;

    public AntResult(List<Ant> ants,int time,double pole){
        this.ants=ants;
        this.time=time;
        this.pole=pole;
    }

    public void setPole(double pole) {
        this.pole = pole;
    }
    public void setAnts(List<Ant> ants) {
        this.ants = ants;
    }
    public void setTime(int time) {
        this.time = time;
    }
    public List<Ant> getAnts() {
        return ants;
    }
    public int getTime(){
        return time;
    }
    public double getPole() {
        return pole;
    }
}
