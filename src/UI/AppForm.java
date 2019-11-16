/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import Model.NutrientsCollection;
import Model.TotalNutrientsDaily;
import Model.TotalNutrients;
import Model.TotalNutrientsKCal;
import eatingsmart_nb.API;
import eatingsmart_nb.Controller;
import eatingsmart_nb.MongoDB;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.PieSectionLabelGenerator;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultKeyedValuesDataset;
import org.jfree.data.general.DefaultPieDataset;

/**
 *
 * @author Roman
 */
public class AppForm extends javax.swing.JFrame {

    Controller app;

    final String QUANTITY = "quantity";
    final String UNIT = "unit";
    final String LABEL = "label";

    /**
     * Creates new form AppForm
     */
    public AppForm() {
        initComponents();

        app = new Controller(new MongoDB("EatingSmart", "Nutrients"), new API());

        Dimension dim = getToolkit().getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
        setInitialPanelsVisibility();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu3 = new javax.swing.JMenu();
        jLabel1 = new javax.swing.JLabel();
        btnSearch = new javax.swing.JButton();
        jVitaminsTable = new javax.swing.JTabbedPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        grdNutrients = new javax.swing.JTable();
        panLabel = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lblCalories = new javax.swing.JLabel();
        lblFat = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lblSatD = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jSeparator6 = new javax.swing.JSeparator();
        jSeparator8 = new javax.swing.JSeparator();
        jSeparator9 = new javax.swing.JSeparator();
        lblMonoD = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        lblPolyD = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel21 = new javax.swing.JLabel();
        jSeparator10 = new javax.swing.JSeparator();
        lblCarbsD = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jSeparator11 = new javax.swing.JSeparator();
        lblProteinD = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jSeparator12 = new javax.swing.JSeparator();
        lblFiberD = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jSeparator13 = new javax.swing.JSeparator();
        lblSugarD = new javax.swing.JLabel();
        lblFatMg = new javax.swing.JLabel();
        lblSaturatedMg = new javax.swing.JLabel();
        lblMonoG = new javax.swing.JLabel();
        lblPolyG = new javax.swing.JLabel();
        lblCarbG = new javax.swing.JLabel();
        lblProteinG = new javax.swing.JLabel();
        lblFiberG = new javax.swing.JLabel();
        lblSugarG = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        pieJPanel = new javax.swing.JPanel();
        barJPanel = new javax.swing.JPanel();
        txtSearch = new javax.swing.JTextField();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();

        jMenu3.setText("jMenu3");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setSize(new java.awt.Dimension(3, 3));

        jLabel1.setFont(new java.awt.Font("Rockwell", 1, 48)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Eating Smart");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        btnSearch.setText("Search");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        jVitaminsTable.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        grdNutrients.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Label", "Quantity", "Unit"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Double.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(grdNutrients);

        jVitaminsTable.addTab("Vitamins", jScrollPane2);

        panLabel.setBackground(new java.awt.Color(255, 255, 255));
        panLabel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        panLabel.setDoubleBuffered(false);
        panLabel.setMaximumSize(new java.awt.Dimension(350, 500));
        panLabel.setName("panLabel"); // NOI18N
        panLabel.setPreferredSize(new java.awt.Dimension(350, 500));
        panLabel.setLayout(null);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Nutrition Facts");
        panLabel.add(jLabel3);
        jLabel3.setBounds(30, 20, 290, 36);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("Calories");
        panLabel.add(jLabel2);
        jLabel2.setBounds(30, 90, 72, 20);

        lblCalories.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblCalories.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblCalories.setText("CaloriesAmt");
        lblCalories.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        panLabel.add(lblCalories);
        lblCalories.setBounds(150, 90, 170, 20);

        lblFat.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblFat.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblFat.setText("lblFatD");
        lblFat.setAlignmentX(0.5F);
        panLabel.add(lblFat);
        lblFat.setBounds(250, 150, 60, 15);

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel20.setText("Fat");
        jLabel20.setAlignmentX(0.5F);
        panLabel.add(jLabel20);
        jLabel20.setBounds(20, 150, 29, 17);

        jLabel4.setText("Saturated");
        jLabel4.setAlignmentX(0.5F);
        panLabel.add(jLabel4);
        jLabel4.setBounds(30, 180, 70, 14);

        lblSatD.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblSatD.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblSatD.setAlignmentX(0.5F);
        panLabel.add(lblSatD);
        lblSatD.setBounds(250, 180, 60, 20);

        jLabel6.setText("Monosaturated");
        jLabel6.setAlignmentX(0.5F);
        panLabel.add(jLabel6);
        jLabel6.setBounds(30, 210, 90, 14);

        jSeparator6.setDoubleBuffered(true);
        jSeparator6.setMinimumSize(new java.awt.Dimension(300, 2));
        panLabel.add(jSeparator6);
        jSeparator6.setBounds(20, 170, 292, 10);

        jSeparator8.setDoubleBuffered(true);
        panLabel.add(jSeparator8);
        jSeparator8.setBounds(30, 200, 280, 10);

        jSeparator9.setDoubleBuffered(true);
        panLabel.add(jSeparator9);
        jSeparator9.setBounds(30, 230, 280, 10);

        lblMonoD.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblMonoD.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblMonoD.setAlignmentX(0.5F);
        panLabel.add(lblMonoD);
        lblMonoD.setBounds(250, 210, 60, 20);

        jLabel8.setText("Polysaturated");
        jLabel8.setAlignmentX(0.5F);
        panLabel.add(jLabel8);
        jLabel8.setBounds(30, 240, 80, 14);

        lblPolyD.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblPolyD.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblPolyD.setAlignmentX(0.5F);
        panLabel.add(lblPolyD);
        lblPolyD.setBounds(250, 240, 60, 20);

        jSeparator2.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator2.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator2.setMinimumSize(new java.awt.Dimension(270, 10));
        panLabel.add(jSeparator2);
        jSeparator2.setBounds(22, 115, 300, 10);

        jSeparator1.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jSeparator1.setPreferredSize(new java.awt.Dimension(50, 20));
        panLabel.add(jSeparator1);
        jSeparator1.setBounds(22, 62, 300, 20);
        panLabel.add(jSeparator3);
        jSeparator3.setBounds(30, 260, 280, 10);

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel21.setText("Carbohydrates");
        jLabel21.setAlignmentX(0.5F);
        panLabel.add(jLabel21);
        jLabel21.setBounds(20, 270, 110, 17);

        jSeparator10.setDoubleBuffered(true);
        panLabel.add(jSeparator10);
        jSeparator10.setBounds(20, 290, 292, 2);

        lblCarbsD.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblCarbsD.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        panLabel.add(lblCarbsD);
        lblCarbsD.setBounds(220, 270, 90, 20);

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel22.setText("Protein");
        jLabel22.setAlignmentX(0.5F);
        panLabel.add(jLabel22);
        jLabel22.setBounds(20, 300, 50, 17);

        jSeparator11.setDoubleBuffered(true);
        panLabel.add(jSeparator11);
        jSeparator11.setBounds(20, 320, 292, 2);

        lblProteinD.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblProteinD.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        panLabel.add(lblProteinD);
        lblProteinD.setBounds(230, 300, 80, 20);

        jLabel24.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel24.setText("Fiber");
        jLabel24.setAlignmentX(0.5F);
        panLabel.add(jLabel24);
        jLabel24.setBounds(20, 330, 40, 17);

        jSeparator12.setDoubleBuffered(true);
        panLabel.add(jSeparator12);
        jSeparator12.setBounds(20, 350, 292, 2);

        lblFiberD.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblFiberD.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        panLabel.add(lblFiberD);
        lblFiberD.setBounds(240, 330, 70, 20);

        jLabel26.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel26.setText("Sugar");
        jLabel26.setAlignmentX(0.5F);
        panLabel.add(jLabel26);
        jLabel26.setBounds(20, 360, 50, 17);

        jSeparator13.setDoubleBuffered(true);
        panLabel.add(jSeparator13);
        jSeparator13.setBounds(20, 380, 292, 2);

        lblSugarD.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblSugarD.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        panLabel.add(lblSugarD);
        lblSugarD.setBounds(240, 360, 70, 20);

        lblFatMg.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblFatMg.setText("jLabel30");
        panLabel.add(lblFatMg);
        lblFatMg.setBounds(60, 150, 52, 15);

        lblSaturatedMg.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblSaturatedMg.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblSaturatedMg.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        panLabel.add(lblSaturatedMg);
        lblSaturatedMg.setBounds(150, 180, 70, 20);

        lblMonoG.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblMonoG.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblMonoG.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        panLabel.add(lblMonoG);
        lblMonoG.setBounds(150, 210, 60, 20);

        lblPolyG.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblPolyG.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblPolyG.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        panLabel.add(lblPolyG);
        lblPolyG.setBounds(150, 240, 60, 20);

        lblCarbG.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblCarbG.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblCarbG.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        panLabel.add(lblCarbG);
        lblCarbG.setBounds(150, 270, 60, 20);

        lblProteinG.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblProteinG.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblProteinG.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        lblProteinG.setPreferredSize(new java.awt.Dimension(70, 20));
        panLabel.add(lblProteinG);
        lblProteinG.setBounds(150, 300, 70, 20);

        lblFiberG.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblFiberG.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        panLabel.add(lblFiberG);
        lblFiberG.setBounds(150, 330, 60, 20);

        lblSugarG.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblSugarG.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        panLabel.add(lblSugarG);
        lblSugarG.setBounds(150, 360, 60, 20);

        jLabel39.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel39.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel39.setText("%Daily Value *");
        panLabel.add(jLabel39);
        jLabel39.setBounds(230, 130, 90, 14);

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("* Percent Daily Values are based on a 2000 calorie diet");
        panLabel.add(jLabel7);
        jLabel7.setBounds(20, 400, 290, 11);

        pieJPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        pieJPanel.setPreferredSize(new java.awt.Dimension(400, 250));
        pieJPanel.setVerifyInputWhenFocusTarget(false);

        javax.swing.GroupLayout pieJPanelLayout = new javax.swing.GroupLayout(pieJPanel);
        pieJPanel.setLayout(pieJPanelLayout);
        pieJPanelLayout.setHorizontalGroup(
            pieJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 420, Short.MAX_VALUE)
        );
        pieJPanelLayout.setVerticalGroup(
            pieJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 246, Short.MAX_VALUE)
        );

        barJPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        barJPanel.setMinimumSize(new java.awt.Dimension(400, 250));

        javax.swing.GroupLayout barJPanelLayout = new javax.swing.GroupLayout(barJPanel);
        barJPanel.setLayout(barJPanelLayout);
        barJPanelLayout.setHorizontalGroup(
            barJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 420, Short.MAX_VALUE)
        );
        barJPanelLayout.setVerticalGroup(
            barJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 248, Short.MAX_VALUE)
        );

        txtSearch.setText("1 banana");

        jMenu1.setText("File");

        jMenuItem1.setText("Exit");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Info");

        jMenuItem2.setText("About");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem2);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(40, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(63, 63, 63)
                        .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(panLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(barJPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(pieJPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 424, Short.MAX_VALUE))
                        .addGap(18, 61, Short.MAX_VALUE)
                        .addComponent(jVitaminsTable, javax.swing.GroupLayout.DEFAULT_SIZE, 287, Short.MAX_VALUE)))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 69, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSearch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtSearch))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(pieJPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(barJPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(panLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jVitaminsTable))
                .addContainerGap(38, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //GET NUTRITIONS LABEL
    private void getLabel(NutrientsCollection n) {

        NumberFormat num = NumberFormat.getNumberInstance();
        num.setMaximumFractionDigits(1);

        TotalNutrients t = n.getTotalNutrients();
        TotalNutrientsDaily d = n.getTotalDaily();

        lblFatMg.setText(t.getFAT() != null ? num.format(t.getFAT().getQuantity()) + " g" : "");
        lblCalories.setText(t.getEnergy() != null ? num.format(t.getEnergy().getQuantity()) + " kcal" : "");
        lblCarbG.setText(t.getCarbs() != null ? num.format(t.getCarbs().getQuantity()) + " g" : "");
        lblFiberG.setText(t.getFiber() != null ? num.format(t.getFiber().getQuantity()) + " g" : "");
        lblMonoG.setText(t.getMonostaturatedFat() != null ? num.format(t.getMonostaturatedFat().getQuantity()) + " g" : "");
        lblPolyG.setText(t.getFatPolySaturated() != null ? num.format(t.getFatPolySaturated().getQuantity()) + " g" : "");
        lblProteinG.setText(t.getProtein() != null ? num.format(t.getProtein().getQuantity()) + " g" : "");
        lblSaturatedMg.setText(t.getSaturatedFat() != null ? num.format(t.getSaturatedFat().getQuantity()) + " g" : "");
        lblSugarG.setText(t.getSUGAR() != null ? num.format(t.getSUGAR().getQuantity()) : "");

        lblFat.setText(d.getFAT() != null ? num.format(d.getFAT().getQuantity()) + " %" : "");
        lblCarbsD.setText(d.getCarbs() != null ? num.format(d.getCarbs().getQuantity()) + " %" : "");
        lblFiberD.setText(d.getFiber() != null ? num.format(d.getFiber().getQuantity()) + " %" : "");
        lblProteinD.setText(d.getProtein() != null ? num.format(d.getProtein().getQuantity()) + " %" : "");
        lblSatD.setText(d.getSaturatedFat() != null ? num.format(d.getSaturatedFat().getQuantity()) + " %" : "");

        panLabel.setVisible(true);

    }

    //PIE CHART CALORIES PROPORTION
    private void getCaloriesProportion(TotalNutrientsKCal cal) {

        refreshChart(pieJPanel);

        //REFERSH PANEL FROM PREVIOUS CHART   
        //DATASET PIE
        double carbsData = cal.getCarbsKCAL().getQuantity();
        double energyData = cal.getEnergy().getQuantity();
        double fatData = cal.getFATKCAL().getQuantity();
        double proteinData = cal.getProteinKcal().getQuantity();

        //SET DATASET
        DefaultPieDataset data = new DefaultKeyedValuesDataset();
        data.setValue("Protein", proteinData);
        data.setValue("Fat", fatData);
        data.setValue("Carbohydrates", carbsData);

        //CREATE PIE CHART
        JFreeChart chart = ChartFactory.createPieChart(
                "Calories Proportion. \nTotal " + energyData + " kcal",
                data,
                true,
                false,
                false
        );

        //CONFIGURE HOW DATA IS DISPLAYED
        PiePlot plot = (PiePlot) chart.getPlot();
        plot.setLabelFont(new Font("SansSerif", Font.PLAIN, 10));

        plot.setSectionPaint("Protein", Color.GREEN);
        plot.setSectionPaint("Fat", Color.YELLOW);
        plot.setSectionPaint("Carbohydrates", Color.MAGENTA);

        //CONFIGURE LABELS
        PieSectionLabelGenerator gen = new StandardPieSectionLabelGenerator(
                "{0}: {1} ({2})", new DecimalFormat("0kcal"), new DecimalFormat("0%"));
        plot.setLabelGenerator(gen);

        //PIE CONFIG
        ChartPanel myChart = new ChartPanel(chart, 400, 250, 350, 230, 350, 230, true, false, true, true, false, false);
        myChart.setMouseWheelEnabled(true);

        //HOW PIE IS SITTING IN JPANEL
        pieJPanel.setLayout(new java.awt.BorderLayout());
        pieJPanel.add(myChart, BorderLayout.CENTER);
        pieJPanel.validate();
        pieJPanel.setVisible(true);
    }

    private void getVitamins(NutrientsCollection nutrients) {

        //Table 
        DefaultTableModel tableModel = (DefaultTableModel) grdNutrients.getModel();

        //FOR EACH NEXT QUERY RESET ROWS IN TABLE
        tableModel.setRowCount(0);

        //RowData
        Object rowData[] = new Object[4];

        nutrients.getVitaminsCollection().entrySet().stream().forEach(entry -> {
            rowData[0] = entry.getValue().getLabel();
            rowData[1] = entry.getValue().getQuantity();
            rowData[2] = entry.getValue().getUnit();
            tableModel.addRow(rowData);
        });

        grdNutrients.setAutoCreateRowSorter(true);

        //SHOW VITAMINS
        jVitaminsTable.setVisible(true);

    }

    private void getNutrientsChart(TotalNutrients nutrients) {
        refreshChart(barJPanel);

        double carbs = nutrients.getCarbs() != null ? nutrients.getCarbs().getQuantity() : 0;
        double fat = nutrients.getFAT() != null ? nutrients.getFAT().getQuantity() : 0;
        double fiber = nutrients.getFiber() != null ? nutrients.getFiber().getQuantity() : 0;
        double protein = nutrients.getProtein() != null ? nutrients.getProtein().getQuantity() : 0;
        double sugar = nutrients.getSUGAR() != null ? nutrients.getSUGAR().getQuantity() : 0;

        //DATASET BAR
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.setValue(carbs, "Nutrients gramms", "Carbs");
        dataset.setValue(fat, "Nutrients gramms", "Fat");
        dataset.setValue(fiber, "Nutrients gramms", "Fiber");
        dataset.setValue(protein, "Nutrients gramms", "Protein");
        dataset.setValue(sugar, "Nutrients gramms", "Sugar");

        //BAR CONFIG
        JFreeChart bar = ChartFactory.createBarChart("Nutrients (G)", "", "Gramms", dataset, PlotOrientation.VERTICAL, false, true, false);

        ChartPanel barNutrientsPanel = new ChartPanel(bar);
        barNutrientsPanel.setPreferredSize(new Dimension(400, 250));

        CategoryPlot plot = (CategoryPlot) bar.getPlot();
        BarRenderer barRenderer = (BarRenderer) plot.getRenderer();

        barRenderer.setSeriesPaint(0, Color.BLUE);

        //HOW PIE IS SITTING IN JPANEL
        barJPanel.setLayout(new java.awt.BorderLayout());
        barJPanel.add(barNutrientsPanel, BorderLayout.CENTER);
        barJPanel.validate();

        barJPanel.setVisible(true);

    }

    /**
     * REMOVES ALL ELEMENTS FROM PANEL AND REFRESHES IT
     */
    private void refreshChart(JPanel panel) {
        panel.removeAll();
        panel.revalidate();

    }

    private void setInitialPanelsVisibility() {
        panLabel.setVisible(false);
        pieJPanel.setVisible(false);
        barJPanel.setVisible(false);
        jVitaminsTable.setVisible(false);
    }


    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed

        try {

            //GET VALUE FROM FROM FIELD SEARCH
            String srchWord = txtSearch.getText().trim();

            if (srchWord.trim().equals("")) {
                JOptionPane.showMessageDialog(this, "Please fill in the search field");
                return;
            }

            //SEARCH
            NutrientsCollection nutrients = app.queryData(srchWord);

            if (!app.getErrors().isEmpty()) {
                app.getErrors().stream().forEach(err -> JOptionPane.showMessageDialog(this, err.getDescription()));
                return;
            
            }
            if (nutrients != null) {

                //PRINT LABEL 
                this.getLabel(nutrients);

                //SHOW CHARTS 
                //KCAL PROPORTION
                getCaloriesProportion(nutrients.getTotalKcal());
                //BAR NUTRIENTS GRAMS
                getNutrientsChart(nutrients.getTotalNutrients());
                //VITAMINS TABLE
                getVitamins(nutrients);
            } else {
              
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


    }//GEN-LAST:event_btnSearchActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        setVisible(false);
        dispose(); //Destroy the JFrame object
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
        AboutForm f = new AboutForm();
        f.setVisible(true);

    }//GEN-LAST:event_jMenuItem2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AppForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AppForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AppForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AppForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AppForm().setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel barJPanel;
    private javax.swing.JButton btnSearch;
    private javax.swing.JTable grdNutrients;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator10;
    private javax.swing.JSeparator jSeparator11;
    private javax.swing.JSeparator jSeparator12;
    private javax.swing.JSeparator jSeparator13;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
    private javax.swing.JTabbedPane jVitaminsTable;
    private javax.swing.JLabel lblCalories;
    private javax.swing.JLabel lblCarbG;
    private javax.swing.JLabel lblCarbsD;
    private javax.swing.JLabel lblFat;
    private javax.swing.JLabel lblFatMg;
    private javax.swing.JLabel lblFiberD;
    private javax.swing.JLabel lblFiberG;
    private javax.swing.JLabel lblMonoD;
    private javax.swing.JLabel lblMonoG;
    private javax.swing.JLabel lblPolyD;
    private javax.swing.JLabel lblPolyG;
    private javax.swing.JLabel lblProteinD;
    private javax.swing.JLabel lblProteinG;
    private javax.swing.JLabel lblSatD;
    private javax.swing.JLabel lblSaturatedMg;
    private javax.swing.JLabel lblSugarD;
    private javax.swing.JLabel lblSugarG;
    private javax.swing.JPanel panLabel;
    private javax.swing.JPanel pieJPanel;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}
