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
 * A description of a fix applied to a library.
 *
 * @coverage dart.server.generated.types
 */
@SuppressWarnings("unused")
public class BulkFixDetail {

  public static final BulkFixDetail[] EMPTY_ARRAY = new BulkFixDetail[0];

  public static final List<BulkFixDetail> EMPTY_LIST = List.of();

  /**
   * The code of the diagnostic associated with the fix.
   */
  private final String code;

  /**
   * The number times the associated diagnostic was fixed in the associated source edit.
   */
  private final int occurrences;

  /**
   * Constructor for {@link BulkFixDetail}.
   */
  public BulkFixDetail(String code, int occurrences) {
    this.code = code;
    this.occurrences = occurrences;
  }

  @Override
  public boolean equals(Object obj) {
    if (obj instanceof BulkFixDetail other) {
      return
        Objects.equals(other.code, code) &&
        other.occurrences == occurrences;
    }
    return false;
  }

  public static BulkFixDetail fromJson(JsonObject jsonObject) {
    String code = jsonObject.get("code").getAsString();
    int occurrences = jsonObject.get("occurrences").getAsInt();
    return new BulkFixDetail(code, occurrences);
  }

  public static List<BulkFixDetail> fromJsonArray(JsonArray jsonArray) {
    if (jsonArray == null) {
      return EMPTY_LIST;
    }
    List<BulkFixDetail> list = new ArrayList<>(jsonArray.size());
    for (final JsonElement element : jsonArray) {
      list.add(fromJson(element.getAsJsonObject()));
    }
    return list;
  }

  /**
   * The code of the diagnostic associated with the fix.
   */
  public String getCode() {
    return code;
  }

  /**
   * The number times the associated diagnostic was fixed in the associated source edit.
   */
  public int getOccurrences() {
    return occurrences;
  }

  @Override
  public int hashCode() {
    return Objects.hash(
      code,
      occurrences
    );
  }

  public JsonObject toJson() {
    JsonObject jsonObject = new JsonObject();
    jsonObject.addProperty("code", code);
    jsonObject.addProperty("occurrences", occurrences);
    return jsonObject;
  }

  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    builder.append("[");
    builder.append("code=");
    builder.append(code);
    builder.append(", ");
    builder.append("occurrences=");
    builder.append(occurrences);
    builder.append("]");
    return builder.toString();
  }

}
