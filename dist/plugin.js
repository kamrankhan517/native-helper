var capacitorNativeHelper = (function (exports, core) {
    'use strict';

    const NativeHelper = core.registerPlugin('NativeHelper', {
        web: () => Promise.resolve().then(function () { return web; }).then(m => new m.NativeHelperWeb()),
    });

    class NativeHelperWeb extends core.WebPlugin {
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

    var web = /*#__PURE__*/Object.freeze({
        __proto__: null,
        NativeHelperWeb: NativeHelperWeb
    });

    exports.NativeHelper = NativeHelper;

    Object.defineProperty(exports, '__esModule', { value: true });

    return exports;

})({}, capacitorExports);
//# sourceMappingURL=plugin.js.map
