/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.tyaa.java.portal.springboot.gae.client.viewcontroller;

import java.util.ArrayList;
import java.util.List;
import org.teavm.flavour.templates.BindTemplate;

/**
 *
 * @author yurii
 */
@BindTemplate("templates/fibonacci.html")
public class Fibonacci {
    
    private List<Integer> values = new ArrayList<>();

    public Fibonacci() {
        values.add(0);
        values.add(1);
    }

    public List<Integer> getValues() {
        return values;
    }

    public void next() {
        values.add(values.get(values.size() - 2) + values.get(values.size() - 1));
    }
}
