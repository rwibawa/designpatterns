package com.avisow.designpatterns.behavioralpatterns.strategy;

public class App2 {
    public static void main(String[] args) {
        TextFormatter formatter = new CapTextFormatter();
        TextEditor editor = new TextEditor(formatter);
        editor.publishText("Testing text in caps formatter");

        formatter = new LowerTextFormatter();
        editor = new TextEditor(formatter);
        editor.publishText("Testing text in lowercase formatter");
    }
}

class TextEditor {
    private final TextFormatter textFormatter;

    public TextEditor(TextFormatter textFormatter){
        this.textFormatter = textFormatter;
    }

    public void publishText(String text){
        textFormatter.format(text);
    }
}

interface TextFormatter {
    void format(String text);
}

class ArialTextFormatter implements TextFormatter {
    @Override
    public void format(String text) {
        System.out.println("[ArialTextFormatter]: "+text);
    }
}

class CapTextFormatter implements TextFormatter {
    @Override
    public void format(String text) {
        System.out.println("[CapTextFormatter]: "+text.toUpperCase());
    }
}

class LowerTextFormatter implements TextFormatter {
    @Override
    public void format(String text) {
        System.out.println("[LowerTextFormatter]: "+text.toLowerCase());
    }
}