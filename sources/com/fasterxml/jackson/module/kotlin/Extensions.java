package com.fasterxml.jackson.module.kotlin;

import androidx.exifinterface.media.ExifInterface;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.TreeNode;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.module.kotlin.KotlinModule;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.File;
import java.io.InputStream;
import java.io.Reader;
import java.lang.annotation.Annotation;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.URL;
import java.util.BitSet;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmClassMapping;
import kotlin.jvm.JvmInline;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

@Metadata(m108d1 = {"\u0000ò\u0001\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\u0010\u0006\n\u0002\u0010\u0007\n\u0002\u0010\t\n\u0002\u0010\n\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010(\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0006\u0010\u0000\u001a\u00020\u0001\u001a\u0006\u0010\u0002\u001a\u00020\u0003\u001a\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00060\u0005\"\u0006\b\u0000\u0010\u0006\u0018\u0001H\u0086\b\u001a!\u0010\u0007\u001a\u00020\b2\u0019\b\u0002\u0010\t\u001a\u0013\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\u0002\b\f\u001a!\u0010\r\u001a\u00020\u000e2\u0019\b\u0002\u0010\t\u001a\u0013\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\u0002\b\f\u001a5\u0010\u0010\u001a\u00020\u0011\"\n\b\u0000\u0010\u0006\u0018\u0001*\u00020\u0012*\u00020\u00112\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u0002H\u00060\u00142\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u0002H\u00060\u0016H\u0086\b\u001a5\u0010\u0017\u001a\u00020\u0011\"\n\b\u0000\u0010\u0006\u0018\u0001*\u00020\u0012*\u00020\u00112\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u0002H\u00060\u00142\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u0002H\u00060\u0019H\u0086\b\u001a\u0015\u0010\u001a\u001a\u00020\u001b*\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0086\u0002\u001a\u0015\u0010\u001a\u001a\u00020\u001b*\u00020\u001c2\u0006\u0010\u001f\u001a\u00020 H\u0086\u0002\u001a\"\u0010!\u001a\u0002H\u0006\"\u0006\b\u0000\u0010\u0006\u0018\u0001*\u00020\u00032\u0006\u0010\"\u001a\u00020\u0012H\u0086\b¢\u0006\u0002\u0010#\u001a\u0010\u0010$\u001a\u00020\u001b*\u0006\u0012\u0002\b\u00030%H\u0000\u001a\u0015\u0010&\u001a\u00020\u000b*\u00020'2\u0006\u0010\u001d\u001a\u00020\u001eH\u0086\u0002\u001a\u0015\u0010&\u001a\u00020\u000b*\u00020(2\u0006\u0010\u001f\u001a\u00020 H\u0086\u0002\u001a\u001b\u0010&\u001a\u00020\u000b*\u00020(2\f\u0010)\u001a\b\u0012\u0004\u0012\u00020 0*H\u0086\u0002\u001a\u0015\u0010+\u001a\u00020\u000b*\u00020'2\u0006\u0010\u001d\u001a\u00020\u001eH\u0086\u0002\u001a\u0015\u0010+\u001a\u00020\u000b*\u00020(2\u0006\u0010\u001f\u001a\u00020 H\u0086\u0002\u001a\u001b\u0010+\u001a\u00020\u000b*\u00020(2\f\u0010)\u001a\b\u0012\u0004\u0012\u00020 0*H\u0086\u0002\u001a\u0015\u0010,\u001a\u00020\u000b*\u00020'2\u0006\u0010-\u001a\u00020\u001cH\u0086\u0002\u001a\u0015\u0010,\u001a\u00020\u000b*\u00020'2\u0006\u0010.\u001a\u00020'H\u0086\u0002\u001a\u0015\u0010,\u001a\u00020\u000b*\u00020'2\u0006\u0010-\u001a\u00020/H\u0086\u0002\u001a\u0015\u0010,\u001a\u00020\u000b*\u00020'2\u0006\u0010-\u001a\u000200H\u0086\u0002\u001a\u0015\u0010,\u001a\u00020\u000b*\u00020'2\u0006\u0010-\u001a\u00020\u001bH\u0086\u0002\u001a\u0015\u0010,\u001a\u00020\u000b*\u00020'2\u0006\u0010-\u001a\u000201H\u0086\u0002\u001a\u0015\u0010,\u001a\u00020\u000b*\u00020'2\u0006\u0010-\u001a\u000202H\u0086\u0002\u001a\u0015\u0010,\u001a\u00020\u000b*\u00020'2\u0006\u0010-\u001a\u000203H\u0086\u0002\u001a\u0015\u0010,\u001a\u00020\u000b*\u00020'2\u0006\u0010-\u001a\u00020\u001eH\u0086\u0002\u001a\u0015\u0010,\u001a\u00020\u000b*\u00020'2\u0006\u0010-\u001a\u000204H\u0086\u0002\u001a\u0015\u0010,\u001a\u00020\u000b*\u00020'2\u0006\u0010-\u001a\u000205H\u0086\u0002\u001a\u0015\u0010,\u001a\u00020\u000b*\u00020'2\u0006\u0010-\u001a\u00020 H\u0086\u0002\u001a\u0015\u00106\u001a\u00020\u000b*\u00020'2\u0006\u0010-\u001a\u00020\u001cH\u0086\u0002\u001a\u0015\u00106\u001a\u00020\u000b*\u00020'2\u0006\u0010.\u001a\u00020'H\u0086\u0002\u001a\u0015\u00106\u001a\u00020\u000b*\u00020'2\u0006\u0010-\u001a\u00020/H\u0086\u0002\u001a\u0015\u00106\u001a\u00020\u000b*\u00020'2\u0006\u0010-\u001a\u000200H\u0086\u0002\u001a\u0015\u00106\u001a\u00020\u000b*\u00020'2\u0006\u0010-\u001a\u00020\u001bH\u0086\u0002\u001a\u0015\u00106\u001a\u00020\u000b*\u00020'2\u0006\u0010-\u001a\u000201H\u0086\u0002\u001a\u0015\u00106\u001a\u00020\u000b*\u00020'2\u0006\u0010-\u001a\u000202H\u0086\u0002\u001a\u0015\u00106\u001a\u00020\u000b*\u00020'2\u0006\u0010-\u001a\u000203H\u0086\u0002\u001a\u0015\u00106\u001a\u00020\u000b*\u00020'2\u0006\u0010-\u001a\u00020\u001eH\u0086\u0002\u001a\u0015\u00106\u001a\u00020\u000b*\u00020'2\u0006\u0010-\u001a\u000204H\u0086\u0002\u001a\u0015\u00106\u001a\u00020\u000b*\u00020'2\u0006\u0010-\u001a\u000205H\u0086\u0002\u001a\u0015\u00106\u001a\u00020\u000b*\u00020'2\u0006\u0010-\u001a\u00020 H\u0086\u0002\u001a\"\u00107\u001a\u0002H\u0006\"\u0006\b\u0000\u0010\u0006\u0018\u0001*\u00020\u00032\u0006\u00108\u001a\u000209H\u0086\b¢\u0006\u0002\u0010:\u001a\"\u00107\u001a\u0002H\u0006\"\u0006\b\u0000\u0010\u0006\u0018\u0001*\u00020\u00032\u0006\u0010;\u001a\u00020<H\u0086\b¢\u0006\u0002\u0010=\u001a\"\u00107\u001a\u0002H\u0006\"\u0006\b\u0000\u0010\u0006\u0018\u0001*\u00020\u00032\u0006\u0010;\u001a\u00020>H\u0086\b¢\u0006\u0002\u0010?\u001a\"\u00107\u001a\u0002H\u0006\"\u0006\b\u0000\u0010\u0006\u0018\u0001*\u00020\u00032\u0006\u0010;\u001a\u00020@H\u0086\b¢\u0006\u0002\u0010A\u001a\"\u00107\u001a\u0002H\u0006\"\u0006\b\u0000\u0010\u0006\u0018\u0001*\u00020\u00032\u0006\u0010;\u001a\u00020BH\u0086\b¢\u0006\u0002\u0010C\u001a\"\u00107\u001a\u0002H\u0006\"\u0006\b\u0000\u0010\u0006\u0018\u0001*\u00020\u00032\u0006\u0010;\u001a\u000201H\u0086\b¢\u0006\u0002\u0010D\u001a\"\u00107\u001a\u0002H\u0006\"\u0006\b\u0000\u0010\u0006\u0018\u0001*\u00020\u00032\u0006\u0010E\u001a\u00020 H\u0086\b¢\u0006\u0002\u0010F\u001a\"\u0010G\u001a\u0002H\u0006\"\u0006\b\u0000\u0010\u0006\u0018\u0001*\u00020H2\u0006\u00108\u001a\u000209H\u0086\b¢\u0006\u0002\u0010I\u001a#\u0010J\u001a\b\u0012\u0004\u0012\u0002H\u00060K\"\u0006\b\u0000\u0010\u0006\u0018\u0001*\u00020\u00032\u0006\u00108\u001a\u000209H\u0086\b\u001a#\u0010L\u001a\b\u0012\u0004\u0012\u0002H\u00060M\"\u0006\b\u0000\u0010\u0006\u0018\u0001*\u00020H2\u0006\u00108\u001a\u000209H\u0086\b\u001a\n\u0010N\u001a\u00020\u0003*\u00020\u0003\u001a\f\u0010O\u001a\u00020P*\u00020\u001eH\u0000\u001a\"\u0010Q\u001a\u0002H\u0006\"\u0006\b\u0000\u0010\u0006\u0018\u0001*\u00020\u00032\u0006\u0010R\u001a\u00020SH\u0086\b¢\u0006\u0002\u0010T\u001a$\u0010Q\u001a\u0004\u0018\u0001H\u0006\"\u0006\b\u0000\u0010\u0006\u0018\u0001*\u00020H2\u0006\u0010R\u001a\u00020SH\u0086\b¢\u0006\u0002\u0010U\u001a&\u0010V\u001a\n X*\u0004\u0018\u00010W0W*\u00020W2\b\u0010Y\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u001d\u001a\u00020\u001eH\u0000\u001a&\u0010V\u001a\n X*\u0004\u0018\u00010W0W*\u00020W2\b\u0010Y\u001a\u0004\u0018\u00010\u00122\u0006\u0010Z\u001a\u00020 H\u0000¨\u0006["}, m107d2 = {"jacksonMapperBuilder", "Lcom/fasterxml/jackson/databind/json/JsonMapper$Builder;", "jacksonObjectMapper", "Lcom/fasterxml/jackson/databind/ObjectMapper;", "jacksonTypeRef", "Lcom/fasterxml/jackson/core/type/TypeReference;", ExifInterface.GPS_DIRECTION_TRUE, "jsonMapper", "Lcom/fasterxml/jackson/databind/json/JsonMapper;", "initializer", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "kotlinModule", "Lcom/fasterxml/jackson/module/kotlin/KotlinModule;", "Lcom/fasterxml/jackson/module/kotlin/KotlinModule$Builder;", "addDeserializer", "Lcom/fasterxml/jackson/databind/module/SimpleModule;", "", "kClass", "Lkotlin/reflect/KClass;", "deserializer", "Lcom/fasterxml/jackson/databind/JsonDeserializer;", "addSerializer", "serializer", "Lcom/fasterxml/jackson/databind/JsonSerializer;", "contains", "", "Lcom/fasterxml/jackson/databind/JsonNode;", FirebaseAnalytics.Param.INDEX, "", "field", "", "convertValue", "from", "(Lcom/fasterxml/jackson/databind/ObjectMapper;Ljava/lang/Object;)Ljava/lang/Object;", "isUnboxableValueClass", "Ljava/lang/Class;", "minus", "Lcom/fasterxml/jackson/databind/node/ArrayNode;", "Lcom/fasterxml/jackson/databind/node/ObjectNode;", "fields", "", "minusAssign", "plus", "element", MessengerShareContentUtility.ELEMENTS, "Ljava/math/BigDecimal;", "Ljava/math/BigInteger;", "", "", "", "", "", "plusAssign", "readValue", "jp", "Lcom/fasterxml/jackson/core/JsonParser;", "(Lcom/fasterxml/jackson/databind/ObjectMapper;Lcom/fasterxml/jackson/core/JsonParser;)Ljava/lang/Object;", "src", "Ljava/io/File;", "(Lcom/fasterxml/jackson/databind/ObjectMapper;Ljava/io/File;)Ljava/lang/Object;", "Ljava/io/InputStream;", "(Lcom/fasterxml/jackson/databind/ObjectMapper;Ljava/io/InputStream;)Ljava/lang/Object;", "Ljava/io/Reader;", "(Lcom/fasterxml/jackson/databind/ObjectMapper;Ljava/io/Reader;)Ljava/lang/Object;", "Ljava/net/URL;", "(Lcom/fasterxml/jackson/databind/ObjectMapper;Ljava/net/URL;)Ljava/lang/Object;", "(Lcom/fasterxml/jackson/databind/ObjectMapper;[B)Ljava/lang/Object;", "content", "(Lcom/fasterxml/jackson/databind/ObjectMapper;Ljava/lang/String;)Ljava/lang/Object;", "readValueTyped", "Lcom/fasterxml/jackson/databind/ObjectReader;", "(Lcom/fasterxml/jackson/databind/ObjectReader;Lcom/fasterxml/jackson/core/JsonParser;)Ljava/lang/Object;", "readValues", "Lcom/fasterxml/jackson/databind/MappingIterator;", "readValuesTyped", "", "registerKotlinModule", "toBitSet", "Ljava/util/BitSet;", "treeToValue", "n", "Lcom/fasterxml/jackson/core/TreeNode;", "(Lcom/fasterxml/jackson/databind/ObjectMapper;Lcom/fasterxml/jackson/core/TreeNode;)Ljava/lang/Object;", "(Lcom/fasterxml/jackson/databind/ObjectReader;Lcom/fasterxml/jackson/core/TreeNode;)Ljava/lang/Object;", "wrapWithPath", "Lcom/fasterxml/jackson/databind/JsonMappingException;", "kotlin.jvm.PlatformType", "refFrom", "refFieldName", "jackson-module-kotlin"}, m106k = 2, m105mv = {1, 5, 1}, m103xi = 48)
/* renamed from: com.fasterxml.jackson.module.kotlin.ExtensionsKt */
/* loaded from: classes2.dex */
public final class Extensions {
    public static /* synthetic */ KotlinModule kotlinModule$default(Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            function1 = ExtensionsKt$kotlinModule$1.INSTANCE;
        }
        return kotlinModule(function1);
    }

    public static final KotlinModule kotlinModule(Function1<? super KotlinModule.Builder, Unit> initializer) {
        Intrinsics.checkNotNullParameter(initializer, "initializer");
        KotlinModule.Builder builder = new KotlinModule.Builder();
        initializer.invoke(builder);
        return builder.build();
    }

    public static /* synthetic */ JsonMapper jsonMapper$default(Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            function1 = ExtensionsKt$jsonMapper$1.INSTANCE;
        }
        return jsonMapper(function1);
    }

    public static final JsonMapper jsonMapper(Function1<? super JsonMapper.Builder, Unit> initializer) {
        Intrinsics.checkNotNullParameter(initializer, "initializer");
        JsonMapper.Builder builder = JsonMapper.builder();
        Intrinsics.checkNotNullExpressionValue(builder, "builder");
        initializer.invoke(builder);
        JsonMapper build = builder.build();
        Intrinsics.checkNotNullExpressionValue(build, "builder.build()");
        return build;
    }

    public static final ObjectMapper jacksonObjectMapper() {
        return jsonMapper(ExtensionsKt$jacksonObjectMapper$1.INSTANCE);
    }

    public static final JsonMapper.Builder jacksonMapperBuilder() {
        JsonMapper.Builder addModule = JsonMapper.builder().addModule(kotlinModule$default(null, 1, null));
        Intrinsics.checkNotNullExpressionValue(addModule, "builder().addModule(kotlinModule())");
        return addModule;
    }

    public static final ObjectMapper registerKotlinModule(ObjectMapper objectMapper) {
        Intrinsics.checkNotNullParameter(objectMapper, "<this>");
        ObjectMapper registerModule = objectMapper.registerModule(kotlinModule$default(null, 1, null));
        Intrinsics.checkNotNullExpressionValue(registerModule, "this.registerModule(kotlinModule())");
        return registerModule;
    }

    public static final /* synthetic */ <T> T treeToValue(ObjectMapper objectMapper, TreeNode n) {
        Intrinsics.checkNotNullParameter(objectMapper, "<this>");
        Intrinsics.checkNotNullParameter(n, "n");
        JsonParser treeAsTokens = objectMapper.treeAsTokens(n);
        Intrinsics.needClassReification();
        return (T) objectMapper.readValue(treeAsTokens, new TypeReference<T>() { // from class: com.fasterxml.jackson.module.kotlin.ExtensionsKt$treeToValue$$inlined$jacksonTypeRef$1
        });
    }

    public static final /* synthetic */ <T> T treeToValue(ObjectReader objectReader, TreeNode n) {
        Intrinsics.checkNotNullParameter(objectReader, "<this>");
        Intrinsics.checkNotNullParameter(n, "n");
        JsonParser treeAsTokens = objectReader.treeAsTokens(n);
        Intrinsics.needClassReification();
        return (T) objectReader.readValue(treeAsTokens, new TypeReference<T>() { // from class: com.fasterxml.jackson.module.kotlin.ExtensionsKt$treeToValue$$inlined$jacksonTypeRef$2
        });
    }

    public static final void plus(ArrayNode arrayNode, boolean z) {
        Intrinsics.checkNotNullParameter(arrayNode, "<this>");
        Unit unit = Unit.INSTANCE;
        arrayNode.add(z);
    }

    public static final void plus(ArrayNode arrayNode, short s) {
        Intrinsics.checkNotNullParameter(arrayNode, "<this>");
        Unit unit = Unit.INSTANCE;
        arrayNode.add(s);
    }

    public static final void plus(ArrayNode arrayNode, int i) {
        Intrinsics.checkNotNullParameter(arrayNode, "<this>");
        Unit unit = Unit.INSTANCE;
        arrayNode.add(i);
    }

    public static final void plus(ArrayNode arrayNode, long j) {
        Intrinsics.checkNotNullParameter(arrayNode, "<this>");
        Unit unit = Unit.INSTANCE;
        arrayNode.add(j);
    }

    public static final void plus(ArrayNode arrayNode, float f) {
        Intrinsics.checkNotNullParameter(arrayNode, "<this>");
        Unit unit = Unit.INSTANCE;
        arrayNode.add(f);
    }

    public static final void plus(ArrayNode arrayNode, double d) {
        Intrinsics.checkNotNullParameter(arrayNode, "<this>");
        Unit unit = Unit.INSTANCE;
        arrayNode.add(d);
    }

    public static final void plus(ArrayNode arrayNode, BigDecimal element) {
        Intrinsics.checkNotNullParameter(arrayNode, "<this>");
        Intrinsics.checkNotNullParameter(element, "element");
        Unit unit = Unit.INSTANCE;
        arrayNode.add(element);
    }

    public static final void plus(ArrayNode arrayNode, BigInteger element) {
        Intrinsics.checkNotNullParameter(arrayNode, "<this>");
        Intrinsics.checkNotNullParameter(element, "element");
        Unit unit = Unit.INSTANCE;
        arrayNode.add(element);
    }

    public static final void plus(ArrayNode arrayNode, String element) {
        Intrinsics.checkNotNullParameter(arrayNode, "<this>");
        Intrinsics.checkNotNullParameter(element, "element");
        Unit unit = Unit.INSTANCE;
        arrayNode.add(element);
    }

    public static final void plus(ArrayNode arrayNode, byte[] element) {
        Intrinsics.checkNotNullParameter(arrayNode, "<this>");
        Intrinsics.checkNotNullParameter(element, "element");
        Unit unit = Unit.INSTANCE;
        arrayNode.add(element);
    }

    public static final void plus(ArrayNode arrayNode, JsonNode element) {
        Intrinsics.checkNotNullParameter(arrayNode, "<this>");
        Intrinsics.checkNotNullParameter(element, "element");
        Unit unit = Unit.INSTANCE;
        arrayNode.add(element);
    }

    public static final void plus(ArrayNode arrayNode, ArrayNode elements) {
        Intrinsics.checkNotNullParameter(arrayNode, "<this>");
        Intrinsics.checkNotNullParameter(elements, "elements");
        Unit unit = Unit.INSTANCE;
        arrayNode.addAll(elements);
    }

    public static final void plusAssign(ArrayNode arrayNode, boolean z) {
        Intrinsics.checkNotNullParameter(arrayNode, "<this>");
        Unit unit = Unit.INSTANCE;
        arrayNode.add(z);
    }

    public static final void plusAssign(ArrayNode arrayNode, short s) {
        Intrinsics.checkNotNullParameter(arrayNode, "<this>");
        Unit unit = Unit.INSTANCE;
        arrayNode.add(s);
    }

    public static final void plusAssign(ArrayNode arrayNode, int i) {
        Intrinsics.checkNotNullParameter(arrayNode, "<this>");
        Unit unit = Unit.INSTANCE;
        arrayNode.add(i);
    }

    public static final void plusAssign(ArrayNode arrayNode, long j) {
        Intrinsics.checkNotNullParameter(arrayNode, "<this>");
        Unit unit = Unit.INSTANCE;
        arrayNode.add(j);
    }

    public static final void plusAssign(ArrayNode arrayNode, float f) {
        Intrinsics.checkNotNullParameter(arrayNode, "<this>");
        Unit unit = Unit.INSTANCE;
        arrayNode.add(f);
    }

    public static final void plusAssign(ArrayNode arrayNode, double d) {
        Intrinsics.checkNotNullParameter(arrayNode, "<this>");
        Unit unit = Unit.INSTANCE;
        arrayNode.add(d);
    }

    public static final void plusAssign(ArrayNode arrayNode, BigDecimal element) {
        Intrinsics.checkNotNullParameter(arrayNode, "<this>");
        Intrinsics.checkNotNullParameter(element, "element");
        Unit unit = Unit.INSTANCE;
        arrayNode.add(element);
    }

    public static final void plusAssign(ArrayNode arrayNode, BigInteger element) {
        Intrinsics.checkNotNullParameter(arrayNode, "<this>");
        Intrinsics.checkNotNullParameter(element, "element");
        Unit unit = Unit.INSTANCE;
        arrayNode.add(element);
    }

    public static final void plusAssign(ArrayNode arrayNode, String element) {
        Intrinsics.checkNotNullParameter(arrayNode, "<this>");
        Intrinsics.checkNotNullParameter(element, "element");
        Unit unit = Unit.INSTANCE;
        arrayNode.add(element);
    }

    public static final void plusAssign(ArrayNode arrayNode, byte[] element) {
        Intrinsics.checkNotNullParameter(arrayNode, "<this>");
        Intrinsics.checkNotNullParameter(element, "element");
        Unit unit = Unit.INSTANCE;
        arrayNode.add(element);
    }

    public static final void plusAssign(ArrayNode arrayNode, JsonNode element) {
        Intrinsics.checkNotNullParameter(arrayNode, "<this>");
        Intrinsics.checkNotNullParameter(element, "element");
        Unit unit = Unit.INSTANCE;
        arrayNode.add(element);
    }

    public static final void plusAssign(ArrayNode arrayNode, ArrayNode elements) {
        Intrinsics.checkNotNullParameter(arrayNode, "<this>");
        Intrinsics.checkNotNullParameter(elements, "elements");
        Unit unit = Unit.INSTANCE;
        arrayNode.addAll(elements);
    }

    public static final void minus(ArrayNode arrayNode, int i) {
        Intrinsics.checkNotNullParameter(arrayNode, "<this>");
        Unit unit = Unit.INSTANCE;
        arrayNode.remove(i);
    }

    public static final void minusAssign(ArrayNode arrayNode, int i) {
        Intrinsics.checkNotNullParameter(arrayNode, "<this>");
        Unit unit = Unit.INSTANCE;
        arrayNode.remove(i);
    }

    public static final void minus(ObjectNode objectNode, String field) {
        Intrinsics.checkNotNullParameter(objectNode, "<this>");
        Intrinsics.checkNotNullParameter(field, "field");
        Unit unit = Unit.INSTANCE;
        objectNode.remove(field);
    }

    public static final void minus(ObjectNode objectNode, Collection<String> fields) {
        Intrinsics.checkNotNullParameter(objectNode, "<this>");
        Intrinsics.checkNotNullParameter(fields, "fields");
        Unit unit = Unit.INSTANCE;
        objectNode.remove(fields);
    }

    public static final void minusAssign(ObjectNode objectNode, String field) {
        Intrinsics.checkNotNullParameter(objectNode, "<this>");
        Intrinsics.checkNotNullParameter(field, "field");
        Unit unit = Unit.INSTANCE;
        objectNode.remove(field);
    }

    public static final void minusAssign(ObjectNode objectNode, Collection<String> fields) {
        Intrinsics.checkNotNullParameter(objectNode, "<this>");
        Intrinsics.checkNotNullParameter(fields, "fields");
        Unit unit = Unit.INSTANCE;
        objectNode.remove(fields);
    }

    public static final boolean contains(JsonNode jsonNode, String field) {
        Intrinsics.checkNotNullParameter(jsonNode, "<this>");
        Intrinsics.checkNotNullParameter(field, "field");
        return jsonNode.has(field);
    }

    public static final boolean contains(JsonNode jsonNode, int i) {
        Intrinsics.checkNotNullParameter(jsonNode, "<this>");
        return jsonNode.has(i);
    }

    public static final JsonMappingException wrapWithPath(JsonMappingException jsonMappingException, Object obj, String refFieldName) {
        Intrinsics.checkNotNullParameter(jsonMappingException, "<this>");
        Intrinsics.checkNotNullParameter(refFieldName, "refFieldName");
        return JsonMappingException.wrapWithPath(jsonMappingException, obj, refFieldName);
    }

    public static final JsonMappingException wrapWithPath(JsonMappingException jsonMappingException, Object obj, int i) {
        Intrinsics.checkNotNullParameter(jsonMappingException, "<this>");
        return JsonMappingException.wrapWithPath(jsonMappingException, obj, i);
    }

    public static final /* synthetic */ <T> SimpleModule addSerializer(SimpleModule simpleModule, KClass<T> kClass, JsonSerializer<T> serializer) {
        Intrinsics.checkNotNullParameter(simpleModule, "<this>");
        Intrinsics.checkNotNullParameter(kClass, "kClass");
        Intrinsics.checkNotNullParameter(serializer, "serializer");
        simpleModule.addSerializer(JvmClassMapping.getJavaClass((KClass) kClass), serializer);
        simpleModule.addSerializer(JvmClassMapping.getJavaObjectType(kClass), serializer);
        return simpleModule;
    }

    public static final /* synthetic */ <T> SimpleModule addDeserializer(SimpleModule simpleModule, KClass<T> kClass, JsonDeserializer<T> deserializer) {
        Intrinsics.checkNotNullParameter(simpleModule, "<this>");
        Intrinsics.checkNotNullParameter(kClass, "kClass");
        Intrinsics.checkNotNullParameter(deserializer, "deserializer");
        simpleModule.addDeserializer(JvmClassMapping.getJavaClass((KClass) kClass), deserializer);
        simpleModule.addDeserializer(JvmClassMapping.getJavaObjectType(kClass), deserializer);
        return simpleModule;
    }

    public static final BitSet toBitSet(int i) {
        BitSet bitSet = new BitSet(32);
        int i2 = 0;
        while (i != 0) {
            if (i % 2 != 0) {
                bitSet.set(i2);
            }
            i2++;
            i >>= 1;
        }
        return bitSet;
    }

    public static final boolean isUnboxableValueClass(Class<?> cls) {
        boolean z;
        Intrinsics.checkNotNullParameter(cls, "<this>");
        Annotation[] annotations = cls.getAnnotations();
        Intrinsics.checkNotNullExpressionValue(annotations, "annotations");
        Annotation[] annotationArr = annotations;
        int length = annotationArr.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                z = false;
                break;
            } else if (annotationArr[i] instanceof JvmInline) {
                z = true;
                break;
            } else {
                i++;
            }
        }
        return z && KotlinModuleKt.isKotlinClass(cls);
    }

    public static final /* synthetic */ <T> T readValue(ObjectMapper objectMapper, JsonParser jp2) {
        Intrinsics.checkNotNullParameter(objectMapper, "<this>");
        Intrinsics.checkNotNullParameter(jp2, "jp");
        Intrinsics.needClassReification();
        return (T) objectMapper.readValue(jp2, new TypeReference<T>() { // from class: com.fasterxml.jackson.module.kotlin.ExtensionsKt$readValue$$inlined$jacksonTypeRef$1
        });
    }

    public static final /* synthetic */ <T> MappingIterator<T> readValues(ObjectMapper objectMapper, JsonParser jp2) {
        Intrinsics.checkNotNullParameter(objectMapper, "<this>");
        Intrinsics.checkNotNullParameter(jp2, "jp");
        Intrinsics.needClassReification();
        MappingIterator<T> readValues = objectMapper.readValues(jp2, (TypeReference) new TypeReference<T>() { // from class: com.fasterxml.jackson.module.kotlin.ExtensionsKt$readValues$$inlined$jacksonTypeRef$1
        });
        Intrinsics.checkNotNullExpressionValue(readValues, "readValues(jp, jacksonTypeRef<T>())");
        return readValues;
    }

    public static final /* synthetic */ <T> T readValue(ObjectMapper objectMapper, File src) {
        Intrinsics.checkNotNullParameter(objectMapper, "<this>");
        Intrinsics.checkNotNullParameter(src, "src");
        Intrinsics.needClassReification();
        return (T) objectMapper.readValue(src, new TypeReference<T>() { // from class: com.fasterxml.jackson.module.kotlin.ExtensionsKt$readValue$$inlined$jacksonTypeRef$2
        });
    }

    public static final /* synthetic */ <T> T readValue(ObjectMapper objectMapper, URL src) {
        Intrinsics.checkNotNullParameter(objectMapper, "<this>");
        Intrinsics.checkNotNullParameter(src, "src");
        Intrinsics.needClassReification();
        return (T) objectMapper.readValue(src, new TypeReference<T>() { // from class: com.fasterxml.jackson.module.kotlin.ExtensionsKt$readValue$$inlined$jacksonTypeRef$3
        });
    }

    public static final /* synthetic */ <T> T readValue(ObjectMapper objectMapper, String content) {
        Intrinsics.checkNotNullParameter(objectMapper, "<this>");
        Intrinsics.checkNotNullParameter(content, "content");
        Intrinsics.needClassReification();
        return (T) objectMapper.readValue(content, new TypeReference<T>() { // from class: com.fasterxml.jackson.module.kotlin.ExtensionsKt$readValue$$inlined$jacksonTypeRef$4
        });
    }

    public static final /* synthetic */ <T> T readValue(ObjectMapper objectMapper, Reader src) {
        Intrinsics.checkNotNullParameter(objectMapper, "<this>");
        Intrinsics.checkNotNullParameter(src, "src");
        Intrinsics.needClassReification();
        return (T) objectMapper.readValue(src, new TypeReference<T>() { // from class: com.fasterxml.jackson.module.kotlin.ExtensionsKt$readValue$$inlined$jacksonTypeRef$5
        });
    }

    public static final /* synthetic */ <T> T readValue(ObjectMapper objectMapper, InputStream src) {
        Intrinsics.checkNotNullParameter(objectMapper, "<this>");
        Intrinsics.checkNotNullParameter(src, "src");
        Intrinsics.needClassReification();
        return (T) objectMapper.readValue(src, new TypeReference<T>() { // from class: com.fasterxml.jackson.module.kotlin.ExtensionsKt$readValue$$inlined$jacksonTypeRef$6
        });
    }

    public static final /* synthetic */ <T> T readValue(ObjectMapper objectMapper, byte[] src) {
        Intrinsics.checkNotNullParameter(objectMapper, "<this>");
        Intrinsics.checkNotNullParameter(src, "src");
        Intrinsics.needClassReification();
        return (T) objectMapper.readValue(src, new TypeReference<T>() { // from class: com.fasterxml.jackson.module.kotlin.ExtensionsKt$readValue$$inlined$jacksonTypeRef$7
        });
    }

    public static final /* synthetic */ <T> T convertValue(ObjectMapper objectMapper, Object from) {
        Intrinsics.checkNotNullParameter(objectMapper, "<this>");
        Intrinsics.checkNotNullParameter(from, "from");
        Intrinsics.needClassReification();
        return (T) objectMapper.convertValue(from, new TypeReference<T>() { // from class: com.fasterxml.jackson.module.kotlin.ExtensionsKt$convertValue$$inlined$jacksonTypeRef$1
        });
    }

    public static final /* synthetic */ <T> T readValueTyped(ObjectReader objectReader, JsonParser jp2) {
        Intrinsics.checkNotNullParameter(objectReader, "<this>");
        Intrinsics.checkNotNullParameter(jp2, "jp");
        Intrinsics.needClassReification();
        return (T) objectReader.readValue(jp2, new TypeReference<T>() { // from class: com.fasterxml.jackson.module.kotlin.ExtensionsKt$readValueTyped$$inlined$jacksonTypeRef$1
        });
    }

    public static final /* synthetic */ <T> Iterator<T> readValuesTyped(ObjectReader objectReader, JsonParser jp2) {
        Intrinsics.checkNotNullParameter(objectReader, "<this>");
        Intrinsics.checkNotNullParameter(jp2, "jp");
        Intrinsics.needClassReification();
        Iterator<T> readValues = objectReader.readValues(jp2, new TypeReference<T>() { // from class: com.fasterxml.jackson.module.kotlin.ExtensionsKt$readValuesTyped$$inlined$jacksonTypeRef$1
        });
        Intrinsics.checkNotNullExpressionValue(readValues, "readValues(jp, jacksonTypeRef<T>())");
        return readValues;
    }
}
