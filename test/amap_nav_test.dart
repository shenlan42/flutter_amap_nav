import 'package:flutter/services.dart';
import 'package:flutter_test/flutter_test.dart';
import 'package:amap_nav/amap_nav.dart';

void main() {
  const MethodChannel channel = MethodChannel('amap_nav');

  TestWidgetsFlutterBinding.ensureInitialized();

  setUp(() {
    channel.setMockMethodCallHandler((MethodCall methodCall) async {
      return '42';
    });
  });

  tearDown(() {
    channel.setMockMethodCallHandler(null);
  });

  test('getPlatformVersion', () async {
    expect(await AmapNav.platformVersion, '42');
  });
}
