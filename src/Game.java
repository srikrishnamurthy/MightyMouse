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

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class Game implements Runnable {
	
   public static JLabel scores;
   
   //for the jar file
   @SuppressWarnings("unused")
   private ImageIcon background;
   
   //for the jar file
   @SuppressWarnings("unused")
   private ImageIcon cat;

   public void run() {
      // Top-level frame
      final JFrame frame = new JFrame("Mighty Mouse's daring escape!");
      frame.setLocation(300,100);
      background = new ImageIcon(getClass().getResource("kitchen.jpg"));
      cat = new ImageIcon(getClass().getResource("Picture1.png"));
      ImageIcon hoovy = new ImageIcon(getClass().getResource("Hoovy.png"));
      frame.setIconImage(hoovy.getImage());
      // Main playing area
      final PongCourt court = new PongCourt();
      frame.add(court, BorderLayout.CENTER);
      
      //instructions
      final JWindow w1 = new JWindow();
      w1.setSize(500, 200);
      w1.setBackground(Color.WHITE);
      w1.setLocation(350, 200);
      JTextPane textPane = new JTextPane();
      textPane.setBackground(Color.GREEN);
      w1.add(textPane);
      //countdown
      final JWindow w2 = new JWindow();
      w2.setSize(500, 200);
      w2.setBackground(Color.GREEN);
      w2.setLocation(350, 200);
      JTextPane textPane2 = new JTextPane();
      textPane2.setBackground(Color.GREEN);
      textPane2.setText("3");
      w2.add(textPane2);
      
      final JWindow w3 = new JWindow();
      w3.setSize(500, 200);
      w3.setBackground(Color.WHITE);
      w3.setLocation(350, 200);
      JTextPane textPane3 = new JTextPane();
      textPane3.setBackground(Color.GREEN);
      textPane3.setText("2");
      w3.add(textPane3);
      
      final JWindow w4 = new JWindow();
      w4.setSize(500, 200);
      w4.setBackground(Color.BLUE);
      w4.setLocation(350, 200);
      JTextPane textPane4 = new JTextPane();
      textPane4.setBackground(Color.GREEN);
      textPane4.setText("1");
      w4.add(textPane4);
     //resume game button
      final JButton resume= new JButton("Resume game");
      resume.addActionListener(
            new ActionListener(){
               public void actionPerformed(ActionEvent e){
               w1.setVisible(false);
                  try {
                     w2.setVisible(true);
                     Thread.sleep(1000);
                     w2.setVisible(false);
                     w3.setVisible(true);
                     Thread.sleep(1000);
                     w3.setVisible(false);
                     w4.setVisible(true);
                     Thread.sleep(1000);
                     w4.setVisible(false);
                     court.restartTimer(); 
                     court.requestFocus();
                     resume.setVisible(false);
                  } 
                  catch (InterruptedException e1) {
                     e1.printStackTrace();
                  }
               }
            });
      
      //Instruction button
      final JPanel panel = new JPanel();
      frame.add(panel, BorderLayout.NORTH);
      final JButton instructions= new JButton("Instructions");
      instructions.addActionListener(
            new ActionListener(){
               public void actionPerformed(ActionEvent e){
                  court.stopTimer();
                  w1.setVisible(true);
                  resume.setVisible(true);
               }
            });      
      
      // Reset button
      final JButton reset = new JButton("New Game");
      reset.addActionListener(
            new ActionListener() {
               public void actionPerformed(ActionEvent e) {
                  court.startTimer();
                  court.reset();
               }
            });
      panel.add(resume);
      resume.setVisible(false);
      panel.add(instructions);
      panel.add(reset);
     
      scores= new JLabel();
      
      scores.setText("Score " + court.score);
      panel.add(scores);
      
      frame.pack();
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setVisible(true);
   
      court.reset();
   }

   public static void main(String[] args) {
      SwingUtilities.invokeLater(new Game());
   }

}
