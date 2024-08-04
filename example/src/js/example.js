import { NativeHelper } from '@capacitor-community&#x2F;native-helper';

window.testEcho = () => {
    const inputValue = document.getElementById("echoInput").value;
    NativeHelper.echo({ value: inputValue })
}
