/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ca.game.servlet;

import com.ca.game.gameparticipants.ShuffleandValidate;
import com.ca.game.model.gamerecord;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Inject;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.Response;

/**
 *
 * @author a0123055u
 */
@WebServlet("/gameidservlet")
public class GameIdServlet extends HttpServlet {

    List<String> gameid1;
    List<String> player1;
    List<String> player2;
    @Inject private Game gamecheck;
    @EJB
    GameIdGeneratorBean gidgen;
    JsonArrayBuilder arraybuilder = Json.createArrayBuilder();
    @Inject
    private ShuffleandValidate shuffleandValidate;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String playerid = request.getParameter("playerid");
        
        List<gamerecord> grcd = gidgen.searchgameid();

        if (grcd == null) {
            int a = gidgen.GameIdGenerator(playerid);
            
            if (a == 1) {
                
                response.setStatus(HttpServletResponse.SC_ACCEPTED);
            } else {
                response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            }

        } else {
            for (gamerecord gr : grcd) {
                if (gr.getPlayerid2().isEmpty()) {
                    gr.setPlayerid2("available");
                    response.setStatus(HttpServletResponse.SC_OK);
                    response.setContentType("application/json");

                    JsonObjectBuilder builder1 = Json.createObjectBuilder();

                    builder1.add("gameid", gr.getGameid());
                    builder1.add("player1", gr.getPlayerid1());
                    builder1.add("player2", gr.getPlayerid2());
                    arraybuilder.add(builder1.build());
                    

                } else {
                    response.setStatus(HttpServletResponse.SC_OK);
                    response.setContentType("application/json");

                    JsonObjectBuilder builder1 = Json.createObjectBuilder();
                    System.out.println(">>" + gr.getGameid() + ">>" + gr.getPlayerid1() + ">>" + gr.getPlayerid2());
                    builder1.add("gameid", gr.getGameid());
                    builder1.add("player1", gr.getPlayerid1());
                    builder1.add("player2", gr.getPlayerid2());
                    arraybuilder.add(builder1.build());

                }
                 gamecheck.gameid=gr.getGameid();
                 
                    gamecheck.playerid=gr.getPlayerid1();
                    
                   
                    gamecheck.listno="new";
                  
                    

            }
                   
            
            try (PrintWriter pw = response.getWriter()) {
                pw.println(arraybuilder.build());
            }
        }
    }
}
