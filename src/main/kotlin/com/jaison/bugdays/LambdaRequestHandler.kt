package com.jaison.bugdays

import com.amazonaws.services.lambda.runtime.Context
import com.amazonaws.services.lambda.runtime.RequestHandler


class LambdaRequestHandler: RequestHandler<Request, Response> {
    override fun handleRequest(input: Request, context: Context): Response {
        println(input)
        return Response(greetings = "hi"+input.firstName + " "+ input.lastName)
    }
}
/*Lambda is not aware of kotlin data classes yet. It still uses Jackson which needs default constructor and setter*/
data class Request(
    var firstName: String = "",
    var lastName: String = ""
)
data class Response(val greetings: String)
