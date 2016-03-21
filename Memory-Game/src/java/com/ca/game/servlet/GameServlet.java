/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ca.game.servlet;

import com.ca.game.model.memorygame;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Inject;
import javax.json.Json;
import javax.json.JsonObject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author A0129075A
 */
@WebServlet(name = "GameServlet", urlPatterns = {"/GameServlet"})
public class GameServlet extends HttpServlet {

    @EJB
    private PlayerBean pb;
    @EJB
    private GeneratorBean ib;
    @Inject private Player player;
     @Inject private PlayerStore playerstore;
    

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String playername = request.getParameter("playername");
        String imei = request.getParameter("imei");
        String playerid;
        String imei1;
      
        if (!(playername.isEmpty() ) && !(imei.isEmpty())) {
            response.setStatus(HttpServletResponse.SC_ACCEPTED);
            List<memorygame> mg = pb.gameSearch(imei);
            if (mg.isEmpty()) {
                ib.generateid(imei, playername);
                //String ss1=pb.retrivePlayerid(imei);
                //player.setPlayerid(ss1);

            } else {
                String ss = pb.retrivePlayerid(imei);
                 player.setPlayerid(ss);

                JsonObject result = Json.createObjectBuilder()
                        .add("Plid", ss)
                        .build();
                response.setStatus(HttpServletResponse.SC_OK);
                response.setContentType("application/json");
                try (PrintWriter pw = response.getWriter()) {
                    pw.println(result.toString());
                }
            }
        } else {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);

        }

    }

// <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("get inside servlet");
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
