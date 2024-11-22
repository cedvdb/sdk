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
 * A description of the references to a single element within a single file.
 *
 * @coverage dart.server.generated.types
 */
@SuppressWarnings("unused")
public class Occurrences {

  public static final Occurrences[] EMPTY_ARRAY = new Occurrences[0];

  public static final List<Occurrences> EMPTY_LIST = List.of();

  /**
   * The element that was referenced.
   */
  private final Element element;

  /**
   * The offsets of the name of the referenced element within the file.
   */
  private final int[] offsets;

  /**
   * The length of the name of the referenced element.
   */
  private final int length;

  /**
   * Constructor for {@link Occurrences}.
   */
  public Occurrences(Element element, int[] offsets, int length) {
    this.element = element;
    this.offsets = offsets;
    this.length = length;
  }

  public boolean containsInclusive(int x) {
    for (int offset : offsets) {
      if (offset <= x && x <= offset + length) {
        return true;
      }
    }
    return false;
  }

  @Override
  public boolean equals(Object obj) {
    if (obj instanceof Occurrences other) {
      return
        Objects.equals(other.element, element) &&
        Arrays.equals(other.offsets, offsets) &&
        other.length == length;
    }
    return false;
  }

  public static Occurrences fromJson(JsonObject jsonObject) {
    Element element = Element.fromJson(jsonObject.get("element").getAsJsonObject());
    int[] offsets = JsonUtilities.decodeIntArray(jsonObject.get("offsets").getAsJsonArray());
    int length = jsonObject.get("length").getAsInt();
    return new Occurrences(element, offsets, length);
  }

  public static List<Occurrences> fromJsonArray(JsonArray jsonArray) {
    if (jsonArray == null) {
      return EMPTY_LIST;
    }
    List<Occurrences> list = new ArrayList<>(jsonArray.size());
    for (final JsonElement element : jsonArray) {
      list.add(fromJson(element.getAsJsonObject()));
    }
    return list;
  }

  /**
   * The element that was referenced.
   */
  public Element getElement() {
    return element;
  }

  /**
   * The length of the name of the referenced element.
   */
  public int getLength() {
    return length;
  }

  /**
   * The offsets of the name of the referenced element within the file.
   */
  public int[] getOffsets() {
    return offsets;
  }

  @Override
  public int hashCode() {
    return Objects.hash(
      element,
      Arrays.hashCode(offsets),
      length
    );
  }

  public JsonObject toJson() {
    JsonObject jsonObject = new JsonObject();
    jsonObject.add("element", element.toJson());
    JsonArray jsonArrayOffsets = new JsonArray();
    for (int elt : offsets) {
      jsonArrayOffsets.add(new JsonPrimitive(elt));
    }
    jsonObject.add("offsets", jsonArrayOffsets);
    jsonObject.addProperty("length", length);
    return jsonObject;
  }

  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    builder.append("[");
    builder.append("element=");
    builder.append(element);
    builder.append(", ");
    builder.append("offsets=");
    builder.append(Arrays.stream(offsets).mapToObj(String::valueOf).collect(Collectors.joining(", ")));
    builder.append(", ");
    builder.append("length=");
    builder.append(length);
    builder.append("]");
    return builder.toString();
  }

}
