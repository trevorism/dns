package com.trevorism.gcloud.service

import com.trevorism.secure.PropertiesProvider

class GodaddyHeaders {

    static Map<String, String> headers = [:]

    static Map<String, String> get(){
        if(!headers){
            PropertiesProvider propertiesProvider = new PropertiesProvider()
            String apiKey = propertiesProvider.getProperty("apiKey")
            String apiSecret = propertiesProvider.getProperty("apiSecret")
            headers = ["Authorization": "sso-key $apiKey:$apiSecret".toString()]
        }
        return headers
    }
}
