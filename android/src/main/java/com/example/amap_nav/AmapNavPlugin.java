package com.example.amap_nav;

import android.util.Log;

import androidx.annotation.NonNull;

import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.MethodChannel.MethodCallHandler;
import io.flutter.plugin.common.MethodChannel.Result;
import io.flutter.plugin.common.StringCodec;

import com.example.amap_nav.MyViewFactory;

/** AmapNavPlugin */
public class AmapNavPlugin implements FlutterPlugin, MethodCallHandler {

  private MethodChannel channel;



  @Override
  public void onAttachedToEngine(@NonNull FlutterPluginBinding flutterPluginBinding) {
//    需要注册的视图的唯一标识
    final String key = "karl_info";
//    创建MethodChannel通道，amap_nav与yaml的name是需要对应的
    channel = new MethodChannel(flutterPluginBinding.getBinaryMessenger(), "amap_nav");

    channel.setMethodCallHandler(this);
//    注册原生view，通过注册视图工厂（viewFactory），需要传入唯一标识和ViewFactory类
    flutterPluginBinding.getPlatformViewRegistry().registerViewFactory(key,new MyViewFactory(flutterPluginBinding.getBinaryMessenger()));



  }


  @Override
  public void onMethodCall(@NonNull MethodCall call, @NonNull Result result) {

    if (call.method.equals("getPlatformVersion")) {

      result.success("Android " + android.os.Build.VERSION.RELEASE +call.arguments);
    }
    else if (call.method.equals("startEnd")) {

      result.success("Android " + android.os.Build.VERSION.RELEASE);

    }
    else {
      result.notImplemented();
    }
  }

  @Override
  public void onDetachedFromEngine(@NonNull FlutterPluginBinding binding) {
    channel.setMethodCallHandler(null);
  }
}
