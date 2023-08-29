package com.mutkuensert.phasecomposeextension

import androidx.compose.runtime.Composable
import com.mutkuensert.androidphase.Phase

@Composable
fun <T : Any> Phase<T>.Execute(
    onStandby: @Composable (T?) -> Unit = {},
    onLoading: @Composable (T?) -> Unit = {},
    onSuccess: @Composable (T) -> Unit = {},
    onError: @Composable (Phase.Error<T>) -> Unit = {}
) {
    when (this) {
        is Phase.Standby -> onStandby.invoke(data)
        is Phase.Loading -> onLoading.invoke(data)
        is Phase.Success -> onSuccess.invoke(data)
        is Phase.Error -> onError.invoke(this)
    }
}