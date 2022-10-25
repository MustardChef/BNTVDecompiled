package com.lagradost.cloudstream3.extractors.helper;

import com.fasterxml.jackson.annotation.JsonProperty;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: WcoHelper.kt */
@Metadata(m108d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, m107d2 = {"Lcom/lagradost/cloudstream3/extractors/helper/WcoHelper;", "", "()V", "Companion", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
/* loaded from: classes3.dex */
public final class WcoHelper {
    private static final String BACKUP_KEY_DATA = "github_keys_backup";
    public static final Companion Companion = new Companion(null);
    private static Companion.ExternalKeys keys;
    private static Companion.NewExternalKeys newKeys;

    /* compiled from: WcoHelper.kt */
    @Metadata(m108d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001:\u0002\u000f\u0010B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0011\u0010\t\u001a\u00020\nH\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\u000bJ\u0011\u0010\f\u001a\u00020\nH\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\u000bJ\u0013\u0010\r\u001a\u0004\u0018\u00010\bH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u000bJ\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u0006H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u000bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0011"}, m107d2 = {"Lcom/lagradost/cloudstream3/extractors/helper/WcoHelper$Companion;", "", "()V", "BACKUP_KEY_DATA", "", "keys", "Lcom/lagradost/cloudstream3/extractors/helper/WcoHelper$Companion$ExternalKeys;", "newKeys", "Lcom/lagradost/cloudstream3/extractors/helper/WcoHelper$Companion$NewExternalKeys;", "getKeys", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getNewKeys", "getNewWcoKey", "getWcoKey", "ExternalKeys", "NewExternalKeys", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* compiled from: WcoHelper.kt */
        @Metadata(m108d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u000b\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003J!\u0010\u000b\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0012"}, m107d2 = {"Lcom/lagradost/cloudstream3/extractors/helper/WcoHelper$Companion$ExternalKeys;", "", "wcoKey", "", "wcocipher", "(Ljava/lang/String;Ljava/lang/String;)V", "getWcoKey", "()Ljava/lang/String;", "getWcocipher", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
        /* loaded from: classes3.dex */
        public static final class ExternalKeys {
            private final String wcoKey;
            private final String wcocipher;

            public ExternalKeys() {
                this(null, null, 3, null);
            }

            public static /* synthetic */ ExternalKeys copy$default(ExternalKeys externalKeys, String str, String str2, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = externalKeys.wcoKey;
                }
                if ((i & 2) != 0) {
                    str2 = externalKeys.wcocipher;
                }
                return externalKeys.copy(str, str2);
            }

            public final String component1() {
                return this.wcoKey;
            }

            public final String component2() {
                return this.wcocipher;
            }

            public final ExternalKeys copy(@JsonProperty("wco_key") String str, @JsonProperty("wco_cipher_key") String str2) {
                return new ExternalKeys(str, str2);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj instanceof ExternalKeys) {
                    ExternalKeys externalKeys = (ExternalKeys) obj;
                    return Intrinsics.areEqual(this.wcoKey, externalKeys.wcoKey) && Intrinsics.areEqual(this.wcocipher, externalKeys.wcocipher);
                }
                return false;
            }

            public int hashCode() {
                String str = this.wcoKey;
                int hashCode = (str == null ? 0 : str.hashCode()) * 31;
                String str2 = this.wcocipher;
                return hashCode + (str2 != null ? str2.hashCode() : 0);
            }

            public String toString() {
                return "ExternalKeys(wcoKey=" + this.wcoKey + ", wcocipher=" + this.wcocipher + ')';
            }

            public ExternalKeys(@JsonProperty("wco_key") String str, @JsonProperty("wco_cipher_key") String str2) {
                this.wcoKey = str;
                this.wcocipher = str2;
            }

            public /* synthetic */ ExternalKeys(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2);
            }

            public final String getWcoKey() {
                return this.wcoKey;
            }

            public final String getWcocipher() {
                return this.wcocipher;
            }
        }

        /* compiled from: WcoHelper.kt */
        @Metadata(m108d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0006J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J-\u0010\u000e\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u0015"}, m107d2 = {"Lcom/lagradost/cloudstream3/extractors/helper/WcoHelper$Companion$NewExternalKeys;", "", "cipherkey", "", "encryptKey", "mainKey", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getCipherkey", "()Ljava/lang/String;", "getEncryptKey", "getMainKey", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
        /* loaded from: classes3.dex */
        public static final class NewExternalKeys {
            private final String cipherkey;
            private final String encryptKey;
            private final String mainKey;

            public NewExternalKeys() {
                this(null, null, null, 7, null);
            }

            public static /* synthetic */ NewExternalKeys copy$default(NewExternalKeys newExternalKeys, String str, String str2, String str3, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = newExternalKeys.cipherkey;
                }
                if ((i & 2) != 0) {
                    str2 = newExternalKeys.encryptKey;
                }
                if ((i & 4) != 0) {
                    str3 = newExternalKeys.mainKey;
                }
                return newExternalKeys.copy(str, str2, str3);
            }

            public final String component1() {
                return this.cipherkey;
            }

            public final String component2() {
                return this.encryptKey;
            }

            public final String component3() {
                return this.mainKey;
            }

            public final NewExternalKeys copy(@JsonProperty("cipherKey") String str, @JsonProperty("encryptKey") String str2, @JsonProperty("mainKey") String str3) {
                return new NewExternalKeys(str, str2, str3);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj instanceof NewExternalKeys) {
                    NewExternalKeys newExternalKeys = (NewExternalKeys) obj;
                    return Intrinsics.areEqual(this.cipherkey, newExternalKeys.cipherkey) && Intrinsics.areEqual(this.encryptKey, newExternalKeys.encryptKey) && Intrinsics.areEqual(this.mainKey, newExternalKeys.mainKey);
                }
                return false;
            }

            public int hashCode() {
                String str = this.cipherkey;
                int hashCode = (str == null ? 0 : str.hashCode()) * 31;
                String str2 = this.encryptKey;
                int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
                String str3 = this.mainKey;
                return hashCode2 + (str3 != null ? str3.hashCode() : 0);
            }

            public String toString() {
                return "NewExternalKeys(cipherkey=" + this.cipherkey + ", encryptKey=" + this.encryptKey + ", mainKey=" + this.mainKey + ')';
            }

            public NewExternalKeys(@JsonProperty("cipherKey") String str, @JsonProperty("encryptKey") String str2, @JsonProperty("mainKey") String str3) {
                this.cipherkey = str;
                this.encryptKey = str2;
                this.mainKey = str3;
            }

            public /* synthetic */ NewExternalKeys(String str, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3);
            }

            public final String getCipherkey() {
                return this.cipherkey;
            }

            public final String getEncryptKey() {
                return this.encryptKey;
            }

            public final String getMainKey() {
                return this.mainKey;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Can't wrap try/catch for region: R(13:1|(2:3|(11:5|6|(1:(1:9)(2:36|37))(4:38|(2:40|(1:42))|29|30)|10|11|12|13|(1:15)(1:32)|(3:17|(4:19|20|21|(1:23)(2:24|25))|28)|29|30))|43|6|(0)(0)|10|11|12|13|(0)(0)|(0)|29|30) */
        /* JADX WARN: Code restructure failed: missing block: B:22:0x0082, code lost:
            r0 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:23:0x0083, code lost:
            r0.printStackTrace();
            r0 = null;
         */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:10:0x002a  */
        /* JADX WARN: Removed duplicated region for block: B:14:0x0038  */
        /* JADX WARN: Removed duplicated region for block: B:26:0x008d  */
        /* JADX WARN: Removed duplicated region for block: B:27:0x0093  */
        /* JADX WARN: Removed duplicated region for block: B:29:0x0096  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object getKeys(kotlin.coroutines.Continuation<? super kotlin.Unit> r21) {
            /*
                r20 = this;
                r0 = r21
                boolean r1 = r0 instanceof com.lagradost.cloudstream3.extractors.helper.WcoHelper$Companion$getKeys$1
                if (r1 == 0) goto L18
                r1 = r0
                com.lagradost.cloudstream3.extractors.helper.WcoHelper$Companion$getKeys$1 r1 = (com.lagradost.cloudstream3.extractors.helper.WcoHelper$Companion$getKeys$1) r1
                int r2 = r1.label
                r3 = -2147483648(0xffffffff80000000, float:-0.0)
                r2 = r2 & r3
                if (r2 == 0) goto L18
                int r0 = r1.label
                int r0 = r0 - r3
                r1.label = r0
                r2 = r20
                goto L1f
            L18:
                com.lagradost.cloudstream3.extractors.helper.WcoHelper$Companion$getKeys$1 r1 = new com.lagradost.cloudstream3.extractors.helper.WcoHelper$Companion$getKeys$1
                r2 = r20
                r1.<init>(r2, r0)
            L1f:
                java.lang.Object r0 = r1.result
                java.lang.Object r15 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r3 = r1.label
                r4 = 1
                if (r3 == 0) goto L38
                if (r3 != r4) goto L30
                kotlin.ResultKt.throwOnFailure(r0)
                goto L69
            L30:
                java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
                java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
                r0.<init>(r1)
                throw r0
            L38:
                kotlin.ResultKt.throwOnFailure(r0)
                com.lagradost.cloudstream3.extractors.helper.WcoHelper$Companion$ExternalKeys r0 = com.lagradost.cloudstream3.extractors.helper.WcoHelper.access$getKeys$cp()
                if (r0 != 0) goto Lc3
                com.lagradost.cloudstream3.utils.Extensions$RequestCustom r0 = com.lagradost.cloudstream3.MainActivityKt.getApp()
                r3 = r0
                com.lagradost.nicehttp.Requests r3 = (com.lagradost.nicehttp.Requests) r3
                r5 = 0
                r6 = 0
                r7 = 0
                r8 = 0
                r9 = 0
                r10 = 0
                r11 = 0
                r12 = 0
                r14 = 0
                r0 = 0
                r17 = 2046(0x7fe, float:2.867E-42)
                r18 = 0
                r1.label = r4
                java.lang.String r4 = "https://raw.githubusercontent.com/LagradOst/CloudStream-3/master/docs/keys.json"
                r19 = r15
                r15 = r0
                r16 = r1
                java.lang.Object r0 = com.lagradost.nicehttp.Requests.get$default(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r14, r15, r16, r17, r18)
                r1 = r19
                if (r0 != r1) goto L69
                return r1
            L69:
                com.lagradost.nicehttp.NiceResponse r0 = (com.lagradost.nicehttp.NiceResponse) r0
                r1 = 0
                com.lagradost.nicehttp.Requests$Companion r3 = com.lagradost.nicehttp.Requests.Companion     // Catch: java.lang.Exception -> L82
                com.fasterxml.jackson.databind.ObjectMapper r3 = r3.getMapper()     // Catch: java.lang.Exception -> L82
                java.lang.String r0 = r0.getText()     // Catch: java.lang.Exception -> L82
                com.lagradost.cloudstream3.extractors.helper.WcoHelper$Companion$getKeys$$inlined$parsedSafe$1 r4 = new com.lagradost.cloudstream3.extractors.helper.WcoHelper$Companion$getKeys$$inlined$parsedSafe$1     // Catch: java.lang.Exception -> L82
                r4.<init>()     // Catch: java.lang.Exception -> L82
                com.fasterxml.jackson.core.type.TypeReference r4 = (com.fasterxml.jackson.core.type.TypeReference) r4     // Catch: java.lang.Exception -> L82
                java.lang.Object r0 = r3.readValue(r0, r4)     // Catch: java.lang.Exception -> L82
                goto L87
            L82:
                r0 = move-exception
                r0.printStackTrace()
                r0 = r1
            L87:
                com.lagradost.cloudstream3.extractors.helper.WcoHelper$Companion$ExternalKeys r0 = (com.lagradost.cloudstream3.extractors.helper.WcoHelper.Companion.ExternalKeys) r0
                java.lang.String r3 = "github_keys_backup"
                if (r0 == 0) goto L93
                com.lagradost.cloudstream3.AcraApplication$Companion r4 = com.lagradost.cloudstream3.AcraApplication.Companion
                r4.setKey(r3, r0)
                goto L94
            L93:
                r0 = r1
            L94:
                if (r0 != 0) goto Lc3
                com.lagradost.cloudstream3.AcraApplication$Companion r0 = com.lagradost.cloudstream3.AcraApplication.Companion
                android.content.Context r0 = r0.getContext()
                if (r0 == 0) goto Lc0
                com.lagradost.cloudstream3.utils.DataStore r4 = com.lagradost.cloudstream3.utils.DataStore.INSTANCE
                android.content.SharedPreferences r0 = r4.getSharedPrefs(r0)     // Catch: java.lang.Exception -> Lc0
                java.lang.String r0 = r0.getString(r3, r1)     // Catch: java.lang.Exception -> Lc0
                if (r0 != 0) goto Lab
                goto Lc0
            Lab:
                java.lang.String r3 = "getSharedPrefs().getStri…h, null) ?: return defVal"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r3)     // Catch: java.lang.Exception -> Lc0
                com.fasterxml.jackson.databind.json.JsonMapper r3 = r4.getMapper()     // Catch: java.lang.Exception -> Lc0
                java.lang.Class<com.lagradost.cloudstream3.extractors.helper.WcoHelper$Companion$ExternalKeys> r4 = com.lagradost.cloudstream3.extractors.helper.WcoHelper.Companion.ExternalKeys.class
                java.lang.Object r0 = r3.readValue(r0, r4)     // Catch: java.lang.Exception -> Lc0
                java.lang.String r3 = "mapper.readValue(this, T::class.java)"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r3)     // Catch: java.lang.Exception -> Lc0
                r1 = r0
            Lc0:
                r0 = r1
                com.lagradost.cloudstream3.extractors.helper.WcoHelper$Companion$ExternalKeys r0 = (com.lagradost.cloudstream3.extractors.helper.WcoHelper.Companion.ExternalKeys) r0
            Lc3:
                com.lagradost.cloudstream3.extractors.helper.WcoHelper.access$setKeys$cp(r0)
                kotlin.Unit r0 = kotlin.Unit.INSTANCE
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.lagradost.cloudstream3.extractors.helper.WcoHelper.Companion.getKeys(kotlin.coroutines.Continuation):java.lang.Object");
        }

        /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
        /* JADX WARN: Removed duplicated region for block: B:14:0x0032  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object getWcoKey(kotlin.coroutines.Continuation<? super com.lagradost.cloudstream3.extractors.helper.WcoHelper.Companion.ExternalKeys> r5) {
            /*
                r4 = this;
                boolean r0 = r5 instanceof com.lagradost.cloudstream3.extractors.helper.WcoHelper$Companion$getWcoKey$1
                if (r0 == 0) goto L14
                r0 = r5
                com.lagradost.cloudstream3.extractors.helper.WcoHelper$Companion$getWcoKey$1 r0 = (com.lagradost.cloudstream3.extractors.helper.WcoHelper$Companion$getWcoKey$1) r0
                int r1 = r0.label
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r1 = r1 & r2
                if (r1 == 0) goto L14
                int r5 = r0.label
                int r5 = r5 - r2
                r0.label = r5
                goto L19
            L14:
                com.lagradost.cloudstream3.extractors.helper.WcoHelper$Companion$getWcoKey$1 r0 = new com.lagradost.cloudstream3.extractors.helper.WcoHelper$Companion$getWcoKey$1
                r0.<init>(r4, r5)
            L19:
                java.lang.Object r5 = r0.result
                java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r2 = r0.label
                r3 = 1
                if (r2 == 0) goto L32
                if (r2 != r3) goto L2a
                kotlin.ResultKt.throwOnFailure(r5)
                goto L3e
            L2a:
                java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r5.<init>(r0)
                throw r5
            L32:
                kotlin.ResultKt.throwOnFailure(r5)
                r0.label = r3
                java.lang.Object r5 = r4.getKeys(r0)
                if (r5 != r1) goto L3e
                return r1
            L3e:
                com.lagradost.cloudstream3.extractors.helper.WcoHelper$Companion$ExternalKeys r5 = com.lagradost.cloudstream3.extractors.helper.WcoHelper.access$getKeys$cp()
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: com.lagradost.cloudstream3.extractors.helper.WcoHelper.Companion.getWcoKey(kotlin.coroutines.Continuation):java.lang.Object");
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Can't wrap try/catch for region: R(13:1|(2:3|(11:5|6|(1:(1:9)(2:36|37))(4:38|(2:40|(1:42))|29|30)|10|11|12|13|(1:15)(1:32)|(3:17|(4:19|20|21|(1:23)(2:24|25))|28)|29|30))|43|6|(0)(0)|10|11|12|13|(0)(0)|(0)|29|30) */
        /* JADX WARN: Code restructure failed: missing block: B:22:0x0082, code lost:
            r0 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:23:0x0083, code lost:
            r0.printStackTrace();
            r0 = null;
         */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:10:0x002a  */
        /* JADX WARN: Removed duplicated region for block: B:14:0x0038  */
        /* JADX WARN: Removed duplicated region for block: B:26:0x008d  */
        /* JADX WARN: Removed duplicated region for block: B:27:0x0093  */
        /* JADX WARN: Removed duplicated region for block: B:29:0x0096  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object getNewKeys(kotlin.coroutines.Continuation<? super kotlin.Unit> r21) {
            /*
                r20 = this;
                r0 = r21
                boolean r1 = r0 instanceof com.lagradost.cloudstream3.extractors.helper.WcoHelper$Companion$getNewKeys$1
                if (r1 == 0) goto L18
                r1 = r0
                com.lagradost.cloudstream3.extractors.helper.WcoHelper$Companion$getNewKeys$1 r1 = (com.lagradost.cloudstream3.extractors.helper.WcoHelper$Companion$getNewKeys$1) r1
                int r2 = r1.label
                r3 = -2147483648(0xffffffff80000000, float:-0.0)
                r2 = r2 & r3
                if (r2 == 0) goto L18
                int r0 = r1.label
                int r0 = r0 - r3
                r1.label = r0
                r2 = r20
                goto L1f
            L18:
                com.lagradost.cloudstream3.extractors.helper.WcoHelper$Companion$getNewKeys$1 r1 = new com.lagradost.cloudstream3.extractors.helper.WcoHelper$Companion$getNewKeys$1
                r2 = r20
                r1.<init>(r2, r0)
            L1f:
                java.lang.Object r0 = r1.result
                java.lang.Object r15 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r3 = r1.label
                r4 = 1
                if (r3 == 0) goto L38
                if (r3 != r4) goto L30
                kotlin.ResultKt.throwOnFailure(r0)
                goto L69
            L30:
                java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
                java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
                r0.<init>(r1)
                throw r0
            L38:
                kotlin.ResultKt.throwOnFailure(r0)
                com.lagradost.cloudstream3.extractors.helper.WcoHelper$Companion$NewExternalKeys r0 = com.lagradost.cloudstream3.extractors.helper.WcoHelper.access$getNewKeys$cp()
                if (r0 != 0) goto Lc3
                com.lagradost.cloudstream3.utils.Extensions$RequestCustom r0 = com.lagradost.cloudstream3.MainActivityKt.getApp()
                r3 = r0
                com.lagradost.nicehttp.Requests r3 = (com.lagradost.nicehttp.Requests) r3
                r5 = 0
                r6 = 0
                r7 = 0
                r8 = 0
                r9 = 0
                r10 = 0
                r11 = 0
                r12 = 0
                r14 = 0
                r0 = 0
                r17 = 2046(0x7fe, float:2.867E-42)
                r18 = 0
                r1.label = r4
                java.lang.String r4 = "https://raw.githubusercontent.com/chekaslowakiya/BruhFlow/main/keys.json"
                r19 = r15
                r15 = r0
                r16 = r1
                java.lang.Object r0 = com.lagradost.nicehttp.Requests.get$default(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r14, r15, r16, r17, r18)
                r1 = r19
                if (r0 != r1) goto L69
                return r1
            L69:
                com.lagradost.nicehttp.NiceResponse r0 = (com.lagradost.nicehttp.NiceResponse) r0
                r1 = 0
                com.lagradost.nicehttp.Requests$Companion r3 = com.lagradost.nicehttp.Requests.Companion     // Catch: java.lang.Exception -> L82
                com.fasterxml.jackson.databind.ObjectMapper r3 = r3.getMapper()     // Catch: java.lang.Exception -> L82
                java.lang.String r0 = r0.getText()     // Catch: java.lang.Exception -> L82
                com.lagradost.cloudstream3.extractors.helper.WcoHelper$Companion$getNewKeys$$inlined$parsedSafe$1 r4 = new com.lagradost.cloudstream3.extractors.helper.WcoHelper$Companion$getNewKeys$$inlined$parsedSafe$1     // Catch: java.lang.Exception -> L82
                r4.<init>()     // Catch: java.lang.Exception -> L82
                com.fasterxml.jackson.core.type.TypeReference r4 = (com.fasterxml.jackson.core.type.TypeReference) r4     // Catch: java.lang.Exception -> L82
                java.lang.Object r0 = r3.readValue(r0, r4)     // Catch: java.lang.Exception -> L82
                goto L87
            L82:
                r0 = move-exception
                r0.printStackTrace()
                r0 = r1
            L87:
                com.lagradost.cloudstream3.extractors.helper.WcoHelper$Companion$NewExternalKeys r0 = (com.lagradost.cloudstream3.extractors.helper.WcoHelper.Companion.NewExternalKeys) r0
                java.lang.String r3 = "github_keys_backup"
                if (r0 == 0) goto L93
                com.lagradost.cloudstream3.AcraApplication$Companion r4 = com.lagradost.cloudstream3.AcraApplication.Companion
                r4.setKey(r3, r0)
                goto L94
            L93:
                r0 = r1
            L94:
                if (r0 != 0) goto Lc3
                com.lagradost.cloudstream3.AcraApplication$Companion r0 = com.lagradost.cloudstream3.AcraApplication.Companion
                android.content.Context r0 = r0.getContext()
                if (r0 == 0) goto Lc0
                com.lagradost.cloudstream3.utils.DataStore r4 = com.lagradost.cloudstream3.utils.DataStore.INSTANCE
                android.content.SharedPreferences r0 = r4.getSharedPrefs(r0)     // Catch: java.lang.Exception -> Lc0
                java.lang.String r0 = r0.getString(r3, r1)     // Catch: java.lang.Exception -> Lc0
                if (r0 != 0) goto Lab
                goto Lc0
            Lab:
                java.lang.String r3 = "getSharedPrefs().getStri…h, null) ?: return defVal"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r3)     // Catch: java.lang.Exception -> Lc0
                com.fasterxml.jackson.databind.json.JsonMapper r3 = r4.getMapper()     // Catch: java.lang.Exception -> Lc0
                java.lang.Class<com.lagradost.cloudstream3.extractors.helper.WcoHelper$Companion$NewExternalKeys> r4 = com.lagradost.cloudstream3.extractors.helper.WcoHelper.Companion.NewExternalKeys.class
                java.lang.Object r0 = r3.readValue(r0, r4)     // Catch: java.lang.Exception -> Lc0
                java.lang.String r3 = "mapper.readValue(this, T::class.java)"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r3)     // Catch: java.lang.Exception -> Lc0
                r1 = r0
            Lc0:
                r0 = r1
                com.lagradost.cloudstream3.extractors.helper.WcoHelper$Companion$NewExternalKeys r0 = (com.lagradost.cloudstream3.extractors.helper.WcoHelper.Companion.NewExternalKeys) r0
            Lc3:
                com.lagradost.cloudstream3.extractors.helper.WcoHelper.access$setNewKeys$cp(r0)
                kotlin.Unit r0 = kotlin.Unit.INSTANCE
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.lagradost.cloudstream3.extractors.helper.WcoHelper.Companion.getNewKeys(kotlin.coroutines.Continuation):java.lang.Object");
        }

        /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
        /* JADX WARN: Removed duplicated region for block: B:14:0x0032  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object getNewWcoKey(kotlin.coroutines.Continuation<? super com.lagradost.cloudstream3.extractors.helper.WcoHelper.Companion.NewExternalKeys> r5) {
            /*
                r4 = this;
                boolean r0 = r5 instanceof com.lagradost.cloudstream3.extractors.helper.WcoHelper$Companion$getNewWcoKey$1
                if (r0 == 0) goto L14
                r0 = r5
                com.lagradost.cloudstream3.extractors.helper.WcoHelper$Companion$getNewWcoKey$1 r0 = (com.lagradost.cloudstream3.extractors.helper.WcoHelper$Companion$getNewWcoKey$1) r0
                int r1 = r0.label
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r1 = r1 & r2
                if (r1 == 0) goto L14
                int r5 = r0.label
                int r5 = r5 - r2
                r0.label = r5
                goto L19
            L14:
                com.lagradost.cloudstream3.extractors.helper.WcoHelper$Companion$getNewWcoKey$1 r0 = new com.lagradost.cloudstream3.extractors.helper.WcoHelper$Companion$getNewWcoKey$1
                r0.<init>(r4, r5)
            L19:
                java.lang.Object r5 = r0.result
                java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r2 = r0.label
                r3 = 1
                if (r2 == 0) goto L32
                if (r2 != r3) goto L2a
                kotlin.ResultKt.throwOnFailure(r5)
                goto L3e
            L2a:
                java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r5.<init>(r0)
                throw r5
            L32:
                kotlin.ResultKt.throwOnFailure(r5)
                r0.label = r3
                java.lang.Object r5 = r4.getNewKeys(r0)
                if (r5 != r1) goto L3e
                return r1
            L3e:
                com.lagradost.cloudstream3.extractors.helper.WcoHelper$Companion$NewExternalKeys r5 = com.lagradost.cloudstream3.extractors.helper.WcoHelper.access$getNewKeys$cp()
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: com.lagradost.cloudstream3.extractors.helper.WcoHelper.Companion.getNewWcoKey(kotlin.coroutines.Continuation):java.lang.Object");
        }
    }
}
