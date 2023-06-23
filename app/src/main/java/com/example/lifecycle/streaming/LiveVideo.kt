package com.example.lifecycle.streaming

import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner

class LiveVideo : DefaultLifecycleObserver {
    override fun onStart(owner: LifecycleOwner) {
        super.onStart(owner)
        // play video
    }

    override fun onStop(owner: LifecycleOwner) {
        super.onStop(owner)
        // pausa o vídeo
    }

    override fun onDestroy(owner: LifecycleOwner) {
        super.onDestroy(owner)
        // libera memória do vídeo
    }
}

// exemplo de straming com LifecycleOwner