package business

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import entity.FullParameters
import entity.HTTPResponse
import entity.PostEntity
import infra.EndpointConstants
import infra.OperationalMethod
import repository.PostRepository

class PostBusiness() {

    fun getAllPosts(): List<PostEntity> {

        val url: String = EndpointConstants.BASE.URL + EndpointConstants.POST.ALL_POSTS
        val fullParameters: FullParameters = FullParameters(url, OperationalMethod.GET)
        val response: HTTPResponse = PostRepository.getAllPosts(fullParameters)


        return Gson().fromJson<List<PostEntity>>(response.jsonResponde, object : TypeToken<List<PostEntity>>() {}.type)

    }

    fun getSinglePost(id: Int): PostEntity {

        val url: String = EndpointConstants.BASE.URL + EndpointConstants.POST.SINGLE_POST
        val fullParameters: FullParameters = FullParameters(url, OperationalMethod.GET, mapOf(Pair("id", id.toString())))

        val response: HTTPResponse = PostRepository.getSinglePost(fullParameters)

        return Gson().fromJson<List<PostEntity>>(response.jsonResponde, object : TypeToken<List<PostEntity>>() {}.type)[0]


    }
}