# 1. Concurrent programlama ve Parallel Programlama nedir ? Aralarında çalışma şekli olarak nasıl bir fark bulunmaktadır ?


*   Paralel programlama nedir ?

    * Çok basit bir ifadeyle, bir sorunu çözmek için birden çok kaynağın, bu durumda işlemcilerin kullanılmasıdır. Bu tür bir programlama bir sorunu alır, bir dizi küçük adıma böler ve işlemciler aynı anda çözümleri uygular.

*   Concurrent programlama nedir ?

    * Bir uygulama birden fazla şeyi aynı anda yapabiliyorsa buna concurrent uygulama denir. Concurrency kavramı aynı anda birden fazla işlem yapabilme yeteneğini ifade eder.java'da ise bu işlem java.util.concurrent paketi ile kullanılır.



<img src="https://miro.medium.com/max/600/1*Z08NN_yk-sG9LfKKK3jmMw.jpeg" alt="Örnek Resim" width = "500"/>


# 2. Mutex ve Semaphore kavramlarını açıklayınız. Hangi tür durumlarda bunlara başvurmamız gerekir ?

* Mutex 

    * Ortak kaynak kullanımından kaynaklanan sorunları çözmek için mutexlerden faydalanılır. Bir thread, başka threadlerin de kullanabildiği bir kaynağa erişmeye çalıştığında, mutex değişkenini ayarlar. Bu atama işlemci tarafından kesinlikle kesilmez; yani thread mutexi tam yazacakken işletim sistemi sırayı başka bir threade vermez. Böylece mutex ile korunan bölgeye erişmeye çalışan tüm threadler, orayı kullanan thread işini tamamlayana kadar bekletilir. Thread işini bitirdiğinde alanı serbest bıraktığını bildirmek için mutexi tekrar ayarlar. Her sırası geldiğinde bu alana girmeye çalışan threadlerden ilk sırası gelen tekrar bölgeye girer ve mutex ile bölgeyi tekrar kilitler.

* Semafor

    * Semaforların amacı mutexlerin amacı ile aynıdır. Semaforlar mutexlerden farklı olarak birden fazla threadin aynı bölgeye girmesine izin verebilir. Mutexler semaforların iki durumlu özel halleri olarak düşünülebilir. Mutexler korudukları bölgeye sadece 1 threadin girmesine izin verirken, semaforlar korumalı bölgeye giren thread sayısını belli bir değerle sınırlamak için kullanılır.

* Hangi durumda kullanılması gerekmektedir ?

    * Bir semaforun doğru kullanımı, bir görevden diğerine sinyal vermek içindir. Bir muteks, koruduğu paylaşılan kaynağı kullanan her görev tarafından her zaman bu sırayla alınıp serbest bırakılmak içindir. Buna karşılık, semaforları kullanan görevler ya sinyal verir ya da bekler 


# 3. Java’da Error ve Exception arasındaki fark nedir ? Throwable ile ilişkileri nasıldır ? Hangi tür durumlarda Error hangi tür durumlarda Exception meydana gelebilir ? Örneklerler açıklayınız.

* Error ve Exception arasında ki fark 

    * Error :OutOfMemoryError gibi hande edilemeyen hatalardır. Fakat exception tipindeki hataları try-catch ile handle edebiliriz.

* Throwable ile ilişkileri nasıldır ?
    
    * Error throwable değildir. Çünkü runtime da meydana gelir ve jvm çöker. Exception ise throwable edilebilir. Kendisi handle etmek istemiyorsa bir üst parent classa bu exceptionu throw eder. 

* Hangi tür durumlarda Error hangi tür durumlarda Exception meydana gelebilir ?

    * VirtualMachineError : JVM’nin çalışmasını etkileyen durumları inceler.

    * AWTError : Grafik arayüze ait hataları inceler.

    * OutOfMemoryError : Bellek yetersizliği durumlarını inceler.

    * ClassNotFoundException : Olmayan bir dosyaya erişme istediği durumlarını inceler.

    * IOException : Giriş çıkış işlemlerindeki istenmeyen durumları inceler.

    * AritmeticException : Aritmetik hataları inceler.

    * NullPointerException : Herhangi bir nesneye null referanslı bir değişken ile ulaşılmaya çalışılan durumlarda fırlatılır.

    * IllegalArgumentException : Metotlara geçersiz argüman atamalarında fırlatılır.

