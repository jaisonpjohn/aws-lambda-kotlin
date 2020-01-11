package com.jaison.bugdays

import com.amazonaws.services.lambda.runtime.Context
import com.amazonaws.services.lambda.runtime.RequestHandler


class LambdaRequestHandler: RequestHandler<Request, Response> {
    override fun handleRequest(input: Request, context: Context): Response {
        println("input: $input")
        println("Context: $context.")
        return Response(greetings = "hi "+input.firstName + " "+ input.lastName)
    }
}
/*Lambda is not aware of kotlin data classes yet. It still uses Jackson which needs default constructor and setter
* Even Adding the kotlin jackson support library to this jar wont make any difference I guess as the deserialization
* happens with in AWS*/
data class Request(
    var firstName: String = "",
    var lastName: String = ""
)
data class Response(val greetings: String)
