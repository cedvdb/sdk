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
public class ExtractMethodFeedback extends RefactoringFeedback {

  public static final ExtractMethodFeedback[] EMPTY_ARRAY = new ExtractMethodFeedback[0];

  public static final List<ExtractMethodFeedback> EMPTY_LIST = List.of();

  /**
   * The offset to the beginning of the expression or statements that will be extracted.
   */
  private final int offset;

  /**
   * The length of the expression or statements that will be extracted.
   */
  private final int length;

  /**
   * The proposed return type for the method. If the returned element does not have a declared return
   * type, this field will contain an empty string.
   */
  private final String returnType;

  /**
   * The proposed names for the method.
   */
  private final List<String> names;

  /**
   * True if a getter could be created rather than a method.
   */
  private final boolean canCreateGetter;

  /**
   * The proposed parameters for the method.
   */
  private final List<RefactoringMethodParameter> parameters;

  /**
   * The offsets of the expressions or statements that would be replaced by an invocation of the
   * method.
   */
  private final int[] offsets;

  /**
   * The lengths of the expressions or statements that would be replaced by an invocation of the
   * method. The lengths correspond to the offsets. In other words, for a given expression (or block
   * of statements), if the offset of that expression is offsets[i], then the length of that
   * expression is lengths[i].
   */
  private final int[] lengths;

  /**
   * Constructor for {@link ExtractMethodFeedback}.
   */
  public ExtractMethodFeedback(int offset, int length, String returnType, List<String> names, boolean canCreateGetter, List<RefactoringMethodParameter> parameters, int[] offsets, int[] lengths) {
    this.offset = offset;
    this.length = length;
    this.returnType = returnType;
    this.names = names;
    this.canCreateGetter = canCreateGetter;
    this.parameters = parameters;
    this.offsets = offsets;
    this.lengths = lengths;
  }

  @Override
  public boolean equals(Object obj) {
    if (obj instanceof ExtractMethodFeedback other) {
      return
        other.offset == offset &&
        other.length == length &&
        Objects.equals(other.returnType, returnType) &&
        Objects.equals(other.names, names) &&
        other.canCreateGetter == canCreateGetter &&
        Objects.equals(other.parameters, parameters) &&
        Arrays.equals(other.offsets, offsets) &&
        Arrays.equals(other.lengths, lengths);
    }
    return false;
  }

  public static ExtractMethodFeedback fromJson(JsonObject jsonObject) {
    int offset = jsonObject.get("offset").getAsInt();
    int length = jsonObject.get("length").getAsInt();
    String returnType = jsonObject.get("returnType").getAsString();
    List<String> names = JsonUtilities.decodeStringList(jsonObject.get("names").getAsJsonArray());
    boolean canCreateGetter = jsonObject.get("canCreateGetter").getAsBoolean();
    List<RefactoringMethodParameter> parameters = RefactoringMethodParameter.fromJsonArray(jsonObject.get("parameters").getAsJsonArray());
    int[] offsets = JsonUtilities.decodeIntArray(jsonObject.get("offsets").getAsJsonArray());
    int[] lengths = JsonUtilities.decodeIntArray(jsonObject.get("lengths").getAsJsonArray());
    return new ExtractMethodFeedback(offset, length, returnType, names, canCreateGetter, parameters, offsets, lengths);
  }

  public static List<ExtractMethodFeedback> fromJsonArray(JsonArray jsonArray) {
    if (jsonArray == null) {
      return EMPTY_LIST;
    }
    List<ExtractMethodFeedback> list = new ArrayList<>(jsonArray.size());
    for (final JsonElement element : jsonArray) {
      list.add(fromJson(element.getAsJsonObject()));
    }
    return list;
  }

  /**
   * True if a getter could be created rather than a method.
   */
  public boolean canCreateGetter() {
    return canCreateGetter;
  }

  /**
   * The length of the expression or statements that will be extracted.
   */
  public int getLength() {
    return length;
  }

  /**
   * The lengths of the expressions or statements that would be replaced by an invocation of the
   * method. The lengths correspond to the offsets. In other words, for a given expression (or block
   * of statements), if the offset of that expression is offsets[i], then the length of that
   * expression is lengths[i].
   */
  public int[] getLengths() {
    return lengths;
  }

  /**
   * The proposed names for the method.
   */
  public List<String> getNames() {
    return names;
  }

  /**
   * The offset to the beginning of the expression or statements that will be extracted.
   */
  public int getOffset() {
    return offset;
  }

  /**
   * The offsets of the expressions or statements that would be replaced by an invocation of the
   * method.
   */
  public int[] getOffsets() {
    return offsets;
  }

  /**
   * The proposed parameters for the method.
   */
  public List<RefactoringMethodParameter> getParameters() {
    return parameters;
  }

  /**
   * The proposed return type for the method. If the returned element does not have a declared return
   * type, this field will contain an empty string.
   */
  public String getReturnType() {
    return returnType;
  }

  @Override
  public int hashCode() {
    return Objects.hash(
      offset,
      length,
      returnType,
      names,
      canCreateGetter,
      parameters,
      Arrays.hashCode(offsets),
      Arrays.hashCode(lengths)
    );
  }

  @Override
  public JsonObject toJson() {
    JsonObject jsonObject = new JsonObject();
    jsonObject.addProperty("offset", offset);
    jsonObject.addProperty("length", length);
    jsonObject.addProperty("returnType", returnType);
    JsonArray jsonArrayNames = new JsonArray();
    for (String elt : names) {
      jsonArrayNames.add(new JsonPrimitive(elt));
    }
    jsonObject.add("names", jsonArrayNames);
    jsonObject.addProperty("canCreateGetter", canCreateGetter);
    JsonArray jsonArrayParameters = new JsonArray();
    for (RefactoringMethodParameter elt : parameters) {
      jsonArrayParameters.add(elt.toJson());
    }
    jsonObject.add("parameters", jsonArrayParameters);
    JsonArray jsonArrayOffsets = new JsonArray();
    for (int elt : offsets) {
      jsonArrayOffsets.add(new JsonPrimitive(elt));
    }
    jsonObject.add("offsets", jsonArrayOffsets);
    JsonArray jsonArrayLengths = new JsonArray();
    for (int elt : lengths) {
      jsonArrayLengths.add(new JsonPrimitive(elt));
    }
    jsonObject.add("lengths", jsonArrayLengths);
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
    builder.append("returnType=");
    builder.append(returnType);
    builder.append(", ");
    builder.append("names=");
    builder.append(names.stream().map(String::valueOf).collect(Collectors.joining(", ")));
    builder.append(", ");
    builder.append("canCreateGetter=");
    builder.append(canCreateGetter);
    builder.append(", ");
    builder.append("parameters=");
    builder.append(parameters.stream().map(String::valueOf).collect(Collectors.joining(", ")));
    builder.append(", ");
    builder.append("offsets=");
    builder.append(Arrays.stream(offsets).mapToObj(String::valueOf).collect(Collectors.joining(", ")));
    builder.append(", ");
    builder.append("lengths=");
    builder.append(Arrays.stream(lengths).mapToObj(String::valueOf).collect(Collectors.joining(", ")));
    builder.append("]");
    return builder.toString();
  }

}
