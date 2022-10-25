package com.fasterxml.jackson.databind.node;

import com.fasterxml.jackson.core.JsonStreamContext;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.JsonNode;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public abstract class NodeCursor extends JsonStreamContext {
    protected String _currentName;
    protected Object _currentValue;
    protected final NodeCursor _parent;

    public abstract JsonNode currentNode();

    public abstract JsonToken nextToken();

    public abstract NodeCursor startArray();

    public abstract NodeCursor startObject();

    public NodeCursor(int i, NodeCursor nodeCursor) {
        this._type = i;
        this._index = -1;
        this._parent = nodeCursor;
    }

    @Override // com.fasterxml.jackson.core.JsonStreamContext
    public final NodeCursor getParent() {
        return this._parent;
    }

    @Override // com.fasterxml.jackson.core.JsonStreamContext
    public final String getCurrentName() {
        return this._currentName;
    }

    public void overrideCurrentName(String str) {
        this._currentName = str;
    }

    @Override // com.fasterxml.jackson.core.JsonStreamContext
    public Object getCurrentValue() {
        return this._currentValue;
    }

    @Override // com.fasterxml.jackson.core.JsonStreamContext
    public void setCurrentValue(Object obj) {
        this._currentValue = obj;
    }

    public final NodeCursor iterateChildren() {
        JsonNode currentNode = currentNode();
        if (currentNode == null) {
            throw new IllegalStateException("No current node");
        }
        if (currentNode.isArray()) {
            return new ArrayCursor(currentNode, this);
        }
        if (currentNode.isObject()) {
            return new ObjectCursor(currentNode, this);
        }
        throw new IllegalStateException("Current node of type " + currentNode.getClass().getName());
    }

    /* loaded from: classes2.dex */
    protected static final class RootCursor extends NodeCursor {
        protected boolean _done;
        protected JsonNode _node;

        @Override // com.fasterxml.jackson.databind.node.NodeCursor
        public void overrideCurrentName(String str) {
        }

        @Override // com.fasterxml.jackson.databind.node.NodeCursor, com.fasterxml.jackson.core.JsonStreamContext
        public /* bridge */ /* synthetic */ JsonStreamContext getParent() {
            return super.getParent();
        }

        public RootCursor(JsonNode jsonNode, NodeCursor nodeCursor) {
            super(0, nodeCursor);
            this._done = false;
            this._node = jsonNode;
        }

        @Override // com.fasterxml.jackson.databind.node.NodeCursor
        public JsonToken nextToken() {
            if (!this._done) {
                this._index++;
                this._done = true;
                return this._node.asToken();
            }
            this._node = null;
            return null;
        }

        @Override // com.fasterxml.jackson.databind.node.NodeCursor
        public JsonNode currentNode() {
            if (this._done) {
                return this._node;
            }
            return null;
        }

        @Override // com.fasterxml.jackson.databind.node.NodeCursor
        public NodeCursor startArray() {
            return new ArrayCursor(this._node, this);
        }

        @Override // com.fasterxml.jackson.databind.node.NodeCursor
        public NodeCursor startObject() {
            return new ObjectCursor(this._node, this);
        }
    }

    /* loaded from: classes2.dex */
    protected static final class ArrayCursor extends NodeCursor {
        protected Iterator<JsonNode> _contents;
        protected JsonNode _currentElement;

        @Override // com.fasterxml.jackson.databind.node.NodeCursor, com.fasterxml.jackson.core.JsonStreamContext
        public /* bridge */ /* synthetic */ JsonStreamContext getParent() {
            return super.getParent();
        }

        public ArrayCursor(JsonNode jsonNode, NodeCursor nodeCursor) {
            super(1, nodeCursor);
            this._contents = jsonNode.elements();
        }

        @Override // com.fasterxml.jackson.databind.node.NodeCursor
        public JsonToken nextToken() {
            if (!this._contents.hasNext()) {
                this._currentElement = null;
                return JsonToken.END_ARRAY;
            }
            this._index++;
            JsonNode next = this._contents.next();
            this._currentElement = next;
            return next.asToken();
        }

        @Override // com.fasterxml.jackson.databind.node.NodeCursor
        public JsonNode currentNode() {
            return this._currentElement;
        }

        @Override // com.fasterxml.jackson.databind.node.NodeCursor
        public NodeCursor startArray() {
            return new ArrayCursor(this._currentElement, this);
        }

        @Override // com.fasterxml.jackson.databind.node.NodeCursor
        public NodeCursor startObject() {
            return new ObjectCursor(this._currentElement, this);
        }
    }

    /* loaded from: classes2.dex */
    protected static final class ObjectCursor extends NodeCursor {
        protected Iterator<Map.Entry<String, JsonNode>> _contents;
        protected Map.Entry<String, JsonNode> _current;
        protected boolean _needEntry;

        @Override // com.fasterxml.jackson.databind.node.NodeCursor, com.fasterxml.jackson.core.JsonStreamContext
        public /* bridge */ /* synthetic */ JsonStreamContext getParent() {
            return super.getParent();
        }

        public ObjectCursor(JsonNode jsonNode, NodeCursor nodeCursor) {
            super(2, nodeCursor);
            this._contents = ((ObjectNode) jsonNode).fields();
            this._needEntry = true;
        }

        @Override // com.fasterxml.jackson.databind.node.NodeCursor
        public JsonToken nextToken() {
            if (this._needEntry) {
                if (!this._contents.hasNext()) {
                    this._currentName = null;
                    this._current = null;
                    return JsonToken.END_OBJECT;
                }
                this._index++;
                this._needEntry = false;
                Map.Entry<String, JsonNode> next = this._contents.next();
                this._current = next;
                this._currentName = next != null ? next.getKey() : null;
                return JsonToken.FIELD_NAME;
            }
            this._needEntry = true;
            return this._current.getValue().asToken();
        }

        @Override // com.fasterxml.jackson.databind.node.NodeCursor
        public JsonNode currentNode() {
            Map.Entry<String, JsonNode> entry = this._current;
            if (entry == null) {
                return null;
            }
            return entry.getValue();
        }

        @Override // com.fasterxml.jackson.databind.node.NodeCursor
        public NodeCursor startArray() {
            return new ArrayCursor(currentNode(), this);
        }

        @Override // com.fasterxml.jackson.databind.node.NodeCursor
        public NodeCursor startObject() {
            return new ObjectCursor(currentNode(), this);
        }
    }
}
