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
import java.awt.Toolkit;
import org.jfree.chart.ChartFactory;

import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.util.Rotation;

import javax.swing.*;
import java.util.ArrayList;


public class HappinessBarChart extends JFrame {
    private static final long serialVersionUID = 1L;
    private Shop shop;
    private String domainLabel;
    private String rangeLabel;

    public HappinessBarChart(String applicationTitle, String chartTitle, Shop s, String d, String r) {
        super(applicationTitle);
        // This will create the dataset
        this.shop = s;
        this.domainLabel = d;
        this.rangeLabel = r;
        DefaultCategoryDataset dataset = createDataset();
        // based on the dataset we create the chart
        JFreeChart chart = createChart(dataset, chartTitle);
        // we put the chart into a panel
        ChartPanel chartPanel = new ChartPanel(chart);
        // default size
        chartPanel.setPreferredSize(new java.awt.Dimension(500, 270));
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        int w = this.getSize().width;
        int h = this.getSize().height;
        int x = (dim.width - w) / 3;
        int y = (dim.height - h) / 3;
        this.setLocation(x, y);
        // add it to our application
        setContentPane(chartPanel);
        

    }


    /**
     * Creates a sample dataset
     */

    private  DefaultCategoryDataset createDataset() {
        DefaultCategoryDataset result = new DefaultCategoryDataset();
        ArrayList<Customer> customers = this.shop.sendCustomer();
        for(int i=0; i< customers.size(); i++) {
            Customer  customer = customers.get(i);
            result.setValue(customer.getLevel_of_Happiness(), customer.getName(), customer.getName());
        }
        return result;

    }


    /**
     * Creates a chart
     */

    private JFreeChart createChart(DefaultCategoryDataset dataset, String title) {

        JFreeChart chart = ChartFactory.createBarChart(title,          // chart title
                domainLabel,
                rangeLabel,
                dataset,
                PlotOrientation.VERTICAL, // orientation
                true,             // include legend?
                false,             // include tooltips?
                false             // include URLs?
                );
        

        return chart;

    }

}

