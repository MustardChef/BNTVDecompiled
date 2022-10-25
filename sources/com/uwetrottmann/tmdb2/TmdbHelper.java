package com.uwetrottmann.tmdb2;

import androidx.tvprovider.media.p009tv.TvContractCompat;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.uwetrottmann.tmdb2.entities.AccountStates;
import com.uwetrottmann.tmdb2.entities.BaseAccountStates;
import com.uwetrottmann.tmdb2.entities.BaseMovie;
import com.uwetrottmann.tmdb2.entities.BasePerson;
import com.uwetrottmann.tmdb2.entities.BaseTvShow;
import com.uwetrottmann.tmdb2.entities.Media;
import com.uwetrottmann.tmdb2.entities.PersonCastCredit;
import com.uwetrottmann.tmdb2.entities.PersonCrewCredit;
import com.uwetrottmann.tmdb2.entities.RatingObject;
import com.uwetrottmann.tmdb2.enumerations.MediaType;
import com.uwetrottmann.tmdb2.enumerations.Status;
import com.uwetrottmann.tmdb2.enumerations.VideoType;
import java.lang.reflect.Type;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/* loaded from: classes4.dex */
public class TmdbHelper {
    private static final ThreadLocal<SimpleDateFormat> TMDB_DATE_FORMAT = new ThreadLocal<>();
    public static final String TMDB_DATE_PATTERN = "yyyy-MM-dd";

