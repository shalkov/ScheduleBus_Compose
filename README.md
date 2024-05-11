### Android Compose Application (расписание автобусных маршрутов)

Это Android приложение, которое позволяет отображать расписание автобусных маршрутов.
Работае в связки с этим бекендом: https://github.com/shalkov/KtorServer_ScheduleBus

Технологие используемые при реализации этого приложения:
1. Многомодульность. Архитектура основана на принципах [Clean Architecture](https://fernandocejas.com/2018/05/07/architecting-android-reloaded/). Выделены три основных модуля: **data**, **domain** и **feature**.
2. Слой представления(feature), реализует MVVM паттерн, рекомендуемый Google.
3. Для вёрстки UI, используется [JetPack Compose](https://developer.android.com/develop/ui/compose).
4. Библиотека для работы с сетью [Ktor Client](https://ktor.io/docs/client-create-new-application.html).
5. Для асинхронных операций, используются [Kotlin Coroutines](https://kotlinlang.org/docs/coroutines-overview.html).
6. Для реализации паттерна DI, используется библиотека [Hilt](https://developer.android.com/training/dependency-injection/hilt-android).
7. Для навигации используется [Navigation Component](https://developer.android.com/develop/ui/compose/navigation), который Google рекомендует использовать совместно с Compose.