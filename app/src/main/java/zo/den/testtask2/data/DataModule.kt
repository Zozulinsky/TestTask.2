package zo.den.testtask2.data

import dagger.Module

@Module(includes = [NetworkModule::class, DataBinder::class])
class DataModule {
}