package entity

import infra.OperationalMethod

data class FullParameters(
        val url:String,
        val method: OperationalMethod,
        val parameters: Map<String,String> = emptyMap()
)