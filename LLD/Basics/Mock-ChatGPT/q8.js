/*
Implement a simple EventEmitter class with the following methods:
    on(event, listener)
    emit(event, ...args)
    off(event, listener) (remove a listener)

Rules:
    Multiple listeners per event
    emit should call listeners in order of registration
    Removing a listener should not affect others
*/

class EventEmitter {
    map
    constructor() {
        this.map = new Map()
    }
    on(event, listener) {
        if(!this.map.has(event)) {
            this.map.set(event, [])
        }
        this.map.get(event).push(listener)
    }

    emit(event, ...args) {
        if(!this.map.has(event)) {
            console.log('Event not available');
            return 
        }
        for(let listener of this.map.get(event)) {
            listener(...args)
        }
    }

    off(event, listener) {
        if(!this.map.has(event)) {
            console.log('Event not available');
            return 
        }
        const listeners = this.map.get(event)
        const idx = listeners.indexOf(listener)
        if (idx === -1) return;

        listeners.splice(idx, 1);
    }

    once(event, listener) {

    }
}

const emitter = new EventEmitter();

function listener1(data) {
  console.log('Listener 1:', data);
}

function listener2(data) {
  console.log('Listener 2:', data);
}

emitter.on('eventA', listener1);
emitter.on('eventA', listener2);

emitter.emit('eventA', 'hello');
// Listener 1: hello
// Listener 2: hello

emitter.off('eventA', listener1);

emitter.emit('eventA', 'world');
// Listener 2: world
