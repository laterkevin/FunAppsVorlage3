package de.syntax_institut.funappsvorlage.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import de.syntax_institut.funappsvorlage.data.AppRepository
import de.syntax_institut.funappsvorlage.data.remote.SearchApi
import kotlinx.coroutines.*

class SearchViewModel : ViewModel() {

    // In dieser Live Data Variablen wird durch Data Binding der aktuelle Input Text gespeichert
    // TODO
    val inputText = MutableLiveData<String>()

    // hier wird ein AppRepository Objekt erstellt
    // TODO
    private val repository = AppRepository(SearchApi)

    // hier werden die results aus dem repository in einer eigenen Variablen gespeichert
    // TODO
    val song = repository.songs

    // search job für delay
    private var searchJob: Job? = null

    /**
     * Diese Funktion ruft die Repository-Funktion zum Laden der Ergebnisse
     * innerhalb einer Coroutine auf
     */
    // TODO
    fun loadData(search: String) {
        viewModelScope.launch {
            searchJob?.cancelAndJoin()
            searchJob = this.launch {
                delay(500)
                repository.getResults(search)
            }
        }
    }
}
