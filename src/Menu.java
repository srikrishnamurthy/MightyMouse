/*
 * Copyright 2015 Srinidhi Krishnamurthy
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

import javax.swing.*;

import org.opencv.core.Core;

import java.awt.*;
import java.awt.Graphics;
public class Menu extends JPanel
{
	//for the jar file -_-
   private static final long serialVersionUID = 1L;
   static JFrame frame;
   private JPanel Display;
   private ImageIcon background;
   public Menu(){
      background = new ImageIcon(getClass().getResource("menu.png"));
      //
      setLayout(new BorderLayout());
      //Title
      JLabel Title = new JLabel("Mighty Mouse's Daring Escape", SwingConstants.CENTER);
      Title.setFont(new Font("Verdana", Font.BOLD, 30));
      Title.setForeground(Color.YELLOW);
      Title.setOpaque(true);
      Title.setBackground(Color.RED);
      add(Title,BorderLayout.NORTH);
      //Buttons
      Display = new Display(frame);
      add(Display, BorderLayout.EAST);
      //
      
      }
   public void paintComponent(Graphics g) {
     g.drawImage(background.getImage(),0,50,683,713,null);
   }
      public static void main(String[] args)
   {
      frame = new JFrame("Mighty Mouse's Daring Escape!");
      frame.setSize(800, 800);
      frame.setLocation(100, 50);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setContentPane(new Menu());
      frame.setVisible(true);
      System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
      
      //Running the class using an EventQueue
      EventQueue.invokeLater(new Runnable() {
          public void run() {
              new FaceDetection().setVisible(true);
          }
      });
      
   }
}      
