package com.example.amap_nav;

import android.content.Context;

import com.example.amap_nav.mapView;

import java.util.Map;

import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.StandardMessageCodec;
import io.flutter.plugin.platform.PlatformView;
import io.flutter.plugin.platform.PlatformViewFactory;

public class MyViewFactory extends PlatformViewFactory {

    private final BinaryMessenger messenger;

    public MyViewFactory(BinaryMessenger messenger) {
        super(StandardMessageCodec.INSTANCE);
        this.messenger = messenger;
    }

    @Override
    @SuppressWarnings("unchecked")
    public PlatformView create(Context context, int id, Object o) {
        Map<String, Object> params = (Map<String, Object>) o;
        return new mapView(context, messenger, id, params);
    }
}
