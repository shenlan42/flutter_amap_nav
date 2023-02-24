import 'dart:io';

import 'package:flutter/material.dart';
import 'package:flutter/services.dart';



class navWidget extends StatelessWidget {
  const navWidget({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    String viewType = 'karl_info'; // 唯一标识符
    var creationParams = {
      'start':'30.501258, 114.414684',
      'end': '30.511258,114.434684'
    };// 视图创建参数，可以被插件用来传递构造函数参数到嵌入式Android视图
    // 视图创建完毕的回调
    PlatformViewCreatedCallback callback = (id) {};
    // 判断设备类型，也可用：defaultTargetPlatform == TargetPlatform.android
    if (Platform.isAndroid) {
      return AndroidView(
          viewType: viewType,
        onPlatformViewCreated: callback,
        creationParams: creationParams,
        //参数的编码方式
        creationParamsCodec: const StandardMessageCodec(),
      );
    } else if (Platform.isIOS) {
      return UiKitView(
          viewType: viewType,
        onPlatformViewCreated: callback,

      );
    } else {
      return Text('您的设备暂不支持此软件');
    }

  }
}
