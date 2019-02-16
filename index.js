
import { NativeModules, DeviceEventEmitter } from 'react-native';
import { EventEmitter } from 'events';

const { RNXg } = NativeModules;

// export default RNXg;

let RNThreePigeon = {
    emitter : new EventEmitter(),
}

/**
 * `addListener` inherits from `events` module
 * @method addListener
 * @param {String} eventName - the event name
 * @param {Function} trigger - the function when event is fired
 */
RNThreePigeon.addListener = RNThreePigeon.emitter.addListener.bind(RNThreePigeon.emitter);


/**
 * `removeAllListeners` inherits from `events` module
 * @method removeAllListeners
 * @param {String} eventName - the event name
 */
RNThreePigeon.removeAllListeners = RNThreePigeon.emitter.removeAllListeners.bind(RNThreePigeon.emitter);

DeviceEventEmitter.addListener('onMsgReceiver', data => {
    RNThreePigeon.emitter.emit('onMsgReceiver', data);
});

export default RNThreePigeon;
