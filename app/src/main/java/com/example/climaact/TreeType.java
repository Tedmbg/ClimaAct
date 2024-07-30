package com.example.climaact;

public class TreeType {
    private String treeName;
    private String treeDescription;

    public TreeType(String treeName, String treeDescription) {
        this.treeName = treeName;
        this.treeDescription = treeDescription;
    }

    public String getTreeName() {
        return treeName;
    }

    public String getTreeDescription() {
        return treeDescription;
    }
}
