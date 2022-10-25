package khttp.structures.authorization;

import java.nio.charset.Charset;
import java.util.Base64;
import kotlin.Metadata;
import kotlin.Tuples;
import kotlin.TuplesKt;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* compiled from: BasicAuthorization.kt */
@Metadata(m109bv = {1, 0, 3}, m108d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001R \u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000b¨\u0006\u0017"}, m107d2 = {"Lkhttp/structures/authorization/BasicAuthorization;", "Lkhttp/structures/authorization/Authorization;", "user", "", "password", "(Ljava/lang/String;Ljava/lang/String;)V", "header", "Lkotlin/Pair;", "getHeader", "()Lkotlin/Pair;", "getPassword", "()Ljava/lang/String;", "getUser", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "library_release"}, m106k = 1, m105mv = {1, 1, 13})
/* loaded from: classes4.dex */
public final class BasicAuthorization implements Authorization {
    private final String password;
    private final String user;

    public static /* synthetic */ BasicAuthorization copy$default(BasicAuthorization basicAuthorization, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = basicAuthorization.user;
        }
        if ((i & 2) != 0) {
            str2 = basicAuthorization.password;
        }
        return basicAuthorization.copy(str, str2);
    }

    public final String component1() {
        return this.user;
    }

    public final String component2() {
        return this.password;
    }

    public final BasicAuthorization copy(String user, String password) {
        Intrinsics.checkParameterIsNotNull(user, "user");
        Intrinsics.checkParameterIsNotNull(password, "password");
        return new BasicAuthorization(user, password);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof BasicAuthorization) {
                BasicAuthorization basicAuthorization = (BasicAuthorization) obj;
                return Intrinsics.areEqual(this.user, basicAuthorization.user) && Intrinsics.areEqual(this.password, basicAuthorization.password);
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        String str = this.user;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.password;
        return hashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        return "BasicAuthorization(user=" + this.user + ", password=" + this.password + ")";
    }

    public BasicAuthorization(String user, String password) {
        Intrinsics.checkParameterIsNotNull(user, "user");
        Intrinsics.checkParameterIsNotNull(password, "password");
        this.user = user;
        this.password = password;
    }

    public final String getPassword() {
        return this.password;
    }

    public final String getUser() {
        return this.user;
    }

    @Override // khttp.structures.authorization.Authorization
    public Tuples<String, String> getHeader() {
        Base64.Encoder encoder = Base64.getEncoder();
        String str = this.user + ':' + this.password;
        Charset charset = Charsets.UTF_8;
        if (str == null) {
            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
        }
        byte[] bytes = str.getBytes(charset);
        Intrinsics.checkExpressionValueIsNotNull(bytes, "(this as java.lang.String).getBytes(charset)");
        byte[] encode = encoder.encode(bytes);
        Intrinsics.checkExpressionValueIsNotNull(encode, "Base64.getEncoder().enco…password}\".toByteArray())");
        return TuplesKt.m100to("Authorization", "Basic " + new String(encode, Charsets.UTF_8));
    }
}
