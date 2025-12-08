import { useCallback, useRef } from 'react'

export const useThrottle = (callback, delay) => {
    const canTrigger = useRef(true);
    
    return useCallback(() => {
        if (!canTrigger.current) {
            console.log('cannot run');
            return;
        }

        canTrigger.current = false
        callback()

        setTimeout(() => {
            canTrigger.current = true
        }, delay * 1000);

    }, [callback, delay])
}
