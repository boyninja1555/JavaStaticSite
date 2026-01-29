package com.boyninja1555.jss.elements;

import com.boyninja1555.jss.JElement;
import org.jetbrains.annotations.ApiStatus;

import java.util.Map;

public class JLink extends JElement {
    public enum Rel {
        STYLESHEET("stylesheet");

        public final String value;

        Rel(String value) {
            this.value = value;
        }
    }

    /**
     * Creates a link (not hyperlink, this is for loading certain resources)
     * @param rel Resource type
     * @param href Resource URL
     */
    @ApiStatus.Internal
    public JLink(Rel rel, String href) {
        super("head", Map.of(
                "rel", rel.value,
                "href", href
        ), true);
    }
}
