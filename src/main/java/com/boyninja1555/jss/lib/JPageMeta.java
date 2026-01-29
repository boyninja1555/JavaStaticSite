package com.boyninja1555.jss.lib;

import com.boyninja1555.jss.elements.JHead;
import com.boyninja1555.jss.elements.JTitle;

import java.util.List;

public record JPageMeta(Lang language, String title) {
    public enum Lang {
        ENGLISH("en"),
        JAPANESE("ja");

        public final String value;

        Lang(String value) {
            this.value = value;
        }
    }

    public JHead serialize() {
        return new JHead(List.of(
                new JTitle(title)
        ));
    }
}
