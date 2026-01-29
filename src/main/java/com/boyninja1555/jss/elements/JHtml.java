package com.boyninja1555.jss.elements;

import com.boyninja1555.jss.JElement;
import com.boyninja1555.jss.lib.JPageMeta;
import org.jetbrains.annotations.ApiStatus;

import java.util.List;
import java.util.Map;

public class JHtml extends JElement {

    /**
     * Creates the root HTML element
     * @param head Head element (page meta)
     * @param body Body element (page structure/HTML)
     */
    @ApiStatus.Internal
    public JHtml(JPageMeta.Lang language, JHead head, JBody body) {
        super("html", Map.of("lang", language.value), false, List.of(head, body));
    }
}
