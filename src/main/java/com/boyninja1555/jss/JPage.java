package com.boyninja1555.jss;

import com.boyninja1555.jss.elements.*;
import com.boyninja1555.jss.lib.JPageMeta;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public abstract class JPage {

    @ApiStatus.OverrideOnly
    @Nullable
    public abstract Map<JLink.Rel, String> imports();

    @ApiStatus.OverrideOnly
    @Nullable
    public abstract JPageMeta meta();

    @ApiStatus.OverrideOnly
    @NotNull
    public abstract JElement structure();

    public boolean isModern() {
        return true;
    }

    public String toString() {
        JPageMeta meta = meta();

        if (meta == null)
            meta = new JPageMeta(JPageMeta.Lang.ENGLISH, "JavaStaticSite");

        JHead headElement = meta.serialize();
        Map<JLink.Rel, String> imports = imports();

        if (imports == null)
            imports = Map.of();

        imports.forEach((r, h) -> headElement.appendChild(new JLink(r, h)));
        JBody bodyElement = new JBody(List.of(structure()));
        JHtml rootElement = new JHtml(meta.language(), headElement, bodyElement);
        String root = rootElement.toString();

        if (isModern())
            root = "<!doctype html>\n" + root;

        return root;
    }

    public void toFile(File file) throws IOException {
        if (!file.exists()) {
            boolean created = file.createNewFile();
            if (!created)
                throw new IOException("Please ensure you can access the " + file.getParentFile() + " directory");
        }

        BufferedWriter writer = new BufferedWriter(new FileWriter(file));
        writer.write(toString());
        writer.flush();
    }
}
