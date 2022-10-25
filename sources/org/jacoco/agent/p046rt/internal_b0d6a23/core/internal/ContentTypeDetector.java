package org.jacoco.agent.p046rt.internal_b0d6a23.core.internal;

import androidx.core.internal.view.SupportMenu;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.jacoco.agent.p046rt.internal_b0d6a23.asm.Opcodes;

/* renamed from: org.jacoco.agent.rt.internal_b0d6a23.core.internal.ContentTypeDetector */
/* loaded from: 5.6.84.apk:jacocoagent.jar:org/jacoco/agent/rt/internal_b0d6a23/core/internal/ContentTypeDetector.class */
public class ContentTypeDetector {
    public static final int UNKNOWN = -1;
    public static final int CLASSFILE = -889275714;
    public static final int ZIPFILE = 1347093252;
    public static final int GZFILE = 529203200;
    public static final int PACK200FILE = -889270259;
    private static final int BUFFER_SIZE = 8;

    /* renamed from: in */
    private final InputStream f10707in;
    private final int type;

    public ContentTypeDetector(InputStream in) throws IOException {
        if (in.markSupported()) {
            this.f10707in = in;
        } else {
            this.f10707in = new BufferedInputStream(in, 8);
        }
        this.f10707in.mark(8);
        this.type = determineType(this.f10707in);
        this.f10707in.reset();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private static int determineType(InputStream in) throws IOException {
        int header = readInt(in);
        switch (header) {
            case CLASSFILE /* -889275714 */:
                switch (readInt(in)) {
                    case 46:
                    case 47:
                    case 48:
                    case 49:
                    case 50:
                    case 51:
                    case 52:
                    case Opcodes.V1_1 /* 196653 */:
                        return CLASSFILE;
                }
            case PACK200FILE /* -889270259 */:
                return PACK200FILE;
            case ZIPFILE /* 1347093252 */:
                return ZIPFILE;
        }
        if ((header & SupportMenu.CATEGORY_MASK) == 529203200) {
            return GZFILE;
        }
        return -1;
    }

    private static int readInt(InputStream in) throws IOException {
        return (in.read() << 24) | (in.read() << 16) | (in.read() << 8) | in.read();
    }

    public InputStream getInputStream() {
        return this.f10707in;
    }

    public int getType() {
        return this.type;
    }
}
