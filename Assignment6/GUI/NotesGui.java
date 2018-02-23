/**
 * The GUI from the notes (p.15 Chapter 11 Slides)
 * 
 * @author Lynn Marshall
 * @version Skeleton: November 17, 2012
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.border.TitledBorder;
import javax.swing.border.*;
import java.lang.Comparable;  
import java.awt.Color;

public class NotesGui implements ActionListener
{
    private static JPanel mainPanel; //panel encompassing all panels
    private JFrame mainFrame;
    private static JPanel buttonsPanel;
    private JPanel buttonPanel; //panel for buttons
    private JButton b1;
    private JToggleButton b2;
    private JPanel checkboxPanel;
    private JCheckBox check1;
    private JCheckBox check2;
    private JPanel buttongroupPanel;
    private JRadioButton radio1;
    private JRadioButton radio2;

    private static JPanel labelPanel;
    private JLabel textLabel;
    private JTextField textField;

    private static JPanel progressPanel;
    private JProgressBar progressBar;

    private static JPanel selectPanel; 
    private JPanel sliderPanel;
    private JSlider slider;
    private JPanel MainScrollPanel;
    private JScrollPane scrollPanel;
    private JList list;
    private JPanel spinnerPanel;
    private JSpinner spinner;
    private JPanel comboPanel;
    private JComboBox comboBox;

   public NotesGui() {
      // JFrame and contentPane
      mainFrame = new JFrame("Swing Component Demo");
      Color grey = Color.decode("#CCCCCC");
      Border blackline;
      blackline = BorderFactory.createLineBorder(Color.black);
      Container contentPane = mainFrame.getContentPane();
      mainFrame.getContentPane().setBackground(grey);
      mainPanel = new JPanel(new GridBagLayout());
      mainPanel.setBackground(grey);
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(0,0,10,0);
        mainFrame.add(mainPanel);
        mainPanel.setVisible(true);
        buttonsPanel = new JPanel(new FlowLayout()); //main panel for buttons
        
        TitledBorder borderButtonsPanel = new TitledBorder(blackline,"Buttons");
        borderButtonsPanel.setTitleJustification(TitledBorder.LEFT);
        borderButtonsPanel.setTitlePosition(TitledBorder.TOP);
  
        buttonsPanel.setBorder(borderButtonsPanel);
        buttonsPanel.setBackground(grey);
        buttonsPanel.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        
        c.gridx = 0;
        c.gridy = 0;

        mainPanel.add(buttonsPanel,c);
        buttonsPanel.setVisible(true);
        buttonPanel = new JPanel(); //panel for button and toggle button
        buttonPanel.setBackground(grey);
        buttonPanel.setLayout(new BoxLayout(buttonPanel,BoxLayout.PAGE_AXIS));
        TitledBorder borderButtonPanel = new TitledBorder(blackline,"Some buttons");
        borderButtonPanel.setTitleJustification(TitledBorder.LEFT);
        borderButtonPanel.setTitlePosition(TitledBorder.TOP);
        buttonPanel.setBorder(borderButtonPanel);
        b1 = new JButton("Button 1");
        b1.setBackground(grey);
        b1.addActionListener(this);
        buttonPanel.add(b1);
        b1.setAlignmentX(Component.LEFT_ALIGNMENT);
        b2 = new JToggleButton("Button 2 long");
        b2.setBackground(grey);
        b2.addActionListener(this);
        b2.setAlignmentX(Component.LEFT_ALIGNMENT);
        buttonPanel.add(b2);
        buttonsPanel.add(buttonPanel);

        checkboxPanel = new JPanel();
        checkboxPanel.setBackground(grey);
        checkboxPanel.setLayout(new BoxLayout(checkboxPanel,BoxLayout.PAGE_AXIS));
        TitledBorder bordercheckboxPanel = new TitledBorder(blackline,"Some check boxes");
        bordercheckboxPanel.setTitleJustification(TitledBorder.LEFT);
        bordercheckboxPanel.setTitlePosition(TitledBorder.TOP);
        checkboxPanel.setBorder(bordercheckboxPanel);
        check1 = new JCheckBox("A JCheckBox");
        check1.setBackground(grey);
        check1.addActionListener(this);
        check1.setAlignmentX(Component.LEFT_ALIGNMENT);
        checkboxPanel.add(check1);
        check2 = new JCheckBox("Another JCheckBox");
        check2.setBackground(grey);
        check2.addActionListener(this);
        check2.setAlignmentX(Component.LEFT_ALIGNMENT);
        checkboxPanel.add(check2);
        buttonsPanel.add(checkboxPanel);

        buttongroupPanel = new JPanel();
        buttongroupPanel.setBackground(grey);
        buttongroupPanel.setLayout(new BoxLayout(buttongroupPanel,BoxLayout.PAGE_AXIS));
        TitledBorder borderButtonGroupPanel = new TitledBorder(blackline,"Some radio buttons");
        borderButtonGroupPanel.setTitleJustification(TitledBorder.LEFT);
        borderButtonGroupPanel.setTitlePosition(TitledBorder.TOP);
        buttongroupPanel.setBorder(borderButtonGroupPanel);
        radio1 = new JRadioButton("A radio button");
        radio1.setBackground(grey);
        radio1.addActionListener(this);
        radio1.setAlignmentX(Component.LEFT_ALIGNMENT);
        buttongroupPanel.add(radio1);
        radio2 = new JRadioButton("Another radio button");
        radio2.setBackground(grey);
        radio2.addActionListener(this);
        radio2.setAlignmentX(Component.LEFT_ALIGNMENT);
        buttongroupPanel.add(radio2);
        buttonsPanel.add(buttongroupPanel);
        //All sections for the button component are done

        labelPanel = new JPanel(new FlowLayout()); //JPanel for labels and text entry
        labelPanel.setBackground(grey);
        TitledBorder labelTabelBorder = new TitledBorder(blackline,"Labels and Text Entry");
        labelTabelBorder.setTitleJustification(TitledBorder.LEFT);
        labelTabelBorder.setTitlePosition(TitledBorder.TOP);
        labelPanel.setBorder(labelTabelBorder);
        labelPanel.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);

        c.gridx = 0;
        c.gridy = 1;
        mainPanel.add(labelPanel,c);

        textLabel = new JLabel("A JLabel with a text label.");
        textLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        textLabel.setBorder(new EmptyBorder(0, 0, 0, 80));
        labelPanel.add(textLabel);

        textField = new JTextField("Yout can type in text here");
        textField.addFocusListener(new FocusListener() { 
                public void focusLost(FocusEvent e){
                    JTextField source = (JTextField)e.getSource();
                    System.out.println("The text area says " + source.getText());
                }
                
                public void focusGained(FocusEvent e){}
               
            });
        textField.setAlignmentX(Component.LEFT_ALIGNMENT);
        textField.setPreferredSize( new Dimension( 200, 24 ) );
        labelPanel.add(textField);

        //all section for the label panel are done

        progressPanel = new JPanel(new FlowLayout());
        progressPanel.setBackground(grey);
        TitledBorder progressTable = new TitledBorder(blackline,"Progress bar");
        progressTable.setTitleJustification(TitledBorder.LEFT);
        progressTable.setTitlePosition(TitledBorder.TOP);
        progressPanel.setBorder(progressTable);
        progressPanel.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);

        c.gridx = 0;
        c.gridy = 2;
        c.gridwidth = 2;
        c.fill = GridBagConstraints.HORIZONTAL; //stretch component

        progressBar = new JProgressBar();
        progressBar.setValue(67);
        progressBar.setString("67%");
        progressBar.setStringPainted(true);
        progressBar.addMouseListener(new MouseListener() { 
                
                public void mouseReleased(MouseEvent e) { 
                    JProgressBar source = (JProgressBar)e.getSource();
                    
                    System.out.println("The bar is at " + source.getValue());
                } 

                public void mouseExited(MouseEvent e) {}

                public void mouseEntered(MouseEvent e) {}

                public void mousePressed(MouseEvent e) {}

                public void mouseClicked(MouseEvent e) {}
            });
        progressBar.setAlignmentX(Component.LEFT_ALIGNMENT);
        progressBar.setPreferredSize( new Dimension( 400, 24 ) );
        progressPanel.add(progressBar);
        mainPanel.add(progressPanel,c);

        //progress bar panel done

        selectPanel = new JPanel(new GridBagLayout());
        selectPanel.setBackground(grey);
        GridBagConstraints c1 = new GridBagConstraints();
        c1.insets = new Insets(10,10,10,10); //for inside the panel

        c.gridx = 0;
        c.gridy = 3;
        c.gridwidth = 2;
        c.fill = GridBagConstraints.HORIZONTAL;

        mainPanel.add(selectPanel,c);
        TitledBorder selectBorder = new TitledBorder(blackline,"Components for Selecting");
        selectBorder.setTitleJustification(TitledBorder.LEFT);
        selectBorder.setTitlePosition(TitledBorder.TOP);
        selectPanel.setBorder(selectBorder);

        sliderPanel = new JPanel(new FlowLayout());
        sliderPanel.setBackground(grey);
        TitledBorder sliderBorder = new TitledBorder(blackline,"A JSlider");
        sliderBorder.setTitleJustification(TitledBorder.LEFT);
        sliderBorder.setTitlePosition(TitledBorder.TOP);
        sliderPanel.setBorder(sliderBorder);
        c1.gridx = 0;
        c1.gridy = 0;

        selectPanel.add(sliderPanel,c1);
        slider = new JSlider(0,10);
        slider.setBackground(grey);
        slider.setMinorTickSpacing(2);
        slider.setMajorTickSpacing(10);
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);
        slider.setLabelTable(slider.createStandardLabels(10));
        slider.addMouseListener(new MouseListener() { 
                
                public void mouseReleased(MouseEvent e) { 
                    JSlider source = (JSlider)e.getSource();
                    
                    System.out.println("The slider is at " + source.getValue());
                } 

                public void mouseExited(MouseEvent e) {}

                public void mouseEntered(MouseEvent e) {}

                public void mousePressed(MouseEvent e) {}

                public void mouseClicked(MouseEvent e) {}
            });
            
        sliderPanel.add(slider);

        spinnerPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        spinnerPanel.setBackground(grey);
        spinnerPanel.setPreferredSize( new Dimension( 150, 60 ) );
        TitledBorder spinnerBorder = new TitledBorder(blackline,"A JSpinner");
        spinnerBorder.setTitleJustification(TitledBorder.LEFT);
        spinnerBorder.setTitlePosition(TitledBorder.TOP);
        spinnerPanel.setBorder(spinnerBorder);
        c1.gridx = 1;
        c1.gridy = 0;
        spinnerPanel.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);

        selectPanel.add(spinnerPanel,c1);
        spinner = new JSpinner();
        spinner.addChangeListener(new ChangeListener() { 
               
            
                public void stateChanged(ChangeEvent e) {
                    
                    JSpinner source = (JSpinner)e.getSource();
                    System.out.println("The spinner is at "+ source.getValue());
                } 

            });
            
        spinner.setPreferredSize( new Dimension( 60, 20) );
        spinner.setBorder(new EmptyBorder(0, 0, 0, 100));
        spinner.setAlignmentX(Component.LEFT_ALIGNMENT);
        spinnerPanel.add(spinner);

        comboPanel = new JPanel(new GridLayout());
        comboPanel.setBackground(grey);
        comboPanel.setPreferredSize( new Dimension( 150, 50 ) );
        TitledBorder comboBorder = new TitledBorder(blackline,"A JComboBox");
        comboBorder.setTitleJustification(TitledBorder.LEFT);
        comboBorder.setTitlePosition(TitledBorder.TOP);
        comboPanel.setBorder(comboBorder);
        c1.gridx = 1;
        c1.gridy = 1;
        //c1.fill = GridBagConstraints.HORIZONTAL;

        String labels[] = {"Item1","Item2","Item3","Item4","Item5",
                "Item6","Item7","Item8","Item9"};
            
        selectPanel.add(comboPanel,c1);
        comboBox = new JComboBox(labels);
        comboBox.setBackground(grey);
        comboBox.addMouseListener(new MouseListener() { 
                
                public void mouseReleased(MouseEvent e) {
                    
                } 

                public void mouseExited(MouseEvent e) {}

                public void mouseEntered(MouseEvent e) {}

                public void mousePressed(MouseEvent e) {}

                public void mouseClicked(MouseEvent e) {
                    JComboBox source = (JComboBox)e.getSource();
                    System.out.println("you have selected "+ source.getSelectedItem().toString());
                
                }
            });
        comboPanel.add(comboBox);

        MainScrollPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        MainScrollPanel.setBackground(grey);
        TitledBorder scrollBorder = new TitledBorder(blackline,"A JList in a JScrollPane");
        scrollBorder.setTitleJustification(TitledBorder.LEFT);
        scrollBorder.setTitlePosition(TitledBorder.TOP);
        MainScrollPanel.setBorder(scrollBorder);
        c1.gridx = 0;
        c1.gridy = 1;
        c1.gridheight = 2;

        

        list = new JList(labels);
        list.addMouseListener(new MouseListener() { 
                
                public void mouseReleased(MouseEvent e) {
                    JList source = (JList)e.getSource();
                    
                    System.out.println("you have selected "+ source.getSelectedValue());
                } 

                public void mouseExited(MouseEvent e) {}

                public void mouseEntered(MouseEvent e) {}

                public void mousePressed(MouseEvent e) {}

                public void mouseClicked(MouseEvent e) {}
            });
        scrollPanel = new JScrollPane(list);
        scrollPanel.setBackground(grey);
        scrollPanel.setPreferredSize( new Dimension( 200, 150 ) );
        scrollPanel.setBorder(new EmptyBorder(0, 0, 0, 100));
        scrollPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
        MainScrollPanel.add(scrollPanel);
        selectPanel.add(MainScrollPanel,c1);
      
      // set the layout of the contentPane
      
      // add all the GUI components 
      // Most of the classes required can be determined from the names
      // used in the GUI (e.g. JButton, etc.).
      // Note that many of these have a TitledBorder -- that's what
      // puts the line around a component with a title in the upper left.
      // See the TitledBorder interface and also the tutorial on using Borders:
      // http://docs.oracle.com/javase/tutorial/uiswing/components/border.html
      
      // set up the action listeners 
      
      // finish setting up the frame
      mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
      mainFrame.pack();
      mainFrame.setResizable(true);
      mainFrame.setVisible(true);
   }
   
   /** 
    * This action listener is called when the user clicks / enters
    * information using the GUI. 
    */
    public void actionPerformed(ActionEvent e)
    {
        
        Object o = e.getSource();

        if(o instanceof JButton){
            
            System.out.println("A button was just pressed!");
        } 
        if(o instanceof JCheckBox ){
            System.out.println("A checkbox was just pressed");
        } 
        if(o instanceof JRadioButton){
            System.out.println("A radio button was just pressed");
        }
        if(o instanceof JToggleButton){
            System.out.println("A toggle button was just pressed");
        }
        

        
   }    
}