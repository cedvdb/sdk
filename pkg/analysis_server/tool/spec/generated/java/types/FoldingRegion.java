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
 * A description of a region that can be folded.
 *
 * @coverage dart.server.generated.types
 */
@SuppressWarnings("unused")
public class FoldingRegion {

  public static final FoldingRegion[] EMPTY_ARRAY = new FoldingRegion[0];

  public static final List<FoldingRegion> EMPTY_LIST = List.of();

  /**
   * The kind of the region.
   */
  private final String kind;

  /**
   * The offset of the region to be folded.
   */
  private final int offset;

  /**
   * The length of the region to be folded.
   */
  private final int length;

  /**
   * Constructor for {@link FoldingRegion}.
   */
  public FoldingRegion(String kind, int offset, int length) {
    this.kind = kind;
    this.offset = offset;
    this.length = length;
  }

  @Override
  public boolean equals(Object obj) {
    if (obj instanceof FoldingRegion other) {
      return
        Objects.equals(other.kind, kind) &&
        other.offset == offset &&
        other.length == length;
    }
    return false;
  }

  public static FoldingRegion fromJson(JsonObject jsonObject) {
    String kind = jsonObject.get("kind").getAsString();
    int offset = jsonObject.get("offset").getAsInt();
    int length = jsonObject.get("length").getAsInt();
    return new FoldingRegion(kind, offset, length);
  }

  public static List<FoldingRegion> fromJsonArray(JsonArray jsonArray) {
    if (jsonArray == null) {
      return EMPTY_LIST;
    }
    List<FoldingRegion> list = new ArrayList<>(jsonArray.size());
    for (final JsonElement element : jsonArray) {
      list.add(fromJson(element.getAsJsonObject()));
    }
    return list;
  }

  /**
   * The kind of the region.
   */
  public String getKind() {
    return kind;
  }

  /**
   * The length of the region to be folded.
   */
  public int getLength() {
    return length;
  }

  /**
   * The offset of the region to be folded.
   */
  public int getOffset() {
    return offset;
  }

  @Override
  public int hashCode() {
    return Objects.hash(
      kind,
      offset,
      length
    );
  }

  public JsonObject toJson() {
    JsonObject jsonObject = new JsonObject();
    jsonObject.addProperty("kind", kind);
    jsonObject.addProperty("offset", offset);
    jsonObject.addProperty("length", length);
    return jsonObject;
  }

  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    builder.append("[");
    builder.append("kind=");
    builder.append(kind);
    builder.append(", ");
    builder.append("offset=");
    builder.append(offset);
    builder.append(", ");
    builder.append("length=");
    builder.append(length);
    builder.append("]");
    return builder.toString();
  }

}
