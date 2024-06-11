package com.engage.emadsdk

interface EMContentPlaybackListener {
    fun onProgressUpdate(currentTime: Long, totalTime: Long)
    fun onContentEnded()
}