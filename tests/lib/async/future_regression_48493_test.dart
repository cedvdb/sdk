// Copyright (c) 2022, the Dart project authors.  Please see the AUTHORS file
// for details. All rights reserved. Use of this source code is governed by a
// BSD-style license that can be found in the LICENSE file.

// Regression test for http://dartbug.com/48493
//
// The `Completer.complete` method, given an already completed `_Future`
// with a value result, will complete the `Completer.future` synchronously.

import 'dart:async';

import 'package:expect/async_helper.dart';
import 'package:expect/expect.dart';

void main() async {
  asyncStart();

  var completer = Completer<int>(); // Not synchronous.
  var future = Future<int>.value(4);
  await future; // Ensure future completed.
  bool thenRun = false;
  completer.future.then((_) {
    thenRun = true;
  });
  Expect.isFalse(thenRun, "Sanity check");
  completer.complete(future);
  Expect.isFalse(thenRun, "Ran early"); // Bug would cause this to fail.
  await Future(() {}); // Await timer, all microtasks completed.
  Expect.isTrue(thenRun, "Did not run as microtask");

  asyncEnd();
}
