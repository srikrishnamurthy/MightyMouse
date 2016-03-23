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
import java.awt.*;
import java.awt.event.*;
public class Display extends JPanel
{
	//for the jar file -_-
	private static final long serialVersionUID = 1L;
   private JFrame menuFrame, instructionsFrame, gameFrame;
   public Display(JFrame jk){
      menuFrame = jk;
      setLayout(new GridLayout(3,1));
      
      JButton play = new JButton("Play!");
      play.addActionListener(
            new ActionListener(){
               public void actionPerformed(ActionEvent e){
                //hide menu frame
                  menuFrame.setVisible(false);
                //show instructions frame, or make a new one if it doesn't exist yet
                  if(gameFrame == null){
                     gameFrame = new JFrame("Game");
                     gameFrame.setVisible(true);
                     gameFrame.setLocation(100, 50);
                     gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                     gameFrame.setSize(600,900);
                     gameFrame.setContentPane(new GamePanel(menuFrame,gameFrame));//instructions panel needs to know the frames!;  }                           
                }
                  else
                	  gameFrame.setVisible(true); 
               }
            }
            );
      add(play, BorderLayout.EAST);
                
      JButton instructions = new JButton("Instructions");
      instructions.addActionListener(
            new ActionListener(){
               public void actionPerformed(ActionEvent e){
                //hide menu frame
                  menuFrame.setVisible(false);
                //show instructions frame, or make a new one if it doesn't exist yet
                  if(instructionsFrame == null){
                     instructionsFrame = new JFrame("Instructions");
                     instructionsFrame.setVisible(true);
                     instructionsFrame.setLocation(100, 50);
                     instructionsFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                     instructionsFrame.setContentPane(new instructions(menuFrame, instructionsFrame));//instructions panel needs to know the frames!
                     instructionsFrame.setSize(550,500);  }            
                  else
                     instructionsFrame.setVisible(true);
                     
               }
            });
      add(instructions);
      
      JButton quit = new JButton("Quit");
      quit.addActionListener(
            new ActionListener(){
               public void actionPerformed(ActionEvent e){
                  System.exit(0);
               }
            });
      add(quit);   
   }
}