    public static GsonBuilder getGsonBuilder() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(Integer.class, $$Lambda$TmdbHelper$ciX_9oGGxbwqvg4nUBp5GqibqC4.INSTANCE);
        gsonBuilder.registerTypeAdapter(MediaType.class, $$Lambda$TmdbHelper$OsuL5blvsh2esrqy9a_dF7tkXKo.INSTANCE);
        gsonBuilder.registerTypeAdapter(VideoType.class, $$Lambda$TmdbHelper$e9awqWS8pSeTzxKURwrjx_9tbpo.INSTANCE);
        gsonBuilder.registerTypeAdapter(BaseAccountStates.class, $$Lambda$TmdbHelper$L5IvSzwDPMOMIzHeEu0fUkqjc0A.INSTANCE);
        gsonBuilder.registerTypeAdapter(AccountStates.class, $$Lambda$TmdbHelper$VGOfRxmFZuMsehYFi3Gg0NOyI8.INSTANCE);
        gsonBuilder.registerTypeAdapter(Media.class, $$Lambda$TmdbHelper$hKWzfbyVywaMxa3PxsZKvieGIU.INSTANCE);
        gsonBuilder.registerTypeAdapter(PersonCastCredit.class, $$Lambda$TmdbHelper$DVTS0Vup7J9tSJvzoGD0ASyPbtg.INSTANCE);
        gsonBuilder.registerTypeAdapter(PersonCrewCredit.class, $$Lambda$TmdbHelper$F9VoCxYmRaV3UVrQnwYiw81UDB0.INSTANCE);
        gsonBuilder.registerTypeAdapter(Date.class, $$Lambda$TmdbHelper$fVk_AdvBbdW1KjlkIom2OwqQ08o.INSTANCE);
        gsonBuilder.registerTypeAdapter(Status.class, $$Lambda$TmdbHelper$tr3ncaDCbyEKHSxRiffRNsi5rU0.INSTANCE);
        return gsonBuilder;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ BaseAccountStates lambda$getGsonBuilder$3(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        JsonObject asJsonObject = jsonElement.getAsJsonObject();
        BaseAccountStates baseAccountStates = new BaseAccountStates();
        deserializeBaseAccountStates(jsonDeserializationContext, asJsonObject, baseAccountStates);
        return baseAccountStates;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ AccountStates lambda$getGsonBuilder$4(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        JsonObject asJsonObject = jsonElement.getAsJsonObject();
        AccountStates accountStates = new AccountStates();
        deserializeBaseAccountStates(jsonDeserializationContext, asJsonObject, accountStates);
        if (asJsonObject.get("favorite") != null) {
            accountStates.favorite = Boolean.valueOf(asJsonObject.get("favorite").getAsBoolean());
            accountStates.watchlist = Boolean.valueOf(asJsonObject.get("watchlist").getAsBoolean());
        }
        if (asJsonObject.get(TvContractCompat.Programs.COLUMN_EPISODE_NUMBER) != null) {
            accountStates.episode_number = Integer.valueOf(asJsonObject.get(TvContractCompat.Programs.COLUMN_EPISODE_NUMBER).getAsInt());
        }
        return accountStates;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Media lambda$getGsonBuilder$5(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        Media media = new Media();
        if (jsonElement.getAsJsonObject().get(MessengerShareContentUtility.MEDIA_TYPE) != null) {
            media.media_type = (MediaType) jsonDeserializationContext.deserialize(jsonElement.getAsJsonObject().get(MessengerShareContentUtility.MEDIA_TYPE), MediaType.class);
        } else if (jsonElement.getAsJsonObject().get("first_air_date") != null) {
            media.media_type = MediaType.TV;
        } else if (jsonElement.getAsJsonObject().get("name") != null) {
            media.media_type = MediaType.PERSON;
        } else if (jsonElement.getAsJsonObject().get("title") != null) {
            media.media_type = MediaType.MOVIE;
        }
        int i = C49891.$SwitchMap$com$uwetrottmann$tmdb2$enumerations$MediaType[media.media_type.ordinal()];
        if (i == 1) {
            media.movie = (BaseMovie) jsonDeserializationContext.deserialize(jsonElement, BaseMovie.class);
        } else if (i == 2) {
            media.tvShow = (BaseTvShow) jsonDeserializationContext.deserialize(jsonElement, BaseTvShow.class);
        } else if (i == 3) {
            media.person = (BasePerson) jsonDeserializationContext.deserialize(jsonElement, BasePerson.class);
        }
        return media;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.uwetrottmann.tmdb2.TmdbHelper$1 */
    /* loaded from: classes4.dex */
    public static /* synthetic */ class C49891 {
        static final /* synthetic */ int[] $SwitchMap$com$uwetrottmann$tmdb2$enumerations$MediaType;

        static {
            int[] iArr = new int[MediaType.values().length];
            $SwitchMap$com$uwetrottmann$tmdb2$enumerations$MediaType = iArr;
            try {
                iArr[MediaType.MOVIE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$uwetrottmann$tmdb2$enumerations$MediaType[MediaType.TV.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$uwetrottmann$tmdb2$enumerations$MediaType[MediaType.PERSON.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ PersonCastCredit lambda$getGsonBuilder$6(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        PersonCastCredit personCastCredit = new PersonCastCredit();
        personCastCredit.media = (Media) jsonDeserializationContext.deserialize(jsonElement, Media.class);
        JsonElement jsonElement2 = jsonElement.getAsJsonObject().get(FirebaseAnalytics.Param.CHARACTER);
        if (jsonElement2 != null) {
            personCastCredit.character = jsonElement2.getAsString();
        }
        JsonElement jsonElement3 = jsonElement.getAsJsonObject().get("credit_id");
        if (jsonElement3 != null) {
            personCastCredit.credit_id = jsonElement3.getAsString();
        }
        if (personCastCredit.media.media_type == MediaType.TV) {
            personCastCredit.episode_count = Integer.valueOf(jsonElement.getAsJsonObject().get("episode_count").getAsInt());
        }
        return personCastCredit;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ PersonCrewCredit lambda$getGsonBuilder$7(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        PersonCrewCredit personCrewCredit = new PersonCrewCredit();
        personCrewCredit.media = (Media) jsonDeserializationContext.deserialize(jsonElement, Media.class);
        personCrewCredit.department = jsonElement.getAsJsonObject().get("department").getAsString();
        personCrewCredit.job = jsonElement.getAsJsonObject().get("job").getAsString();
        personCrewCredit.credit_id = jsonElement.getAsJsonObject().get("credit_id").getAsString();
        if (personCrewCredit.media.media_type == MediaType.TV && jsonElement.getAsJsonObject().get("episode_count") != null) {
            personCrewCredit.episode_count = Integer.valueOf(jsonElement.getAsJsonObject().get("episode_count").getAsInt());
        }
        return personCrewCredit;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Date lambda$getGsonBuilder$8(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        try {
            ThreadLocal<SimpleDateFormat> threadLocal = TMDB_DATE_FORMAT;
            SimpleDateFormat simpleDateFormat = threadLocal.get();
            if (simpleDateFormat == null) {
                simpleDateFormat = new SimpleDateFormat(TMDB_DATE_PATTERN);
                threadLocal.set(simpleDateFormat);
            }
            return simpleDateFormat.parse(jsonElement.getAsString());
        } catch (ParseException unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Status lambda$getGsonBuilder$9(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        String asString = jsonElement.getAsString();
        if (asString != null) {
            return Status.fromValue(asString);
        }
        return null;
    }

    private static void deserializeBaseAccountStates(JsonDeserializationContext jsonDeserializationContext, JsonObject jsonObject, BaseAccountStates baseAccountStates) {
        baseAccountStates.f10045id = Integer.valueOf(jsonObject.get("id").getAsInt());
        try {
            baseAccountStates.rated = Boolean.valueOf(jsonObject.get("rated").getAsBoolean());
        } catch (Exception unused) {
            baseAccountStates.rated = true;
            baseAccountStates.rating = (RatingObject) jsonDeserializationContext.deserialize(jsonObject.get("rated"), RatingObject.class);
        }
    }
}
