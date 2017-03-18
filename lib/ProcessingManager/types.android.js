// @flow

export type sourceType = string
  | { uri: string };

export type trimOptions = {
  startTime: number,
  endTime: number
};

declare class RNTrimmerManager {
  static trim(source: string, options: trimOptions): Promise<{ source: string }>;
  static compress(source: string, options: any): Promise<*>;
  static getVideoInfo(source: string): Promise<*>;
  static getPreviewImages(source: string): Promise<*>;
  static getPreviewImageAtPosition(source: string, second: number): Promise<{ image: string }>;
}
