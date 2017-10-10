import com.mysql.jdbc.BufferRow;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import Object.*;

import java.io.PrintWriter;
import java.util.*;
import java.util.logging.Logger;

public class AntsResult extends HttpServlet{
    private Logger logger=Logger.getLogger("AntsResult");
    private Pole pole;
    private Time time;
    public AntsResult(){super();}
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pole_len=req.getParameter("pole");
        String ants_str=req.getParameter("ants");
        List<Ant> fix_direction=new ArrayList<Ant>();
        List<Ant> change_direction=new ArrayList<Ant>();
        List<List<Ant>> kinds=new ArrayList<>();
        List<AntResult> antResults=new ArrayList<>();
        pole=new Pole(Double.valueOf(pole_len));
        time=new Time();
        JSONObject jsonObject=JSONObject.fromObject(ants_str);
        Iterator iterator=jsonObject.keys();
        while (iterator.hasNext()){
            String key=(String)iterator.next();
            String ant_str=jsonObject.getString(key);
            JSONObject ant_info=JSONObject.fromObject(ant_str);
            String id_str=ant_info.getString("id");
            String speed_str=ant_info.getString("speed");
            String dirt_str=ant_info.getString("dirt");
            String distX_str=ant_info.getString("distX");
            String pos_str=ant_info.getString("pos");
            if(dirt_str.equals("0")){
                Ant ant=new Ant(id_str,Double.valueOf(speed_str),false,Double.valueOf(distX_str),Integer.valueOf(pos_str));
                fix_direction.add(ant);
            }
            else if(dirt_str.equals("1")){
                Ant ant=new Ant(id_str,Double.valueOf(speed_str),true,Double.valueOf(distX_str),Integer.valueOf(pos_str));
                fix_direction.add(ant);
            }else{
                Ant ant=new Ant(id_str,Double.valueOf(speed_str),Double.valueOf(distX_str),Integer.valueOf(pos_str));
                change_direction.add(ant);
            }
        }
        int change_kind=1<<change_direction.size();
        for(int i=0;i<change_kind;i++){
            List<Ant> fix_copy=copyList(fix_direction);
            for(int j=1;j<=change_direction.size();j++){
                Ant ant=change_direction.get(j-1);
                Ant new_ant=new Ant(ant);
                int base_num=1<<(j-1);
                int extra_num=i/base_num;
                if(extra_num%2==0)
                    new_ant.setInit_dirt(false);
                else
                    new_ant.setInit_dirt(true);
                fix_copy.add(new_ant);
            }
            kinds.add(fix_copy);
        }
        logger.info("situation kind num : "+kinds.size());
        int flag=0;
        int kind_size=kinds.size();
        int time_count=0;
        while(flag!=kind_size){
            time_count=time_count+1;
            for(int i=0;i<kinds.size();i++){
                List<Ant> ants_handing = kinds.get(i);
                if (time.isFinished(ants_handing, pole)) {
                    flag++;
                    sortList(ants_handing);
                    AntResult antResult=new AntResult(ants_handing,time_count,pole.getLen());
                    antResults.add(antResult);
                    kinds.remove(i);
                    i--;
                }
            }
        }
        JSONArray jsonArray=JSONArray.fromObject(antResults);
        String json_str=jsonArray.toString();
        logger.info(json_str);
        PrintWriter printWriter=resp.getWriter();
        printWriter.print(json_str);
        printWriter.close();
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    /*copy the old list existing ants*/
    private List<Ant> copyList(List<Ant> old_ants){
        List<Ant> new_ants=new ArrayList<Ant>();
        for(int i=0;i<old_ants.size();i++){
            Ant old_ant=old_ants.get(i);
            Ant new_ant=new Ant(old_ant);
            new_ants.add(new_ant);
        }
        return new_ants;
    }
    /*sort the list of ant*/
    private void sortList(List<Ant> old_ants){
        Collections.sort(old_ants,new Comparator<Ant>(){
            public int compare(Ant o1, Ant o2){
                return Integer.compare(o1.getPos(), o2.getPos());
            }
        });
    }
}
