package com.anggrayudi.storage.file;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.DocumentsContract;
import android.text.format.Formatter;
import androidx.core.content.FileProvider;
import androidx.core.content.MimeTypeFilter;
import androidx.documentfile.provider.DocumentFile;
import com.anggrayudi.storage.SimpleStorage;
import com.anggrayudi.storage.callback.BaseFileCallback;
import com.anggrayudi.storage.callback.FileCallback;
import com.anggrayudi.storage.callback.FolderCallback;
import com.anggrayudi.storage.callback.MultipleFileCallback;
import com.anggrayudi.storage.extension.ContextExt;
import com.anggrayudi.storage.extension.CoroutineExt;
import com.anggrayudi.storage.extension.IOExt;
import com.anggrayudi.storage.extension.TextExt;
import com.anggrayudi.storage.extension.UriExt;
import com.anggrayudi.storage.file.FileProperties;
import com.anggrayudi.storage.media.FileDescription;
import com.anggrayudi.storage.media.MediaFile;
import com.facebook.share.internal.ShareConstants;
import com.fasterxml.jackson.core.JsonPointer;
import com.google.ads.interactivemedia.p034v3.internal.bqk;
import java.io.File;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Tuples;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.p043io.Closeable;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.MainCoroutineDispatcher;
import org.jacoco.agent.p046rt.internal_b0d6a23.core.runtime.AgentOptions;

