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
 * A description of a target to which the user can navigate.
 *
 * @coverage dart.server.generated.types
 */
@SuppressWarnings("unused")
public class NavigationTarget {

  public static final NavigationTarget[] EMPTY_ARRAY = new NavigationTarget[0];

  public static final List<NavigationTarget> EMPTY_LIST = List.of();

  /**
   * The kind of the element.
   */
  private final String kind;

  /**
   * The index of the file (in the enclosing navigation response) to navigate to.
   */
  private final int fileIndex;

  /**
   * The offset of the name of the target to which the user can navigate.
   */
  private final int offset;

  /**
   * The length of the name of the target to which the user can navigate.
   */
  private final int length;

  /**
   * The one-based index of the line containing the first character of the name of the target.
   */
  private final int startLine;

  /**
   * The one-based index of the column containing the first character of the name of the target.
   */
  private final int startColumn;

  /**
   * The offset of the target code to which the user can navigate.
   */
  private final Integer codeOffset;

  /**
   * The length of the target code to which the user can navigate.
   */
  private final Integer codeLength;

  private String file;

  /**
   * Constructor for {@link NavigationTarget}.
   */
  public NavigationTarget(String kind, int fileIndex, int offset, int length, int startLine, int startColumn, Integer codeOffset, Integer codeLength) {
    this.kind = kind;
    this.fileIndex = fileIndex;
    this.offset = offset;
    this.length = length;
    this.startLine = startLine;
    this.startColumn = startColumn;
    this.codeOffset = codeOffset;
    this.codeLength = codeLength;
  }

  @Override
  public boolean equals(Object obj) {
    if (obj instanceof NavigationTarget other) {
      return
        Objects.equals(other.kind, kind) &&
        other.fileIndex == fileIndex &&
        other.offset == offset &&
        other.length == length &&
        other.startLine == startLine &&
        other.startColumn == startColumn &&
        Objects.equals(other.codeOffset, codeOffset) &&
        Objects.equals(other.codeLength, codeLength);
    }
    return false;
  }

  public static NavigationTarget fromJson(JsonObject jsonObject) {
    String kind = jsonObject.get("kind").getAsString();
    int fileIndex = jsonObject.get("fileIndex").getAsInt();
    int offset = jsonObject.get("offset").getAsInt();
    int length = jsonObject.get("length").getAsInt();
    int startLine = jsonObject.get("startLine").getAsInt();
    int startColumn = jsonObject.get("startColumn").getAsInt();
    Integer codeOffset = jsonObject.get("codeOffset") == null ? null : jsonObject.get("codeOffset").getAsInt();
    Integer codeLength = jsonObject.get("codeLength") == null ? null : jsonObject.get("codeLength").getAsInt();
    return new NavigationTarget(kind, fileIndex, offset, length, startLine, startColumn, codeOffset, codeLength);
  }

  public static List<NavigationTarget> fromJsonArray(JsonArray jsonArray) {
    if (jsonArray == null) {
      return EMPTY_LIST;
    }
    List<NavigationTarget> list = new ArrayList<>(jsonArray.size());
    for (final JsonElement element : jsonArray) {
      list.add(fromJson(element.getAsJsonObject()));
    }
    return list;
  }

  public String getFile() {
    return file;
  }

  /**
   * The length of the target code to which the user can navigate.
   */
  public Integer getCodeLength() {
    return codeLength;
  }

  /**
   * The offset of the target code to which the user can navigate.
   */
  public Integer getCodeOffset() {
    return codeOffset;
  }

  /**
   * The index of the file (in the enclosing navigation response) to navigate to.
   */
  public int getFileIndex() {
    return fileIndex;
  }

  /**
   * The kind of the element.
   */
  public String getKind() {
    return kind;
  }

  /**
   * The length of the name of the target to which the user can navigate.
   */
  public int getLength() {
    return length;
  }

  /**
   * The offset of the name of the target to which the user can navigate.
   */
  public int getOffset() {
    return offset;
  }

  /**
   * The one-based index of the column containing the first character of the name of the target.
   */
  public int getStartColumn() {
    return startColumn;
  }

  /**
   * The one-based index of the line containing the first character of the name of the target.
   */
  public int getStartLine() {
    return startLine;
  }

  @Override
  public int hashCode() {
    return Objects.hash(
      kind,
      fileIndex,
      offset,
      length,
      startLine,
      startColumn,
      codeOffset,
      codeLength
    );
  }

  public void lookupFile(String[] allTargetFiles) {
    file = allTargetFiles[fileIndex];
  }

  public JsonObject toJson() {
    JsonObject jsonObject = new JsonObject();
    jsonObject.addProperty("kind", kind);
    jsonObject.addProperty("fileIndex", fileIndex);
    jsonObject.addProperty("offset", offset);
    jsonObject.addProperty("length", length);
    jsonObject.addProperty("startLine", startLine);
    jsonObject.addProperty("startColumn", startColumn);
    if (codeOffset != null) {
      jsonObject.addProperty("codeOffset", codeOffset);
    }
    if (codeLength != null) {
      jsonObject.addProperty("codeLength", codeLength);
    }
    return jsonObject;
  }

  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    builder.append("[");
    builder.append("kind=");
    builder.append(kind);
    builder.append(", ");
    builder.append("fileIndex=");
    builder.append(fileIndex);
    builder.append(", ");
    builder.append("offset=");
    builder.append(offset);
    builder.append(", ");
    builder.append("length=");
    builder.append(length);
    builder.append(", ");
    builder.append("startLine=");
    builder.append(startLine);
    builder.append(", ");
    builder.append("startColumn=");
    builder.append(startColumn);
    builder.append(", ");
    builder.append("codeOffset=");
    builder.append(codeOffset);
    builder.append(", ");
    builder.append("codeLength=");
    builder.append(codeLength);
    builder.append("]");
    return builder.toString();
  }

}
