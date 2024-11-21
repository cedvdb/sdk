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
 * @coverage dart.server.generated.types
 */
@SuppressWarnings("unused")
public class ExtractLocalVariableOptions extends RefactoringOptions {

  public static final ExtractLocalVariableOptions[] EMPTY_ARRAY = new ExtractLocalVariableOptions[0];

  public static final List<ExtractLocalVariableOptions> EMPTY_LIST = List.of();

  /**
   * The name that the local variable should be given.
   */
  private String name;

  /**
   * True if all occurrences of the expression within the scope in which the variable will be defined
   * should be replaced by a reference to the local variable. The expression used to initiate the
   * refactoring will always be replaced.
   */
  private boolean extractAll;

  /**
   * Constructor for {@link ExtractLocalVariableOptions}.
   */
  public ExtractLocalVariableOptions(String name, boolean extractAll) {
    this.name = name;
    this.extractAll = extractAll;
  }

  @Override
  public boolean equals(Object obj) {
    if (obj instanceof ExtractLocalVariableOptions other) {
      return
        Objects.equals(other.name, name) &&
        other.extractAll == extractAll;
    }
    return false;
  }

  public static ExtractLocalVariableOptions fromJson(JsonObject jsonObject) {
    String name = jsonObject.get("name").getAsString();
    boolean extractAll = jsonObject.get("extractAll").getAsBoolean();
    return new ExtractLocalVariableOptions(name, extractAll);
  }

  public static List<ExtractLocalVariableOptions> fromJsonArray(JsonArray jsonArray) {
    if (jsonArray == null) {
      return EMPTY_LIST;
    }
    List<ExtractLocalVariableOptions> list = new ArrayList<>(jsonArray.size());
    for (final JsonElement element : jsonArray) {
      list.add(fromJson(element.getAsJsonObject()));
    }
    return list;
  }

  /**
   * True if all occurrences of the expression within the scope in which the variable will be defined
   * should be replaced by a reference to the local variable. The expression used to initiate the
   * refactoring will always be replaced.
   */
  public boolean extractAll() {
    return extractAll;
  }

  /**
   * The name that the local variable should be given.
   */
  public String getName() {
    return name;
  }

  @Override
  public int hashCode() {
    return Objects.hash(
      name,
      extractAll
    );
  }

  /**
   * True if all occurrences of the expression within the scope in which the variable will be defined
   * should be replaced by a reference to the local variable. The expression used to initiate the
   * refactoring will always be replaced.
   */
  public void setExtractAll(boolean extractAll) {
    this.extractAll = extractAll;
  }

  /**
   * The name that the local variable should be given.
   */
  public void setName(String name) {
    this.name = name;
  }

  @Override
  public JsonObject toJson() {
    JsonObject jsonObject = new JsonObject();
    jsonObject.addProperty("name", name);
    jsonObject.addProperty("extractAll", extractAll);
    return jsonObject;
  }

  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    builder.append("[");
    builder.append("name=");
    builder.append(name);
    builder.append(", ");
    builder.append("extractAll=");
    builder.append(extractAll);
    builder.append("]");
    return builder.toString();
  }

}
