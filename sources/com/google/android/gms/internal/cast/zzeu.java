package com.google.android.gms.internal.cast;

import kotlin.text.Typography;

/* compiled from: com.google.android.gms:play-services-cast@@20.0.0 */
/* loaded from: classes3.dex */
public enum zzeu implements zzou {
    ERROR_UNKNOWN(0),
    ERROR_SETUP_DEVICE_NOT_SUPPORTED(1),
    ERROR_SETUP_GOOGLE_PLAY_SERVICES_UPDATE_REQUIRED(2),
    ERROR_SETUP_CONFIGURATION_REJECTED_BY_RECEIVER(3),
    ERROR_OPENGL_UNKNOWN_ERROR(4),
    ERROR_OPENGL_INITIALIZATION_ERROR(5),
    ERROR_OPENGL_CONTEXT_CREATION_ERROR(6),
    ERROR_OPENGL_SHADER_COMPILATION_ERROR(7),
    ERROR_OPENGL_SHADER_LINKING_ERROR(8),
    ERROR_OPENGL_RENDERING_ERROR(9),
    ERROR_OPENGL_TEXTURE_BINDING_ERROR(10),
    ERROR_OPENGL_SHUTDOWN_ERROR(11),
    ERROR_OPENGL_UNSUPPORTED_OPENGL_API_ERROR(12),
    ERROR_OPENGL_TEXTURE_CACHE_CREATION_ERROR(13),
    ERROR_OPENGL_LUMA_PASS_PIPELINE_CREATION_ERROR(14),
    ERROR_OPENGL_CHROMA_PASS_PIPELINE_CREATION_ERROR(15),
    ERROR_OPENGL_SHADER_DECOMPRESSION_ERROR(16),
    ERROR_OPENGL_PIXELBUFFER_CREATION_ERROR(17),
    ERROR_OPENGL_LUMA_TEXTURE_CACHE_CREATION_ERROR(18),
    ERROR_OPENGL_CHROMA_TEXTURE_CACHE_CREATION_ERROR(19),
    ERROR_OPENGL_MAKE_CURRENT_ERROR(20),
    ERROR_OPENGL_EGL_CONTEXT_ERROR(21),
    ERROR_OPENGL_EGL_BAD_NATIVE_SURFACE_ERROR(22),
    ERROR_METAL_UNKNOWN_ERROR(23),
    ERROR_METAL_TEXTURE_CACHE_CREATION_ERROR(24),
    ERROR_METAL_SHADER_DECOMPRESSION_ERROR(25),
    ERROR_METAL_SHADER_LOADING_ERROR(26),
    ERROR_METAL_BUFFER_ALLOCATION_ERROR(27),
    ERROR_METAL_LUMA_PASS_PIPELINE_CREATION_ERROR(28),
    ERROR_METAL_CHROMA_PASS_BUFFER_CREATION_ERROR(29),
    ERROR_METAL_CHROMA_PASS_TEXTURE_CREATION_ERROR(30),
    ERROR_METAL_CHROMA_PASS_PIPELINE_CREATION_ERROR(31),
    ERROR_METAL_PIXELBUFFER_CREATION_ERROR(32),
    ERROR_METAL_TEXTURE_CREATION_ERROR(33),
    ERROR_METAL_LUMA_RENDER_COMMAND_ENCODER_CREATION_ERROR(34),
    ERROR_METAL_CHROMA_RENDER_COMMAND_ENCODER_CREATION_ERROR(35),
    ERROR_METAL_COMMAND_BUFFER_EXECUTION_ERROR(36),
    ERROR_AUDIO_CONVERTER_CREATION_ERROR(37),
    ERROR_AUDIO_CONVERTER_PRIMEMETHOD_ERROR(38),
    ERROR_AUDIO_CONVERTER_CONVERSION_ERROR(39),
    ERROR_SETUP_FEATURE_NOT_SUPPORTED(40),
    ERROR_DUPLICATE_REQUEST(41),
    ERROR_PROTOCOL_ERROR(42);
    
    private static final zzov<zzeu> zzR = new zzov<zzeu>() { // from class: com.google.android.gms.internal.cast.zzes
    };
    private final int zzS;

    zzeu(int i) {
        this.zzS = i;
    }

    public static zzow zza() {
        return zzet.zza;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return "<" + getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zzS + " name=" + name() + Typography.greater;
    }
}