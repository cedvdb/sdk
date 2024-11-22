/*
 * Copyright (c) 2019, the Dart project authors. Please see the AUTHORS file
 * for details. All rights reserved. Use of this source code is governed by a
 * BSD-style license that can be found in the LICENSE file.
 *
 * This file has been automatically generated. Please do not edit it manually.
 * To regenerate the file, use the script "pkg/analysis_server/tool/spec/generate_files".
 */
package org.dartlang.analysis.server.protocol;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import com.google.dart.server.utilities.general.JsonUtilities;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;

/**
 * A single result from a search request.
 *
 * @coverage dart.server.generated.types
 */
@SuppressWarnings("unused")
public class SearchResult {

  public static final SearchResult[] EMPTY_ARRAY = new SearchResult[0];

  public static final List<SearchResult> EMPTY_LIST = List.of();

  /**
   * The location of the code that matched the search criteria.
   */
  private final Location location;

  /**
   * The kind of element that was found or the kind of reference that was found.
   */
  private final String kind;

  /**
   * True if the result is a potential match but cannot be confirmed to be a match. For example, if
   * all references to a method m defined in some class were requested, and a reference to a method m
   * from an unknown class were found, it would be marked as being a potential match.
   */
  private final boolean isPotential;

  /**
   * The elements that contain the result, starting with the most immediately enclosing ancestor and
   * ending with the library.
   */
  private final List<Element> path;

  /**
   * Constructor for {@link SearchResult}.
   */
  public SearchResult(Location location, String kind, boolean isPotential, List<Element> path) {
    this.location = location;
    this.kind = kind;
    this.isPotential = isPotential;
    this.path = path;
  }

  @Override
  public boolean equals(Object obj) {
    if (obj instanceof SearchResult other) {
      return
        Objects.equals(other.location, location) &&
        Objects.equals(other.kind, kind) &&
        other.isPotential == isPotential &&
        Objects.equals(other.path, path);
    }
    return false;
  }

  public static SearchResult fromJson(JsonObject jsonObject) {
    Location location = Location.fromJson(jsonObject.get("location").getAsJsonObject());
    String kind = jsonObject.get("kind").getAsString();
    boolean isPotential = jsonObject.get("isPotential").getAsBoolean();
    List<Element> path = Element.fromJsonArray(jsonObject.get("path").getAsJsonArray());
    return new SearchResult(location, kind, isPotential, path);
  }

  public static List<SearchResult> fromJsonArray(JsonArray jsonArray) {
    if (jsonArray == null) {
      return EMPTY_LIST;
    }
    List<SearchResult> list = new ArrayList<>(jsonArray.size());
    for (final JsonElement element : jsonArray) {
      list.add(fromJson(element.getAsJsonObject()));
    }
    return list;
  }

  /**
   * True if the result is a potential match but cannot be confirmed to be a match. For example, if
   * all references to a method m defined in some class were requested, and a reference to a method m
   * from an unknown class were found, it would be marked as being a potential match.
   */
  public boolean isPotential() {
    return isPotential;
  }

  /**
   * The kind of element that was found or the kind of reference that was found.
   */
  public String getKind() {
    return kind;
  }

  /**
   * The location of the code that matched the search criteria.
   */
  public Location getLocation() {
    return location;
  }

  /**
   * The elements that contain the result, starting with the most immediately enclosing ancestor and
   * ending with the library.
   */
  public List<Element> getPath() {
    return path;
  }

  @Override
  public int hashCode() {
    return Objects.hash(
      location,
      kind,
      isPotential,
      path
    );
  }

  public JsonObject toJson() {
    JsonObject jsonObject = new JsonObject();
    jsonObject.add("location", location.toJson());
    jsonObject.addProperty("kind", kind);
    jsonObject.addProperty("isPotential", isPotential);
    JsonArray jsonArrayPath = new JsonArray();
    for (Element elt : path) {
      jsonArrayPath.add(elt.toJson());
    }
    jsonObject.add("path", jsonArrayPath);
    return jsonObject;
  }

  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    builder.append("[");
    builder.append("location=");
    builder.append(location);
    builder.append(", ");
    builder.append("kind=");
    builder.append(kind);
    builder.append(", ");
    builder.append("isPotential=");
    builder.append(isPotential);
    builder.append(", ");
    builder.append("path=");
    builder.append(path.stream().map(String::valueOf).collect(Collectors.joining(", ")));
    builder.append("]");
    return builder.toString();
  }

}
