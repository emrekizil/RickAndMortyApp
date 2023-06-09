package com.example.emrekizil_usgstajyerchallenge.data.repository

import app.cash.turbine.test
import com.example.emrekizil_usgstajyerchallenge.SAMPLE_IDS
import com.example.emrekizil_usgstajyerchallenge.SAMPLE_PAGE_NUMBER
import com.example.emrekizil_usgstajyerchallenge.TestResponseEnum
import com.example.emrekizil_usgstajyerchallenge.data.NetworkResponseState
import com.example.emrekizil_usgstajyerchallenge.data.mappers.CharacterListMapperImpl
import com.example.emrekizil_usgstajyerchallenge.data.mappers.LocationListMapperImpl
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations

class RickAndMortyRepositoryImplTest {
    @Mock
    private lateinit var locationListMapper :LocationListMapperImpl
    @Mock
    private lateinit var characterListMapper: CharacterListMapperImpl
    private lateinit var fakeRepository: FakeRepository

    @Before
    fun setup(){
        MockitoAnnotations.openMocks(this)
        fakeRepository = FakeRepository(locationListMapper,characterListMapper)
    }

    @Test
    fun `when get location is first state downloading`() =
        runBlocking {
            fakeRepository.getLocations(SAMPLE_PAGE_NUMBER).test {
                assertThat(awaitItem()).isInstanceOf(NetworkResponseState.Loading::class.java)
                cancelAndIgnoreRemainingEvents()
            }
        }

    @Test
    fun `when get location response failure is state downloading and failure sequentially`() =
        runBlocking {
            fakeRepository.setRequest(TestResponseEnum.ERROR)
            fakeRepository.getLocations(SAMPLE_PAGE_NUMBER).test {
                assertThat(awaitItem()).isInstanceOf(NetworkResponseState.Loading::class.java)
                assertThat(awaitItem()).isInstanceOf(NetworkResponseState.Error::class.java)
                awaitComplete()
            }
        }

    @Test
    fun `when get location response success is state downloading and success sequentially`() =
        runBlocking {
            fakeRepository.setRequest(TestResponseEnum.SUCCESS)
            fakeRepository.getLocations(SAMPLE_PAGE_NUMBER).test {
                assertThat(awaitItem()).isInstanceOf(NetworkResponseState.Loading::class.java)
                assertThat(awaitItem()).isInstanceOf(NetworkResponseState.Success::class.java)
                awaitComplete()
            }
        }


    @Test
    fun `when get character is first state downloading`() =
        runBlocking {
            fakeRepository.getCharactersById(SAMPLE_IDS).test {
                assertThat(awaitItem()).isInstanceOf(NetworkResponseState.Loading::class.java)
                cancelAndIgnoreRemainingEvents()
            }
        }

    @Test
    fun `when get character response failure is state downloading and failure sequentially`() =
        runBlocking {
            fakeRepository.setRequest(TestResponseEnum.ERROR)
            fakeRepository.getCharactersById(SAMPLE_IDS).test {
                assertThat(awaitItem()).isInstanceOf(NetworkResponseState.Loading::class.java)
                assertThat(awaitItem()).isInstanceOf(NetworkResponseState.Error::class.java)
                awaitComplete()
            }
        }

    @Test
    fun `when get character response success is state downloading and success sequentially`() =
        runBlocking {
            fakeRepository.setRequest(TestResponseEnum.SUCCESS)
            fakeRepository.getCharactersById(SAMPLE_IDS).test {
                assertThat(awaitItem()).isInstanceOf(NetworkResponseState.Loading::class.java)
                assertThat(awaitItem()).isInstanceOf(NetworkResponseState.Success::class.java)
                awaitComplete()
            }
        }


}