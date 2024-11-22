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
public class RenameOptions extends RefactoringOptions {

  public static final RenameOptions[] EMPTY_ARRAY = new RenameOptions[0];

  public static final List<RenameOptions> EMPTY_LIST = List.of();

  /**
   * The name that the element should have after the refactoring.
   */
  private String newName;

  /**
   * Constructor for {@link RenameOptions}.
   */
  public RenameOptions(String newName) {
    this.newName = newName;
  }

  @Override
  public boolean equals(Object obj) {
    if (obj instanceof RenameOptions other) {
      return
        Objects.equals(other.newName, newName);
    }
    return false;
  }

  public static RenameOptions fromJson(JsonObject jsonObject) {
    String newName = jsonObject.get("newName").getAsString();
    return new RenameOptions(newName);
  }

  public static List<RenameOptions> fromJsonArray(JsonArray jsonArray) {
    if (jsonArray == null) {
      return EMPTY_LIST;
    }
    List<RenameOptions> list = new ArrayList<>(jsonArray.size());
    for (final JsonElement element : jsonArray) {
      list.add(fromJson(element.getAsJsonObject()));
    }
    return list;
  }

  /**
   * The name that the element should have after the refactoring.
   */
  public String getNewName() {
    return newName;
  }

  @Override
  public int hashCode() {
    return Objects.hash(
      newName
    );
  }

  /**
   * The name that the element should have after the refactoring.
   */
  public void setNewName(String newName) {
    this.newName = newName;
  }

  @Override
  public JsonObject toJson() {
    JsonObject jsonObject = new JsonObject();
    jsonObject.addProperty("newName", newName);
    return jsonObject;
  }

  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    builder.append("[");
    builder.append("newName=");
    builder.append(newName);
    builder.append("]");
    return builder.toString();
  }

}
