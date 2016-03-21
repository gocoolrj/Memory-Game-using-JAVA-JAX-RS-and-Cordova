/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ca.game.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "GameValidation", urlPatterns = {"/GameValidation"})
public class GameValidation extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<Integer> random_pick = new ArrayList<Integer>();
//
//        String btn1 = request.getParameter("btn1");
//        String btn2 = request.getParameter("btn2");
//        int tries = Integer.parseInt(request.getParameter("tries"));
//
//        if (tries == 2) {
//
//            random_pick = shuffle();
//            String[] selected = new String[2];
//            int[] buttonID = new int[2];
//            selected[0] = btn1;
//            selected[1] = btn2;
//            for (int i = 0; i < selected.length; i++) {
//
//                int b = Integer.parseInt((selected[i].substring(3)));
//                buttonID[i] = b;
//            }
//            if(randompick[buttonID[0]]==buttonID[0])
//            
//
//        } else {
//            
//        }
//
    }
//
//    protected List<Integer> shuffle() {
////        List<Integer> generate = new ArrayList<Integer>();
//        int[] generate = new int[20];
//        for (int i = 0; i < 10; i++) {
//
//           generate[i]=i;
//        }
//
//        long seed = System.nanoTime();
//        Collections.shuffle(generate, new Random(seed));
//        return generate;
//    }

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
