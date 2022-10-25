package com.uwetrottmann.tmdb2.entities;

import com.google.gson.JsonPrimitive;
import java.util.Date;

/* loaded from: classes4.dex */
public class Person extends BasePerson {
    public java.util.List<JsonPrimitive> also_known_as;
    public String biography;
    public Date birthday;
    public Changes changes;
    public PersonCredits combined_credits;
    public Date deathday;
    public PersonExternalIds external_ids;
    public Integer gender;
    public String homepage;
    public PersonImages images;
    public String imdb_id;
    public PersonCredits movie_credits;
    public String place_of_birth;
    public TaggedImagesResultsPage tagged_images;
    public PersonCredits tv_credits;
}
