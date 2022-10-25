package com.fasterxml.jackson.core;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.TSFBuilder;
import com.fasterxml.jackson.core.json.JsonReadFeature;
import com.fasterxml.jackson.core.json.JsonWriteFeature;
import com.fasterxml.jackson.core.p033io.InputDecorator;
import com.fasterxml.jackson.core.p033io.OutputDecorator;

/* loaded from: classes2.dex */
public abstract class TSFBuilder<F extends JsonFactory, B extends TSFBuilder<F, B>> {
    protected int _factoryFeatures;
    protected InputDecorator _inputDecorator;
    protected OutputDecorator _outputDecorator;
    protected int _streamReadFeatures;
    protected int _streamWriteFeatures;
    protected static final int DEFAULT_FACTORY_FEATURE_FLAGS = JsonFactory.Feature.collectDefaults();
    protected static final int DEFAULT_PARSER_FEATURE_FLAGS = JsonParser.Feature.collectDefaults();
    protected static final int DEFAULT_GENERATOR_FEATURE_FLAGS = JsonGenerator.Feature.collectDefaults();

    protected final B _this() {
        return this;
    }

    public abstract F build();

    /* JADX INFO: Access modifiers changed from: protected */
    public TSFBuilder() {
        this._factoryFeatures = DEFAULT_FACTORY_FEATURE_FLAGS;
        this._streamReadFeatures = DEFAULT_PARSER_FEATURE_FLAGS;
        this._streamWriteFeatures = DEFAULT_GENERATOR_FEATURE_FLAGS;
        this._inputDecorator = null;
        this._outputDecorator = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public TSFBuilder(JsonFactory jsonFactory) {
        this(jsonFactory._factoryFeatures, jsonFactory._parserFeatures, jsonFactory._generatorFeatures);
    }

    protected TSFBuilder(int i, int i2, int i3) {
        this._factoryFeatures = i;
        this._streamReadFeatures = i2;
        this._streamWriteFeatures = i3;
    }

    public int factoryFeaturesMask() {
        return this._factoryFeatures;
    }

    public int streamReadFeatures() {
        return this._streamReadFeatures;
    }

    public int streamWriteFeatures() {
        return this._streamWriteFeatures;
    }

    public InputDecorator inputDecorator() {
        return this._inputDecorator;
    }

    public OutputDecorator outputDecorator() {
        return this._outputDecorator;
    }

    public B enable(JsonFactory.Feature feature) {
        this._factoryFeatures = feature.getMask() | this._factoryFeatures;
        return _this();
    }

    public B disable(JsonFactory.Feature feature) {
        this._factoryFeatures = (~feature.getMask()) & this._factoryFeatures;
        return _this();
    }

    public B configure(JsonFactory.Feature feature, boolean z) {
        return z ? enable(feature) : disable(feature);
    }

    public B enable(StreamReadFeature streamReadFeature) {
        this._streamReadFeatures = streamReadFeature.mappedFeature().getMask() | this._streamReadFeatures;
        return _this();
    }

    public B enable(StreamReadFeature streamReadFeature, StreamReadFeature... streamReadFeatureArr) {
        this._streamReadFeatures = streamReadFeature.mappedFeature().getMask() | this._streamReadFeatures;
        for (StreamReadFeature streamReadFeature2 : streamReadFeatureArr) {
            this._streamReadFeatures = streamReadFeature2.mappedFeature().getMask() | this._streamReadFeatures;
        }
        return _this();
    }

    public B disable(StreamReadFeature streamReadFeature) {
        this._streamReadFeatures = (~streamReadFeature.mappedFeature().getMask()) & this._streamReadFeatures;
        return _this();
    }

    public B disable(StreamReadFeature streamReadFeature, StreamReadFeature... streamReadFeatureArr) {
        this._streamReadFeatures = (~streamReadFeature.mappedFeature().getMask()) & this._streamReadFeatures;
        for (StreamReadFeature streamReadFeature2 : streamReadFeatureArr) {
            this._streamReadFeatures = (~streamReadFeature2.mappedFeature().getMask()) & this._streamReadFeatures;
        }
        return _this();
    }

    public B configure(StreamReadFeature streamReadFeature, boolean z) {
        return z ? enable(streamReadFeature) : disable(streamReadFeature);
    }

    public B enable(StreamWriteFeature streamWriteFeature) {
        this._streamWriteFeatures = streamWriteFeature.mappedFeature().getMask() | this._streamWriteFeatures;
        return _this();
    }

    public B enable(StreamWriteFeature streamWriteFeature, StreamWriteFeature... streamWriteFeatureArr) {
        this._streamWriteFeatures = streamWriteFeature.mappedFeature().getMask() | this._streamWriteFeatures;
        for (StreamWriteFeature streamWriteFeature2 : streamWriteFeatureArr) {
            this._streamWriteFeatures = streamWriteFeature2.mappedFeature().getMask() | this._streamWriteFeatures;
        }
        return _this();
    }

    public B disable(StreamWriteFeature streamWriteFeature) {
        this._streamWriteFeatures = (~streamWriteFeature.mappedFeature().getMask()) & this._streamWriteFeatures;
        return _this();
    }

    public B disable(StreamWriteFeature streamWriteFeature, StreamWriteFeature... streamWriteFeatureArr) {
        this._streamWriteFeatures = (~streamWriteFeature.mappedFeature().getMask()) & this._streamWriteFeatures;
        for (StreamWriteFeature streamWriteFeature2 : streamWriteFeatureArr) {
            this._streamWriteFeatures = (~streamWriteFeature2.mappedFeature().getMask()) & this._streamWriteFeatures;
        }
        return _this();
    }

    public B configure(StreamWriteFeature streamWriteFeature, boolean z) {
        return z ? enable(streamWriteFeature) : disable(streamWriteFeature);
    }

    public B enable(JsonReadFeature jsonReadFeature) {
        return _failNonJSON(jsonReadFeature);
    }

    public B enable(JsonReadFeature jsonReadFeature, JsonReadFeature... jsonReadFeatureArr) {
        return _failNonJSON(jsonReadFeature);
    }

    public B disable(JsonReadFeature jsonReadFeature) {
        return _failNonJSON(jsonReadFeature);
    }

    public B disable(JsonReadFeature jsonReadFeature, JsonReadFeature... jsonReadFeatureArr) {
        return _failNonJSON(jsonReadFeature);
    }

    public B configure(JsonReadFeature jsonReadFeature, boolean z) {
        return _failNonJSON(jsonReadFeature);
    }

    private B _failNonJSON(Object obj) {
        throw new IllegalArgumentException("Feature " + obj.getClass().getName() + "#" + obj.toString() + " not supported for non-JSON backend");
    }

    public B enable(JsonWriteFeature jsonWriteFeature) {
        return _failNonJSON(jsonWriteFeature);
    }

    public B enable(JsonWriteFeature jsonWriteFeature, JsonWriteFeature... jsonWriteFeatureArr) {
        return _failNonJSON(jsonWriteFeature);
    }

    public B disable(JsonWriteFeature jsonWriteFeature) {
        return _failNonJSON(jsonWriteFeature);
    }

    public B disable(JsonWriteFeature jsonWriteFeature, JsonWriteFeature... jsonWriteFeatureArr) {
        return _failNonJSON(jsonWriteFeature);
    }

    public B configure(JsonWriteFeature jsonWriteFeature, boolean z) {
        return _failNonJSON(jsonWriteFeature);
    }

    public B inputDecorator(InputDecorator inputDecorator) {
        this._inputDecorator = inputDecorator;
        return _this();
    }

    public B outputDecorator(OutputDecorator outputDecorator) {
        this._outputDecorator = outputDecorator;
        return _this();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void _legacyEnable(JsonParser.Feature feature) {
        if (feature != null) {
            this._streamReadFeatures = feature.getMask() | this._streamReadFeatures;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void _legacyDisable(JsonParser.Feature feature) {
        if (feature != null) {
            this._streamReadFeatures = (~feature.getMask()) & this._streamReadFeatures;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void _legacyEnable(JsonGenerator.Feature feature) {
        if (feature != null) {
            this._streamWriteFeatures = feature.getMask() | this._streamWriteFeatures;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void _legacyDisable(JsonGenerator.Feature feature) {
        if (feature != null) {
            this._streamWriteFeatures = (~feature.getMask()) & this._streamWriteFeatures;
        }
    }
}
