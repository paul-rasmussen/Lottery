package com.dbtw.lottery.dialog;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Iterator;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import com.dbtw.dialogs.UserPrefsDialog;
import com.dbtw.widgets.LogFile;
import com.dbtw.widgets.UserPrefs;

import javax.swing.JMenu;

public class MainFrame extends JFrame implements WindowListener{
  //Static variables
  private static String TITLE = "Lottery Analysis";
  private static int WIDTH = 1115;
  private static int HEIGHT = 830;
  
  //Private variables
  private int environment = UserPrefs.LINUX;
  private String prefs = "LotteryNumbers.dat";

  private JMenuBar menuBar = new JMenuBar();
  private JMenu mnFile = new JMenu("File");
  private JMenuItem mntmExit = new JMenuItem("Exit");
  private JMenu mnGraphs = new JMenu("Graphs");
  private JMenuItem mntmFrequency = new JMenuItem("Frequency");
  private JMenuItem mntmProbability = new JMenuItem("Probability");
  private JMenuItem mntmIntervals = new JMenuItem("Intervals");
  private JMenu mnAdmin = new JMenu("Admin");
  private JMenuItem mntmPreferences = new JMenuItem("Preferences");
  private JMenuItem mntmLoadNumbers = new JMenuItem("Load Numbers");

  //Public variables
  
  //Constructors
  public MainFrame() {
    super();
    init();
  }
  
  //Static methods
  //Public methods
  //Private methods
  private void init() {
    try {
      if (System.getenv("HOME") != null) {
        environment = UserPrefs.LINUX;
      }
      else {
        environment = UserPrefs.WINDOWS;
      }
      open();
      if (!UserPrefs.getInstance().getParameterKeys().contains(UserPrefs.APP_NAME)) {
        UserPrefs.getInstance().setParameter(UserPrefs.APP_NAME, "LotteryNumbers");
      }
      else {
        if (UserPrefs.getInstance().getParameter(UserPrefs.APP_NAME).equals("LotteryNumbers")) {
          UserPrefs.getInstance().setParameter(UserPrefs.APP_NAME, "LotteryNumbers");
        }
      }
      setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
      getContentPane().setBackground((Color) UserPrefs.getInstance().getParameter(UserPrefs.THEME_COLOR));
      getContentPane().setLayout(null);
      setTitle(TITLE);
      setSize(WIDTH, HEIGHT);
      Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
      int x = (int) ((dimension.getWidth() - getWidth()) / 2);
      int y = (int) ((dimension.getHeight() - getHeight()) / 2);
      setLocation(x, y);
  
      setJMenuBar(menuBar);
      menuBar.add(mnFile);
      mnFile.add(mntmExit);
      menuBar.add(mnGraphs);
      mnGraphs.add(mntmFrequency);
      mntmFrequency.setActionCommand("Frequency");
      mntmFrequency.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent ae) {
          if (ae.getActionCommand().equals("Frequency")) {
            actionFrequency();
          }
        }
      });
      mnGraphs.add(mntmProbability);
      mntmProbability.setActionCommand("Probability");
      mntmProbability.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent ae) {
          if (ae.getActionCommand().equals("Probability")) {
            actionProbability();
          }
        }
      });
      mnGraphs.add(mntmIntervals);
      mntmIntervals.setActionCommand("Intervals");
      mntmIntervals.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent ae) {
          if (ae.getActionCommand().equals("Intervals")) {
            actionIntervals();
          }
        }
      });
      menuBar.add(mnAdmin);
      mnAdmin.add(mntmPreferences);
      mntmPreferences.setActionCommand("Preferences");
      mntmPreferences.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent ae) {
          if (ae.getActionCommand().equals("Preferences")) {
            actionPreferences();
          }
        }
      });
      
      mnAdmin.add(mntmLoadNumbers);
      mntmLoadNumbers.setActionCommand("LoadNumbers");
      mntmLoadNumbers.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent ae) {
          if (ae.getActionCommand().equals("LoadNumbers")) {
            actionLoadNumbers();
          }
        }
      });
      
      validate();
    }
    catch (Exception e) {
      LogFile.getInstance().writeDump(e);
    }
  }
  
  private void actionFrequency() {
    
  }
  
  private void actionProbability() {
    
  }
  
  private void actionIntervals() {
    
  }
  
  private void actionPreferences() {
    UserPrefsDialog dialog = new UserPrefsDialog();
    dialog.validate();
  }

  private void actionLoadNumbers() {
    AddNumbersDialog dialog = new AddNumbersDialog();
    dialog.setVisible(true);
  }
  
  private void close() throws IOException{
    String file = "";
    switch (environment) {
      case (UserPrefs.LINUX): {
        file = System.getenv("HOME") + "/" + prefs;
        break;
      }
      case (UserPrefs.WINDOWS): {
        file = System.getenv("USERPROFILE") + "\\" + prefs;
        break;
      }
    }
    FileOutputStream fos = new FileOutputStream(new File(file));
    ObjectOutputStream os = new ObjectOutputStream(fos);
    JOptionPane.showMessageDialog(new JFrame(), "Saving options to file: " + file, "FYI", JOptionPane.OK_OPTION);
    os.writeObject(UserPrefs.getInstance());
  }
  
  private void open() throws FileNotFoundException, IOException, ClassNotFoundException {
    String file = "";
    try {
      UserPrefs us = UserPrefs.getInstance();
      switch (environment) {
        case (UserPrefs.LINUX): {
          file = System.getenv("HOME") + "/" + prefs;
          break;
        }
        case (UserPrefs.WINDOWS): {
          file = System.getenv("USERPROFILE") + "\\" + prefs;
          break;
        }
      }
      File sel = new File(file);
      if (sel.exists()) {
        FileInputStream fis = new FileInputStream(sel);
        ObjectInputStream ois = new ObjectInputStream(fis);
        us = (UserPrefs) ois.readObject();
        for (Iterator<String> i = us.getParameterKeys().iterator(); i.hasNext(); ) {
          String key = i.next();
          UserPrefs.getInstance().setParameter(key, us.getParameter(key));
        }
      }
      else {
        JOptionPane.showMessageDialog(new JFrame(), "The user preferences file (" + file + ") does not exist.", "Application Error", JOptionPane.OK_OPTION);
        close();
      }
      us.setParameter(UserPrefs.APP_NAME, "Lottery");
    }
    catch (Exception e) {
      JOptionPane.showMessageDialog(new JFrame(), "There was a problem opening the user preferences file.\n" + e.getMessage(), "Application Error", JOptionPane.OK_OPTION);
    }
  }

  @Override
  public void windowClosing(WindowEvent e) {
    try {
      close();
      ActionListener task = new ActionListener() {
        boolean alreadyDisposed = false;
        public void actionPerformed(ActionEvent e) {
          if (isDisplayable()) {
            alreadyDisposed = true;
            dispose();
          }
        }
      };
    }
    catch (Exception ex) {
      LogFile.getInstance().writeDump(ex);;
    }
  }

  public void windowDeactivated(WindowEvent e) {
    //Do nothing
  }

  @Override
  public void windowActivated(WindowEvent arg0) {
    // TODO Auto-generated method stub
    
  }

  @Override
  public void windowClosed(WindowEvent arg0) {
    // TODO Auto-generated method stub
    
  }

  @Override
  public void windowDeiconified(WindowEvent arg0) {
    // TODO Auto-generated method stub
    
  }

  @Override
  public void windowIconified(WindowEvent arg0) {
    // TODO Auto-generated method stub
    
  }

  @Override
  public void windowOpened(WindowEvent arg0) {
    // TODO Auto-generated method stub
    
  }

}