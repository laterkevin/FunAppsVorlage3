package de.syntax_institut.funappsvorlage.data.remote

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import de.syntax_institut.funappsvorlage.data.datamodels.SongList
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

// Die Konstante enthält die URL der API
// TODO
const val BASE_URL = "https://itunes.apple.com/"

// Moshi konvertiert Serverantworten in Kotlin Objekte
// TODO
private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

// Retrofit übernimmt die Kommunikation und übersetzt die Antwort
// TODO
private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

// Das Interface bestimmt, wie mit dem Server kommuniziert wird
// TODO
interface SongApiService {

    @GET("search")
    suspend fun getResults(@Query("term") term: String): SongList
}

// Das Objekt dient als Zugangspunkt für den Rest der App und stellt den API Service zur Verfügung
// TODO
object SearchApi {
    val retrofitService: SongApiService by lazy { retrofit.create(SongApiService::class.java) }
}
