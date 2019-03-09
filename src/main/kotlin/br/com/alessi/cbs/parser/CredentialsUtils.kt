package br.com.alessi.cbs.parser

import br.com.alessi.cbs.parser.pojo.Back4appCredentials
import com.google.gson.Gson
import com.google.gson.stream.JsonReader
import java.io.FileReader
import com.google.gson.reflect.TypeToken
import java.io.Reader


class CredentialsUtils {


    companion object {
        fun readCredentials(): Back4appCredentials{
            val reader = JsonReader(FileReader("credentials.json") as Reader?)
            val gson = Gson()
            val type = object : TypeToken<Back4appCredentials>() {}.type
            return gson.fromJson<Back4appCredentials>(reader, type)
        }

    }
}