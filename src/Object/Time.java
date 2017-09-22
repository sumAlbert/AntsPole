package Object;

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

}
