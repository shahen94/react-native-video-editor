//
//  RNVideoProcessingManager.swift
//  RNVideoProcessing
//
//  Created by Shahen Hovhannisyan on 11/14/16.
//  Copyright © 2016 Facebook. All rights reserved.
//

import Foundation

@objc(RNVideoProcessingManager)
class RNVideoProcessingManager: RCTViewManager {
    
    @objc override func view() -> UIView! {
        return RNVideoPlayer()
    }
    override func constantsToExport() -> [String : Any]! {
        return [
            "ScaleNone": AVLayerVideoGravityResizeAspect,
            "ScaleToFill": AVLayerVideoGravityResize,
            "ScaleAspectFit": AVLayerVideoGravityResizeAspect,
            "ScaleAspectFill": AVLayerVideoGravityResizeAspectFill
        ]
    }
}
