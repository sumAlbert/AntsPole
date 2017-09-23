$(document).ready(function(){
    /*global variables*/
    var ant_postfix=0;//The postfix of ant
    var pole_len=10;//The length for the pole
    var ant_num=0;//The number of the ants
    var ants={};//The detail info about ants
    var ant;//The global variables

    /*lock avoid repeat sth again*/
    var lock_add=false;
    var lock_hover=false;

    /*init web*/
    init();

    /*catch the length of pole*/
    $("#pole-len").blur(function(){
       pole_len=$(this).val();
       if (pole_len==null||pole_len==""){
           pole_len=10;
           console.log(pole_len);
       }
       else{
           if (!isNaN(pole_len)){
               pole_len=parseInt(pole_len);
               console.log(pole_len);
           }
           else{
               pole_len=10;
               console.log(pole_len);
           }
       }
    });
    /*add a ant*/
    $("#add-ant").click(function(){
        var numId=createId();
        if(lock_add==false){
            lock_add=true;
            addAntInfo(numId);
            addId(numId,1);
            addInputEvent(numId);
            console.log(JSON.stringify(ants));
        }
    });
    /*send the requests to the servlet*/
    $(".run-button").click(function () {
        var JSON_requests=JSON.stringify(ants);
        $.ajax({
            url:"AntsResult",
            data:{
                ants:JSON_requests,
                pole:pole_len
            },
            success: function (data) {
                console.log(data);
                var results=JSON.parse(data);
                for(var result in results){
                    for(var item in result){
                        console.log(item);
                    }
                }
            },
            error:function () {
                console.log("error");
            }
        });
    });

    /*create a number between 0 and 1000000 as the id*/
    function createId(){
        return Math.round(Math.random()*1000000);
    }
    /*init the basic ant*/
    function init(){
        var numId=createId();
        addAntInfo(numId,0);
        addId(numId,0);
        addInputEvent(numId);
    }
    /*add a serial of id in the new DOM*/
    function addId(numId,flag){
        if(flag!=0){
            $(".panel1-line").eq(ant_num+2).attr("id","Ant-"+numId);
            $(".panel1-line-ant-name").eq(ant_num+1).html("蚂蚁"+(ant_postfix+1));
            $(".panel1-line-close").eq(ant_num+1).attr("id","Close-"+numId);
            $(".panel1-line-switched").eq(ant_num+1).attr("id","Switched-"+numId);
            $(".switch-left").eq(ant_num+1).attr("id","Left-"+numId);
            $(".switch-right").eq(ant_num+1).attr("id","Right-"+numId);
            $(".switch-both").eq(ant_num+1).attr("id","Both-"+numId);
            $(".ant-speed").eq(ant_num+1).attr("id","Speed-"+numId);
            $(".ant-dist").eq(ant_num+1).attr("id","Dist-"+numId);
            $(".panel1-line-switch-box").eq(ant_num+1).attr("id","Box-"+numId);
            $(".panel1-line-close").eq(ant_num).attr("id","Close-"+numId);
            $(".panel1-line-switch-items-hidden").eq(ant_num+1).attr("id","Hidden-"+numId);
            setTimeout(function () {
                ant_num=ant_num+1;
                ant_postfix=ant_postfix+1;
            },100)
        }else{
            $(".panel1-line").eq(ant_num+1).attr("id","Ant-"+numId);
            $(".panel1-line-switched").eq(ant_num).attr("id","Switched-"+numId);
            $(".switch-left").eq(ant_num).attr("id","Left-"+numId);
            $(".switch-right").eq(ant_num).attr("id","Right-"+numId);
            $(".switch-both").eq(ant_num).attr("id","Both-"+numId);
            $(".ant-speed").eq(ant_num).attr("id","Speed-"+numId);
            $(".ant-dist").eq(ant_num).attr("id","Dist-"+numId);
            $(".panel1-line-switch-box").eq(ant_num).attr("id","Box-"+numId);
            $(".panel1-line-switch-items-hidden").eq(ant_num).attr("id","Hidden-"+numId);
            setTimeout(function () {
                ant_num=ant_num+1;
                ant_postfix=ant_postfix+1;
            },100)
        }
    }
    /*add a serial of events including click and focus etc.*/
    function addInputEvent(numId){
        /*delete the ant*/
        $("#Close-"+numId).on("click",function(){
            $("#Ant-"+numId).remove();
            delete ants["id"+numId];
            ant_num=ant_num-1;
            console.log(JSON.stringify(ants));
        });
        /*show and hide the menu of direction*/
        $("#Box-"+numId).hover(function(){
            if(lock_hover==false){
                lock_hover=true;
                $("#Hidden-"+numId).show();
            }
        },
            function(){
            $("#Hidden-"+numId).hide();
            setTimeout(function () {
                lock_hover=false;
            },100)
        });
        setTimeout(function () {
            lock_add=false;
        },1)
        /*choose the direction*/
        $("#Left-"+numId).click(function(){
           var id="id"+numId;
           $("#Switched-"+numId).html("左");
           ants[id].dirt=0;
        });
        $("#Right-"+numId).click(function(){
            var id="id"+numId;
            $("#Switched-"+numId).html("右");
            ants[id].dirt=1;
        });
        $("#Both-"+numId).click(function(){
            var id="id"+numId;
            $("#Switched-"+numId).html("均可");
            ants[id].dirt=2;
        });
        /*change the speed of the ant*/
        $("#Speed-"+numId).blur(function(){
            var id="id"+numId;
            var speed=$(this).val();
            if (speed==null || speed==""){
                speed=1;
                ants[id].speed=speed;
            }
            else{
                if(!isNaN(speed)){
                    speed=parseInt(speed);
                    ants[id].speed=speed;
                }
                else{
                    speed=1;
                    ants[id].speed=speed;
                }
            }
        });
        /*change the dist of the ant*/
        $("#Dist-"+numId).blur(function(){
            var id="id"+numId;
            var speed=$(this).val();
            if (speed==null || speed==""){
                speed=1;
                ants[id].distX=speed;
            }
            else{
                if(!isNaN(speed)){
                    speed=parseInt(speed);
                    ants[id].distX=speed;
                }
                else{
                    speed=1;
                    ants[id].distX=speed;
                }
            }
        });
    }
    /*make up the JSON object to transform servlet*/
    function addAntInfo(numId,flag){
        if(flag!=0){
            var antId="id"+numId;
            var panel1_line_add=$(".panel1-line").eq(2).clone();
            $(".panel1").append(panel1_line_add);
            ant={id:antId,speed:1,dirt:2,distX:1,pos:ant_postfix};
            ants[antId]=ant;
        }
        else{
            var antId="id"+numId;
            ant={id:antId,speed:1,dirt:2,distX:1,pos:0};
            ants[antId]=ant;
        }
    }
});