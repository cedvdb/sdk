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
 * A collection of positions that should be linked (edited simultaneously) for the purposes of
 * updating code after a source change. For example, if a set of edits introduced a new variable
 * name, the group would contain all of the positions of the variable name so that if the client
 * wanted to let the user edit the variable name after the operation, all occurrences of the name
 * could be edited simultaneously.
 *
 * Edit groups may have a length of 0 and function as tabstops where there is no default text, for
 * example, an edit that inserts an if statement might provide an empty group between parens where
 * a condition should be typed. For this reason, it's also valid for a group to contain only a
 * single position that is not linked to others.
 *
 * @coverage dart.server.generated.types
 */
@SuppressWarnings("unused")
public class LinkedEditGroup {

  public static final LinkedEditGroup[] EMPTY_ARRAY = new LinkedEditGroup[0];

  public static final List<LinkedEditGroup> EMPTY_LIST = List.of();

  /**
   * The positions of the regions (after applying the relevant edits) that should be edited
   * simultaneously.
   */
  private final List<Position> positions;

  /**
   * The length of the regions that should be edited simultaneously.
   */
  private final int length;

  /**
   * Pre-computed suggestions for what every region might want to be changed to.
   */
  private final List<LinkedEditSuggestion> suggestions;

  /**
   * Constructor for {@link LinkedEditGroup}.
   */
  public LinkedEditGroup(List<Position> positions, int length, List<LinkedEditSuggestion> suggestions) {
    this.positions = positions;
    this.length = length;
    this.suggestions = suggestions;
  }

  @Override
  public boolean equals(Object obj) {
    if (obj instanceof LinkedEditGroup other) {
      return
        Objects.equals(other.positions, positions) &&
        other.length == length &&
        Objects.equals(other.suggestions, suggestions);
    }
    return false;
  }

  public static LinkedEditGroup fromJson(JsonObject jsonObject) {
    List<Position> positions = Position.fromJsonArray(jsonObject.get("positions").getAsJsonArray());
    int length = jsonObject.get("length").getAsInt();
    List<LinkedEditSuggestion> suggestions = LinkedEditSuggestion.fromJsonArray(jsonObject.get("suggestions").getAsJsonArray());
    return new LinkedEditGroup(positions, length, suggestions);
  }

  public static List<LinkedEditGroup> fromJsonArray(JsonArray jsonArray) {
    if (jsonArray == null) {
      return EMPTY_LIST;
    }
    List<LinkedEditGroup> list = new ArrayList<>(jsonArray.size());
    for (final JsonElement element : jsonArray) {
      list.add(fromJson(element.getAsJsonObject()));
    }
    return list;
  }

  /**
   * The length of the regions that should be edited simultaneously.
   */
  public int getLength() {
    return length;
  }

  /**
   * The positions of the regions (after applying the relevant edits) that should be edited
   * simultaneously.
   */
  public List<Position> getPositions() {
    return positions;
  }

  /**
   * Pre-computed suggestions for what every region might want to be changed to.
   */
  public List<LinkedEditSuggestion> getSuggestions() {
    return suggestions;
  }

  @Override
  public int hashCode() {
    return Objects.hash(
      positions,
      length,
      suggestions
    );
  }

  public JsonObject toJson() {
    JsonObject jsonObject = new JsonObject();
    JsonArray jsonArrayPositions = new JsonArray();
    for (Position elt : positions) {
      jsonArrayPositions.add(elt.toJson());
    }
    jsonObject.add("positions", jsonArrayPositions);
    jsonObject.addProperty("length", length);
    JsonArray jsonArraySuggestions = new JsonArray();
    for (LinkedEditSuggestion elt : suggestions) {
      jsonArraySuggestions.add(elt.toJson());
    }
    jsonObject.add("suggestions", jsonArraySuggestions);
    return jsonObject;
  }

  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    builder.append("[");
    builder.append("positions=");
    builder.append(positions.stream().map(String::valueOf).collect(Collectors.joining(", ")));
    builder.append(", ");
    builder.append("length=");
    builder.append(length);
    builder.append(", ");
    builder.append("suggestions=");
    builder.append(suggestions.stream().map(String::valueOf).collect(Collectors.joining(", ")));
    builder.append("]");
    return builder.toString();
  }

}