# 4. Spring’te yer alan @Scheduled anotasyonunun kullanım amaçlarını ve kullanım şeklini açıklayınız.

* Kullanım amacı 

    * Periyodik olarak yapmak istediğimiz metodlarımız olduğu zaman @Scheduled anatasyonunu kullanırız.

* Kullanım şekli

    *  Periyodik olarak yapmak istediğimiz metodun başına @ Scheduled anotasyonunu eklememiz yeterli olur. Uygulamamıza @ EnableScheduling anotasyonunu ekleriz. Zamanlamak istediğimiz metoda da @ Scheduled anotasyonunu ekleriz. 
    

Burada 3 tip Schedule bulunmakta. Bunlar:

    * fixedDelay : Sabit gecikme süresi ile, taskımız bir önceki taskın bitiminden sonra belirlediğimiz süre kadar bekler. Yani ‘fixedDelay=5000’ dediğimizde önceki taskın bitiminden 5 saniye sonra yeni task başlar. Tasklar arasında 5 saniye olduğundan emin oluruz.
    * fixedRate: Sabit belirlenen süre ile, taskın gerçekleşeceği zaman bir önceki taskın başladığı zamandan hesaplanır. Yani ‘fixedRate=5000’ dediğimizde önceki task başladıktan sonra 5 saniye içerisinde bu task gerçekleşecek demektir.
    * cron: Aynı Linux’da bulunan cron yapısını burada da kullanabiliriz. Basit bir cron expression ile işlemlerimizi istediğimiz belli bir periyoda zamanlayabiliriz.

# 5. Spring’te yer alan @Async anotasyonunun kullanım amaçlarını ve kullanım şeklini açıklayınız.

* Kullanım amaçları 

    *  Bir bean’in methoduna @Async annotationu eklemek onun main thread’den farklı olarak ayrı bir threadde çalıştırılmasını sağlar. Yani call edilen methodun tamamlanmasını call eden kısım beklemez. Kod böylece async olarak çalışmış olur.

* Kullanım şekli

    * 1 - Enable Async Support -> Asynchronous process’leri, Java configuration’ı ile enable etmeliyiz(@EnableAsync). @EnableAsync annotationu @Async annotationuna sahip methodları arayacak ve bu methodları background thread pool’larında çalışacaktır.

    * 2 - @Async annotationu Async yapmak istediğimiz method üzerine eklemek.
 

# 6. High Availability (HA) kavramını kısa açıklayınız.

*Günümüzün kritik öneme sahip uygulamalarını çalıştıran 7×24 ortamlarda, işletmeler büyük ölçüde verilerinin kullanılabilirliğine / erişilebilirliğine güveniyor. Sunucular ve yazılımları genellikle güvenilir olsa da, her biri bir sunucuyu çökertebilecek bir donanım arızası veya yazılım hatası riski her zaman vardır. Bu riskleri azaltmak için iş açısından kritik uygulamalar, hata toleransı sağlamak için genellikle yedek donanıma güvenir. Birincil sistem başarısız olursa, uygulama otomatik olarak yedek sisteme yük devredebilir. Bu, yüksek erişilebilirliğin (HA – High Availability) altında yatan ilkedir.*


# 7. Entity ve Value Object kavramlarını Domain Driven Design (DDD) kapsamında açıklayınız.

* Entitiy & Value Object

    * Kendine ait unique bir kimliği olan nesneler Entity olarak adlandırılırken, kendine ait bir kimliği olmayanlar ise value object olarak adlandırılıyor.

    * Entityler domainimiz içerisindeki bir kavrama denk gelirler. DDD nesne yönelimli programlamaya sımsıkı bağlıdır. İş mantığımızı servislere değil bütünüyle entitylere yığmamızı öneriyor. Kısaca sınıflarımızı, veritabanımızdaki bir tabloya karşılık gelecek şekilde değil, iş mantığımızı oturtacağımız yapıda, bir başka deyişle entitylere logic ekleyerek oluşturmalıyız.


# 8. Ubiquitous Language kavramını DDD kapsamında açıklayınız. Sizce neden önemli olabileceğini belirtiniz.

