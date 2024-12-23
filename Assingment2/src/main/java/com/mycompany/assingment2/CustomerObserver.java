/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.assingment2;

import java.util.ArrayList;
import javax.swing.JComboBox;

/**
 *
 * @author priya
 */
interface CustomerObserver {
    void update(JComboBox<String> customerCombo);
    JComboBox<String> getComboBox();
}
