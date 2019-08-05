
# react-native-app-config

## Getting started

`$ npm install react-native-app-config --save`

### Mostly automatic installation

`$ react-native link react-native-app-config`

### Manual installation


#### iOS

1. In XCode, in the project navigator, right click `Libraries` ➜ `Add Files to [your project's name]`
2. Go to `node_modules` ➜ `react-native-app-config` and add `RNAppConfig.xcodeproj`
3. In XCode, in the project navigator, select your project. Add `libRNAppConfig.a` to your project's `Build Phases` ➜ `Link Binary With Libraries`
4. Run your project (`Cmd+R`)<

#### Android

1. Open up `android/app/src/main/java/[...]/MainActivity.java`
  - Add `import com.reactlibrary.RNAppConfigPackage;` to the imports at the top of the file
  - Add `new RNAppConfigPackage()` to the list returned by the `getPackages()` method
2. Append the following lines to `android/settings.gradle`:
  	```
  	include ':react-native-app-config'
  	project(':react-native-app-config').projectDir = new File(rootProject.projectDir, 	'../node_modules/react-native-app-config/android')
  	```
3. Insert the following lines inside the dependencies block in `android/app/build.gradle`:
  	```
      compile project(':react-native-app-config')
  	```

#### Windows
[Read it! :D](https://github.com/ReactWindows/react-native)

1. In Visual Studio add the `RNAppConfig.sln` in `node_modules/react-native-app-config/windows/RNAppConfig.sln` folder to their solution, reference from their app.
2. Open up your `MainPage.cs` app
  - Add `using App.Config.RNAppConfig;` to the usings at the top of the file
  - Add `new RNAppConfigPackage()` to the `List<IReactPackage>` returned by the `Packages` method


## Usage
```javascript
import RNAppConfig from 'react-native-app-config';

// TODO: What to do with the module?
RNAppConfig;
```
  