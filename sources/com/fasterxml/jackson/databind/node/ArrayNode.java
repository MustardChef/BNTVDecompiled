package com.fasterxml.jackson.databind.node;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonPointer;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.type.WritableTypeId;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import com.fasterxml.jackson.databind.util.RawValue;
import java.io.IOException;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public class ArrayNode extends ContainerNode<ArrayNode> implements Serializable {
    private static final long serialVersionUID = 1;
    private final List<JsonNode> _children;

    @Override // com.fasterxml.jackson.databind.node.ContainerNode, com.fasterxml.jackson.databind.JsonNode, com.fasterxml.jackson.core.TreeNode
    public JsonNode get(String str) {
        return null;
    }

    @Override // com.fasterxml.jackson.databind.JsonNode, com.fasterxml.jackson.core.TreeNode
    public boolean isArray() {
        return true;
    }

    public ArrayNode(JsonNodeFactory jsonNodeFactory) {
        super(jsonNodeFactory);
        this._children = new ArrayList();
    }

    public ArrayNode(JsonNodeFactory jsonNodeFactory, int i) {
        super(jsonNodeFactory);
        this._children = new ArrayList(i);
    }

    public ArrayNode(JsonNodeFactory jsonNodeFactory, List<JsonNode> list) {
        super(jsonNodeFactory);
        this._children = list;
    }

    @Override // com.fasterxml.jackson.databind.JsonNode
    protected JsonNode _at(JsonPointer jsonPointer) {
        return get(jsonPointer.getMatchingIndex());
    }

    @Override // com.fasterxml.jackson.databind.JsonNode
    public ArrayNode deepCopy() {
        ArrayNode arrayNode = new ArrayNode(this._nodeFactory);
        for (JsonNode jsonNode : this._children) {
            arrayNode._children.add(jsonNode.deepCopy());
        }
        return arrayNode;
    }

    @Override // com.fasterxml.jackson.databind.JsonSerializable.Base
    public boolean isEmpty(SerializerProvider serializerProvider) {
        return this._children.isEmpty();
    }

    @Override // com.fasterxml.jackson.databind.JsonNode
    public JsonNodeType getNodeType() {
        return JsonNodeType.ARRAY;
    }

    @Override // com.fasterxml.jackson.databind.node.ContainerNode, com.fasterxml.jackson.databind.node.BaseJsonNode, com.fasterxml.jackson.core.TreeNode
    public JsonToken asToken() {
        return JsonToken.START_ARRAY;
    }

    @Override // com.fasterxml.jackson.databind.node.ContainerNode, com.fasterxml.jackson.databind.JsonNode, com.fasterxml.jackson.core.TreeNode
    public int size() {
        return this._children.size();
    }

    @Override // com.fasterxml.jackson.databind.JsonNode
    public boolean isEmpty() {
        return this._children.isEmpty();
    }

    @Override // com.fasterxml.jackson.databind.JsonNode
    public Iterator<JsonNode> elements() {
        return this._children.iterator();
    }

    @Override // com.fasterxml.jackson.databind.node.ContainerNode, com.fasterxml.jackson.databind.JsonNode, com.fasterxml.jackson.core.TreeNode
    public JsonNode get(int i) {
        if (i < 0 || i >= this._children.size()) {
            return null;
        }
        return this._children.get(i);
    }

    @Override // com.fasterxml.jackson.databind.JsonNode, com.fasterxml.jackson.core.TreeNode
    public JsonNode path(String str) {
        return MissingNode.getInstance();
    }

    @Override // com.fasterxml.jackson.databind.JsonNode, com.fasterxml.jackson.core.TreeNode
    public JsonNode path(int i) {
        if (i >= 0 && i < this._children.size()) {
            return this._children.get(i);
        }
        return MissingNode.getInstance();
    }

    @Override // com.fasterxml.jackson.databind.node.BaseJsonNode, com.fasterxml.jackson.databind.JsonNode
    public JsonNode required(int i) {
        if (i >= 0 && i < this._children.size()) {
            return this._children.get(i);
        }
        return (JsonNode) _reportRequiredViolation("No value at index #%d [0, %d) of `ArrayNode`", Integer.valueOf(i), Integer.valueOf(this._children.size()));
    }

    @Override // com.fasterxml.jackson.databind.JsonNode
    public boolean equals(Comparator<JsonNode> comparator, JsonNode jsonNode) {
        if (jsonNode instanceof ArrayNode) {
            ArrayNode arrayNode = (ArrayNode) jsonNode;
            int size = this._children.size();
            if (arrayNode.size() != size) {
                return false;
            }
            List<JsonNode> list = this._children;
            List<JsonNode> list2 = arrayNode._children;
            for (int i = 0; i < size; i++) {
                if (!list.get(i).equals(comparator, list2.get(i))) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    @Override // com.fasterxml.jackson.databind.node.BaseJsonNode, com.fasterxml.jackson.databind.JsonSerializable
    public void serialize(JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        List<JsonNode> list = this._children;
        int size = list.size();
        jsonGenerator.writeStartArray(this, size);
        for (int i = 0; i < size; i++) {
            ((BaseJsonNode) list.get(i)).serialize(jsonGenerator, serializerProvider);
        }
        jsonGenerator.writeEndArray();
    }

    @Override // com.fasterxml.jackson.databind.node.BaseJsonNode, com.fasterxml.jackson.databind.JsonSerializable
    public void serializeWithType(JsonGenerator jsonGenerator, SerializerProvider serializerProvider, TypeSerializer typeSerializer) throws IOException {
        WritableTypeId writeTypePrefix = typeSerializer.writeTypePrefix(jsonGenerator, typeSerializer.typeId(this, JsonToken.START_ARRAY));
        Iterator<JsonNode> it = this._children.iterator();
        while (it.hasNext()) {
            ((BaseJsonNode) it.next()).serialize(jsonGenerator, serializerProvider);
        }
        typeSerializer.writeTypeSuffix(jsonGenerator, writeTypePrefix);
    }

    @Override // com.fasterxml.jackson.databind.JsonNode
    public JsonNode findValue(String str) {
        for (JsonNode jsonNode : this._children) {
            JsonNode findValue = jsonNode.findValue(str);
            if (findValue != null) {
                return findValue;
            }
        }
        return null;
    }

    @Override // com.fasterxml.jackson.databind.JsonNode
    public List<JsonNode> findValues(String str, List<JsonNode> list) {
        for (JsonNode jsonNode : this._children) {
            list = jsonNode.findValues(str, list);
        }
        return list;
    }

    @Override // com.fasterxml.jackson.databind.JsonNode
    public List<String> findValuesAsText(String str, List<String> list) {
        for (JsonNode jsonNode : this._children) {
            list = jsonNode.findValuesAsText(str, list);
        }
        return list;
    }

    @Override // com.fasterxml.jackson.databind.JsonNode
    public ObjectNode findParent(String str) {
        for (JsonNode jsonNode : this._children) {
            JsonNode findParent = jsonNode.findParent(str);
            if (findParent != null) {
                return (ObjectNode) findParent;
            }
        }
        return null;
    }

    @Override // com.fasterxml.jackson.databind.JsonNode
    public List<JsonNode> findParents(String str, List<JsonNode> list) {
        for (JsonNode jsonNode : this._children) {
            list = jsonNode.findParents(str, list);
        }
        return list;
    }

    public JsonNode set(int i, JsonNode jsonNode) {
        if (jsonNode == null) {
            jsonNode = nullNode();
        }
        if (i < 0 || i >= this._children.size()) {
            throw new IndexOutOfBoundsException("Illegal index " + i + ", array size " + size());
        }
        return this._children.set(i, jsonNode);
    }

    public ArrayNode add(JsonNode jsonNode) {
        if (jsonNode == null) {
            jsonNode = nullNode();
        }
        _add(jsonNode);
        return this;
    }

    public ArrayNode addAll(ArrayNode arrayNode) {
        this._children.addAll(arrayNode._children);
        return this;
    }

    public ArrayNode addAll(Collection<? extends JsonNode> collection) {
        for (JsonNode jsonNode : collection) {
            add(jsonNode);
        }
        return this;
    }

    public ArrayNode insert(int i, JsonNode jsonNode) {
        if (jsonNode == null) {
            jsonNode = nullNode();
        }
        _insert(i, jsonNode);
        return this;
    }

    public JsonNode remove(int i) {
        if (i < 0 || i >= this._children.size()) {
            return null;
        }
        return this._children.remove(i);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.fasterxml.jackson.databind.node.ContainerNode
    public ArrayNode removeAll() {
        this._children.clear();
        return this;
    }

    public ArrayNode addArray() {
        ArrayNode arrayNode = arrayNode();
        _add(arrayNode);
        return arrayNode;
    }

    public ObjectNode addObject() {
        ObjectNode objectNode = objectNode();
        _add(objectNode);
        return objectNode;
    }

    public ArrayNode addPOJO(Object obj) {
        return _add(obj == null ? nullNode() : pojoNode(obj));
    }

    public ArrayNode addRawValue(RawValue rawValue) {
        return _add(rawValue == null ? nullNode() : rawValueNode(rawValue));
    }

    public ArrayNode addNull() {
        return _add(nullNode());
    }

    public ArrayNode add(short s) {
        return _add(numberNode(s));
    }

    public ArrayNode add(Short sh) {
        return _add(sh == null ? nullNode() : numberNode(sh.shortValue()));
    }

    public ArrayNode add(int i) {
        return _add(numberNode(i));
    }

    public ArrayNode add(Integer num) {
        return _add(num == null ? nullNode() : numberNode(num.intValue()));
    }

    public ArrayNode add(long j) {
        return _add(numberNode(j));
    }

    public ArrayNode add(Long l) {
        return _add(l == null ? nullNode() : numberNode(l.longValue()));
    }

    public ArrayNode add(float f) {
        return _add(numberNode(f));
    }

    public ArrayNode add(Float f) {
        return _add(f == null ? nullNode() : numberNode(f.floatValue()));
    }

    public ArrayNode add(double d) {
        return _add(numberNode(d));
    }

    public ArrayNode add(Double d) {
        return _add(d == null ? nullNode() : numberNode(d.doubleValue()));
    }

    public ArrayNode add(BigDecimal bigDecimal) {
        return _add(bigDecimal == null ? nullNode() : numberNode(bigDecimal));
    }

    public ArrayNode add(BigInteger bigInteger) {
        return _add(bigInteger == null ? nullNode() : numberNode(bigInteger));
    }

    public ArrayNode add(String str) {
        return _add(str == null ? nullNode() : textNode(str));
    }

    public ArrayNode add(boolean z) {
        return _add(booleanNode(z));
    }

    public ArrayNode add(Boolean bool) {
        return _add(bool == null ? nullNode() : booleanNode(bool.booleanValue()));
    }

    public ArrayNode add(byte[] bArr) {
        return _add(bArr == null ? nullNode() : binaryNode(bArr));
    }

    public ArrayNode insertArray(int i) {
        ArrayNode arrayNode = arrayNode();
        _insert(i, arrayNode);
        return arrayNode;
    }

    public ObjectNode insertObject(int i) {
        ObjectNode objectNode = objectNode();
        _insert(i, objectNode);
        return objectNode;
    }

    public ArrayNode insertNull(int i) {
        return _insert(i, nullNode());
    }

    public ArrayNode insertPOJO(int i, Object obj) {
        return _insert(i, obj == null ? nullNode() : pojoNode(obj));
    }

    public ArrayNode insertRawValue(int i, RawValue rawValue) {
        return _insert(i, rawValue == null ? nullNode() : rawValueNode(rawValue));
    }

    public ArrayNode insert(int i, short s) {
        return _insert(i, numberNode(s));
    }

    public ArrayNode insert(int i, Short sh) {
        return _insert(i, sh == null ? nullNode() : numberNode(sh.shortValue()));
    }

    public ArrayNode insert(int i, int i2) {
        return _insert(i, numberNode(i2));
    }

    public ArrayNode insert(int i, Integer num) {
        return _insert(i, num == null ? nullNode() : numberNode(num.intValue()));
    }

    public ArrayNode insert(int i, long j) {
        return _insert(i, numberNode(j));
    }

    public ArrayNode insert(int i, Long l) {
        return _insert(i, l == null ? nullNode() : numberNode(l.longValue()));
    }

    public ArrayNode insert(int i, float f) {
        return _insert(i, numberNode(f));
    }

    public ArrayNode insert(int i, Float f) {
        return _insert(i, f == null ? nullNode() : numberNode(f.floatValue()));
    }

    public ArrayNode insert(int i, double d) {
        return _insert(i, numberNode(d));
    }

    public ArrayNode insert(int i, Double d) {
        return _insert(i, d == null ? nullNode() : numberNode(d.doubleValue()));
    }

    public ArrayNode insert(int i, BigDecimal bigDecimal) {
        return _insert(i, bigDecimal == null ? nullNode() : numberNode(bigDecimal));
    }

    public ArrayNode insert(int i, BigInteger bigInteger) {
        return _insert(i, bigInteger == null ? nullNode() : numberNode(bigInteger));
    }

    public ArrayNode insert(int i, String str) {
        return _insert(i, str == null ? nullNode() : textNode(str));
    }

    public ArrayNode insert(int i, boolean z) {
        return _insert(i, booleanNode(z));
    }

    public ArrayNode insert(int i, Boolean bool) {
        if (bool == null) {
            return insertNull(i);
        }
        return _insert(i, booleanNode(bool.booleanValue()));
    }

    public ArrayNode insert(int i, byte[] bArr) {
        if (bArr == null) {
            return insertNull(i);
        }
        return _insert(i, binaryNode(bArr));
    }

    public ArrayNode setNull(int i) {
        return _set(i, nullNode());
    }

    public ArrayNode setPOJO(int i, Object obj) {
        return _set(i, obj == null ? nullNode() : pojoNode(obj));
    }

    public ArrayNode setRawValue(int i, RawValue rawValue) {
        return _set(i, rawValue == null ? nullNode() : rawValueNode(rawValue));
    }

    public ArrayNode set(int i, short s) {
        return _set(i, numberNode(s));
    }

    public ArrayNode set(int i, Short sh) {
        return _set(i, sh == null ? nullNode() : numberNode(sh.shortValue()));
    }

    public ArrayNode set(int i, int i2) {
        return _set(i, numberNode(i2));
    }

    public ArrayNode set(int i, Integer num) {
        return _set(i, num == null ? nullNode() : numberNode(num.intValue()));
    }

    public ArrayNode set(int i, long j) {
        return _set(i, numberNode(j));
    }

    public ArrayNode set(int i, Long l) {
        return _set(i, l == null ? nullNode() : numberNode(l.longValue()));
    }

    public ArrayNode set(int i, float f) {
        return _set(i, numberNode(f));
    }

    public ArrayNode set(int i, Float f) {
        return _set(i, f == null ? nullNode() : numberNode(f.floatValue()));
    }

    public ArrayNode set(int i, double d) {
        return _set(i, numberNode(d));
    }

    public ArrayNode set(int i, Double d) {
        return _set(i, d == null ? nullNode() : numberNode(d.doubleValue()));
    }

    public ArrayNode set(int i, BigDecimal bigDecimal) {
        return _set(i, bigDecimal == null ? nullNode() : numberNode(bigDecimal));
    }

    public ArrayNode set(int i, BigInteger bigInteger) {
        return _set(i, bigInteger == null ? nullNode() : numberNode(bigInteger));
    }

    public ArrayNode set(int i, String str) {
        return _set(i, str == null ? nullNode() : textNode(str));
    }

    public ArrayNode set(int i, boolean z) {
        return _set(i, booleanNode(z));
    }

    public ArrayNode set(int i, Boolean bool) {
        return _set(i, bool == null ? nullNode() : booleanNode(bool.booleanValue()));
    }

    public ArrayNode set(int i, byte[] bArr) {
        return _set(i, bArr == null ? nullNode() : binaryNode(bArr));
    }

    @Override // com.fasterxml.jackson.databind.JsonNode
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj != null && (obj instanceof ArrayNode)) {
            return this._children.equals(((ArrayNode) obj)._children);
        }
        return false;
    }

    protected boolean _childrenEqual(ArrayNode arrayNode) {
        return this._children.equals(arrayNode._children);
    }

    @Override // com.fasterxml.jackson.databind.node.BaseJsonNode
    public int hashCode() {
        return this._children.hashCode();
    }

    protected ArrayNode _set(int i, JsonNode jsonNode) {
        if (i < 0 || i >= this._children.size()) {
            throw new IndexOutOfBoundsException("Illegal index " + i + ", array size " + size());
        }
        this._children.set(i, jsonNode);
        return this;
    }

    protected ArrayNode _add(JsonNode jsonNode) {
        this._children.add(jsonNode);
        return this;
    }

    protected ArrayNode _insert(int i, JsonNode jsonNode) {
        if (i < 0) {
            this._children.add(0, jsonNode);
        } else if (i >= this._children.size()) {
            this._children.add(jsonNode);
        } else {
            this._children.add(i, jsonNode);
        }
        return this;
    }
}
