
# ModularAndroid
An Android test project to implement Modular approach to build structure

### Create modules

1. Create a module
2. If the module has any Dagger, implement it into main module also.
3. The env file is in gradle.properties:
	- Eg : apiUrl=http://github.com/
   - Implement those into the module by

   ```gradle
   //Get env from gradle properties
    def API_URL = System.getenv("API_URL") ?: apiUrl

    android.buildTypes.each { type ->
        type.buildConfigField "String", "API_URL", "\"$API_URL\""
    }
    ```
   where API_URL is the key in gradle.properties.

4.  Build the module.
5. Include the module into main module's gradle:
```gradle
        dependencies{
    		implementation project(':moduleName')
    	}
```
7. For Dagger DI, you'll need to add a Module class that impliments all the dagger module classes like Singleton, Providers into one class. Like so:
```kotlin
        @Module
        class SomeClass{
            @Provides
            @Singleton
            fun provideUrl():String{
                return BuildConfig.URL
            }
        }
```

### Implementing Module
1. After creating and implementing modules into main module.
2. For Dagger, you'll need to add those DaggerModule class into the **AppComponent.kt** class of the main module.
```java
        @Singleton
        @Component(modules = [(AndroidInjectionModule::class), (AppModule::class),(NetworkModule::class), (ActivityBuilder::class), (ViewModelFactoryModules::class)])
        interface AppComponent {

        @Component.Builder
        interface Builder{
            @BindsInstance
            fun application(application: Application): Builder

            fun build(): AppComponent

        }
        fun inject(app: ModularAndroidApplication)
}
```
