Welcome to "Buy List"" testing framework.
To start testing:
1. Download and install Appium from [here](https://github.com/appium/appium-desktop) 
2. Download and install Android SDK tools from [here](https://developer.android.com/studio/releases/platform-tools.html). Create emulator.
3. You can start emulator from command line using `exec:exec -Dmaven.exec.skip=false -Dpath.to.emulator=/Users/ageneralov/Library/Android/sdk/tools/ -Ddevice.name=kenjke`
where -Dmaven.exec.skip - skipping maven-exec-plugin execution; -Dpath.to.emulator - local path to emulator; -Ddevice.name - name of device.
4. To start testing using command line: `clean verify site -Dgroups={groups} -Ddevice.name=kenjke -Dpath.to.app=/path/to/app -Dappium.uri={appiumUri}`, 
where {groups}=list,settings; -Dpath.to.app - local path to .apk file; -Dappium.uri - uri to Appium server (can be local and global).
By default tests are running in 1 thread to avoid data interrupting.
Allure report can be found at /target/site/allure-maven-plugin/index.html
