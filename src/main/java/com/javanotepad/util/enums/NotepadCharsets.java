package com.javanotepad.util.enums;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public enum NotepadCharsets {
    utf_8(StandardCharsets.UTF_8),
    utf_16(StandardCharsets.UTF_16),
    utf_16be(StandardCharsets.UTF_16BE),
    utf_16le(StandardCharsets.UTF_16LE),
    us_ascii(StandardCharsets.US_ASCII),
    iso_8859_1(StandardCharsets.ISO_8859_1);

    private Charset charset;

    public Charset getCharset() {
        return charset;
    }

    private NotepadCharsets(Charset charset) {
        this.charset = charset;
    }
}
