package Object;

import java.util.List;

public class Time
{
    private int clock;

    /*construct function*/
    public Time(){
        super();
        clock=0;
    }

    /*The function to get private attrs*/
    public int getClock() {
        return clock;
    }

    /*The function to get private attrs*/
    public void setClock(int clock) {
        this.clock = clock;
    }
    /*run the game for one second*/
    public boolean isFinished(List<Ant> ants,Pole pole){
        boolean result=true;
        for(int i=0;i<ants.size();i++){
            Ant ant=ants.get(i);
            if(ant.getStatus()){
                ant.run(pole);
            }
        }
        for(int i=0;i<ants.size();i++){
            Ant ant=ants.get(i);
            if(ant.getStatus()){
                result=false;
                for(int j=i+1;j<ants.size();j++){
                    Ant ant_comp=ants.get(j);
                    if(j!=i&&(ant.getDistX()==ant_comp.getDistX())&&(ant.getDirt()!=ant_comp.getDirt())){
                        ant.setDirt(!ant.getDirt());
                        ant_comp.setDirt(!ant_comp.getDirt());
                    }
                }
            }
        }
        return result;
    }
}