@Metadata(m108d1 = {"\u0000\u008a\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001aV\u0010\u0018\u001a\u00020\u0019\"\u0004\b\u0000\u0010\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u00022\u0014\u0010\u001f\u001a\u0010\u0012\u0004\u0012\u0002H\u001a\u0012\u0002\b\u0003\u0012\u0002\b\u00030 2\u0018\u0010!\u001a\u0014\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020\u00190\"H\u0002\u001aC\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020%2\u0006\u0010\u001f\u001a\u00020&2\u0018\u0010!\u001a\u0014\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020\u00190\"H\u0082\b\u001a<\u0010'\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010(\u001a\u00020\u00022\u0006\u0010)\u001a\u00020\u00012\b\u0010\u0012\u001a\u0004\u0018\u00010\u00012\u0006\u0010*\u001a\u00020+2\u0006\u0010\u001f\u001a\u00020&H\u0002\u001a(\u0010,\u001a\u00020-2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010(\u001a\u00020\u00022\u0006\u0010.\u001a\u00020\u00012\u0006\u0010\u001f\u001a\u00020&H\u0002\u001a(\u0010/\u001a\u0002002\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u00101\u001a\u00020\u00022\u0006\u00102\u001a\u00020\u00012\u0006\u0010\u001f\u001a\u000203H\u0002\u001a\u001c\u00104\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u00105\u001a\u00020\u0001H\u0007\u001a\u0012\u00106\u001a\u00020\f*\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001c\u001a$\u00107\u001a\u00020\f*\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u00108\u001a\u00020\f2\u0006\u00109\u001a\u00020\fH\u0007\u001a(\u0010:\u001a\u0004\u0018\u00010\u0002*\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010;\u001a\u00020\u00012\b\b\u0002\u00108\u001a\u00020\fH\u0007\u001aD\u0010<\u001a\u00020\u0019*\u00020\u00022\u0006\u0010=\u001a\u00020#2\u0006\u0010>\u001a\u00020$2\u0006\u0010\u001e\u001a\u00020?2\u0006\u0010@\u001a\u00020\f2\u0006\u0010A\u001a\u00020B2\u0006\u0010C\u001a\u00020\f2\u0006\u0010\u001f\u001a\u00020&H\u0002\u001a0\u0010D\u001a\u00020\u0019*\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010(\u001a\u00020\u00022\n\b\u0002\u0010E\u001a\u0004\u0018\u00010F2\u0006\u0010\u001f\u001a\u00020&H\u0007\u001a8\u0010D\u001a\u00020\u0019*\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010(\u001a\u00020\u00022\b\u0010)\u001a\u0004\u0018\u00010\u00012\b\u0010G\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u001f\u001a\u00020&H\u0002\u001a$\u0010D\u001a\u00020\u0019*\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020%2\u0006\u0010\u001f\u001a\u00020&H\u0007\u001a,\u0010D\u001a\u00020\u0019*\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020%2\u0006\u0010C\u001a\u00020\f2\u0006\u0010\u001f\u001a\u00020&H\u0002\u001a0\u0010D\u001a\u00020\u0019*\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010(\u001a\u00020H2\n\b\u0002\u0010E\u001a\u0004\u0018\u00010F2\u0006\u0010\u001f\u001a\u00020&H\u0007\u001a0\u0010D\u001a\u00020\u0019*\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010I\u001a\u00020\u00012\n\b\u0002\u0010E\u001a\u0004\u0018\u00010F2\u0006\u0010\u001f\u001a\u00020&H\u0007\u001a.\u0010J\u001a\u00020\u0019*\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010E\u001a\u00020F2\u0006\u0010\u001f\u001a\u00020&2\b\b\u0002\u0010*\u001a\u00020+H\u0007\u001a<\u0010K\u001a\u00020\u0019*\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010E\u001a\u00020F2\u0006\u0010\u001f\u001a\u00020&2\u0006\u0010L\u001a\u00020M2\u0006\u0010C\u001a\u00020\f2\u0006\u0010*\u001a\u00020+H\u0002\u001a.\u0010N\u001a\u00020\u0019*\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010E\u001a\u00020F2\u0006\u0010\u001f\u001a\u00020&2\b\b\u0002\u0010*\u001a\u00020+H\u0007\u001a:\u0010O\u001a\u00020\u0019*\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u00101\u001a\u00020\u00022\b\b\u0002\u0010P\u001a\u00020\f2\n\b\u0002\u0010Q\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u001f\u001a\u000203H\u0007\u001aB\u0010O\u001a\u00020\u0019*\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u00101\u001a\u00020\u00022\b\b\u0002\u0010P\u001a\u00020\f2\n\b\u0002\u0010Q\u001a\u0004\u0018\u00010\u00012\u0006\u0010R\u001a\u00020\f2\u0006\u0010\u001f\u001a\u000203H\u0002\u001a4\u0010S\u001a\u00020\u0019*\b\u0012\u0004\u0012\u00020\u00020T2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u00101\u001a\u00020\u00022\b\b\u0002\u0010P\u001a\u00020\f2\u0006\u0010\u001f\u001a\u00020UH\u0007\u001a<\u0010S\u001a\u00020\u0019*\b\u0012\u0004\u0012\u00020\u00020T2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u00101\u001a\u00020\u00022\b\b\u0002\u0010P\u001a\u00020\f2\u0006\u0010R\u001a\u00020\f2\u0006\u0010\u001f\u001a\u00020UH\u0002\u001a(\u0010V\u001a\u0004\u0018\u00010\u0002*\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010W\u001a\u00020\u00012\b\b\u0002\u0010*\u001a\u00020+H\u0007\u001a\u0012\u0010X\u001a\u00020\f*\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001c\u001a\u001e\u0010Y\u001a\u00020\f*\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010Z\u001a\u00020\fH\u0007\u001a0\u0010[\u001a\u0004\u0018\u00010\u0002*\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010(\u001a\u00020\u00022\b\u0010)\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u001f\u001a\u00020&H\u0002\u001a0\u0010[\u001a\u0004\u0018\u00010\u0002*\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u00101\u001a\u00020\u00022\b\u0010Q\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u001f\u001a\u000203H\u0002\u001a>\u0010[\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020]\u0018\u00010\\*\b\u0012\u0004\u0012\u00020\u00020T2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u00101\u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020UH\u0002\u001a\u0014\u0010^\u001a\u0004\u0018\u00010\u0002*\u00020\u00022\u0006\u0010W\u001a\u00020\u0001\u001a-\u0010_\u001a\b\u0012\u0004\u0012\u00020\u00020T*\u00020\u00022\f\u0010`\u001a\b\u0012\u0004\u0012\u00020\u00010a2\b\b\u0002\u0010b\u001a\u00020c¢\u0006\u0002\u0010d\u001a\u0014\u0010e\u001a\u0004\u0018\u00010\u0002*\u00020\u00022\u0006\u0010W\u001a\u00020\u0001\u001a\u001e\u0010f\u001a\u00020\f*\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010Z\u001a\u00020\fH\u0007\u001a\u0012\u0010g\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001c\u001a\u0012\u0010h\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001c\u001a\u001a\u0010i\u001a\n j*\u0004\u0018\u00010\u00010\u0001*\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001c\u001a\u001c\u0010k\u001a\u00020\u0019*\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001f\u001a\u00020lH\u0007\u001a\u0012\u0010m\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001c\u001a \u0010n\u001a\u0004\u0018\u00010\u0002*\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u00108\u001a\u00020\fH\u0007\u001a\u0012\u0010o\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001c\u001a\u0012\u0010p\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001c\u001a\u0012\u0010q\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001c\u001a\u0012\u0010r\u001a\u00020s*\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001c\u001a\u001c\u0010t\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010u\u001a\u00020\u0001H\u0002\u001a2\u0010/\u001a\n\u0012\u0004\u0012\u00020v\u0018\u00010T*\b\u0012\u0004\u0012\u00020\u00020T2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u00101\u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020UH\u0002\u001a\u001a\u0010w\u001a\u00020\f*\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010x\u001a\u00020\u0002\u001a\u0012\u0010y\u001a\u00020\f*\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001c\u001a\u0012\u0010z\u001a\u00020\f*\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001c\u001a\u0012\u0010{\u001a\u00020\f*\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001c\u001a\u001a\u0010|\u001a\u00020\f*\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010}\u001a\u00020\u0002\u001a\u0012\u0010~\u001a\u00020\f*\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001c\u001a\u0014\u0010\u007f\u001a\u00020\f*\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001cH\u0007\u001a\u0013\u0010\u0080\u0001\u001a\u00020\f*\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001c\u001a\u0013\u0010\u0081\u0001\u001a\u00020\f*\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001c\u001a\u0013\u0010\u0082\u0001\u001a\u00020\f*\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001c\u001a\u0013\u0010\u0083\u0001\u001a\u00020\f*\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001c\u001a5\u0010\u0084\u0001\u001a\u0004\u0018\u00010\u0002*\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010W\u001a\u00020\u00012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00012\b\b\u0002\u0010*\u001a\u00020+H\u0007\u001a)\u0010\u0085\u0001\u001a\u0004\u0018\u00010\u0002*\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010W\u001a\u00020\u00012\b\b\u0002\u0010*\u001a\u00020+H\u0007\u001a\"\u0010\u0086\u0001\u001a\u00020\f*\u00020\u00022\r\u0010\u0087\u0001\u001a\b\u0012\u0004\u0012\u00020\u00010aH\u0002¢\u0006\u0003\u0010\u0088\u0001\u001a1\u0010\u0089\u0001\u001a\u00020\u0019*\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010(\u001a\u00020\u00022\n\b\u0002\u0010E\u001a\u0004\u0018\u00010F2\u0006\u0010\u001f\u001a\u00020&H\u0007\u001a9\u0010\u0089\u0001\u001a\u00020\u0019*\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010(\u001a\u00020\u00022\b\u0010)\u001a\u0004\u0018\u00010\u00012\b\u0010G\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u001f\u001a\u00020&H\u0002\u001a%\u0010\u0089\u0001\u001a\u00020\u0019*\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020%2\u0006\u0010\u001f\u001a\u00020&H\u0007\u001a1\u0010\u0089\u0001\u001a\u00020\u0019*\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010(\u001a\u00020H2\n\b\u0002\u0010E\u001a\u0004\u0018\u00010F2\u0006\u0010\u001f\u001a\u00020&H\u0007\u001a1\u0010\u0089\u0001\u001a\u00020\u0019*\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010I\u001a\u00020\u00012\n\b\u0002\u0010E\u001a\u0004\u0018\u00010F2\u0006\u0010\u001f\u001a\u00020&H\u0007\u001a/\u0010\u008a\u0001\u001a\u00020\u0019*\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010E\u001a\u00020F2\u0006\u0010\u001f\u001a\u00020&2\b\b\u0002\u0010*\u001a\u00020+H\u0007\u001a/\u0010\u008b\u0001\u001a\u00020\u0019*\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010E\u001a\u00020F2\u0006\u0010\u001f\u001a\u00020&2\b\b\u0002\u0010*\u001a\u00020+H\u0007\u001a;\u0010\u008c\u0001\u001a\u00020\u0019*\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u00101\u001a\u00020\u00022\b\b\u0002\u0010P\u001a\u00020\f2\n\b\u0002\u0010Q\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u001f\u001a\u000203H\u0007\u001a5\u0010\u008d\u0001\u001a\u00020\u0019*\b\u0012\u0004\u0012\u00020\u00020T2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u00101\u001a\u00020\u00022\b\b\u0002\u0010P\u001a\u00020\f2\u0006\u0010\u001f\u001a\u00020UH\u0007\u001a\u001f\u0010\u008e\u0001\u001a\u00030\u008f\u0001*\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001c2\u0007\u0010\u0090\u0001\u001a\u00020\u0001H\u0007\u001a\u0017\u0010\u0091\u0001\u001a\u0004\u0018\u00010#*\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001cH\u0007\u001a\"\u0010\u0092\u0001\u001a\u0004\u0018\u00010$*\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001c2\t\b\u0002\u0010\u0093\u0001\u001a\u00020\fH\u0007\u001a\u0017\u0010\u0094\u0001\u001a\u0004\u0018\u00010\u0002*\u00020\u00022\u0006\u0010W\u001a\u00020\u0001H\u0007\u001a)\u0010\u0095\u0001\u001a\u0004\u0018\u00010\u0002*\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001c2\b\u0010\u0096\u0001\u001a\u00030\u0097\u00012\u0006\u0010W\u001a\u00020\u0001H\u0007\u001a\u0015\u0010\u0098\u0001\u001a\u0004\u0018\u00010\u0002*\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001c\u001aY\u0010\u0099\u0001\u001a\b\u0012\u0004\u0012\u00020\u00020T*\u00020\u00022\t\b\u0002\u0010\u009a\u0001\u001a\u00020\f2\b\b\u0002\u0010b\u001a\u00020c2\u0011\b\u0002\u0010\u009b\u0001\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010a2\b\b\u0002\u0010W\u001a\u00020\u00012\f\b\u0002\u0010\u009c\u0001\u001a\u0005\u0018\u00010\u009d\u0001H\u0007¢\u0006\u0003\u0010\u009e\u0001\u001a\u001d\u0010\u009f\u0001\u001a\u00020\f*\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u00108\u001a\u00020\fH\u0007\u001a\u0015\u0010 \u0001\u001a\u00020\f*\u00020\u00022\u0006\u0010\u001f\u001a\u00020&H\u0002\u001a\u001f\u0010¡\u0001\u001a\u0004\u0018\u00010\u0002*\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u00108\u001a\u00020\fH\u0007\u001a\u0014\u0010¢\u0001\u001a\u00030£\u0001*\b0¤\u0001j\u0003`¥\u0001H\u0000\u001a\u0014\u0010¦\u0001\u001a\u00030§\u0001*\b0¤\u0001j\u0003`¥\u0001H\u0002\u001a\u0015\u0010¨\u0001\u001a\u0004\u0018\u00010%*\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001c\u001a\u0014\u0010©\u0001\u001a\u00030ª\u0001*\b0¤\u0001j\u0003`¥\u0001H\u0002\u001a\u0015\u0010«\u0001\u001a\u0004\u0018\u00010\u0002*\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001c\u001a\u0015\u0010¬\u0001\u001a\u0004\u0018\u00010H*\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001c\u001a\u0015\u0010\u00ad\u0001\u001a\u0004\u0018\u00010\u0002*\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001c\u001a\u0017\u0010®\u0001\u001a\u0004\u0018\u00010\u0002*\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001cH\u0007\u001aC\u0010¯\u0001\u001a\u0004\u0018\u00010?*\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001c2\u0007\u0010°\u0001\u001a\u00020\u00022\u0006\u00102\u001a\u00020\u00012\u0006\u0010P\u001a\u00020\f2\b\u0010Q\u001a\u0004\u0018\u00010\u00012\u0007\u0010±\u0001\u001a\u000200H\u0002\u001a\u001b\u0010²\u0001\u001a\b\u0012\u0004\u0012\u00020\u00020T*\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001cH\u0002\u001a\u0013\u0010³\u0001\u001a\b\u0012\u0004\u0012\u00020\u00020T*\u00020\u0002H\u0002\u001a\u0013\u0010´\u0001\u001a\b\u0012\u0004\u0012\u00020\u00020T*\u00020\u0002H\u0002\u001a\u0013\u0010µ\u0001\u001a\b\u0012\u0004\u0012\u00020\u00020T*\u00020\u0002H\u0002\u001a!\u0010¶\u0001\u001a\u00020\u0019*\u00020\u00022\b\u0010·\u0001\u001a\u00030¸\u00012\b\u0010¹\u0001\u001a\u00030º\u0001H\u0002\u001aO\u0010»\u0001\u001a\b\u0012\u0004\u0012\u00020\u00020T*\u00020\u00022\u0006\u0010b\u001a\u00020c2\r\u0010\u009b\u0001\u001a\b\u0012\u0004\u0012\u00020\u00010a2\u0007\u0010¼\u0001\u001a\u00020\u00012\n\u0010\u009c\u0001\u001a\u0005\u0018\u00010\u009d\u00012\b\u0010¹\u0001\u001a\u00030º\u0001H\u0002¢\u0006\u0003\u0010½\u0001\"\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\"\u0015\u0010\u0005\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0004\"\u0015\u0010\u0007\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\b\u0010\u0004\"\u0015\u0010\t\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\n\u0010\u0004\"\u0015\u0010\u000b\u001a\u00020\f*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\r\"\u0015\u0010\u000e\u001a\u00020\f*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\r\"\u0015\u0010\u000f\u001a\u00020\f*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\r\"\u0015\u0010\u0010\u001a\u00020\f*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\r\"\u0015\u0010\u0011\u001a\u00020\f*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\r\"\u0017\u0010\u0012\u001a\u0004\u0018\u00010\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0004\"\u0017\u0010\u0014\u001a\u0004\u0018\u00010\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0004\"\u0015\u0010\u0016\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0004¨\u0006¾\u0001"}, m107d2 = {"baseName", "", "Landroidx/documentfile/provider/DocumentFile;", "getBaseName", "(Landroidx/documentfile/provider/DocumentFile;)Ljava/lang/String;", ShareConstants.MEDIA_EXTENSION, "getExtension", "fullName", "getFullName", "id", "getId", "isDownloadsDocument", "", "(Landroidx/documentfile/provider/DocumentFile;)Z", "isExternalStorageDocument", "isMediaDocument", "isRawFile", "isTreeDocumentFile", "mimeType", "getMimeType", "mimeTypeByFileName", "getMimeTypeByFileName", "rootId", "getRootId", "createFileStreams", "", "Enum", "context", "Landroid/content/Context;", "sourceFile", "targetFile", "callback", "Lcom/anggrayudi/storage/callback/BaseFileCallback;", "onStreamsReady", "Lkotlin/Function2;", "Ljava/io/InputStream;", "Ljava/io/OutputStream;", "Lcom/anggrayudi/storage/media/MediaFile;", "Lcom/anggrayudi/storage/callback/FileCallback;", "createTargetFile", "targetFolder", "newFilenameInTargetPath", "mode", "Lcom/anggrayudi/storage/file/CreateMode;", "handleFileConflict", "Lcom/anggrayudi/storage/callback/FileCallback$ConflictResolution;", "targetFileName", "handleParentFolderConflict", "Lcom/anggrayudi/storage/callback/FolderCallback$ConflictResolution;", "targetParentFolder", "targetFolderParentName", "Lcom/anggrayudi/storage/callback/FolderCallback;", "autoIncrementFileName", "filename", "canModify", "checkRequirements", "requiresWriteAccess", "considerRawFile", "child", "path", "copyFileStream", "inputStream", "outputStream", "", "watchProgress", "reportInterval", "", "deleteSourceFileWhenComplete", "copyFileTo", "fileDescription", "Lcom/anggrayudi/storage/media/FileDescription;", "newMimeTypeInTargetPath", "Ljava/io/File;", "targetFolderAbsolutePath", "copyFileToDownloadMedia", "copyFileToMedia", "publicDirectory", "Lcom/anggrayudi/storage/file/PublicDirectory;", "copyFileToPictureMedia", "copyFolderTo", "skipEmptyFiles", "newFolderNameInTargetPath", "deleteSourceWhenComplete", "copyTo", "", "Lcom/anggrayudi/storage/callback/MultipleFileCallback;", "createBinaryFile", "name", "deleteEmptyFolders", "deleteRecursively", "childrenOnly", "doesMeetCopyRequirements", "Lkotlin/Pair;", "", "findFileLiterally", "findFiles", "names", "", "documentType", "Lcom/anggrayudi/storage/file/DocumentFileType;", "(Landroidx/documentfile/provider/DocumentFile;[Ljava/lang/String;Lcom/anggrayudi/storage/file/DocumentFileType;)Ljava/util/List;", "findFolder", "forceDelete", "getAbsolutePath", "getBasePath", "getFormattedSize", "kotlin.jvm.PlatformType", "getProperties", "Lcom/anggrayudi/storage/file/FileProperties$CalculationCallback;", "getRelativePath", "getRootDocumentFile", "getRootPath", "getSimplePath", "getStorageId", "getStorageType", "Lcom/anggrayudi/storage/file/StorageType;", "getSubPath", "otherFolderAbsolutePath", "Lcom/anggrayudi/storage/callback/MultipleFileCallback$ParentConflict;", "hasParent", "parent", "inDataStorage", "inInternalStorage", "inPrimaryStorage", "inSameMountPointWith", "file", "inSdCardStorage", "isEmpty", "isExternalStorageManager", "isReadOnly", "isRootUriPermissionGranted", "isWritable", "makeFile", "makeFolder", "matchesMimeTypes", "filterMimeTypes", "(Landroidx/documentfile/provider/DocumentFile;[Ljava/lang/String;)Z", "moveFileTo", "moveFileToDownloadMedia", "moveFileToPictureMedia", "moveFolderTo", "moveTo", "openFileIntent", "Landroid/content/Intent;", "authority", "openInputStream", "openOutputStream", AgentOptions.APPEND, "quickFindRawFile", "quickFindTreeFile", "resolver", "Landroid/content/ContentResolver;", "recreateFile", "search", "recursive", "mimeTypes", "regex", "Lkotlin/text/Regex;", "(Landroidx/documentfile/provider/DocumentFile;ZLcom/anggrayudi/storage/file/DocumentFileType;[Ljava/lang/String;Ljava/lang/String;Lkotlin/text/Regex;)Ljava/util/List;", "shouldWritable", "simpleCheckSourceFile", "takeIfWritable", "toFileCallbackErrorCode", "Lcom/anggrayudi/storage/callback/FileCallback$ErrorCode;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "toFolderCallbackErrorCode", "Lcom/anggrayudi/storage/callback/FolderCallback$ErrorCode;", "toMediaFile", "toMultipleFileCallbackErrorCode", "Lcom/anggrayudi/storage/callback/MultipleFileCallback$ErrorCode;", "toRawDocumentFile", "toRawFile", "toTreeDocumentFile", "toWritableDownloadsDocumentFile", "tryMoveFolderByRenamingPath", "writableTargetParentFolder", "conflictResolution", "walkFileTree", "walkFileTreeAndDeleteEmptyFolders", "walkFileTreeAndSkipEmptyFiles", "walkFileTreeForDeletion", "walkFileTreeForInfo", "properties", "Lcom/anggrayudi/storage/file/FileProperties;", "thread", "Ljava/lang/Thread;", "walkFileTreeForSearch", "nameFilter", "(Landroidx/documentfile/provider/DocumentFile;Lcom/anggrayudi/storage/file/DocumentFileType;[Ljava/lang/String;Ljava/lang/String;Lkotlin/text/Regex;Ljava/lang/Thread;)Ljava/util/List;", "storage_release"}, m106k = 2, m105mv = {1, 5, 1}, m103xi = 48)
/* renamed from: com.anggrayudi.storage.file.DocumentFileUtils */
/* loaded from: classes.dex */
public final class DocumentFileExt {

    /* compiled from: DocumentFileExt.kt */
    @Metadata(m106k = 3, m105mv = {1, 5, 1}, m103xi = 48)
    /* renamed from: com.anggrayudi.storage.file.DocumentFileUtils$WhenMappings */
    /* loaded from: classes.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;
        public static final /* synthetic */ int[] $EnumSwitchMapping$2;

        static {
            int[] iArr = new int[DocumentFileType.values().length];
            iArr[DocumentFileType.FILE.ordinal()] = 1;
            iArr[DocumentFileType.FOLDER.ordinal()] = 2;
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[FolderCallback.ErrorCode.values().length];
            iArr2[FolderCallback.ErrorCode.INVALID_TARGET_FOLDER.ordinal()] = 1;
            iArr2[FolderCallback.ErrorCode.STORAGE_PERMISSION_DENIED.ordinal()] = 2;
            $EnumSwitchMapping$1 = iArr2;
            int[] iArr3 = new int[FolderCallback.ConflictResolution.values().length];
            iArr3[FolderCallback.ConflictResolution.REPLACE.ordinal()] = 1;
            iArr3[FolderCallback.ConflictResolution.MERGE.ordinal()] = 2;
            $EnumSwitchMapping$2 = iArr3;
        }
    }

    public static final DocumentFile child(DocumentFile documentFile, Context context, String path) {
        Intrinsics.checkNotNullParameter(documentFile, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(path, "path");
        return child$default(documentFile, context, path, false, 4, null);
    }

    public static final void copyFileToDownloadMedia(DocumentFile documentFile, Context context, FileDescription fileDescription, FileCallback callback) {
        Intrinsics.checkNotNullParameter(documentFile, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(fileDescription, "fileDescription");
        Intrinsics.checkNotNullParameter(callback, "callback");
        copyFileToDownloadMedia$default(documentFile, context, fileDescription, callback, null, 8, null);
    }

    public static final void copyFileToPictureMedia(DocumentFile documentFile, Context context, FileDescription fileDescription, FileCallback callback) {
        Intrinsics.checkNotNullParameter(documentFile, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(fileDescription, "fileDescription");
        Intrinsics.checkNotNullParameter(callback, "callback");
        copyFileToPictureMedia$default(documentFile, context, fileDescription, callback, null, 8, null);
    }

    public static final DocumentFile createBinaryFile(DocumentFile documentFile, Context context, String name) {
        Intrinsics.checkNotNullParameter(documentFile, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(name, "name");
        return createBinaryFile$default(documentFile, context, name, null, 4, null);
    }

    public static final boolean deleteRecursively(DocumentFile documentFile, Context context) {
        Intrinsics.checkNotNullParameter(documentFile, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        return deleteRecursively$default(documentFile, context, false, 2, null);
    }

    public static final boolean forceDelete(DocumentFile documentFile, Context context) {
        Intrinsics.checkNotNullParameter(documentFile, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        return forceDelete$default(documentFile, context, false, 2, null);
    }

    public static final DocumentFile getRootDocumentFile(DocumentFile documentFile, Context context) {
        Intrinsics.checkNotNullParameter(documentFile, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        return getRootDocumentFile$default(documentFile, context, false, 2, null);
    }

    public static final DocumentFile makeFile(DocumentFile documentFile, Context context, String name) {
        Intrinsics.checkNotNullParameter(documentFile, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(name, "name");
        return makeFile$default(documentFile, context, name, null, null, 12, null);
    }

    public static final DocumentFile makeFile(DocumentFile documentFile, Context context, String name, String str) {
        Intrinsics.checkNotNullParameter(documentFile, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(name, "name");
        return makeFile$default(documentFile, context, name, str, null, 8, null);
    }

    public static final DocumentFile makeFolder(DocumentFile documentFile, Context context, String name) {
        Intrinsics.checkNotNullParameter(documentFile, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(name, "name");
        return makeFolder$default(documentFile, context, name, null, 4, null);
    }

    public static final void moveFileToDownloadMedia(DocumentFile documentFile, Context context, FileDescription fileDescription, FileCallback callback) {
        Intrinsics.checkNotNullParameter(documentFile, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(fileDescription, "fileDescription");
        Intrinsics.checkNotNullParameter(callback, "callback");
        moveFileToDownloadMedia$default(documentFile, context, fileDescription, callback, null, 8, null);
    }

    public static final void moveFileToPictureMedia(DocumentFile documentFile, Context context, FileDescription fileDescription, FileCallback callback) {
        Intrinsics.checkNotNullParameter(documentFile, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(fileDescription, "fileDescription");
        Intrinsics.checkNotNullParameter(callback, "callback");
        moveFileToPictureMedia$default(documentFile, context, fileDescription, callback, null, 8, null);
    }

    public static final OutputStream openOutputStream(DocumentFile documentFile, Context context) {
        Intrinsics.checkNotNullParameter(documentFile, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        return openOutputStream$default(documentFile, context, false, 2, null);
    }

    public static final List<DocumentFile> search(DocumentFile documentFile) {
        Intrinsics.checkNotNullParameter(documentFile, "<this>");
        return search$default(documentFile, false, null, null, null, null, 31, null);
    }

    public static final List<DocumentFile> search(DocumentFile documentFile, boolean z) {
        Intrinsics.checkNotNullParameter(documentFile, "<this>");
        return search$default(documentFile, z, null, null, null, null, 30, null);
    }

    public static final List<DocumentFile> search(DocumentFile documentFile, boolean z, DocumentFileType documentType) {
        Intrinsics.checkNotNullParameter(documentFile, "<this>");
        Intrinsics.checkNotNullParameter(documentType, "documentType");
        return search$default(documentFile, z, documentType, null, null, null, 28, null);
    }

    public static final List<DocumentFile> search(DocumentFile documentFile, boolean z, DocumentFileType documentType, String[] strArr) {
        Intrinsics.checkNotNullParameter(documentFile, "<this>");
        Intrinsics.checkNotNullParameter(documentType, "documentType");
        return search$default(documentFile, z, documentType, strArr, null, null, 24, null);
    }

    public static final List<DocumentFile> search(DocumentFile documentFile, boolean z, DocumentFileType documentType, String[] strArr, String name) {
        Intrinsics.checkNotNullParameter(documentFile, "<this>");
        Intrinsics.checkNotNullParameter(documentType, "documentType");
        Intrinsics.checkNotNullParameter(name, "name");
        return search$default(documentFile, z, documentType, strArr, name, null, 16, null);
    }

    public static final String getStorageId(DocumentFile documentFile, Context context) {
        Intrinsics.checkNotNullParameter(documentFile, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        Uri uri = documentFile.getUri();
        Intrinsics.checkNotNullExpressionValue(uri, "uri");
        return UriExt.getStorageId(uri, context);
    }

    public static final boolean isTreeDocumentFile(DocumentFile documentFile) {
        Intrinsics.checkNotNullParameter(documentFile, "<this>");
        Uri uri = documentFile.getUri();
        Intrinsics.checkNotNullExpressionValue(uri, "uri");
        return UriExt.isTreeDocumentFile(uri);
    }

    public static final boolean isExternalStorageDocument(DocumentFile documentFile) {
        Intrinsics.checkNotNullParameter(documentFile, "<this>");
        Uri uri = documentFile.getUri();
        Intrinsics.checkNotNullExpressionValue(uri, "uri");
        return UriExt.isExternalStorageDocument(uri);
    }

    public static final boolean isDownloadsDocument(DocumentFile documentFile) {
        Intrinsics.checkNotNullParameter(documentFile, "<this>");
        Uri uri = documentFile.getUri();
        Intrinsics.checkNotNullExpressionValue(uri, "uri");
        return UriExt.isDownloadsDocument(uri);
    }

    public static final boolean isMediaDocument(DocumentFile documentFile) {
        Intrinsics.checkNotNullParameter(documentFile, "<this>");
        Uri uri = documentFile.getUri();
        Intrinsics.checkNotNullExpressionValue(uri, "uri");
        return UriExt.isMediaDocument(uri);
    }

    public static final boolean isReadOnly(DocumentFile documentFile, Context context) {
        Intrinsics.checkNotNullParameter(documentFile, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        return documentFile.canRead() && !isWritable(documentFile, context);
    }

    public static final String getId(DocumentFile documentFile) {
        Intrinsics.checkNotNullParameter(documentFile, "<this>");
        String documentId = DocumentsContract.getDocumentId(documentFile.getUri());
        Intrinsics.checkNotNullExpressionValue(documentId, "getDocumentId(uri)");
        return documentId;
    }

    public static final String getRootId(DocumentFile documentFile) {
        Intrinsics.checkNotNullParameter(documentFile, "<this>");
        String rootId = DocumentsContract.getRootId(documentFile.getUri());
        Intrinsics.checkNotNullExpressionValue(rootId, "getRootId(uri)");
        return rootId;
    }

    public static final boolean isExternalStorageManager(DocumentFile documentFile, Context context) {
        Intrinsics.checkNotNullParameter(documentFile, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        if (isRawFile(documentFile)) {
            String path = documentFile.getUri().getPath();
            Intrinsics.checkNotNull(path);
            if (FileExt.isExternalStorageManager(new File(path), context)) {
                return true;
            }
        }
        return false;
    }

    public static final String getFullName(DocumentFile documentFile) {
        Intrinsics.checkNotNullParameter(documentFile, "<this>");
        if (isRawFile(documentFile) || isExternalStorageDocument(documentFile) || documentFile.isDirectory()) {
            String name = documentFile.getName();
            return name != null ? name : "";
        }
        String name2 = documentFile.getName();
        return MimeType.getFullFileName(name2 != null ? name2 : "", documentFile.getType());
    }

    public static final boolean inSameMountPointWith(DocumentFile documentFile, Context context, DocumentFile file) {
        Intrinsics.checkNotNullParameter(documentFile, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(file, "file");
        String storageId = getStorageId(documentFile, context);
        String storageId2 = getStorageId(file, context);
        return Intrinsics.areEqual(storageId, storageId2) || ((Intrinsics.areEqual(storageId, StorageId.PRIMARY) || Intrinsics.areEqual(storageId, "data")) && (Intrinsics.areEqual(storageId2, StorageId.PRIMARY) || Intrinsics.areEqual(storageId2, "data")));
    }

    public static final boolean isEmpty(DocumentFile documentFile, Context context) {
        Cursor query;
        boolean z;
        Intrinsics.checkNotNullParameter(documentFile, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        if (!documentFile.isFile() || documentFile.length() != 0) {
            if (!documentFile.isDirectory()) {
                return false;
            }
            if (isRawFile(documentFile)) {
                File rawFile = toRawFile(documentFile, context);
                String[] list = rawFile != null ? rawFile.list() : null;
                if (list != null) {
                    if (!(list.length == 0)) {
                        z = false;
                    }
                }
                z = true;
            } else {
                try {
                    query = context.getContentResolver().query(DocumentsContract.buildChildDocumentsUriUsingTree(documentFile.getUri(), getId(documentFile)), new String[]{"document_id"}, null, null, null);
                } catch (Exception unused) {
                }
                if (query == null) {
                    z = true;
                } else {
                    Cursor cursor = query;
                    Throwable th = null;
                    z = cursor.getCount() == 0;
                    Closeable.closeFinally(cursor, th);
                }
            }
            if (!z) {
                return false;
            }
        }
        return true;
    }

    public static final void getProperties(DocumentFile documentFile, Context context, FileProperties.CalculationCallback callback) {
        Job startCoroutineTimer;
        Intrinsics.checkNotNullParameter(documentFile, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (!documentFile.canRead()) {
            BuildersKt__Builders_commonKt.launch$default(callback.getUiScope(), Dispatchers.getMain(), null, new DocumentFileUtils$getProperties$$inlined$postToUi$1(null, callback), 2, null);
        } else if (documentFile.isDirectory()) {
            String name = documentFile.getName();
            if (name == null) {
                name = "";
            }
            String str = name;
            String absolutePath = getAbsolutePath(documentFile, context);
            boolean isVirtual = documentFile.isVirtual();
            long lastModified = documentFile.lastModified();
            FileProperties fileProperties = new FileProperties(str, absolutePath, 0L, true, 0, 0, 0, 0, isVirtual, lastModified > 0 ? new Date(lastModified) : null, 244, null);
            if (isEmpty(documentFile, context)) {
                BuildersKt__Builders_commonKt.launch$default(callback.getUiScope(), Dispatchers.getMain(), null, new DocumentFileUtils$getProperties$$inlined$postToUi$2(null, callback, fileProperties), 2, null);
                return;
            }
            if (callback.getUpdateInterval() < 1) {
                startCoroutineTimer = null;
            } else {
                startCoroutineTimer = CoroutineExt.startCoroutineTimer((r14 & 1) != 0 ? 0L : 0L, (r14 & 2) != 0 ? 0L : callback.getUpdateInterval(), (r14 & 4) != 0 ? false : false, new DocumentFileUtils$getProperties$timer$1(callback, fileProperties));
            }
            Thread thread = Thread.currentThread();
            Intrinsics.checkNotNullExpressionValue(thread, "thread");
            walkFileTreeForInfo(documentFile, fileProperties, thread);
            if (startCoroutineTimer != null) {
                Job.DefaultImpls.cancel$default(startCoroutineTimer, (CancellationException) null, 1, (Object) null);
            }
            BuildersKt__Builders_commonKt.launch$default(callback.getUiScope(), Dispatchers.getMain(), null, new DocumentFileUtils$getProperties$$inlined$postToUi$3(null, thread.isInterrupted(), callback, fileProperties), 2, null);
        } else if (documentFile.isFile()) {
            String fullName = getFullName(documentFile);
            String absolutePath2 = getAbsolutePath(documentFile, context);
            long length = documentFile.length();
            boolean isVirtual2 = documentFile.isVirtual();
            long lastModified2 = documentFile.lastModified();
            BuildersKt__Builders_commonKt.launch$default(callback.getUiScope(), Dispatchers.getMain(), null, new DocumentFileUtils$getProperties$$inlined$postToUi$4(null, callback, new FileProperties(fullName, absolutePath2, length, false, 0, 0, 0, 0, isVirtual2, lastModified2 > 0 ? new Date(lastModified2) : null, bqk.f6595cb, null)), 2, null);
        }
    }

    private static final void walkFileTreeForInfo(DocumentFile documentFile, FileProperties fileProperties, Thread thread) {
        DocumentFile[] listFiles = documentFile.listFiles();
        Intrinsics.checkNotNullExpressionValue(listFiles, "listFiles()");
        if (listFiles.length == 0) {
            fileProperties.setEmptyFolders(fileProperties.getEmptyFolders() + 1);
            return;
        }
        for (DocumentFile it : listFiles) {
            if (thread.isInterrupted()) {
                return;
            }
            if (it.isFile()) {
                fileProperties.setFiles(fileProperties.getFiles() + 1);
                long length = it.length();
                fileProperties.setSize(fileProperties.getSize() + length);
                if (length == 0) {
                    fileProperties.setEmptyFiles(fileProperties.getEmptyFiles() + 1);
                }
            } else {
                fileProperties.setFolders(fileProperties.getFolders() + 1);
                Intrinsics.checkNotNullExpressionValue(it, "it");
                walkFileTreeForInfo(it, fileProperties, thread);
            }
        }
    }

    public static final StorageType getStorageType(DocumentFile documentFile, Context context) {
        Intrinsics.checkNotNullParameter(documentFile, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        return isTreeDocumentFile(documentFile) ? inPrimaryStorage(documentFile, context) ? StorageType.EXTERNAL : StorageType.SD_CARD : inSdCardStorage(documentFile, context) ? StorageType.SD_CARD : inDataStorage(documentFile, context) ? StorageType.DATA : StorageType.UNKNOWN;
    }

    public static final boolean inInternalStorage(DocumentFile documentFile, Context context) {
        Intrinsics.checkNotNullParameter(documentFile, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        String storageId = getStorageId(documentFile, context);
        return Intrinsics.areEqual(storageId, StorageId.PRIMARY) || Intrinsics.areEqual(storageId, "data");
    }

    public static final boolean inPrimaryStorage(DocumentFile documentFile, Context context) {
        Intrinsics.checkNotNullParameter(documentFile, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        if (!isTreeDocumentFile(documentFile) || !Intrinsics.areEqual(getStorageId(documentFile, context), StorageId.PRIMARY)) {
            if (!isRawFile(documentFile)) {
                return false;
            }
            String path = documentFile.getUri().getPath();
            if (path == null) {
                path = "";
            }
            if (!StringsKt.startsWith$default(path, SimpleStorage.Companion.getExternalStoragePath(), false, 2, (Object) null)) {
                return false;
            }
        }
        return true;
    }

    public static final boolean inSdCardStorage(DocumentFile documentFile, Context context) {
        Intrinsics.checkNotNullParameter(documentFile, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        if (!isTreeDocumentFile(documentFile) || Intrinsics.areEqual(getStorageId(documentFile, context), StorageId.PRIMARY)) {
            if (!isRawFile(documentFile)) {
                return false;
            }
            String path = documentFile.getUri().getPath();
            if (path == null) {
                path = "";
            }
            if (!StringsKt.startsWith$default(path, Intrinsics.stringPlus("/storage/", getStorageId(documentFile, context)), false, 2, (Object) null)) {
                return false;
            }
        }
        return true;
    }

    public static final boolean inDataStorage(DocumentFile documentFile, Context context) {
        Intrinsics.checkNotNullParameter(documentFile, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        if (isRawFile(documentFile)) {
            String path = documentFile.getUri().getPath();
            Intrinsics.checkNotNull(path);
            if (FileExt.inDataStorage(new File(path), context)) {
                return true;
            }
        }
        return false;
    }

    public static final boolean isRawFile(DocumentFile documentFile) {
        Intrinsics.checkNotNullParameter(documentFile, "<this>");
        Uri uri = documentFile.getUri();
        Intrinsics.checkNotNullExpressionValue(uri, "uri");
        return UriExt.isRawFile(uri);
    }

    public static final String getBaseName(DocumentFile documentFile) {
        Intrinsics.checkNotNullParameter(documentFile, "<this>");
        return StringsKt.substringBeforeLast$default(getFullName(documentFile), '.', (String) null, 2, (Object) null);
    }

    public static final String getExtension(DocumentFile documentFile) {
        Intrinsics.checkNotNullParameter(documentFile, "<this>");
        return StringsKt.substringAfterLast(getFullName(documentFile), '.', "");
    }

    public static final String getMimeType(DocumentFile documentFile) {
        Intrinsics.checkNotNullParameter(documentFile, "<this>");
        if (documentFile.isFile()) {
            String type = documentFile.getType();
            return type == null ? MimeType.getMimeTypeFromExtension(getExtension(documentFile)) : type;
        }
        return null;
    }

    public static final String getMimeTypeByFileName(DocumentFile documentFile) {
        Intrinsics.checkNotNullParameter(documentFile, "<this>");
        if (documentFile.isDirectory()) {
            return null;
        }
        String name = documentFile.getName();
        if (name == null) {
            name = "";
        }
        String mimeTypeFromExtension = MimeType.getMimeTypeFromExtension(StringsKt.substringAfterLast(name, '.', ""));
        return Intrinsics.areEqual(mimeTypeFromExtension, MimeType.UNKNOWN) ? documentFile.getType() : mimeTypeFromExtension;
    }

    public static final File toRawFile(DocumentFile documentFile, Context context) {
        Intrinsics.checkNotNullParameter(documentFile, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        if (isRawFile(documentFile)) {
            String path = documentFile.getUri().getPath();
            if (path == null) {
                return null;
            }
            return new File(path);
        } else if (inPrimaryStorage(documentFile, context)) {
            return new File(SimpleStorage.Companion.getExternalStoragePath() + JsonPointer.SEPARATOR + getBasePath(documentFile, context));
        } else {
            if (getStorageId(documentFile, context).length() > 0) {
                return new File("/storage/" + getStorageId(documentFile, context) + JsonPointer.SEPARATOR + getBasePath(documentFile, context));
            }
            return null;
        }
    }

    public static final DocumentFile toRawDocumentFile(DocumentFile documentFile, Context context) {
        Intrinsics.checkNotNullParameter(documentFile, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        if (isRawFile(documentFile)) {
            return documentFile;
        }
        File rawFile = toRawFile(documentFile, context);
        if (rawFile == null) {
            return null;
        }
        return DocumentFile.fromFile(rawFile);
    }

    public static final DocumentFile toTreeDocumentFile(DocumentFile documentFile, Context context) {
        Intrinsics.checkNotNullParameter(documentFile, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        if (isRawFile(documentFile)) {
            File rawFile = toRawFile(documentFile, context);
            if (rawFile == null) {
                return null;
            }
            return DocumentFileCompat.fromFile$default(context, rawFile, null, false, false, 12, null);
        } else if (isTreeDocumentFile(documentFile)) {
            return documentFile;
        } else {
            return null;
        }
    }

    public static final MediaFile toMediaFile(DocumentFile documentFile, Context context) {
        Intrinsics.checkNotNullParameter(documentFile, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        if (isTreeDocumentFile(documentFile)) {
            return null;
        }
        Uri uri = documentFile.getUri();
        Intrinsics.checkNotNullExpressionValue(uri, "uri");
        return new MediaFile(context, uri);
    }

    public static /* synthetic */ DocumentFile child$default(DocumentFile documentFile, Context context, String str, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            z = false;
        }
        return child(documentFile, context, str, z);
    }

    /* JADX WARN: Removed duplicated region for block: B:51:0x0046  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final androidx.documentfile.provider.DocumentFile child(androidx.documentfile.provider.DocumentFile r4, android.content.Context r5, java.lang.String r6, boolean r7) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            java.lang.String r0 = "context"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            java.lang.String r0 = "path"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            r0 = r6
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            int r0 = r0.length()
            if (r0 != 0) goto L1a
            r0 = 1
            goto L1b
        L1a:
            r0 = 0
        L1b:
            r1 = 0
            if (r0 == 0) goto L1f
            goto L69
        L1f:
            boolean r0 = r4.isDirectory()
            if (r0 == 0) goto L68
            boolean r0 = isRawFile(r4)
            if (r0 == 0) goto L30
            androidx.documentfile.provider.DocumentFile r4 = quickFindRawFile(r4, r6)
            goto L60
        L30:
            android.content.ContentResolver r0 = r5.getContentResolver()
            com.anggrayudi.storage.file.DocumentFileCompat r2 = com.anggrayudi.storage.file.DocumentFileCompat.INSTANCE
            java.util.List r6 = r2.getDirectorySequence$storage_release(r6)
            java.lang.Iterable r6 = (java.lang.Iterable) r6
            java.util.Iterator r6 = r6.iterator()
        L40:
            boolean r2 = r6.hasNext()
            if (r2 == 0) goto L60
            java.lang.Object r2 = r6.next()
            java.lang.String r2 = (java.lang.String) r2
            java.lang.String r3 = "resolver"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r3)
            androidx.documentfile.provider.DocumentFile r4 = quickFindTreeFile(r4, r5, r0, r2)
            if (r4 != 0) goto L58
            return r1
        L58:
            boolean r2 = r4.canRead()
            if (r2 == 0) goto L5f
            goto L40
        L5f:
            return r1
        L60:
            if (r4 != 0) goto L63
            goto L68
        L63:
            androidx.documentfile.provider.DocumentFile r4 = takeIfWritable(r4, r5, r7)
            goto L69
        L68:
            r4 = r1
        L69:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anggrayudi.storage.file.DocumentFileExt.child(androidx.documentfile.provider.DocumentFile, android.content.Context, java.lang.String, boolean):androidx.documentfile.provider.DocumentFile");
    }

    public static final DocumentFile quickFindRawFile(DocumentFile documentFile, String name) {
        Intrinsics.checkNotNullParameter(documentFile, "<this>");
        Intrinsics.checkNotNullParameter(name, "name");
        String path = documentFile.getUri().getPath();
        Intrinsics.checkNotNull(path);
        DocumentFile fromFile = DocumentFile.fromFile(new File(path, name));
        if (fromFile.canRead()) {
            return fromFile;
        }
        return null;
    }

    public static final DocumentFile quickFindTreeFile(DocumentFile documentFile, Context context, ContentResolver resolver, String name) {
        Intrinsics.checkNotNullParameter(documentFile, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(resolver, "resolver");
        Intrinsics.checkNotNullParameter(name, "name");
        try {
            Cursor query = resolver.query(DocumentsContract.buildChildDocumentsUriUsingTree(documentFile.getUri(), getId(documentFile)), new String[]{"document_id"}, null, null, null);
            if (query != null) {
                Cursor cursor = query;
                Throwable th = null;
                Cursor cursor2 = cursor;
                String[] strArr = {"_display_name"};
                while (cursor2.moveToNext()) {
                    try {
                        Uri documentUri = DocumentsContract.buildDocumentUriUsingTree(documentFile.getUri(), cursor2.getString(0));
                        Cursor query2 = resolver.query(documentUri, strArr, null, null, null);
                        if (query2 != null) {
                            Cursor cursor3 = query2;
                            Throwable th2 = null;
                            try {
                                Cursor cursor4 = cursor3;
                                if (cursor4.moveToFirst() && Intrinsics.areEqual(name, cursor4.getString(0))) {
                                    Intrinsics.checkNotNullExpressionValue(documentUri, "documentUri");
                                    DocumentFile fromTreeUri = ContextExt.fromTreeUri(context, documentUri);
                                    Closeable.closeFinally(cursor3, th2);
                                    Closeable.closeFinally(cursor, th);
                                    return fromTreeUri;
                                }
                                Unit unit = Unit.INSTANCE;
                                Closeable.closeFinally(cursor3, th2);
                            } finally {
                            }
                        }
                    } catch (Exception unused) {
                    }
                }
                Unit unit2 = Unit.INSTANCE;
                Closeable.closeFinally(cursor, th);
            }
        } catch (Exception unused2) {
        }
        return null;
    }

    public static final boolean shouldWritable(DocumentFile documentFile, Context context, boolean z) {
        Intrinsics.checkNotNullParameter(documentFile, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        return (z && isWritable(documentFile, context)) || !z;
    }

    public static final DocumentFile takeIfWritable(DocumentFile documentFile, Context context, boolean z) {
        Intrinsics.checkNotNullParameter(documentFile, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        if (shouldWritable(documentFile, context, z)) {
            return documentFile;
        }
        return null;
    }

    public static final boolean checkRequirements(DocumentFile documentFile, Context context, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(documentFile, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        return documentFile.canRead() && (z2 || isExternalStorageManager(documentFile, context)) && shouldWritable(documentFile, context, z);
    }

    public static final String getBasePath(DocumentFile documentFile, Context context) {
        Intrinsics.checkNotNullParameter(documentFile, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        String path = documentFile.getUri().getPath();
        if (path == null) {
            path = "";
        }
        String storageId = getStorageId(documentFile, context);
        if (isRawFile(documentFile)) {
            return FileExt.getBasePath(new File(path), context);
        }
        if (isExternalStorageDocument(documentFile)) {
            if (StringsKt.contains$default((CharSequence) path, (CharSequence) ("/document/" + storageId + ':'), false, 2, (Object) null)) {
                return TextExt.trimFileSeparator(StringsKt.substringAfterLast(path, "/document/" + storageId + ':', ""));
            }
        }
        if (isDownloadsDocument(documentFile)) {
            if (Build.VERSION.SDK_INT < 28) {
                if (new Regex("/document/\\d+").matches(path)) {
                    Uri uri = documentFile.getUri();
                    Intrinsics.checkNotNullExpressionValue(uri, "uri");
                    String name = new MediaFile(context, uri).getName();
                    if (name == null) {
                        return "";
                    }
                    return ((Object) Environment.DIRECTORY_DOWNLOADS) + JsonPointer.SEPARATOR + name;
                }
            }
            if (Build.VERSION.SDK_INT >= 29) {
                if (new Regex("(.*?)/ms[f,d]:\\d+(.*?)").matches(path)) {
                    if (!isTreeDocumentFile(documentFile)) {
                        return "";
                    }
                    String[] strArr = new String[1];
                    String name2 = documentFile.getName();
                    if (name2 == null) {
                        name2 = "";
                    }
                    strArr[0] = name2;
                    List mutableListOf = CollectionsKt.mutableListOf(strArr);
                    while (true) {
                        DocumentFile parentFile = documentFile.getParentFile();
                        if (parentFile == null) {
                            parentFile = null;
                        } else {
                            documentFile = parentFile;
                        }
                        if (parentFile != null) {
                            String name3 = documentFile.getName();
                            if (name3 == null) {
                                name3 = "";
                            }
                            mutableListOf.add(name3);
                        } else {
                            return CollectionsKt.joinToString$default(CollectionsKt.reversed(mutableListOf), "/", null, null, 0, null, null, 62, null);
                        }
                    }
                }
            }
            return TextExt.trimFileSeparator(StringsKt.substringAfterLast(path, SimpleStorage.Companion.getExternalStoragePath(), ""));
        }
        return "";
    }

    private static final String getSubPath(DocumentFile documentFile, Context context, String str) {
        String absolutePath = getAbsolutePath(documentFile, context);
        return absolutePath.length() > str.length() ? TextExt.trimFileSeparator(StringsKt.substringAfter(absolutePath, StringsKt.substringAfterLast$default(str, (char) JsonPointer.SEPARATOR, (String) null, 2, (Object) null), "")) : str.length() > absolutePath.length() ? TextExt.trimFileSeparator(StringsKt.substringAfter(str, StringsKt.substringAfterLast$default(absolutePath, (char) JsonPointer.SEPARATOR, (String) null, 2, (Object) null), "")) : "";
    }

    public static final String getRootPath(DocumentFile documentFile, Context context) {
        Intrinsics.checkNotNullParameter(documentFile, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        if (!isRawFile(documentFile)) {
            return !isTreeDocumentFile(documentFile) ? "" : inSdCardStorage(documentFile, context) ? Intrinsics.stringPlus("/storage/", getStorageId(documentFile, context)) : SimpleStorage.Companion.getExternalStoragePath();
        }
        String path = documentFile.getUri().getPath();
        String rootPath = path == null ? null : FileExt.getRootPath(new File(path), context);
        return rootPath != null ? rootPath : "";
    }

    public static final String getRelativePath(DocumentFile documentFile, Context context) {
        Intrinsics.checkNotNullParameter(documentFile, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        return StringsKt.substringBeforeLast(getBasePath(documentFile, context), (char) JsonPointer.SEPARATOR, "");
    }

    public static final String getAbsolutePath(DocumentFile documentFile, Context context) {
        String trimEnd;
        DocumentFile documentFile2 = documentFile;
        Intrinsics.checkNotNullParameter(documentFile2, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        String path = documentFile.getUri().getPath();
        String str = "";
        if (path == null) {
            path = "";
        }
        String storageId = getStorageId(documentFile, context);
        if (isRawFile(documentFile)) {
            return path;
        }
        if (isExternalStorageDocument(documentFile)) {
            if (StringsKt.contains$default((CharSequence) path, (CharSequence) ("/document/" + storageId + ':'), false, 2, (Object) null)) {
                String trimFileSeparator = TextExt.trimFileSeparator(StringsKt.substringAfterLast(path, "/document/" + storageId + ':', ""));
                if (Intrinsics.areEqual(storageId, StorageId.PRIMARY)) {
                    return StringsKt.trimEnd(SimpleStorage.Companion.getExternalStoragePath() + JsonPointer.SEPARATOR + trimFileSeparator, JsonPointer.SEPARATOR);
                }
                return StringsKt.trimEnd("/storage/" + storageId + JsonPointer.SEPARATOR + trimFileSeparator, JsonPointer.SEPARATOR);
            }
        }
        String uri = documentFile.getUri().toString();
        if (Intrinsics.areEqual(uri, DocumentFileCompat.DOWNLOADS_TREE_URI) || Intrinsics.areEqual(uri, "content://com.android.providers.downloads.documents/tree/downloads/document/downloads")) {
            String absolutePath = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).getAbsolutePath();
            Intrinsics.checkNotNullExpressionValue(absolutePath, "getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).absolutePath");
            return absolutePath;
        } else if (isDownloadsDocument(documentFile)) {
            if (Build.VERSION.SDK_INT < 28 && new Regex("/document/\\d+").matches(path)) {
                Uri uri2 = documentFile.getUri();
                Intrinsics.checkNotNullExpressionValue(uri2, "uri");
                String name = new MediaFile(context, uri2).getName();
                if (name == null) {
                    return "";
                }
                trimEnd = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS), name).getAbsolutePath();
            } else if (Build.VERSION.SDK_INT >= 29 && new Regex("(.*?)/ms[f,d]:\\d+(.*?)").matches(path)) {
                if (isTreeDocumentFile(documentFile)) {
                    String[] strArr = new String[1];
                    String name2 = documentFile.getName();
                    if (name2 == null) {
                        name2 = "";
                    }
                    strArr[0] = name2;
                    List mutableListOf = CollectionsKt.mutableListOf(strArr);
                    while (true) {
                        DocumentFile parentFile = documentFile2.getParentFile();
                        if (parentFile == null) {
                            parentFile = null;
                        } else {
                            documentFile2 = parentFile;
                        }
                        if (parentFile == null) {
                            break;
                        }
                        String name3 = documentFile2.getName();
                        if (name3 == null) {
                            name3 = "";
                        }
                        mutableListOf.add(name3);
                    }
                    trimEnd = StringsKt.trimEnd(SimpleStorage.Companion.getExternalStoragePath() + JsonPointer.SEPARATOR + CollectionsKt.joinToString$default(CollectionsKt.reversed(mutableListOf), "/", null, null, 0, null, null, 62, null), JsonPointer.SEPARATOR);
                }
                Intrinsics.checkNotNullExpressionValue(str, "{\n            when {\n                // API 26 - 27 => content://com.android.providers.downloads.documents/document/22\n                Build.VERSION.SDK_INT < Build.VERSION_CODES.P && path.matches(Regex(\"/document/\\\\d+\")) -> {\n                    val fileName = MediaFile(context, uri).name ?: return \"\"\n                    File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS), fileName).absolutePath\n                }\n\n                Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q && path.matches(Regex(\"(.*?)/ms[f,d]:\\\\d+(.*?)\")) -> {\n                    if (isTreeDocumentFile) {\n                        val parentTree = mutableListOf(name.orEmpty())\n                        var parent = this\n                        while (parent.parentFile?.also { parent = it } != null) {\n                            parentTree.add(parent.name.orEmpty())\n                        }\n                        \"${SimpleStorage.externalStoragePath}/${parentTree.reversed().joinToString(\"/\")}\".trimEnd('/')\n                    } else {\n                        // we can't use msf/msd ID as MediaFile ID to fetch relative path, so just return empty String\n                        \"\"\n                    }\n                }\n\n                else -> path.substringAfterLast(\"/document/raw:\", \"\").trimEnd('/')\n            }\n        }");
                return str;
            } else {
                trimEnd = StringsKt.trimEnd(StringsKt.substringAfterLast(path, "/document/raw:", ""), JsonPointer.SEPARATOR);
            }
            str = trimEnd;
            Intrinsics.checkNotNullExpressionValue(str, "{\n            when {\n                // API 26 - 27 => content://com.android.providers.downloads.documents/document/22\n                Build.VERSION.SDK_INT < Build.VERSION_CODES.P && path.matches(Regex(\"/document/\\\\d+\")) -> {\n                    val fileName = MediaFile(context, uri).name ?: return \"\"\n                    File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS), fileName).absolutePath\n                }\n\n                Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q && path.matches(Regex(\"(.*?)/ms[f,d]:\\\\d+(.*?)\")) -> {\n                    if (isTreeDocumentFile) {\n                        val parentTree = mutableListOf(name.orEmpty())\n                        var parent = this\n                        while (parent.parentFile?.also { parent = it } != null) {\n                            parentTree.add(parent.name.orEmpty())\n                        }\n                        \"${SimpleStorage.externalStoragePath}/${parentTree.reversed().joinToString(\"/\")}\".trimEnd('/')\n                    } else {\n                        // we can't use msf/msd ID as MediaFile ID to fetch relative path, so just return empty String\n                        \"\"\n                    }\n                }\n\n                else -> path.substringAfterLast(\"/document/raw:\", \"\").trimEnd('/')\n            }\n        }");
            return str;
        } else if (isTreeDocumentFile(documentFile)) {
            if (inPrimaryStorage(documentFile, context)) {
                return StringsKt.trimEnd(SimpleStorage.Companion.getExternalStoragePath() + JsonPointer.SEPARATOR + getBasePath(documentFile, context), JsonPointer.SEPARATOR);
            }
            return StringsKt.trimEnd("/storage/" + storageId + JsonPointer.SEPARATOR + getBasePath(documentFile, context), JsonPointer.SEPARATOR);
        } else {
            return "";
        }
    }

    public static final String getSimplePath(DocumentFile documentFile, Context context) {
        Intrinsics.checkNotNullParameter(documentFile, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        return StringsKt.removePrefix(getStorageId(documentFile, context) + ':' + getBasePath(documentFile, context), (CharSequence) ":");
    }

    public static final DocumentFile recreateFile(DocumentFile documentFile, Context context) {
        Intrinsics.checkNotNullParameter(documentFile, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        if (documentFile.exists()) {
            if (isRawFile(documentFile) || isExternalStorageDocument(documentFile)) {
                String name = documentFile.getName();
                if (name == null) {
                    name = "";
                }
                String str = name;
                DocumentFile parentFile = documentFile.getParentFile();
                if (parentFile != null && isWritable(parentFile, context)) {
                    String type = documentFile.getType();
                    forceDelete$default(documentFile, context, false, 2, null);
                    return makeFile$default(parentFile, context, str, type, null, 8, null);
                }
                return null;
            }
            return null;
        }
        return null;
    }

    public static /* synthetic */ DocumentFile getRootDocumentFile$default(DocumentFile documentFile, Context context, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return getRootDocumentFile(documentFile, context, z);
    }

    public static final DocumentFile getRootDocumentFile(DocumentFile documentFile, Context context, boolean z) {
        String path;
        File rootRawFile;
        Intrinsics.checkNotNullParameter(documentFile, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        if (isTreeDocumentFile(documentFile)) {
            return DocumentFileCompat.getRootDocumentFile$default(context, getStorageId(documentFile, context), z, false, 8, null);
        }
        if (!isRawFile(documentFile) || (path = documentFile.getUri().getPath()) == null || (rootRawFile = FileExt.getRootRawFile(new File(path), context, z)) == null) {
            return null;
        }
        return DocumentFile.fromFile(rootRawFile);
    }

    public static final boolean canModify(DocumentFile documentFile, Context context) {
        Intrinsics.checkNotNullParameter(documentFile, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        return documentFile.canRead() && isWritable(documentFile, context);
    }

    public static final boolean isWritable(DocumentFile documentFile, Context context) {
        Intrinsics.checkNotNullParameter(documentFile, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        if (isRawFile(documentFile)) {
            String path = documentFile.getUri().getPath();
            Intrinsics.checkNotNull(path);
            return FileExt.isWritable(new File(path), context);
        }
        return documentFile.canWrite();
    }

    public static final boolean isRootUriPermissionGranted(DocumentFile documentFile, Context context) {
        Intrinsics.checkNotNullParameter(documentFile, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        return isExternalStorageDocument(documentFile) && DocumentFileCompat.isStorageUriPermissionGranted$default(context, getStorageId(documentFile, context), null, 4, null);
    }

    public static final String getFormattedSize(DocumentFile documentFile, Context context) {
        Intrinsics.checkNotNullParameter(documentFile, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        return Formatter.formatFileSize(context, documentFile.length());
    }

    /* JADX WARN: Removed duplicated region for block: B:118:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x00a5 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.String autoIncrementFileName(androidx.documentfile.provider.DocumentFile r17, android.content.Context r18, java.lang.String r19) {
        /*
            Method dump skipped, instructions count: 297
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anggrayudi.storage.file.DocumentFileExt.autoIncrementFileName(androidx.documentfile.provider.DocumentFile, android.content.Context, java.lang.String):java.lang.String");
    }

    public static /* synthetic */ DocumentFile createBinaryFile$default(DocumentFile documentFile, Context context, String str, CreateMode createMode, int i, Object obj) {
        if ((i & 4) != 0) {
            createMode = CreateMode.CREATE_NEW;
        }
        return createBinaryFile(documentFile, context, str, createMode);
    }

    public static final DocumentFile createBinaryFile(DocumentFile documentFile, Context context, String name, CreateMode mode) {
        Intrinsics.checkNotNullParameter(documentFile, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(mode, "mode");
        return makeFile(documentFile, context, name, MimeType.BINARY_FILE, mode);
    }

    public static /* synthetic */ DocumentFile makeFile$default(DocumentFile documentFile, Context context, String str, String str2, CreateMode createMode, int i, Object obj) {
        if ((i & 4) != 0) {
            str2 = MimeType.UNKNOWN;
        }
        if ((i & 8) != 0) {
            createMode = CreateMode.CREATE_NEW;
        }
        return makeFile(documentFile, context, str, str2, createMode);
    }

    public static final DocumentFile makeFile(DocumentFile documentFile, Context context, String name, String str, CreateMode mode) {
        DocumentFile documentFile2;
        String str2;
        String str3;
        Intrinsics.checkNotNullParameter(documentFile, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(mode, "mode");
        if (documentFile.isDirectory() && isWritable(documentFile, context)) {
            String trimFileSeparator = TextExt.trimFileSeparator(DocumentFileCompat.INSTANCE.removeForbiddenCharsFromFilename$storage_release(name));
            String substringBeforeLast = StringsKt.substringBeforeLast(trimFileSeparator, (char) JsonPointer.SEPARATOR, "");
            if (substringBeforeLast.length() == 0) {
                documentFile2 = documentFile;
            } else {
                DocumentFile makeFolder = makeFolder(documentFile, context, substringBeforeLast, mode);
                if (makeFolder == null) {
                    return null;
                }
                documentFile2 = makeFolder;
            }
            String substringAfterLast$default = StringsKt.substringAfterLast$default(trimFileSeparator, (char) JsonPointer.SEPARATOR, (String) null, 2, (Object) null);
            String substringAfterLast = StringsKt.substringAfterLast(trimFileSeparator, '.', "");
            if (!(substringAfterLast.length() > 0) || (str != null && !Intrinsics.areEqual(str, MimeType.UNKNOWN) && !Intrinsics.areEqual(str, MimeType.BINARY_FILE))) {
                substringAfterLast = MimeType.getExtensionFromMimeTypeOrFileName(str, trimFileSeparator);
            }
            String str4 = substringAfterLast;
            String removeSuffix = StringsKt.removeSuffix(substringAfterLast$default, (CharSequence) Intrinsics.stringPlus(".", str4));
            String trimEnd = StringsKt.trimEnd(removeSuffix + '.' + str4, '.');
            if (mode != CreateMode.CREATE_NEW) {
                str2 = removeSuffix;
                str3 = trimEnd;
                DocumentFile child$default = child$default(documentFile2, context, trimEnd, false, 4, null);
                if (child$default != null) {
                    if (mode == CreateMode.REPLACE) {
                        recreateFile(child$default, context);
                    } else {
                        child$default.isFile();
                    }
                }
            } else {
                str2 = removeSuffix;
                str3 = trimEnd;
            }
            if (isRawFile(documentFile)) {
                File rawFile = toRawFile(documentFile, context);
                File makeFile = rawFile == null ? null : FileExt.makeFile(rawFile, context, trimFileSeparator, str, mode);
                if (makeFile == null) {
                    return null;
                }
                return DocumentFile.fromFile(makeFile);
            }
            String mimeTypeFromExtension = MimeType.getMimeTypeFromExtension(str4);
            if (Intrinsics.areEqual(mimeTypeFromExtension, MimeType.UNKNOWN)) {
                mimeTypeFromExtension = MimeType.BINARY_FILE;
            }
            if (Build.VERSION.SDK_INT > 28) {
                DocumentFile createFile = documentFile2.createFile(mimeTypeFromExtension, str2);
                if (createFile == null) {
                    return null;
                }
                if (Intrinsics.areEqual(mimeTypeFromExtension, MimeType.BINARY_FILE)) {
                    String str5 = str3;
                    if (!Intrinsics.areEqual(createFile.getName(), str5)) {
                        createFile.renameTo(str5);
                    }
                }
                return createFile;
            }
            return documentFile2.createFile(mimeTypeFromExtension, str3);
        }
        return null;
    }

    public static /* synthetic */ DocumentFile makeFolder$default(DocumentFile documentFile, Context context, String str, CreateMode createMode, int i, Object obj) {
        if ((i & 4) != 0) {
            createMode = CreateMode.CREATE_NEW;
        }
        return makeFolder(documentFile, context, str, createMode);
    }

    public static final DocumentFile makeFolder(DocumentFile documentFile, Context context, String name, CreateMode mode) {
        DocumentFile quickFindTreeFile;
        Intrinsics.checkNotNullParameter(documentFile, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(mode, "mode");
        if (documentFile.isDirectory() && isWritable(documentFile, context)) {
            if (isRawFile(documentFile)) {
                File rawFile = toRawFile(documentFile, context);
                File makeFolder = rawFile == null ? null : FileExt.makeFolder(rawFile, context, name, mode);
                if (makeFolder == null) {
                    return null;
                }
                return DocumentFile.fromFile(makeFolder);
            }
            List<String> mutableList = CollectionsKt.toMutableList((Collection) DocumentFileCompat.INSTANCE.getDirectorySequence$storage_release(DocumentFileCompat.INSTANCE.removeForbiddenCharsFromFilename$storage_release(name)));
            String str = (String) CollectionsKt.removeFirstOrNull(mutableList);
            if (str == null) {
                return null;
            }
            if (isDownloadsDocument(documentFile) && isTreeDocumentFile(documentFile) && (documentFile = toWritableDownloadsDocumentFile(documentFile, context)) == null) {
                return null;
            }
            DocumentFile child$default = child$default(documentFile, context, str, false, 4, null);
            if (child$default == null || mode == CreateMode.CREATE_NEW) {
                child$default = documentFile.createDirectory(str);
                if (child$default == null) {
                    return null;
                }
            } else if (mode == CreateMode.REPLACE) {
                forceDelete(child$default, context, true);
                if (!child$default.isDirectory() && (child$default = documentFile.createDirectory(str)) == null) {
                    return null;
                }
            } else if (!child$default.isDirectory() || !child$default.canRead()) {
                return null;
            }
            ContentResolver resolver = context.getContentResolver();
            for (String str2 : mutableList) {
                try {
                    Intrinsics.checkNotNullExpressionValue(resolver, "resolver");
                    quickFindTreeFile = quickFindTreeFile(child$default, context, resolver, str2);
                } catch (Exception unused) {
                }
                if (quickFindTreeFile == null) {
                    DocumentFile createDirectory = child$default.createDirectory(str2);
                    if (createDirectory == null) {
                        return null;
                    }
                    child$default = createDirectory;
                } else {
                    if (quickFindTreeFile.isDirectory() && quickFindTreeFile.canRead()) {
                        child$default = quickFindTreeFile;
                    }
                    return null;
                }
            }
            return child$default;
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:80:0x00a2, code lost:
        if (new kotlin.text.Regex("/tree/downloads/document/ms[f,d]:\\d+").matches(r0) == false) goto L37;
     */
    /* JADX WARN: Removed duplicated region for block: B:98:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final androidx.documentfile.provider.DocumentFile toWritableDownloadsDocumentFile(androidx.documentfile.provider.DocumentFile r12, android.content.Context r13) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r0)
            java.lang.String r0 = "context"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, r0)
            boolean r0 = isDownloadsDocument(r12)
            r7 = 0
            if (r0 == 0) goto Lcd
            android.net.Uri r0 = r12.getUri()
            java.lang.String r0 = r0.getPath()
            java.lang.String r8 = ""
            if (r0 == 0) goto L1f
            r9 = r0
            goto L20
        L1f:
            r9 = r8
        L20:
            android.net.Uri r0 = r12.getUri()
            java.lang.String r0 = r0.toString()
            java.lang.String r2 = "content://com.android.providers.downloads.documents/tree/downloads/document/downloads"
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r2)
            if (r0 == 0) goto L38
            boolean r0 = isWritable(r12, r13)
            if (r0 == 0) goto Ld1
            goto Lcb
        L38:
            int r0 = android.os.Build.VERSION.SDK_INT
            java.lang.String r2 = "/tree/downloads/document/raw:"
            r3 = 29
            r4 = 0
            r10 = 2
            if (r0 < r3) goto L76
            boolean r0 = kotlin.text.StringsKt.startsWith$default(r9, r2, r4, r10, r7)
            java.lang.String r11 = "/document/raw:"
            if (r0 != 0) goto L50
            boolean r0 = kotlin.text.StringsKt.startsWith$default(r9, r11, r4, r10, r7)
            if (r0 == 0) goto L76
        L50:
            com.anggrayudi.storage.file.PublicDirectory r1 = com.anggrayudi.storage.file.PublicDirectory.DOWNLOADS
            r2 = 0
            r3 = 0
            r4 = 0
            r5 = 12
            r6 = 0
            r0 = r13
            androidx.documentfile.provider.DocumentFile r0 = com.anggrayudi.storage.file.DocumentFileCompat.fromPublicFolder$default(r0, r1, r2, r3, r4, r5, r6)
            if (r0 != 0) goto L60
            return r7
        L60:
            java.lang.String r1 = kotlin.text.StringsKt.substringAfterLast$default(r9, r11, r7, r10, r7)
            java.lang.String r2 = android.os.Environment.DIRECTORY_DOWNLOADS
            java.lang.String r3 = "/"
            java.lang.String r2 = kotlin.jvm.internal.Intrinsics.stringPlus(r3, r2)
            java.lang.String r1 = kotlin.text.StringsKt.substringAfter(r1, r2, r8)
            r2 = 1
            androidx.documentfile.provider.DocumentFile r0 = child(r0, r13, r1, r2)
            goto Ld0
        L76:
            int r0 = android.os.Build.VERSION.SDK_INT
            if (r0 < r3) goto La4
            r0 = r9
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            kotlin.text.Regex r5 = new kotlin.text.Regex
            java.lang.String r6 = "/document/ms[f,d]:\\d+"
            r5.<init>(r6)
            boolean r5 = r5.matches(r0)
            if (r5 != 0) goto Lc5
            kotlin.text.Regex r5 = new kotlin.text.Regex
            java.lang.String r6 = "/tree/ms[f,d]:\\d+(.*?)"
            r5.<init>(r6)
            boolean r5 = r5.matches(r0)
            if (r5 != 0) goto Lc5
            kotlin.text.Regex r5 = new kotlin.text.Regex
            java.lang.String r6 = "/tree/downloads/document/ms[f,d]:\\d+"
            r5.<init>(r6)
            boolean r0 = r5.matches(r0)
            if (r0 != 0) goto Lc5
        La4:
            int r0 = android.os.Build.VERSION.SDK_INT
            if (r0 >= r3) goto Ld1
            java.lang.String r0 = "/tree/raw:"
            boolean r0 = kotlin.text.StringsKt.startsWith$default(r9, r0, r4, r10, r7)
            if (r0 != 0) goto Lc5
            boolean r0 = kotlin.text.StringsKt.startsWith$default(r9, r2, r4, r10, r7)
            if (r0 != 0) goto Lc5
            java.lang.CharSequence r9 = (java.lang.CharSequence) r9
            kotlin.text.Regex r0 = new kotlin.text.Regex
            java.lang.String r2 = "/document/\\d+"
            r0.<init>(r2)
            boolean r0 = r0.matches(r9)
            if (r0 == 0) goto Ld1
        Lc5:
            boolean r0 = isWritable(r12, r13)
            if (r0 == 0) goto Ld1
        Lcb:
            r7 = r12
            goto Ld1
        Lcd:
            r0 = r7
            androidx.documentfile.provider.DocumentFile r0 = (androidx.documentfile.provider.DocumentFile) r0
        Ld0:
            r7 = r0
        Ld1:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anggrayudi.storage.file.DocumentFileExt.toWritableDownloadsDocumentFile(androidx.documentfile.provider.DocumentFile, android.content.Context):androidx.documentfile.provider.DocumentFile");
    }

    public static /* synthetic */ List findFiles$default(DocumentFile documentFile, String[] strArr, DocumentFileType documentFileType, int i, Object obj) {
        if ((i & 2) != 0) {
            documentFileType = DocumentFileType.ANY;
        }
        return findFiles(documentFile, strArr, documentFileType);
    }

    public static final List<DocumentFile> findFiles(DocumentFile documentFile, String[] names, DocumentFileType documentType) {
        DocumentFile[] documentFileArr;
        Intrinsics.checkNotNullParameter(documentFile, "<this>");
        Intrinsics.checkNotNullParameter(names, "names");
        Intrinsics.checkNotNullParameter(documentType, "documentType");
        DocumentFile[] listFiles = documentFile.listFiles();
        Intrinsics.checkNotNullExpressionValue(listFiles, "listFiles()");
        ArrayList arrayList = new ArrayList();
        for (DocumentFile documentFile2 : listFiles) {
            if (ArraysKt.contains(names, documentFile2.getName())) {
                arrayList.add(documentFile2);
            }
        }
        ArrayList arrayList2 = arrayList;
        int i = WhenMappings.$EnumSwitchMapping$0[documentType.ordinal()];
        if (i == 1) {
            ArrayList arrayList3 = new ArrayList();
            for (Object obj : arrayList2) {
                if (((DocumentFile) obj).isFile()) {
                    arrayList3.add(obj);
                }
            }
            return arrayList3;
        } else if (i != 2) {
            return arrayList2;
        } else {
            ArrayList arrayList4 = new ArrayList();
            for (Object obj2 : arrayList2) {
                if (((DocumentFile) obj2).isDirectory()) {
                    arrayList4.add(obj2);
                }
            }
            return arrayList4;
        }
    }

    public static final DocumentFile findFolder(DocumentFile documentFile, String name) {
        DocumentFile documentFile2;
        Intrinsics.checkNotNullParameter(documentFile, "<this>");
        Intrinsics.checkNotNullParameter(name, "name");
        DocumentFile[] listFiles = documentFile.listFiles();
        Intrinsics.checkNotNullExpressionValue(listFiles, "listFiles()");
        DocumentFile[] documentFileArr = listFiles;
        int length = documentFileArr.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                documentFile2 = null;
                break;
            }
            documentFile2 = documentFileArr[i];
            DocumentFile documentFile3 = documentFile2;
            if (Intrinsics.areEqual(documentFile3.getName(), name) && documentFile3.isDirectory()) {
                break;
            }
            i++;
        }
        return documentFile2;
    }

    public static final DocumentFile findFileLiterally(DocumentFile documentFile, String name) {
        DocumentFile documentFile2;
        Intrinsics.checkNotNullParameter(documentFile, "<this>");
        Intrinsics.checkNotNullParameter(name, "name");
        DocumentFile[] listFiles = documentFile.listFiles();
        Intrinsics.checkNotNullExpressionValue(listFiles, "listFiles()");
        DocumentFile[] documentFileArr = listFiles;
        int length = documentFileArr.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                documentFile2 = null;
                break;
            }
            documentFile2 = documentFileArr[i];
            DocumentFile documentFile3 = documentFile2;
            if (Intrinsics.areEqual(documentFile3.getName(), name) && documentFile3.isFile()) {
                break;
            }
            i++;
        }
        return documentFile2;
    }

    public static /* synthetic */ List search$default(DocumentFile documentFile, boolean z, DocumentFileType documentFileType, String[] strArr, String str, Regex regex, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        if ((i & 2) != 0) {
            documentFileType = DocumentFileType.ANY;
        }
        DocumentFileType documentFileType2 = documentFileType;
        String[] strArr2 = (i & 4) != 0 ? null : strArr;
        if ((i & 8) != 0) {
            str = "";
        }
        return search(documentFile, z, documentFileType2, strArr2, str, (i & 16) == 0 ? regex : null);
    }

    /* JADX WARN: Removed duplicated region for block: B:118:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x00ee  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:193:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.util.List<androidx.documentfile.provider.DocumentFile> search(androidx.documentfile.provider.DocumentFile r9, boolean r10, com.anggrayudi.storage.file.DocumentFileType r11, java.lang.String[] r12, java.lang.String r13, kotlin.text.Regex r14) {
        /*
            Method dump skipped, instructions count: 296
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anggrayudi.storage.file.DocumentFileExt.search(androidx.documentfile.provider.DocumentFile, boolean, com.anggrayudi.storage.file.DocumentFileType, java.lang.String[], java.lang.String, kotlin.text.Regex):java.util.List");
    }

    public static final boolean matchesMimeTypes(DocumentFile documentFile, String[] strArr) {
        if (strArr.length == 0) {
            return true;
        }
        String matches = MimeTypeFilter.matches(getMimeTypeByFileName(documentFile), strArr);
        return !(matches == null || matches.length() == 0);
    }

    private static final List<DocumentFile> walkFileTreeForSearch(DocumentFile documentFile, DocumentFileType documentFileType, String[] strArr, String str, Regex regex, Thread thread) {
        String str2;
        ArrayList arrayList = new ArrayList();
        DocumentFile[] listFiles = documentFile.listFiles();
        Intrinsics.checkNotNullExpressionValue(listFiles, "listFiles()");
        int length = listFiles.length;
        int i = 0;
        while (i < length) {
            DocumentFile file = listFiles[i];
            int i2 = i + 1;
            if (thread.isInterrupted()) {
                break;
            }
            if (documentFile.canRead()) {
                if (file.isFile()) {
                    if (documentFileType != DocumentFileType.FOLDER) {
                        String name = file.getName();
                        str2 = name != null ? name : "";
                        if (((str.length() == 0) || Intrinsics.areEqual(str2, str)) && (regex == null || regex.matches(str2))) {
                            Intrinsics.checkNotNullExpressionValue(file, "file");
                            if (matchesMimeTypes(file, strArr)) {
                                arrayList.add(file);
                            }
                        }
                    }
                } else {
                    if (documentFileType != DocumentFileType.FILE) {
                        String name2 = file.getName();
                        str2 = name2 != null ? name2 : "";
                        if (((str.length() == 0) || Intrinsics.areEqual(str2, str)) && (regex == null || regex.matches(str2))) {
                            Intrinsics.checkNotNullExpressionValue(file, "file");
                            arrayList.add(file);
                        }
                    }
                    Intrinsics.checkNotNullExpressionValue(file, "file");
                    arrayList.addAll(walkFileTreeForSearch(file, documentFileType, strArr, str, regex, thread));
                }
                i = i2;
            }
            i = i2;
        }
        return arrayList;
    }

    public static /* synthetic */ boolean deleteRecursively$default(DocumentFile documentFile, Context context, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return deleteRecursively(documentFile, context, z);
    }

    public static final boolean deleteRecursively(DocumentFile documentFile, Context context, boolean z) {
        List<DocumentFile> walkFileTreeForDeletion;
        Intrinsics.checkNotNullParameter(documentFile, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        if (documentFile.isDirectory() && documentFile.canRead()) {
            if (isDownloadsDocument(documentFile)) {
                DocumentFile writableDownloadsDocumentFile = toWritableDownloadsDocumentFile(documentFile, context);
                if (writableDownloadsDocumentFile == null) {
                    return false;
                }
                walkFileTreeForDeletion = walkFileTreeForDeletion(writableDownloadsDocumentFile);
            } else {
                walkFileTreeForDeletion = walkFileTreeForDeletion(documentFile);
            }
            int size = walkFileTreeForDeletion.size();
            int size2 = walkFileTreeForDeletion.size() - 1;
            if (size2 >= 0) {
                while (true) {
                    int i = size2 - 1;
                    if (walkFileTreeForDeletion.get(size2).delete()) {
                        size--;
                    }
                    if (i < 0) {
                        break;
                    }
                    size2 = i;
                }
            }
            if (size == 0 && (z || documentFile.delete() || !documentFile.exists())) {
                return true;
            }
        }
        return false;
    }

    public static /* synthetic */ boolean forceDelete$default(DocumentFile documentFile, Context context, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return forceDelete(documentFile, context, z);
    }

    public static final boolean forceDelete(DocumentFile documentFile, Context context, boolean z) {
        Intrinsics.checkNotNullParameter(documentFile, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        if (documentFile.isDirectory()) {
            return deleteRecursively(documentFile, context, z);
        }
        return documentFile.delete() || !documentFile.exists();
    }

    private static final List<DocumentFile> walkFileTreeForDeletion(DocumentFile documentFile) {
        DocumentFile[] documentFileArr;
        ArrayList arrayList = new ArrayList();
        DocumentFile[] listFiles = documentFile.listFiles();
        Intrinsics.checkNotNullExpressionValue(listFiles, "listFiles()");
        for (DocumentFile it : listFiles) {
            if (!it.delete()) {
                Intrinsics.checkNotNullExpressionValue(it, "it");
                arrayList.add(it);
            }
            if (it.isDirectory()) {
                Intrinsics.checkNotNullExpressionValue(it, "it");
                arrayList.addAll(walkFileTreeForDeletion(it));
            }
        }
        return arrayList;
    }

    public static final boolean deleteEmptyFolders(DocumentFile documentFile, Context context) {
        Intrinsics.checkNotNullParameter(documentFile, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        if (isRawFile(documentFile)) {
            String path = documentFile.getUri().getPath();
            Intrinsics.checkNotNull(path);
            FileExt.deleteEmptyFolders(new File(path), context);
            return true;
        } else if (documentFile.isDirectory() && isWritable(documentFile, context)) {
            for (DocumentFile documentFile2 : CollectionsKt.reversed(walkFileTreeAndDeleteEmptyFolders(documentFile))) {
                documentFile2.delete();
            }
            return true;
        } else {
            return false;
        }
    }

    private static final List<DocumentFile> walkFileTreeAndDeleteEmptyFolders(DocumentFile documentFile) {
        DocumentFile[] documentFileArr;
        ArrayList arrayList = new ArrayList();
        DocumentFile[] listFiles = documentFile.listFiles();
        Intrinsics.checkNotNullExpressionValue(listFiles, "listFiles()");
        for (DocumentFile it : listFiles) {
            if (it.isDirectory() && !it.delete()) {
                Intrinsics.checkNotNullExpressionValue(it, "it");
                arrayList.add(it);
                arrayList.addAll(walkFileTreeAndDeleteEmptyFolders(it));
            }
        }
        return arrayList;
    }

    public static final OutputStream openOutputStream(DocumentFile documentFile, Context context, boolean z) {
        Intrinsics.checkNotNullParameter(documentFile, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        Uri uri = documentFile.getUri();
        Intrinsics.checkNotNullExpressionValue(uri, "uri");
        return UriExt.openOutputStream(uri, context, z);
    }

    public static /* synthetic */ OutputStream openOutputStream$default(DocumentFile documentFile, Context context, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        return openOutputStream(documentFile, context, z);
    }

    public static final InputStream openInputStream(DocumentFile documentFile, Context context) {
        Intrinsics.checkNotNullParameter(documentFile, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        Uri uri = documentFile.getUri();
        Intrinsics.checkNotNullExpressionValue(uri, "uri");
        return UriExt.openInputStream(uri, context);
    }

    public static final Intent openFileIntent(DocumentFile documentFile, Context context, String authority) {
        Uri uri;
        Intrinsics.checkNotNullParameter(documentFile, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(authority, "authority");
        Intent intent = new Intent("android.intent.action.VIEW");
        if (isRawFile(documentFile)) {
            String path = documentFile.getUri().getPath();
            Intrinsics.checkNotNull(path);
            uri = FileProvider.getUriForFile(context, authority, new File(path));
        } else {
            uri = documentFile.getUri();
        }
        Intent addFlags = intent.setData(uri).addFlags(1).addFlags(268435456);
        Intrinsics.checkNotNullExpressionValue(addFlags, "Intent(Intent.ACTION_VIEW)\n    .setData(if (isRawFile) FileProvider.getUriForFile(context, authority, File(uri.path!!)) else uri)\n    .addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)\n    .addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)");
        return addFlags;
    }

    public static final boolean hasParent(DocumentFile documentFile, Context context, DocumentFile parent) {
        Intrinsics.checkNotNullParameter(documentFile, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(parent, "parent");
        return TextExt.hasParent(getAbsolutePath(documentFile, context), getAbsolutePath(parent, context));
    }

    private static final List<DocumentFile> walkFileTree(DocumentFile documentFile, Context context) {
        DocumentFile[] documentFileArr;
        ArrayList arrayList = new ArrayList();
        DocumentFile[] listFiles = documentFile.listFiles();
        Intrinsics.checkNotNullExpressionValue(listFiles, "listFiles()");
        for (DocumentFile it : listFiles) {
            if (it.isDirectory()) {
                Intrinsics.checkNotNullExpressionValue(it, "it");
                if (isEmpty(it, context)) {
                    arrayList.add(it);
                } else {
                    arrayList.addAll(walkFileTree(it, context));
                }
            } else {
                Intrinsics.checkNotNullExpressionValue(it, "it");
                arrayList.add(it);
            }
        }
        return arrayList;
    }

    private static final List<DocumentFile> walkFileTreeAndSkipEmptyFiles(DocumentFile documentFile) {
        DocumentFile[] documentFileArr;
        ArrayList arrayList = new ArrayList();
        DocumentFile[] listFiles = documentFile.listFiles();
        Intrinsics.checkNotNullExpressionValue(listFiles, "listFiles()");
        for (DocumentFile it : listFiles) {
            if (it.isDirectory()) {
                Intrinsics.checkNotNullExpressionValue(it, "it");
                arrayList.addAll(walkFileTreeAndSkipEmptyFiles(it));
            } else if (it.length() > 0) {
                Intrinsics.checkNotNullExpressionValue(it, "it");
                arrayList.add(it);
            }
        }
        return arrayList;
    }

    public static /* synthetic */ void moveTo$default(List list, Context context, DocumentFile documentFile, boolean z, MultipleFileCallback multipleFileCallback, int i, Object obj) {
        if ((i & 4) != 0) {
            z = true;
        }
        moveTo(list, context, documentFile, z, multipleFileCallback);
    }

    public static final void moveTo(List<? extends DocumentFile> list, Context context, DocumentFile targetParentFolder, boolean z, MultipleFileCallback callback) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(targetParentFolder, "targetParentFolder");
        Intrinsics.checkNotNullParameter(callback, "callback");
        copyTo(list, context, targetParentFolder, z, true, callback);
    }

    public static /* synthetic */ void copyTo$default(List list, Context context, DocumentFile documentFile, boolean z, MultipleFileCallback multipleFileCallback, int i, Object obj) {
        if ((i & 4) != 0) {
            z = true;
        }
        copyTo(list, context, documentFile, z, multipleFileCallback);
    }

    public static final void copyTo(List<? extends DocumentFile> list, Context context, DocumentFile targetParentFolder, boolean z, MultipleFileCallback callback) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(targetParentFolder, "targetParentFolder");
        Intrinsics.checkNotNullParameter(callback, "callback");
        copyTo(list, context, targetParentFolder, z, false, callback);
    }

    /* JADX WARN: Code restructure failed: missing block: B:483:0x04c6, code lost:
        r1 = r28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:484:0x04c9, code lost:
        r1.element = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:499:0x0527, code lost:
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:502:0x052b, code lost:
        r28 = r15;
        r14.put(r3, r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:503:0x0530, code lost:
        r0 = kotlin.Unit.INSTANCE;
        r13 = r44;
        r0 = r21;
        r15 = r28;
        r28 = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:504:0x053c, code lost:
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:508:0x0541, code lost:
        r28 = r15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:510:0x054d, code lost:
        if (r7.invoke((com.anggrayudi.storage.file.DocumentFileUtils$copyTo$handleError$1) r0).booleanValue() == false) goto L182;
     */
    /* JADX WARN: Code restructure failed: missing block: B:511:0x054f, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:512:0x0550, code lost:
        r1.element = false;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:511:0x054f A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:512:0x0550  */
    /* JADX WARN: Removed duplicated region for block: B:516:0x058e A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:517:0x058f  */
    /* JADX WARN: Type inference failed for: r0v88, types: [T, androidx.documentfile.provider.DocumentFile] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void copyTo(java.util.List<? extends androidx.documentfile.provider.DocumentFile> r39, android.content.Context r40, androidx.documentfile.provider.DocumentFile r41, boolean r42, boolean r43, com.anggrayudi.storage.callback.MultipleFileCallback r44) {
        /*
            Method dump skipped, instructions count: 1743
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anggrayudi.storage.file.DocumentFileExt.copyTo(java.util.List, android.content.Context, androidx.documentfile.provider.DocumentFile, boolean, boolean, com.anggrayudi.storage.callback.MultipleFileCallback):void");
    }

    private static final Tuples<DocumentFile, List<DocumentFile>> doesMeetCopyRequirements(List<? extends DocumentFile> list, Context context, DocumentFile documentFile, MultipleFileCallback multipleFileCallback) {
        Object runBlocking$default;
        Tuples tuples;
        BuildersKt__Builders_commonKt.launch$default(multipleFileCallback.getUiScope(), Dispatchers.getMain(), null, new DocumentFileUtils$doesMeetCopyRequirements$$inlined$postToUi$1(null, multipleFileCallback), 2, null);
        if (!documentFile.isDirectory()) {
            BuildersKt__Builders_commonKt.launch$default(multipleFileCallback.getUiScope(), Dispatchers.getMain(), null, new DocumentFileUtils$doesMeetCopyRequirements$$inlined$postToUi$2(null, multipleFileCallback), 2, null);
            return null;
        } else if (!isWritable(documentFile, context)) {
            BuildersKt__Builders_commonKt.launch$default(multipleFileCallback.getUiScope(), Dispatchers.getMain(), null, new DocumentFileUtils$doesMeetCopyRequirements$$inlined$postToUi$3(null, multipleFileCallback), 2, null);
            return null;
        } else {
            String absolutePath = getAbsolutePath(documentFile, context);
            HashSet hashSet = new HashSet();
            ArrayList arrayList = new ArrayList();
            for (Object obj : list) {
                if (hashSet.add(((DocumentFile) obj).getName())) {
                    arrayList.add(obj);
                }
            }
            ArrayList<DocumentFile> arrayList2 = arrayList;
            ArrayList arrayList3 = new ArrayList();
            for (DocumentFile documentFile2 : arrayList2) {
                if (!documentFile2.exists()) {
                    tuples = new Tuples(documentFile2, FolderCallback.ErrorCode.SOURCE_FILE_NOT_FOUND);
                } else if (documentFile2.canRead()) {
                    DocumentFile parentFile = documentFile2.getParentFile();
                    tuples = Intrinsics.areEqual(absolutePath, parentFile == null ? null : getAbsolutePath(parentFile, context)) ? new Tuples(documentFile2, FolderCallback.ErrorCode.TARGET_FOLDER_CANNOT_HAVE_SAME_PATH_WITH_SOURCE_FOLDER) : null;
                } else {
                    tuples = new Tuples(documentFile2, FolderCallback.ErrorCode.STORAGE_PERMISSION_DENIED);
                }
                if (tuples != null) {
                    arrayList3.add(tuples);
                }
            }
            Map map = MapsKt.toMap(arrayList3);
            if (!map.isEmpty()) {
                runBlocking$default = BuildersKt__BuildersKt.runBlocking$default(null, new C1101x4e709d7f(multipleFileCallback.getUiScope(), null, multipleFileCallback, map), 1, null);
                if (((Boolean) runBlocking$default).booleanValue()) {
                    BuildersKt__Builders_commonKt.launch$default(multipleFileCallback.getUiScope(), Dispatchers.getMain(), null, new DocumentFileUtils$doesMeetCopyRequirements$$inlined$postToUi$4(null, multipleFileCallback), 2, null);
                    return null;
                } else if (map.size() == list.size()) {
                    BuildersKt__Builders_commonKt.launch$default(multipleFileCallback.getUiScope(), Dispatchers.getMain(), null, new DocumentFileUtils$doesMeetCopyRequirements$$inlined$postToUi$5(null, multipleFileCallback), 2, null);
                    return null;
                }
            }
            DocumentFile writableDownloadsDocumentFile = isDownloadsDocument(documentFile) ? toWritableDownloadsDocumentFile(documentFile, context) : documentFile;
            if (writableDownloadsDocumentFile == null) {
                BuildersKt__Builders_commonKt.launch$default(multipleFileCallback.getUiScope(), Dispatchers.getMain(), null, new DocumentFileUtils$doesMeetCopyRequirements$$inlined$postToUi$6(null, multipleFileCallback), 2, null);
                return null;
            }
            List mutableList = CollectionsKt.toMutableList((Collection) arrayList2);
            ArrayList arrayList4 = new ArrayList(map.size());
            for (Map.Entry entry : map.entrySet()) {
                arrayList4.add((DocumentFile) entry.getKey());
            }
            mutableList.removeAll(arrayList4);
            Unit unit = Unit.INSTANCE;
            return new Tuples<>(writableDownloadsDocumentFile, mutableList);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:108:0x008e A[Catch: all -> 0x00a8, TryCatch #0 {all -> 0x00a8, blocks: (B:94:0x005b, B:96:0x0061, B:98:0x0067, B:100:0x006d, B:108:0x008e, B:110:0x0094, B:113:0x009c, B:115:0x00a1, B:116:0x00a5, B:103:0x0075, B:106:0x007c), top: B:121:0x005b }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static final java.lang.Object tryMoveFolderByRenamingPath(androidx.documentfile.provider.DocumentFile r4, android.content.Context r5, androidx.documentfile.provider.DocumentFile r6, java.lang.String r7, boolean r8, java.lang.String r9, com.anggrayudi.storage.callback.FolderCallback.ConflictResolution r10) {
        /*
            boolean r0 = inSameMountPointWith(r4, r5, r6)
            r1 = 0
            if (r0 == 0) goto Lab
            boolean r0 = inInternalStorage(r4, r5)
            if (r0 == 0) goto L2d
            java.io.File r0 = toRawFile(r4, r5)
            if (r0 != 0) goto L14
            goto L2d
        L14:
            java.lang.String r2 = getAbsolutePath(r6, r5)
            com.anggrayudi.storage.callback.FileCallback$ConflictResolution r3 = r10.toFileConflictResolution()
            java.io.File r0 = com.anggrayudi.storage.file.FileExt.moveTo(r0, r5, r2, r7, r3)
            if (r0 != 0) goto L23
            goto L2d
        L23:
            if (r8 == 0) goto L28
            com.anggrayudi.storage.file.FileExt.deleteEmptyFolders(r0, r5)
        L28:
            androidx.documentfile.provider.DocumentFile r4 = androidx.documentfile.provider.DocumentFile.fromFile(r0)
            return r4
        L2d:
            boolean r0 = isExternalStorageManager(r4, r5)
            if (r0 == 0) goto L5b
            java.io.File r0 = toRawFile(r4, r5)
            if (r0 != 0) goto L3c
            com.anggrayudi.storage.callback.FolderCallback$ErrorCode r4 = com.anggrayudi.storage.callback.FolderCallback.ErrorCode.STORAGE_PERMISSION_DENIED
            return r4
        L3c:
            java.io.File r2 = toRawFile(r6, r5)
            if (r2 != 0) goto L43
            goto L5b
        L43:
            com.anggrayudi.storage.callback.FileCallback$ConflictResolution r10 = r10.toFileConflictResolution()
            java.io.File r10 = com.anggrayudi.storage.file.FileExt.moveTo(r0, r5, r2, r7, r10)
            if (r10 != 0) goto L51
            r10 = r1
            java.lang.Void r10 = (java.lang.Void) r10
            goto L5b
        L51:
            if (r8 == 0) goto L56
            com.anggrayudi.storage.file.FileExt.deleteEmptyFolders(r10, r5)
        L56:
            androidx.documentfile.provider.DocumentFile r4 = androidx.documentfile.provider.DocumentFile.fromFile(r10)
            return r4
        L5b:
            int r10 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.Throwable -> La8
            r0 = 24
            if (r10 < r0) goto Lab
            boolean r10 = isRawFile(r4)     // Catch: java.lang.Throwable -> La8
            if (r10 != 0) goto Lab
            boolean r10 = isTreeDocumentFile(r6)     // Catch: java.lang.Throwable -> La8
            if (r10 == 0) goto Lab
            androidx.documentfile.provider.DocumentFile r10 = r4.getParentFile()     // Catch: java.lang.Throwable -> La8
            if (r10 != 0) goto L75
        L73:
            r4 = r1
            goto L8c
        L75:
            android.net.Uri r10 = r10.getUri()     // Catch: java.lang.Throwable -> La8
            if (r10 != 0) goto L7c
            goto L73
        L7c:
            android.content.ContentResolver r0 = r5.getContentResolver()     // Catch: java.lang.Throwable -> La8
            android.net.Uri r4 = r4.getUri()     // Catch: java.lang.Throwable -> La8
            android.net.Uri r6 = r6.getUri()     // Catch: java.lang.Throwable -> La8
            android.net.Uri r4 = android.provider.DocumentsContract.moveDocument(r0, r4, r10, r6)     // Catch: java.lang.Throwable -> La8
        L8c:
            if (r4 == 0) goto Lab
            androidx.documentfile.provider.DocumentFile r4 = com.anggrayudi.storage.extension.ContextExt.fromTreeUri(r5, r4)     // Catch: java.lang.Throwable -> La8
            if (r4 == 0) goto La5
            boolean r6 = r4.isDirectory()     // Catch: java.lang.Throwable -> La8
            if (r6 == 0) goto La5
            if (r9 == 0) goto L9f
            r4.renameTo(r7)     // Catch: java.lang.Throwable -> La8
        L9f:
            if (r8 == 0) goto La7
            deleteEmptyFolders(r4, r5)     // Catch: java.lang.Throwable -> La8
            goto La7
        La5:
            com.anggrayudi.storage.callback.FolderCallback$ErrorCode r4 = com.anggrayudi.storage.callback.FolderCallback.ErrorCode.INVALID_TARGET_FOLDER     // Catch: java.lang.Throwable -> La8
        La7:
            return r4
        La8:
            com.anggrayudi.storage.callback.FolderCallback$ErrorCode r4 = com.anggrayudi.storage.callback.FolderCallback.ErrorCode.STORAGE_PERMISSION_DENIED
            return r4
        Lab:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anggrayudi.storage.file.DocumentFileExt.tryMoveFolderByRenamingPath(androidx.documentfile.provider.DocumentFile, android.content.Context, androidx.documentfile.provider.DocumentFile, java.lang.String, boolean, java.lang.String, com.anggrayudi.storage.callback.FolderCallback$ConflictResolution):java.lang.Object");
    }

    public static /* synthetic */ void moveFolderTo$default(DocumentFile documentFile, Context context, DocumentFile documentFile2, boolean z, String str, FolderCallback folderCallback, int i, Object obj) {
        boolean z2 = (i & 4) != 0 ? true : z;
        if ((i & 8) != 0) {
            str = null;
        }
        moveFolderTo(documentFile, context, documentFile2, z2, str, folderCallback);
    }

    public static final void moveFolderTo(DocumentFile documentFile, Context context, DocumentFile targetParentFolder, boolean z, String str, FolderCallback callback) {
        Intrinsics.checkNotNullParameter(documentFile, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(targetParentFolder, "targetParentFolder");
        Intrinsics.checkNotNullParameter(callback, "callback");
        copyFolderTo(documentFile, context, targetParentFolder, z, str, true, callback);
    }

    public static /* synthetic */ void copyFolderTo$default(DocumentFile documentFile, Context context, DocumentFile documentFile2, boolean z, String str, FolderCallback folderCallback, int i, Object obj) {
        boolean z2 = (i & 4) != 0 ? true : z;
        if ((i & 8) != 0) {
            str = null;
        }
        copyFolderTo(documentFile, context, documentFile2, z2, str, folderCallback);
    }

    public static final void copyFolderTo(DocumentFile documentFile, Context context, DocumentFile targetParentFolder, boolean z, String str, FolderCallback callback) {
        Intrinsics.checkNotNullParameter(documentFile, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(targetParentFolder, "targetParentFolder");
        Intrinsics.checkNotNullParameter(callback, "callback");
        copyFolderTo(documentFile, context, targetParentFolder, z, str, false, callback);
    }

    static /* synthetic */ void copyFolderTo$default(DocumentFile documentFile, Context context, DocumentFile documentFile2, boolean z, String str, boolean z2, FolderCallback folderCallback, int i, Object obj) {
        boolean z3 = (i & 4) != 0 ? true : z;
        if ((i & 8) != 0) {
            str = null;
        }
        copyFolderTo(documentFile, context, documentFile2, z3, str, z2, folderCallback);
    }

    /* JADX WARN: Code restructure failed: missing block: B:323:0x035b, code lost:
        r5.element = false;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:350:0x03d5 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:351:0x03d6  */
    /* JADX WARN: Removed duplicated region for block: B:356:0x0417 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:357:0x0418  */
    /* JADX WARN: Type inference failed for: r0v60, types: [T, androidx.documentfile.provider.DocumentFile] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static final void copyFolderTo(androidx.documentfile.provider.DocumentFile r35, android.content.Context r36, androidx.documentfile.provider.DocumentFile r37, boolean r38, java.lang.String r39, boolean r40, com.anggrayudi.storage.callback.FolderCallback r41) {
        /*
            Method dump skipped, instructions count: 1389
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anggrayudi.storage.file.DocumentFileExt.copyFolderTo(androidx.documentfile.provider.DocumentFile, android.content.Context, androidx.documentfile.provider.DocumentFile, boolean, java.lang.String, boolean, com.anggrayudi.storage.callback.FolderCallback):void");
    }

    public static final FolderCallback.ErrorCode toFolderCallbackErrorCode(Exception exc) {
        if (exc instanceof SecurityException) {
            return FolderCallback.ErrorCode.STORAGE_PERMISSION_DENIED;
        }
        return exc instanceof InterruptedIOException ? true : exc instanceof InterruptedException ? FolderCallback.ErrorCode.CANCELED : FolderCallback.ErrorCode.UNKNOWN_IO_ERROR;
    }

    public static final MultipleFileCallback.ErrorCode toMultipleFileCallbackErrorCode(Exception exc) {
        if (exc instanceof SecurityException) {
            return MultipleFileCallback.ErrorCode.STORAGE_PERMISSION_DENIED;
        }
        return exc instanceof InterruptedIOException ? true : exc instanceof InterruptedException ? MultipleFileCallback.ErrorCode.CANCELED : MultipleFileCallback.ErrorCode.UNKNOWN_IO_ERROR;
    }

    private static final DocumentFile doesMeetCopyRequirements(DocumentFile documentFile, Context context, DocumentFile documentFile2, String str, FolderCallback folderCallback) {
        BuildersKt__Builders_commonKt.launch$default(folderCallback.getUiScope(), Dispatchers.getMain(), null, new DocumentFileUtils$doesMeetCopyRequirements$$inlined$postToUi$7(null, folderCallback), 2, null);
        if (!documentFile.isDirectory()) {
            BuildersKt__Builders_commonKt.launch$default(folderCallback.getUiScope(), Dispatchers.getMain(), null, new DocumentFileUtils$doesMeetCopyRequirements$$inlined$postToUi$8(null, folderCallback), 2, null);
            return null;
        } else if (!documentFile2.isDirectory()) {
            BuildersKt__Builders_commonKt.launch$default(folderCallback.getUiScope(), Dispatchers.getMain(), null, new DocumentFileUtils$doesMeetCopyRequirements$$inlined$postToUi$9(null, folderCallback), 2, null);
            return null;
        } else if (!documentFile.canRead() || !isWritable(documentFile2, context)) {
            BuildersKt__Builders_commonKt.launch$default(folderCallback.getUiScope(), Dispatchers.getMain(), null, new DocumentFileUtils$doesMeetCopyRequirements$$inlined$postToUi$10(null, folderCallback), 2, null);
            return null;
        } else {
            String absolutePath = getAbsolutePath(documentFile2, context);
            DocumentFile parentFile = documentFile.getParentFile();
            if (Intrinsics.areEqual(absolutePath, parentFile == null ? null : getAbsolutePath(parentFile, context))) {
                String str2 = str;
                if ((str2 == null || str2.length() == 0) || Intrinsics.areEqual(documentFile.getName(), str)) {
                    BuildersKt__Builders_commonKt.launch$default(folderCallback.getUiScope(), Dispatchers.getMain(), null, new DocumentFileUtils$doesMeetCopyRequirements$$inlined$postToUi$11(null, folderCallback), 2, null);
                    return null;
                }
            }
            DocumentFile writableDownloadsDocumentFile = isDownloadsDocument(documentFile2) ? toWritableDownloadsDocumentFile(documentFile2, context) : documentFile2;
            if (writableDownloadsDocumentFile == null) {
                BuildersKt__Builders_commonKt.launch$default(folderCallback.getUiScope(), Dispatchers.getMain(), null, new DocumentFileUtils$doesMeetCopyRequirements$$inlined$postToUi$12(null, folderCallback), 2, null);
            }
            return writableDownloadsDocumentFile;
        }
    }

    public static /* synthetic */ void copyFileTo$default(DocumentFile documentFile, Context context, File file, FileDescription fileDescription, FileCallback fileCallback, int i, Object obj) {
        if ((i & 4) != 0) {
            fileDescription = null;
        }
        copyFileTo(documentFile, context, file, fileDescription, fileCallback);
    }

    public static final void copyFileTo(DocumentFile documentFile, Context context, File targetFolder, FileDescription fileDescription, FileCallback callback) {
        Intrinsics.checkNotNullParameter(documentFile, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(targetFolder, "targetFolder");
        Intrinsics.checkNotNullParameter(callback, "callback");
        String absolutePath = targetFolder.getAbsolutePath();
        Intrinsics.checkNotNullExpressionValue(absolutePath, "targetFolder.absolutePath");
        copyFileTo(documentFile, context, absolutePath, fileDescription, callback);
    }

    public static /* synthetic */ void copyFileTo$default(DocumentFile documentFile, Context context, String str, FileDescription fileDescription, FileCallback fileCallback, int i, Object obj) {
        if ((i & 4) != 0) {
            fileDescription = null;
        }
        copyFileTo(documentFile, context, str, fileDescription, fileCallback);
    }

    public static final void copyFileTo(DocumentFile documentFile, Context context, String targetFolderAbsolutePath, FileDescription fileDescription, FileCallback callback) {
        Intrinsics.checkNotNullParameter(documentFile, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(targetFolderAbsolutePath, "targetFolderAbsolutePath");
        Intrinsics.checkNotNullParameter(callback, "callback");
        DocumentFile mkdirs$default = DocumentFileCompat.mkdirs$default(context, targetFolderAbsolutePath, true, false, 8, (Object) null);
        if (mkdirs$default == null) {
            BuildersKt__Builders_commonKt.launch$default(callback.getUiScope(), Dispatchers.getMain(), null, new DocumentFileUtils$copyFileTo$$inlined$postToUi$1(null, callback), 2, null);
        } else {
            copyFileTo(documentFile, context, mkdirs$default, fileDescription, callback);
        }
    }

    public static /* synthetic */ void copyFileTo$default(DocumentFile documentFile, Context context, DocumentFile documentFile2, FileDescription fileDescription, FileCallback fileCallback, int i, Object obj) {
        if ((i & 4) != 0) {
            fileDescription = null;
        }
        copyFileTo(documentFile, context, documentFile2, fileDescription, fileCallback);
    }

    public static final void copyFileTo(DocumentFile documentFile, Context context, DocumentFile targetFolder, FileDescription fileDescription, FileCallback callback) {
        Intrinsics.checkNotNullParameter(documentFile, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(targetFolder, "targetFolder");
        Intrinsics.checkNotNullParameter(callback, "callback");
        String subFolder = fileDescription == null ? null : fileDescription.getSubFolder();
        if (subFolder == null || subFolder.length() == 0) {
            copyFileTo(documentFile, context, targetFolder, fileDescription == null ? null : fileDescription.getName(), fileDescription != null ? fileDescription.getMimeType() : null, callback);
            return;
        }
        String subFolder2 = fileDescription == null ? null : fileDescription.getSubFolder();
        if (subFolder2 == null) {
            subFolder2 = "";
        }
        DocumentFile makeFolder = makeFolder(targetFolder, context, subFolder2, CreateMode.REUSE);
        if (makeFolder == null) {
            BuildersKt__Builders_commonKt.launch$default(callback.getUiScope(), Dispatchers.getMain(), null, new DocumentFileUtils$copyFileTo$$inlined$postToUi$2(null, callback), 2, null);
        } else {
            copyFileTo(documentFile, context, makeFolder, fileDescription == null ? null : fileDescription.getName(), fileDescription != null ? fileDescription.getMimeType() : null, callback);
        }
    }

    private static final void copyFileTo(DocumentFile documentFile, Context context, DocumentFile documentFile2, String str, String str2, FileCallback fileCallback) {
        Object runBlocking$default;
        String mimeTypeByFileName;
        String str3 = str;
        DocumentFile doesMeetCopyRequirements = doesMeetCopyRequirements(documentFile, context, documentFile2, str3, fileCallback);
        if (doesMeetCopyRequirements == null) {
            return;
        }
        BuildersKt__Builders_commonKt.launch$default(fileCallback.getUiScope(), Dispatchers.getMain(), null, new DocumentFileUtils$copyFileTo$$inlined$postToUi$3(null, fileCallback), 2, null);
        try {
            if (!fileCallback.onCheckFreeSpace(DocumentFileCompat.getFreeSpace(context, getStorageId(doesMeetCopyRequirements, context)), documentFile.length())) {
                BuildersKt__Builders_commonKt.launch$default(fileCallback.getUiScope(), Dispatchers.getMain(), null, new DocumentFileUtils$copyFileTo$$inlined$postToUi$4(null, fileCallback), 2, null);
                return;
            }
            DocumentFileCompat documentFileCompat = DocumentFileCompat.INSTANCE;
            if (str3 == null && (str3 = documentFile.getName()) == null) {
                str3 = "";
            }
            String trimFileSeparator = TextExt.trimFileSeparator(documentFileCompat.removeForbiddenCharsFromFilename$storage_release(MimeType.getFullFileName(str3, str2 == null ? getMimeTypeByFileName(documentFile) : str2)));
            FileCallback.ConflictResolution handleFileConflict = handleFileConflict(context, doesMeetCopyRequirements, trimFileSeparator, fileCallback);
            if (handleFileConflict == FileCallback.ConflictResolution.SKIP) {
                return;
            }
            runBlocking$default = BuildersKt__BuildersKt.runBlocking$default(null, new DocumentFileUtils$copyFileTo$$inlined$awaitUiResult$1(fileCallback.getUiScope(), null, fileCallback, documentFile, Thread.currentThread()), 1, null);
            long longValue = ((Number) runBlocking$default).longValue();
            int i = (longValue > 0L ? 1 : (longValue == 0L ? 0 : -1));
            if (i < 0) {
                return;
            }
            boolean z = i > 0;
            if (str2 == null) {
                try {
                    mimeTypeByFileName = getMimeTypeByFileName(documentFile);
                } catch (Exception e) {
                    BuildersKt__Builders_commonKt.launch$default(fileCallback.getUiScope(), Dispatchers.getMain(), null, new DocumentFileUtils$copyFileTo$$inlined$postToUi$6(null, fileCallback, e), 2, null);
                    return;
                }
            } else {
                mimeTypeByFileName = str2;
            }
            DocumentFile createTargetFile = createTargetFile(context, doesMeetCopyRequirements, trimFileSeparator, mimeTypeByFileName, handleFileConflict.toCreateMode(), fileCallback);
            if (createTargetFile == null) {
                return;
            }
            createFileStreams(context, documentFile, createTargetFile, fileCallback, new DocumentFileUtils$copyFileTo$6(documentFile, createTargetFile, z, longValue, fileCallback));
        } catch (Throwable unused) {
            BuildersKt__Builders_commonKt.launch$default(fileCallback.getUiScope(), Dispatchers.getMain(), null, new DocumentFileUtils$copyFileTo$$inlined$postToUi$5(null, fileCallback), 2, null);
        }
    }

    private static final DocumentFile doesMeetCopyRequirements(DocumentFile documentFile, Context context, DocumentFile documentFile2, String str, FileCallback fileCallback) {
        BuildersKt__Builders_commonKt.launch$default(fileCallback.getUiScope(), Dispatchers.getMain(), null, new DocumentFileUtils$doesMeetCopyRequirements$$inlined$postToUi$13(null, fileCallback), 2, null);
        if (!documentFile.isFile()) {
            BuildersKt__Builders_commonKt.launch$default(fileCallback.getUiScope(), Dispatchers.getMain(), null, new DocumentFileUtils$doesMeetCopyRequirements$$inlined$postToUi$14(null, fileCallback), 2, null);
            return null;
        } else if (!documentFile2.isDirectory()) {
            BuildersKt__Builders_commonKt.launch$default(fileCallback.getUiScope(), Dispatchers.getMain(), null, new DocumentFileUtils$doesMeetCopyRequirements$$inlined$postToUi$15(null, fileCallback), 2, null);
            return null;
        } else if (!documentFile.canRead() || !isWritable(documentFile2, context)) {
            BuildersKt__Builders_commonKt.launch$default(fileCallback.getUiScope(), Dispatchers.getMain(), null, new DocumentFileUtils$doesMeetCopyRequirements$$inlined$postToUi$16(null, fileCallback), 2, null);
            return null;
        } else {
            DocumentFile parentFile = documentFile.getParentFile();
            if (Intrinsics.areEqual(parentFile == null ? null : getAbsolutePath(parentFile, context), getAbsolutePath(documentFile2, context))) {
                String str2 = str;
                if ((str2 == null || str2.length() == 0) || Intrinsics.areEqual(documentFile.getName(), str)) {
                    BuildersKt__Builders_commonKt.launch$default(fileCallback.getUiScope(), Dispatchers.getMain(), null, new DocumentFileUtils$doesMeetCopyRequirements$$inlined$postToUi$17(null, fileCallback), 2, null);
                    return null;
                }
            }
            DocumentFile writableDownloadsDocumentFile = isDownloadsDocument(documentFile2) ? toWritableDownloadsDocumentFile(documentFile2, context) : documentFile2;
            if (writableDownloadsDocumentFile == null) {
                BuildersKt__Builders_commonKt.launch$default(fileCallback.getUiScope(), Dispatchers.getMain(), null, new DocumentFileUtils$doesMeetCopyRequirements$$inlined$postToUi$18(null, fileCallback), 2, null);
            }
            return writableDownloadsDocumentFile;
        }
    }

    public static final <Enum> void createFileStreams(Context context, DocumentFile documentFile, DocumentFile documentFile2, BaseFileCallback<Enum, ?, ?> baseFileCallback, Function2<? super InputStream, ? super OutputStream, Unit> function2) {
        FileCallback.ErrorCode errorCode;
        FileCallback.ErrorCode errorCode2;
        OutputStream openOutputStream$default = openOutputStream$default(documentFile2, context, false, 2, null);
        if (openOutputStream$default == null) {
            if (baseFileCallback instanceof MultipleFileCallback) {
                errorCode2 = MultipleFileCallback.ErrorCode.CANNOT_CREATE_FILE_IN_TARGET;
            } else {
                errorCode2 = baseFileCallback instanceof FolderCallback ? FolderCallback.ErrorCode.CANNOT_CREATE_FILE_IN_TARGET : FileCallback.ErrorCode.TARGET_FILE_NOT_FOUND;
            }
            BuildersKt__Builders_commonKt.launch$default(baseFileCallback.getUiScope(), Dispatchers.getMain(), null, new DocumentFileUtils$createFileStreams$$inlined$postToUi$1(null, baseFileCallback, errorCode2), 2, null);
            return;
        }
        InputStream openInputStream = openInputStream(documentFile, context);
        if (openInputStream == null) {
            IOExt.closeStream(openOutputStream$default);
            if (baseFileCallback instanceof MultipleFileCallback) {
                errorCode = MultipleFileCallback.ErrorCode.SOURCE_FILE_NOT_FOUND;
            } else {
                errorCode = baseFileCallback instanceof FolderCallback ? FolderCallback.ErrorCode.SOURCE_FILE_NOT_FOUND : FileCallback.ErrorCode.SOURCE_FILE_NOT_FOUND;
            }
            BuildersKt__Builders_commonKt.launch$default(baseFileCallback.getUiScope(), Dispatchers.getMain(), null, new DocumentFileUtils$createFileStreams$$inlined$postToUi$2(null, baseFileCallback, errorCode), 2, null);
            return;
        }
        function2.invoke(openInputStream, openOutputStream$default);
    }

    private static final void createFileStreams(Context context, DocumentFile documentFile, MediaFile mediaFile, FileCallback fileCallback, Function2<? super InputStream, ? super OutputStream, Unit> function2) {
        OutputStream openOutputStream$default = MediaFile.openOutputStream$default(mediaFile, false, 1, null);
        if (openOutputStream$default == null) {
            BuildersKt__Builders_commonKt.launch$default(fileCallback.getUiScope(), Dispatchers.getMain(), null, new DocumentFileUtils$createFileStreams$$inlined$postToUi$3(null, fileCallback), 2, null);
            return;
        }
        InputStream openInputStream = openInputStream(documentFile, context);
        if (openInputStream == null) {
            IOExt.closeStream(openOutputStream$default);
            BuildersKt__Builders_commonKt.launch$default(fileCallback.getUiScope(), Dispatchers.getMain(), null, new DocumentFileUtils$createFileStreams$$inlined$postToUi$4(null, fileCallback), 2, null);
            return;
        }
        function2.invoke(openInputStream, openOutputStream$default);
    }

    private static final DocumentFile createTargetFile(Context context, DocumentFile documentFile, String str, String str2, CreateMode createMode, FileCallback fileCallback) {
        DocumentFile makeFile = makeFile(documentFile, context, str, str2, createMode);
        if (makeFile == null) {
            BuildersKt__Builders_commonKt.launch$default(fileCallback.getUiScope(), Dispatchers.getMain(), null, new DocumentFileUtils$createTargetFile$$inlined$postToUi$1(null, fileCallback), 2, null);
        }
        return makeFile;
    }

    public static final void copyFileStream(DocumentFile documentFile, InputStream inputStream, OutputStream outputStream, Object obj, boolean z, long j, boolean z2, FileCallback fileCallback) {
        Job job;
        try {
            Ref.LongRef longRef = new Ref.LongRef();
            Ref.IntRef intRef = new Ref.IntRef();
            long length = documentFile.length();
            if (!z || length <= 10485760) {
                job = null;
            } else {
                job = CoroutineExt.startCoroutineTimer((r14 & 1) != 0 ? 0L : 0L, (r14 & 2) != 0 ? 0L : j, (r14 & 4) != 0 ? false : false, new DocumentFileUtils$copyFileStream$1(longRef, length, intRef, fileCallback));
            }
            try {
                byte[] bArr = new byte[1024];
                int read = inputStream.read(bArr);
                while (read != -1) {
                    try {
                        outputStream.write(bArr, 0, read);
                        longRef.element += read;
                        intRef.element += read;
                        read = inputStream.read(bArr);
                    } catch (Throwable th) {
                        th = th;
                        if (job != null) {
                            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
                        }
                        IOExt.closeStream(inputStream);
                        IOExt.closeStream(outputStream);
                        throw th;
                    }
                }
                if (job != null) {
                    Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
                }
                if (z2) {
                    documentFile.delete();
                }
                if (obj instanceof MediaFile) {
                    ((MediaFile) obj).setLength(length);
                }
                BuildersKt__Builders_commonKt.launch$default(fileCallback.getUiScope(), Dispatchers.getMain(), null, new DocumentFileUtils$copyFileStream$$inlined$postToUi$1(null, fileCallback, obj), 2, null);
                if (job != null) {
                    Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
                }
                IOExt.closeStream(inputStream);
                IOExt.closeStream(outputStream);
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Throwable th3) {
            th = th3;
            job = null;
        }
    }

    public static /* synthetic */ void moveFileTo$default(DocumentFile documentFile, Context context, File file, FileDescription fileDescription, FileCallback fileCallback, int i, Object obj) {
        if ((i & 4) != 0) {
            fileDescription = null;
        }
        moveFileTo(documentFile, context, file, fileDescription, fileCallback);
    }

    public static final void moveFileTo(DocumentFile documentFile, Context context, File targetFolder, FileDescription fileDescription, FileCallback callback) {
        Intrinsics.checkNotNullParameter(documentFile, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(targetFolder, "targetFolder");
        Intrinsics.checkNotNullParameter(callback, "callback");
        String absolutePath = targetFolder.getAbsolutePath();
        Intrinsics.checkNotNullExpressionValue(absolutePath, "targetFolder.absolutePath");
        moveFileTo(documentFile, context, absolutePath, fileDescription, callback);
    }

    public static /* synthetic */ void moveFileTo$default(DocumentFile documentFile, Context context, String str, FileDescription fileDescription, FileCallback fileCallback, int i, Object obj) {
        if ((i & 4) != 0) {
            fileDescription = null;
        }
        moveFileTo(documentFile, context, str, fileDescription, fileCallback);
    }

    public static final void moveFileTo(DocumentFile documentFile, Context context, String targetFolderAbsolutePath, FileDescription fileDescription, FileCallback callback) {
        Intrinsics.checkNotNullParameter(documentFile, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(targetFolderAbsolutePath, "targetFolderAbsolutePath");
        Intrinsics.checkNotNullParameter(callback, "callback");
        DocumentFile mkdirs$default = DocumentFileCompat.mkdirs$default(context, targetFolderAbsolutePath, true, false, 8, (Object) null);
        if (mkdirs$default == null) {
            BuildersKt__Builders_commonKt.launch$default(callback.getUiScope(), Dispatchers.getMain(), null, new DocumentFileUtils$moveFileTo$$inlined$postToUi$1(null, callback), 2, null);
        } else {
            moveFileTo(documentFile, context, mkdirs$default, fileDescription, callback);
        }
    }

    public static /* synthetic */ void moveFileTo$default(DocumentFile documentFile, Context context, DocumentFile documentFile2, FileDescription fileDescription, FileCallback fileCallback, int i, Object obj) {
        if ((i & 4) != 0) {
            fileDescription = null;
        }
        moveFileTo(documentFile, context, documentFile2, fileDescription, fileCallback);
    }

    public static final void moveFileTo(DocumentFile documentFile, Context context, DocumentFile targetFolder, FileDescription fileDescription, FileCallback callback) {
        Intrinsics.checkNotNullParameter(documentFile, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(targetFolder, "targetFolder");
        Intrinsics.checkNotNullParameter(callback, "callback");
        String subFolder = fileDescription == null ? null : fileDescription.getSubFolder();
        if (subFolder == null || subFolder.length() == 0) {
            moveFileTo(documentFile, context, targetFolder, fileDescription == null ? null : fileDescription.getName(), fileDescription != null ? fileDescription.getMimeType() : null, callback);
            return;
        }
        String subFolder2 = fileDescription == null ? null : fileDescription.getSubFolder();
        if (subFolder2 == null) {
            subFolder2 = "";
        }
        DocumentFile makeFolder = makeFolder(targetFolder, context, subFolder2, CreateMode.REUSE);
        if (makeFolder == null) {
            BuildersKt__Builders_commonKt.launch$default(callback.getUiScope(), Dispatchers.getMain(), null, new DocumentFileUtils$moveFileTo$$inlined$postToUi$2(null, callback), 2, null);
        } else {
            moveFileTo(documentFile, context, makeFolder, fileDescription == null ? null : fileDescription.getName(), fileDescription != null ? fileDescription.getMimeType() : null, callback);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:158:0x0146 A[Catch: all -> 0x023e, TryCatch #1 {all -> 0x023e, blocks: (B:142:0x0109, B:144:0x010f, B:146:0x0115, B:148:0x011b, B:150:0x0125, B:158:0x0146, B:160:0x014c, B:163:0x0154, B:164:0x0157, B:165:0x0172, B:153:0x012d, B:156:0x0134, B:167:0x018a, B:169:0x0198), top: B:193:0x0109 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static final void moveFileTo(androidx.documentfile.provider.DocumentFile r18, android.content.Context r19, androidx.documentfile.provider.DocumentFile r20, java.lang.String r21, java.lang.String r22, com.anggrayudi.storage.callback.FileCallback r23) {
        /*
            Method dump skipped, instructions count: 611
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anggrayudi.storage.file.DocumentFileExt.moveFileTo(androidx.documentfile.provider.DocumentFile, android.content.Context, androidx.documentfile.provider.DocumentFile, java.lang.String, java.lang.String, com.anggrayudi.storage.callback.FileCallback):void");
    }

    private static final boolean simpleCheckSourceFile(DocumentFile documentFile, FileCallback fileCallback) {
        if (!documentFile.isFile()) {
            BuildersKt__Builders_commonKt.launch$default(fileCallback.getUiScope(), Dispatchers.getMain(), null, new DocumentFileUtils$simpleCheckSourceFile$$inlined$postToUi$1(null, fileCallback), 2, null);
            return true;
        } else if (documentFile.canRead()) {
            return false;
        } else {
            BuildersKt__Builders_commonKt.launch$default(fileCallback.getUiScope(), Dispatchers.getMain(), null, new DocumentFileUtils$simpleCheckSourceFile$$inlined$postToUi$2(null, fileCallback), 2, null);
            return true;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:68:0x003e, code lost:
        if ((r7 != null && isTreeDocumentFile(r7)) != false) goto L29;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static final void copyFileToMedia(androidx.documentfile.provider.DocumentFile r15, android.content.Context r16, com.anggrayudi.storage.media.FileDescription r17, com.anggrayudi.storage.callback.FileCallback r18, com.anggrayudi.storage.file.PublicDirectory r19, boolean r20, com.anggrayudi.storage.file.CreateMode r21) {
        /*
            Method dump skipped, instructions count: 269
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anggrayudi.storage.file.DocumentFileExt.copyFileToMedia(androidx.documentfile.provider.DocumentFile, android.content.Context, com.anggrayudi.storage.media.FileDescription, com.anggrayudi.storage.callback.FileCallback, com.anggrayudi.storage.file.PublicDirectory, boolean, com.anggrayudi.storage.file.CreateMode):void");
    }

    public static /* synthetic */ void copyFileToDownloadMedia$default(DocumentFile documentFile, Context context, FileDescription fileDescription, FileCallback fileCallback, CreateMode createMode, int i, Object obj) {
        if ((i & 8) != 0) {
            createMode = CreateMode.CREATE_NEW;
        }
        copyFileToDownloadMedia(documentFile, context, fileDescription, fileCallback, createMode);
    }

    public static final void copyFileToDownloadMedia(DocumentFile documentFile, Context context, FileDescription fileDescription, FileCallback callback, CreateMode mode) {
        Intrinsics.checkNotNullParameter(documentFile, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(fileDescription, "fileDescription");
        Intrinsics.checkNotNullParameter(callback, "callback");
        Intrinsics.checkNotNullParameter(mode, "mode");
        copyFileToMedia(documentFile, context, fileDescription, callback, PublicDirectory.DOWNLOADS, false, mode);
    }

    public static /* synthetic */ void copyFileToPictureMedia$default(DocumentFile documentFile, Context context, FileDescription fileDescription, FileCallback fileCallback, CreateMode createMode, int i, Object obj) {
        if ((i & 8) != 0) {
            createMode = CreateMode.CREATE_NEW;
        }
        copyFileToPictureMedia(documentFile, context, fileDescription, fileCallback, createMode);
    }

    public static final void copyFileToPictureMedia(DocumentFile documentFile, Context context, FileDescription fileDescription, FileCallback callback, CreateMode mode) {
        Intrinsics.checkNotNullParameter(documentFile, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(fileDescription, "fileDescription");
        Intrinsics.checkNotNullParameter(callback, "callback");
        Intrinsics.checkNotNullParameter(mode, "mode");
        copyFileToMedia(documentFile, context, fileDescription, callback, PublicDirectory.PICTURES, false, mode);
    }

    public static /* synthetic */ void moveFileToDownloadMedia$default(DocumentFile documentFile, Context context, FileDescription fileDescription, FileCallback fileCallback, CreateMode createMode, int i, Object obj) {
        if ((i & 8) != 0) {
            createMode = CreateMode.CREATE_NEW;
        }
        moveFileToDownloadMedia(documentFile, context, fileDescription, fileCallback, createMode);
    }

    public static final void moveFileToDownloadMedia(DocumentFile documentFile, Context context, FileDescription fileDescription, FileCallback callback, CreateMode mode) {
        Intrinsics.checkNotNullParameter(documentFile, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(fileDescription, "fileDescription");
        Intrinsics.checkNotNullParameter(callback, "callback");
        Intrinsics.checkNotNullParameter(mode, "mode");
        copyFileToMedia(documentFile, context, fileDescription, callback, PublicDirectory.DOWNLOADS, true, mode);
    }

    public static /* synthetic */ void moveFileToPictureMedia$default(DocumentFile documentFile, Context context, FileDescription fileDescription, FileCallback fileCallback, CreateMode createMode, int i, Object obj) {
        if ((i & 8) != 0) {
            createMode = CreateMode.CREATE_NEW;
        }
        moveFileToPictureMedia(documentFile, context, fileDescription, fileCallback, createMode);
    }

    public static final void moveFileToPictureMedia(DocumentFile documentFile, Context context, FileDescription fileDescription, FileCallback callback, CreateMode mode) {
        Intrinsics.checkNotNullParameter(documentFile, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(fileDescription, "fileDescription");
        Intrinsics.checkNotNullParameter(callback, "callback");
        Intrinsics.checkNotNullParameter(mode, "mode");
        copyFileToMedia(documentFile, context, fileDescription, callback, PublicDirectory.PICTURES, true, mode);
    }

    public static final void moveFileTo(DocumentFile documentFile, Context context, MediaFile targetFile, FileCallback callback) {
        Intrinsics.checkNotNullParameter(documentFile, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(targetFile, "targetFile");
        Intrinsics.checkNotNullParameter(callback, "callback");
        copyFileTo(documentFile, context, targetFile, true, callback);
    }

    public static final void copyFileTo(DocumentFile documentFile, Context context, MediaFile targetFile, FileCallback callback) {
        Intrinsics.checkNotNullParameter(documentFile, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(targetFile, "targetFile");
        Intrinsics.checkNotNullParameter(callback, "callback");
        copyFileTo(documentFile, context, targetFile, false, callback);
    }

    private static final void copyFileTo(DocumentFile documentFile, Context context, MediaFile mediaFile, boolean z, FileCallback fileCallback) {
        Object runBlocking$default;
        CoroutineScope uiScope;
        MainCoroutineDispatcher main;
        CoroutineStart coroutineStart;
        DocumentFileUtils$createFileStreams$$inlined$postToUi$4 documentFileUtils$createFileStreams$$inlined$postToUi$4;
        if (simpleCheckSourceFile(documentFile, fileCallback)) {
            return;
        }
        try {
            if (!fileCallback.onCheckFreeSpace(DocumentFileCompat.getFreeSpace(context, StorageId.PRIMARY), documentFile.length())) {
                BuildersKt__Builders_commonKt.launch$default(fileCallback.getUiScope(), Dispatchers.getMain(), null, new DocumentFileUtils$copyFileTo$$inlined$postToUi$7(null, fileCallback), 2, null);
                return;
            }
            runBlocking$default = BuildersKt__BuildersKt.runBlocking$default(null, new DocumentFileUtils$copyFileTo$$inlined$awaitUiResult$2(fileCallback.getUiScope(), null, fileCallback, documentFile, Thread.currentThread()), 1, null);
            long longValue = ((Number) runBlocking$default).longValue();
            int i = (longValue > 0L ? 1 : (longValue == 0L ? 0 : -1));
            if (i < 0) {
                return;
            }
            boolean z2 = i > 0;
            try {
                OutputStream openOutputStream$default = MediaFile.openOutputStream$default(mediaFile, false, 1, null);
                if (openOutputStream$default == null) {
                    uiScope = fileCallback.getUiScope();
                    main = Dispatchers.getMain();
                    coroutineStart = null;
                    documentFileUtils$createFileStreams$$inlined$postToUi$4 = new DocumentFileUtils$createFileStreams$$inlined$postToUi$3(null, fileCallback);
                } else {
                    InputStream openInputStream = openInputStream(documentFile, context);
                    if (openInputStream != null) {
                        copyFileStream(documentFile, openInputStream, openOutputStream$default, mediaFile, z2, longValue, z, fileCallback);
                        return;
                    }
                    IOExt.closeStream(openOutputStream$default);
                    uiScope = fileCallback.getUiScope();
                    main = Dispatchers.getMain();
                    coroutineStart = null;
                    documentFileUtils$createFileStreams$$inlined$postToUi$4 = new DocumentFileUtils$createFileStreams$$inlined$postToUi$4(null, fileCallback);
                }
                BuildersKt__Builders_commonKt.launch$default(uiScope, main, coroutineStart, documentFileUtils$createFileStreams$$inlined$postToUi$4, 2, null);
            } catch (Exception e) {
                BuildersKt__Builders_commonKt.launch$default(fileCallback.getUiScope(), Dispatchers.getMain(), null, new DocumentFileUtils$copyFileTo$$inlined$postToUi$9(null, fileCallback, e), 2, null);
            }
        } catch (Throwable unused) {
            BuildersKt__Builders_commonKt.launch$default(fileCallback.getUiScope(), Dispatchers.getMain(), null, new DocumentFileUtils$copyFileTo$$inlined$postToUi$8(null, fileCallback), 2, null);
        }
    }

    public static final FileCallback.ErrorCode toFileCallbackErrorCode(Exception exc) {
        Intrinsics.checkNotNullParameter(exc, "<this>");
        if (exc instanceof SecurityException) {
            return FileCallback.ErrorCode.STORAGE_PERMISSION_DENIED;
        }
        return exc instanceof InterruptedIOException ? true : exc instanceof InterruptedException ? FileCallback.ErrorCode.CANCELED : FileCallback.ErrorCode.UNKNOWN_IO_ERROR;
    }

    private static final FileCallback.ConflictResolution handleFileConflict(Context context, DocumentFile documentFile, String str, FileCallback fileCallback) {
        Object runBlocking$default;
        DocumentFile child$default = child$default(documentFile, context, str, false, 4, null);
        if (child$default != null) {
            runBlocking$default = BuildersKt__BuildersKt.runBlocking$default(null, new C1104x5fab843(fileCallback.getUiScope(), null, fileCallback, child$default), 1, null);
            FileCallback.ConflictResolution conflictResolution = (FileCallback.ConflictResolution) runBlocking$default;
            if (conflictResolution == FileCallback.ConflictResolution.REPLACE) {
                BuildersKt__Builders_commonKt.launch$default(fileCallback.getUiScope(), Dispatchers.getMain(), null, new C1106x4f78a608(null, fileCallback), 2, null);
                if (!forceDelete$default(child$default, context, false, 2, null)) {
                    BuildersKt__Builders_commonKt.launch$default(fileCallback.getUiScope(), Dispatchers.getMain(), null, new C1107x4f78a609(null, fileCallback), 2, null);
                    return FileCallback.ConflictResolution.SKIP;
                }
            }
            return conflictResolution;
        }
        return FileCallback.ConflictResolution.CREATE_NEW;
    }

    private static final FolderCallback.ConflictResolution handleParentFolderConflict(Context context, DocumentFile documentFile, String str, FolderCallback folderCallback) {
        Object runBlocking$default;
        DocumentFile child$default = child$default(documentFile, context, str, false, 4, null);
        if (child$default != null) {
            boolean isDirectory = child$default.isDirectory();
            if (!isDirectory || !isEmpty(child$default, context)) {
                runBlocking$default = BuildersKt__BuildersKt.runBlocking$default(null, new C1110x1d0444a3(folderCallback.getUiScope(), null, folderCallback, child$default, isDirectory), 1, null);
                FolderCallback.ConflictResolution conflictResolution = (FolderCallback.ConflictResolution) runBlocking$default;
                int i = WhenMappings.$EnumSwitchMapping$2[conflictResolution.ordinal()];
                if (i == 1) {
                    BuildersKt__Builders_commonKt.launch$default(folderCallback.getUiScope(), Dispatchers.getMain(), null, new C1112x54e6f268(null, folderCallback), 2, null);
                    boolean isDirectory2 = child$default.isDirectory();
                    if (!forceDelete(child$default, context, true)) {
                        BuildersKt__Builders_commonKt.launch$default(folderCallback.getUiScope(), Dispatchers.getMain(), null, new C1114x54e6f26a(null, folderCallback), 2, null);
                        return FolderCallback.ConflictResolution.SKIP;
                    } else if (!isDirectory2) {
                        DocumentFile parentFile = child$default.getParentFile();
                        if ((parentFile == null ? null : parentFile.createDirectory(str)) == null) {
                            BuildersKt__Builders_commonKt.launch$default(folderCallback.getUiScope(), Dispatchers.getMain(), null, new C1113x54e6f269(null, folderCallback), 2, null);
                            return FolderCallback.ConflictResolution.SKIP;
                        }
                    }
                } else if (i == 2 && child$default.isFile()) {
                    if (!child$default.delete()) {
                        BuildersKt__Builders_commonKt.launch$default(folderCallback.getUiScope(), Dispatchers.getMain(), null, new C1116x54e6f26c(null, folderCallback), 2, null);
                        return FolderCallback.ConflictResolution.SKIP;
                    }
                    DocumentFile parentFile2 = child$default.getParentFile();
                    if ((parentFile2 == null ? null : parentFile2.createDirectory(str)) == null) {
                        BuildersKt__Builders_commonKt.launch$default(folderCallback.getUiScope(), Dispatchers.getMain(), null, new C1115x54e6f26b(null, folderCallback), 2, null);
                        return FolderCallback.ConflictResolution.SKIP;
                    }
                }
                return conflictResolution;
            }
            return FolderCallback.ConflictResolution.MERGE;
        }
        return FolderCallback.ConflictResolution.CREATE_NEW;
    }

    private static final List<MultipleFileCallback.ParentConflict> handleParentFolderConflict(List<? extends DocumentFile> list, Context context, DocumentFile documentFile, MultipleFileCallback multipleFileCallback) {
        DocumentFile[] documentFileArr;
        Object runBlocking$default;
        boolean z;
        boolean z2;
        FolderCallback.ConflictResolution conflictResolution;
        List<? extends DocumentFile> list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        for (DocumentFile documentFile2 : list2) {
            arrayList.add(documentFile2.getName());
        }
        ArrayList arrayList2 = arrayList;
        DocumentFile[] listFiles = documentFile.listFiles();
        Intrinsics.checkNotNullExpressionValue(listFiles, "targetParentFolder.listFiles()");
        ArrayList arrayList3 = new ArrayList();
        for (DocumentFile documentFile3 : listFiles) {
            if (arrayList2.contains(documentFile3.getName())) {
                arrayList3.add(documentFile3);
            }
        }
        ArrayList arrayList4 = arrayList3;
        ArrayList arrayList5 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList4, 10));
        Iterator it = arrayList4.iterator();
        while (true) {
            boolean z3 = true;
            if (!it.hasNext()) {
                ArrayList arrayList6 = arrayList5;
                ArrayList arrayList7 = new ArrayList();
                for (Object obj : arrayList6) {
                    if (((MultipleFileCallback.ParentConflict) obj).getSolution() != FolderCallback.ConflictResolution.MERGE) {
                        arrayList7.add(obj);
                    }
                }
                List mutableList = CollectionsKt.toMutableList((Collection) arrayList7);
                if (!mutableList.isEmpty()) {
                    List list3 = mutableList;
                    ArrayList arrayList8 = new ArrayList();
                    for (Object obj2 : list3) {
                        if (((MultipleFileCallback.ParentConflict) obj2).getSource().isFile()) {
                            arrayList8.add(obj2);
                        }
                    }
                    List mutableList2 = CollectionsKt.toMutableList((Collection) arrayList8);
                    ArrayList arrayList9 = new ArrayList();
                    for (Object obj3 : list3) {
                        if (((MultipleFileCallback.ParentConflict) obj3).getSource().isDirectory()) {
                            arrayList9.add(obj3);
                        }
                    }
                    runBlocking$default = BuildersKt__BuildersKt.runBlocking$default(null, new C1108x2935bd4c(multipleFileCallback.getUiScope(), null, multipleFileCallback, documentFile, CollectionsKt.toMutableList((Collection) arrayList9), mutableList2), 1, null);
                    List list4 = (List) runBlocking$default;
                    List<MultipleFileCallback.ParentConflict> list5 = list4;
                    if (!(list5 instanceof Collection) || !list5.isEmpty()) {
                        for (MultipleFileCallback.ParentConflict parentConflict : list5) {
                            if (parentConflict.getSolution() == FolderCallback.ConflictResolution.REPLACE) {
                                z = true;
                                continue;
                            } else {
                                z = false;
                                continue;
                            }
                            if (z) {
                                z2 = true;
                                break;
                            }
                        }
                    }
                    z2 = false;
                    if (z2) {
                        BuildersKt__Builders_commonKt.launch$default(multipleFileCallback.getUiScope(), Dispatchers.getMain(), null, new DocumentFileUtils$handleParentFolderConflict$$inlined$postToUi$1(null, multipleFileCallback), 2, null);
                    }
                    for (MultipleFileCallback.ParentConflict parentConflict2 : list5) {
                        int i = WhenMappings.$EnumSwitchMapping$2[parentConflict2.getSolution().ordinal()];
                        if (i == 1) {
                            DocumentFile target = parentConflict2.getTarget();
                            if (!(deleteRecursively(target, context, true) || !target.exists())) {
                                BuildersKt__Builders_commonKt.launch$default(multipleFileCallback.getUiScope(), Dispatchers.getMain(), null, new C1117x165ca6a0(null, multipleFileCallback), 2, null);
                                return null;
                            }
                        } else if (i == 2 && parentConflict2.getTarget().isFile() && !parentConflict2.getTarget().delete()) {
                            BuildersKt__Builders_commonKt.launch$default(multipleFileCallback.getUiScope(), Dispatchers.getMain(), null, new C1118x165ca6a1(null, multipleFileCallback), 2, null);
                            return null;
                        }
                    }
                    List<MultipleFileCallback.ParentConflict> mutableList3 = CollectionsKt.toMutableList((Collection) list4);
                    ArrayList arrayList10 = new ArrayList();
                    for (Object obj4 : arrayList6) {
                        if (((MultipleFileCallback.ParentConflict) obj4).getSolution() == FolderCallback.ConflictResolution.MERGE) {
                            arrayList10.add(obj4);
                        }
                    }
                    mutableList3.addAll(arrayList10);
                    return mutableList3;
                }
                return CollectionsKt.emptyList();
            }
            DocumentFile it2 = (DocumentFile) it.next();
            for (DocumentFile documentFile4 : list2) {
                if (Intrinsics.areEqual(documentFile4.getName(), it2.getName())) {
                    z3 = (documentFile4.isDirectory() && it2.isDirectory()) ? false : false;
                    if (z3) {
                        Intrinsics.checkNotNullExpressionValue(it2, "it");
                        if (isEmpty(it2, context)) {
                            conflictResolution = FolderCallback.ConflictResolution.MERGE;
                            Intrinsics.checkNotNullExpressionValue(it2, "it");
                            arrayList5.add(new MultipleFileCallback.ParentConflict(documentFile4, it2, z3, conflictResolution));
                        }
                    }
                    conflictResolution = FolderCallback.ConflictResolution.CREATE_NEW;
                    Intrinsics.checkNotNullExpressionValue(it2, "it");
                    arrayList5.add(new MultipleFileCallback.ParentConflict(documentFile4, it2, z3, conflictResolution));
                }
            }
            throw new NoSuchElementException("Collection contains no element matching the predicate.");
        }
    }
}
