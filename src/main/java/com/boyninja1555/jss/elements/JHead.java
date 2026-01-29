package com.boyninja1555.jss.elements;

import com.boyninja1555.jss.JElement;
import org.jetbrains.annotations.ApiStatus;

import java.util.List;
import java.util.Map;

public class JHead extends JElement {

    /**
     * Creates a head section
     * @param children JElement(s)
     */
    @ApiStatus.Internal
    public JHead(List<JElement> children) {
        super("head", Map.of(), false, children);
    }
}
