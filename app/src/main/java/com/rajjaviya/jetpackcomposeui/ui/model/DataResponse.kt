package com.rajjaviya.jetpackcomposeui.ui.model


sealed class DataResponse {
    object Loading : DataResponse()
    data class Success(val data: Any) : DataResponse()
    data class Error(val error: String) : DataResponse()
}

fun handleResult(result: DataResponse) {
    val message = when (result) {
        is DataResponse.Loading -> "Loading"
        is DataResponse.Success -> "Success"
        is DataResponse.Error -> "Error"
    }
}
