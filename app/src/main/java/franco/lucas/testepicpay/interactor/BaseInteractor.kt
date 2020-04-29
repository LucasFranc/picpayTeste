package franco.lucas.testepicpay.interactor

interface BaseInteractor<in PARAM, out RESPONSE> {
    suspend fun execute(param: PARAM): RESPONSE
}