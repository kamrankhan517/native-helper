import { WebPlugin } from '@capacitor/core';

import type { NativeHelperPlugin } from './definitions';

export class NativeHelperWeb extends WebPlugin implements NativeHelperPlugin {
  async echo(options: { value: string }): Promise<{ value: string }> {
    console.log('ECHO', options);
    return options;
  }
  async toastMe(): Promise<any> {
    return true;
  }
  async moveToBackground(): Promise<any> {
    return true;
  }
  async startClipService(): Promise<any> {
    return true;
  }
  async stopClipService(): Promise<any> {
    return true;
  }
  async storeInSharedPrefs(): Promise<any> {
    return true;
  }
  async getOverlayPermissionStatus(): Promise<any> {
    return true;
  }
  async getNotificationPermissionStatus(): Promise<any> {
    return true;
  }
  async getSystemLanguage(): Promise<any> {
    return true;
  }
  async getVersionName(): Promise<any> {
    return true;
  }
  async requestOverlayPermission(): Promise<any> {
    return true;
  }
  async goToNotificationSettings(): Promise<any> {
    return true;
  }
}
