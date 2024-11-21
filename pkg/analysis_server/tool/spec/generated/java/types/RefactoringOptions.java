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
 * An abstract superclass of all refactoring options.
 *
 * @coverage dart.server.generated.types
 */
@SuppressWarnings("unused")
public class RefactoringOptions {

  public static final RefactoringOptions[] EMPTY_ARRAY = new RefactoringOptions[0];

  public static final List<RefactoringOptions> EMPTY_LIST = List.of();

  /**
   * Constructor for {@link RefactoringOptions}.
   */
  public RefactoringOptions() {
  }

  @Override
  public boolean equals(Object obj) {
    if (obj instanceof RefactoringOptions other) {
      return
        true;
    }
    return false;
  }

  public static RefactoringOptions fromJson(JsonObject jsonObject) {
    return new RefactoringOptions();
  }

  @Override
  public int hashCode() {
    return Objects.hash();
  }

  public JsonObject toJson() {
    JsonObject jsonObject = new JsonObject();
    return jsonObject;
  }

  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    builder.append("[");
    builder.append("]");
    return builder.toString();
  }

}
