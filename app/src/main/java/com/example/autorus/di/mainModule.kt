package com.example.autorus.di
import com.example.autorus.data.api.PartsApi
import com.example.autorus.data.network.NetworkClient
import com.example.autorus.data.network.RetrofitNetworkClient
import com.example.autorus.data.part.Impl.PartsRepositoryImpl
import com.example.autorus.data.part.PartsRepository
import com.example.autorus.domain.part.PartsInteractor
import com.example.autorus.domain.part.impl.PartsInteractorImpl
import com.example.autorus.ui.part.view_model.PartViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val mainModule = module {
    single<PartsRepository> { PartsRepositoryImpl(get()) }
    single<NetworkClient> { RetrofitNetworkClient(get()) }
    single<PartsInteractor> { PartsInteractorImpl(get()) }
    single<PartsApi> {
        Retrofit.Builder()
            .baseUrl("https://193.39.160.82:7001")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(PartsApi::class.java)
    }

    viewModel { PartViewModel(get()) }
}
