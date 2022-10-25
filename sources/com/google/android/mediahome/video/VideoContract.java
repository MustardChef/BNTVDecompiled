package com.google.android.mediahome.video;

import android.content.ContentUris;
import android.net.Uri;
import android.provider.BaseColumns;
import android.text.TextUtils;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/* compiled from: com.google.android.mediahome:video@@1.0.0 */
/* loaded from: classes3.dex */
public final class VideoContract {
    public static final String ACTION_INITIALIZE_PROGRAMS = "com.google.android.mediahome.action.INITIALIZE_PROGRAMS";
    public static final String AUTHORITY = "com.google.android.mediahome.video";
    static final String PARAM_CHANNEL = "channel";

    /* compiled from: com.google.android.mediahome:video@@1.0.0 */
    /* loaded from: classes3.dex */
    public interface BaseVideoColumns extends BaseColumns {
        public static final String COLUMN_PACKAGE_NAME = "package_name";
    }

    /* compiled from: com.google.android.mediahome:video@@1.0.0 */
    /* loaded from: classes3.dex */
    public static final class PreviewChannels implements BaseVideoColumns {
        public static final String COLUMN_APP_LINK_ICON_URI = "app_link_icon_uri";
        public static final String COLUMN_APP_LINK_INTENT_URI = "app_link_intent_uri";
        public static final String COLUMN_APP_LINK_TEXT = "app_link_text";
        public static final String COLUMN_DESCRIPTION = "description";
        public static final String COLUMN_DISPLAY_NAME = "display_name";
        public static final String COLUMN_INTERNAL_PROVIDER_DATA = "internal_provider_data";
        public static final String COLUMN_INTERNAL_PROVIDER_FLAG1 = "internal_provider_flag1";
        public static final String COLUMN_INTERNAL_PROVIDER_FLAG2 = "internal_provider_flag2";
        public static final String COLUMN_INTERNAL_PROVIDER_FLAG3 = "internal_provider_flag3";
        public static final String COLUMN_INTERNAL_PROVIDER_FLAG4 = "internal_provider_flag4";
        public static final String COLUMN_INTERNAL_PROVIDER_ID = "internal_provider_id";
        public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/channel";
        public static final String CONTENT_TYPE = "vnd.android.cursor.dir/channel";
        public static final Uri CONTENT_URI = Uri.parse("content://com.google.android.mediahome.video/channel");

        private PreviewChannels() {
        }
    }

