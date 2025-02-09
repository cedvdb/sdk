// Copyright (c) 2014, the Dart project authors. Please see the AUTHORS file
// for details. All rights reserved. Use of this source code is governed by a
// BSD-style license that can be found in the LICENSE file.

import 'package:analysis_server/protocol/protocol_generated.dart';
import 'package:test/test.dart';
import 'package:test_reflective_loader/test_reflective_loader.dart';

import '../support/integration_tests.dart';

void main() {
  defineReflectiveSuite(() {
    defineReflectiveTests(OccurrencesTest);
  });
}

@reflectiveTest
class OccurrencesTest extends AbstractAnalysisServerIntegrationTest {
  Future<void> test_occurrences() async {
    var pathname = sourcePath('test.dart');
    var text = r'''
void f() {
  int sum = 0;
  for (int i = 0; i < 10; i++) {
    for (int j = 0; j < i; j++) {
      sum += j;
    }
  }
  print(sum);
}
''';
    writeFile(pathname, text);
    await standardAnalysisSetup();
    await sendAnalysisSetSubscriptions({
      AnalysisService.OCCURRENCES: [pathname],
    });

    await analysisFinished;
    expect(currentAnalysisErrors[pathname], isEmpty);

    var params = await onAnalysisOccurrences.first;
    expect(params.file, equals(pathname));
    var occurrences = params.occurrences;

    Set<int> findOffsets(String elementName) {
      for (var occurrence in occurrences) {
        if (occurrence.element.name == elementName) {
          return occurrence.offsets.toSet();
        }
      }
      fail('No element found matching $elementName');
    }

    void check(String elementName, Iterable<String> expectedOccurrences) {
      var expectedOffsets =
          expectedOccurrences
              .map((String substring) => text.indexOf(substring))
              .toSet();
      var foundOffsets = findOffsets(elementName);
      expect(foundOffsets, equals(expectedOffsets));
    }

    check('i', ['i = 0', 'i < 10', 'i++', 'i;']);
    check('j', ['j = 0', 'j < i', 'j++', 'j;']);
    check('sum', ['sum = 0', 'sum +=', 'sum)']);
  }
}
