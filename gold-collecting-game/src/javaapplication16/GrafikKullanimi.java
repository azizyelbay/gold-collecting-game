/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication16;

/**
 *
 * @author lenovo
 */

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import javax.imageio.ImageIO;
import javax.imageio.stream.FileImageInputStream;
import javax.swing.JPanel;


public class GrafikKullanimi extends JPanel {
//private Robot robot;
public int[][] harita;
      BufferedImage bes_altin;
BufferedImage on_altin;
BufferedImage onbes_altin;
BufferedImage yirmi_altin;
BufferedImage PLAYER_A;
BufferedImage PLAYER_B;
BufferedImage PLAYER_C;
BufferedImage PLAYER_D;
      
                
              
    public GrafikKullanimi(int[][] harita) throws IOException {
        this.harita = harita;
        bes_altin=ImageIO.read(new FileImageInputStream(new File("BES.png")));
        on_altin=ImageIO.read(new FileImageInputStream(new File("ON.png")));
        onbes_altin=ImageIO.read(new FileImageInputStream(new File("ONBES.png")));
        yirmi_altin=ImageIO.read(new FileImageInputStream(new File("YIRMI.png")));
        PLAYER_A=ImageIO.read(new FileImageInputStream(new File("A.png")));
        PLAYER_B=ImageIO.read(new FileImageInputStream(new File("B.png")));
        PLAYER_C=ImageIO.read(new FileImageInputStream(new File("C.png")));
        PLAYER_D=ImageIO.read(new FileImageInputStream(new File("D.png")));
    }

    public GrafikKullanimi() {
        
        setBackground(Color.white);
        //this.robot=robot;
        
        
    }
    
    @Override
    public void paint(Graphics g) {
        super.paint(g); //To change body of generated methods, choose Tools | Templates.
        
        for (int i = 0; i < harita.length; i++) {
            for (int j = 0; j < harita[0].length; j++) {
               /*if(harita[i][j]>0&&harita[i][j]<21){
                   g.setColor(Color.orange);
                   g.fillOval(j*30, i*30, 30, 30);//y  x seklinde yaz
                   
               }*/
               if(harita[i][j]==5){
                   
                   g.drawImage(bes_altin,j*30,i*30,bes_altin.getWidth()/3,bes_altin.getHeight()/3,this);
               }
               if(harita[i][j]==10){
                   
                   g.drawImage(on_altin,j*30,i*30,on_altin.getWidth()/3,on_altin.getHeight()/3,this);
               }
               if(harita[i][j]==15){
                   
                   g.drawImage(onbes_altin,j*30,i*30,onbes_altin.getWidth()/3,onbes_altin.getHeight()/3,this);
               }
               if(harita[i][j]==20){
                   
                   g.drawImage(yirmi_altin,j*30,i*30,yirmi_altin.getWidth()/3,yirmi_altin.getHeight()/3,this);
               }
               else if(harita[i][j]==21){//player a
                   //g.setColor(Color.blue);
                  // g.fillRect(j*30, i*30, 30, 30);
                   g.drawImage(PLAYER_A,j*30,i*30,PLAYER_A.getWidth()/3,PLAYER_A.getHeight()/3,this);
   
               }
               else if(harita[i][j]==22){//player a
                   //g.setColor(Color.red);
                   //g.fillRect(j*30, i*30, 30, 30);
                   g.drawImage(PLAYER_B,j*30,i*30,PLAYER_B.getWidth()/3,PLAYER_B.getHeight()/3,this);
               }
               else if(harita[i][j]==23){//player a
                   //g.setColor(Color.red);
                   //g.fillRect(j*30, i*30, 30, 30);
                   g.drawImage(PLAYER_C,j*30,i*30,PLAYER_C.getWidth()/3,PLAYER_C.getHeight()/3,this);
               }
               else if(harita[i][j]==24){//player a
                   //g.setColor(Color.red);
                   //g.fillRect(j*30, i*30, 30, 30);
                   g.drawImage(PLAYER_D,j*30,i*30,PLAYER_D.getWidth()/3,PLAYER_D.getHeight()/3,this);
               }

            }
            
        }
        
        
        /*g.setColor(Color.orange);
        g.fillOval(7*30, 2*30, 30, 30);//y  x seklinde yaz
        */
        g.setColor(Color.blue);
        
        
        
        for (int i = 0; i < harita[0].length+1; i++) {
            g.drawLine(i*30,0 ,i*30 ,harita.length*30);
            
        }
        
        for (int i = 0; i < harita.length+1; i++) {
            g.drawLine(0,i*30 ,harita[0].length*30 ,i*30);
            
        }
        
        
    
    
    
    
    
    
    /*g.setColor(Color.red);
        for (int i = 0; i < engel_sayisi; i++) {
                 g.fillRect((array[i][0]-1)*30,(array[i][1]-1)*30 , 30,30);   
                    
            
        }*/
        
     //g.fillOval((i-1)*30+10,(i-1)*30+10 , 30,30);
    }
        
        
        
    
      
   
      
    
    
    
    
    
    
    
    
    }
    
        
        
        
        

    
     
            
        

    
    
    
    

