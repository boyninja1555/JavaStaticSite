package com.boyninja1555.jss_example;

import com.boyninja1555.jss.JElement;
import com.boyninja1555.jss.JPage;
import com.boyninja1555.jss.elements.JLink;
import com.boyninja1555.jss.elements.JParagraph;
import com.boyninja1555.jss.lib.JPageMeta;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.File;
import java.io.IOException;
import java.util.Map;

public class HomePage extends JPage {

    static void main() throws IOException {
        HomePage page = new HomePage();
        page.toFile(new File("home.html"));
    }

    @Override
    @Nullable
    public Map<JLink.Rel, String> imports() {
        return Map.of();
    }

    @Override
    @Nullable
    public JPageMeta meta() {
        return null;
    }

    @Override
    @NotNull
    public JElement structure() {
        return new JParagraph("Hello!");
    }
}
