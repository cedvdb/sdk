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
 * An node in the Flutter specific outline structure of a file.
 *
 * @coverage dart.server.generated.types
 */
@SuppressWarnings("unused")
public class FlutterOutline {

  public static final FlutterOutline[] EMPTY_ARRAY = new FlutterOutline[0];

  public static final List<FlutterOutline> EMPTY_LIST = List.of();

  /**
   * The kind of the node.
   */
  private final String kind;

  /**
   * The offset of the first character of the element. This is different than the offset in the
   * Element, which is the offset of the name of the element. It can be used, for example, to map
   * locations in the file back to an outline.
   */
  private final int offset;

  /**
   * The length of the element.
   */
  private final int length;

  /**
   * The offset of the first character of the element code, which is neither documentation, nor
   * annotation.
   */
  private final int codeOffset;

  /**
   * The length of the element code.
   */
  private final int codeLength;

  /**
   * The text label of the node children of the node. It is provided for any
   * FlutterOutlineKind.GENERIC node, where better information is not available.
   */
  private final String label;

  /**
   * If this node is a Dart element, the description of it; omitted otherwise.
   */
  private final Element dartElement;

  /**
   * Additional attributes for this node, which might be interesting to display on the client. These
   * attributes are usually arguments for the instance creation or the invocation that created the
   * widget.
   */
  private final List<FlutterOutlineAttribute> attributes;

  /**
   * If the node creates a new class instance, or a reference to an instance, this field has the name
   * of the class.
   */
  private final String className;

  /**
   * A short text description how this node is associated with the parent node. For example "appBar"
   * or "body" in Scaffold.
   */
  private final String parentAssociationLabel;

  /**
   * If FlutterOutlineKind.VARIABLE, the name of the variable.
   */
  private final String variableName;

  /**
   * The children of the node. The field will be omitted if the node has no children.
   */
  private final List<FlutterOutline> children;

  /**
   * Constructor for {@link FlutterOutline}.
   */
  public FlutterOutline(String kind, int offset, int length, int codeOffset, int codeLength, String label, Element dartElement, List<FlutterOutlineAttribute> attributes, String className, String parentAssociationLabel, String variableName, List<FlutterOutline> children) {
    this.kind = kind;
    this.offset = offset;
    this.length = length;
    this.codeOffset = codeOffset;
    this.codeLength = codeLength;
    this.label = label;
    this.dartElement = dartElement;
    this.attributes = attributes;
    this.className = className;
    this.parentAssociationLabel = parentAssociationLabel;
    this.variableName = variableName;
    this.children = children;
  }

  @Override
  public boolean equals(Object obj) {
    if (obj instanceof FlutterOutline other) {
      return
        Objects.equals(other.kind, kind) &&
        other.offset == offset &&
        other.length == length &&
        other.codeOffset == codeOffset &&
        other.codeLength == codeLength &&
        Objects.equals(other.label, label) &&
        Objects.equals(other.dartElement, dartElement) &&
        Objects.equals(other.attributes, attributes) &&
        Objects.equals(other.className, className) &&
        Objects.equals(other.parentAssociationLabel, parentAssociationLabel) &&
        Objects.equals(other.variableName, variableName) &&
        Objects.equals(other.children, children);
    }
    return false;
  }

  public static FlutterOutline fromJson(JsonObject jsonObject) {
    String kind = jsonObject.get("kind").getAsString();
    int offset = jsonObject.get("offset").getAsInt();
    int length = jsonObject.get("length").getAsInt();
    int codeOffset = jsonObject.get("codeOffset").getAsInt();
    int codeLength = jsonObject.get("codeLength").getAsInt();
    String label = jsonObject.get("label") == null ? null : jsonObject.get("label").getAsString();
    Element dartElement = jsonObject.get("dartElement") == null ? null : Element.fromJson(jsonObject.get("dartElement").getAsJsonObject());
    List<FlutterOutlineAttribute> attributes = jsonObject.get("attributes") == null ? null : FlutterOutlineAttribute.fromJsonArray(jsonObject.get("attributes").getAsJsonArray());
    String className = jsonObject.get("className") == null ? null : jsonObject.get("className").getAsString();
    String parentAssociationLabel = jsonObject.get("parentAssociationLabel") == null ? null : jsonObject.get("parentAssociationLabel").getAsString();
    String variableName = jsonObject.get("variableName") == null ? null : jsonObject.get("variableName").getAsString();
    List<FlutterOutline> children = jsonObject.get("children") == null ? null : FlutterOutline.fromJsonArray(jsonObject.get("children").getAsJsonArray());
    return new FlutterOutline(kind, offset, length, codeOffset, codeLength, label, dartElement, attributes, className, parentAssociationLabel, variableName, children);
  }

