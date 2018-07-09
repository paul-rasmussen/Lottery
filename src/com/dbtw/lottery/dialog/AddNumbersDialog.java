package com.dbtw.lottery.dialog;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFrame;

import com.dbtw.lottery.datasets.NumberCounts;
import com.dbtw.tools.parser.DelimitedParser;
import com.dbtw.widgets.DebugLogger;
import com.dbtw.widgets.LogFile;
import com.dbtw.widgets.UserPrefs;
import javax.swing.JRadioButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;

public class AddNumbersDialog extends JFrame {
  //Constants
  private final String TITLE = "Add Numbers";
  private final int WIDTH = 560;
  private final int HEIGHT = 320;

  //Private variables
  private JTextField txtDate;
  private JTextField txtBall1;
  private JTextField txtBall2;
  private JTextField txtBall3;
  private JTextField txtBall4;
  private JTextField txtBall5;
  private JTextField txtMultiplier;
  private int min = 1;
  private int max = 75;
  private int[] multi = {2,3,4,5};
  private JTextField textField;

  //Public variables

  //Constructors
  public AddNumbersDialog() {
    init();
  }

  //Static methods
  //Public methods
  //Private methods
  private void init() {
    setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    getContentPane().setBackground((Color) UserPrefs.getInstance().getParameter(UserPrefs.THEME_COLOR));
    setTitle(TITLE);
    setSize(WIDTH, HEIGHT);
    Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
    int x = (int) ((dimension.getWidth() - getWidth()) / 2);
    int y = (int) ((dimension.getHeight() - getHeight()) / 2);
    setLocation(x, y);
    getContentPane().setLayout(null);
    getContentPane().setLayout(null);
    
    ButtonGroup rg = new ButtonGroup();
    
    JLabel lblDate = new JLabel("Date");
    lblDate.setBounds(14, 100, 46, 14);
    getContentPane().add(lblDate);
    
    JLabel lblBall = new JLabel("Ball 1");
    lblBall.setBounds(119, 100, 46, 14);
    getContentPane().add(lblBall);
    
    JLabel lblBall_1 = new JLabel("Ball 2");
    lblBall_1.setBounds(175, 100, 46, 14);
    getContentPane().add(lblBall_1);
    
    JLabel lblBall_2 = new JLabel("Ball 3");
    lblBall_2.setBounds(230, 100, 46, 14);
    getContentPane().add(lblBall_2);
    
    JLabel lblBall_3 = new JLabel("Ball 4");
    lblBall_3.setBounds(286, 100, 46, 14);
    getContentPane().add(lblBall_3);
    
    JLabel lblBall_5 = new JLabel("Ball 5");
    lblBall_5.setBounds(342, 100, 46, 14);
    getContentPane().add(lblBall_5);
    
    JLabel lblMultiplier = new JLabel("Multiplier");
    lblMultiplier.setBounds(469, 100, 65, 14);
    getContentPane().add(lblMultiplier);
    
    txtDate = new JTextField();
    txtDate.setBounds(10, 125, 86, 20);
    getContentPane().add(txtDate);
    txtDate.setColumns(10);
    
    txtBall1 = new JTextField();
    txtBall1.setBounds(121, 125, 25, 20);
    getContentPane().add(txtBall1);
    txtBall1.setColumns(10);
    
    txtBall2 = new JTextField();
    txtBall2.setColumns(10);
    txtBall2.setBounds(175, 125, 25, 20);
    getContentPane().add(txtBall2);
    
    txtBall3 = new JTextField();
    txtBall3.setColumns(10);
    txtBall3.setBounds(232, 125, 25, 20);
    getContentPane().add(txtBall3);
    
    txtBall4 = new JTextField();
    txtBall4.setColumns(10);
    txtBall4.setBounds(286, 125, 25, 20);
    getContentPane().add(txtBall4);
    
    txtBall5 = new JTextField();
    txtBall5.setColumns(10);
    txtBall5.setBounds(342, 125, 25, 20);
    getContentPane().add(txtBall5);
    
    txtMultiplier = new JTextField();
    txtMultiplier.setColumns(10);
    txtMultiplier.setBounds(483, 125, 25, 20);
    getContentPane().add(txtMultiplier);
    
    JButton btnSave = new JButton("Save");
    btnSave.setBounds(208, 199, 89, 23);
    btnSave.setActionCommand("saveNumber");
    btnSave.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent ae) {
        if (ae.getActionCommand().equals("saveNumber")) {
          actionSave();
        }
      }
    });
    getContentPane().add(btnSave);
    
    JPanel panel = new JPanel();
    panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
    panel.setBounds(10, 21, 524, 36);
    getContentPane().add(panel);
    panel.setLayout(null);
    
    JRadioButton rdbtnLotto = new JRadioButton("Lotto");
    rdbtnLotto.setBounds(288, 7, 109, 23);
    rdbtnLotto.setActionCommand("Lotto");
    rdbtnLotto.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent ae) {
        if (ae.getActionCommand().equals("Lotto")) {
          actionLotto();
        }
      }
    });
    panel.add(rdbtnLotto);
    
    JRadioButton rdbtnMegamillions = new JRadioButton("MegaMillions");
    rdbtnMegamillions.setBounds(177, 7, 109, 23);
    rdbtnMegamillions.setActionCommand("Megamillions");
    rdbtnMegamillions.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent ae) {
        if (ae.getActionCommand().equals("Megamillions")) {
          actionMegamillions();
        }
      }
    });
    panel.add(rdbtnMegamillions);
    
    JRadioButton rdbtnPowerball = new JRadioButton("Powerball");
    rdbtnPowerball.setBounds(66, 7, 109, 23);
    rdbtnPowerball.setActionCommand("Powerball");
    rdbtnPowerball.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent ae) {
        if (ae.getActionCommand().equals("Powerball")) {
          actionPowerball();
        }
      }
    });
    panel.add(rdbtnPowerball);
    
    rg.add(rdbtnLotto);
    rg.add(rdbtnMegamillions);
    rg.add(rdbtnPowerball);
    
    textField = new JTextField();
    textField.setColumns(10);
    textField.setBounds(398, 125, 25, 20);
    getContentPane().add(textField);
    
    JLabel lblBall_4 = new JLabel("Ball 6");
    lblBall_4.setBounds(398, 100, 46, 14);
    getContentPane().add(lblBall_4);
    
    JMenuBar menuBar = new JMenuBar();
    setJMenuBar(menuBar);
    
    JMenu mnAddFile = new JMenu("Add File");
    menuBar.add(mnAddFile);
    
    JMenuItem mntmPowerball = new JMenuItem("Powerball");
    mntmPowerball.setActionCommand("LoadPowerball");
    mntmPowerball.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent ae) {
        if (ae.getActionCommand().equals("LoadPowerball")) {
          actionLoadPowerballFile();
        }
      }
    });
    mnAddFile.add(mntmPowerball);
    
    JMenuItem mntmMegamillions = new JMenuItem("MegaMillions");
    mntmMegamillions.setActionCommand("LoadMegamillions");
    mntmMegamillions.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent ae) {
        if (ae.getActionCommand().equals("LoadMegamillions")) {
          actionLoadMegamillionFile();
        }
      }
    });
    mnAddFile.add(mntmMegamillions);
    
    JMenuItem mntmLotto = new JMenuItem("Lotto");
    mntmLotto.setActionCommand("LoadLotto");
    mntmLotto.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent ae) {
        if (ae.getActionCommand().equals("LoadLotto")) {
          actionLoadLottoFile();
        }
      }
    });
    mnAddFile.add(mntmLotto);
    
  }
  
  private void actionLotto() {
    max = NumberCounts.LOTTO_MAX;
    txtMultiplier.setVisible(false);
  }
  
  private void actionPowerball() {
    max = NumberCounts.POWERBALL_MAX;
    txtMultiplier.setVisible(true);
  }
  
  private void actionMegamillions() {
    max = NumberCounts.MEGAMILL_MAX;
    txtMultiplier.setVisible(true);
  }
  
  private File actionLoadFile() {
    JFileChooser fc = new JFileChooser();
    if(fc.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {  
      return fc.getSelectedFile();
    }  
    return null;
  }
  
  private void actionLoadPowerballFile() {
    File source = actionLoadFile();
  }
  
  private void actionLoadMegamillionFile() {
    File source = actionLoadFile();
  }
  
  private void actionLoadLottoFile() {
    File source = actionLoadFile();
  }
  
  private void actionSave() {
    
  }

}
