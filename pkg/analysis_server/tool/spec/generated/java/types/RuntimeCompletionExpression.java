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
 * An expression for which we want to know its runtime type. In expressions like 'a.b.c.where((e)
 * =&gt; e.^)' we want to know the runtime type of 'a.b.c' to enforce it statically at the time
 * when we compute completion suggestions, and get better type for 'e'.
 *
 * @coverage dart.server.generated.types
 */
@SuppressWarnings("unused")
public class RuntimeCompletionExpression {

  public static final RuntimeCompletionExpression[] EMPTY_ARRAY = new RuntimeCompletionExpression[0];

  public static final List<RuntimeCompletionExpression> EMPTY_LIST = List.of();

  /**
   * The offset of the expression in the code for completion.
   */
  private final int offset;

  /**
   * The length of the expression in the code for completion.
   */
  private final int length;

  /**
   * When the expression is sent from the server to the client, the type is omitted. The client
   * should fill the type when it sends the request to the server again.
   */
  private final RuntimeCompletionExpressionType type;

  /**
   * Constructor for {@link RuntimeCompletionExpression}.
   */
  public RuntimeCompletionExpression(int offset, int length, RuntimeCompletionExpressionType type) {
    this.offset = offset;
    this.length = length;
    this.type = type;
  }

  @Override
  public boolean equals(Object obj) {
    if (obj instanceof RuntimeCompletionExpression other) {
      return
        other.offset == offset &&
        other.length == length &&
        Objects.equals(other.type, type);
    }
    return false;
  }

  public static RuntimeCompletionExpression fromJson(JsonObject jsonObject) {
    int offset = jsonObject.get("offset").getAsInt();
    int length = jsonObject.get("length").getAsInt();
    RuntimeCompletionExpressionType type = jsonObject.get("type") == null ? null : RuntimeCompletionExpressionType.fromJson(jsonObject.get("type").getAsJsonObject());
    return new RuntimeCompletionExpression(offset, length, type);
  }

  public static List<RuntimeCompletionExpression> fromJsonArray(JsonArray jsonArray) {
    if (jsonArray == null) {
      return EMPTY_LIST;
    }
    List<RuntimeCompletionExpression> list = new ArrayList<>(jsonArray.size());
    for (final JsonElement element : jsonArray) {
      list.add(fromJson(element.getAsJsonObject()));
    }
    return list;
  }

  /**
   * The length of the expression in the code for completion.
   */
  public int getLength() {
    return length;
  }

  /**
   * The offset of the expression in the code for completion.
   */
  public int getOffset() {
    return offset;
  }

  /**
   * When the expression is sent from the server to the client, the type is omitted. The client
   * should fill the type when it sends the request to the server again.
   */
  public RuntimeCompletionExpressionType getType() {
    return type;
  }

  @Override
  public int hashCode() {
    return Objects.hash(
      offset,
      length,
      type
    );
  }

  public JsonObject toJson() {
    JsonObject jsonObject = new JsonObject();
    jsonObject.addProperty("offset", offset);
    jsonObject.addProperty("length", length);
    if (type != null) {
      jsonObject.add("type", type.toJson());
    }
    return jsonObject;
  }

  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    builder.append("[");
    builder.append("offset=");
    builder.append(offset);
    builder.append(", ");
    builder.append("length=");
    builder.append(length);
    builder.append(", ");
    builder.append("type=");
    builder.append(type);
    builder.append("]");
    return builder.toString();
  }

}