    /* compiled from: com.google.android.mediahome:video@@1.0.0 */
    /* loaded from: classes3.dex */
    public interface PreviewProgramColumns {
        public static final int ASPECT_RATIO_16_9 = 0;
        public static final int ASPECT_RATIO_1_1 = 3;
        public static final int ASPECT_RATIO_2_3 = 4;
        public static final int ASPECT_RATIO_3_2 = 1;
        public static final int ASPECT_RATIO_4_3 = 2;
        public static final int ASPECT_RATIO_MOVIE_POSTER = 5;
        public static final int AVAILABILITY_AVAILABLE = 0;
        public static final int AVAILABILITY_FREE = 4;
        public static final int AVAILABILITY_FREE_WITH_SUBSCRIPTION = 1;
        public static final int AVAILABILITY_PAID_CONTENT = 2;
        public static final int AVAILABILITY_PURCHASED = 3;
        public static final String COLUMN_AUTHOR = "author";
        public static final String COLUMN_AVAILABILITY = "availability";
        public static final String COLUMN_CANONICAL_GENRE = "canonical_genre";
        public static final String COLUMN_CONTENT_ID = "content_id";
        public static final String COLUMN_CONTENT_RATING = "content_rating";
        public static final String COLUMN_DURATION_MILLIS = "duration_millis";
        public static final String COLUMN_END_TIME_UTC_MILLIS = "end_time_utc_millis";
        public static final String COLUMN_EPISODE_DISPLAY_NUMBER = "episode_display_number";
        public static final String COLUMN_EPISODE_TITLE = "episode_title";
        public static final String COLUMN_GENRE = "genre";
        public static final String COLUMN_INTENT_URI = "intent_uri";
        public static final String COLUMN_INTERACTION_COUNT = "interaction_count";
        public static final String COLUMN_INTERACTION_TYPE = "interaction_type";
        public static final String COLUMN_INTERNAL_PROVIDER_ID = "internal_provider_id";
        public static final String COLUMN_ITEM_COUNT = "item_count";
        public static final String COLUMN_LAST_PLAYBACK_POSITION_MILLIS = "last_playback_position_millis";
        public static final String COLUMN_LIVE = "live";
        public static final String COLUMN_LOGO_CONTENT_DESCRIPTION = "logo_content_description";
        public static final String COLUMN_LOGO_URI = "logo_uri";
        public static final String COLUMN_OFFER_PRICE = "offer_price";
        public static final String COLUMN_POSTER_ART_ASPECT_RATIO = "poster_art_aspect_ratio";
        public static final String COLUMN_POSTER_ART_URI = "poster_art_uri";
        public static final String COLUMN_PREVIEW_AUDIO_URI = "preview_audio_uri";
        public static final String COLUMN_PREVIEW_VIDEO_URI = "preview_video_uri";
        public static final String COLUMN_RELEASE_DATE = "release_date";
        public static final String COLUMN_REVIEW_RATING = "review_rating";
        public static final String COLUMN_REVIEW_RATING_STYLE = "review_rating_style";
        public static final String COLUMN_SEASON_DISPLAY_NUMBER = "season_display_number";
        public static final String COLUMN_SEASON_TITLE = "season_title";
        public static final String COLUMN_SERIES_ID = "series_id";
        public static final String COLUMN_SHORT_DESCRIPTION = "short_description";
        public static final String COLUMN_STARTING_PRICE = "starting_price";
        public static final String COLUMN_START_TIME_UTC_MILLIS = "start_time_utc_millis";
        public static final String COLUMN_THUMBNAIL_ASPECT_RATIO = "poster_thumbnail_aspect_ratio";
        public static final String COLUMN_THUMBNAIL_URI = "thumbnail_uri";
        public static final String COLUMN_TITLE = "title";
        public static final String COLUMN_TV_SERIES_ITEM_TYPE = "tv_series_item_type";
        public static final String COLUMN_TYPE = "type";
        public static final String COLUMN_VIDEO_HEIGHT = "video_height";
        public static final String COLUMN_VIDEO_WIDTH = "video_width";
        public static final int INTERACTION_TYPE_FANS = 3;
        public static final int INTERACTION_TYPE_FOLLOWERS = 2;
        public static final int INTERACTION_TYPE_LIKES = 4;
        public static final int INTERACTION_TYPE_LISTENS = 1;
        public static final int INTERACTION_TYPE_THUMBS = 5;
        public static final int INTERACTION_TYPE_VIEWERS = 6;
        public static final int INTERACTION_TYPE_VIEWS = 0;
        public static final int REVIEW_RATING_STYLE_PERCENTAGE = 2;
        public static final int REVIEW_RATING_STYLE_STARS = 0;
        public static final int REVIEW_RATING_STYLE_THUMBS_UP_DOWN = 1;
        public static final int TV_SERIES_ITEM_TYPE_CHAPTER = 1;
        public static final int TV_SERIES_ITEM_TYPE_EPISODE = 0;
        public static final int TYPE_ALBUM = 8;
        public static final int TYPE_ARTIST = 9;
        public static final int TYPE_CHANNEL = 6;
        public static final int TYPE_CLIP = 4;
        public static final int TYPE_EVENT = 5;
        public static final int TYPE_GAME = 12;
        public static final int TYPE_MOVIE = 0;
        public static final int TYPE_PLAYLIST = 10;
        public static final int TYPE_STATION = 11;
        public static final int TYPE_TRACK = 7;
        public static final int TYPE_TV_EPISODE = 3;
        public static final int TYPE_TV_SEASON = 2;
        public static final int TYPE_TV_SERIES = 1;

        /* compiled from: com.google.android.mediahome:video@@1.0.0 */
        /* loaded from: classes3.dex */
        public static final class Genres {
            public static final String ANIMAL_WILDLIFE = "ANIMAL_WILDLIFE";
            public static final String ARTS = "ARTS";
            public static final String COMEDY = "COMEDY";
            public static final String DRAMA = "DRAMA";
            public static final String EDUCATION = "EDUCATION";
            public static final String ENTERTAINMENT = "ENTERTAINMENT";
            public static final String FAMILY_KIDS = "FAMILY_KIDS";
            public static final String GAMING = "GAMING";
            public static final String LIFE_STYLE = "LIFE_STYLE";
            public static final String MOVIES = "MOVIES";
            public static final String MUSIC = "MUSIC";
            public static final String NEWS = "NEWS";
            public static final String PREMIER = "PREMIER";
            public static final String SHOPPING = "SHOPPING";
            public static final String SPORTS = "SPORTS";
            public static final String TECH_SCIENCE = "TECH_SCIENCE";
            public static final String TRAVEL = "TRAVEL";
            private static final HashSet<String> zza;
            private static final String[] zzb;

            /* compiled from: com.google.android.mediahome:video@@1.0.0 */
            @Retention(RetentionPolicy.SOURCE)
            /* loaded from: classes3.dex */
            public @interface Genre {
            }

            static {
                HashSet<String> hashSet = new HashSet<>();
                zza = hashSet;
                hashSet.add("FAMILY_KIDS");
                hashSet.add("SPORTS");
                hashSet.add("SHOPPING");
                hashSet.add("MOVIES");
                hashSet.add("COMEDY");
                hashSet.add("TRAVEL");
                hashSet.add("DRAMA");
                hashSet.add("EDUCATION");
                hashSet.add("ANIMAL_WILDLIFE");
                hashSet.add("NEWS");
                hashSet.add("GAMING");
                hashSet.add("ARTS");
                hashSet.add("ENTERTAINMENT");
                hashSet.add("LIFE_STYLE");
                hashSet.add("MUSIC");
                hashSet.add("PREMIER");
                hashSet.add("TECH_SCIENCE");
                zzb = new String[0];
            }

