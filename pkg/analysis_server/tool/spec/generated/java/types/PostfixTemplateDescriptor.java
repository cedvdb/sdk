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
 * The description of a postfix completion template.
 *
 * @coverage dart.server.generated.types
 */
@SuppressWarnings("unused")
public class PostfixTemplateDescriptor {

  public static final PostfixTemplateDescriptor[] EMPTY_ARRAY = new PostfixTemplateDescriptor[0];

  public static final List<PostfixTemplateDescriptor> EMPTY_LIST = List.of();

  /**
   * The template name, shown in the UI.
   */
  private final String name;

  /**
   * The unique template key, not shown in the UI.
   */
  private final String key;

  /**
   * A short example of the transformation performed when the template is applied.
   */
  private final String example;

  /**
   * Constructor for {@link PostfixTemplateDescriptor}.
   */
  public PostfixTemplateDescriptor(String name, String key, String example) {
    this.name = name;
    this.key = key;
    this.example = example;
  }

  @Override
  public boolean equals(Object obj) {
    if (obj instanceof PostfixTemplateDescriptor other) {
      return
        Objects.equals(other.name, name) &&
        Objects.equals(other.key, key) &&
        Objects.equals(other.example, example);
    }
    return false;
  }

  public static PostfixTemplateDescriptor fromJson(JsonObject jsonObject) {
    String name = jsonObject.get("name").getAsString();
    String key = jsonObject.get("key").getAsString();
    String example = jsonObject.get("example").getAsString();
    return new PostfixTemplateDescriptor(name, key, example);
  }

  public static List<PostfixTemplateDescriptor> fromJsonArray(JsonArray jsonArray) {
    if (jsonArray == null) {
      return EMPTY_LIST;
    }
    List<PostfixTemplateDescriptor> list = new ArrayList<>(jsonArray.size());
    for (final JsonElement element : jsonArray) {
      list.add(fromJson(element.getAsJsonObject()));
    }
    return list;
  }

  /**
   * A short example of the transformation performed when the template is applied.
   */
  public String getExample() {
    return example;
  }

  /**
   * The unique template key, not shown in the UI.
   */
  public String getKey() {
    return key;
  }

  /**
   * The template name, shown in the UI.
   */
  public String getName() {
    return name;
  }

  @Override
  public int hashCode() {
    return Objects.hash(
      name,
      key,
      example
    );
  }

  public JsonObject toJson() {
    JsonObject jsonObject = new JsonObject();
    jsonObject.addProperty("name", name);
    jsonObject.addProperty("key", key);
    jsonObject.addProperty("example", example);
    return jsonObject;
  }

  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    builder.append("[");
    builder.append("name=");
    builder.append(name);
    builder.append(", ");
    builder.append("key=");
    builder.append(key);
    builder.append(", ");
    builder.append("example=");
    builder.append(example);
    builder.append("]");
    return builder.toString();
  }

}
