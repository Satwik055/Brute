package com.ironclad.brute.features.portal

import io.ktor.client.HttpClient
import io.ktor.client.engine.cio.CIO
import io.ktor.client.request.header
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.http.setCookie
import io.ktor.util.InternalAPI
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis
import kotlin.time.measureTime

suspend fun getSessionCookie(username:String, password:String): String? {
    val url = "https://saksham.sitslive.com/login"
    val client = HttpClient(CIO)

    val headers = mapOf(
        "accept" to "*/*",
        "accept-language" to "en-GB,en-US;q=0.9,en;q=0.8,hi;q=0.7",
        "cache-control" to "no-cache",
        "content-type" to "application/x-www-form-urlencoded; charset=UTF-8",
        "origin" to "https://saksham.sitslive.com",
        "priority" to "u=1, i",
        "referer" to "https://saksham.sitslive.com/login",
        "sec-ch-ua" to "\"Google Chrome\";v=\"125\", \"Chromium\";v=\"125\", \"Not.A/Brand\";v=\"24\"",
        "sec-ch-ua-mobile" to "?0",
        "sec-ch-ua-platform" to "\"Windows\"",
        "sec-fetch-dest" to "empty",
        "sec-fetch-mode" to "cors",
        "sec-fetch-site" to "same-origin",
        "user-agent" to "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/125.0.0.0 Safari/537.36",
        "x-microsoftajax" to "Delta=true",
        "x-requested-with" to "XMLHttpRequest"
    )

    val payload = "ScriptManager1=updatepanel%7CbtnLogin&__EVENTTARGET=&__EVENTARGUMENT=&__VIEWSTATE=GXq8WYlFoIyiG3kHh%2FyWm36EVSPnNg9oMUi9wBqeXZ5oLCwDaEF1fWGlZu6NIZKEGzs%2FZqM8kQDJ35ynh50OxuDTdeqaTh4wZe5gn2NIsPG1M9Ds%2BzDSx0hHu317Lrbw&__VIEWSTATEGENERATOR=C2EE9ABB&__EVENTVALIDATION=k9EujBZLYjXQ6rTY4Kfb27V%2FFrBy8Ba23xg9ZaR9inInhEHhMnDnorNbGIO4S1IWOPs2u1aAPCkn5ieUxwSc0CgIlxhouE9FPckXsb%2F078IUjLS6AJvoaw3K%2F%2BAABCmEBzF1Ae469WWe4mDfDZPlJyLwg8Y3lH9jol6vnwidKeaSu%2FewI8Hnv04%2BBd2lhQqFFWErXV4tmCmIKvRSer%2FfDZ1HHrJ3Vk%2FQdhUnj8JX2LHHfAeU5ALRWJxbSolA%2FDYVhU8PM7E3jQd1FBYJtVrqHwAgbSxV%2B6dPvyEDYjFbaiHkiz84m5JxTVPK53KMH%2Bpa&txtLoginID=$username&txtPassword=$password&ddlType=0&txtUserName=&__ASYNCPOST=true&btnLogin=Login"

    client.use {
        val response = client.post(url) {
            headers.forEach { (key, value) -> header(key, value) }
            setBody(payload)
        }
        val sessionCookie = response.setCookie().firstOrNull()?.value
        return sessionCookie
    }
}

fun main() {
    val username = "2023/0399"
    val password = "3773"

    runBlocking {
        try{
            val timeTaken = measureTimeMillis {
                val sessionCookie = getSessionCookie(username, password)
                println("Session cookie for $username: $sessionCookie")
            }
            println("Time taken: ${timeTaken}ms")
        }
        catch (e:Exception){
            println("Error: ${e.message}")
        }
    }
}