            private Genres() {
            }

            public static String[] decode(String str) {
                if (TextUtils.isEmpty(str)) {
                    return zzb;
                }
                if (str.indexOf(44) == -1 && str.indexOf(34) == -1) {
                    return new String[]{str.trim()};
                }
                StringBuilder sb = new StringBuilder();
                ArrayList arrayList = new ArrayList();
                int length = str.length();
                boolean z = false;
                for (int i = 0; i < length; i++) {
                    char charAt = str.charAt(i);
                    if (charAt != '\"') {
                        if (charAt == ',' && !z) {
                            String trim = sb.toString().trim();
                            if (trim.length() > 0) {
                                arrayList.add(trim);
                            }
                            sb = new StringBuilder();
                            z = false;
                        }
                    } else if (!z) {
                        z = true;
                    }
                    sb.append(charAt);
                    z = false;
                }
                String trim2 = sb.toString().trim();
                if (trim2.length() > 0) {
                    arrayList.add(trim2);
                }
                return (String[]) arrayList.toArray(new String[0]);
            }

            public static String encode(String... strArr) {
                if (strArr == null) {
                    return null;
                }
                StringBuilder sb = new StringBuilder();
                int length = strArr.length;
                String str = "";
                int i = 0;
                while (i < length) {
                    String str2 = strArr[i];
                    sb.append(str);
                    StringBuilder sb2 = new StringBuilder();
                    int length2 = str2.length();
                    for (int i2 = 0; i2 < length2; i2++) {
                        char charAt = str2.charAt(i2);
                        if (charAt == '\"' || charAt == ',') {
                            sb2.append('\"');
                        }
                        sb2.append(charAt);
                    }
                    sb.append(sb2.toString());
                    i++;
                    str = ",";
                }
                return sb.toString();
            }

            public static boolean isCanonical(String str) {
                return zza.contains(str);
            }
        }
    }

    /* compiled from: com.google.android.mediahome:video@@1.0.0 */
    /* loaded from: classes3.dex */
    public static final class PreviewPrograms implements BaseVideoColumns, PreviewProgramColumns {
        public static final String COLUMN_CHANNEL_ID = "channel_id";
        public static final String COLUMN_WEIGHT = "weight";
        public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/preview_program";
        public static final String CONTENT_TYPE = "vnd.android.cursor.dir/preview_program";
        public static final Uri CONTENT_URI = Uri.parse("content://com.google.android.mediahome.video/preview_program");

        private PreviewPrograms() {
        }
    }

    /* compiled from: com.google.android.mediahome:video@@1.0.0 */
    /* loaded from: classes3.dex */
    public static final class WatchNextPrograms implements BaseVideoColumns, PreviewProgramColumns {
        public static final String COLUMN_LAST_ENGAGEMENT_TIME_UTC_MILLIS = "last_engagement_time_utc_millis";
        public static final String COLUMN_WATCH_NEXT_TYPE = "watch_next_type";
        public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/watch_next_program";
        public static final String CONTENT_TYPE = "vnd.android.cursor.dir/watch_next_program";
        public static final Uri CONTENT_URI = Uri.parse("content://com.google.android.mediahome.video/watch_next_program");
        public static final int WATCH_NEXT_TYPE_CONTINUE = 0;
        public static final int WATCH_NEXT_TYPE_NEW = 2;
        public static final int WATCH_NEXT_TYPE_NEXT = 1;
        public static final int WATCH_NEXT_TYPE_WATCHLIST = 3;

        private WatchNextPrograms() {
        }
    }

    private VideoContract() {
    }

    public static Uri buildChannelUri(long j) {
        return ContentUris.withAppendedId(PreviewChannels.CONTENT_URI, j);
    }

    public static Uri buildPreviewProgramUri(long j) {
        return ContentUris.withAppendedId(PreviewPrograms.CONTENT_URI, j);
    }

    public static Uri buildPreviewProgramsUriForChannel(long j) {
        return PreviewPrograms.CONTENT_URI.buildUpon().appendQueryParameter("channel", String.valueOf(j)).build();
    }

    public static Uri buildWatchNextProgramUri(long j) {
        return ContentUris.withAppendedId(WatchNextPrograms.CONTENT_URI, j);
    }

    public static boolean isChannelUri(Uri uri) {
        if (uri != null && "content".equals(uri.getScheme()) && AUTHORITY.equals(uri.getAuthority())) {
            List<String> pathSegments = uri.getPathSegments();
            if (pathSegments.size() == 2 && "channel".equals(pathSegments.get(0))) {
                return true;
            }
        }
        return false;
    }

    public static Uri buildPreviewProgramsUriForChannel(Uri uri) {
        if (!isChannelUri(uri)) {
            String valueOf = String.valueOf(uri);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 15);
            sb.append("Not a channel: ");
            sb.append(valueOf);
            throw new IllegalArgumentException(sb.toString());
        }
        return buildPreviewProgramsUriForChannel(ContentUris.parseId(uri));
    }
}
