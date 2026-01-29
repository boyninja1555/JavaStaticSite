package com.boyninja1555.jss;

import org.jetbrains.annotations.ApiStatus;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ApiStatus.Internal
public class JElement {
    private final String name;
    private final Map<String, String> attributes;
    private final boolean selfClosing;
    private final List<JElement> children;
    private final String text;

    public JElement(String name, Map<String, String> attributes, boolean selfClosing, List<JElement> children) {
        this.name = name;
        this.attributes = attributes;
        this.selfClosing = selfClosing;
        this.children = children;
        this.text = null;
    }

    public JElement(String name, Map<String, String> attributes, boolean selfClosing) {
        this.name = name;
        this.attributes = attributes;
        this.selfClosing = selfClosing;
        this.children = List.of();
        this.text = null;
    }

    public JElement(String text) {
        this.name = null;
        this.attributes = new HashMap<>();
        this.selfClosing = false;
        this.children = List.of();
        this.text = text;
    }

    public void appendChild(JElement child) {
        children.add(child);
    }

    public String toString() {
        StringBuilder tag = new StringBuilder();

        if (name != null)
            tag.append("<").append(name);

        if (text == null)
            attributes.forEach((k, v) -> tag.append(" ")
                    .append(k)
                    .append("=\"")
                    .append(v)
                    .append("\""));

        if (selfClosing)
            return tag + " />";
        else if (text == null)
            tag.append(">");
        else
            tag.append(text);

        children.forEach(c -> tag.append(c.toString()));

        if (text == null)
            tag.append("</").append(name).append(">");

        return tag.toString();
    }
}
