package at.huber.youtubeExtractor;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.util.SparseArray;
import at.huber.youtubeExtractor.Format;
import com.evgenii.jsevaluator.JsEvaluator;
import com.evgenii.jsevaluator.interfaces.JsCallback;
import com.google.ads.interactivemedia.p034v3.internal.bqk;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.ref.WeakReference;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLDecoder;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public abstract class YouTubeExtractor extends AsyncTask<String, Void, SparseArray<YtFile>> {
    private static final String CACHE_FILE_NAME = "decipher_js_funct";
    static boolean CACHING = true;
    private static final SparseArray<Format> FORMAT_MAP;
    static boolean LOGGING = false;
    private static final String LOG_TAG = "YouTubeExtractor";
    private static final String USER_AGENT = "Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/97.0.4692.98 Safari/537.36";
    private static String decipherFunctionName;
    private static String decipherFunctions;
    private static String decipherJsFileName;
    private final String cacheDirPath;
    private volatile String decipheredSignature;
    private final Condition jsExecuting;
    private final Lock lock;
    private final WeakReference<Context> refContext;
    private String videoID;
    private VideoMeta videoMeta;
    private static final Pattern patYouTubePageLink = Pattern.compile("(http|https)://(www\\.|m.|)youtube\\.com/watch\\?v=(.+?)( |\\z|&)");
    private static final Pattern patYouTubeShortLink = Pattern.compile("(http|https)://(www\\.|)youtu.be/(.+?)( |\\z|&)");
    private static final Pattern patPlayerResponse = Pattern.compile("var ytInitialPlayerResponse\\s*=\\s*(\\{.+?\\})\\s*;");
    private static final Pattern patSigEncUrl = Pattern.compile("url=(.+?)(\\u0026|$)");
    private static final Pattern patSignature = Pattern.compile("s=(.+?)(\\u0026|$)");
    private static final Pattern patVariableFunction = Pattern.compile("([{; =])([a-zA-Z$][a-zA-Z0-9$]{0,2})\\.([a-zA-Z$][a-zA-Z0-9$]{0,2})\\(");
    private static final Pattern patFunction = Pattern.compile("([{; =])([a-zA-Z$_][a-zA-Z0-9$]{0,2})\\(");
    private static final Pattern patDecryptionJsFile = Pattern.compile("\\\\/s\\\\/player\\\\/([^\"]+?)\\.js");
    private static final Pattern patDecryptionJsFileWithoutSlash = Pattern.compile("/s/player/([^\"]+?).js");
    private static final Pattern patSignatureDecFunction = Pattern.compile("(?:\\b|[^a-zA-Z0-9$])([a-zA-Z0-9$]{1,4})\\s*=\\s*function\\(\\s*a\\s*\\)\\s*\\{\\s*a\\s*=\\s*a\\.split\\(\\s*\"\"\\s*\\)");

    protected abstract void onExtractionComplete(SparseArray<YtFile> sparseArray, VideoMeta videoMeta);

    public void setDefaultHttpProtocol(boolean z) {
    }

    public void setIncludeWebM(boolean z) {
    }

    public void setParseDashManifest(boolean z) {
    }

    static {
        SparseArray<Format> sparseArray = new SparseArray<>();
        FORMAT_MAP = sparseArray;
        sparseArray.put(17, new Format(17, "3gp", 144, Format.VCodec.MPEG4, Format.ACodec.AAC, 24, false));
        sparseArray.put(36, new Format(36, "3gp", 240, Format.VCodec.MPEG4, Format.ACodec.AAC, 32, false));
        sparseArray.put(5, new Format(5, "flv", 240, Format.VCodec.H263, Format.ACodec.MP3, 64, false));
        sparseArray.put(43, new Format(43, "webm", 360, Format.VCodec.VP8, Format.ACodec.VORBIS, 128, false));
        sparseArray.put(18, new Format(18, "mp4", 360, Format.VCodec.H264, Format.ACodec.AAC, 96, false));
        sparseArray.put(22, new Format(22, "mp4", 720, Format.VCodec.H264, Format.ACodec.AAC, 192, false));
        sparseArray.put(160, new Format(160, "mp4", 144, Format.VCodec.H264, Format.ACodec.NONE, true));
        sparseArray.put(133, new Format(133, "mp4", 240, Format.VCodec.H264, Format.ACodec.NONE, true));
        sparseArray.put(134, new Format(134, "mp4", 360, Format.VCodec.H264, Format.ACodec.NONE, true));
        sparseArray.put(135, new Format(135, "mp4", 480, Format.VCodec.H264, Format.ACodec.NONE, true));
        sparseArray.put(136, new Format(136, "mp4", 720, Format.VCodec.H264, Format.ACodec.NONE, true));
        sparseArray.put(137, new Format(137, "mp4", 1080, Format.VCodec.H264, Format.ACodec.NONE, true));
        sparseArray.put(264, new Format(264, "mp4", 1440, Format.VCodec.H264, Format.ACodec.NONE, true));
        sparseArray.put(bqk.f6569bc, new Format((int) bqk.f6569bc, "mp4", 2160, Format.VCodec.H264, Format.ACodec.NONE, true));
        sparseArray.put(298, new Format(298, "mp4", 720, Format.VCodec.H264, 60, Format.ACodec.NONE, true));
        sparseArray.put(299, new Format(299, "mp4", 1080, Format.VCodec.H264, 60, Format.ACodec.NONE, true));
        sparseArray.put(140, new Format(140, "m4a", Format.VCodec.NONE, Format.ACodec.AAC, 128, true));
        sparseArray.put(141, new Format(141, "m4a", Format.VCodec.NONE, Format.ACodec.AAC, 256, true));
        sparseArray.put(256, new Format(256, "m4a", Format.VCodec.NONE, Format.ACodec.AAC, 192, true));
        sparseArray.put(258, new Format(258, "m4a", Format.VCodec.NONE, Format.ACodec.AAC, 384, true));
        sparseArray.put(bqk.f6536aw, new Format((int) bqk.f6536aw, "webm", 144, Format.VCodec.VP9, Format.ACodec.NONE, true));
        sparseArray.put(bqk.f6541bA, new Format((int) bqk.f6541bA, "webm", 240, Format.VCodec.VP9, Format.ACodec.NONE, true));
        sparseArray.put(243, new Format(243, "webm", 360, Format.VCodec.VP9, Format.ACodec.NONE, true));
        sparseArray.put(244, new Format(244, "webm", 480, Format.VCodec.VP9, Format.ACodec.NONE, true));
        sparseArray.put(bqk.f6594ca, new Format((int) bqk.f6594ca, "webm", 720, Format.VCodec.VP9, Format.ACodec.NONE, true));
        sparseArray.put(bqk.f6595cb, new Format((int) bqk.f6595cb, "webm", 1080, Format.VCodec.VP9, Format.ACodec.NONE, true));
        sparseArray.put(bqk.f6531ar, new Format((int) bqk.f6531ar, "webm", 1440, Format.VCodec.VP9, Format.ACodec.NONE, true));
        sparseArray.put(313, new Format(313, "webm", 2160, Format.VCodec.VP9, Format.ACodec.NONE, true));
        sparseArray.put(302, new Format(302, "webm", 720, Format.VCodec.VP9, 60, Format.ACodec.NONE, true));
        sparseArray.put(308, new Format(308, "webm", 1440, Format.VCodec.VP9, 60, Format.ACodec.NONE, true));
        sparseArray.put(303, new Format(303, "webm", 1080, Format.VCodec.VP9, 60, Format.ACodec.NONE, true));
        sparseArray.put(315, new Format(315, "webm", 2160, Format.VCodec.VP9, 60, Format.ACodec.NONE, true));
        sparseArray.put(171, new Format(171, "webm", Format.VCodec.NONE, Format.ACodec.VORBIS, 128, true));
        sparseArray.put(249, new Format(249, "webm", Format.VCodec.NONE, Format.ACodec.OPUS, 48, true));
        sparseArray.put(250, new Format(250, "webm", Format.VCodec.NONE, Format.ACodec.OPUS, 64, true));
        sparseArray.put(bqk.f6602ci, new Format((int) bqk.f6602ci, "webm", Format.VCodec.NONE, Format.ACodec.OPUS, 160, true));
        sparseArray.put(91, new Format(91, "mp4", 144, Format.VCodec.H264, Format.ACodec.AAC, 48, false, true));
        sparseArray.put(92, new Format(92, "mp4", 240, Format.VCodec.H264, Format.ACodec.AAC, 48, false, true));
        sparseArray.put(93, new Format(93, "mp4", 360, Format.VCodec.H264, Format.ACodec.AAC, 128, false, true));
        sparseArray.put(94, new Format(94, "mp4", 480, Format.VCodec.H264, Format.ACodec.AAC, 128, false, true));
        sparseArray.put(95, new Format(95, "mp4", 720, Format.VCodec.H264, Format.ACodec.AAC, 256, false, true));
        sparseArray.put(96, new Format(96, "mp4", 1080, Format.VCodec.H264, Format.ACodec.AAC, 256, false, true));
    }

    public YouTubeExtractor(Context context) {
        ReentrantLock reentrantLock = new ReentrantLock();
        this.lock = reentrantLock;
        this.jsExecuting = reentrantLock.newCondition();
        this.refContext = new WeakReference<>(context);
        this.cacheDirPath = context.getCacheDir().getAbsolutePath();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    public void onPostExecute(SparseArray<YtFile> sparseArray) {
        onExtractionComplete(sparseArray, this.videoMeta);
    }

    public void extract(String str, boolean z, boolean z2) {
        execute(str);
    }

    public void extract(String str) {
        execute(str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    public SparseArray<YtFile> doInBackground(String... strArr) {
        this.videoID = null;
        String str = strArr[0];
        if (str == null) {
            return null;
        }
        Matcher matcher = patYouTubePageLink.matcher(str);
        if (matcher.find()) {
            this.videoID = matcher.group(3);
        } else {
            Matcher matcher2 = patYouTubeShortLink.matcher(str);
            if (matcher2.find()) {
                this.videoID = matcher2.group(3);
            } else if (str.matches("\\p{Graph}+?")) {
                this.videoID = str;
            }
        }
        if (this.videoID != null) {
            try {
                return getStreamUrls();
            } catch (Exception e) {
                Log.e(LOG_TAG, "Extraction failed", e);
            }
        } else {
            Log.e(LOG_TAG, "Wrong YouTube link format");
        }
        return null;
    }

    private SparseArray<YtFile> getStreamUrls() throws IOException, InterruptedException, JSONException {
        HttpURLConnection httpURLConnection;
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        JSONArray jSONArray;
        String str7;
        String str8;
        SparseArray<String> sparseArray = new SparseArray<>();
        SparseArray<YtFile> sparseArray2 = new SparseArray<>();
        try {
            httpURLConnection = (HttpURLConnection) new URL("https://youtube.com/watch?v=" + this.videoID).openConnection();
            try {
                httpURLConnection.setRequestProperty("User-Agent", USER_AGENT);
                bufferedReader2 = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
            } catch (Throwable th) {
                th = th;
                bufferedReader = null;
            }
        } catch (Throwable th2) {
            th = th2;
            httpURLConnection = null;
            bufferedReader = null;
        }
        try {
            StringBuilder sb = new StringBuilder();
            while (true) {
                String readLine = bufferedReader2.readLine();
                if (readLine == null) {
                    break;
                }
                sb.append(readLine);
            }
            String sb2 = sb.toString();
            bufferedReader2.close();
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
            Matcher matcher = patPlayerResponse.matcher(sb2);
            boolean find = matcher.find();
            String str9 = LOG_TAG;
            if (find) {
                JSONObject jSONObject = new JSONObject(matcher.group(1));
                JSONObject jSONObject2 = jSONObject.getJSONObject("streamingData");
                JSONArray jSONArray2 = jSONObject2.getJSONArray("formats");
                int i = 0;
                while (true) {
                    str4 = "itag";
                    str = sb2;
                    str5 = "url";
                    str6 = str9;
                    if (i >= jSONArray2.length()) {
                        break;
                    }
                    JSONObject jSONObject3 = jSONArray2.getJSONObject(i);
                    String optString = jSONObject3.optString("type");
                    if (optString == null || !optString.equals("FORMAT_STREAM_TYPE_OTF")) {
                        int i2 = jSONObject3.getInt("itag");
                        SparseArray<Format> sparseArray3 = FORMAT_MAP;
                        if (sparseArray3.get(i2) != null) {
                            if (jSONObject3.has("url")) {
                                sparseArray2.append(i2, new YtFile(sparseArray3.get(i2), jSONObject3.getString("url").replace("\\u0026", "&")));
                            } else if (jSONObject3.has("signatureCipher")) {
                                Matcher matcher2 = patSigEncUrl.matcher(jSONObject3.getString("signatureCipher"));
                                Matcher matcher3 = patSignature.matcher(jSONObject3.getString("signatureCipher"));
                                if (matcher2.find() && matcher3.find()) {
                                    String decode = URLDecoder.decode(matcher2.group(1), "UTF-8");
                                    String decode2 = URLDecoder.decode(matcher3.group(1), "UTF-8");
                                    sparseArray2.append(i2, new YtFile(sparseArray3.get(i2), decode));
                                    sparseArray.append(i2, decode2);
                                }
                            }
                        }
                    }
                    i++;
                    sb2 = str;
                    str9 = str6;
                }
                JSONArray jSONArray3 = jSONObject2.getJSONArray("adaptiveFormats");
                int i3 = 0;
                while (i3 < jSONArray3.length()) {
                    JSONObject jSONObject4 = jSONArray3.getJSONObject(i3);
                    String optString2 = jSONObject4.optString("type");
                    if (optString2 == null || !optString2.equals("FORMAT_STREAM_TYPE_OTF")) {
                        int i4 = jSONObject4.getInt(str4);
                        jSONArray = jSONArray3;
                        SparseArray<Format> sparseArray4 = FORMAT_MAP;
                        if (sparseArray4.get(i4) != null) {
                            if (jSONObject4.has(str5)) {
                                str7 = str4;
                                sparseArray2.append(i4, new YtFile(sparseArray4.get(i4), jSONObject4.getString(str5).replace("\\u0026", "&")));
                            } else {
                                str7 = str4;
                                if (jSONObject4.has("signatureCipher")) {
                                    str8 = str5;
                                    Matcher matcher4 = patSigEncUrl.matcher(jSONObject4.getString("signatureCipher"));
                                    Matcher matcher5 = patSignature.matcher(jSONObject4.getString("signatureCipher"));
                                    if (matcher4.find() && matcher5.find()) {
                                        String decode3 = URLDecoder.decode(matcher4.group(1), "UTF-8");
                                        String decode4 = URLDecoder.decode(matcher5.group(1), "UTF-8");
                                        sparseArray2.append(i4, new YtFile(sparseArray4.get(i4), decode3));
                                        sparseArray.append(i4, decode4);
                                    }
                                    i3++;
                                    jSONArray3 = jSONArray;
                                    str4 = str7;
                                    str5 = str8;
                                }
                            }
                            str8 = str5;
                            i3++;
                            jSONArray3 = jSONArray;
                            str4 = str7;
                            str5 = str8;
                        }
                    } else {
                        jSONArray = jSONArray3;
                    }
                    str7 = str4;
                    str8 = str5;
                    i3++;
                    jSONArray3 = jSONArray;
                    str4 = str7;
                    str5 = str8;
                }
                JSONObject jSONObject5 = jSONObject.getJSONObject("videoDetails");
                this.videoMeta = new VideoMeta(jSONObject5.getString("videoId"), jSONObject5.getString("title"), jSONObject5.getString("author"), jSONObject5.getString("channelId"), Long.parseLong(jSONObject5.getString("lengthSeconds")), Long.parseLong(jSONObject5.getString("viewCount")), jSONObject5.getBoolean("isLiveContent"), jSONObject5.getString("shortDescription"));
                str2 = str6;
            } else {
                str = sb2;
                str2 = LOG_TAG;
                Log.d(str2, "ytPlayerResponse was not found");
            }
            if (sparseArray.size() > 0) {
                if (CACHING && (decipherJsFileName == null || decipherFunctions == null || decipherFunctionName == null)) {
                    readDecipherFunctFromCache();
                }
                str3 = str;
                Matcher matcher6 = patDecryptionJsFile.matcher(str3);
                if (!matcher6.find()) {
                    matcher6 = patDecryptionJsFileWithoutSlash.matcher(str3);
                }
                if (matcher6.find()) {
                    String replace = matcher6.group(0).replace("\\/", "/");
                    String str10 = decipherJsFileName;
                    if (str10 == null || !str10.equals(replace)) {
                        decipherFunctions = null;
                        decipherFunctionName = null;
                    }
                    decipherJsFileName = replace;
                }
                if (LOGGING) {
                    Log.d(str2, "Decipher signatures: " + sparseArray.size() + ", videos: " + sparseArray2.size());
                }
                this.decipheredSignature = null;
                if (decipherSignature(sparseArray)) {
                    this.lock.lock();
                    try {
                        this.jsExecuting.await(7L, TimeUnit.SECONDS);
                    } finally {
                        this.lock.unlock();
                    }
                }
                String str11 = this.decipheredSignature;
                if (str11 == null) {
                    return null;
                }
                String[] split = str11.split("\n");
                for (int i5 = 0; i5 < sparseArray.size() && i5 < split.length; i5++) {
                    int keyAt = sparseArray.keyAt(i5);
                    sparseArray2.put(keyAt, new YtFile(FORMAT_MAP.get(keyAt), sparseArray2.get(keyAt).getUrl() + "&sig=" + split[i5]));
                }
            } else {
                str3 = str;
            }
            if (sparseArray2.size() == 0) {
                if (LOGGING) {
                    Log.d(str2, str3);
                }
                return null;
            }
            return sparseArray2;
        } catch (Throwable th3) {
            th = th3;
            bufferedReader = bufferedReader2;
            if (bufferedReader != null) {
                bufferedReader.close();
            }
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
            throw th;
        }
    }

    private boolean decipherSignature(SparseArray<String> sparseArray) throws IOException {
        BufferedReader bufferedReader;
        String str;
        int indexOf;
        if (decipherFunctionName == null || decipherFunctions == null) {
            String str2 = "https://youtube.com" + decipherJsFileName;
            BufferedReader bufferedReader2 = null;
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str2).openConnection();
            httpURLConnection.setRequestProperty("User-Agent", USER_AGENT);
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
            } catch (Throwable th) {
                th = th;
            }
            try {
                StringBuilder sb = new StringBuilder();
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    sb.append(readLine);
                    sb.append(" ");
                }
                String sb2 = sb.toString();
                bufferedReader.close();
                httpURLConnection.disconnect();
                if (LOGGING) {
                    Log.d(LOG_TAG, "Decipher FunctURL: " + str2);
                }
                Matcher matcher = patSignatureDecFunction.matcher(sb2);
                if (!matcher.find()) {
                    return false;
                }
                decipherFunctionName = matcher.group(1);
                if (LOGGING) {
                    Log.d(LOG_TAG, "Decipher Functname: " + decipherFunctionName);
                }
                Matcher matcher2 = Pattern.compile("(var |\\s|,|;)" + decipherFunctionName.replace("$", "\\$") + "(=function\\((.{1,3})\\)\\{)").matcher(sb2);
                if (matcher2.find()) {
                    str = "var " + decipherFunctionName + matcher2.group(2);
                } else {
                    matcher2 = Pattern.compile("function " + decipherFunctionName.replace("$", "\\$") + "(\\((.{1,3})\\)\\{)").matcher(sb2);
                    if (!matcher2.find()) {
                        return false;
                    }
                    str = "function " + decipherFunctionName + matcher2.group(2);
                }
                int end = matcher2.end();
                int i = end;
                int i2 = 1;
                while (true) {
                    if (i < sb2.length()) {
                        if (i2 == 0 && end + 5 < i) {
                            str = str + sb2.substring(end, i) + ";";
                            break;
                        }
                        if (sb2.charAt(i) == '{') {
                            i2++;
                        } else if (sb2.charAt(i) == '}') {
                            i2--;
                        }
                        i++;
                    } else {
                        break;
                    }
                }
                decipherFunctions = str;
                Matcher matcher3 = patVariableFunction.matcher(str);
                while (matcher3.find()) {
                    String str3 = "var " + matcher3.group(2) + "={";
                    if (!decipherFunctions.contains(str3)) {
                        int indexOf2 = sb2.indexOf(str3) + str3.length();
                        int i3 = 1;
                        while (true) {
                            if (indexOf2 >= sb2.length()) {
                                break;
                            } else if (i3 == 0) {
                                decipherFunctions += str3 + sb2.substring(indexOf, indexOf2) + ";";
                                break;
                            } else {
                                if (sb2.charAt(indexOf2) == '{') {
                                    i3++;
                                } else if (sb2.charAt(indexOf2) == '}') {
                                    i3--;
                                }
                                indexOf2++;
                            }
                        }
                    }
                }
                Matcher matcher4 = patFunction.matcher(str);
                while (matcher4.find()) {
                    String str4 = "function " + matcher4.group(2) + "(";
                    if (!decipherFunctions.contains(str4)) {
                        int indexOf3 = sb2.indexOf(str4) + str4.length();
                        int i4 = indexOf3;
                        int i5 = 0;
                        while (true) {
                            if (i4 < sb2.length()) {
                                if (i5 == 0 && indexOf3 + 5 < i4) {
                                    decipherFunctions += str4 + sb2.substring(indexOf3, i4) + ";";
                                    break;
                                }
                                if (sb2.charAt(i4) == '{') {
                                    i5++;
                                } else if (sb2.charAt(i4) == '}') {
                                    i5--;
                                }
                                i4++;
                            } else {
                                break;
                            }
                        }
                    }
                }
                if (LOGGING) {
                    Log.d(LOG_TAG, "Decipher Function: " + decipherFunctions);
                }
                decipherViaWebView(sparseArray);
                if (CACHING) {
                    writeDeciperFunctToChache();
                }
            } catch (Throwable th2) {
                th = th2;
                bufferedReader2 = bufferedReader;
                if (bufferedReader2 != null) {
                    bufferedReader2.close();
                }
                httpURLConnection.disconnect();
                throw th;
            }
        } else {
            decipherViaWebView(sparseArray);
        }
        return true;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x006e -> B:31:0x007d). Please submit an issue!!! */
    private void readDecipherFunctFromCache() {
        File file = new File(this.cacheDirPath + "/" + CACHE_FILE_NAME);
        if (!file.exists() || System.currentTimeMillis() - file.lastModified() >= 1209600000) {
            return;
        }
        BufferedReader bufferedReader = null;
        try {
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            try {
                BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"));
                try {
                    decipherJsFileName = bufferedReader2.readLine();
                    decipherFunctionName = bufferedReader2.readLine();
                    decipherFunctions = bufferedReader2.readLine();
                    bufferedReader2.close();
                } catch (Exception e2) {
                    e = e2;
                    bufferedReader = bufferedReader2;
                    e.printStackTrace();
                    if (bufferedReader != null) {
                        bufferedReader.close();
                    }
                } catch (Throwable th) {
                    th = th;
                    bufferedReader = bufferedReader2;
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (IOException e3) {
                            e3.printStackTrace();
                        }
                    }
                    throw th;
                }
            } catch (Exception e4) {
                e = e4;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private void writeDeciperFunctToChache() {
        File file = new File(this.cacheDirPath + "/" + CACHE_FILE_NAME);
        BufferedWriter bufferedWriter = null;
        try {
            try {
                try {
                    BufferedWriter bufferedWriter2 = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), "UTF-8"));
                    try {
                        bufferedWriter2.write(decipherJsFileName + "\n");
                        bufferedWriter2.write(decipherFunctionName + "\n");
                        bufferedWriter2.write(decipherFunctions);
                        bufferedWriter2.close();
                    } catch (Exception e) {
                        e = e;
                        bufferedWriter = bufferedWriter2;
                        e.printStackTrace();
                        if (bufferedWriter != null) {
                            bufferedWriter.close();
                        }
                    } catch (Throwable th) {
                        th = th;
                        bufferedWriter = bufferedWriter2;
                        if (bufferedWriter != null) {
                            try {
                                bufferedWriter.close();
                            } catch (IOException e2) {
                                e2.printStackTrace();
                            }
                        }
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Exception e3) {
                e = e3;
            }
        } catch (IOException e4) {
            e4.printStackTrace();
        }
    }

    private void decipherViaWebView(SparseArray<String> sparseArray) {
        final Context context = this.refContext.get();
        if (context == null) {
            return;
        }
        final StringBuilder sb = new StringBuilder(decipherFunctions + " function decipher(");
        sb.append("){return ");
        for (int i = 0; i < sparseArray.size(); i++) {
            int keyAt = sparseArray.keyAt(i);
            if (i < sparseArray.size() - 1) {
                sb.append(decipherFunctionName);
                sb.append("('");
                sb.append(sparseArray.get(keyAt));
                sb.append("')+\"\\n\"+");
            } else {
                sb.append(decipherFunctionName);
                sb.append("('");
                sb.append(sparseArray.get(keyAt));
                sb.append("')");
            }
        }
        sb.append("};decipher();");
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: at.huber.youtubeExtractor.YouTubeExtractor.1
            @Override // java.lang.Runnable
            public void run() {
                new JsEvaluator(context).evaluate(sb.toString(), new JsCallback() { // from class: at.huber.youtubeExtractor.YouTubeExtractor.1.1
                    @Override // com.evgenii.jsevaluator.interfaces.JsCallback
                    public void onResult(String str) {
                        YouTubeExtractor.this.lock.lock();
                        try {
                            YouTubeExtractor.this.decipheredSignature = str;
                            YouTubeExtractor.this.jsExecuting.signal();
                        } finally {
                            YouTubeExtractor.this.lock.unlock();
                        }
                    }

                    @Override // com.evgenii.jsevaluator.interfaces.JsCallback
                    public void onError(String str) {
                        YouTubeExtractor.this.lock.lock();
                        try {
                            if (YouTubeExtractor.LOGGING) {
                                Log.e(YouTubeExtractor.LOG_TAG, str);
                            }
                            YouTubeExtractor.this.jsExecuting.signal();
                        } finally {
                            YouTubeExtractor.this.lock.unlock();
                        }
                    }
                });
            }
        });
    }
}
