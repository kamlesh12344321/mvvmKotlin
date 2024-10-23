package com.appin.finalmvvmcleanarchitructureapp.utils


/**
 * Created by Kamlesh Patel on 22/10/24.
 */
sealed class Resource<T> (
    val data:T? = null,
    val message:String? = null
){
    class Success<T>(data: T):Resource<T>(data)
    class Error<T>(message: String?, data: T? = null): Resource<T>(message = message, data = data)
    class Loading<T>(data: T? = null):Resource<T>(data = data)

}