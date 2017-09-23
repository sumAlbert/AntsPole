package Object;

import java.util.ArrayList;
import java.util.List;

public class AntResult {
    private List<Ant> ants;
    private int time;

    public AntResult(List<Ant> ants,int time){
        this.ants=ants;
        this.time=time;
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
}
