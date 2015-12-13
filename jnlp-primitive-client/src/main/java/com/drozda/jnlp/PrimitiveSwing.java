package com.drozda.jnlp;

import javax.swing.*;

/**
 * Created by GFH on 12.12.2015.
 */
public class PrimitiveSwing {
    public static void main(String[] args) {
        JFrame frame = new JFrame("HelloPrimitiveSwing");
        final JLabel label = new JLabel("Hello jnlp World");
        frame.getContentPane().add(label);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