  public static List<FlutterOutline> fromJsonArray(JsonArray jsonArray) {
    if (jsonArray == null) {
      return EMPTY_LIST;
    }
    List<FlutterOutline> list = new ArrayList<>(jsonArray.size());
    for (final JsonElement element : jsonArray) {
      list.add(fromJson(element.getAsJsonObject()));
    }
    return list;
  }

  /**
   * Additional attributes for this node, which might be interesting to display on the client. These
   * attributes are usually arguments for the instance creation or the invocation that created the
   * widget.
   */
  public List<FlutterOutlineAttribute> getAttributes() {
    return attributes;
  }

  /**
   * The children of the node. The field will be omitted if the node has no children.
   */
  public List<FlutterOutline> getChildren() {
    return children;
  }

  /**
   * If the node creates a new class instance, or a reference to an instance, this field has the name
   * of the class.
   */
  public String getClassName() {
    return className;
  }

  /**
   * The length of the element code.
   */
  public int getCodeLength() {
    return codeLength;
  }

  /**
   * The offset of the first character of the element code, which is neither documentation, nor
   * annotation.
   */
  public int getCodeOffset() {
    return codeOffset;
  }

  /**
   * If this node is a Dart element, the description of it; omitted otherwise.
   */
  public Element getDartElement() {
    return dartElement;
  }

  /**
   * The kind of the node.
   */
  public String getKind() {
    return kind;
  }

  /**
   * The text label of the node children of the node. It is provided for any
   * FlutterOutlineKind.GENERIC node, where better information is not available.
   */
  public String getLabel() {
    return label;
  }

  /**
   * The length of the element.
   */
  public int getLength() {
    return length;
  }

  /**
   * The offset of the first character of the element. This is different than the offset in the
   * Element, which is the offset of the name of the element. It can be used, for example, to map
   * locations in the file back to an outline.
   */
  public int getOffset() {
    return offset;
  }

  /**
   * A short text description how this node is associated with the parent node. For example "appBar"
   * or "body" in Scaffold.
   */
  public String getParentAssociationLabel() {
    return parentAssociationLabel;
  }

  /**
   * If FlutterOutlineKind.VARIABLE, the name of the variable.
   */
  public String getVariableName() {
    return variableName;
  }

  @Override
  public int hashCode() {
    return Objects.hash(
      kind,
      offset,
      length,
      codeOffset,
      codeLength,
      label,
      dartElement,
      attributes,
      className,
      parentAssociationLabel,
      variableName,
      children
    );
  }

  public JsonObject toJson() {
    JsonObject jsonObject = new JsonObject();
    jsonObject.addProperty("kind", kind);
    jsonObject.addProperty("offset", offset);
    jsonObject.addProperty("length", length);
    jsonObject.addProperty("codeOffset", codeOffset);
    jsonObject.addProperty("codeLength", codeLength);
    if (label != null) {
      jsonObject.addProperty("label", label);
    }
    if (dartElement != null) {
      jsonObject.add("dartElement", dartElement.toJson());
    }
    if (attributes != null) {
      JsonArray jsonArrayAttributes = new JsonArray();
      for (FlutterOutlineAttribute elt : attributes) {
        jsonArrayAttributes.add(elt.toJson());
      }
      jsonObject.add("attributes", jsonArrayAttributes);
    }
    if (className != null) {
      jsonObject.addProperty("className", className);
    }
    if (parentAssociationLabel != null) {
      jsonObject.addProperty("parentAssociationLabel", parentAssociationLabel);
    }
    if (variableName != null) {
      jsonObject.addProperty("variableName", variableName);
    }
    if (children != null) {
      JsonArray jsonArrayChildren = new JsonArray();
      for (FlutterOutline elt : children) {
        jsonArrayChildren.add(elt.toJson());
      }
      jsonObject.add("children", jsonArrayChildren);
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
    builder.append("offset=");
    builder.append(offset);
    builder.append(", ");
    builder.append("length=");
    builder.append(length);
    builder.append(", ");
    builder.append("codeOffset=");
    builder.append(codeOffset);
    builder.append(", ");
    builder.append("codeLength=");
    builder.append(codeLength);
    builder.append(", ");
    builder.append("label=");
    builder.append(label);
    builder.append(", ");
    builder.append("dartElement=");
    builder.append(dartElement);
    builder.append(", ");
    builder.append("attributes=");
    builder.append(attributes == null ? "null" : attributes.stream().map(String::valueOf).collect(Collectors.joining(", ")));
    builder.append(", ");
    builder.append("className=");
    builder.append(className);
    builder.append(", ");
    builder.append("parentAssociationLabel=");
    builder.append(parentAssociationLabel);
    builder.append(", ");
    builder.append("variableName=");
    builder.append(variableName);
    builder.append(", ");
    builder.append("children=");
    builder.append(children == null ? "null" : children.stream().map(String::valueOf).collect(Collectors.joining(", ")));
    builder.append("]");
    return builder.toString();
  }

}
