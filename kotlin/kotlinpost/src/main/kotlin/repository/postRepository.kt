package repository

import entity.FullParameters
import entity.HTTPResponse

class PostRepository private constructor (){


    companion object : BaseRepository () {

        fun getAllPosts (fullParameters: FullParameters): HTTPResponse{
           return super.execute(fullParameters)
        }

        fun getSinglePost (fullParameters: FullParameters) : HTTPResponse{
           return  super.execute(fullParameters)
        }
    }

}