* İstenilen çıktıyı üretebilmemiz ve bu çıktının sürekliliğini sağlayabilmemiz için Domain Expert’ ler ile aynı dili konuşacak seviyeye gelmemiz gerekiyor. Sonrasında da edindiğimiz bu tecrübeyi uygulamalarımızı geliştirirken kullandığımız method ve sınıflara expertin kullandığı kavramların isimlerini vererek aktarmamız gerekiyor. Projemizde kullanacağımız her servisin domainde bir karşılığı olması gerekiyor. Böylelikle projede yer alan herkes bu ortak dili konuşabilir birbirini anlayabilir oluyor.


# 9. Core Domain, Supporting Domain, Generic Domain kavramlarını DDD kapsamında açıklayınız.

*Bir organizasyona özel ve diğer organizsasyonlardan farklı kılan şey çekirdek alan adıdır. (core domain) Bir organizsayon, core domnainde olağanüstü derecede iyi olmadan başarılı olamaz (hatta var olamaz). Core domain çok önemli olduğu için, en yüksek önceliği, en büyük çabayı ve en iyi geliştiricileri alması gerekir. Daha küçük alanlar için yalnızca tek bir core domain tanımlayabilirsiniz, daha büyük alanların birden fazla alanı olabilir. Core domain'in özelliklerini sıfırdan oluşturmaya hazırlıklı olmalısınız.*

*Destekleyen bir alt alan  (Supporting Subdomains), kuruluşun başarılı olması için gerekli olan, ancak core domain kategorisine girmeyen bir alt alan adıdır. Genel değildir çünkü söz konusu organizasyon için hala bir miktar uzmanlaşma gerektirir. Mevcut bir çözümle başlayabilir ve onu ince ayarlayabilir veya özel ihtiyaçlarınıza göre genişletebilirsiniz.*

*Genel bir alt alan adı  (Generic Subdomains), kuruluşa özel herhangi bir şey içermeyen ancak yine de genel çözümün çalışması için gerekli olan bir alt alan adıdır. Genel alt alan adlarınız için hazır yazılımları kullanmaya çalışarak zamandan ve işten tasarruf edebilirsiniz. Tipik bir örnek, kullanıcı kimliği yönetimi olabilir.*


# 10. Anemic Domain Model ve Rich Domain Model kavramlarını kıyaslayarak açıklayınız.

* Anemic Domain Model
Anemik model, herhangi bir mantık içermeyen bir etki alanı modelidir. Bu nedenle modele anemik denir. Yalnızca istemciler tarafından değiştirilebilen ve yorumlanabilen veriler için bir kapsayıcıdır. Bu nedenle, tüm mantık, anemik bir modelde etki alanı nesnelerinin dışına yerleştirilir. 

Anemik etki alanı modellerini kullanırken, verileri değiştirme ve yorumlama mantığı başka bir yere yerleştirilmelidir. Çoğu zaman mantık Service, Util, Helper veya Manager adlı sınıflara yerleştirilir . Sanırım adlandırma, kulağa daha tuhaf gelen ve güncel olana bağlı. Servis odaklı mimariler günceldir ve bu nedenle sınıflar genellikle Service olarak adlandırılır . Ancak bu sınıfların genellikle hizmet odaklı bir mimarideki hizmetlerle ortak hiçbir yanı yoktur.


* Rich Domain Model

Anemik alan modelinin aksine Rich Domain Model, nesne yönelimli ilkeleri takip eder. Bu nedenle, rich bir etki alanı modeli gerçekten nesne yönelimli programlamadır.

Rich bir etki alanı modelinin veya nesne yönelimli programlamanın amacı, verileri ve mantığı bir araya getirmektir. 

Nesne yönelimli şu anlama gelir: bir nesne kendi durumunu yönetir ve herhangi bir zamanda legal bir durumda olduğunu garanti eder.

Nesne yönelimli programlamanın avantajı, bir nesnenin herhangi bir zamanda legal bir durumda olduğunu ve artık hiçbir “Hizmet” sınıfına ihtiyaç olmadığını garanti edebilmesidir. Bir test vakası, “ anemi modelleri herhangi bir zamanda legal bir durumda olduklarını garanti edemez ” kaynağındaki
farkı gösterecektir .