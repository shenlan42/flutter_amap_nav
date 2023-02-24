
import 'dart:async';

import 'package:flutter/cupertino.dart';
import 'package:flutter/services.dart';


class AmapNav {
  static const MethodChannel _channel = MethodChannel('amap_nav');

  static Future<String?> get platformVersion async {
    final String? version = await _channel.invokeMethod('getPlatformVersion',666);
    return version;
  }
  static Future<String?> get startEnd async {

  }
}

