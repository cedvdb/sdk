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
 * An abstract superclass of all refactoring feedbacks.
 *
 * @coverage dart.server.generated.types
 */
@SuppressWarnings("unused")
public class RefactoringFeedback {

  public static final RefactoringFeedback[] EMPTY_ARRAY = new RefactoringFeedback[0];

  public static final List<RefactoringFeedback> EMPTY_LIST = List.of();

  /**
   * Constructor for {@link RefactoringFeedback}.
   */
  public RefactoringFeedback() {
  }

  @Override
  public boolean equals(Object obj) {
    if (obj instanceof RefactoringFeedback other) {
      return
        true;
    }
    return false;
  }

  public static RefactoringFeedback fromJson(JsonObject jsonObject) {
    return new RefactoringFeedback();
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
