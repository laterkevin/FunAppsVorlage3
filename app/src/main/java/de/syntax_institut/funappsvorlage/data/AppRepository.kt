package de.syntax_institut.funappsvorlage.data

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import de.syntax_institut.funappsvorlage.data.datamodels.Song
import de.syntax_institut.funappsvorlage.data.remote.SearchApi
import java.lang.Exception

const val TAG = "AppRepository"

/**
 * Diese Klasse holt die Informationen und stellt sie mithilfe von Live Data dem Rest
 * der App zur Verfügung
 */
class AppRepository(private var api: SearchApi) {

    // Die LiveData Variable results enthält die Liste aus dem API call
    // TODO
    private val _songs = MutableLiveData<List<Song>>()
    val songs: LiveData<List<Song>>
        get() = _songs

    /**
     * Diese Funktion ruft die Daten aus dem API Service ab und speichert die Antwort in der
     * Variable results. Falls der Call nicht funktioniert, wird die Fehlermeldung geloggt
     */
    // TODO
    suspend fun getResults(search: String) {
        try {
            val songList = api.retrofitService.getResults(search)
            _songs.value = songList.songs
        } catch (e: Exception) {
            Log.e(TAG, "Error Data not Loading from API: $e")
        }
    }
}
