/*
 * MIT License
 *
 * Copyright (c) 2017 Shahen Hovhannisyan.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package com.shahenlibrary.Trimmer;

import android.support.annotation.NonNull;
import android.util.Log;

import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;

public class TrimmerManager extends ReactContextBaseJavaModule {
  static final String REACT_PACKAGE = "RNTrimmerManager";

  private final ReactApplicationContext reactContext;

  public TrimmerManager(ReactApplicationContext reactContext) {
    super(reactContext);
    this.reactContext = reactContext;
  }

  @Override
  public String getName() {
    return REACT_PACKAGE;
  }

  @ReactMethod
  public void getPreviewImages(String path, Promise promise) {
    Log.d(REACT_PACKAGE, "getPreviewImages: " + path);
    Trimmer.getPreviewImages(path, promise, reactContext);
  }

  @ReactMethod
  public void getVideoInfo(String path, Promise promise) {
    Log.d(REACT_PACKAGE, "getVideoInfo: " + path);
    Trimmer.getVideoInfo(path, promise, reactContext);
  }

  @ReactMethod
  public void trim(ReadableMap options, Promise promise) {
    Log.d(REACT_PACKAGE, options.toString());
    Trimmer.trim(options, promise);
  }
  @ReactMethod
  public void compress(ReadableMap options, Promise promise) {
    Log.d(REACT_PACKAGE, "compress: not supported");
    promise.reject("not supported on android", "");
  }

  @ReactMethod
  public void getPreviewImageAtPosition(ReadableMap options, Promise promise) {
    String source = options.getString("source");
    double sec = options.getDouble("second");
    Trimmer.getPreviewAtPosition(source, sec, promise);
  }
}
