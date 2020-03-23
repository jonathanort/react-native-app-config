
#import "RNAppConfig.h"
#import <UIKit/UIKit.h>

@implementation RNAppConfig

- (dispatch_queue_t)methodQueue
  {
    return dispatch_get_main_queue();
  }
  
- (NSString*) uniqueId
  {
    return [[[UIDevice currentDevice] identifierForVendor] UUIDString];
  }
  
- (NSString*) buildType
  {
    return [[NSBundle mainBundle] objectForInfoDictionaryKey:@"BuildEnvironment"] ?: [NSNull null];;
  }
  
- (NSString*) appVersion
  {
    return [[NSBundle mainBundle] objectForInfoDictionaryKey:@"CFBundleShortVersionString"] ?: [NSNull null];
  }
  
- (NSString*) pushToken
  {
    return [[NSUserDefaults standardUserDefaults] valueForKey:@"pushToken"] ?: [NSNull null];
  }

- (NSNumber *) useStaging
{
  NSUserDefaults *defaults = [NSUserDefaults standardUserDefaults];
  return [NSNumber numberWithBool:[defaults valueForKey:@"staging_enabled"] ?: NO];
}
  
- (NSDictionary *)constantsToExport
  {
    return @{
             @"uniqueId": self.uniqueId,
             @"buildType": self.buildType,
             @"appVersion": self.appVersion,
             @"pushToken": self.pushToken,
             @"useStaging": self.useStaging
             };
  }
  
+ (BOOL)requiresMainQueueSetup
  {
    return YES;
  }
  
RCT_EXPORT_MODULE()

@end
