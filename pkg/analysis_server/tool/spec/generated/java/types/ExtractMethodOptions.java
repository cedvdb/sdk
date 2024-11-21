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
public class ExtractMethodOptions extends RefactoringOptions {

  public static final ExtractMethodOptions[] EMPTY_ARRAY = new ExtractMethodOptions[0];

  public static final List<ExtractMethodOptions> EMPTY_LIST = List.of();

  /**
   * The return type that should be defined for the method.
   */
  private String returnType;

  /**
   * True if a getter should be created rather than a method. It is an error if this field is true
   * and the list of parameters is non-empty.
   */
  private boolean createGetter;

  /**
   * The name that the method should be given.
   */
  private String name;

  /**
   * The parameters that should be defined for the method.
   *
   * It is an error if a REQUIRED or NAMED parameter follows a POSITIONAL parameter. It is an error
   * if a REQUIRED or POSITIONAL parameter follows a NAMED parameter.
   *
   * - To change the order and/or update proposed parameters, add parameters with the same
   *   identifiers as proposed.
   * - To add new parameters, omit their identifier.
   * - To remove some parameters, omit them in this list.
   */
  private List<RefactoringMethodParameter> parameters;

  /**
   * True if all occurrences of the expression or statements should be replaced by an invocation of
   * the method. The expression or statements used to initiate the refactoring will always be
   * replaced.
   */
  private boolean extractAll;

  /**
   * Constructor for {@link ExtractMethodOptions}.
   */
  public ExtractMethodOptions(String returnType, boolean createGetter, String name, List<RefactoringMethodParameter> parameters, boolean extractAll) {
    this.returnType = returnType;
    this.createGetter = createGetter;
    this.name = name;
    this.parameters = parameters;
    this.extractAll = extractAll;
  }

  @Override
  public boolean equals(Object obj) {
    if (obj instanceof ExtractMethodOptions other) {
      return
        Objects.equals(other.returnType, returnType) &&
        other.createGetter == createGetter &&
        Objects.equals(other.name, name) &&
        Objects.equals(other.parameters, parameters) &&
        other.extractAll == extractAll;
    }
    return false;
  }

  public static ExtractMethodOptions fromJson(JsonObject jsonObject) {
    String returnType = jsonObject.get("returnType").getAsString();
    boolean createGetter = jsonObject.get("createGetter").getAsBoolean();
    String name = jsonObject.get("name").getAsString();
    List<RefactoringMethodParameter> parameters = RefactoringMethodParameter.fromJsonArray(jsonObject.get("parameters").getAsJsonArray());
    boolean extractAll = jsonObject.get("extractAll").getAsBoolean();
    return new ExtractMethodOptions(returnType, createGetter, name, parameters, extractAll);
  }

  public static List<ExtractMethodOptions> fromJsonArray(JsonArray jsonArray) {
    if (jsonArray == null) {
      return EMPTY_LIST;
    }
    List<ExtractMethodOptions> list = new ArrayList<>(jsonArray.size());
    for (final JsonElement element : jsonArray) {
      list.add(fromJson(element.getAsJsonObject()));
    }
    return list;
  }

  /**
   * True if a getter should be created rather than a method. It is an error if this field is true
   * and the list of parameters is non-empty.
   */
  public boolean createGetter() {
    return createGetter;
  }

  /**
   * True if all occurrences of the expression or statements should be replaced by an invocation of
   * the method. The expression or statements used to initiate the refactoring will always be
   * replaced.
   */
  public boolean extractAll() {
    return extractAll;
  }

  /**
   * The name that the method should be given.
   */
  public String getName() {
    return name;
  }

  /**
   * The parameters that should be defined for the method.
   *
   * It is an error if a REQUIRED or NAMED parameter follows a POSITIONAL parameter. It is an error
   * if a REQUIRED or POSITIONAL parameter follows a NAMED parameter.
   *
   * - To change the order and/or update proposed parameters, add parameters with the same
   *   identifiers as proposed.
   * - To add new parameters, omit their identifier.
   * - To remove some parameters, omit them in this list.
   */
  public List<RefactoringMethodParameter> getParameters() {
    return parameters;
  }

  /**
   * The return type that should be defined for the method.
   */
  public String getReturnType() {
    return returnType;
  }

  @Override
  public int hashCode() {
    return Objects.hash(
      returnType,
      createGetter,
      name,
      parameters,
      extractAll
    );
  }

  /**
   * True if a getter should be created rather than a method. It is an error if this field is true
   * and the list of parameters is non-empty.
   */
  public void setCreateGetter(boolean createGetter) {
    this.createGetter = createGetter;
  }

  /**
   * True if all occurrences of the expression or statements should be replaced by an invocation of
   * the method. The expression or statements used to initiate the refactoring will always be
   * replaced.
   */
  public void setExtractAll(boolean extractAll) {
    this.extractAll = extractAll;
  }

  /**
   * The name that the method should be given.
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * The parameters that should be defined for the method.
   *
   * It is an error if a REQUIRED or NAMED parameter follows a POSITIONAL parameter. It is an error
   * if a REQUIRED or POSITIONAL parameter follows a NAMED parameter.
   *
   * - To change the order and/or update proposed parameters, add parameters with the same
   *   identifiers as proposed.
   * - To add new parameters, omit their identifier.
   * - To remove some parameters, omit them in this list.
   */
  public void setParameters(List<RefactoringMethodParameter> parameters) {
    this.parameters = parameters;
  }

  /**
   * The return type that should be defined for the method.
   */
  public void setReturnType(String returnType) {
    this.returnType = returnType;
  }

  @Override
  public JsonObject toJson() {
    JsonObject jsonObject = new JsonObject();
    jsonObject.addProperty("returnType", returnType);
    jsonObject.addProperty("createGetter", createGetter);
    jsonObject.addProperty("name", name);
    JsonArray jsonArrayParameters = new JsonArray();
    for (RefactoringMethodParameter elt : parameters) {
      jsonArrayParameters.add(elt.toJson());
    }
    jsonObject.add("parameters", jsonArrayParameters);
    jsonObject.addProperty("extractAll", extractAll);
    return jsonObject;
  }

  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    builder.append("[");
    builder.append("returnType=");
    builder.append(returnType);
    builder.append(", ");
    builder.append("createGetter=");
    builder.append(createGetter);
    builder.append(", ");
    builder.append("name=");
    builder.append(name);
    builder.append(", ");
    builder.append("parameters=");
    builder.append(parameters.stream().map(String::valueOf).collect(Collectors.joining(", ")));
    builder.append(", ");
    builder.append("extractAll=");
    builder.append(extractAll);
    builder.append("]");
    return builder.toString();
  }

}
