
# react-native-xg

## Getting started

`$ npm install react-native-xg --save`

### Mostly automatic installation

`$ react-native link react-native-xg`

### Manual installation


#### iOS

1. In XCode, in the project navigator, right click `Libraries` ➜ `Add Files to [your project's name]`
2. Go to `node_modules` ➜ `react-native-xg` and add `RNXg.xcodeproj`
3. In XCode, in the project navigator, select your project. Add `libRNXg.a` to your project's `Build Phases` ➜ `Link Binary With Libraries`
4. Run your project (`Cmd+R`)<

#### Android

1. Open up `android/app/src/main/java/[...]/MainActivity.java`
  - Add `import com.zxx.threepigeon.RNXgPackage;` to the imports at the top of the file
  - Add `new RNXgPackage()` to the list returned by the `getPackages()` method
2. Append the following lines to `android/settings.gradle`:
  	```
  	include ':react-native-xg'
  	project(':react-native-xg').projectDir = new File(rootProject.projectDir, 	'../node_modules/react-native-xg/android')
  	```
3. Insert the following lines inside the dependencies block in `android/app/build.gradle`:
  	```
      compile project(':react-native-xg')
  	```


## Usage
```javascript
import RNXg from 'react-native-xg';

// TODO: What to do with the module?
RNXg;
```
  