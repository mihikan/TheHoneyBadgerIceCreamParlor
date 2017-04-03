/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tempproj;

/**
 *
 * @author Mihika
 */

import java.awt.Dimension;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.*;

public class JFileChooserDemo extends JFrame {

	private static final long serialVersionUID = 1L;

	public void go()
	{
		this.setPreferredSize(new Dimension(800,600));
		this.setSize(new Dimension(800,600));
                this.setLocationRelativeTo(null);
		//this.setLocation(new Point(0,0));
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JTextField tf=new JTextField();
		//tf.setInputVerifier(inputVerifier);
		
		
	}
	
	
        @SuppressWarnings("OverridableMethodCallInConstructor")
	public JFileChooserDemo() {
		// TODO Auto-generated method stub
		
		this.go();
	}

	public ArrayList<String> doFileChooser() {
		JFileChooser loader=new JFileChooser(".");
                @SuppressWarnings("UnusedAssignment")
		int result=0;
		result=loader.showDialog(this, "OK");
		ArrayList<String> data = new ArrayList<>();

		if (result==0)
		{
			
			
			File fp=loader.getSelectedFile();

                        
			//Create a Scanner Here
			//Create a formatter Here
			//Load image here.
			try
			{
				Scanner scanner=new Scanner(fp);
				String line;
				String [] tokens;
				while(scanner.hasNextLine())
				{
					line=scanner.nextLine();
					data.add(line);
				}
			}
			catch(FileNotFoundException e)
			{
				System.err.println("Sorry, File not found.");
			}
		}
		else
		{
			System.out.println("Action Cancelled");
		}

		return data;
	}
		
		
		
	}
