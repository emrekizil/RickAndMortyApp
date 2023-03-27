package com.example.emrekizil_usgstajyerchallenge.data.source

import com.example.emrekizil_usgstajyerchallenge.SAMPLE_IDS
import com.example.emrekizil_usgstajyerchallenge.SAMPLE_PAGE_NUMBER
import com.example.emrekizil_usgstajyerchallenge.characterResponseItemList
import com.example.emrekizil_usgstajyerchallenge.data.NetworkResponseState
import com.example.emrekizil_usgstajyerchallenge.data.api.RickAndMortyApi
import com.example.emrekizil_usgstajyerchallenge.data.dto.character.CharacterResponse
import com.example.emrekizil_usgstajyerchallenge.data.dto.locations.LocationResponse
import com.example.emrekizil_usgstajyerchallenge.data.source.remote.RemoteDataSourceImpl
import com.example.emrekizil_usgstajyerchallenge.resultList
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class RemoteDataSourceImplTest {

    @Mock
    private lateinit var rickAndMortyApi: RickAndMortyApi

    private lateinit var remoteDataSourceImpl: RemoteDataSourceImpl

    @Before
    fun setup(){
        MockitoAnnotations.openMocks(this)
        remoteDataSourceImpl = RemoteDataSourceImpl(rickAndMortyApi)
    }

    @Test
    fun `when location list returned is state success`(){
        runBlocking {
            Mockito.`when`(rickAndMortyApi.getLocations(SAMPLE_PAGE_NUMBER))
                .thenReturn(
                    LocationResponse(null, resultList)
                )
            val response = remoteDataSourceImpl.getLocations(SAMPLE_PAGE_NUMBER)
            assertThat(response).isInstanceOf(NetworkResponseState.Success::class.java)
        }
    }

    @Test
    fun  `when rickAndMorty api location returned null is state failure`(){
        runBlocking {
            Mockito.`when`(rickAndMortyApi.getLocations(SAMPLE_PAGE_NUMBER))
                .thenReturn(
                    null
                )
            val response = remoteDataSourceImpl.getLocations(SAMPLE_PAGE_NUMBER)
            assertThat(response).isInstanceOf(NetworkResponseState.Error::class.java)
        }
    }

    @Test
    fun `when character list returned is state success`(){
        runBlocking {
            Mockito.`when`(rickAndMortyApi.getCharactersById(SAMPLE_IDS))
                .thenReturn(
                    CharacterResponse()
                )
            val response = remoteDataSourceImpl.getCharactersById(SAMPLE_IDS)
            assertThat(response).isInstanceOf(NetworkResponseState.Success::class.java)
        }
    }

    @Test
    fun  `when rickAndMorty api character returned null is state failure`(){
        runBlocking {
            Mockito.`when`(rickAndMortyApi.getCharactersById(SAMPLE_IDS))
                .thenReturn(
                    null
                )
            val response = remoteDataSourceImpl.getCharactersById(SAMPLE_IDS)
            assertThat(response).isInstanceOf(NetworkResponseState.Error::class.java)
        }
    }
}