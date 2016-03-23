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
public class instructions extends JPanel
{
	//the jar file... again -----_____------
   private static final long serialVersionUID = 1L;
   private JFrame menuFrame, instructionsFrame;
   public instructions(JFrame jk, JFrame kj){
      menuFrame = jk;
      instructionsFrame = kj;
      setLayout(new BorderLayout());
      //Title
      JLabel Title = new JLabel("Instructions", SwingConstants.CENTER);
      Title.setFont(new Font("Verdana", Font.BOLD, 40));
      Title.setForeground(Color.YELLOW);
      Title.setOpaque(true);
      Title.setBackground(Color.RED);
      add(Title,BorderLayout.NORTH);
      //Instructions
      JTextArea box = new JTextArea("To play this game, just make sure you followthese rules:\n" 
                                  + "1. Arrow keys/StartButton on the other panel to control Mouse\n" 
                                  + "2. Platform yourself up by using the cheese blocks to bounce\n"
                                  + "3. Make sure not to hit the bottom\n"
                                  + "4. Have Fun!");
      box.setLineWrap(true);
      box.setFont(new Font("Serif", Font.PLAIN, 30));
      add(box,BorderLayout.CENTER);
      //Back
      JButton cButton = new JButton("Back");
      cButton.addActionListener(new backListener());
      add(cButton, BorderLayout.SOUTH);
   }
   private class backListener implements ActionListener{
      public void actionPerformed(ActionEvent e){
         menuFrame.setVisible(true);
         instructionsFrame.setVisible(false);  
      }
   }
}
