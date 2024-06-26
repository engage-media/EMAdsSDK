package com.engage.emadsdk

import androidx.media3.common.util.UnstableApi
import androidx.media3.exoplayer.source.ads.AdsMediaSource
import com.engage.emadsdk.data.EMVASTAd

internal interface EMAdPlayer {
    @UnstableApi
    fun playAd(
        emVastAd: EMVASTAd,
        emContentPlaybackListener: EMContentPlaybackListener,
        vastUrl: String,
    )

    fun release()
}