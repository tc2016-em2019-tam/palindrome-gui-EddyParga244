package com.eddyparga;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ventana extends JFrame {

    private String palabra;

    public Ventana(){
        this.setTitle("Palidromo");
        this.setSize(300,200);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setLayout(new GridLayout(4,1));

        JLabel label = new JLabel("Escribe una palabra:");
        JTextField textField = new JTextField(10);
        JLabel resultado = new JLabel("");
        JButton comprobar = new JButton("Comprobar");

        comprobar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                palabra = textField.getText().toLowerCase().replaceAll("\\s+","");
                resultado.setText(isPalindrome());
            }
        });

        this.add(label);
        this.add(textField);
        this.add(resultado);
        this.add(comprobar);

        this.setVisible(true);
    }

    public String isPalindrome(){
        Stack stack = new Stack();

        String inverso = "";

        for (int i = 0; i < palabra.length(); i++){
            stack.push(palabra.charAt(i));
        }

        while (!stack.isEmpty()) {
            try {
                inverso = inverso + stack.pop();
            } catch (Exception e) {
                System.out.println(e);
            }
        }

        System.out.println(palabra);
        System.out.println(inverso);
        if (palabra.equals(inverso)) {
            return "La palabra es un palidromo";
        } else {
            return "La palabra no es un palidromo";
        }
    }
}
