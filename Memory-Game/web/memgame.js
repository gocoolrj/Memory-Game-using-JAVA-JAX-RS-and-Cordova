var gameId = "";
var Gid = "";
var Pid="";
var selection = [];
var s1;
var s2;



$(function () {
    $("#smtbtn").on("click", function () {

        $.getJSON("GameServlet", {playername: $("#playername").val(), imei: $("#imei").val()})
                .done(function (result) {
                    console.log(">> " + JSON.stringify(result));
                    console.log(">> " + result.Plid);

                })
                .fail(function () {
                    $("#status").text("Error!!!");
                })
    });
});
$(function () {
    $("#getIDbtn").on("click", function () {
        $.getJSON("GameServlet", {playername: $("#playername").val(), imei: $("#imei").val()})
                .done(function (result) {
                    console.log(">> " + JSON.stringify(result));
                    console.log(">> " + result.Plid);
                    $("#playerid").val((result.Plid));
                    Pid=result.Plid;
                    console.log(Pid);
                })
                .fail(function () {
                    $("#status").text("Error!!!");
                })
    });
});



$(document).on("pagecontainerbeforeshow", function (_, $ui) {
    if ("newgamepage" == $ui.toPage.attr("id")) {

        $.getJSON("gameidservlet", {playerid: $("#playerid").text})

                .done(function (result) {
                    for (var i in result)
                    {
                        $("#gamesplayed").append(createLi(result[i].gameid));
                        console.log("For loop for append");
                        $("#gamesplayed").listview("refresh");

                    }
                });


    }


    if ("gamehomepage" === $ui.toPage.attr("id")) {


        // <input type="text" id="room-name">
        //   gameId = $("#gameid").val();
        // console.log("gameId"+gameId);
        //GET
        sseConnection = new EventSource("api/game/" + gameId);
        //sseConnection.onmessage = messageHandler;
       console.log(Gid);
        Gid=gameId;
        
        
        sseConnection.addEventListener(gameId, messageHandler);
//          Gid=gameID;
//      console.log(Gid);
        //$(sseConnection).on("message", messageHandler); //jQuery

        for (var i = 1; i <= 20; i++)
        {
            $("#btn" + i).html("<img src = \"images/back.png \">");

        }
        $("#Pid").val(Pid);
           $("#Gid").val(Gid);
        $("button").click(function () {

           
            console.log(selection);
            if(selection.length<2)
            {
                 selection.push(this.id);
                 console.log("...."+selection);
            }
            else
            {
                selection=[];
                  selection.push(this.id);
                    console.log("...."+selection);
                
            }

        });
        $("#submit").on("click", function () {
            s1 = selection[0];
            s2 = selection[1];
           
            selection = [];


            $.get("gameparticipantServlet", {selection1: s1, selection2: s2,playerid:Pid,
                message: Gid
            });


        });

    }

    function messageHandler(result) {
        var array;
        console.log("SSE message");
        console.log(result.data);
        var a = result.data;
        array = a.split(":");

        var gameid = array[0];
        var result = array[1];
        var button1=array[2];
        var button2=array[3];
        var index1 = array[4];
        var index2 = array[5];
        console.log(gameid);
        console.log(result);
        console.log(index1);
        console.log(index2);
        console.log(button1);
        console.log(button2);
        

        if (result === "true")
        {

            $("#" + button1).html("<img src = \"images/" + index1 + ".png\"/>");
            $("#" + button2).html("<img src = \"images/" + index2 + ".png\"/>");
           

        }
        else if (result === "false")
        {

            $("#" + button1).html("<img src = \"images/" + index1 + ".png\"/>");
            $("#" + button2).html("<img src = \"images/" + index2 + ".png\"/>");
            setTimeout(function () {

                console.log(selection);
                $("#" + button1).html("<img src = \"images/back.png\"/>");
                $("#" + button2).html("<img src = \"images/back.png\"/>");

            }, 2000);

        }
        

    }


});

function createLi(name) {
    var $a = $("<a>").attr("href", "#gamehomepage").text(name);
    var $li = $("<li>").append($a);
    return ($li);
}



$(document).on("pagecontainershow", function (_, $ui) {
    if ("newgamepage" === $ui.toPage.attr("id")) {
        console.log("startnewgame");
        $("#startnewgame").on("click", function () {
            
            $("#gamesplayed").listview("refresh")

        });

    }

    if ("newgamepage" === $ui.toPage.attr("id"))
    {
        $("a").on("click", function () {
            gameId = $(this).text();
            console.log(gameId);


        });


    }


});

$(document).on("pagecontainershow", function (_, $ui) {
    if ("CommonView" === $ui.toPage.attr("id")) {
        //gameid=
        console.log(gameid);
          sseConnection = new EventSource("api/game/"+gameid);
          
        //sseConnection.onmessage = messageHandler;
        sseConnection.addEventListener(btn11, messageHandler);
        
        function messageHandler(result) {
    
        var array;
        console.log("CommonVIew");
        console.log(result.data);
        var a = result.data;
        array = a.split(":");

        var button1=array[0];
        var button2=array[1];
        var gameid = array[2];s
        var result = array[3];
        var index1 = array[4];
        var index2 = array[5];
        
        console.log(button1);
        console.log(button2);
        console.log(gameid);
        console.log(result);
        console.log(index1);
    }

    }
});