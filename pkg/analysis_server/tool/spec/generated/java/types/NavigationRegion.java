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
 * A description of a region from which the user can navigate to the declaration of an element.
 *
 * @coverage dart.server.generated.types
 */
@SuppressWarnings("unused")
public class NavigationRegion {

  public static final NavigationRegion[] EMPTY_ARRAY = new NavigationRegion[0];

  public static final List<NavigationRegion> EMPTY_LIST = List.of();

  /**
   * The offset of the region from which the user can navigate.
   */
  private final int offset;

  /**
   * The length of the region from which the user can navigate.
   */
  private final int length;

  /**
   * The indexes of the targets (in the enclosing navigation response) to which the given region is
   * bound. By opening the target, clients can implement one form of navigation. This list cannot be
   * empty.
   */
  private final int[] targets;

  private final List<NavigationTarget> targetObjects = new ArrayList<>();

  /**
   * Constructor for {@link NavigationRegion}.
   */
  public NavigationRegion(int offset, int length, int[] targets) {
    this.offset = offset;
    this.length = length;
    this.targets = targets;
  }

  public boolean containsInclusive(int x) {
    return offset <= x && x <= offset + length;
  }

  @Override
  public boolean equals(Object obj) {
    if (obj instanceof NavigationRegion other) {
      return
        other.offset == offset &&
        other.length == length &&
        Arrays.equals(other.targets, targets);
    }
    return false;
  }

  public static NavigationRegion fromJson(JsonObject jsonObject) {
    int offset = jsonObject.get("offset").getAsInt();
    int length = jsonObject.get("length").getAsInt();
    int[] targets = JsonUtilities.decodeIntArray(jsonObject.get("targets").getAsJsonArray());
    return new NavigationRegion(offset, length, targets);
  }

  public static List<NavigationRegion> fromJsonArray(JsonArray jsonArray) {
    if (jsonArray == null) {
      return EMPTY_LIST;
    }
    List<NavigationRegion> list = new ArrayList<>(jsonArray.size());
    for (final JsonElement element : jsonArray) {
      list.add(fromJson(element.getAsJsonObject()));
    }
    return list;
  }

  public List<NavigationTarget> getTargetObjects() {
    return targetObjects;
  }

  /**
   * The length of the region from which the user can navigate.
   */
  public int getLength() {
    return length;
  }

  /**
   * The offset of the region from which the user can navigate.
   */
  public int getOffset() {
    return offset;
  }

  /**
   * The indexes of the targets (in the enclosing navigation response) to which the given region is
   * bound. By opening the target, clients can implement one form of navigation. This list cannot be
   * empty.
   */
  public int[] getTargets() {
    return targets;
  }

  @Override
  public int hashCode() {
    return Objects.hash(
      offset,
      length,
      Arrays.hashCode(targets)
    );
  }

  public void lookupTargets(List<NavigationTarget> allTargets) {
    for (int targetIndex : targets) {
      NavigationTarget target = allTargets.get(targetIndex);
      targetObjects.add(target);
    }
  }

  public JsonObject toJson() {
    JsonObject jsonObject = new JsonObject();
    jsonObject.addProperty("offset", offset);
    jsonObject.addProperty("length", length);
    JsonArray jsonArrayTargets = new JsonArray();
    for (int elt : targets) {
      jsonArrayTargets.add(new JsonPrimitive(elt));
    }
    jsonObject.add("targets", jsonArrayTargets);
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
    builder.append("targets=");
    builder.append(Arrays.stream(targets).mapToObj(String::valueOf).collect(Collectors.joining(", ")));
    builder.append("]");
    return builder.toString();
  }

}
