/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ca.game.gameparticipants;

import com.ca.game.servlet.Game;
import com.ca.game.servlet.ListMaintain;
import com.ca.game.servlet.Player;
import com.ca.game.servlet.PlayerStore;
import java.io.Console;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.enterprise.concurrent.ManagedScheduledExecutorService;
import javax.inject.Inject;
import javax.jms.Session;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author a0123055u
 */
@WebServlet("/gameparticipantServlet")
public class gameparticipantServlet extends HttpServlet {

    int selection1;
    int selection2;
    String playerid;
    String result;
    String btn1;
    String btn2;
    String c;
    int p11;
    int p22;
    int score;
    int tries;
     String scoretemp ;
     String temptries;
    
      boolean a ;
    @Inject
    private gameparticipants participants;
    @Inject
    private GameRoom rooms;
    @Inject private Game game;
    @Inject private PlayerStore ps;
    @Inject private Player p;
    @Resource(mappedName = "concurrent/myfirstthreadpool")
    private ManagedScheduledExecutorService svc;

    @Inject
    private ShuffleandValidate shuffleandValidate;
    @Inject
    private ListMaintain lm;
    @EJB
     private UpdateScoreTriesBean up;

    HttpSession session;

    protected void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        btn1 = req.getParameter("selection1");
        btn2 = req.getParameter("selection2");
        playerid=req.getParameter("playerid");
      
        String temp = btn1.substring(3);
        String temp2 = btn2.substring(3);
        p11 = Integer.parseInt(temp) - 1;
        p22 = Integer.parseInt(temp2) - 1;
        c = req.getParameter("message");//game id is ms
       // if (gamecheck.getListno().equalsIgnoreCase("new")) {
//        if((btn1!=null )&&(btn2!=null)&&(c!=null))
//        {
        if(null==ps.getPlayerstore().get(c))
        {
            List<Player> p2p= new ArrayList<Player>();
        
           
           Map<String,List<Player>> map= ps.getPlayerstore();
           map.put(c, p2p);
      
           
           
        }
        
        boolean t=checkPlayer(c,playerid);
        System.out.println("TTTTTTTTTTTT   "+t);
        
        ps.getPlayerstore().get(playerid);
        if(lm.getRandom_pick().containsKey(c))
            
        {
//           lm.getRandom_pick().get(c);
             a = shuffleandValidate.checkagain(p11, p22,lm.getRandom_pick().get(c));
                System.out.println(a);
                System.out.println(">>>game.getPlayerid()"+game.getPlayerid());
                System.out.println(">>>game.playerid()"+playerid);
                
            if (a == true && tries<10)
             {
                 score++;
                 scoretemp = Integer.toString(score);
                result = "true";
                game.setPlayerscore(scoretemp);
                tries++;
                 temptries=Integer.toString(tries);
                 game.setPlayertries(temptries);
                 
            } 
             else if(a == true && tries==10)
             {
                 up.updatescore(scoretemp, playerid);
                 up.updatetries(temptries, playerid);
                  result = "true";
                  System.out.print("I am exected always in  if with 1st elseif");
             }
             else if(a == false  && tries==10)
             {
                 up.updatescore(scoretemp, playerid);
                  up.updatetries(temptries, playerid);
                   result = "false";
                   System.out.print("I am exected always in  if with 2nd elseif");
             }
             
             else {
                result = "false"; 
                System.out.print("I am exected always in else of if");
                 tries++;
                  temptries=Integer.toString(tries);
            game.setPlayertries(temptries);
            }
            
            
             System.out.print("score  "+scoretemp);
              System.out.print("tries  "+temptries);
              System.out.print("result  "+result);
         
        } else {

            Map<String,List > temp12 = lm.getRandom_pick();
          temp12.put(c, shuffleandValidate.swap());
            lm.setRandom_pick(temp12);
            a = shuffleandValidate.check(p11, p22);
             if (a == true && game.getPlayerid()==playerid && tries<10)
             {
                 score++;
                  scoretemp = Integer.toString(score);
                result = "true";
                game.setPlayerscore(scoretemp);
                tries++;
                temptries=Integer.toString(tries);
                 game.setPlayertries(temptries);
                 System.out.print("I am exected always in  if of else ");
                 
            } 
             else if(a == true && tries==10)
             {
                 up.updatescore(scoretemp, playerid);
                 up.updatetries(temptries, playerid);
                 result = "true";
                  System.out.print("I am exected always in  else with 1st elseif");
                 
             }
             else if(a == false  && tries==10)
             {
                 up.updatescore(scoretemp, playerid);
                 up.updatetries(temptries, playerid);
                 result = "false";
                  System.out.print("I am exected always in  else with 2nd elseif");
             }
             
             else {
                result = "false";
                 tries++;
                  System.out.print("I am exected always in 2nd else ");
                  temptries=Integer.toString(tries);
            game.setPlayertries(temptries);
            }
            
            System.out.print("hello"+a);
             System.out.print("score  "+scoretemp);
              System.out.print("tries  "+temptries);
              System.out.print("result  "+result);
        
        }
        

        int p1 = shuffleandValidate.getImageno1();
        int p2 = shuffleandValidate.getImageno2();
        svc.submit(new publishselection(c, result, p1, p2));
        svc.submit(new publishcommonselection(p11,p22,c,p1,p2));
        resp.setStatus(HttpServletResponse.SC_ACCEPTED);

    }

    public class publishselection implements Runnable {

        String result;
        String gameid;
        int p1;
        int p2;
//        int btn1;
//        int btn2;

        public publishselection(String gameid, String result, int p1, int p2) {
            this.result = result;
            this.gameid = gameid;
            this.p1 = p1;
            this.p2 = p2;
        }
             @Override
            public void run() {
            System.out.println(">> publishing: " + p11 + "  " + p22 + " " + result + " " + gameid + " " + p1 + " " + p2);
            rooms.publish(gameid, result+":"+btn1+":"+btn2, p1, p2);
           
                   
             }
    }
         public class publishcommonselection implements Runnable {
             
        String result;
        String gameid;
        int p1;
        int p2;
        int btn1;
        int btn2;
            

        private publishcommonselection(int p11, int p22, String result, int p1, int p2) {
            
            this.result = result;
            this.gameid = gameid;
            this.p1 = p1;
            this.p2 = p2;
            this.btn1=p11;
            this.btn2=p22;
            
        }
              @Override
        public void run() {
            System.out.println(">> publishing: " + p11 + "  " + p22 + " " + result + " " + gameid + " " + p1 + " " + p2);
            rooms.publishcommonview(btn1,btn2,gameid, result, p1, p2);
         }

       
            
        }

    

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.print("in servelet");
        response.getWriter().print("vada naye>>>>>>>>>");
        processRequest(request, response);
    }
    
    
    private boolean checkPlayer(String gameid,String playerid)
    {
       List<Player> list =ps.getPlayerstore().get(gameid);
       
       for(Player p : list)
       {
           if(p.getPlayerid()==playerid)
               return true;
       }
       return false;
    }

}
