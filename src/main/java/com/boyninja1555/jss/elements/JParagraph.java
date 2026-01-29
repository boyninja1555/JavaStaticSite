package com.boyninja1555.jss.elements;

import com.boyninja1555.jss.JElement;
import com.boyninja1555.jss.elements.custom.JTextNode;
import org.jetbrains.annotations.ApiStatus;

import java.util.List;
import java.util.Map;

public class JParagraph extends JElement {

    /**
     * Creates a paragraph made of text and other elements
     * @param children JTextNode(s) and other JElement(s)
     */
    @ApiStatus.Internal
    public JParagraph(List<JElement> children) {
        super("p", Map.of(), false, children);
    }

    /**
     * Creates a paragraph made of just text
     * @param text Text
     */
    public JParagraph(String text) {
        super("p", Map.of(), false, List.of(new JTextNode(text)));
    }
}
