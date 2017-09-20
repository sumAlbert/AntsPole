$(document).ready(function(){
    var pole_len=10;//The length for the pole
    var ant_num=0;//The number of the ants
    var ants={};
    var ant;//The global variables
    /*init web*/
    init();
    /*add a ant*/
    $("#add-ant").click(function(){
        var antId=createId();
        var panel1_line_add=$(".panel1-line").eq(2).clone();
        $(".panel1").append(panel1_line_add);
        $(".panel1-line").eq(ant_num+2).attr("id",antId);
        ant_num=ant_num+1;
        ant={id:antId,speed:1,dirt:0,distX:1};
        ants[antId]=ant;
        $("#"+antId).on("click",function(){
            alert("delete");
        });
        console.log(ants);
    });
    function createId(){
        var num=Math.round(Math.random()*1000000);
        num="Ant"+num;
        return num;
    }
    function init(){
        var antId=createId();
        $(".panel1-line").eq(1).attr("id",antId);
        ant_num=ant_num+1;
        ant={id:antId,speed:1,dirt:0,distX:1};
        ants[antId]=ant;
    }
});