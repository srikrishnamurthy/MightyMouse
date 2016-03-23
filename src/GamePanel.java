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

public class GamePanel extends JPanel {
	//for the jar file 0-0 
   private static final long serialVersionUID = 1L;
   public static JLabel scores;
   private JFrame menuFrame, contentFrame;
   private PongCourt court;
   public GamePanel(JFrame jk, JFrame kj) {
	  menuFrame = jk;
	  contentFrame = kj;
      setLayout(new BorderLayout());
      court = new PongCourt();
      add(court, BorderLayout.CENTER);
      
      JPanel panel = new JPanel();
      add(panel, BorderLayout.NORTH);

      final JButton reset = new JButton("New Game");
      reset.addActionListener(
            new ActionListener() {
               public void actionPerformed(ActionEvent e) {
                  court.startTimer();
                  court.reset();
               }
            });
      panel.add(reset);
            
      
      final JButton back = new JButton("Back");
      back.addActionListener(
            new ActionListener() {
               public void actionPerformed(ActionEvent e) {
            	  contentFrame.setVisible(false);
                  contentFrame = null;
                  menuFrame.setVisible(true);
               }
            });
      panel.add(back);
      
      scores= new JLabel();
      
      scores.setText("Score " + court.score);
      panel.add(scores);
      
      court.reset();
   }
   public void reset(){
	   court.startTimer();
	   court.reset();
   }   
   }

