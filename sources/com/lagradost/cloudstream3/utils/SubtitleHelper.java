package com.lagradost.cloudstream3.utils;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.tvprovider.media.p009tv.TvContractCompat;
import com.facebook.appevents.UserDataStore;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.google.android.gms.cast.HlsSegmentFormat;
import com.lagradost.cloudstream3.mvvm.ArchComponentExt;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SubtitleHelper.kt */
@Metadata(m108d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u001dB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0012\u001a\u00020\u0005J\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0015J\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0012\u001a\u00020\u0005J\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0012\u001a\u00020\u0005J\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0012\u001a\u00020\u0005J\u0012\u0010\u0019\u001a\u0004\u0018\u00010\u00052\b\u0010\u001a\u001a\u0004\u0018\u00010\u0005J\b\u0010\u001b\u001a\u00020\u001cH\u0002R\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u001e"}, m107d2 = {"Lcom/lagradost/cloudstream3/utils/SubtitleHelper;", "", "()V", "ISO_639_1Map", "Ljava/util/HashMap;", "", "asciiOffset", "", "flagOffset", "flags", "", "languages", "", "Lcom/lagradost/cloudstream3/utils/SubtitleHelper$Language639;", "getLanguages", "()Ljava/util/List;", TypedValues.CycleType.S_WAVE_OFFSET, "fromLanguageToThreeLetters", TvContractCompat.PARAM_INPUT, "fromLanguageToTwoLetters", "looseCheck", "", "fromThreeLettersToLanguage", "fromTwoLettersToLanguage", "fromTwoLettersToThreeLetters", "getFlagFromIso", "inp", "initISO6391Map", "", "Language639", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
/* loaded from: classes4.dex */
public final class SubtitleHelper {
    private static final int asciiOffset = 65;
    private static final int flagOffset = 127462;
    private static final int offset = 127397;
    public static final SubtitleHelper INSTANCE = new SubtitleHelper();
    private static HashMap<String, String> ISO_639_1Map = new HashMap<>();
    private static final Map<String, String> flags = MapsKt.mapOf(TuplesKt.m100to("af", "ZA"), TuplesKt.m100to("agq", "CM"), TuplesKt.m100to("ak", "GH"), TuplesKt.m100to("am", "ET"), TuplesKt.m100to("ar", "AE"), TuplesKt.m100to("as", "IN"), TuplesKt.m100to("asa", "TZ"), TuplesKt.m100to("az", "AZ"), TuplesKt.m100to("bas", "CM"), TuplesKt.m100to("be", "BY"), TuplesKt.m100to("bem", "ZM"), TuplesKt.m100to("bez", "IT"), TuplesKt.m100to("bg", "BG"), TuplesKt.m100to("bm", "ML"), TuplesKt.m100to("bn", "BD"), TuplesKt.m100to("bo", "CN"), TuplesKt.m100to(TtmlNode.TAG_BR, "FR"), TuplesKt.m100to("brx", "IN"), TuplesKt.m100to("bs", "BA"), TuplesKt.m100to("ca", "ES"), TuplesKt.m100to("cgg", "UG"), TuplesKt.m100to("chr", "US"), TuplesKt.m100to("cs", "CZ"), TuplesKt.m100to("cy", "GB"), TuplesKt.m100to("da", "DK"), TuplesKt.m100to("dav", "KE"), TuplesKt.m100to("de", "DE"), TuplesKt.m100to("dje", "NE"), TuplesKt.m100to("dua", "CM"), TuplesKt.m100to("dyo", "SN"), TuplesKt.m100to("ebu", "KE"), TuplesKt.m100to("ee", "GH"), TuplesKt.m100to("en", "GB"), TuplesKt.m100to("el", "GR"), TuplesKt.m100to("es", "ES"), TuplesKt.m100to("et", "EE"), TuplesKt.m100to("eu", "ES"), TuplesKt.m100to("ewo", "CM"), TuplesKt.m100to("fa", "IR"), TuplesKt.m100to("fil", "PH"), TuplesKt.m100to("fr", "FR"), TuplesKt.m100to("ga", "IE"), TuplesKt.m100to("gl", "ES"), TuplesKt.m100to("gsw", "CH"), TuplesKt.m100to("gu", "IN"), TuplesKt.m100to("guz", "KE"), TuplesKt.m100to("gv", "GB"), TuplesKt.m100to("ha", "NG"), TuplesKt.m100to("haw", "US"), TuplesKt.m100to("he", "IL"), TuplesKt.m100to("hi", "IN"), TuplesKt.m100to("ff", "CN"), TuplesKt.m100to("fi", "FI"), TuplesKt.m100to("fo", "FO"), TuplesKt.m100to("hr", "HR"), TuplesKt.m100to("hu", "HU"), TuplesKt.m100to("hy", "AM"), TuplesKt.m100to("id", "ID"), TuplesKt.m100to("ig", "NG"), TuplesKt.m100to("ii", "CN"), TuplesKt.m100to("is", "IS"), TuplesKt.m100to("it", "IT"), TuplesKt.m100to("ita", "IT"), TuplesKt.m100to("ja", "JP"), TuplesKt.m100to("jmc", "TZ"), TuplesKt.m100to("ka", "GE"), TuplesKt.m100to("kab", "DZ"), TuplesKt.m100to("ki", "KE"), TuplesKt.m100to("kam", "KE"), TuplesKt.m100to("mer", "KE"), TuplesKt.m100to("kde", "TZ"), TuplesKt.m100to("kea", "CV"), TuplesKt.m100to("khq", "ML"), TuplesKt.m100to("kk", "KZ"), TuplesKt.m100to("kl", "GL"), TuplesKt.m100to("kln", "KE"), TuplesKt.m100to("km", "KH"), TuplesKt.m100to("kn", "IN"), TuplesKt.m100to("ko", "KR"), TuplesKt.m100to("kok", "IN"), TuplesKt.m100to("ksb", "TZ"), TuplesKt.m100to("ksf", "CM"), TuplesKt.m100to("kw", "GB"), TuplesKt.m100to("lag", "TZ"), TuplesKt.m100to("lg", "UG"), TuplesKt.m100to(UserDataStore.LAST_NAME, "CG"), TuplesKt.m100to("lt", "LT"), TuplesKt.m100to("lu", "CD"), TuplesKt.m100to("lv", "LV"), TuplesKt.m100to("lat", "LV"), TuplesKt.m100to("luo", "KE"), TuplesKt.m100to("luy", "KE"), TuplesKt.m100to("mas", "TZ"), TuplesKt.m100to("mfe", "MU"), TuplesKt.m100to("mg", "MG"), TuplesKt.m100to("mgh", "MZ"), TuplesKt.m100to("ml", "IN"), TuplesKt.m100to("mk", "MK"), TuplesKt.m100to("mr", "IN"), TuplesKt.m100to("ms", "MY"), TuplesKt.m100to("mt", "MT"), TuplesKt.m100to("mua", "CM"), TuplesKt.m100to("my", "MM"), TuplesKt.m100to("naq", "NA"), TuplesKt.m100to("nb", "NO"), TuplesKt.m100to("no", "NO"), TuplesKt.m100to("nn", "NO"), TuplesKt.m100to("nd", "ZW"), TuplesKt.m100to("ne", "NP"), TuplesKt.m100to("nl", "NL"), TuplesKt.m100to("nmg", "CM"), TuplesKt.m100to("nus", "SD"), TuplesKt.m100to("nyn", "UG"), TuplesKt.m100to("om", "ET"), TuplesKt.m100to("or", "IN"), TuplesKt.m100to("pa", "PK"), TuplesKt.m100to("pl", "PL"), TuplesKt.m100to("ps", "AF"), TuplesKt.m100to("pt", "PT"), TuplesKt.m100to("rm", "CH"), TuplesKt.m100to("rn", "BI"), TuplesKt.m100to("ro", "RO"), TuplesKt.m100to("ru", "RU"), TuplesKt.m100to("rw", "RW"), TuplesKt.m100to("rof", "TZ"), TuplesKt.m100to("rwk", "TZ"), TuplesKt.m100to("saq", "KE"), TuplesKt.m100to("sbp", "TZ"), TuplesKt.m100to("seh", "MZ"), TuplesKt.m100to("ses", "ML"), TuplesKt.m100to("sg", "CF"), TuplesKt.m100to("shi", "MA"), TuplesKt.m100to("si", "LK"), TuplesKt.m100to("sk", "SK"), TuplesKt.m100to("sl", "SI"), TuplesKt.m100to("sn", "ZW"), TuplesKt.m100to("so", "SO"), TuplesKt.m100to("sq", "AL"), TuplesKt.m100to("sr", "RS"), TuplesKt.m100to("sv", "SE"), TuplesKt.m100to("sw", "TZ"), TuplesKt.m100to("swc", "CD"), TuplesKt.m100to("ta", "IN"), TuplesKt.m100to("te", "IN"), TuplesKt.m100to("teo", "UG"), TuplesKt.m100to("th", "TH"), TuplesKt.m100to("ti", "ET"), TuplesKt.m100to("to", "TO"), TuplesKt.m100to("tr", "TR"), TuplesKt.m100to("twq", "NE"), TuplesKt.m100to("tzm", "MA"), TuplesKt.m100to("uk", "UA"), TuplesKt.m100to("ur", "PK"), TuplesKt.m100to("uz", "UZ"), TuplesKt.m100to("vai", "LR"), TuplesKt.m100to("vi", "VN"), TuplesKt.m100to("vun", "TZ"), TuplesKt.m100to("xog", "UG"), TuplesKt.m100to("yav", "CM"), TuplesKt.m100to("yo", "NG"), TuplesKt.m100to("zh", "CN"), TuplesKt.m100to("zu", "ZA"), TuplesKt.m100to("tl", "PH"));
    private static final List<Language639> languages = CollectionsKt.listOf((Object[]) new Language639[]{new Language639("Abkhaz", "аҧсуа бызшәа, аҧсшәа", "ab", "abk", "abk", "abk", "abks"), new Language639("Afar", "Afaraf", "aa", "aar", "aar", "aar", "aars"), new Language639("Afrikaans", "Afrikaans", "af", "afr", "afr", "afr", "afrs"), new Language639("Akan", "Akan", "ak", "aka", "aka", "aka", ""), new Language639("Albanian", "Shqip", "sq", "sqi", "", "sqi", ""), new Language639("Amharic", "አማርኛ", "am", "amh", "amh", "amh", ""), new Language639("Arabic", "العربية", "ar", "ara", "ara", "ara", ""), new Language639("Aragonese", "aragonés", "an", "arg", "arg", "arg", ""), new Language639("Armenian", "Հայերեն", "hy", "hye", "", "hye", ""), new Language639("Assamese", "অসমীয়া", "as", "asm", "asm", "asm", ""), new Language639("Avaric", "авар мацӀ, магӀарул мацӀ", "av", "ava", "ava", "ava", ""), new Language639("Avestan", "avesta", "ae", "ave", "ave", "ave", ""), new Language639("Aymara", "aymar aru", "ay", "aym", "aym", "aym", ""), new Language639("Azerbaijani", "azərbaycan dili", "az", "aze", "aze", "aze", ""), new Language639("Bambara", "bamanankan", "bm", "bam", "bam", "bam", ""), new Language639("Bashkir", "башҡорт теле", "ba", "bak", "bak", "bak", ""), new Language639("Basque", "euskara, euskera", "eu", "eus", "", "eus", ""), new Language639("Belarusian", "беларуская мова", "be", "bel", "bel", "bel", ""), new Language639("Bengali", "বাংলা", "bn", "ben", "ben", "ben", ""), new Language639("Bihari", "भोजपुरी", "bh", "bih", "bih", "", ""), new Language639("Bislama", "Bislama", "bi", "bis", "bis", "bis", ""), new Language639("Bosnian", "bosanski jezik", "bs", "bos", "bos", "bos", "boss"), new Language639("Breton", "brezhoneg", TtmlNode.TAG_BR, "bre", "bre", "bre", ""), new Language639("Bulgarian", "български език", "bg", "bul", "bul", "bul", "buls"), new Language639("Burmese", "ဗမာစာ", "my", "mya", "", "mya", ""), new Language639("Catalan", "català", "ca", "cat", "cat", "cat", ""), new Language639("Chamorro", "Chamoru", "ch", "cha", "cha", "cha", ""), new Language639("Chechen", "нохчийн мотт", "ce", "che", "che", "che", ""), new Language639("Chichewa", "chiCheŵa, chinyanja", "ny", "nya", "nya", "nya", ""), new Language639("Chinese", "中文 (Zhōngwén), 汉语, 漢語", "zh", "zho", "", "zho", ""), new Language639("Chuvash", "чӑваш чӗлхи", "cv", "chv", "chv", "chv", ""), new Language639("Cornish", "Kernewek", "kw", "cor", "cor", "cor", ""), new Language639("Corsican", "corsu, lingua corsa", "co", "cos", "cos", "cos", ""), new Language639("Cree", "ᓀᐦᐃᔭᐍᐏᐣ", "cr", "cre", "cre", "cre", ""), new Language639("Croatian", "hrvatski jezik", "hr", "hrv", "hrv", "hrv", ""), new Language639("Czech", "čeština, český jazyk", "cs", "ces", "", "ces", ""), new Language639("Danish", "dansk", "da", "dan", "dan", "dan", ""), new Language639("Divehi", "ދިވެހި", "dv", TtmlNode.TAG_DIV, TtmlNode.TAG_DIV, TtmlNode.TAG_DIV, ""), new Language639("Dutch", "Nederlands, Vlaams", "nl", "nld", "", "nld", ""), new Language639("Dzongkha", "རྫོང་ཁ", "dz", "dzo", "dzo", "dzo", ""), new Language639("English", "English", "en", "eng", "eng", "eng", "engs"), new Language639("Esperanto", "Esperanto", "eo", "epo", "epo", "epo", ""), new Language639("Estonian", "eesti, eesti keel", "et", "est", "est", "est", ""), new Language639("Ewe", "Eʋegbe", "ee", "ewe", "ewe", "ewe", ""), new Language639("Faroese", "føroyskt", "fo", "fao", "fao", "fao", ""), new Language639("Fijian", "vosa Vakaviti", "fj", "fij", "fij", "fij", ""), new Language639("Finnish", "suomi, suomen kieli", "fi", "fin", "fin", "fin", ""), new Language639("French", "français, langue française", "fr", "fra", "", "fra", "fras"), new Language639("Fula", "Fulfulde, Pulaar, Pular", "ff", "ful", "ful", "ful", ""), new Language639("Galician", "galego", "gl", "glg", "glg", "glg", ""), new Language639("Georgian", "ქართული", "ka", "kat", "", "kat", ""), new Language639("German", "Deutsch", "de", "deu", "", "deu", "deus"), new Language639("Greek", "ελληνικά", "el", "ell", "", "ell", "ells"), new Language639("Guaraní", "Avañe'ẽ", "gn", "grn", "grn", "grn", ""), new Language639("Gujarati", "ગુજરાતી", "gu", "guj", "guj", "guj", ""), new Language639("Haitian", "Kreyòl ayisyen", "ht", "hat", "hat", "hat", ""), new Language639("Hausa", "(Hausa) هَوُسَ", "ha", "hau", "hau", "hau", ""), new Language639("Hebrew", "עברית", "he", "heb", "heb", "heb", ""), new Language639("Herero", "Otjiherero", "hz", "her", "her", "her", ""), new Language639("Hindi", "हिन्दी, हिंदी", "hi", "hin", "hin", "hin", "hins"), new Language639("Hiri Motu", "Hiri Motu", "ho", "hmo", "hmo", "hmo", ""), new Language639("Hungarian", "magyar", "hu", "hun", "hun", "hun", ""), new Language639("Interlingua", "Interlingua", "ia", "ina", "ina", "ina", ""), new Language639("Indonesian", "Bahasa Indonesia", "id", "ind", "ind", "ind", ""), new Language639("Interlingue", "Originally called Occidental; then Interlingue after WWII", "ie", "ile", "ile", "ile", ""), new Language639("Irish", "Gaeilge", "ga", "gle", "gle", "gle", ""), new Language639("Igbo", "Asụsụ Igbo", "ig", "ibo", "ibo", "ibo", ""), new Language639("Inupiaq", "Iñupiaq, Iñupiatun", "ik", "ipk", "ipk", "ipk", ""), new Language639("Ido", "Ido", "io", "ido", "ido", "ido", "idos"), new Language639("Icelandic", "Íslenska", "is", "isl", "", "isl", ""), new Language639("Italian", "italiano", "it", "ita", "ita", "ita", "itas"), new Language639("Inuktitut", "ᐃᓄᒃᑎᑐᑦ", "iu", "iku", "iku", "iku", ""), new Language639("Japanese", "日本語 (にほんご)", "ja", "jpn", "jpn", "jpn", ""), new Language639("Javanese", "ꦧꦱꦗꦮ", "jv", "jav", "jav", "jav", ""), new Language639("Kalaallisut", "kalaallisut, kalaallit oqaasii", "kl", "kal", "kal", "kal", ""), new Language639("Kannada", "ಕನ್ನಡ", "kn", "kan", "kan", "kan", ""), new Language639("Kanuri", "Kanuri", "kr", "kau", "kau", "kau", ""), new Language639("Kashmiri", "कश्मीरी, كشميري\u200e", "ks", "kas", "kas", "kas", ""), new Language639("Kazakh", "қазақ тілі", "kk", "kaz", "kaz", "kaz", ""), new Language639("Khmer", "ខ្មែរ, ខេមរភាសា, ភាសាខ្មែរ", "km", "khm", "khm", "khm", ""), new Language639("Kikuyu", "Gĩkũyũ", "ki", "kik", "kik", "kik", ""), new Language639("Kinyarwanda", "Ikinyarwanda", "rw", "kin", "kin", "kin", ""), new Language639("Kyrgyz", "Кыргызча, Кыргыз тили", "ky", "kir", "kir", "kir", ""), new Language639("Komi", "коми кыв", "kv", "kom", "kom", "kom", ""), new Language639("Kongo", "Kikongo", "kg", "kon", "kon", "kon", ""), new Language639("Korean", "한국어, 조선어", "ko", "kor", "kor", "kor", ""), new Language639("Kurdish", "Kurdî, كوردی\u200e", "ku", "kur", "kur", "kur", ""), new Language639("Kwanyama", "Kuanyama", "kj", "kua", "kua", "kua", ""), new Language639("Latin", "latine, lingua latina", "la", "lat", "lat", "lat", "lats"), new Language639("Luxembourgish", "Lëtzebuergesch", "lb", "ltz", "ltz", "ltz", ""), new Language639("Ganda", "Luganda", "lg", "lug", "lug", "lug", ""), new Language639("Limburgish", "Limburgs", "li", "lim", "lim", "lim", ""), new Language639("Lingala", "Lingála", UserDataStore.LAST_NAME, "lin", "lin", "lin", ""), new Language639("Lao", "ພາສາລາວ", "lo", "lao", "lao", "lao", ""), new Language639("Lithuanian", "lietuvių kalba", "lt", "lit", "lit", "lit", ""), new Language639("Luba-Katanga", "Tshiluba", "lu", "lub", "lub", "lub", ""), new Language639("Latvian", "latviešu valoda", "lv", "lav", "lav", "lav", ""), new Language639("Manx", "Gaelg, Gailck", "gv", "glv", "glv", "glv", ""), new Language639("Macedonian", "македонски јазик", "mk", "mkd", "", "mkd", ""), new Language639("Malagasy", "fiteny malagasy", "mg", "mlg", "mlg", "mlg", ""), new Language639("Malay", "bahasa Melayu, بهاس ملايو\u200e", "ms", "msa", "", "msa", ""), new Language639("Malayalam", "മലയാളം", "ml", "mal", "mal", "mal", ""), new Language639("Maltese", "Malti", "mt", "mlt", "mlt", "mlt", ""), new Language639("Māori", "te reo Māori", "mi", "mri", "", "mri", ""), new Language639("Marathi", "मराठी", "mr", "mar", "mar", "mar", ""), new Language639("Marshallese", "Kajin M̧ajeļ", "mh", "mah", "mah", "mah", ""), new Language639("Mongolian", "Монгол хэл", "mn", "mon", "mon", "mon", ""), new Language639("Nauruan", "Dorerin Naoero", "na", "nau", "nau", "nau", ""), new Language639("Navajo", "Diné bizaad", "nv", "nav", "nav", "nav", ""), new Language639("Northern Ndebele", "isiNdebele", "nd", "nde", "nde", "nde", ""), new Language639("Nepali", "नेपाली", "ne", "nep", "nep", "nep", ""), new Language639("Ndonga", "Owambo", "ng", "ndo", "ndo", "ndo", ""), new Language639("Norwegian Bokmål", "Norsk bokmål", "nb", "nob", "nob", "nob", ""), new Language639("Norwegian Nynorsk", "Norsk nynorsk", "nn", "nno", "nno", "nno", ""), new Language639("Norwegian", "Norsk", "no", "nor", "nor", "nor", ""), new Language639("Nuosu", "ꆈꌠ꒿ Nuosuhxop", "ii", "iii", "iii", "iii", ""), new Language639("Southern Ndebele", "isiNdebele", "nr", "nbl", "nbl", "nbl", ""), new Language639("Occitan", "occitan, lenga d'òc", "oc", "oci", "oci", "oci", ""), new Language639("Ojibwe", "ᐊᓂᔑᓈᐯᒧᐎᓐ", "oj", "oji", "oji", "oji", ""), new Language639("Old Church Slavonic", "ѩзыкъ словѣньскъ", "cu", "chu", "chu", "chu", ""), new Language639("Oromo", "Afaan Oromoo", "om", "orm", "orm", "orm", ""), new Language639("Oriya", "ଓଡ଼ିଆ", "or", "ori", "ori", "ori", ""), new Language639("Ossetian", "ирон æвзаг", "os", "oss", "oss", "oss", ""), new Language639("Panjabi", "ਪੰਜਾਬੀ, پنجابی\u200e", "pa", "pan", "pan", "pan", ""), new Language639("Pāli", "पाऴि", "pi", "pli", "pli", "pli", ""), new Language639("Persian", "فارسی", "fa", "fas", "", "fas", ""), new Language639("Polish", "język polski, polszczyzna", "pl", "pol", "pol", "pol", "pols"), new Language639("Pashto", "پښتو", "ps", "pus", "pus", "pus", ""), new Language639("Portuguese", "português", "pt", "por", "por", "por", ""), new Language639("Quechua", "Runa Simi, Kichwa", "qu", "que", "que", "que", ""), new Language639("Romansh", "rumantsch grischun", "rm", "roh", "roh", "roh", ""), new Language639("Kirundi", "Ikirundi", "rn", "run", "run", "run", ""), new Language639("Reunion Creole", "Kréol Rénioné", "rc", "rcf", "rcf", "rcf", ""), new Language639("Romanian", "limba română", "ro", "ron", "", "ron", ""), new Language639("Russian", "Русский", "ru", "rus", "rus", "rus", ""), new Language639("Sanskrit", "संस्कृतम्", "sa", "san", "san", "san", ""), new Language639("Sardinian", "sardu", "sc", "srd", "srd", "srd", ""), new Language639("Sindhi", "सिन्धी, سنڌي، سندھی\u200e", "sd", "snd", "snd", "snd", ""), new Language639("Northern Sami", "Davvisámegiella", "se", "sme", "sme", "sme", ""), new Language639("Samoan", "gagana fa'a Samoa", "sm", "smo", "smo", "smo", ""), new Language639("Sango", "yângâ tî sängö", "sg", "sag", "sag", "sag", ""), new Language639("Serbian", "српски језик", "sr", "srp", "srp", "srp", ""), new Language639("Scottish Gaelic", "Gàidhlig", "gd", "gla", "gla", "gla", ""), new Language639("Shona", "chiShona", "sn", "sna", "sna", "sna", ""), new Language639("Sinhalese", "සිංහල", "si", "sin", "sin", "sin", ""), new Language639("Slovak", "slovenčina, slovenský jazyk", "sk", "slk", "", "slk", ""), new Language639("Slovene", "slovenski jezik, slovenščina", "sl", "slv", "slv", "slv", ""), new Language639("Somali", "Soomaaliga, af Soomaali", "so", "som", "som", "som", ""), new Language639("Southern Sotho", "Sesotho", UserDataStore.STATE, "sot", "sot", "sot", ""), new Language639("Spanish", "español", "es", "spa", "spa", "spa", ""), new Language639("Sundanese", "Basa Sunda", "su", "sun", "sun", "sun", ""), new Language639("Swahili", "Kiswahili", "sw", "swa", "swa", "swa", ""), new Language639("Swati", "SiSwati", "ss", "ssw", "ssw", "ssw", ""), new Language639("Swedish", "svenska", "sv", "swe", "swe", "swe", ""), new Language639("Tamil", "தமிழ்", "ta", "tam", "tam", "tam", ""), new Language639("Telugu", "తెలుగు", "te", "tel", "tel", "tel", ""), new Language639("Tajik", "тоҷикӣ, toçikī, تاجیکی\u200e", "tg", "tgk", "tgk", "tgk", ""), new Language639("Thai", "ไทย", "th", "tha", "tha", "tha", ""), new Language639("Tigrinya", "ትግርኛ", "ti", "tir", "tir", "tir", ""), new Language639("Tibetan Standard", "བོད་ཡིག", "bo", "bod", "", "bod", ""), new Language639("Turkmen", "Türkmen, Түркмен", "tk", "tuk", "tuk", "tuk", ""), new Language639("Tagalog", "Wikang Tagalog", "tl", "tgl", "tgl", "tgl", ""), new Language639("Tswana", "Setswana", "tn", "tsn", "tsn", "tsn", ""), new Language639("Tonga", "faka Tonga", "to", "ton", "ton", "ton", ""), new Language639("Turkish", "Türkçe", "tr", "tur", "tur", "tur", ""), new Language639("Tsonga", "Xitsonga", HlsSegmentFormat.f9702TS, "tso", "tso", "tso", ""), new Language639("Tatar", "татар теле, tatar tele", TtmlNode.TAG_TT, "tat", "tat", "tat", ""), new Language639("Twi", "Twi", "tw", "twi", "twi", "twi", ""), new Language639("Tahitian", "Reo Tahiti", "ty", "tah", "tah", "tah", ""), new Language639("Uyghur", "ئۇيغۇرچە\u200e, Uyghurche", "ug", "uig", "uig", "uig", ""), new Language639("Ukrainian", "Українська", "uk", "ukr", "ukr", "ukr", ""), new Language639("Urdu", "اردو", "ur", "urd", "urd", "urd", ""), new Language639("Uzbek", "Oʻzbek, Ўзбек, أۇزبېك\u200e", "uz", "uzb", "uzb", "uzb", ""), new Language639("Venda", "Tshivenḓa", "ve", "ven", "ven", "ven", ""), new Language639("Vietnamese", "Tiếng Việt", "vi", "vie", "vie", "vie", ""), new Language639("Volapük", "Volapük", "vo", "vol", "vol", "vol", ""), new Language639("Walloon", "walon", "wa", "wln", "wln", "wln", ""), new Language639("Welsh", "Cymraeg", "cy", "cym", "", "cym", ""), new Language639("Wolof", "Wollof", "wo", "wol", "wol", "wol", ""), new Language639("Western Frisian", "Frysk", "fy", "fry", "fry", "fry", ""), new Language639("Xhosa", "isiXhosa", "xh", "xho", "xho", "xho", ""), new Language639("Yiddish", "ייִדיש", "yi", "yid", "yid", "yid", ""), new Language639("Yoruba", "Yorùbá", "yo", "yor", "yor", "yor", ""), new Language639("Zhuang", "Saɯ cueŋƅ, Saw cuengh", "za", "zha", "zha", "zha", ""), new Language639("Zulu", "isiZulu", "zu", "zul", "zul", "zul", "")});

    /* compiled from: SubtitleHelper.kt */
    @Metadata(m108d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003¢\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003JO\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J\t\u0010 \u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\f¨\u0006!"}, m107d2 = {"Lcom/lagradost/cloudstream3/utils/SubtitleHelper$Language639;", "", "languageName", "", "nativeName", "ISO_639_1", "ISO_639_2_T", "ISO_639_2_B", "ISO_639_3", "ISO_639_6", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getISO_639_1", "()Ljava/lang/String;", "getISO_639_2_B", "getISO_639_2_T", "getISO_639_3", "getISO_639_6", "getLanguageName", "getNativeName", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* loaded from: classes4.dex */
    public static final class Language639 {
        private final String ISO_639_1;
        private final String ISO_639_2_B;
        private final String ISO_639_2_T;
        private final String ISO_639_3;
        private final String ISO_639_6;
        private final String languageName;
        private final String nativeName;

        public static /* synthetic */ Language639 copy$default(Language639 language639, String str, String str2, String str3, String str4, String str5, String str6, String str7, int i, Object obj) {
            if ((i & 1) != 0) {
                str = language639.languageName;
            }
            if ((i & 2) != 0) {
                str2 = language639.nativeName;
            }
            String str8 = str2;
            if ((i & 4) != 0) {
                str3 = language639.ISO_639_1;
            }
            String str9 = str3;
            if ((i & 8) != 0) {
                str4 = language639.ISO_639_2_T;
            }
            String str10 = str4;
            if ((i & 16) != 0) {
                str5 = language639.ISO_639_2_B;
            }
            String str11 = str5;
            if ((i & 32) != 0) {
                str6 = language639.ISO_639_3;
            }
            String str12 = str6;
            if ((i & 64) != 0) {
                str7 = language639.ISO_639_6;
            }
            return language639.copy(str, str8, str9, str10, str11, str12, str7);
        }

        public final String component1() {
            return this.languageName;
        }

        public final String component2() {
            return this.nativeName;
        }

        public final String component3() {
            return this.ISO_639_1;
        }

        public final String component4() {
            return this.ISO_639_2_T;
        }

        public final String component5() {
            return this.ISO_639_2_B;
        }

        public final String component6() {
            return this.ISO_639_3;
        }

        public final String component7() {
            return this.ISO_639_6;
        }

        public final Language639 copy(String languageName, String nativeName, String ISO_639_1, String ISO_639_2_T, String ISO_639_2_B, String ISO_639_3, String ISO_639_6) {
            Intrinsics.checkNotNullParameter(languageName, "languageName");
            Intrinsics.checkNotNullParameter(nativeName, "nativeName");
            Intrinsics.checkNotNullParameter(ISO_639_1, "ISO_639_1");
            Intrinsics.checkNotNullParameter(ISO_639_2_T, "ISO_639_2_T");
            Intrinsics.checkNotNullParameter(ISO_639_2_B, "ISO_639_2_B");
            Intrinsics.checkNotNullParameter(ISO_639_3, "ISO_639_3");
            Intrinsics.checkNotNullParameter(ISO_639_6, "ISO_639_6");
            return new Language639(languageName, nativeName, ISO_639_1, ISO_639_2_T, ISO_639_2_B, ISO_639_3, ISO_639_6);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Language639) {
                Language639 language639 = (Language639) obj;
                return Intrinsics.areEqual(this.languageName, language639.languageName) && Intrinsics.areEqual(this.nativeName, language639.nativeName) && Intrinsics.areEqual(this.ISO_639_1, language639.ISO_639_1) && Intrinsics.areEqual(this.ISO_639_2_T, language639.ISO_639_2_T) && Intrinsics.areEqual(this.ISO_639_2_B, language639.ISO_639_2_B) && Intrinsics.areEqual(this.ISO_639_3, language639.ISO_639_3) && Intrinsics.areEqual(this.ISO_639_6, language639.ISO_639_6);
            }
            return false;
        }

        public int hashCode() {
            return (((((((((((this.languageName.hashCode() * 31) + this.nativeName.hashCode()) * 31) + this.ISO_639_1.hashCode()) * 31) + this.ISO_639_2_T.hashCode()) * 31) + this.ISO_639_2_B.hashCode()) * 31) + this.ISO_639_3.hashCode()) * 31) + this.ISO_639_6.hashCode();
        }

        public String toString() {
            return "Language639(languageName=" + this.languageName + ", nativeName=" + this.nativeName + ", ISO_639_1=" + this.ISO_639_1 + ", ISO_639_2_T=" + this.ISO_639_2_T + ", ISO_639_2_B=" + this.ISO_639_2_B + ", ISO_639_3=" + this.ISO_639_3 + ", ISO_639_6=" + this.ISO_639_6 + ')';
        }

        public Language639(String languageName, String nativeName, String ISO_639_1, String ISO_639_2_T, String ISO_639_2_B, String ISO_639_3, String ISO_639_6) {
            Intrinsics.checkNotNullParameter(languageName, "languageName");
            Intrinsics.checkNotNullParameter(nativeName, "nativeName");
            Intrinsics.checkNotNullParameter(ISO_639_1, "ISO_639_1");
            Intrinsics.checkNotNullParameter(ISO_639_2_T, "ISO_639_2_T");
            Intrinsics.checkNotNullParameter(ISO_639_2_B, "ISO_639_2_B");
            Intrinsics.checkNotNullParameter(ISO_639_3, "ISO_639_3");
            Intrinsics.checkNotNullParameter(ISO_639_6, "ISO_639_6");
            this.languageName = languageName;
            this.nativeName = nativeName;
            this.ISO_639_1 = ISO_639_1;
            this.ISO_639_2_T = ISO_639_2_T;
            this.ISO_639_2_B = ISO_639_2_B;
            this.ISO_639_3 = ISO_639_3;
            this.ISO_639_6 = ISO_639_6;
        }

        public final String getLanguageName() {
            return this.languageName;
        }

        public final String getNativeName() {
            return this.nativeName;
        }

        public final String getISO_639_1() {
            return this.ISO_639_1;
        }

        public final String getISO_639_2_T() {
            return this.ISO_639_2_T;
        }

        public final String getISO_639_2_B() {
            return this.ISO_639_2_B;
        }

        public final String getISO_639_3() {
            return this.ISO_639_3;
        }

        public final String getISO_639_6() {
            return this.ISO_639_6;
        }
    }

    private SubtitleHelper() {
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:5:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.String fromLanguageToTwoLetters(java.lang.String r5, boolean r6) {
        /*
            r4 = this;
            java.lang.String r0 = "input"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            java.util.List<com.lagradost.cloudstream3.utils.SubtitleHelper$Language639> r0 = com.lagradost.cloudstream3.utils.SubtitleHelper.languages
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.Iterator r0 = r0.iterator()
        Ld:
            boolean r1 = r0.hasNext()
            r2 = 1
            if (r1 == 0) goto L33
            java.lang.Object r1 = r0.next()
            com.lagradost.cloudstream3.utils.SubtitleHelper$Language639 r1 = (com.lagradost.cloudstream3.utils.SubtitleHelper.Language639) r1
            java.lang.String r3 = r1.getLanguageName()
            boolean r3 = kotlin.text.StringsKt.equals(r3, r5, r2)
            if (r3 != 0) goto L2e
            java.lang.String r3 = r1.getNativeName()
            boolean r2 = kotlin.text.StringsKt.equals(r3, r5, r2)
            if (r2 == 0) goto Ld
        L2e:
            java.lang.String r5 = r1.getISO_639_1()
            return r5
        L33:
            if (r6 == 0) goto L69
            java.util.List<com.lagradost.cloudstream3.utils.SubtitleHelper$Language639> r6 = com.lagradost.cloudstream3.utils.SubtitleHelper.languages
            java.lang.Iterable r6 = (java.lang.Iterable) r6
            java.util.Iterator r6 = r6.iterator()
        L3d:
            boolean r0 = r6.hasNext()
            if (r0 == 0) goto L69
            java.lang.Object r0 = r6.next()
            com.lagradost.cloudstream3.utils.SubtitleHelper$Language639 r0 = (com.lagradost.cloudstream3.utils.SubtitleHelper.Language639) r0
            r1 = r5
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            java.lang.String r3 = r0.getLanguageName()
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            boolean r3 = kotlin.text.StringsKt.contains(r1, r3, r2)
            if (r3 != 0) goto L64
            java.lang.String r3 = r0.getNativeName()
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            boolean r1 = kotlin.text.StringsKt.contains(r1, r3, r2)
            if (r1 == 0) goto L3d
        L64:
            java.lang.String r5 = r0.getISO_639_1()
            return r5
        L69:
            r5 = 0
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lagradost.cloudstream3.utils.SubtitleHelper.fromLanguageToTwoLetters(java.lang.String, boolean):java.lang.String");
    }

    private final void initISO6391Map() {
        for (Language639 language639 : languages) {
            ISO_639_1Map.put(language639.getISO_639_1(), language639.getLanguageName());
        }
    }

    public final String fromTwoLettersToLanguage(String input) {
        Intrinsics.checkNotNullParameter(input, "input");
        if (input.length() != 2) {
            return null;
        }
        if (ISO_639_1Map.isEmpty()) {
            initISO6391Map();
        }
        Locale ROOT = Locale.ROOT;
        Intrinsics.checkNotNullExpressionValue(ROOT, "ROOT");
        String lowerCase = input.toLowerCase(ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(locale)");
        return ISO_639_1Map.get(lowerCase);
    }

    public final String fromTwoLettersToThreeLetters(String input) {
        Intrinsics.checkNotNullParameter(input, "input");
        if (input.length() != 2) {
            return null;
        }
        Locale ROOT = Locale.ROOT;
        Intrinsics.checkNotNullExpressionValue(ROOT, "ROOT");
        String lowerCase = input.toLowerCase(ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(locale)");
        for (Language639 language639 : languages) {
            if (Intrinsics.areEqual(language639.getISO_639_1(), lowerCase)) {
                return language639.getISO_639_2_T();
            }
        }
        return null;
    }

    public final String fromThreeLettersToLanguage(String input) {
        Intrinsics.checkNotNullParameter(input, "input");
        if (input.length() != 3) {
            return null;
        }
        Locale ROOT = Locale.ROOT;
        Intrinsics.checkNotNullExpressionValue(ROOT, "ROOT");
        String lowerCase = input.toLowerCase(ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(locale)");
        for (Language639 language639 : languages) {
            if (Intrinsics.areEqual(language639.getISO_639_2_B(), lowerCase)) {
                return language639.getLanguageName();
            }
        }
        for (Language639 language6392 : languages) {
            if (Intrinsics.areEqual(language6392.getISO_639_2_T(), lowerCase)) {
                return language6392.getLanguageName();
            }
        }
        for (Language639 language6393 : languages) {
            if (Intrinsics.areEqual(language6393.getISO_639_3(), lowerCase)) {
                return language6393.getLanguageName();
            }
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:5:0x0011  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.String fromLanguageToThreeLetters(java.lang.String r4) {
        /*
            r3 = this;
            java.lang.String r0 = "input"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            java.util.List<com.lagradost.cloudstream3.utils.SubtitleHelper$Language639> r0 = com.lagradost.cloudstream3.utils.SubtitleHelper.languages
            java.util.Iterator r0 = r0.iterator()
        Lb:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L30
            java.lang.Object r1 = r0.next()
            com.lagradost.cloudstream3.utils.SubtitleHelper$Language639 r1 = (com.lagradost.cloudstream3.utils.SubtitleHelper.Language639) r1
            java.lang.String r2 = r1.getLanguageName()
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual(r2, r4)
            if (r2 != 0) goto L2b
            java.lang.String r2 = r1.getNativeName()
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual(r2, r4)
            if (r2 == 0) goto Lb
        L2b:
            java.lang.String r4 = r1.getISO_639_2_T()
            return r4
        L30:
            r4 = 0
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lagradost.cloudstream3.utils.SubtitleHelper.fromLanguageToThreeLetters(java.lang.String):java.lang.String");
    }

    public final String getFlagFromIso(String str) {
        String str2;
        try {
            Map<String, String> map = flags;
            if (str == null || (str2 = map.get(str)) == null) {
                return null;
            }
            int codePointAt = Character.codePointAt(str2, 0) + offset;
            int codePointAt2 = Character.codePointAt(str2, 1) + offset;
            StringBuilder sb = new StringBuilder();
            char[] chars = Character.toChars(codePointAt);
            Intrinsics.checkNotNullExpressionValue(chars, "toChars(firstChar)");
            sb.append(new String(chars));
            char[] chars2 = Character.toChars(codePointAt2);
            Intrinsics.checkNotNullExpressionValue(chars2, "toChars(secondChar)");
            sb.append(new String(chars2));
            return sb.toString();
        } catch (Exception e) {
            ArchComponentExt.logError(e);
            return null;
        }
    }

    public final List<Language639> getLanguages() {
        return languages;
    }
}
