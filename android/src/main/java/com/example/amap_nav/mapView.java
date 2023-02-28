package com.example.amap_nav;

import android.content.Context;
import android.view.View;
import android.webkit.WebView;
import android.widget.TextView;

import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.Poi;
import com.amap.api.navi.AmapNaviPage;
import com.amap.api.navi.AmapNaviParams;
import com.amap.api.navi.AmapNaviType;
import com.amap.api.navi.AmapPageType;
import com.amap.api.navi.NaviSetting;
import com.amap.api.navi.INaviInfoCallback;
import com.amap.api.navi.model.AMapNaviLocation;

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
            AmapNaviPage.getInstance().showRouteActivity(context.getApplicationContext(), naviParams,new INaviInfoCallback() {

                @Override
                public void onInitNaviFailure() {

                }

                @Override
                public void onGetNavigationText(String s) {

                }

                @Override
                public void onLocationChange(AMapNaviLocation aMapNaviLocation) {

                }

                @Override
                public void onArriveDestination(boolean b) {

                }

                @Override
                public void onStartNavi(int i) {

                }

                @Override
                public void onCalculateRouteSuccess(int[] ints) {

                }

                @Override
                public void onCalculateRouteFailure(int i) {

                }

                @Override
                public void onStopSpeaking() {

                }

                @Override
                public void onReCalculateRoute(int i) {

                }

                @Override
                public void onExitPage(int i) {

                }

                @Override
                public void onStrategyChanged(int i) {

                }

                @Override
                public void onArrivedWayPoint(int i) {

                }

                @Override
                public void onMapTypeChanged(int i) {

                }

                @Override
                public void onNaviDirectionChanged(int i) {

                }

                @Override
                public void onDayAndNightModeChanged(int i) {

                }

                @Override
                public void onBroadcastModeChanged(int i) {

                }

                @Override
                public void onScaleAutoChanged(boolean b) {

                }

                @Override
                public View getCustomMiddleView() {
                    return null;
                }

                @Override
                public View getCustomNaviView() {
                    return null;
                }

                @Override
                public View getCustomNaviBottomView() {
                    TextView textView = new TextView(context);
                    String a = "12312321333333333333312333333333333333333333333333333333333333333333333333333123123123";
                    textView.setText(a);
                    return textView;
                }

            });




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


