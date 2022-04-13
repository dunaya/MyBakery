# MyBakery
Это проект по предмету Java в МФТИ, апрель-май 2022
Проект представляет собой клиентско-серверное приложение онлайн-кондитерской(пекарни), в которой заказчики могут найти кондитера для исполнения своих требований, а кондитеры - найти заказы, которые можно взять.
В серверной части 4 модели: клиент(Client), пекарь(Baker), администратор системы(Admin), общая модель всех юзеров системы(GeneralModel), в которой сохраняется только id и тип юзера, чтобы можно было их узнавать. Типы юзеров: пекарь, клиент, админ. К каждой модели серверной части прописаны DTO и репозитории. Прописаны Mvc и Swagger конфигурации. 
TODO (и to report, разумеется): контроллеры, конфигурция Web, Security, скорее всего, нужно будет поменять какие-нибудь поля в моделях и дто.
