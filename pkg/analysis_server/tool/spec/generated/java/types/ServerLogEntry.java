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
 * A log entry from the server.
 *
 * @coverage dart.server.generated.types
 */
@SuppressWarnings("unused")
public class ServerLogEntry {

  public static final ServerLogEntry[] EMPTY_ARRAY = new ServerLogEntry[0];

  public static final List<ServerLogEntry> EMPTY_LIST = List.of();

  /**
   * The time (milliseconds since epoch) at which the server created this log entry.
   */
  private final int time;

  /**
   * The kind of the entry, used to determine how to interpret the "data" field.
   */
  private final String kind;

  /**
   * The payload of the entry, the actual format is determined by the "kind" field.
   */
  private final String data;

  /**
   * Constructor for {@link ServerLogEntry}.
   */
  public ServerLogEntry(int time, String kind, String data) {
    this.time = time;
    this.kind = kind;
    this.data = data;
  }

  @Override
  public boolean equals(Object obj) {
    if (obj instanceof ServerLogEntry other) {
      return
        other.time == time &&
        Objects.equals(other.kind, kind) &&
        Objects.equals(other.data, data);
    }
    return false;
  }

  public static ServerLogEntry fromJson(JsonObject jsonObject) {
    int time = jsonObject.get("time").getAsInt();
    String kind = jsonObject.get("kind").getAsString();
    String data = jsonObject.get("data").getAsString();
    return new ServerLogEntry(time, kind, data);
  }

  public static List<ServerLogEntry> fromJsonArray(JsonArray jsonArray) {
    if (jsonArray == null) {
      return EMPTY_LIST;
    }
    List<ServerLogEntry> list = new ArrayList<>(jsonArray.size());
    for (final JsonElement element : jsonArray) {
      list.add(fromJson(element.getAsJsonObject()));
    }
    return list;
  }

  /**
   * The payload of the entry, the actual format is determined by the "kind" field.
   */
  public String getData() {
    return data;
  }

  /**
   * The kind of the entry, used to determine how to interpret the "data" field.
   */
  public String getKind() {
    return kind;
  }

  /**
   * The time (milliseconds since epoch) at which the server created this log entry.
   */
  public int getTime() {
    return time;
  }

  @Override
  public int hashCode() {
    return Objects.hash(
      time,
      kind,
      data
    );
  }

  public JsonObject toJson() {
    JsonObject jsonObject = new JsonObject();
    jsonObject.addProperty("time", time);
    jsonObject.addProperty("kind", kind);
    jsonObject.addProperty("data", data);
    return jsonObject;
  }

  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    builder.append("[");
    builder.append("time=");
    builder.append(time);
    builder.append(", ");
    builder.append("kind=");
    builder.append(kind);
    builder.append(", ");
    builder.append("data=");
    builder.append(data);
    builder.append("]");
    return builder.toString();
  }

}
