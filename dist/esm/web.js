import { WebPlugin } from '@capacitor/core';
export class NativeHelperWeb extends WebPlugin {
    async echo(options) {
        console.log('ECHO', options);
        return options;
    }
    async toastMe() {
        return true;
    }
    async moveToBackground() {
        return true;
    }
    async startClipService() {
        return true;
    }
    async stopClipService() {
        return true;
    }
    async storeInSharedPrefs() {
        return true;
    }
    async getOverlayPermissionStatus() {
        return true;
    }
    async getNotificationPermissionStatus() {
        return true;
    }
    async getSystemLanguage() {
        return true;
    }
    async getVersionName() {
        return true;
    }
    async requestOverlayPermission() {
        return true;
    }
    async goToNotificationSettings() {
        return true;
    }
}
//# sourceMappingURL=web.js.map