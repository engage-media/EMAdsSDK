package com.engage.emadsdk.ima

import android.content.Context
import android.widget.ProgressBar
import androidx.media3.exoplayer.ExoPlayer
import androidx.media3.exoplayer.ima.ImaAdsLoader
import androidx.media3.exoplayer.source.MediaSource
import androidx.media3.ui.PlayerView
import com.engage.emadsdk.EMContentPlaybackListener
import com.engage.emadsdk.data.EMVASTAd
import org.junit.Before
import org.junit.Test
import org.mockito.ArgumentMatchers.any
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class AdPlayerImplTest {

    @Mock
    private lateinit var context: Context

    @Mock
    private lateinit var playerView: PlayerView

    @Mock
    private lateinit var progressBar: ProgressBar

    @Mock
    private lateinit var emContentPlaybackListener: EMContentPlaybackListener

    @Mock
    private lateinit var emVastAd: EMVASTAd

    @Mock
    private lateinit var exoPlayer: ExoPlayer

    @Mock
    private lateinit var imaAdsLoader: ImaAdsLoader

    private lateinit var adPlayerImpl: AdPlayerImpl

    @Before
    fun setUp() {
        MockitoAnnotations.openMocks(this)
        adPlayerImpl = AdPlayerImpl(context, playerView, progressBar, imaAdsLoader, exoPlayer)
    }

    @Test
    fun testPlayAd() {
        val vastUrl = "https://example.com/vast.xml"
        adPlayerImpl.playAd(emVastAd, emContentPlaybackListener, vastUrl)

        Mockito.verify(exoPlayer).setMediaSource(any())
        Mockito.verify(exoPlayer).prepare()
        Mockito.verify(exoPlayer).playWhenReady = true
        Mockito.verify(emContentPlaybackListener).onContentEnded()
    }
}

interface ExoPlayerWrapper {
    fun setMediaSource(mediaSource: MediaSource)
    fun prepare()
    var playWhenReady: Boolean
}

