/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ca.game.gameparticipants;

import com.ca.game.servlet.ListMaintain;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;

import org.kohsuke.rngom.digested.Main;

/**
 *
 * @author a0123055u
 */
@RequestScoped
public class ShuffleandValidate implements Serializable {
   private static final long version=1L;
     List<Integer> random_pick = new ArrayList<Integer>();
   Integer imageno1;
   Integer imageno2;
   @Inject
    private ListMaintain lm;
   public List swap()
   {  
	
   
        for (int i = 1; i <= 10; i++) {
            random_pick.add(i);
          random_pick.add(i);
        }
        System.out.println(random_pick);
        
        Collections.shuffle(random_pick);
//        long seed = System.nanoTime();
//        Collections.shuffle(random_pick, new Random(seed));
       System.out.println(random_pick);
       return random_pick;
            
   
   }
    public boolean check(Integer selection1,Integer selection2)
    {
       
         if((random_pick.get(selection1))==(random_pick.get(selection2)))
             ///image nos ..must match.result 
            {
             
             
                this.imageno1=random_pick.get(selection1);
                this.imageno2=random_pick.get(selection2);
            
               //return true;
            }
         else
            {
                    this.imageno1=random_pick.get(selection1);
                this.imageno2=random_pick.get(selection2);
                //return false;///image index btn id...common view
            }
 
        System.out.println("thiru???"+imageno1+"???"+imageno2);
      return true;
    }
    public boolean checkagain(Integer selection1,Integer selection2,List<Integer> x)
    {
        random_pick.clear();
        random_pick.addAll(x);
         if((random_pick.get(selection1))==(random_pick.get(selection2)))
             ///image nos ..must match.result 
            {
             
             
                this.imageno1=random_pick.get(selection1);
                this.imageno2=random_pick.get(selection2);
            
               // return true;
            }
         else
            {
                    this.imageno1=random_pick.get(selection1);
                this.imageno2=random_pick.get(selection2);
                return false;///image index btn id...common view
            }
         return true;
    }

    public Integer getImageno1() {
        return imageno1;
    }

    public Integer getImageno2() {
        return imageno2;
    }
   
    
}

