package application;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedReader;
import java.io.File;
import java.awt.GridLayout;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Calendar;
import java.util.Scanner;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.border.Border;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import javax.swing.text.html.HTMLDocument;
import javax.swing.text.html.HTMLEditorKit;

public class Main {
	public static JFrame frame;
	public static JButton UpdatePlanbtn;
	
	// Mood Calendar
	static Calendar date = Calendar.getInstance();
	static int yearMood = date.get(Calendar.YEAR);
    static int monthMood = date.get(Calendar.MONTH) + 1;

	/* Create the application. */
	public Main() {
		initialize();
	}

	public static void initialize() {
		Audio audio = new Audio("schedule-initial");
		
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		
		frame.setTitle("Knu Daily, Kaily");
		
		ImageIcon clickTracker = new ImageIcon("./data/images/Icon/Tracker_click_line.png");
		ImageIcon clickPlan = new ImageIcon("./data/images/Icon/Plan_click_line.png");
		ImageIcon clickMood = new ImageIcon("./data/images/Icon/Mood_click_line.png");
		
		ImagePanel startPanel = new ImagePanel(new ImageIcon("./data/images/panel_page/Kaily_start.png").getImage());
		ImagePanel menuPanel = new ImagePanel(new ImageIcon("./data/images/panel_page/Kaily_menu.png").getImage());
		ImagePanel MoodPanel = new ImagePanel(new ImageIcon("./data/images/panel_page/MoodPanel.png").getImage());
		ImagePanel TrackerPanel = new ImagePanel(new ImageIcon("./data/images/panel_page/TrackerPanel.png").getImage());
		ImagePanel monthlyTrackerPanel = new ImagePanel(new ImageIcon("./data/images/panel_page/Tracker_monthly_panel.png").getImage());
		ImagePanel dailyTrackerPanel = new ImagePanel(new ImageIcon("./data/images/panel_page/Tracker_daily_panel.png").getImage());
		ImagePanel PlanPanel =  new ImagePanel(new ImageIcon("./data/images/panel_page/PlanPanel.png").getImage());
		
		ImageIcon PlayIcon = new ImageIcon("./data/images/Icon/play.png");
		ImageIcon PauseIcon = new ImageIcon("./data/images/Icon/Pause.png");

		JButton plangoToMenubtn = new JButton("");
		JButton AddPlanbtn = new JButton("");
		JButton goToMenu = new JButton(" 뜝 럥堉ｅ뜝 럥六욕뜝 럩踰   뜝 럥由 占쎈쇀占쎈  뜝 룞 삕  뜝 럥留숋옙 쇊占쎄섰 뇡占썲뜝 럥裕  占쎈쑏熬곣뫕 맋, Kaily.");
		JButton Planbtn = new JButton("");
		JButton Trackerbtn = new JButton("");
		JButton Moodbtn = new JButton("");
		JButton trackergoToMenubtn = new JButton("");
		JButton goToDailyTrackerbtn = new JButton("");
		JButton goToMonthlyTracker = new JButton("");
		JButton monthlyToTracker = new JButton("");
		JButton dailyToTracker = new JButton("");
		JTextPane PlanPrintPanel = new JTextPane();
		UpdatePlanbtn = new JButton("");
		JButton Deletebtn = new JButton("");
		JButton Backbtn = new JButton("");
		JButton Playbtn = new JButton("");
		JButton Forwardbtn = new JButton("");
		
		AddPlanbtn.setIcon(new ImageIcon("./data/images/Icon/Add.png"));
		Planbtn.setIcon(new ImageIcon("./data/images/Icon/Plan.png"));
		Trackerbtn.setIcon(new ImageIcon("./data/images/Icon/Tracker.png"));
		Moodbtn.setIcon(new ImageIcon("./data/images/Icon/Mood.png"));
		Deletebtn.setIcon(new ImageIcon("./data/images/Icon/delete.png"));
		Backbtn.setIcon(new ImageIcon("./data/images/Icon/back.png"));
		Forwardbtn.setIcon(new ImageIcon("./data/images/Icon/fast-forward.png"));
		UpdatePlanbtn.setIcon(new ImageIcon("./data/images/Icon/Update.png"));
		
//		ImageIcon clickTracker = new ImageIcon("/Users/ellie/Desktop/2021-java-programming/data/images/Icon/Tracker_click_line.png");
//		ImageIcon clickPlan = new ImageIcon("/Users/ellie/Desktop/2021-java-programming/data/images/Icon/Plan_click_line.png");
//		ImageIcon clickMood = new ImageIcon("/Users/ellie/Desktop/2021-java-programming/data/images/Icon/Mood_click_line.png");
//		ImagePanel startPanel = new ImagePanel(new ImageIcon("/Users/ellie/Desktop/2021-java-programming/data/images/panel_page/Kaily_start.png").getImage());
//		ImagePanel menuPanel = new ImagePanel(new ImageIcon("/Users/ellie/Desktop/2021-java-programming/data/images/panel_page/Kaily_menu.png").getImage());
//		ImagePanel TrackerPanel = new ImagePanel(new ImageIcon("/Users/ellie/Desktop/2021-java-programming/data/images/panel_page/TrackerPanel.png").getImage());
//		ImagePanel monthlyTrackerPanel = new ImagePanel(new ImageIcon("/Users/ellie/Desktop/2021-java-programming/data/images/panel_page/Tracker_monthly_panel.png").getImage());
//		ImagePanel dailyTrackerPanel = new ImagePanel(new ImageIcon("/Users/ellie/Desktop/2021-java-programming/data/images/panel_page/Tracker_daily_panel.png").getImage());
//		ImagePanel PlanPanel = new ImagePanel(new ImageIcon("/Users/ellie/Desktop/2021-java-programming/data/images/panel_page/PlanPanel.png").getImage());
//		ImageIcon PlayIcon = new ImageIcon("/Users/ellie/Desktop/2021-java-programming/data/images/Icon/play.png");
//		ImageIcon PauseIcon = new ImageIcon("/Users/ellie/Desktop/2021-java-programming/data/images/Icon/Pause.png");
//		ImagePanel MoodPanel = new ImagePanel(new ImageIcon("/Users/ellie/Desktop/2021-java-programming/data/images/panel_page/MoodPanel.png").getImage());
//		
//		AddPlanbtn.setIcon(new ImageIcon("/Users/ellie/Desktop/2021-java-programming/data/images/Icon/Add.png"));
//		Planbtn.setIcon(new ImageIcon("/Users/ellie/Desktop/2021-java-programming/data/images/Icon/Plan.png"));
//		Trackerbtn.setIcon(new ImageIcon("/Users/ellie/Desktop/2021-java-programming/data/images/Icon/Tracker.png"));
//		Moodbtn.setIcon(new ImageIcon("/Users/ellie/Desktop/2021-java-programming/data/images/Icon/Mood.png"));
//		Deletebtn.setIcon(new ImageIcon("/Users/ellie/Desktop/2021-java-programming/data/images/Icon/delete.png"));
//		Backbtn.setIcon(new ImageIcon("/Users/ellie/Desktop/2021-java-programming/data/images/Icon/back.png"));
//		Forwardbtn.setIcon(new ImageIcon("/Users/ellie/Desktop/2021-java-programming/data/images/Icon/fast-forward.png"));
//		UpdatePlanbtn.setIcon(new ImageIcon("/Users/ellie/Desktop/2021-java-programming/data/images/Icon/Update.png"));		
		
		menuPanel.setVisible(false);
		TrackerPanel.setVisible(false);
		monthlyTrackerPanel.setVisible(false);
		dailyTrackerPanel.setVisible(false);
		
		PlanPanel.setVisible(false);
		JButton moodgoToMenubtn = new JButton("");
		
		MoodPanel.setVisible(false);
		frame.getContentPane().add(MoodPanel);
		
		moodgoToMenubtn.setBounds(1214, 22, 48, 46);
		moodgoToMenubtn.setBorderPainted(false);
		moodgoToMenubtn.setContentAreaFilled(false);
		MoodPanel.add(moodgoToMenubtn);
		
		moodgoToMenubtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				MoodPanel.setVisible(false);
				menuPanel.setVisible(true);
			}	
		});
		
		// Create MonthPanel to use moodPanel
		
		Font MoodbtnFont = new Font("나눔고딕", Font.PLAIN, 70);		// Set button font
		
		// All Day Button
		JButton MonthBtn[][] = new JButton[12][];
		
		
		
		
		// Month : 1 (Panel)
		JPanel MoodMonth01 = new JPanel();
		MoodMonth01.setBounds(172, 129, 924, 500);
		MoodMonth01.setBackground(Color.white);
		MoodPanel.add(MoodMonth01);
		MoodMonth01.setVisible(false);
		MonthBtn[0] = new JButton[31];
		
		for (int i = 0 ; i < MonthBtn[0].length; i++) {
			if (i <= 8)
				MonthBtn[0][i] = new JButton(String.format("0%d", i + 1));
			else
				MonthBtn[0][i] = new JButton(String.format("%d", i + 1));
			
			MonthBtn[0][i].setFont(MoodbtnFont);
			MonthBtn[0][i].setBorderPainted(false);
			MonthBtn[0][i].setContentAreaFilled(false);
			MonthBtn[0][i].setForeground(new Color(200, 200, 200));
			MoodMonth01.add(MonthBtn[0][i]);
			if(i <= 8)
				MonthBtn[0][i].addActionListener(new MyActionListener("010" + Integer.toString(i + 1)));
			else
				MonthBtn[0][i].addActionListener(new MyActionListener("01" + Integer.toString(i + 1)));
		}
		
		
		// Month : 2 (Panel)
		JPanel MoodMonth02 = new JPanel();
		MoodMonth02.setBounds(172, 129, 924, 500);
		MoodMonth02.setBackground(Color.white);
		MoodPanel.add(MoodMonth02);
		MoodMonth02.setVisible(false);
		MonthBtn[1] = new JButton[28];
		
		for (int i = 0 ; i < MonthBtn[1].length; i++) {
			if (i <= 8)
				MonthBtn[1][i] = new JButton(String.format("0%d", i + 1));
			else
				MonthBtn[1][i] = new JButton(String.format("%d", i + 1));
			
			MonthBtn[1][i].setFont(MoodbtnFont);
			MonthBtn[1][i].setBorderPainted(false);
			MonthBtn[1][i].setContentAreaFilled(false);
			MonthBtn[1][i].setForeground(new Color(200, 200, 200));
			MoodMonth02.add(MonthBtn[1][i]);
			if(i <= 8)
				MonthBtn[1][i].addActionListener(new MyActionListener("020" + Integer.toString(i + 1)));
			else
				MonthBtn[1][i].addActionListener(new MyActionListener("02" + Integer.toString(i + 1)));
		}
		
		
		// Month : 3 (Panel)
		JPanel MoodMonth03 = new JPanel();
		MoodMonth03.setBounds(172, 129, 924, 500);
		MoodMonth03.setBackground(Color.white);
		MoodPanel.add(MoodMonth03);
		MoodMonth03.setVisible(false);
		MonthBtn[2] = new JButton[31];
		
		for (int i = 0 ; i < MonthBtn[2].length; i++) {
			if (i <= 8)
				MonthBtn[2][i] = new JButton(String.format("0%d", i + 1));
			else
				MonthBtn[2][i] = new JButton(String.format("%d", i + 1));
			
			MonthBtn[2][i].setFont(MoodbtnFont);
			MonthBtn[2][i].setBorderPainted(false);
			MonthBtn[2][i].setContentAreaFilled(false);
			MonthBtn[2][i].setForeground(new Color(200, 200, 200));
			MoodMonth03.add(MonthBtn[2][i]);
			if(i <= 8)
				MonthBtn[2][i].addActionListener(new MyActionListener("030" + Integer.toString(i + 1)));
			else
				MonthBtn[2][i].addActionListener(new MyActionListener("03" + Integer.toString(i + 1)));
		}
		
		
		// Month : 4 (Panel)
		JPanel MoodMonth04 = new JPanel();
		MoodMonth04.setBounds(172, 129, 924, 500);
		MoodMonth04.setBackground(Color.white);
		MoodPanel.add(MoodMonth04);
		MoodMonth04.setVisible(false);
		MonthBtn[3] = new JButton[30];
		
		for (int i = 0 ; i < MonthBtn[3].length; i++) {
			if (i <= 8)
				MonthBtn[3][i] = new JButton(String.format("0%d", i + 1));
			else
				MonthBtn[3][i] = new JButton(String.format("%d", i + 1));
			
			MonthBtn[3][i].setFont(MoodbtnFont);
			MonthBtn[3][i].setBorderPainted(false);
			MonthBtn[3][i].setContentAreaFilled(false);
			MonthBtn[3][i].setForeground(new Color(200, 200, 200));
			MoodMonth04.add(MonthBtn[3][i]);
			if(i <= 8)
				MonthBtn[3][i].addActionListener(new MyActionListener("040" + Integer.toString(i + 1)));
			else
				MonthBtn[3][i].addActionListener(new MyActionListener("04" + Integer.toString(i + 1)));
			
		}
		
		
		// Month : 5 (Panel)
		JPanel MoodMonth05 = new JPanel();
		MoodMonth05.setBounds(172, 129, 924, 500);
		MoodMonth05.setBackground(Color.white);
		MoodPanel.add(MoodMonth05);
		MoodMonth05.setVisible(false);
		MonthBtn[4] = new JButton[31];
		
		for (int i = 0 ; i < MonthBtn[4].length; i++) {
			if (i <= 8)
				MonthBtn[4][i] = new JButton(String.format("0%d", i + 1));
			else
				MonthBtn[4][i] = new JButton(String.format("%d", i + 1));
			
			MonthBtn[4][i].setFont(MoodbtnFont);
			MonthBtn[4][i].setBorderPainted(false);
			MonthBtn[4][i].setContentAreaFilled(false);
			MonthBtn[4][i].setForeground(new Color(200, 200, 200));
			MoodMonth05.add(MonthBtn[4][i]);
			if(i <= 8)
				MonthBtn[4][i].addActionListener(new MyActionListener("050" + Integer.toString(i + 1)));
			else
				MonthBtn[4][i].addActionListener(new MyActionListener("05" + Integer.toString(i + 1)));
			
		}
		
		
		// Month : 6 (Panel)
		JPanel MoodMonth06 = new JPanel();
		MoodMonth06.setBounds(172, 129, 924, 500);
		MoodMonth06.setBackground(Color.white);
		MoodPanel.add(MoodMonth06);
		MoodMonth06.setVisible(false);
		MonthBtn[5] = new JButton[30];
		
		for (int i = 0 ; i < MonthBtn[5].length; i++) {
			if (i <= 8)
				MonthBtn[5][i] = new JButton(String.format("0%d", i + 1));
			else
				MonthBtn[5][i] = new JButton(String.format("%d", i + 1));
			
			MonthBtn[5][i].setFont(MoodbtnFont);
			MonthBtn[5][i].setBorderPainted(false);
			MonthBtn[5][i].setContentAreaFilled(false);
			MonthBtn[5][i].setForeground(new Color(200, 200, 200));
			MoodMonth06.add(MonthBtn[5][i]);
			if(i <= 8)
				MonthBtn[5][i].addActionListener(new MyActionListener("060" + Integer.toString(i + 1)));
			else
				MonthBtn[5][i].addActionListener(new MyActionListener("06" + Integer.toString(i + 1)));
			
		}

		
		// Month : 7 (Panel)
		JPanel MoodMonth07 = new JPanel();
		MoodMonth07.setBounds(172, 129, 924, 500);
		MoodMonth07.setBackground(Color.white);
		MoodPanel.add(MoodMonth07);
		MoodMonth07.setVisible(false);
		MonthBtn[6] = new JButton[31];
		
		for (int i = 0 ; i < MonthBtn[6].length; i++) {
			if (i <= 8)
				MonthBtn[6][i] = new JButton(String.format("0%d", i + 1));
			else
				MonthBtn[6][i] = new JButton(String.format("%d", i + 1));
			
			MonthBtn[6][i].setFont(MoodbtnFont);
			MonthBtn[6][i].setBorderPainted(false);
			MonthBtn[6][i].setContentAreaFilled(false);
			MonthBtn[6][i].setForeground(new Color(200, 200, 200));
			MoodMonth07.add(MonthBtn[6][i]);
			if(i <= 8)
				MonthBtn[6][i].addActionListener(new MyActionListener("070" + Integer.toString(i + 1)));
			else
				MonthBtn[6][i].addActionListener(new MyActionListener("07" + Integer.toString(i + 1)));
		}
		
		
		
		// Month : 8 (Panel)
		JPanel MoodMonth08 = new JPanel();
		MoodMonth08.setBounds(172, 129, 924, 500);
		MoodMonth08.setBackground(Color.white);
		MoodPanel.add(MoodMonth08);
		MoodMonth08.setVisible(false);
		MonthBtn[7] = new JButton[31];
		
		for (int i = 0 ; i < MonthBtn[7].length; i++) {
			if (i <= 8)
				MonthBtn[7][i] = new JButton(String.format("0%d", i + 1));
			else
				MonthBtn[7][i] = new JButton(String.format("%d", i + 1));
			
			MonthBtn[7][i].setFont(MoodbtnFont);
			MonthBtn[7][i].setBorderPainted(false);
			MonthBtn[7][i].setContentAreaFilled(false);
			MonthBtn[7][i].setForeground(new Color(200, 200, 200));
			MoodMonth08.add(MonthBtn[7][i]);
			if(i <= 8)
				MonthBtn[7][i].addActionListener(new MyActionListener("080" + Integer.toString(i + 1)));
			else
				MonthBtn[7][i].addActionListener(new MyActionListener("08" + Integer.toString(i + 1)));
		}
		
		
		
		// Month : 9 (Panel)
		JPanel MoodMonth09 = new JPanel();
		MoodMonth09.setBounds(172, 129, 924, 500);
		MoodMonth09.setBackground(Color.white);
		MoodPanel.add(MoodMonth09);
		MoodMonth09.setVisible(false);
		MonthBtn[8] = new JButton[30];
		
		for (int i = 0 ; i < MonthBtn[8].length; i++) {
			if (i <= 8)
				MonthBtn[8][i] = new JButton(String.format("0%d", i + 1));
			else
				MonthBtn[8][i] = new JButton(String.format("%d", i + 1));
			
			MonthBtn[8][i].setFont(MoodbtnFont);
			MonthBtn[8][i].setBorderPainted(false);
			MonthBtn[8][i].setContentAreaFilled(false);
			MonthBtn[8][i].setForeground(new Color(200, 200, 200));
			MoodMonth09.add(MonthBtn[8][i]);
			if(i <= 8)
				MonthBtn[8][i].addActionListener(new MyActionListener("090" + Integer.toString(i + 1)));
			else
				MonthBtn[8][i].addActionListener(new MyActionListener("09" + Integer.toString(i + 1)));
		}
		
		
		
		
		// Month : 10 (Panel)
		JPanel MoodMonth10 = new JPanel();
		MoodMonth10.setBounds(172, 129, 924, 500);
		MoodMonth10.setBackground(Color.white);
		MoodPanel.add(MoodMonth10);
		MoodMonth10.setVisible(false);
		MonthBtn[9] = new JButton[31];
		
		for (int i = 0 ; i < MonthBtn[9].length; i++) {
			if (i <= 8)
				MonthBtn[9][i] = new JButton(String.format("0%d", i + 1));
			else
				MonthBtn[9][i] = new JButton(String.format("%d", i + 1));
			
			MonthBtn[9][i].setFont(MoodbtnFont);
			MonthBtn[9][i].setBorderPainted(false);
			MonthBtn[9][i].setContentAreaFilled(false);
			MonthBtn[9][i].setForeground(new Color(200, 200, 200));
			MoodMonth10.add(MonthBtn[9][i]);
			if(i <= 8)
				MonthBtn[9][i].addActionListener(new MyActionListener("100" + Integer.toString(i + 1)));
			else
				MonthBtn[9][i].addActionListener(new MyActionListener("10" + Integer.toString(i + 1)));
		}
		
		
		
		// Month : 11 (Panel)
		JPanel MoodMonth11 = new JPanel();
		MoodMonth11.setBounds(172, 129, 924, 500);
		MoodMonth11.setBackground(Color.white);
		MoodPanel.add(MoodMonth11);
		MoodMonth11.setVisible(false);
		MonthBtn[10] = new JButton[30];
		
		for (int i = 0 ; i < MonthBtn[10].length; i++) {
			if (i <= 8)
				MonthBtn[10][i] = new JButton(String.format("0%d", i + 1));
			else
				MonthBtn[10][i] = new JButton(String.format("%d", i + 1));
			
			MonthBtn[10][i].setFont(MoodbtnFont);
			MonthBtn[10][i].setBorderPainted(false);
			MonthBtn[10][i].setContentAreaFilled(false);
			MonthBtn[10][i].setForeground(new Color(200, 200, 200));
			MoodMonth11.add(MonthBtn[10][i]);
			if(i <= 8)
				MonthBtn[10][i].addActionListener(new MyActionListener("110" + Integer.toString(i + 1)));
			else
				MonthBtn[10][i].addActionListener(new MyActionListener("11" + Integer.toString(i + 1)));
		}
		
		
		
		// Month : 12 (Panel)
		JPanel MoodMonth12 = new JPanel();
		MoodMonth12.setBounds(172, 129, 924, 500);
		MoodMonth12.setBackground(Color.white);
		MoodPanel.add(MoodMonth12);
		MoodMonth12.setVisible(false);
		MonthBtn[11] = new JButton[31];
		
		for (int i = 0 ; i < MonthBtn[11].length; i++) {
			if (i <= 8)
				MonthBtn[11][i] = new JButton(String.format("0%d", i + 1));
			else
				MonthBtn[11][i] = new JButton(String.format("%d", i + 1));
			
			MonthBtn[11][i].setFont(MoodbtnFont);
			MonthBtn[11][i].setBorderPainted(false);
			MonthBtn[11][i].setContentAreaFilled(false);
			MonthBtn[11][i].setForeground(new Color(200, 200, 200));
			MoodMonth12.add(MonthBtn[11][i]);
			if(i <= 8)
				MonthBtn[11][i].addActionListener(new MyActionListener("120" + Integer.toString(i + 1)));
			else
				MonthBtn[11][i].addActionListener(new MyActionListener("12" + Integer.toString(i + 1)));
		}
		
		// if Mood save DB, then icon is image
		String path = "./data/moodDB";
		File dir = new File(path);
		File []fileList = dir.listFiles();
		for(File file : fileList) {
			if(file.isFile()) {
				String fileName = file.getName();
				
				File moodFile = new File(path+"/"+fileName);
				
				int Idx = fileName .lastIndexOf(".");
				String _fileName = fileName.substring(0, Idx );
	
				int changeMonth, changeDay;
				changeMonth = Integer.parseInt(_fileName) / 100;
				changeDay = Integer.parseInt(_fileName) - changeMonth * 100;
				
				try {
					FileReader filereadar = new FileReader(moodFile);
					
					BufferedReader bufReader = new BufferedReader(filereadar);
		            String line = "";
		            
		            while((line = bufReader.readLine()) != null) {
		            	switch(Integer.parseInt(line)) {
	            		case 0:
	            			MonthBtn[changeMonth - 1][changeDay - 1].setIcon(new ImageIcon("./data/images/Icon/mood/happy.png"));
	            			break;
	            		case 1:
	            			MonthBtn[changeMonth - 1][changeDay - 1].setIcon(new ImageIcon("./data/images/Icon/mood/good.png"));
	            			break;
	            		case 2:
	            			MonthBtn[changeMonth - 1][changeDay - 1].setIcon(new ImageIcon("./data/images/Icon/mood/tired.png"));
	            			break;
	            		case 3:
	            			MonthBtn[changeMonth - 1][changeDay - 1].setIcon(new ImageIcon("./data/images/Icon/mood/bad.png"));
	            			break;
	            		case 4:
	            			MonthBtn[changeMonth - 1][changeDay - 1].setIcon(new ImageIcon("./data/images/Icon/mood/sad.png"));
	            			break;
	            		case 5:
	            			MonthBtn[changeMonth - 1][changeDay - 1].setIcon(new ImageIcon("./data/images/Icon/mood/seck.png"));
	            			break;
	            		}
		            	
		            	MonthBtn[changeMonth - 1][changeDay - 1].setEnabled(false);
		            }
		            bufReader.close();							
				}
				catch (FileNotFoundException e1) {
					System.out.println(e1);
				}
				catch (IOException e1) {
					System.out.println(e1);
				}
			}
		}
		
		
		// Mood page Add Calendar (button, label)    
	    JLabel yearLB = new JLabel(Integer.toString(yearMood));
	    JLabel monthLB = new JLabel();
	    
	    if(monthMood - 10 < 0) {
	    	monthLB.setText("0" + Integer.toString(monthMood));	
	    }
	    else {
	    	monthLB.setText(Integer.toString(monthMood));
	    }
	    
	    JButton prevMonthBtn = new JButton("◀");
	    JButton nextMonthBtn = new JButton("▶");
	    
	    yearLB.setBounds(1127, 22, 100, 46);
	    yearLB.setFont(new Font("占쎄돌占쎈땸 ⑥쥓逾 ", Font.BOLD, 15));
	    
	    monthLB.setBounds(1126, 50, 50, 46);
	    monthLB.setFont(new Font("占쎄돌占쎈땸 ⑥쥓逾 ", Font.BOLD, 30));
	    
	    prevMonthBtn.setBounds(1070, 36, 70, 46);
	    prevMonthBtn.setBorderPainted(false);
	    prevMonthBtn.setContentAreaFilled(false);
	    prevMonthBtn.setFont(new Font("占쎄돌占쎈땸 ⑥쥓逾 ", Font.BOLD, 25));
	    
	    nextMonthBtn.setBounds(1147, 36, 70, 46);
	    nextMonthBtn.setBorderPainted(false);
	    nextMonthBtn.setContentAreaFilled(false);
	    nextMonthBtn.setFont(new Font("占쎄돌占쎈땸 ⑥쥓逾 ", Font.BOLD, 25));
	    
	    MoodPanel.add(yearLB);
	    MoodPanel.add(monthLB);
	    MoodPanel.add(prevMonthBtn);
	    MoodPanel.add(nextMonthBtn);
	    
	    
	    prevMonthBtn.addActionListener(new ActionListener() {
	    	@Override
	    	public void actionPerformed(ActionEvent e) {
	    		CloseOpenMonth(monthMood, false);
	    		
	    		PrevMonth prevMonth = new PrevMonth(yearMood, monthMood);
	    		
	    		yearMood = prevMonth.getYear();
	    		monthMood = prevMonth.getMonth();
	    		
	    		yearLB.setText(Integer.toString(yearMood));
	    		
	    		if(monthMood - 10 < 0) {
	    	    	monthLB.setText("0" + Integer.toString(monthMood));	
	    	    }
	    	    else {
	    	    	monthLB.setText(Integer.toString(monthMood));
	    	    }
	    		
	    		CloseOpenMonth(monthMood, true);
                
            }
	    	
	    	void CloseOpenMonth(int month, Boolean state) {
	    		switch(month) {
	    		case 1:
	    			MoodMonth01.setVisible(state);
	    			break;
	    		case 2:
	    			MoodMonth02.setVisible(state);
	    			break;
	    		case 3:
	    			MoodMonth03.setVisible(state);
	    			break;
	    		case 4:
	    			MoodMonth04.setVisible(state);
	    			break;
	    		case 5:
	    			MoodMonth05.setVisible(state);
	    			break;
	    		case 6:
	    			MoodMonth06.setVisible(state);
	    			break;
	    		case 7:
	    			MoodMonth07.setVisible(state);
	    			break;
	    		case 8:
	    			MoodMonth08.setVisible(state);
	    			break;
	    		case 9:
	    			MoodMonth09.setVisible(state);
	    			break;
	    		case 10:
	    			MoodMonth10.setVisible(state);
	    			break;
	    		case 11:
	    			MoodMonth11.setVisible(state);
	    			break;
	    		case 12:
	    			MoodMonth12.setVisible(state);
	    			break;
	    		}
	    	}
	    });
	    
	    nextMonthBtn.addActionListener(new ActionListener() {
	    	@Override
	    	public void actionPerformed(ActionEvent e) {
	    		CloseOpenMonth(monthMood, false);
	    		
	    		NextMonth nextMonth = new NextMonth(yearMood, monthMood);
	    		
	    		yearMood = nextMonth.getYear();
	    		monthMood = nextMonth.getMonth();
	    		
	    		yearLB.setText(Integer.toString(yearMood));
	    		
	    		if(monthMood - 10 < 0) {
	    	    	monthLB.setText("0" + Integer.toString(monthMood));	
	    	    }
	    	    else {
	    	    	monthLB.setText(Integer.toString(monthMood));
	    	    }
	    		
	    		CloseOpenMonth(monthMood, true);
	    	}
	    	
	    	void CloseOpenMonth(int month, Boolean state) {
	    		switch(month) {
	    		case 1:
	    			MoodMonth01.setVisible(state);
	    			break;
	    		case 2:
	    			MoodMonth02.setVisible(state);
	    			break;
	    		case 3:
	    			MoodMonth03.setVisible(state);
	    			break;
	    		case 4:
	    			MoodMonth04.setVisible(state);
	    			break;
	    		case 5:
	    			MoodMonth05.setVisible(state);
	    			break;
	    		case 6:
	    			MoodMonth06.setVisible(state);
	    			break;
	    		case 7:
	    			MoodMonth07.setVisible(state);
	    			break;
	    		case 8:
	    			MoodMonth08.setVisible(state);
	    			break;
	    		case 9:
	    			MoodMonth09.setVisible(state);
	    			break;
	    		case 10:
	    			MoodMonth10.setVisible(state);
	    			break;
	    		case 11:
	    			MoodMonth11.setVisible(state);
	    			break;
	    		case 12:
	    			MoodMonth12.setVisible(state);
	    			break;
	    		}
	    	}
	    });
	    
	 // Change Mood
	    JButton moodChange = new JButton("Change Mood");
	    moodChange.setBounds(950, 50, 120, 35);
	    moodChange.setBorderPainted(false);
	    moodChange.setBackground(new Color(255, 206, 92));
	    moodChange.setFont(new Font("나눔 고딕", Font.BOLD, 10));
	    MoodPanel.add(moodChange);
	    
	    moodChange.addActionListener(new ActionListener() {
	    	@Override
	    	public void actionPerformed(ActionEvent e) {
	    		String path = "./data/moodDB";
	    		File dir = new File(path);
	    		File []fileList = dir.listFiles();
	    		
	    		for(File file : fileList) {
	    			if(file.isFile()) {
	    				String fileName = file.getName();
	    				
	    				File moodFile = new File(path+"/"+fileName);
	    				
	    				int Idx = fileName .lastIndexOf(".");
	    				String _fileName = fileName.substring(0, Idx );

	    				int changeMonth, changeDay;
	    				changeMonth = Integer.parseInt(_fileName) / 100;
	    				changeDay = Integer.parseInt(_fileName) - changeMonth * 100;
	    				
	    				try {
							FileReader filereadar = new FileReader(moodFile);
							
							BufferedReader bufReader = new BufferedReader(filereadar);
				            String line = "";
				            
				            while((line = bufReader.readLine()) != null) {
				            	switch(Integer.parseInt(line)) {
			            		case 0:
			            			MonthBtn[changeMonth - 1][changeDay - 1].setIcon(new ImageIcon("./data/images/Icon/mood/happy.png"));
			            			break;
			            		case 1:
			            			MonthBtn[changeMonth - 1][changeDay - 1].setIcon(new ImageIcon("./data/images/Icon/mood/good.png"));
			            			break;
			            		case 2:
			            			MonthBtn[changeMonth - 1][changeDay - 1].setIcon(new ImageIcon("./data/images/Icon/mood/tired.png"));
			            			break;
			            		case 3:
			            			MonthBtn[changeMonth - 1][changeDay - 1].setIcon(new ImageIcon("./data/images/Icon/mood/bad.png"));
			            			break;
			            		case 4:
			            			MonthBtn[changeMonth - 1][changeDay - 1].setIcon(new ImageIcon("./data/images/Icon/mood/sad.png"));
			            			break;
			            		case 5:
			            			MonthBtn[changeMonth - 1][changeDay - 1].setIcon(new ImageIcon("./data/images/Icon/mood/seck.png"));
			            			break;
			            		}
				            	
				            	MonthBtn[changeMonth - 1][changeDay - 1].setEnabled(false);
				            }
				            bufReader.close();							
						}
	    				catch (FileNotFoundException e1) {
							System.out.println(e1);
						}
	    				catch (IOException e1) {
							System.out.println(e1);
						}
	    			}
	    		}
	    	}
	    });
	    
		frame.getContentPane().add(PlanPanel);
		PlanPanel.setLayout(null);
		
		plangoToMenubtn.setBounds(1215, 25, 48, 46);
		plangoToMenubtn.setBorderPainted(false);
		plangoToMenubtn.setContentAreaFilled(false);
		PlanPanel.add(plangoToMenubtn);
		
		plangoToMenubtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				PlanPanel.setVisible(false);
				menuPanel.setVisible(true);
			}	
		});

		AddPlanbtn.setBounds(365, 611, 61, 56);
		AddPlanbtn.setBorderPainted(false);
		PlanPanel.add(AddPlanbtn);
		
		AddPlanbtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new MakeAddPlanFrame();
			}
		});

		frame.getContentPane().add(startPanel);
		frame.getContentPane().add(menuPanel);
		frame.getContentPane().add(TrackerPanel);
		frame.getContentPane().add(dailyTrackerPanel);
		frame.getContentPane().add(monthlyTrackerPanel);
	
		frame.setSize(startPanel.getDim());
		frame.setPreferredSize(startPanel.getDim());

		goToMenu.setBounds(431, 402, 483, 71);
		startPanel.add(goToMenu);
		goToMenu.setBorderPainted(false);
		goToMenu.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				startPanel.setVisible(false);
				menuPanel.setVisible(true);
			}		
		});
		goToMenu.setFont(new Font(" 뜝 럡 룎 뜝 럥 빖 뜝 럥占썹뼨 먯삕 뜝 럥 럞  뤆 룊 삕 뜝 럩肉뷴뜝 럥 뿼占쎈빝 뜝占 ", Font.PLAIN, 24));
		
		Planbtn.setBorderPainted(false);

		Planbtn.setBounds(586, 58, 133, 84);
		Planbtn.setRolloverIcon(clickPlan);
		menuPanel.add(Planbtn);
		
		Planbtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				menuPanel.setVisible(false);
				PlanPanel.setVisible(true);
			}
		});
		
		Trackerbtn.setBorderPainted(false);

		Trackerbtn.setBounds(334, 484, 165, 63);
		Trackerbtn.setRolloverIcon(clickTracker);
		menuPanel.add(Trackerbtn);
		
		Trackerbtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				menuPanel.setVisible(false);
				TrackerPanel.setVisible(true);
			}
		});
		
		Moodbtn.setBorderPainted(false);

		Moodbtn.setBounds(809, 484, 165, 63);
		Moodbtn.setRolloverIcon(clickMood);
		menuPanel.add(Moodbtn);
		
		Moodbtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				menuPanel.setVisible(false);
				MoodPanel.setVisible(true);

				switch(monthMood) {
				case 1:
	    			MoodMonth01.setVisible(true);
	    			break;
	    		case 2:
	    			MoodMonth02.setVisible(true);
	    			break;
	    		case 3:
	    			MoodMonth03.setVisible(true);
	    			break;
	    		case 4:
	    			MoodMonth04.setVisible(true);
	    			break;
	    		case 5:
	    			MoodMonth05.setVisible(true);
	    			break;
	    		case 6:
	    			MoodMonth06.setVisible(true);
	    			break;
	    		case 7:
	    			MoodMonth07.setVisible(true);
	    			break;
	    		case 8:
	    			MoodMonth08.setVisible(true);
	    			break;
	    		case 9:
	    			MoodMonth09.setVisible(true);
	    			break;
	    		case 10:
	    			MoodMonth10.setVisible(true);
	    			break;
	    		case 11:
	    			MoodMonth11.setVisible(true);
	    			break;
	    		case 12:
	    			MoodMonth12.setVisible(true);
	    			break;
	    		}
			}
		});
		
		trackergoToMenubtn.setBounds(1213, 23, 48, 46);
		trackergoToMenubtn.setBorderPainted(false);
		trackergoToMenubtn.setContentAreaFilled(false);
		TrackerPanel.add(trackergoToMenubtn);
	
		trackergoToMenubtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				TrackerPanel.setVisible(false);
				menuPanel.setVisible(true);
			}	
		});
		
		goToDailyTrackerbtn.setBounds(224, 305, 193, 101);
		goToDailyTrackerbtn.setBorderPainted(false);
		goToDailyTrackerbtn.setContentAreaFilled(false);
		TrackerPanel.add(goToDailyTrackerbtn);
		
		goToDailyTrackerbtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				TrackerPanel.setVisible(false);
				dailyTrackerPanel.setVisible(true);
				
			}	
		});
		
		goToMonthlyTracker.setBounds(798, 305, 238, 101);
		goToMonthlyTracker.setBorderPainted(false);
		goToMonthlyTracker.setContentAreaFilled(false);
		TrackerPanel.add(goToMonthlyTracker);
		
		goToMonthlyTracker.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				TrackerPanel.setVisible(false);
				monthlyTrackerPanel.setVisible(true);
				
			}	
		});
		
		monthlyToTracker.setBounds(63, 357, 70, 60);
		monthlyToTracker.setBorderPainted(false);
		monthlyToTracker.setContentAreaFilled(false);
		monthlyTrackerPanel.add(monthlyToTracker);
		
		monthlyToTracker.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				monthlyTrackerPanel.setVisible(false);
				TrackerPanel.setVisible(true);
			}
		});
		
		dailyToTracker.setBounds(67, 366, 64, 48);
		dailyToTracker.setBorderPainted(false);
		dailyToTracker.setContentAreaFilled(false);
		dailyTrackerPanel.add(dailyToTracker);
		
		dailyToTracker.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dailyTrackerPanel.setVisible(false);
				TrackerPanel.setVisible(true);
			}
		});
		
		PlanPrintPanel.setContentType("text/html");
		PlanPrintPanel.setEditable(false);
		JScrollPane ScrollPrint = new JScrollPane(PlanPrintPanel) {
			public void setBorder(Border border) {
				
			}
		};
		ScrollPrint.setBounds(365, 90, 773, 509);
		
		PlanPrintPanel.setEditable(false);
		PlanPrintPanel.setBounds(336, 90, 790, 509);
		PlanPanel.add(ScrollPrint,BorderLayout.CENTER);
		
		StyledDocument doc = PlanPrintPanel.getStyledDocument();
		SimpleAttributeSet styleSet = new SimpleAttributeSet();
	    StyleConstants.setFontSize(styleSet, 20);
	    
		UpdatePlanbtn.setBounds(438, 611, 66, 56);
		PlanPanel.add(UpdatePlanbtn);
		UpdatePlanbtn.setBorderPainted(false);
		
		Deletebtn.setBounds(516, 611, 61, 63);
		Deletebtn.setBorderPainted(false);
		Deletebtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new DeletePlan();
			}	
		});
		
		PlanPanel.add(Deletebtn);
		
		Backbtn.setBounds(76, 351, 48, 46);
		PlanPanel.add(Backbtn);
		Backbtn.setBorderPainted(false);
				
		Playbtn.setIcon(PlayIcon);
		Playbtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if (audio.isPlay == true) {
					audio.stop();
					Playbtn.setIcon(PlayIcon);
				} else {
					Playbtn.setIcon(PauseIcon);
					audio.play();
					
				}
			}
		});
		
		Playbtn.setBounds(152, 349, 48, 48);
		PlanPanel.add(Playbtn);
		Playbtn.setBorderPainted(false);
	
		Forwardbtn.setBounds(229, 351, 48, 46);
		PlanPanel.add(Forwardbtn);
		Forwardbtn.setBorderPainted(false);
		
		UpdatePlanbtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String text = "";
				PlanPrintPanel.setText("");
				try {
					DB.updateDayDB();
				} catch (IOException e2) {
					System.out.println(e2);
				}
				
				try {
					HTMLEditorKit kit = new HTMLEditorKit();
					HTMLDocument HtmlDoc = new HTMLDocument();
					
					PlanPrintPanel.setEditorKit(kit);
					PlanPrintPanel.setDocument(HtmlDoc);
					
					for (Day d : DB.dayDB) {
						text += DB.searchScheduleList(d);
						kit.insertHTML(HtmlDoc, HtmlDoc.getLength(),"<p style='font-family:  뜝 럡 룎 뜝 럥 빖 뜝 럥占썹뼨 먯삕 뜝 럥 럞  뤆 룊 삕 뜝 럩肉뷴뜝 럥 뿼占쎈빝 뜝占 ; font-size: 25px; color: #323C73; font-weight: bold; font-style: italic;'>" + d + "</p>", 0, 0, null);
						kit.insertHTML(HtmlDoc, HtmlDoc.getLength(), "<p><hr align='left' width ='200px'></p>", 0, 0, null);
						for (Schedule s : DB.searchScheduleList(d).scheduleList) {
							String output = String.format("%02d : %02d ~ %02d : %02d %s %s", s.getStartHour(), s.getStartMin(), s.getFinishHour(), s.getFinishMin(), s.getContent(), s.getTag());
							kit.insertHTML(HtmlDoc, HtmlDoc.getLength(), "<font size='6px'> <br> </font>", 0, 0, null);
							kit.insertHTML(HtmlDoc, HtmlDoc.getLength(), "<p style='font-family:  뜝 럡 룎 뜝 럥 빖 뜝 럥占썹뼨 먯삕 뜝 럥 럞  뤆 룊 삕 뜝 럩肉뷴뜝 럥 뿼占쎈빝 뜝占 ; font-size: 20px; color: black;'>" + output + "</p>", 0, 0, null);
						}
						kit.insertHTML(HtmlDoc, HtmlDoc.getLength(), "<font size='20px'><br><br><br></font>", 0, 0, null);
						Util.makeMp3(text, "schedule");
						audio.change("schedule");
					}
	
				} catch (Exception e1) {
					System.out.println(e1);
				}
			}
		});
		
		frame.pack();
	    
	    Calendar cal = Calendar.getInstance();
		int year = cal.get(Calendar.YEAR);
	    int month = cal.get(Calendar.MONTH) + 1;
		int date = cal.get(Calendar.DATE);
		int lastDay = cal.getActualMaximum(Calendar.DATE);
		ArrayList<Integer> calArr = new ArrayList<>();
		
		for(int i = 0; i < lastDay; i++) {
			calArr.add(i + 1);
		}
	}
}

class MyActionListener implements ActionListener {
	String day;
	
	MyActionListener(String day) {
		this.day = day;
	}
	
	public void actionPerformed(ActionEvent e) {
		new EmotionFrame(day);
	}
}