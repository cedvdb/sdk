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
 * An attribute for a FlutterOutline.
 *
 * @coverage dart.server.generated.types
 */
@SuppressWarnings("unused")
public class FlutterOutlineAttribute {

  public static final FlutterOutlineAttribute[] EMPTY_ARRAY = new FlutterOutlineAttribute[0];

  public static final List<FlutterOutlineAttribute> EMPTY_LIST = List.of();

  /**
   * The name of the attribute.
   */
  private final String name;

  /**
   * The label of the attribute value, usually the Dart code. It might be quite long, the client
   * should abbreviate as needed.
   */
  private final String label;

  /**
   * The boolean literal value of the attribute. This field is absent if the value is not a boolean
   * literal.
   */
  private final Boolean literalValueBoolean;

  /**
   * The integer literal value of the attribute. This field is absent if the value is not an integer
   * literal.
   */
  private final Integer literalValueInteger;

  /**
   * The string literal value of the attribute. This field is absent if the value is not a string
   * literal.
   */
  private final String literalValueString;

  /**
   * If the attribute is a named argument, the location of the name, without the colon.
   */
  private final Location nameLocation;

  /**
   * The location of the value.
   *
   * This field is always available, but marked optional for backward compatibility between new
   * clients with older servers.
   */
  private final Location valueLocation;

  /**
   * Constructor for {@link FlutterOutlineAttribute}.
   */
  public FlutterOutlineAttribute(String name, String label, Boolean literalValueBoolean, Integer literalValueInteger, String literalValueString, Location nameLocation, Location valueLocation) {
    this.name = name;
    this.label = label;
    this.literalValueBoolean = literalValueBoolean;
    this.literalValueInteger = literalValueInteger;
    this.literalValueString = literalValueString;
    this.nameLocation = nameLocation;
    this.valueLocation = valueLocation;
  }

  @Override
  public boolean equals(Object obj) {
    if (obj instanceof FlutterOutlineAttribute other) {
      return
        Objects.equals(other.name, name) &&
        Objects.equals(other.label, label) &&
        Objects.equals(other.literalValueBoolean, literalValueBoolean) &&
        Objects.equals(other.literalValueInteger, literalValueInteger) &&
        Objects.equals(other.literalValueString, literalValueString) &&
        Objects.equals(other.nameLocation, nameLocation) &&
        Objects.equals(other.valueLocation, valueLocation);
    }
    return false;
  }

  public static FlutterOutlineAttribute fromJson(JsonObject jsonObject) {
    String name = jsonObject.get("name").getAsString();
    String label = jsonObject.get("label").getAsString();
    Boolean literalValueBoolean = jsonObject.get("literalValueBoolean") == null ? null : jsonObject.get("literalValueBoolean").getAsBoolean();
    Integer literalValueInteger = jsonObject.get("literalValueInteger") == null ? null : jsonObject.get("literalValueInteger").getAsInt();
    String literalValueString = jsonObject.get("literalValueString") == null ? null : jsonObject.get("literalValueString").getAsString();
    Location nameLocation = jsonObject.get("nameLocation") == null ? null : Location.fromJson(jsonObject.get("nameLocation").getAsJsonObject());
    Location valueLocation = jsonObject.get("valueLocation") == null ? null : Location.fromJson(jsonObject.get("valueLocation").getAsJsonObject());
    return new FlutterOutlineAttribute(name, label, literalValueBoolean, literalValueInteger, literalValueString, nameLocation, valueLocation);
  }

  public static List<FlutterOutlineAttribute> fromJsonArray(JsonArray jsonArray) {
    if (jsonArray == null) {
      return EMPTY_LIST;
    }
    List<FlutterOutlineAttribute> list = new ArrayList<>(jsonArray.size());
    for (final JsonElement element : jsonArray) {
      list.add(fromJson(element.getAsJsonObject()));
    }
    return list;
  }

  /**
   * The label of the attribute value, usually the Dart code. It might be quite long, the client
   * should abbreviate as needed.
   */
  public String getLabel() {
    return label;
  }

  /**
   * The boolean literal value of the attribute. This field is absent if the value is not a boolean
   * literal.
   */
  public Boolean getLiteralValueBoolean() {
    return literalValueBoolean;
  }

  /**
   * The integer literal value of the attribute. This field is absent if the value is not an integer
   * literal.
   */
  public Integer getLiteralValueInteger() {
    return literalValueInteger;
  }

  /**
   * The string literal value of the attribute. This field is absent if the value is not a string
   * literal.
   */
  public String getLiteralValueString() {
    return literalValueString;
  }

  /**
   * The name of the attribute.
   */
  public String getName() {
    return name;
  }

  /**
   * If the attribute is a named argument, the location of the name, without the colon.
   */
  public Location getNameLocation() {
    return nameLocation;
  }

  /**
   * The location of the value.
   *
   * This field is always available, but marked optional for backward compatibility between new
   * clients with older servers.
   */
  public Location getValueLocation() {
    return valueLocation;
  }

  @Override
  public int hashCode() {
    return Objects.hash(
      name,
      label,
      literalValueBoolean,
      literalValueInteger,
      literalValueString,
      nameLocation,
      valueLocation
    );
  }

  public JsonObject toJson() {
    JsonObject jsonObject = new JsonObject();
    jsonObject.addProperty("name", name);
    jsonObject.addProperty("label", label);
    if (literalValueBoolean != null) {
      jsonObject.addProperty("literalValueBoolean", literalValueBoolean);
    }
    if (literalValueInteger != null) {
      jsonObject.addProperty("literalValueInteger", literalValueInteger);
    }
    if (literalValueString != null) {
      jsonObject.addProperty("literalValueString", literalValueString);
    }
    if (nameLocation != null) {
      jsonObject.add("nameLocation", nameLocation.toJson());
    }
    if (valueLocation != null) {
      jsonObject.add("valueLocation", valueLocation.toJson());
    }
    return jsonObject;
  }

  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    builder.append("[");
    builder.append("name=");
    builder.append(name);
    builder.append(", ");
    builder.append("label=");
    builder.append(label);
    builder.append(", ");
    builder.append("literalValueBoolean=");
    builder.append(literalValueBoolean);
    builder.append(", ");
    builder.append("literalValueInteger=");
    builder.append(literalValueInteger);
    builder.append(", ");
    builder.append("literalValueString=");
    builder.append(literalValueString);
    builder.append(", ");
    builder.append("nameLocation=");
    builder.append(nameLocation);
    builder.append(", ");
    builder.append("valueLocation=");
    builder.append(valueLocation);
    builder.append("]");
    return builder.toString();
  }

}
