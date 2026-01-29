package com.boyninja1555.jss.elements;

import com.boyninja1555.jss.JElement;
import org.jetbrains.annotations.ApiStatus;

import java.util.List;
import java.util.Map;

public class JBody extends JElement {

    /**
     * Creates a body section
     * @param children JElement(s)
     */
    @ApiStatus.Internal
    public JBody(List<JElement> children) {
        super("body", Map.of(), false, children);
    }
}
