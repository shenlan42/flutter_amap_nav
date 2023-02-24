package com.example.amap_nav;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.Poi;
import com.amap.api.navi.AmapNaviPage;
import com.amap.api.navi.AmapNaviParams;
import com.amap.api.navi.AmapNaviType;
import com.amap.api.navi.AmapPageType;
import com.amap.api.navi.NaviSetting;


import java.util.Map;

import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.platform.PlatformView;

public class mapView implements PlatformView {

    private final View Nav;
    private  final  AmapNaviParams naviParams;


    public mapView(Context context, BinaryMessenger messenger, int id, Map<String, Object> params){
        Poi start;
        Poi end;
        TextView textView = new TextView(context);
//        隐私合规检查
        NaviSetting.updatePrivacyShow(context, true, true);
        NaviSetting.updatePrivacyAgree(context, true);
        if (params!=null&&!params.isEmpty()&&params.containsKey("start")) {
            String start1 = (String) params.get("start");
            String end1 = (String) params.get("end");
            textView.setText(start1+end1);
            double a  = Double.parseDouble(start1.split(",")[0]) ;
            double b  = Double.parseDouble(start1.split(",")[1]) ;
            double c  = Double.parseDouble(end1.split(",")[0]) ;
            double d  = Double.parseDouble(end1.split(",")[1]) ;
            start = new Poi(null, new LatLng(a,b), null);
            end = new Poi(null, new LatLng(c,d), null);
            // 组件参数配置
            //构建导航组件配置类，没有传入起点，所以起点默认为 “我的位置”
            naviParams = new AmapNaviParams(start,null,end, AmapNaviType.DRIVER, AmapPageType.NAVI);
            naviParams.setUseInnerVoice(true);
            naviParams.setMultipleRouteNaviMode(true);
            naviParams.setNeedDestroyDriveManagerInstanceWhenNaviExit(true);
            //启动导航组件
            AmapNaviPage.getInstance().showRouteActivity(context.getApplicationContext(), naviParams,null);

//         拿到flutter传递过来的参数

            this.Nav = textView;

        } else {

            textView.setText(null);
            this.Nav = textView;
            naviParams = null;
        }


    }

    @Override
    public View getView() {
        return Nav;
    }

    @Override
    public void dispose() {

    }
}


