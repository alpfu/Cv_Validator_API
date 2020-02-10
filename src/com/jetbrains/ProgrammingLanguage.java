package com.jetbrains;

public class ProgrammingLanguage {
    String name;
    String versionIndex;

    public ProgrammingLanguage(String name, String versionIndex) {
        setName(name);
        setVersionIndex(versionIndex);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVersionIndex() {
        return versionIndex;
    }

    public void setVersionIndex(String versionIndex) {
        this.versionIndex = versionIndex;
    }
}
