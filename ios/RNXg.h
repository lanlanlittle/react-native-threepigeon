
#if __has_include("RCTBridgeModule.h")
#import "RCTBridgeModule.h"
#else
#import <React/RCTBridgeModule.h>
#endif

#import "XGPush.h"
#if __IPHONE_OS_VERSION_MAX_ALLOWED >= __IPHONE_10_0
#import <UserNotifications/UserNotifications.h>
#endif

@interface RNXg : NSObject <RCTBridgeModule, XGPushDelegate>
@property NSString* XG_ACCESS_ID;
@property NSString* XG_ACCESS_KEY;

- (NSString*)getValueByKey:(NSString*) key;
@end
  
