package com.fasterxml.jackson.core;

import java.io.IOException;

/* loaded from: classes2.dex */
public abstract class TreeCodec {
    public abstract TreeNode createArrayNode();

    public abstract TreeNode createObjectNode();

    public TreeNode missingNode() {
        return null;
    }

    public TreeNode nullNode() {
        return null;
    }

    public abstract <T extends TreeNode> T readTree(JsonParser jsonParser) throws IOException, JsonProcessingException;

    public abstract JsonParser treeAsTokens(TreeNode treeNode);

    public abstract void writeTree(JsonGenerator jsonGenerator, TreeNode treeNode) throws IOException, JsonProcessingException;
}
