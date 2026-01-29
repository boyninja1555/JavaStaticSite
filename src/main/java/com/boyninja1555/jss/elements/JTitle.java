package com.boyninja1555.jss.elements;

import com.boyninja1555.jss.JElement;
import com.boyninja1555.jss.elements.custom.JTextNode;

import java.util.List;
import java.util.Map;

public class JTitle extends JElement {

    /**
     * Creates a text-based page title
     * @param title Title
     */
    public JTitle(String title) {
        super("title", Map.of(), false, List.of(new JTextNode(title)));
    }
}
