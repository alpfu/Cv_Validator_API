package com.jetbrains;

import java.util.ArrayList;
import java.util.Iterator;

public class SourceCode {
    ArrayList<String> sourceCodeTokens;
    ProgrammingLanguage language ;

    public SourceCode(ArrayList<String> sourceCodeTokens, ProgrammingLanguage language) {
        setLanguage(language);
        setSourceCodeTokens(sourceCodeTokens);
    }

    public ArrayList<String> getSourceCodeTokens() {
        return sourceCodeTokens;
    }

    public void setSourceCodeTokens(ArrayList<String> sourceCodeTokens) {
        this.sourceCodeTokens = sourceCodeTokens;
    }

    public ProgrammingLanguage getLanguage() {
        return language;
    }

    public void setLanguage(ProgrammingLanguage language) {
        this.language = language;
    }

    @Override
    public String toString() {
        Iterator<String> it = getSourceCodeTokens().iterator();
        if (! it.hasNext())
            return null;

        StringBuilder sb = new StringBuilder();
        for (;;) {
            String e = it.next();
            sb.append(e);
            if (! it.hasNext())
                return sb.toString();
            sb.append(' ');
        }
    }
}
