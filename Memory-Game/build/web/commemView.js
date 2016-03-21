
$(document).on("pagecontainerbeforeshow", function (_, $ui) {
    

});

function messageHandler(result) {
    
        var array;
        console.log("CommonVIew");
        console.log(result.data);
        var a = result.data;
        array = a.split(":");

        var button1=array[0];
        var button2=array[1];
        var gameid = array[2];
        var result = array[3];
        var index1 = array[4];
        var index2 = array[5];
        
        console.log(button1);
        console.log(button2);
        console.log(gameid);
        console.log(result);
        console.log(index1);
        console.log(index2);
 
    
//    var t = $("#content").text();
//    
//    console.log(gameid);
//    $("#content").text(gameid.data + "\n" + t);
}