package za.co.stemgon.caroom.dealer.models

data class Car(
    val id: Int,
    val name: String,
    val brand: String,
    val price: String,
    val imageUrl: String,
    val description: String
)
