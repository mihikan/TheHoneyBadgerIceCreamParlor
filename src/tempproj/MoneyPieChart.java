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
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.util.Rotation;

import javax.swing.*;
import java.util.ArrayList;


public class MoneyPieChart extends JFrame {
    private static final long serialVersionUID = 1L;
    private Shop shop;

    public MoneyPieChart(String applicationTitle, String chartTitle, Shop s) {
        super(applicationTitle);
        // This will create the dataset
        this.shop = s;
        PieDataset dataset = createDataset();
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

    private  PieDataset createDataset() {
        DefaultPieDataset result = new DefaultPieDataset();
        ArrayList<Worker> workers = this.shop.sendWorker();
        for(int i=0; i< workers.size(); i++) {
            Worker  worker = workers.get(i);
            result.setValue(worker.getName_worker(), worker.getMoney_taken_in());
        }
        return result;

    }


    /**
     * Creates a chart
     */

    private JFreeChart createChart(PieDataset dataset, String title) {

        JFreeChart chart = ChartFactory.createPieChart3D(title,          // chart title
                dataset,                // data
                true,                   // include legend
                true,
                false);

        PiePlot3D plot = (PiePlot3D) chart.getPlot();
        plot.setStartAngle(290);
        plot.setDirection(Rotation.CLOCKWISE);
        plot.setForegroundAlpha(0.5f);
        return chart;

    }

}

