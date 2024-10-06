package za.co.stemgon.retrofitapp.models

data class Make(
    var id: String,
    var name: String,
    var vehicle_count: Int,
    var icon: String,
    var image: String,
    )

data class MakeResponse(
    var count: Int,
    var next: String,
    var previous: String,
    var results: List<Make>,

)