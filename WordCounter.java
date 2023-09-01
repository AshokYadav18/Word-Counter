package codesoft_internship;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class WordCounter extends JFrame {

    private JTextArea txtArea;
    private JLabel counterLabel;
    private JLabel ans;

    public WordCounter() {
    	setVisible(true);
        setSize(350, 250);
        setTitle("Word Counter Page");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        userInterface();
    }

    private void userInterface() {
    	ans=new JLabel("Enter your text below: ");
        txtArea = new JTextArea();
        counterLabel = new JLabel(" ");

        JButton countBttn = new JButton("Count Words");
        JScrollPane scrollPane = new JScrollPane(txtArea);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.add(scrollPane, BorderLayout.CENTER);
        panel.add(countBttn, BorderLayout.SOUTH);

        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(panel, BorderLayout.CENTER);
        getContentPane().add(counterLabel, BorderLayout.SOUTH);
        getContentPane().add(ans, BorderLayout.NORTH);
        
        countBttn.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent ae) {
            	ans.setText("Enter your text below: ");
                String txt = txtArea.getText();
                int wordCount;
                if(txt.length()==0)
                	wordCount=0;
                else
                	 wordCount = countWords(txt);
                counterLabel.setText("Number of words in text: " + wordCount);
            }
        });
        
    }

    private int countWords(String str) {
        String[] words = str.trim().split("\\s+");
        return words.length;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                WordCounter app = new WordCounter();
                app.setVisible(true);
            }
        });
    }
}