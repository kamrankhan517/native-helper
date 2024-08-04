import { WebPlugin } from '@capacitor/core';
import type { NativeHelperPlugin } from './definitions';
export declare class NativeHelperWeb extends WebPlugin implements NativeHelperPlugin {
    echo(options: {
        value: string;
    }): Promise<{
        value: string;
    }>;
    toastMe(): Promise<any>;
    moveToBackground(): Promise<any>;
    startClipService(): Promise<any>;
    stopClipService(): Promise<any>;
    storeInSharedPrefs(): Promise<any>;
    getOverlayPermissionStatus(): Promise<any>;
    getNotificationPermissionStatus(): Promise<any>;
    getSystemLanguage(): Promise<any>;
    getVersionName(): Promise<any>;
    requestOverlayPermission(): Promise<any>;
    goToNotificationSettings(): Promise<any>;
}
