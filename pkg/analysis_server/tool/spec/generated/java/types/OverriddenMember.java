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
 * A description of a member that is being overridden.
 *
 * @coverage dart.server.generated.types
 */
@SuppressWarnings("unused")
public class OverriddenMember {

  public static final OverriddenMember[] EMPTY_ARRAY = new OverriddenMember[0];

  public static final List<OverriddenMember> EMPTY_LIST = List.of();

  /**
   * The element that is being overridden.
   */
  private final Element element;

  /**
   * The name of the class in which the member is defined.
   */
  private final String className;

  /**
   * Constructor for {@link OverriddenMember}.
   */
  public OverriddenMember(Element element, String className) {
    this.element = element;
    this.className = className;
  }

  @Override
  public boolean equals(Object obj) {
    if (obj instanceof OverriddenMember other) {
      return
        Objects.equals(other.element, element) &&
        Objects.equals(other.className, className);
    }
    return false;
  }

  public static OverriddenMember fromJson(JsonObject jsonObject) {
    Element element = Element.fromJson(jsonObject.get("element").getAsJsonObject());
    String className = jsonObject.get("className").getAsString();
    return new OverriddenMember(element, className);
  }

  public static List<OverriddenMember> fromJsonArray(JsonArray jsonArray) {
    if (jsonArray == null) {
      return EMPTY_LIST;
    }
    List<OverriddenMember> list = new ArrayList<>(jsonArray.size());
    for (final JsonElement element : jsonArray) {
      list.add(fromJson(element.getAsJsonObject()));
    }
    return list;
  }

  /**
   * The name of the class in which the member is defined.
   */
  public String getClassName() {
    return className;
  }

  /**
   * The element that is being overridden.
   */
  public Element getElement() {
    return element;
  }

  @Override
  public int hashCode() {
    return Objects.hash(
      element,
      className
    );
  }

  public JsonObject toJson() {
    JsonObject jsonObject = new JsonObject();
    jsonObject.add("element", element.toJson());
    jsonObject.addProperty("className", className);
    return jsonObject;
  }

  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    builder.append("[");
    builder.append("element=");
    builder.append(element);
    builder.append(", ");
    builder.append("className=");
    builder.append(className);
    builder.append("]");
    return builder.toString();
  }

}
