
#import "RNXg.h"
#import "XGPush.h"

@implementation RNXg

- (dispatch_queue_t)methodQueue
{
    return dispatch_get_main_queue();
}

- (instancetype)init
{
    self = [super init];
    if (self) {
        self.XG_ACCESS_ID = [self getValueByKey:@"XG_ACCESS_ID"];
        self.XG_ACCESS_KEY = [self getValueByKey:@"XG_ACCESS_KEY"];
        [[XGPush defaultManager] setEnableDebug:YES];
        [[XGPush defaultManager] startXGWithAppID:2200262432 appKey:@"I89WTUY132GJ" delegate:self];
    }
    return self;
}

- (NSString*)getValueByKey:(NSString*) key{
    NSDictionary* dictBundle = [[NSBundle mainBundle ] infoDictionary];
    if (dictBundle)
    {
        NSString* value = [dictBundle objectForKey:key];
        if(value == NULL) return @"";
        return value;
    }
    
    return @"";
}

RCT_EXPORT_MODULE()

@end
  
