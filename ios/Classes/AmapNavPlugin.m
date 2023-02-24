#import "AmapNavPlugin.h"
#if __has_include(<amap_nav/amap_nav-Swift.h>)
#import <amap_nav/amap_nav-Swift.h>
#else
// Support project import fallback if the generated compatibility header
// is not copied when this plugin is created as a library.
// https://forums.swift.org/t/swift-static-libraries-dont-copy-generated-objective-c-header/19816
#import "amap_nav-Swift.h"
#endif

@implementation AmapNavPlugin
+ (void)registerWithRegistrar:(NSObject<FlutterPluginRegistrar>*)registrar {
  [SwiftAmapNavPlugin registerWithRegistrar:registrar];
}
@end
