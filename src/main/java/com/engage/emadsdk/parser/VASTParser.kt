package com.engage.emadsdk.parser

import com.engage.emadsdk.network.VASTResponse
import org.simpleframework.xml.Serializer
import org.simpleframework.xml.core.Persister
import java.io.StringReader


class VASTParser {
    @Throws(Exception::class)
    fun parseVASTResponse(xmlResponse: String?): VASTResponse {
        val serializer: Serializer = Persister()
        return serializer.read(VASTResponse::class.java, StringReader(xmlResponse))
    }
}
