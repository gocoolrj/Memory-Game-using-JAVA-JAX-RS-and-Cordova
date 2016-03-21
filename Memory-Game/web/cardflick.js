$(document).on("pagecontainershow", function (_, $ui) {
   
     if ("gamehomepage" === $ui.toPage.attr("id")) {
        
    var count=0;
    var selected=[];
    var opencard=[];
    var tries=0;
    var index=[];
  
//    $("button").click(function(){
        
         $("#submit").on("click", function () {
//                      var x=selected[0];
//                  var y =selected[1];
//                var gameid= $("#gameid").val();
                    var x="btn1";
                    var y="btn20";
                    var gameid="gid6";
                $.getJSON("gameparticipantServlet", {selection1:x,selection2:y})
        
         })
        
        
//    });
     }
     });
    
//      if( count<2 )
//      {
//            console.log("count "+count);
//            count++;
//            tries++;
//            selected.push(this.id); 
//          /*-------"selected" contains button id-------*/
//            console.log(selected);
//            
//          if (count=== 2)
//              {
//                         console.log("count "+count);
//                 
//                 $("#submit").on("click", function () {
//                      var x=selected[0];
//                  var y =selected[1];
//                var gameid= $("#gameid").val();
//                $.getJSON("gameparticipantServlet", {selection1:x,selection2:y,gameid:gameid})
//                            .done(function(result){
//                                alert("hi");
//                              var gameid1 =result[0];
//                                var res = result[1];
//                                index[0]=result[2];
//                                index[1]=result[3];
//                                
//                                console.log(gameid1);
//                                 console.log(res);
//                                  console.log( index[0]);
//                                   console.log(index[1]);
//                                
//                            
////                            for (var i in result )
////                            {
//                              
////                                
////
////                            }
//                    
//                            
//                        })
//                    });
//           
//                    
//                  
////                 alert(tries);
////                  var c=[];
////                  for (var i=0;i<2;i++)
////                  {
////                      var b= parseInt(selected[i] .substr(3,2))-1;
////                      c.push(b);
////                  /*-------"c" contains position of image number in images array -------*/
////                  }
////                  if(image[c[0]]===image[c[1]])
////                  {
////                    console.log(">>>>>>Cards are equal ");
////                      $("button").attr("disabled", false);
////                      for(var i =0;i<2;i++)
////                      {
////                            var p = selected[i];
////                            opencard.push(p);
////                        // console.log(opencard);
////                          $("#"+selected[i]).append($('<img>', { 
////                                src : "images/" +image[c[i]]+".png", 
////                                width : 100, 
////                                height : 100, 
////                                alt : "Test Image", 
////                                title : "Test Image"
////                                     
////                            }));
////                               
////                      }
////                      for(var i =0;i<opencard.length;i++)
////                      {
////                          $("#"+opencard[i]).attr("disabled",true);
////                       }
////                      
////                      count=0;
////                      selected=[];
////
////                  }
////                  else
////                  {  console.log("Cards not equal ");
////                        alert("Card Doesnt match");
////                    
////                        $("button").attr("disabled", false);
////                       for(var i =0;i<opencard.length;i++)
////                      {
////                          $("#"+opencard[i]).attr("disabled",true);
////                      }
////                      count=0;
////                      selected=[];
////                  }
//              }
//       } 
//       
////       else
////       {
////             alert("Selection Exceded");
////        }
////     
   
//      }
     


//
//       
//      var a=this.id;
//       
//        var b= ((parseInt(a.substr(3,2))%10));
//        if(b==0)
//         b = b+10;
//        b=b-1;
//        $(this).append($('<img>', { 
//    src : "C:/Users/Ashwin/Desktop/Team 2 adv web/images/" +image[b]+".png", 
//    width : 100, 
//    height : 100, 
//    alt : "Test Image", 
//    title : "Test Image"
//}));