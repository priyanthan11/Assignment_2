/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.assingment2;
import javax.swing.*;
import java.awt.*;

public class PaymentPopup {
    private JFrame parentFrame; // Reference to the parent frame
    private JLabel balanceLabel; // Reference to the balance label in the main window
    private double remainingBalance; // The remaining balance to update

    public PaymentPopup(JFrame parentFrame, JLabel balanceLabel, double remainingBalance) {
        this.parentFrame = parentFrame;
        this.balanceLabel = balanceLabel;
        this.remainingBalance = remainingBalance;
    }

    // Method to show the payment pop-up
    public void show() {
        // Create a JDialog for the payment window
        JDialog paymentDialog = new JDialog(parentFrame, "Make a Payment", true);
        paymentDialog.setSize(300, 200);
        paymentDialog.setLayout(new FlowLayout());

        // Create a label and text field for input
        JLabel inputLabel = new JLabel("Enter Payment Amount:");
        JTextField inputField = new JTextField(15);

        // Create a button to submit the payment
        JButton submitButton = new JButton("Submit");

        // Add components to the dialog
        paymentDialog.add(inputLabel);
        paymentDialog.add(inputField);
        paymentDialog.add(submitButton);

        // Add ActionListener to the Submit button
        submitButton.addActionListener(e -> {
            try {
                // Parse the input amount
                double payment = Double.parseDouble(inputField.getText());

                // Check if payment is valid
                if (payment <= 0) {
                    JOptionPane.showMessageDialog(paymentDialog, "Payment must be greater than 0.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                if (payment > remainingBalance) {
                    JOptionPane.showMessageDialog(paymentDialog, "Payment exceeds remaining balance.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // Subtract payment from the remaining balance
                remainingBalance -= payment;

                // Update the balance label in the main window
                balanceLabel.setText("Remaining Balance: £" + remainingBalance);

                // Close the payment dialog
                paymentDialog.dispose();

                // Show success message
                JOptionPane.showMessageDialog(parentFrame, "Payment successful! Remaining balance: $" + remainingBalance, "Success", JOptionPane.INFORMATION_MESSAGE);

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(paymentDialog, "Invalid input. Please enter a valid number.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        // Center the dialog relative to the parent
        paymentDialog.setLocationRelativeTo(parentFrame);

        // Make the dialog visible
        paymentDialog.setVisible(true);
    }
}

